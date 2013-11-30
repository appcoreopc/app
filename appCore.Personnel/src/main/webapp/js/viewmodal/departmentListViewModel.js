var DepartmentListViewModel = function (initView, data, globalViewModel, command) {

    var self = this;
    self.mode = initView;
    self.coreCommand = command;

    self.enableAdd = false;
    self.enableUpdate = ko.observable(true);
    self.enableAdd = ko.observable(true);
    self.enableDelete = ko.observable(true);
    self.enableSelect = ko.observable(true);

    self.globalViewModel = globalViewModel;
    self.gridViewModel;

    self.gridActionViewModel;

    var viewColumns = [
        { headerText:"Department Code", rowText:"departmentCode" },
        { headerText:"Department Name", rowText:"departmentName" },
        { headerText:"Description", rowText:"description" },
        { headerText:"Disabled", rowText:"disabled" }
    ];


    function getView() {

        self.gridViewModel = new ko.dataGrid.ViewModel({
            data:ko.observableArray(data),
            columns:viewColumns,
            pageSize:10,
            enableUpdate:self.enableUpdate,
            enableAdd:self.enableAdd,
            enableDelete:self.enableDelete,
            enableSelect:self.enableSelect,
            deleteData:deleteFunction,
            updateData:updateFunction
        });

        self.gridActionViewModel = new ko.gridAction.ViewModel({
            goToAdd : self.goToAdd
        });


    }

    self.renderView = function () {
        var gridDataObject = getView();
        var input = { "id":coreDivisionPage, "roleId":globalViewModel.employeeRole() };
        $.when(self.coreCommand.getAppPermission(hostAuthorizationUrl, input)).done(function (authorizationResponse) {
            var helper = new EmployeeHelper();
            var permissionColumnName = globalPermissionColumnName;
            self.gridViewModel.enableAdd(helper.getEnableAdd(authorizationResponse[permissionColumnName]));
            self.gridViewModel.enableUpdate(helper.getEnableUpdate(authorizationResponse[permissionColumnName]));
            self.gridViewModel.enableDelete(helper.getEnableDelete(authorizationResponse[permissionColumnName]));
        });
    }

    function deleteFunction(data) {
        var dialog = new CoreDialog();
        var helper = new EmployeeHelper();
        var dialogObject = helper.createDialogObject("Delete record", "Do you want to remove this record?");
        var result = dialog.createConfirmationDialog(dialogObject, data, globalViewModel, null, deleteCallBack);
    }

    function deleteCallBack(status, data, globalViewModel, codeType) {
        if (status == true) {
            var helper = new CompanyHelper();
            var result = helper.deleteDepartment(data, successDeleteCallback);
        }
    }

    function successDeleteCallback(result, data) {
        if (result.messageCode == 0) {
            self.gridViewModel.data.remove(data);
        }
    }

    function updateFunction(data) {
        globalViewModel.targetId(data.nid);
        globalViewModel.editMode(coreModeEdit);
        globalViewModel.applicationScopeType(coreApplicationTypeDepartment);
        preparePageForLoading("departmentAdd.jsp");
    }

    self.selectAll = function (data) {
        for (var i = 0; i < self.gridViewModel.data().length; i++) {
            if (self.gridViewModel.data()[i].isSelected != undefined) {
                self.gridViewModel.data()[i].isSelected(true);
            }
        }
    }

    self.deleteSelected = function (data) {
        if (self.enableSelect != false) {
            var dialog = new CoreDialog();
            var helper = new EmployeeHelper();
            var dialogObject = helper.createDialogObject("Delete record", "Do you want to remove selected record?");
            var result = dialog.createConfirmationDialog(dialogObject, data, globalViewModel, null, deleteSelectedCallBack);
        }
    }

    function deleteSelectedCallBack(status, data, globalViewModel, codeType) {
        if (status == true) {

            var helper = new CompanyHelper();
            var dataValue = data.gridViewModel.data();
            var arrayToRemove = helper.getSelectedItemGrid(dataValue);

            // perform actual delete //
            for (var j = 0; j < arrayToRemove.length; j++) {
                var deleteElement = arrayToRemove[j]['nid'];
                for (var k = 0; k < self.gridViewModel.data().length; k++) {
                    if (self.gridViewModel.data()[k].nid == deleteElement) {
                        self.gridViewModel.data.splice(k, 1);
                        var result = helper.deleteDepartmentSelected(arrayToRemove[j]);
                    }
                }
            }
        }
    }

    function successDeleteSelectedCallback(result, data) {
        if (result.messageCode == 0) {
            self.gridViewModel.data.remove(data);
            deleteSelectedCallBack(true, self, globalViewModel, null);
        }
    }

    self.goToAdd = function () {
        globalViewModel.applicationScopeType(coreApplicationTypeDepartment);
        globalViewModel.editMode(coreModeInsert);
        preparePageForLoading("departmentAdd.jsp");
    }
}