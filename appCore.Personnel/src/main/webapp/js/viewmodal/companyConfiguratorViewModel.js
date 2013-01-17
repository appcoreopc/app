var treeDivControlName = "entityTree";
var branchNodeType = 2;
var divisionNodeType = 3;
var companyNodeType = 1;
var departmentNodeType = 4;
var sectionNodeType = 5;
var unitNodeType = 6;

var TreeNodeObject = function (title, dataId, nodeDataType) {
    var self = this;
    self.node = {
        "data":title,
        "metadata":{ id:dataId, nodeType:nodeDataType },
        "children":[]
    };

    self.appendChild = function (nodeObject) {
        self.node.children.push(nodeObject);
    }
}

var CompanyConfiguratorViewModel = function (globalViewModel) {

    var self = this;

    self.currentNodeType = ko.observable();

    self.branchCreate = ko.observable();
    self.branchRemove = ko.observable();

    self.divisionCreate = ko.observable();
    self.divisionRemove = ko.observable();

    self.departmentCreate = ko.observable();
    self.departmentRemove = ko.observable();

    self.sectionCreate = ko.observable();
    self.sectionRemove = ko.observable();

    self.unitCreate = ko.observable();
    self.unitRemove = ko.observable();


    // all the employee from a selected company
    self.allUsersList = ko.observableArray();
    // all the employee assigned to a group
    self.allRolesList = ko.observableArray();

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
        helper.getEmployeeGroups(entityObject, getEmployeeGroupCallback);
        helper.getEmployees(entityObject, getAllEmployeeCallback);
    }

    function getAllEmployeeCallback(data) {
        self.allUsersList(data);
    }

    function getEmployeeGroupCallback(data) {
        self.allRolesList(data);
        $.each(data, function (key, value) {
            employeeGroupData[value.name] = value.assignedEmployees;
        });
    }

    self.mode(self.globalViewModel.editMode());

    // get permission
    initializeApplication();

    function initializeApplication() {

        var c1 = new TreeNodeObject("CompanyA", 0, companyNodeType);
        var b1 = new TreeNodeObject("Branch Company A", 1, branchNodeType);
        var b2 = new TreeNodeObject("Branch Company A", 2, branchNodeType);

        var div1 = new TreeNodeObject("Division", 1, divisionNodeType);
        b1.appendChild(div1.node);

        c1.appendChild(b1.node);
        c1.appendChild(b2.node);

        var c2 = new TreeNodeObject("CompanyB", 0, companyNodeType);
        var d1 = new TreeNodeObject("Branch Company B", 1, branchNodeType);
        var d2 = new TreeNodeObject("Branch Company B", 2, branchNodeType);

        c2.appendChild(d1.node);
        c2.appendChild(d2.node);

        var companyNode = new TreeNodeObject("CompanyC", 0, companyNodeType);
        var cbranch = new TreeNodeObject("Branch Company C-1", 1, branchNodeType);
        var cbranch2 = new TreeNodeObject("Branch Company C-2", 2, branchNodeType);

        companyNode.appendChild(cbranch.node);
        companyNode.appendChild(cbranch2.node);


        var jstree = $("#" + treeDivControlName).jstree({
            "json_data":{
                "data":[
                    c1.node, c2.node, companyNode.node
                ]
            },
            "plugins":[ "themes", "json_data", "ui", "checkbox", "crrm", "contextmenu" ]
        }).bind("select_node.jstree", function (e, data) {
                // alert(data.rslt.obj.data("id") +  ":" + data.rslt.obj.data("nodeType"));
            });
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

    self.createBranch = function () {
        var selectedNode = $('#' + treeDivControlName).jstree('get_selected');
        var parents = $("#" + treeDivControlName).jstree("get_path", selectedNode);
        var newNode = new TreeNodeObject("Branch Company C", 3, branchNodeType);

        var nodeType = selectedNode.data("nodeType");
        if (nodeType == companyNodeType) {
            $("#" + treeDivControlName).jstree("create", selectedNode, "inside", newNode.node);
        }
        else {
            createInLevel(selectedNode, parents.length, newNode);
        }
    }

    self.createDepartment = function () {

        var selectedNode = $('#' + treeDivControlName).jstree('get_selected');
        var parents = $("#" + treeDivControlName).jstree("get_path", selectedNode);
        var newNode = new TreeNodeObject("Department", 0, departmentNodeType);

        var nodeType = selectedNode.data("nodeType");

        if (nodeType < departmentNodeType) {
            var levelToTraverse = departmentNodeType - nodeType;
            console.log("dept" + levelToTraverse);
            tryToCreateChild(selectedNode, levelToTraverse, newNode);
        }
        else {
            createInLevel(selectedNode, parents.length - 1, newNode);
        }
    }


    self.createDivision = function () {
        var selectedNode = $('#' + treeDivControlName).jstree('get_selected');
        var parents = $("#" + treeDivControlName).jstree("get_path", selectedNode);
        var newNode = new TreeNodeObject("Division", 0, divisionNodeType);
        var nodeType = selectedNode.data("nodeType");

        if (nodeType < divisionNodeType) {
            var levelToTraverse = divisionNodeType - nodeType;
            tryToCreateChild(selectedNode, levelToTraverse, newNode);
        }
        else {
            createInLevel(selectedNode, parents.length - 1, newNode);
        }
    }

    self.createSection = function () {
        var selectedNode = $('#' + treeDivControlName).jstree('get_selected');
        var parents = $("#" + treeDivControlName).jstree("get_path", selectedNode);
        var newNode = new TreeNodeObject("Section", 0, sectionNodeType);

        var nodeType = selectedNode.data("nodeType");

        if (nodeType < sectionNodeType) {
            var levelToTraverse = sectionNodeType - nodeType;
            console.log("dept" + levelToTraverse);
            tryToCreateChild(selectedNode, levelToTraverse, newNode);
        }
        else {
            createInLevel(selectedNode, parents.length - 1, newNode);
        }
    }

    self.createUnit = function () {
        var selectedNode = $('#' + treeDivControlName).jstree('get_selected');
        var parents = $("#" + treeDivControlName).jstree("get_path", selectedNode);
        var newNode = new TreeNodeObject("Unit", 0, unitNodeType);

        var nodeType = selectedNode.data("nodeType");
        if (nodeType < unitNodeType) {
            var levelToTraverse = unitNodeType - nodeType;
            console.log("dept" + levelToTraverse);
            tryToCreateChild(selectedNode, levelToTraverse, newNode);
        }
        else {
            createInLevel(selectedNode, parents.length - 1, newNode);
        }
    }

    self.deleteNode = function () {
        $("#" + treeDivControlName).jstree("remove", null);
    }

    var treeInstance = $.jstree._reference($("#" + treeDivControlName));

    function tryToCreateChild(selectedNode, levelToTraverse, createNode) {
        console.log("level to traverse:" + levelToTraverse);
        if (levelToTraverse > 1) {
            var child = treeInstance._get_children(selectedNode);

            if (child != undefined && child.length > 0) {
                tryToCreateChild(child, --levelToTraverse, createNode);
            }

        }
        else {
            $("#" + treeDivControlName).jstree("create", selectedNode, "inside", createNode.node);
        }
    }

    function createInLevel(node, level, createNode) {
        console.log(node.data('nodeType'));
        console.log(level);

        if (level > 0) {
            var targetNodePath = node.parent();
            createInLevel(targetNodePath, --level, createNode)
        }
        else if (level == 0) {
            $("#" + treeDivControlName).jstree("create", node, "last", createNode.node);
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
        //alert('cancel update');
        preparePageForLoading("personnelControlPanel.jsp");
    }

    self.assignToGroup = function (data) {
        var selection = self.selectionOfModule();
        var emp = null;

        var groupName = self.currentlySelectedGroup();
        var assignedEmployees = employeeGroupData[groupName];

        for (var i = 0; i < selection.length; i++) {
            var employeeId = selection[i];

            var employeeList = self.allUsersList();
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
            var employeeList = self.allUsersList();
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

        var groupId = getGroupId(groupName);
        removeItemFromListIfExistByGroupAndId(self.employeeGroupChangeList(), groupId, employeeId);
        var employeeGroupInfo = new EmployeeGroupChangeInfo(groupId, employeeId, boolValueToSet);
        self.employeeGroupChangeList.push(employeeGroupInfo);
    }


    self.groupSelectionChanged = function (data) {

    }

    function saveOrUpdateStatus(result) {
        if (result.messageCode == 0) {
            preparePageForLoading("unit.jsp");
        }
    }


    self.currentlySelectedGroup.subscribe(function (groupName) {

        self.moduleNotInGroupList.removeAll();

        var assignedEmployees = employeeGroupData[groupName];

        self.rightsCurrentlyAssignedToAGroup(assignedEmployees);

        if (assignedEmployees != undefined) {
            var newList = self.allUsersList.slice();

            for (var i = 0; i < assignedEmployees.length; i++) {
                for (var k = 0; k < newList.length; k++) {
                    if (newList[k].name == assignedEmployees[i].name) {
                        newList.splice(k, 1);  // remove the list
                    }
                }
            }

            if (newList.length > 0) {
                self.moduleNotInGroupList(newList);
            }
            //pushDataToComboBox(targetControlId, assignedEmployees);
        }
        else {
            // appendAvailableHolidayDataToComboBox(allHolidays, targetControlId);
        }
    });

    function getSelectedNode() {
        var selectedNodeType = $('#' + treeDivControlName).jstree('get_selected').data('nodeType');
        var selectedNodeId = $('#' + treeDivControlName).jstree('get_selected').data('id');
        return selectedNodeType;
    }

}