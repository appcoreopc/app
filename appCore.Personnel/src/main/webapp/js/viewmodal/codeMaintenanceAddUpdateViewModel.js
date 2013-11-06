var CodeMaintenanceAddUpdateViewModel = function (codeType, globalViewModel) {

    var self = this;
    self.nid = ko.observable();
    self.name = ko.observable();
    self.description = ko.observable();
    self.companyRef = ko.observable();
    self.disabled = ko.observable(false);

    self.startEffectiveDate = ko.observable();
    self.endEffectiveDate = ko.observable();

    self.commandText = ko.observable("Add");

    self.mode = ko.observable(coreModeInsert);
    self.enableAdd = ko.observable();
    self.enableUpdate = ko.observable();
    self.enableDelete = ko.observable();

    self.globalViewModel = globalViewModel;

    self.showInfo = ko.observable(false);
    self.errorInForm = ko.observable(false);


    if (self.globalViewModel.applicationScopeType() != coreApplicationMaintenanceCode) {
        throw "Application Type is not maintenance code.";
    }

    self.mode(self.globalViewModel.editMode());

    // get permission
    initializeApplication();

    function initializeApplication() {

        var input = { "id":coreCodeMaintenancePage, "roleId":self.globalViewModel.employeeRole() };
        var coreCommand = new CoreCommand();
        var moduleResult = coreCommand.getPermission(hostAuthorizationUrl, input);
        var result = moduleResult.permission;

        var helper = new EmployeeHelper();
        self.enableAdd(helper.getEnableAdd(result));
        self.enableUpdate(helper.getEnableUpdate(result));
        self.enableDelete(helper.getEnableDelete(result));

        if (self.mode() == coreModeEdit) {
            self.showInfo(true);
            var codeId = globalViewModel.targetId();
            var maintenanceCodeData = { id:codeId };
            var helper = new CompanyHelper();
            helper.getMaintenanceCode(codeType, maintenanceCodeData, getMaintenanceCodeCallback);
        }
    }

    function getMaintenanceCodeCallback(data) {
        if (data != null) {
            var dateHelper = new EmployeeHelper();
            self.nid(data.nid);
            self.companyRef(data.companyRef);
            self.name(data.name);
            self.description(data.description);
            self.disabled(data.disabled);
            self.startEffectiveDate(dateHelper.getDateOnly(new Date(data.startEffectiveDate)));
            self.endEffectiveDate(dateHelper.getDateOnly(new Date(data.endEffectiveDate)));
        }
    }

    function createUpdateBranchData(data) {
        var branchData = {
            category:data.infoCategory(),
            description:data.infoDescription(),
            type:data.infoType(),
            value:data.infoValue(),
            refEntity:self.nid()
        };
        if (data.nid() != null)
            branchData.nid = data.nid();

        return branchData;
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

    self.updateData = function (data) {
        var helper = new EmployeeHelper();
        var isValid = $("#" + formName).validationEngine('validate');

        if (!isValid)
            return;

        if (self.errorInForm())
            return;

        var maintenanceCode = {};

        if (self.mode() == coreModeEdit)
            maintenanceCode.nid = self.nid();

        maintenanceCode.companyRef = self.globalViewModel.companyId();
        maintenanceCode.name = self.name();

        maintenanceCode.description = self.description();
        maintenanceCode.startEffectiveDate = helper.getDate(self.startEffectiveDate());
        maintenanceCode.endEffectiveDate = helper.getDate(self.endEffectiveDate());
        maintenanceCode.disabled = self.disabled();

        var helper = new CompanyHelper();
        helper.saveUpdateMaintenanceCode(codeType, maintenanceCode, saveOrUpdateStatus)
    }

    function saveOrUpdateStatus(result) {
        if (result.messageCode == 0) {
            preparePageForLoading("maintenanceCode.jsp");
        }
    }

    self.cancelUpdate = function (data) {
        preparePageForLoading("maintenanceCode.jsp");
    }
}