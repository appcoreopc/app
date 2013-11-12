var HolidayReplacementTypeListViewModel = function (initView, data, globalViewModel, command) {

    mode = initView;
    var self = this;
    self.gridUrl = globalHostname + "/app/Core/HolidayReplacementType";
    self.codeCommand = "#codeCommand";
    self.gridId = "gridHolidayReplacementType";
    self.data = data;
    self.gridData = ko.observableArray(data);
    self.globalViewModel = globalViewModel;
    self.coreCommand = command;


    var viewColumns = [

        { headerText:"nid", rowText:"nid" },

        { headerText:"name", rowText:"name" },

        { headerText:"description", rowText:"description" },

        { headerText:"type", rowText:"type" },

        { headerText:"refId", rowText:"refId" },

        { headerText:"startEffectiveDate", rowText:"startEffectiveDate" },

        { headerText:"endEffectiveDate", rowText:"endEffectiveDate" },

        { headerText:"lastUpdate", rowText:"lastUpdate" }
    ];

    function getView() {
        var gridDataObject =
        {
            "gridUrl":this.gridUrl,
            "data":this.data
        };

        switch (mode) {
            case 0:
                var addLinkInfo = {
                    "text":"Add Leave Replacement Type",
                    "commandId":'HolidayReplacementTypeAdd',
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
                gridDataObject.addLinkInfo = addLinkInfo;
                gridDataObject.updateLinkInfo = updateLinkInfo;
                return gridDataObject;
        }
        return gridDataObject;
    }

    self.initializeViewModel = function () {
        var gridDataObject = getView();
        var input = { "id":coreBranchPage, "roleId":globalViewModel.employeeRole() };
        var gridViewModel = self.coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);
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
            var helper = new LeaveHelper();
            var result = helper.deleteHolidayReplacementType(data, successDeleteCallback);
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
        globalViewModel.applicationScopeType(coreApplicationTypeHolidayReplacementTypeType);
        preparePageForLoading("holidayReplacementTypeAdd.jsp");
    }

    function goToAdd() {
        globalViewModel.applicationScopeType(coreApplicationTypeHolidayReplacementTypeType);
        globalViewModel.editMode(coreModeInsert);
        preparePageForLoading("holidayReplacementTypeAdd.jsp");
    }

    self.initializeViewModel();
}