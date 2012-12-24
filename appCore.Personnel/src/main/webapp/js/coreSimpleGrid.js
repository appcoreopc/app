var CoreSimpleGrid = function () {

    this.createGrid = function (gridDataObjects) {

        if (gridDataObjects.viewColumns == undefined)
            return;

        var mode = gridDataObjects.mode;
        switch (mode) {
            case 0:
                return createReadOnlyGrid(gridDataObjects);
            case 1:
                return createEditEnabledOnlyGrid(gridDataObjects);
            case 2:
                return createEditModeOnlyGrid(gridDataObjects);
            case 3:
                return createDeleteOnlyGrid(gridDataObjects);
            case 4:
                return createAllFeatureGrid(gridDataObjects);
            case 5:
                return createInsertCommandGrid(gridDataObjects);
            case 6:
                return createEditCommandGrid(gridDataObjects);
            default:
                return createReadOnlyGrid(gridDataObjects);
        }
    }

    function createReadOnlyGrid(gridDataObjects) {
        return new ko.dataGrid.ViewModel({
            data:gridDataObjects.gridData,
            columns:gridDataObjects.viewColumns,
            pageSize:10,
            enableUpdate:ko.observable(false),
            enableAdd:ko.observable(false),
            enableDelete:ko.observable(false),
            deleteData:gridDataObjects.deleteFunction,
            updateData:gridDataObjects.updateFunction
        });
    }

    function createEditEnabledOnlyGrid(gridDataObjects) {
        return new ko.dataGrid.ViewModel({
            data:gridDataObjects.gridData,
            columns:gridDataObjects.viewColumns,
            pageSize:10,
            enableUpdate:ko.observable(true),
            enableAdd:ko.observable(true),
            enableDelete:ko.observable(false),
            deleteData:gridDataObjects.deleteFunction,
            updateData:gridDataObjects.updateFunction
        });
    }

    function createEditModeOnlyGrid(gridDataObjects) {
        return new ko.dataGrid.ViewModel({
            data:gridDataObjects.gridData,
            columns:gridDataObjects.viewColumns,
            pageSize:10,
            enableUpdate:ko.observable(true),
            enableAdd:ko.observable(true),
            enableDelete:ko.observable(false),
            deleteData:gridDataObjects.deleteFunction,
            updateData:gridDataObjects.updateFunction
        });
    }

    function createAllFeatureGrid(gridDataObjects) {

        var vm = new ko.dataGrid.ViewModel({
            columns:gridDataObjects.viewColumns,
            data: gridDataObjects.gridData,
            pageSize:10,
            enableUpdate:ko.observable(true),
            enableAdd:ko.observable(true),
            enableDelete:ko.observable(true),
            deleteData:gridDataObjects.deleteFunction,
            updateData:gridDataObjects.updateFunction
        });
        return vm;
    }

    function createDeleteOnlyGrid(gridDataObjects) {
        return new ko.dataGrid.ViewModel({
            data:gridDataObjects.gridData,
            columns:gridDataObjects.viewColumns,
            pageSize:10,
            enableUpdate:ko.observable(false),
            enableAdd:ko.observable(false),
            enableDelete:ko.observable(false),
            deleteData:gridDataObjects.deleteFunction,
            updateData:gridDataObjects.updateFunction
        });
    }

    function createInsertCommandGrid(gridDataObjects) {
        return new ko.dataGrid.ViewModel({
            data:gridDataObjects.gridData,
            columns:gridDataObjects.viewColumns,
            pageSize:10,
            enableUpdate:ko.observable(false),
            enableAdd:ko.observable(true),
            enableDelete:ko.observable(false),
            deleteData:gridDataObjects.deleteFunction,
            updateData:gridDataObjects.updateFunction
        });
    }

    function createEditCommandGrid(gridDataObjects) {
        return new ko.dataGrid.ViewModel({
            data:gridDataObjects.gridData,
            columns:gridDataObjects.viewColumns,
            pageSize:10,
            enableUpdate:ko.observable(true),
            enableAdd:ko.observable(false),
            enableDelete:ko.observable(false),
            deleteData:gridDataObjects.deleteFunction,
            updateData:gridDataObjects.updateFunction
        });
    }
}