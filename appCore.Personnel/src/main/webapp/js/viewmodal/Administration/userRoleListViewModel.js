var UserRoleListViewModel = function (initView, data, globalViewModel) {

    var mode = initView;
    this.gridUrl = globalHostname + "/app/Core/Branch";
    this.codeCommand = "#codeCommand";
    this.gridId = "gridBranch";
    this.data = data;

    var self = this;
    self.gridData = ko.observableArray(data);
    self.globalViewModel = globalViewModel;

    var viewColumns = [
        { headerText:"Role", rowText:"rolename" }
    ];

    function getView() {

        var gridDataObject =
        {
            "gridUrl":this.gridUrl,
            "data":this.data
        };

        switch (mode) {
            case 0:
                var addUserLinkInfo = {
                    "text":"Add Role",
                    "commandId":'roleAdd',
                    "link":globalPersonnelControlPanel,
                    "ctrlId":"addUserBtn",
                    "callback":function () {
                        goToAdd()
                    }
                };

                var updateLinkInfo = {
                    "text":"Update",
                    "link":this.editPage
                };

                gridDataObject.gridData = self.gridData;
                gridDataObject.viewColumns = viewColumns;
                gridDataObject.updateFunction = updateFunction;
                gridDataObject.deleteFunction = deleteFunction;
                gridDataObject.controlId = this.gridId;

                gridDataObject.updateLinkInfo = updateLinkInfo;
                gridDataObject.addLinkInfo = addUserLinkInfo;
                return gridDataObject;
        }
        return gridDataObject;
    }

    self.initializeViewModel = function () {
        var gridDataObject = getView();
        var input = { "id":coreDivisionPage, "roleId":globalViewModel.employeeRole() };
        var coreCommand = new CoreCommand();

        var gridViewModel = coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);
        self.gridViewModel = gridViewModel;
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
            var result = helper.deleteRole(data, successDeleteCallback);
        }
    }

    function successDeleteCallback(result, data) {
        if (result.messageCode == 0) {
            self.gridData.remove(data);
        }
    }

    function updateFunction(data) {
        globalViewModel.targetId(data.nid);
        globalViewModel.editMode(coreModeEdit);
        globalViewModel.applicationScopeType(coreApplicationTypeUnit);
        preparePageForLoading(globalAdminHostPath + "userRoleAdd.jsp");
    }

    function goToAdd() {
        globalViewModel.applicationScopeType(coreApplicationTypeUnit);
        globalViewModel.editMode(coreModeInsert);
        preparePageForLoading(globalAdminHostPath + "userRoleAdd.jsp");
    }

    self.initializeViewModel();
}