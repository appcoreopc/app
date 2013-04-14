(function () {
    // Private function
    function getColumnsForScaffolding(data) {

        if ((typeof data.length !== 'number') || data.length === 0) {
            return [];
        }
        var columns = [];
        for (var propertyName in data[0]) {
            columns.push({ headerText:propertyName, rowText:propertyName });
        }
        return columns;
    }

    ko.dataGrid = {
        // Defines a view model class you can use to populate a grid
        ViewModel:function (configuration) {

            this.data = configuration.data;
            this.currentPageIndex = ko.observable(0);

            this.enableAdd = configuration.enableAdd;
            this.enableUpdate = configuration.enableUpdate;
            this.enableDelete = configuration.enableDelete;

            this.pageSize = configuration.pageSize || 5;

            if (configuration.updateData != undefined)
                this.updateData = configuration.updateData;

            if (configuration.deleteData != undefined)
                this.deleteData = configuration.deleteData;

            // If you don't specify columns configuration, we'll use scaffolding
            this.columns = configuration.columns || getColumnsForScaffolding(ko.utils.unwrapObservable(this.data));

            this.itemsOnCurrentPage = ko.computed(function () {
                var startIndex = this.pageSize * this.currentPageIndex();
                return this.data.slice(startIndex, startIndex + this.pageSize);
            }, this);

            this.maxPageIndex = ko.computed(function () {
                return Math.ceil(ko.utils.unwrapObservable(this.data).length / this.pageSize) - 1;
            }, this);
        }
    };

    // Templates used to render the grid
    var templateEngine = new ko.nativeTemplateEngine();

    templateEngine.addTemplate = function (templateName, templateMarkup) {
        document.write("<script type='text/html' id='" + templateName + "'>" + templateMarkup + "<" + "/script>");
    };

    templateEngine.addTemplate("ko_simpleGrid_grid", "\
                    <table class=\"ko-grid\" cellspacing=\"0\">\
                        <thead>\
                            <tr>\
                            <!-- ko foreach: columns-->\
                               <th data-bind=\"text: headerText\"></th>\
                             <!-- /ko -->\
                             <th data-bind=\"visible: $root.enableUpdate\">Update</th>\
                              <th data-bind=\"visible: $root.enableDelete\">Delete</th>\
                            </tr>\
                        </thead>\
                        <tbody data-bind=\"foreach: itemsOnCurrentPage\">\
                           <tr>\
                           <!-- ko foreach: $parent.columns-->\
                               <td data-bind=\"text: typeof rowText == 'function' ? rowText($parent) : $parent[rowText] \"></td>\
                           <!-- /ko -->\
                              <td data-bind=\"visible: $root.enableUpdate\"><a href='#' data-bind='click : $root.updateData'>Update</a> </td>\
                              <td data-bind=\"visible: $root.enableDelete\"><a href='#' data-bind=\"click : $root.deleteData\">Delete</a></td>\
                            </tr>\
                        </tbody>\
                    </table>");


    templateEngine.addTemplate("ko_simpleGrid_pageLinks", "\
                    <div class=\"ko-grid-pageLinks\">\
                        <span>Page:</span>\
                            <!-- ko foreach: ko.utils.range(0, maxPageIndex) -->\
                               <a href=\"#\" data-bind=\"text: $data + 1, click: function() { $root.currentPageIndex($data) }, css: { selected: $data == $root.currentPageIndex() }\">\
                            </a>\
                        <!-- /ko -->\
                    </div>");

    // The "simpleGrid" binding
    ko.bindingHandlers.dataGrid = {
        init:function () {
            return { 'controlsDescendantBindings':true };
        },
        // This method is called to initialize the node, and will also be called again if you change what the grid is bound to
        update:function (element, viewModelAccessor, allBindingsAccessor) {

            var viewModel = viewModelAccessor(), allBindings = allBindingsAccessor();

            // Empty the element
            while (element.firstChild)
                ko.removeNode(element.firstChild);

            // Allow the default templates to be overridden
            var gridTemplateName = allBindings.simpleGridTemplate || "ko_simpleGrid_grid",
                pageLinksTemplateName = allBindings.simpleGridPagerTemplate || "ko_simpleGrid_pageLinks";

            // Render the main grid
            var gridContainer = element.appendChild(document.createElement("DIV"));
            ko.renderTemplate(gridTemplateName, viewModel, { templateEngine:templateEngine }, gridContainer, "replaceNode");

            // Render the page links
            var pageLinksContainer = element.appendChild(document.createElement("DIV"));
            ko.renderTemplate(pageLinksTemplateName, viewModel, { templateEngine:templateEngine }, pageLinksContainer, "replaceNode");
        }
    };
})();

