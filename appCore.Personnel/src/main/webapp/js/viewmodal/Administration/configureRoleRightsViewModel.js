var GenericChangeSetInfo = function (groupId, targetId, IsMember, permission) {
    var self = this;
    self.groupId = ko.observable(groupId);
    self.targetId = ko.observable(targetId);
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

    self.targetGroupChangeSet = ko.observableArray();
    self.selectionToRemove = ko.observableArray();
    //self.selectionToRemove = [];

    self.mode = ko.observable(coreModeInsert);

    self.enableAdd = ko.observable();
    self.enableUpdate = ko.observable();
    self.enableDelete = ko.observable();

    self.globalViewModel = globalViewModel;

    self.addPermission = ko.observable(false);
    self.updatePermission = ko.observable(false);
    self.deletePermission = ko.observable(false);

    self.userConfigurePermission = ko.observableArray();

    function getData(value) {
        var helper = new UserHelper();
        var entityObject = { id:globalViewModel.companyId() };
        helper.getUserRoles(entityObject, getRolesRightsCallback); // obtain roles
        helper.getResourceList(entityObject, getModulesCallback);  // obtain forms/resource list
    }

    function getModulesCallback(data) {
        self.moduleListedInSystem(data);
    }

    function getRolesRightsCallback(data) {
        self.allRolesList(data);
        $.each(data, function (key, value) {
            rightsGroupData[value[groupFieldName]] = value.forms;
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

        getData(globalViewModel.companyId());
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
        var list = self.targetGroupChangeSet();

        var helper = new UserHelper();
        for (var i = 0; i < list.length; i++) {
            var item = list[i];
            var entityObject = {
                targetId:item.targetId(),
                groupId:item.groupId(),
                isGrantAccess:item.isMember(),
                permission:item.permission()
            };
            helper.configureRoleResource(entityObject, updateCompleteCallBack);
        }
    }

    function updateCompleteCallBack(data) {

    }

    self.cancelUpdate = function (data) {
        preparePageForLoading(globalEmptyMainPage);
    }

    self.assignToGroup = function (data) {

        var targetElement = null;
        var selection = self.selectionOfModule();
        var groupName = self.currentlySelectedGroup();
        var permission = null;

        for (var i = 0; i < selection.length; i++) {
            var selectedElementId = selection[i];
            var listedModules = self.moduleListedInSystem();

            for (var j = 0; j < listedModules.length; j++) {
                targetElement = listedModules[j];
                if (targetElement.nid == selectedElementId) {

                    if (targetElement.permission == undefined) {
                        permission = getPermissionFromInterface();
                    }
                    removeItemFromList(self.moduleNotInGroupList, selectedElementId);
                    break;
                }
            }
            var flattenElement = { "nid":targetElement.nid, "formName":targetElement.formId, "permission":permission };
            self.rightsCurrentlyAssignedToAGroup.push(flattenElement);
            lookupChangesToPropagateToServer(groupName, selectedElementId, true, permission);
        }
        self.selectionOfModule = ko.observableArray();
    }

    function getPermissionFromInterface() {
        var permission = null;
        if (self.addPermission())
            permission = "A";
        if (self.updatePermission())
            permission += "U";
        if (self.deletePermission())
            permission += "D";
        return permission;
    }


    function getPermissionFromConfiguredList(list, selectedElement) {
        for (var i = 0; i < list.length; i++) {
            var element = list[i];
            if (element.nid == selectedElement) {
                return element.permission;
            }
        }
        return undefined;
    }


    function removeItemFromListIfExistByGroupAndId(list, groupId, targetId) {
        for (var i = 0; i < list.length; i++) {
            var item = list[i];
            if (item.groupId() == groupId && item.targetId() == targetId) {
                list.splice(i, 1);
                break;
            }
        }
        self.targetGroupChangeSet(list);
        return list;
    }

    function removeItemFromList(list, value) {
        var itemList = list();
        for (var j = 0; j < itemList.length; j++) {
            var item = itemList[j];
            if (item.nid == value) {
                list.splice(j, 1);
                return itemList;
            }
        }
    }

    function getGroupId(groupName) {
        var groupList = self.allRolesList();
        for (var i = 0; i < groupList.length; i++) {
            if (groupList[i][groupFieldName] == groupName) {
                return groupList[i].nid;
            }
        }
        return null;
    }

    self.removeFromGroup = function (data) {
        var selection = self.selectionToRemove();
        var targetElement = null;
        for (var i = 0; i < selection.length; i++) {
            var selectedElementToRemove = selection[i];
            var list = self.rightsCurrentlyAssignedToAGroup();
            for (var j = 0; j < list.length; j++) {

                var itemElement = list[j];
                if (itemElement.nid == selectedElementToRemove) {
                    var elementToPass = itemElement;
                    self.moduleNotInGroupList.push(elementToPass);
                    self.rightsCurrentlyAssignedToAGroup.splice(j, 1);
                }
            }
            lookupChangesToPropagateToServer(self.currentlySelectedGroup(), selectedElementToRemove, false, itemElement.permission);

        }
        self.selectionToRemove = ko.observableArray();
    }

    function lookupChangesToPropagateToServer(groupName, targetId, boolValueToSet, permission) {
        var recordModifiedIndicator = true;
        var groupId = getGroupId(groupName);

        if (boolValueToSet) {
            if (checkIfReassignment(targetId, groupName)) {
                recordModifiedIndicator = false;
                removeItemFromListIfExistByGroupAndId(self.targetGroupChangeSet(), groupId, targetId);
            }
        }
        else if (boolValueToSet == false) {
            if (isRevokeAccess(targetId, groupName)) {
                recordModifiedIndicator = true;
            }
            else {
                recordModifiedIndicator = false;
                removeItemFromListIfExistByGroupAndId(self.targetGroupChangeSet(), groupId, targetId);
            }
        }

        if (recordModifiedIndicator == true) {
            removeItemFromListIfExistByGroupAndId(self.targetGroupChangeSet(), groupId, targetId);
            var employeeGroupInfo = new GenericChangeSetInfo(groupId, targetId, boolValueToSet, permission);
            self.targetGroupChangeSet.push(employeeGroupInfo);
        }
    }

    function checkIfReassignment(targetId, groupName) {
        var isRecordAnReassignment = false;
        var staticAssignedDataFromServer = rightsGroupData[groupName];
        for (var i = 0; i < staticAssignedDataFromServer.length; i++) {
            if (staticAssignedDataFromServer[i].nid == targetId) {
                isRecordAnReassignment = true;
            }
        }
        return isRecordAnReassignment;
    }

    function isRevokeAccess(targetId, groupName) {
        var isDoubleRevokeRecord = false;
        var staticAssignedDataFromServer = rightsGroupData[groupName];
        for (var i = 0; i < staticAssignedDataFromServer.length; i++) {
            if (staticAssignedDataFromServer[i].nid == targetId) {
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

    function flattenFormRightsToObservables(source) {
        var flattenData = [];
        for (var i = 0; i < source.length; i++) {
            var nid = source[i].nid;
            var formName = source[i].formId;
            var permission = source[i].permission;
            var flattenElement = new FormsRights(nid, formName, permission);
            flattenData.push(flattenElement);
        }
        return flattenData;
    }

    //self.nid = ko.observable(nid);
    //self.formName = ko.observable(formName);
    //self.permission = ko.observable(permission);

    function flattenObjects(source) {
        var flattenData = [];
        for (var i = 0; i < source.length; i++) {
            var nid = source[i].nid;
            var formName = source[i].formId;
            var permission = source[i].permission;
            var flattenElement = { "nid":nid, "formName":formName, "permission":permission};
            flattenData.push(flattenElement);
        }
        return flattenData;
    }

    self.currentlySelectedGroup.subscribe(function (groupName) {
        if (groupName != undefined) {
            self.moduleNotInGroupList.removeAll();
            self.targetGroupChangeSet.removeAll();
            var assignedRights = rightsGroupData[groupName];
            var clonedAssignedRights = assignedRights.slice();

            self.rightsCurrentlyAssignedToAGroup(flattenObjects(clonedAssignedRights));

            if (assignedRights != undefined) {
                var newList = self.moduleListedInSystem.slice();
                for (var i = 0; i < assignedRights.length; i++) {
                    for (var k = 0; k < newList.length; k++) {
                        if (newList[k]["nid"] == assignedRights[i]["nid"]) {
                            newList.splice(k, 1);  // remove the list
                        }
                    }
                }
                if (newList.length > 0) {
                    self.moduleNotInGroupList(flattenObjects(newList));
                }
            }
            else {
            }
        }
    });
}