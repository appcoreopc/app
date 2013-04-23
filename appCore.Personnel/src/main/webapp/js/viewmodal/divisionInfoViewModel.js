var DivisionInfoViewModel = function (globalViewModel) {

    var self = this;

    self.nid = ko.observable();
    self.code = ko.observable();
    self.name = ko.observable();
    self.description = ko.observable();
    self.disabled = ko.observable(false);

    self.infoCategory = ko.observable();
    self.infoDescription = ko.observable();
    self.infoType = ko.observable();
    self.infoValue = ko.observable();

    self.commandText = ko.observable("Add");

    self.addInfoCategory = ko.observable();
    self.addInfoDescription = ko.observable();
    self.addInfoType = ko.observable();
    self.addInfoValue = ko.observable();


    self.listInfo = ko.observableArray();

    self.mode = ko.observable(coreModeInsert);
    self.enableAdd = ko.observable();
    self.enableUpdate = ko.observable();
    self.enableDelete = ko.observable();

    self.globalViewModel = globalViewModel;
    self.errorInForm = ko.observable(false);
    self.showInfo = ko.observable(false);

    if (self.globalViewModel.applicationScopeType() != coreApplicationTypeDivision) {
        throw "Application Type is not division.";
    }

    self.mode(self.globalViewModel.editMode());

    // get permission
    initializeApplication();

    function initializeApplication() {

        var input = { "id":coreDivisionPage, "roleId":self.globalViewModel.employeeRole() };
        var coreCommand = new CoreCommand();
        var moduleResult = coreCommand.getPermission(hostAuthorizationUrl, input);
        var result = moduleResult.permission;

        var helper = new EmployeeHelper();
        self.enableAdd(helper.getEnableAdd(result));
        self.enableUpdate(helper.getEnableUpdate(result));
        self.enableDelete(helper.getEnableDelete(result));

        if (self.mode() == coreModeEdit) {
            var codeId = globalViewModel.targetId();
            self.showInfo(true);
            var entityData = { id:codeId };
            var helper = new CompanyHelper();
            helper.getDivision(entityData, getBranchCallback);
        }
    }

    function getBranchCallback(data) {

        if (data != null) {

            self.nid(data.nid);
            self.code(data.divisionCode);
            self.name(data.divisionName);
            self.description(data.description);
            self.disabled(data.disabled);

            for (var i = 0; i < data.divisionInfo.length; i++) {
                self.listInfo.push(new InfoDataViewModel(data.divisionInfo[i]));
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
        $("#accordianDivision").accordion({collapsible:true, active:false});
    }

    self.updateInfoData = function (data) {

        var entityData = createUpdateEntityData(data);
        var helper = new CompanyHelper();
        helper.saveOrUpdateDivisionInfo(entityData, updateDataSuccessCallback);

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
        var validationStatusOk = true;

        if (self.addInfoCategory() == "" || self.addInfoCategory() == undefined) {
            $("#divisionCategoryAdd").validationEngine('validate');
            validationStatusOk = false;
        }

        if (self.addInfoType() == "" || self.addInfoType() == undefined) {
            $("#divisionTypeAdd").validationEngine('validate');
            validationStatusOk = false;
        }

        if (validationStatusOk) {
            var entityInfoData = createEntityData();
            var helper = new CompanyHelper();
            helper.saveOrUpdateDivisionInfo(entityInfoData, addDataSuccessCallback);
        }
    }

    function createEntityData() {

        var branchData = {
            category:self.addInfoCategory(),
            description:self.addInfoDescription(),
            type:self.addInfoType(),
            value:self.addInfoValue(),
            refEntity:self.nid()
        };
        return branchData;
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
            var result = helper.deleteDivisionInfo(entityData, data, deleteCompleteCallback);
        }
    }

    function deleteCompleteCallback(result, data) {

        if (result.messageCode == 0) {
            self.listInfo.remove(data);
        }
    }

    function updateFunction(data) {
        globalViewModel.targetId(data.nid);
        globalViewModel.editMode(globalEditorModeEdit);
        globalViewModel.applicationScopeType(coreApplicationTypeBranch);
        preparePageForLoading("branchEdit.jsp");
    }

    self.updateData = function (data) {

        var isValid = $("#" + "divisionForm").validationEngine('validate');

        if (!isValid)
            return;

        if (self.errorInForm())
            return;

        var division = new Division();
        if (self.mode() == coreModeEdit)
            division.nid = self.nid();

        division.companyId = self.globalViewModel.companyId();
        division.divisionCode = self.code();
        division.divisionName = self.name();
        division.description = self.description();
        division.disabled = self.disabled();

        var helper = new CompanyHelper();
        helper.saveUpdateDivision(division, saveOrUpdateStatus)
    }

    function saveOrUpdateStatus(result) {
        if (result.messageCode == 0) {
            preparePageForLoading("division.jsp");
        }
    }

    self.cancelUpdate = function (data) {
        preparePageForLoading("division.jsp");
    }
}