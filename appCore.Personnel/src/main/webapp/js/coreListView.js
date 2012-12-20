var CoreListView = function () {

    this.createListView = function (targetDiv, dataSource, templateId, renderPager) {

        var targetListView = "listView";

        if (dataSource != null) {

            if (targetDiv != null) {
                $(" <div id='" + targetDiv + "listView'></div>").appendTo("#" + targetDiv);

                if (renderPager == undefined) {
                    $("<div id='" + targetDiv + "pager' class='k-pager-wrap'></div>").appendTo("#" + targetDiv);
                }
                targetListView = targetDiv + "listView";

            }
            else {

                $(" <div id='listView'></div>").appendTo("body");
                $("<div id='pager' class='k-pager-wrap'></div>").appendTo("body");
            }

            var coredata = new CoreDataSourceHelper();
            var ds = coredata.getDataSource(dataSource);

            var listView = $("#" + targetListView).kendoListView({
                dataSource:ds,
                template:kendo.template($("#" + templateId).html())
            });

            if (renderPager == undefined) {
                $("#" + targetDiv + "pager").kendoPager({
                    dataSource:ds
                });
            }
        }
    }
}