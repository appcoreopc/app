var treeDivControlName = "entityTree";
var companyNodeType = 1;
//var branchNodeType = 2;
var divisionNodeType = 2;
var departmentNodeType = 3;
var sectionNodeType = 4;
var unitNodeType = 5;

var TreeNodeObject = function (title, dataId, nodeDataType, description, name, disabledState) {
    var self = this;
    self.node = {
        "data":title,
        "metadata":{
            id:dataId,
            nodeType:nodeDataType,
            parentId:-1,
            nodeCode:title,
            nodeDescription:description,
            nodename:name,
            disabled:disabledState
        },
        "children":[]
    };
    self.appendChild = function (nodeObject) {
        self.node.children.push(nodeObject);
    }
}

var TreeNodeData = function (parentId, id, nodeType, title, description, name, disabledState) {

    this.parentId = parentId;
    this.id = id;
    this.nodeType = nodeType;
    this.title = title;
    this.description = description;
    this.name = name;
    this.disabled = disabledState;
}

var TreeNodeInfo = function () {
    this.parentId;
    this.treeNode;
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

    self.newlyCreatedNode = ko.observable();


    self.nodeCode = ko.observable();
    self.nodeType = ko.observable();
    self.parentId = ko.observable();
    self.nodeId = ko.observable();

    self.nodeDescription = ko.observable();
    self.nodeName = ko.observable();
    self.disabled = ko.observable(false);


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

    self.mode = ko.observable(companyNodeType);
    self.enableAdd = ko.observable();
    self.enableUpdate = ko.observable();
    self.enableDelete = ko.observable();
    self.globalViewModel = globalViewModel;

    var jstree;

    //if (self.globalViewModel.applicationScopeType() != coreApplicationTypeUnit) {
    //    throw "Application Type is not of type holidayGroup.";
    //}

    globalViewModel.companyId.subscribe(function (newValue) {
        getData(newValue);
    });

    self.removeFromGroup = function (data) {
    }

    function getData(value) {
        var helper = new CompanyHelper();
        var entityObject = { id:value };
        helper.getCompanyAllInfo(entityObject, getAllCompanyInfoCallback);
    }

    var treeData = [];

    function getAllCompanyInfoCallback(data) {
        for (var i = 0; i < data.length; i++) {
            var companyTreeNode = new TreeNodeObject(data[i]["companyName"], data[i]["nid"], companyNodeType);
            getDivisionData("divisionCode", "nid", divisionNodeType, data[i].divisionList, companyTreeNode, "description", "divisionName", "disabled");
            treeData.push(companyTreeNode.node);
        }
        // setup the tree //
        jstree = $("#" + treeDivControlName).jstree({
            "json_data":{
                "data":treeData
            },
            "plugins":[ "themes", "json_data", "ui", "checkbox", "crrm", "contextmenu" ]
        }).bind("select_node.jstree", function (e, data) {
                getSelectedNodeParent();
            });
    }

    function getDivisionData(fieldName, fieldNid, nodeType, list, parentNode, description, name, disabledState) {
        for (var j = 0; j < list.length; j++) {
            var treeNode = new TreeNodeObject(list[j][fieldName], list[j][fieldNid], nodeType, list[j][description], list[j][name], list[j][disabledState]);
            if (list[j].departmentList != undefined && list[j].departmentList.length > 0) {
                getDepartmentData("departmentCode", "nid", departmentNodeType, list[j].departmentList, treeNode, "description", "departmentName", "disabled");
            }
            parentNode.appendChild(treeNode.node);
        }
    }

    function getDepartmentData(fieldName, fieldNid, nodeType, list, parentNode, description, name, disabledState) {
        for (var j = 0; j < list.length; j++) {
            var treeNode = new TreeNodeObject(list[j][fieldName], list[j][fieldNid], nodeType, list[j][description], list[j][name], list[j][disabledState]);
            if (list[j].section != undefined && list[j].section.length > 0) {
                getSectionData("sectionCode", "nid", sectionNodeType, list[j].section, treeNode, "remark", "sectionName", "disabled");
            }
            parentNode.appendChild(treeNode.node);
        }
    }

    function getSectionData(fieldName, fieldNid, nodeType, list, parentNode, description, name, disabledState) {
        for (var j = 0; j < list.length; j++) {
            var treeNode = new TreeNodeObject(list[j][fieldName], list[j][fieldNid], nodeType, list[j][description], list[j][name], list[j][disabledState]);
            if (list[j].unitList != undefined && list[j].unitList.length > 0) {
                getUnitData("unitCode", "nid", unitNodeType, list[j].unitList, treeNode, "remark", "unitName", "disabled");
            }
            parentNode.appendChild(treeNode.node);
        }
    }

    function getUnitData(fieldName, fieldNid, nodeType, list, parentNode, description, name, disabledState) {
        for (var j = 0; j < list.length; j++) {
            var treeNode = new TreeNodeObject(list[j][fieldName], list[j][fieldNid], nodeType, list[j][description], list[j][name], list[j][disabledState]);
            parentNode.appendChild(treeNode.node);
        }
    }

    function getNodeData(fieldName, fieldNid, nodeType, list, parentNode) {
        for (var j = 0; j < list.length; j++) {
            var treeNode = new TreeNodeObject(list[j][fieldName], list[j][fieldNid], nodeType);
            parentNode.appendChild(treeNode.node);
        }
    }

    function traverseDivision(data) {
        var company = new TreeNodeObject(data[i]["companyName"], 0, companyNodeType);
    }

    self.mode(self.globalViewModel.editMode());

    // get permission
    initializeApplication();

    function initializeApplication() {
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

    /*
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
     */

    self.createDivision = function () {
        var selectedNode = $('#' + treeDivControlName).jstree('get_selected');
        var parents = $("#" + treeDivControlName).jstree("get_path", selectedNode);
        var newNode = new TreeNodeObject("Division", 0, divisionNodeType);
        var nodeType = selectedNode.data("nodeType");

        if (nodeType == undefined) // nothing currently selected
            return;

        if (nodeType == companyNodeType) {
            $("#" + treeDivControlName).jstree("create", selectedNode, "inside", newNode.node);
        }
        else {
            createInLevel(selectedNode, parents.length - 1, newNode);
        }
    }

    self.createDepartment = function () {

        var selectedNode = $('#' + treeDivControlName).jstree('get_selected');
        var parents = $("#" + treeDivControlName).jstree("get_path", selectedNode);
        var newNode = new TreeNodeObject("Department", 0, departmentNodeType);

        var nodeType = selectedNode.data("nodeType");

        if (nodeType == undefined) // nothing currently selected
            return;

        if (nodeType < departmentNodeType) {
            var levelToTraverse = departmentNodeType - nodeType;
            console.log("dept" + levelToTraverse);
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
        if (nodeType == undefined) // nothing currently selected
            return;

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

        if (nodeType == undefined) // nothing currently selected
            return;

        if (nodeType < unitNodeType) {
            var levelToTraverse = unitNodeType - nodeType;
            console.log("dept" + levelToTraverse);
            tryToCreateChild(selectedNode, levelToTraverse, newNode);
        }
        else {
            createInLevel(selectedNode, parents.length - 1, newNode);
        }
    }

    self.saveDivision = function (data) {

        var division = new Division();
        if (self.nodeId() > 0)
            division.nid = self.nodeId();

        division.companyId = self.globalViewModel.companyId();
        division.divisionCode = self.nodeCode();
        division.divisionName = self.nodeName();
        division.description = self.nodeDescription();
        division.disabled = self.disabled();

        var helper = new CompanyHelper();
        helper.saveUpdateDivision(division, saveOrUpdateStatus);
    }

    function saveOrUpdateStatus(result) {
        if (result.messageCode == 0) {
            // preparePageForLoading("branch.jsp");
        }
    }

    self.saveDepartment = function (data) {
        var division = new Department();
        if (self.nodeId() > 0)
            division.nid = self.nodeId();

        division.companyId = self.globalViewModel.companyId();
        division.departmentCode = self.nodeCode();
        division.divisionId = self.parentId();
        division.departmentName = self.nodeName();
        division.description = self.nodeDescription();
        division.disabled = self.disabled();

        var helper = new CompanyHelper();
        helper.saveUpdateDepartment(division, saveOrUpdateStatus);
    }


    self.saveSection = function (data) {
        var section = new Section();
        if (self.nodeId() > 0)
            section.nid = self.nodeId();

        section.companyId = self.globalViewModel.companyId();
        section.sectionCode = self.nodeCode();
        section.departmentId = self.parentId();
        section.sectionName = self.nodeName();
        section.remark = self.nodeDescription();
        section.disabled = self.disabled();

        var helper = new CompanyHelper();
        helper.saveUpdateSection(section, saveOrUpdateStatus);
    }


    self.saveUnit = function (data) {
        var unit = new Unit();
        if (self.nodeId() > 0)
            unit.nid = self.nodeId();

        unit.companyId = self.globalViewModel.companyId();
        unit.unitCode = self.nodeCode();
        unit.sectionId = self.parentId();
        unit.unitName = self.nodeName();
        unit.remark = self.nodeDescription();
        unit.disabled = self.disabled();

        var helper = new CompanyHelper();
        helper.saveUpdateUnit(unit, saveOrUpdateStatus);
    }


    self.deleteNode = function () {
        $("#" + treeDivControlName).jstree("remove", null);
    }

    var treeInstance = $.jstree._reference($("#" + treeDivControlName));

    function tryToCreateChild(selectedNode, levelToTraverse, createNode) {
        var treeInstance = $.jstree._reference($("#" + treeDivControlName));

        if (levelToTraverse > 1) {
            var child = treeInstance._get_children(selectedNode);
            if (child != undefined && child.length > 0) {
                tryToCreateChild(child, --levelToTraverse, createNode);
            }
        }
        else {
            $("#" + treeDivControlName).jstree("create", selectedNode, "inside", createNode.node);
            var treeInstance = $.jstree._reference($("#" + treeDivControlName));

            var parentId = selectedNode.data("nodeType");
            var nodeData = new TreeNodeData(parentId, createNode.node.metadata.id,
                createNode.node.metadata.nodeType, createNode.node.metadata.nodeCode);
            self.newlyCreatedNode(nodeData);
        }
    }

    function createInLevel(node, level, createNode) {
        if (level > 0) {
            var targetNodePath = node.parent();
            createInLevel(targetNodePath, --level, createNode)
        }
        else if (level == 0) {
            $("#" + treeDivControlName).jstree("create", node, "last", createNode.node);
            var parentId = node.data("nodeType");
            var nodeData = new TreeNodeData(parentId, createNode.node.metadata.id,
                createNode.node.metadata.nodeType, createNode.node.metadata.nodeCode);
            self.newlyCreatedNode(nodeData);
            self.newlyCreatedNode(createNode.node);
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
                return "emptyTemplate";
            case divisionNodeType:
                return "divisionInfoUpdateTemplate";
            case departmentNodeType:
                return "departmentInfoUpdateTemplate";
            case sectionNodeType:
                return "sectionInfoUpdateTemplate";
            case unitNodeType:
                return "unitInfoUpdateTemplate";
            default:
                return "emptyTemplate";
        }
        return "emptyTemplate";
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
        preparePageForLoading("personnelControlPanel.jsp");
    }

    self.newlyCreatedNode.subscribe(function (node) {

        self.nodeCode(node.title);
        self.nodeType(node.nodeType);
        self.parentId(node.parentId);
        self.nodeId(node.id);

        self.nodeDescription(node.description);
        self.nodeName(node.name);
        self.disabled(node.disabled);

        switch (node.nodeType) {
            case 2:
                self.mode(divisionNodeType);
                break;
            case 3:
                self.mode(departmentNodeType);
                break;
            case 4:
                self.mode(sectionNodeType);
                break;
            case 5:
                self.mode(unitNodeType);
                break;
        }
    });

    function getSelectedNodeParent() {

        var selectedNode = $('#' + treeDivControlName).jstree('get_selected');
        var treeInstance = $.jstree._reference($("#" + treeDivControlName));
        var parent = treeInstance._get_parent(selectedNode);

        if (parent != -1) {

            var parentId = parent.data("id");
            var id = selectedNode.data("id");
            var title = selectedNode.data("nodeCode");
            var type = selectedNode.data("nodeType");

            var description = selectedNode.data("nodeDescription");
            var name = selectedNode.data("nodename");
            var disabledState = selectedNode.data("disabled");

            self.newlyCreatedNode(new TreeNodeData(parentId, id, type, title, description, name, disabledState));
        }
    }

    function getSelectedNode() {
        var selectedNodeType = $('#' + treeDivControlName).jstree('get_selected').data('nodeType');
        var selectedNodeId = $('#' + treeDivControlName).jstree('get_selected').data('id');
        return selectedNodeType;
    }

    function get_type(thing) {
        if (thing === null)return "[object Null]"; // special case
        return Object.prototype.toString.call(thing);
    }
}