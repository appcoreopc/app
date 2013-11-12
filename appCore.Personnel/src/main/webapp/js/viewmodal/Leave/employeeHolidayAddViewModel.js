var EmployeeHolidayInfoViewModel = function (mode, globalViewModel) {

    var self = this;

    self.nid = ko.observable();
    self.employeeId = ko.observable();
    self.entitlementType = ko.observable();
    self.earningType = ko.observable();
    self.replacementType = ko.observable();
    self.leaveWorkflowId = ko.observable();

    self.entityList = ko.observableArray();
    self.holidayEntitlementType = ko.observableArray();
    self.leaveEarningScheme = ko.observableArray();
    self.leaveReplacementType = ko.observableArray();
    self.leaveWorkflow = ko.observableArray();
    self.lastUpdate = ko.observable();

    self.currentHolidayEntitlementType = ko.observable();
    self.currentLeaveEarningScheme = ko.observable();
    self.currentLeaveReplacementType = ko.observable();
    self.currentWorkflowId = ko.observable();

    self.editData = ko.observable();
    self.commandText = ko.observable("Add");
    self.mode = ko.observable(mode);
    self.enableAdd = ko.observable();
    self.enableUpdate = ko.observable();
    self.enableDelete = ko.observable();

    self.showInfo = ko.observable(false);
    self.errorInForm = ko.observable(false);
    self.globalViewModel = globalViewModel;

    if (self.globalViewModel.applicationScopeType() != coreApplicationTypeEmployeeHolidayType) {
        throw "Application Type is not employeeHoliday.";
    }

    self.mode(self.globalViewModel.editMode());
    // get permission
    initializeApplication();

    function initializeApplication() {
        var input = { "id":coreEmployeeHolidayPage, "roleId":self.globalViewModel.employeeRole() };
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
        }
    }

    self.getEntitlementTypeData = function () {
        var helper = new LeaveHelper();
        var entityData = { id:globalViewModel.companyId() };
        return helper.listByCompanyHolidayEntitlementType(entityData);
    }

    self.getLeaveEarningScheme = function () {
        var helper = new LeaveHelper();
        var entityData = { id:globalViewModel.companyId() };
        return helper.listByCompanyHolidayLeaveEarningScheme(entityData);
    }

    self.getLeaveReplacementScheme = function () {
        var helper = new LeaveHelper();
        var entityData = { id:globalViewModel.companyId() };
        return helper.listByCompanyLeaveReplacementType(entityData);
    }

    self.listByCompanyEmployee = function () {
        var helper = new LeaveHelper();
        var entityData = { id:globalViewModel.companyId() };
        return helper.listByCompanyEmployee(entityData);
    }

    self.getData = function () {
        if (self.mode() == coreModeEdit) {
            var codeId = globalViewModel.targetId();
            var entityData = { id:codeId };
            var helper = new LeaveHelper();
            return helper.getEmployeeHoliday(entityData);
        }
    }

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
        $("#accordianEmployeeHoliday").accordion({collapsible:true, active:false});
    }

    function createUpdateEntityData(data) {

        var entityData = {
            category:data.infoCategory(),
            description:data.infoDescription(),
            //probationMonth : self.probationMonth(),
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
            $("#employeeHolidayCategoryAdd").validationEngine('validate');
            validationStatusOk = false;
        }

        if (self.addInfoType() == "" || self.addInfoType() == undefined) {
            $("#employeeHolidayTypeAdd").validationEngine('validate');
            validationStatusOk = false;
        }

        if (validationStatusOk) {
            var entityInfoData = createEntityData();
            var helper = new CompanyHelper();
            helper.saveOrUpdateEmployeeHolidayInfo(entityInfoData, addDataSuccessCallback);
        }
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
                return "EmployeeHolidayEntityAddTemplate";
            default:
                return "EmployeeHolidayEntityAddTemplate";
        }
        return "EmployeeHolidayEntityAddTemplate";

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
            var result = helper.deleteEmployeeHolidayInfo(entityData, data, deleteCompleteCallback);
        }
    }

    function deleteCompleteCallback(result, data) {

        if (result.messageCode == 0) {
            self.listInfo.remove(data);
        }
    }

    self.updateData = function (data) {

        var isValid = $("#" + "employeeHolidayForm").validationEngine('validate');

        if (!isValid)
            return;

        if (self.errorInForm())
            return;

        var employeeHoliday = {};
        if (self.mode() == coreModeEdit)
            employeeHoliday.nid = self.nid();

        employeeHoliday.companyId = globalViewModel.companyId();
        employeeHoliday.nid = self.nid();
        employeeHoliday.employeeId = self.employeeId();
        employeeHoliday.holidayEntitlementType = self.currentHolidayEntitlementType();
        employeeHoliday.leaveEarningScheme = self.currentLeaveEarningScheme();
        employeeHoliday.holidayReplacementType = self.currentLeaveReplacementType();
        employeeHoliday.lastUpdate = self.lastUpdate();

        var helper = new LeaveHelper();
        helper.saveUpdateEmployeeHoliday(employeeHoliday, saveOrUpdateStatus)
    }

    function saveOrUpdateStatus(result) {
        if (result.messageCode == 0) {
            preparePageForLoading("employeeHolidayListPage.jsp");
        }
    }

    self.cancelUpdate = function (data) {
        preparePageForLoading("employeeHolidayListPage.jsp");
    }
}