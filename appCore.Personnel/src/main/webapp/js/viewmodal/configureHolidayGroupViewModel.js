var HolidayGroupChangeInfo = function (groupId, employeeId, IsMember) {

    var self = this;
    self.employeeGroupId = ko.observable(groupId);
    self.employeeId = ko.observable(employeeId);
    self.isMember = ko.observable(IsMember);
}

var employeeGroupData = [];

var ConfigureHolidayGroupViewModel = function (globalViewModel) {

    var self = this;
    // all the employee from a selected company
    self.allEmployeeInCompanyList = ko.observableArray();
    // all the employee assigned to a group
    self.allEmployeeGroupList = ko.observableArray();

    // Work list
    self.employeeNotInGroupList = ko.observableArray();
    self.employeesCurrentlyAssignedToAGroup = ko.observableArray();

    self.currentlySelectedGroup = ko.observable();
    self.selectionOfEmployee = ko.observableArray();

    self.employeeGroupChangeList = ko.observableArray();

    self.selectionOfEmployeeToRemove = ko.observableArray();

    self.mode = ko.observable(coreModeInsert);
    self.enableAdd = ko.observable();
    self.enableUpdate = ko.observable();
    self.enableDelete = ko.observable();

    self.globalViewModel = globalViewModel;

    //if (self.globalViewModel.applicationScopeType() != coreApplicationTypeUnit) {
    //    throw "Application Type is not of type holidayGroup.";
    //}

    globalViewModel.companyId.subscribe(function (newValue) {
        getData(newValue);
    });


    self.remokeFromGroup = function (data) {

    }


    function getData(value) {
        var helper = new CompanyHelper();
        var entityObject = { id:value };

        helper.getHolidayGroups(entityObject, getHolidayGroupCallback);
        helper.getHolidays(entityObject, getAllEmployeeCallback);
    }

    function getAllEmployeeCallback(data) {
        self.allEmployeeInCompanyList(data);
    }

    function getHolidayGroupCallback(data) {
        self.allEmployeeGroupList(data);

        $.each(data, function (key, value) {
            employeeGroupData[value.name] = value.holidays;
        });
    }

    self.mode(self.globalViewModel.editMode());

    // get permission
    initializeApplication();

    function initializeApplication() {

        var input = { "id":coreUnitPage, "roleId":self.globalViewModel.employeeRole() };
        var coreCommand = new CoreCommand();
        var moduleResult = coreCommand.getPermission(hostAuthorizationUrl, input);
        var result = moduleResult.permission;

        var helper = new EmployeeHelper();

        self.enableAdd(helper.getEnableAdd(result));
        self.enableUpdate(helper.getEnableUpdate(result));
        self.enableDelete(helper.getEnableDelete(result));

        getData(self.globalViewModel.companyId());

    }

    function getEntityGetDataCallback(data) {

        if (data != null) {

            self.nid(data.nid);
            self.code(data.unitCode);
            self.name(data.unitName);
            self.description(data.remark);
            self.disabled(data.disabled);

            for (var i = 0; i < data.unitInfo.length; i++) {
                self.listInfo.push(new InfoDataViewModel(data.unitInfo[i]));
            }
        }
    }

    self.editData = ko.observable();

    self.cancelInfoData = function () {
        self.editData("");
    }


    self.editInfoData = function (data) {

        self.infoCategory = data.infoCategory;
        self.infoDescription = data.infoDescription;
        self.infoType = data.infoType;
        self.infoValue = data.infoValue;
        self.editData(data);
    }

    self.deleteInfoData = function (data) {
        var dialog = new CoreDialog();
        var helper = new EmployeeHelper();
        var dialogObject = helper.createDialogObject("Delete record", "Do you want to remove this record?");
        var result = dialog.createConfirmationDialog(dialogObject, data, globalViewModel, self.codeType, deleteInfoConfirmCallBack);
    }

    self.closeAddControl = function () {
        $("#accordianUnit").accordion({collapsible:true, active:false});
    }

    self.updateInfoData = function (data) {

        var entityData = createUpdateEntityData(data);
        var helper = new CompanyHelper();
        helper.saveOrUpdateUnitInfo(entityData, updateDataSuccessCallback);
        self.editData("");
    }

    function createUpdateEntityData(data) {

        var entityData = {
            category:data.infoCategory(),
            description:data.infoDescription(),
            type:data.infoType(),
            value:data.infoValue(),
            refEntity:self.nid()
        };
        if (data.nid() != null)
            entityData.nid = data.nid();

        return entityData;
    }

    self.addInfo = function (data) {
        var entityInfoData = createEntityData();
        var helper = new CompanyHelper();
        helper.saveOrUpdateUnitInfo(entityInfoData, addDataSuccessCallback);
    }

    function createEntityData() {

        var entityData = {
            category:self.addInfoCategory(),
            description:self.addInfoDescription(),
            type:self.addInfoType(),
            value:self.addInfoValue(),
            refEntity:self.nid()
        };
        return entityData;
    }

    function updateDataSuccessCallback(result) {

    }

    function addDataSuccessCallback(result) {

        if (result.messageCode != null) {
            var data = {
                category:self.addInfoCategory(),
                description:self.addInfoDescription(),
                type:self.addInfoType(),
                value:self.addInfoValue()
            };

            if (result.saveCode != null)
                data.nid = result.saveCode;

            var addItem = new InfoDataViewModel(data);
            self.listInfo.push(addItem);
            self.addInfoCategory("");
            self.addInfoDescription("");
            self.addInfoType("");
            self.addInfoValue("");
        }

    }

    self.addInfoData = function () {

        var data = {
            category:self.addInfoCategory(),
            description:self.addInfoDescription(),
            type:self.addInfoType(),
            value:self.addInfoValue()
        };

        var addItem = new InfoDataViewModel(data);

        self.listInfo.push(addItem);
        self.addInfoCategory("");
        self.addInfoDescription("");
        self.addInfoType("");
        self.addInfoValue("");
    }


    self.templateToUse = function (item) {
        switch (self.mode()) {
            case 1:
            case 2:
                return "companyEntityAddTemplate";
            default:
                return "companyEntityAddTemplate";
        }
        return "companyEntityAddTemplate";

    }.bind(this);


    self.infoTemplateToUse = function (item) {
        if (item === self.editData())
            return "infoUpdateTemplate";

        return "infoViewTemplate";
    }.bind(this);


    function deleteInfoConfirmCallBack(userResponse, data, globalViewModel, codeType) {

        if (userResponse == true) {
            var helper = new CompanyHelper();
            var entityData = { id:data.nid() };
            var result = helper.deleteUnitInfo(entityData, data, deleteCompleteCallback);
        }
    }

    function deleteCompleteCallback(result, data) {

        if (result.messageCode == 0) {
            self.listInfo.remove(data);
        }
    }

    self.updateData = function (data) {
        var list = self.employeeGroupChangeList();
        var helper = new CompanyHelper();
        for (var i = 0; i < list.length; i++) {
            var item = list[i];
            var entityObject = {
                holidayId:item.employeeId(),
                id:item.employeeGroupId(),
                isGrantAccess:item.isMember()
            };
            helper.configureHolidayGroup(entityObject, updateCompleteCallBack);
        }
    }

    function updateCompleteCallBack(data) {
    }

    self.cancelUpdate = function (data) {
        preparePageForLoading("personnelSummaryWidget.jsp");
    }

    self.assignToGroup = function (data) {
        var selection = self.selectionOfEmployee();
        var emp = null;

        var groupName = self.currentlySelectedGroup();
        var assignedEmployees = employeeGroupData[groupName];

        for (var i = 0; i < selection.length; i++) {
            var employeeId = selection[i];

            var employeeList = self.allEmployeeInCompanyList();
            for (var j = 0; j < employeeList.length; j++) {
                emp = employeeList[j];
                if (emp.nid == employeeId) {
                    removeItemFromList(self.employeeNotInGroupList, employeeId);
                    break;
                }
            }
            self.employeesCurrentlyAssignedToAGroup.push(emp);
            lookupChangesToPropagateToServer(groupName, employeeId, true);
        }
        self.selectionOfEmployee = ko.observableArray();
    }


    function removeItemFromListIfExistByGroupAndId(list, groupId, employeeId) {

        for (var i = 0; i < list.length; i++) {
            var item = list[i];
            if (item.employeeGroupId() == groupId && item.employeeId() == employeeId) {
                list.splice(i, 1);
                break;
            }
        }
        self.employeeGroupChangeList(list);
        return list;
    }

    function removeItemFromList(list, value) {
        var itemList = list();
        for (var j = 0; j < itemList.length; j++) {
            var item = itemList[j];
            if (item.nid == value) {
                list.splice(j, 1);
                break;
            }
        }
    }

    function getGroupId(groupName) {
        var groupList = self.allEmployeeGroupList();

        for (var i = 0; i < groupList.length; i++) {
            if (groupList[i].name == groupName) {
                return groupList[i].nid;
            }
        }
        return null;
    }


    self.removeFromGroup = function (data) {

        var selection = self.selectionOfEmployeeToRemove();
        var emp = null;

        for (var i = 0; i < selection.length; i++) {
            var employeeId = selection[i];
            var employeeList = self.allEmployeeInCompanyList();
            for (var j = 0; j < employeeList.length; j++) {
                emp = employeeList[j];
                if (emp.nid == employeeId) {
                    removeItemFromList(self.employeesCurrentlyAssignedToAGroup, employeeId);
                    break;
                }
            }

            self.employeeNotInGroupList.push(emp);
            lookupChangesToPropagateToServer(self.currentlySelectedGroup(), employeeId, false);
        }

        self.selectionOfEmployeeToRemove = ko.observableArray();
    }

    function lookupChangesToPropagateToServer(groupName, employeeId, boolValueToSet) {

        var recordModifiedIndicator = true;
        var groupId = getGroupId(groupName);

        if (boolValueToSet) {

            if (checkIfReassignment(employeeId, groupName)) {
                recordModifiedIndicator = false;
                removeItemFromListIfExistByGroupAndId(self.employeeGroupChangeList(), groupId, employeeId);
            }
        }
        else if (boolValueToSet == false) {

            if (isRevokeAccess(employeeId, groupName)) {
                recordModifiedIndicator = true;
            }
            else {
                recordModifiedIndicator = false;
                removeItemFromListIfExistByGroupAndId(self.employeeGroupChangeList(), groupId, employeeId);
            }
        }

        if (recordModifiedIndicator == true) {
            removeItemFromListIfExistByGroupAndId(self.employeeGroupChangeList(), groupId, employeeId);
            var employeeGroupInfo = new HolidayGroupChangeInfo(groupId, employeeId, boolValueToSet);
            self.employeeGroupChangeList.push(employeeGroupInfo);
        }
    }


    function isRevokeAccess(employeeId, groupName) {

        var isDoubleRevokeRecord = false;
        var staticAssignedDataFromServer = employeeGroupData[groupName];

        for (var i = 0; i < staticAssignedDataFromServer.length; i++) {
            if (staticAssignedDataFromServer[i].nid == employeeId) {
                isDoubleRevokeRecord = true;
                break;
            }
        }
        return isDoubleRevokeRecord;
    }

    function checkIfReassignment(employeeId, groupName) {
        var isRecordAnReassignment = false;
        var staticAssignedDataFromServer = employeeGroupData[groupName];
        for (var i = 0; i < staticAssignedDataFromServer.length; i++) {
            if (staticAssignedDataFromServer[i].nid == employeeId) {
                isRecordAnReassignment = true;
            }
        }
        return isRecordAnReassignment;
    }

    self.groupSelectionChanged = function (data) {

    }

    self.currentlySelectedGroup.subscribe(function (groupName) {

        self.employeeNotInGroupList.removeAll();
        self.employeeGroupChangeList.removeAll();

        if (groupName != undefined) {
            var assignedEmployees = employeeGroupData[groupName];
            var newList = assignedEmployees.slice();
            self.employeesCurrentlyAssignedToAGroup(newList);

            if (assignedEmployees != undefined) {
                var newList = self.allEmployeeInCompanyList.slice();

                for (var i = 0; i < assignedEmployees.length; i++) {
                    for (var k = 0; k < newList.length; k++) {
                        if (newList[k].name == assignedEmployees[i].name) {
                            newList.splice(k, 1);  // remove the list
                        }
                    }
                }
                if (newList.length > 0) {
                    self.employeeNotInGroupList(newList);
                }
            }
            else {

            }
        }
    });
}