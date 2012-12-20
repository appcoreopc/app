var CoreDataSourceHelper = function () {

    this.getDataSource = function (dataSource)
    {
        if (dataSource != null) {
            var ds = new kendo.data.DataSource({
                data:dataSource,
                pageSize:5
            });
            return ds;
        }
    }
}