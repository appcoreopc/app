var UserRoleRightChangeInfo = function (groupId, employeeId, IsMember, permission) {
    var self = this;
    self.employeeGroupId = ko.observable(groupId);
    self.employeeId = ko.observable(employeeId);
    self.isMember = ko.observable(IsMember);
    self.permission = ko.observable(permission);
}

var FormsRights = function (nid, formName, permission) {
    var self = this;
    self.nid = ko.observable(nid);
    self.formName = ko.observable(formName);
    self.permission = ko.observable(permission);

}

var rightsGroupData = [];

var ConfigureRoleRightsViewModel = function (globalViewModel) {

    var groupFieldName = "rolename";
    var elementFieldName = "username";

    var self = this;

    // all the roles
    self.allRolesList = ko.observableArray();
    // all modules
    self.moduleListedInSystem = ko.observableArray();

    // Work list
    self.moduleNotInGroupList = ko.observableArray();
    self.rightsCurrentlyAssignedToAGroup = ko.observableArray();
    self.currentlySelectedGroup = ko.observable();
    self.selectionOfModule = ko.observableArray();

    self.employeeGroupChangeList = ko.observableArray();
    self.selectionOfEmployeeToRemove = ko.observableArray();

    self.mode = ko.observable(coreModeInsert);

    self.enableAdd = ko.observable();
    self.enableUpdate = ko.observable();
    self.enableDelete = ko.observable();

    self.globalViewModel = globalViewModel;

    self.removeFromGroup = function (data) {

    }

    function getData() {
        var helper = new UserHelper();
        var entityObject = { id:0 };
        helper.getUserRoles(entityObject, getRolesRightsCallback); // obtain roles
        helper.getResourceList(entityObject, getModulesCallback);  // obtain forms list
    }

    function getModulesCallback(data) {
        self.moduleListedInSystem(data);
    }


    function getRolesRightsCallback(data) {
        self.allRolesList(data);
        $.each(data, function (key, value) {
            rightsGroupData[value[groupFieldName]] = value.assignedRights;
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

        getData();

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
        var helper = new UserHelper();
        for (var i = 0; i < list.length; i++) {
            var item = list[i];
            var entityObject = {
                employeeId:item.employeeId(),
                groupId:item.employeeGroupId(),
                isGrantAccess:item.isMember()
            };

            helper.configureUserRole(entityObject, updateCompleteCallBack);
        }
    }

    function updateCompleteCallBack(data) {

    }

    self.cancelUpdate = function (data) {
        preparePageForLoading(globalEmptyMainPage);
    }

    self.assignToGroup = function (data) {

        var selection = self.selectionOfModule();
        var emp = null;
        var groupName = self.currentlySelectedGroup();

        var assignedUsers = rightsGroupData[groupName];

        // base on selection // remove from main list
        for (var i = 0; i < selection.length; i++) {

            var employeeId = selection[i];

            var employeeList = self.moduleListedInSystem();

            for (var j = 0; j < employeeList.length; j++) {
                emp = employeeList[j];
                if (emp.nid == employeeId) {
                    removeItemFromList(self.moduleNotInGroupList, employeeId);
                    break;
                }
            }

            self.rightsCurrentlyAssignedToAGroup.push(emp);

            lookupChangesToPropagateToServer(groupName, employeeId, true);
        }

        self.selectionOfModule = ko.observableArray();
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
        var groupList = self.allRolesList();

        for (var i = 0; i < groupList.length; i++) {
            //if (groupList[i].name == groupName) {
            if (groupList[i][groupFieldName] == groupName) {
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
            var employeeList = self.moduleListedInSystem();
            for (var j = 0; j < employeeList.length; j++) {
                emp = employeeList[j];
                if (emp.nid == employeeId) {
                    removeItemFromList(self.rightsCurrentlyAssignedToAGroup, employeeId);
                    break;
                }
            }

            self.moduleNotInGroupList.push(emp);
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
            var employeeGroupInfo = new UserRoleRightChangeInfo(groupId, employeeId, boolValueToSet);
            self.employeeGroupChangeList.push(employeeGroupInfo);
        }
    }

    function checkIfReassignment(employeeId, groupName) {
        var isRecordAnReassignment = false;
        var staticAssignedDataFromServer = rightsGroupData[groupName];
        for (var i = 0; i < staticAssignedDataFromServer.length; i++) {
            if (staticAssignedDataFromServer[i].nid == employeeId) {
                isRecordAnReassignment = true;
            }
        }
        return isRecordAnReassignment;
    }

    function isRevokeAccess(employeeId, groupName) {
        var isDoubleRevokeRecord = false;
        var staticAssignedDataFromServer = rightsGroupData[groupName];
        for (var i = 0; i < staticAssignedDataFromServer.length; i++) {
            if (staticAssignedDataFromServer[i].nid == employeeId) {
                isDoubleRevokeRecord = true;
                break;
            }
        }
        return isDoubleRevokeRecord;
    }

    self.groupSelectionChanged = function (data) {

    }

    function saveOrUpdateStatus(result) {
        if (result.messageCode == 0) {
            preparePageForLoading("unit.jsp");
        }
    }

    function flattenFormRightsToObservables(clonedAssignedEmployees) {

        var flattenData = [];

        for (var i = 0; i < clonedAssignedEmployees.length; i++) {
            var formId = clonedAssignedEmployees[i].forms.nid;
            var formName = clonedAssignedEmployees[i].forms.formId;
            var permission = clonedAssignedEmployees[i].permission;

            var flattenElement = new FormsRights(formId, formName, permission);
            flattenData.push(flattenElement);
        }
        return flattenData;
    }

    self.currentlySelectedGroup.subscribe(function (groupName) {

        if (groupName != undefined) {

            self.moduleNotInGroupList.removeAll();
            self.employeeGroupChangeList.removeAll();

            var assignedRights = rightsGroupData[groupName];
            var clonedAssignedRights = assignedRights.slice();
            self.rightsCurrentlyAssignedToAGroup(flattenFormRightsToObservables(clonedAssignedRights));

            if (assignedRights != undefined) {
                var newList = self.moduleListedInSystem.slice();
                for (var i = 0; i < assignedRights.length; i++) {
                    for (var k = 0; k < newList.length; k++) {

                        if (newList[k]["nid"] == assignedRights[i]["forms"]["nid"]) {
                            newList.splice(k, 1);  // remove the list
                        }
                    }
                }
                if (newList.length > 0) {
                    self.moduleNotInGroupList(newList);
                }
            }
            else {

            }
        }
    });
}