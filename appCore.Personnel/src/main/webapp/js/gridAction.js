(function () {

    function isFunction(possibleFunction) {
        return (typeof(possibleFunction) == typeof(Function));
    }

    ko.gridAction = {
        ViewModel:function (configuration) {

            var self = this;
            this.enableAdd = ko.observable(false);
            this.enableSelect = ko.observable(false);
            this.enableDelete = ko.observable(false);
            this.enablePrint = ko.observable(false);
            this.enableExport = ko.observable(false);

            this.exportSelected = function ()
            {
            };
            this.printSelected = function () {
            };
            this.goToAdd = function () {
            };
            this.deleteSelected = function () {
            };
            this.selectAll = function () {
            };

            if (isFunction(configuration.exportSelected)) {
                this.exportSelected = configuration.exportSelected;
                this.enableExport = ko.observable(true);
            }

            if (isFunction(configuration.printSelected)) {
                this.printSelected = configuration.printSelected;
                this.enablePrint = ko.observable(true);
            }

            if (isFunction(configuration.goToAdd)) {
                this.goToAdd = configuration.goToAdd;
                this.enableAdd = ko.observable(true);
            }

            if (isFunction(configuration.deleteSelected)) {
                this.deleteSelected = configuration.deleteSelected;
                this.enableDelete = ko.observable(true);
            }

            if (isFunction(configuration.selectAll)) {
                this.selectAll = configuration.selectAll;
                this.enableSelect = ko.observable(true);
            }
        }
    };

    var templateEngine = new ko.nativeTemplateEngine();

    templateEngine.addTemplate = function (templateName, templateMarkup) {
        document.write("<script type='text/html' id='" + templateName + "'>" + templateMarkup + "<" + "/script>");
    };

    templateEngine.addTemplate("ko_grid_action", "\
                    <div class=\"commandMenuDiv\">\
                    <li class=\"dropdown\">\
                        <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">Actions..<b class=\"caret\"></b></a>\
                            <ul class=\"dropdown-menu\">\
                                <li><a href=\"#\" data-bind=\"click : goToAdd, visible : $data.enableAdd\">Add</a></li>\
                                <li><a href=\"#\" data-bind=\"click : selectAll, visible : $data.enableSelect\">Select all</a></li>\
                                <li><a href=\"#\" data-bind=\"click : deleteSelected, visible : $data.enableDelete\">Delete</a></li>\
                                <li><a href=\"#\" data-bind=\"click : printSelected, visible : $data.enablePrint\">Print</a></li>\
                                <li><a href=\"#\" data-bind=\"click : exportSelected, visible : $data.enableExport\">Export</a></li>\
                            </ul>\
                    </li>\
                    </div>\
    ");

    ko.bindingHandlers.actionGrid = {
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
            var gridActionTemplateName = allBindings.simpleGridTemplate || "ko_grid_action";

            // Render the main grid
            var gridContainer = element.appendChild(document.createElement("DIV"));
            ko.renderTemplate(gridActionTemplateName, viewModel, { templateEngine:templateEngine }, gridContainer, "replaceNode");
        }
    };
})();

