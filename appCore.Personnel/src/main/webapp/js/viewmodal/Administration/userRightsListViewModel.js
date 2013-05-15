var UserRightsListViewModel = function (initView, data, globalViewModel) {

    var mode = initView;
    this.codeCommand = "#codeCommand";
    this.gridId = "gridBranch";
    this.data = data;
    self.gridData = ko.observableArray(data);
    self.globalViewModel = globalViewModel;

    var viewColumns = [
        { headerText:"User name", rowText:"username" }
    ];

    function getView() {
        var gridDataObject =
        {
            "data":this.data
        };

        switch (mode) {
            case 0:
                var addUserLinkInfo = {
                    "text":"Add Users",
                    "commandId":'userAdd',
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

                gridDataObject.addLinkInfo = [];
                gridDataObject.addLinkInfo.push(addUserLinkInfo);
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
            var result = helper.deleteUser(data, successDeleteCallback);
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
        preparePageForLoading(globalAdminHostPath + "usersAdd.jsp");
    }

    function goToAdd() {
        globalViewModel.applicationScopeType(coreApplicationTypeUnit);
        globalViewModel.editMode(coreModeInsert);
        preparePageForLoading(globalAdminHostPath + "usersAdd.jsp");
    }

    self.initializeViewModel();
}