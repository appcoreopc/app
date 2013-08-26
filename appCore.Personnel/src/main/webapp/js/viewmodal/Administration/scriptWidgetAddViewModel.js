var ScriptWidgetInfoViewModel = function (globalViewModel) {

    var self = this;
    self.nid = ko.observable();
    self.scriptName = ko.observable();
    self.scriptPath = ko.observable();
    self.description = ko.observable();
    self.lastUpdate = ko.observable();

    self.commandText = ko.observable("Add");

    self.mode = ko.observable(coreModeInsert);
    self.enableAdd = ko.observable();
    self.enableUpdate = ko.observable();
    self.enableDelete = ko.observable();

    self.showInfo = ko.observable(false);
    self.errorInForm = ko.observable(false);
    self.globalViewModel = globalViewModel;

    if (self.globalViewModel.applicationScopeType() != coreApplicationTypeScriptWidgetType) {
        throw "Application Type is not scriptWidget.";
    }

    self.mode(self.globalViewModel.editMode());

    // get permission
    initializeApplication();

    function initializeApplication() {

        var input = { "id":coreScriptWidgetPage, "roleId":self.globalViewModel.employeeRole() };
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
            helper.getScriptWidget(entityData, getEntityGetDataCallback);
        }
    }

    function getEntityGetDataCallback(data) {

        if (data != null) {

            self.nid(data.nid);
            self.scriptName(data.scriptName);
            self.scriptPath(data.scriptPath);
            self.description(data.description);
        }
    }

    self.editData = ko.observable();

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
                return "ScriptWidgetEntityAddTemplate";
            default:
                return "ScriptWidgetEntityAddTemplate";
        }
        return "ScriptWidgetEntityAddTemplate";

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
            var result = helper.deleteScriptWidgetInfo(entityData, data, deleteCompleteCallback);
        }
    }

    function deleteCompleteCallback(result, data) {

        if (result.messageCode == 0) {
            self.listInfo.remove(data);
        }
    }

    self.updateData = function (data) {

        var isValid = $("#" + "scriptWidgetForm").validationEngine('validate');

        if (!isValid)
            return;

        if (self.errorInForm())
            return;

        var scriptWidget = {};

        if (self.mode() == coreModeEdit)
            scriptWidget.nid = self.nid();

        scriptWidget.companyId = self.globalViewModel.companyId();
        scriptWidget.scriptName = self.scriptName();
        scriptWidget.scriptPath = self.scriptPath();
        scriptWidget.description = self.description();

        var helper = new CompanyHelper();
        helper.saveUpdateScriptWidget(scriptWidget, saveOrUpdateStatus)
    }

    function saveOrUpdateStatus(result) {
        if (result.messageCode == 0) {
            preparePageForLoading("scriptWidgetListPage.jsp");
        }
    }

    self.cancelUpdate = function (data) {
        preparePageForLoading("scriptWidgetListPage.jsp");
    }
}