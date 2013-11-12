var EmployeeHolidayListViewModel = function (initView, data, globalViewModel, command, entityList, entitlementList, earningLeaveList, replacementList) {

    var mode = initView;
    var self = this;
    self.gridUrl = globalHostname + "/app/Core/EmployeeHoliday";
    self.codeCommand = "#codeCommand";
    self.gridId = "gridEmployeeHoliday";
    self.data = data;
    self.gridData = ko.observableArray(data);
    self.globalViewModel = globalViewModel;
    self.coreCommand = command;
    self.entityList = ko.observableArray(entityList);
    self.entitlementList = ko.observableArray(entitlementList);
    self.earningLeaveList = ko.observableArray(earningLeaveList);
    self.replacementList = ko.observableArray(replacementList);

    var viewColumns = [

        { headerText:"Employee", rowText:function (data) {
            var i = getMatchingItem(self.entityList(), data, "employeeId", "nid")
            if (i != null)
                return i.name;
            else
                return "";
        } },

        { headerText:"Entitlement Type", rowText:function (data) {

            var i = getMatchingItem(self.entitlementList(), data, "holidayEntitlementType", "nid")
            if (i != null)
                return i.name;
            else
                return "";
        }
        },

        { headerText:"Leave Earning Scheme", rowText:function (data) {

            var i = getMatchingItem(self.earningLeaveList(), data, "leaveEarningScheme", "nid")
            if (i != null)
                return i.name;
            else
                return "";
        } },

        { headerText:"Leave Replacement Type", rowText:function (data) {

            var i = getMatchingItem(self.replacementList(), data, "holidayReplacementType", "nid")
            if (i != null)
                return i.name;
            else
                return "";
        }
        }
    ];

    function getMatchingItem(nativeList, data, sourceFieldName, requiredFieldName) {
        var i = ko.utils.arrayFirst(nativeList, function (item) {
            if (data[sourceFieldName] == item[requiredFieldName]) {
                return item;
            }
            else
                return null;
        });

        if (i != null)
            return i;
        else
            return null;
    }

    function getView() {
        var gridDataObject =
        {
            "gridUrl":this.gridUrl,
            "data":this.data
        };

        switch (mode) {
            case 0:
                var addLinkInfo = {
                    "text":"Configure New Employee Leave",
                    "commandId":'EmployeeHolidayAdd',
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
            var result = helper.deleteEmployeeHoliday(data, successDeleteCallback);
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
        globalViewModel.applicationScopeType(coreApplicationTypeEmployeeHolidayType);
        preparePageForLoading("employeeHolidayAdd.jsp");
    }

    function goToAdd() {
        globalViewModel.applicationScopeType(coreApplicationTypeEmployeeHolidayType);
        globalViewModel.editMode(coreModeInsert);
        preparePageForLoading("employeeHolidayAdd.jsp");
    }

    self.initializeViewModel();
}