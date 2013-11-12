var HolidayLeaveEarningSchemeInfoViewModel = function (mode, globalViewModel) {

    var self = this;
    self.nid = ko.observable();
    self.name = ko.observable();
    self.description = ko.observable();
    self.type = ko.observable();
    self.refId = ko.observable();
    self.startEffectiveDate = ko.observable();
    self.endEffectiveDate = ko.observable();
    self.lastUpdate = ko.observable();

    self.commandText = ko.observable("Add");

    self.mode = ko.observable(mode);
    self.enableAdd = ko.observable();
    self.enableUpdate = ko.observable();
    self.enableDelete = ko.observable();

    self.showInfo = ko.observable(false);
    self.errorInForm = ko.observable(false);
    self.globalViewModel = globalViewModel;

    if (self.globalViewModel.applicationScopeType() != coreApplicationTypeHolidayLeaveEarningSchemeType) {
        throw "Application Type is not holidayLeaveEarningScheme.";
    }

    self.mode(self.globalViewModel.editMode());

    // get permission
    initializeApplication();

    function initializeApplication() {

        var input = { "id":coreHolidayLeaveEarningSchemePage, "roleId":self.globalViewModel.employeeRole() };
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
            var helper = new LeaveHelper();
            helper.getHolidayLeaveEarningScheme(entityData, getEntityGetDataCallback);
        }
    }

    function getEntityGetDataCallback(data) {
        if (data != null) {
            var dateHelper = new EmployeeHelper();

            self.nid(data.nid);
            self.name(data.name);
            self.description(data.description);
            self.type(data.type);
            self.refId(data.refId);
            self.startEffectiveDate(dateHelper.getDateOnly(new Date(data.startEffectiveDate)));
            self.endEffectiveDate(dateHelper.getDateOnly(new Date(data.endEffectiveDate)));
            self.lastUpdate(data.lastUpdate);
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
        $("#accordianHolidayLeaveEarningScheme").accordion({collapsible:true, active:false});
    }

    self.updateInfoData = function (data) {

        var entityData = createUpdateEntityData(data);
        var helper = new CompanyHelper();
        helper.saveOrUpdateHolidayLeaveEarningSchemeInfo(entityData, updateDataSuccessCallback);
        self.editData("");
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
            $("#holidayLeaveEarningSchemeCategoryAdd").validationEngine('validate');
            validationStatusOk = false;
        }

        if (self.addInfoType() == "" || self.addInfoType() == undefined) {
            $("#holidayLeaveEarningSchemeTypeAdd").validationEngine('validate');
            validationStatusOk = false;
        }

        if (validationStatusOk) {
            var entityInfoData = createEntityData();
            var helper = new CompanyHelper();
            helper.saveOrUpdateHolidayLeaveEarningSchemeInfo(entityInfoData, addDataSuccessCallback);
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
                return "HolidayLeaveEarningSchemeEntityAddTemplate";
            default:
                return "HolidayLeaveEarningSchemeEntityAddTemplate";
        }
        return "HolidayLeaveEarningSchemeEntityAddTemplate";

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
            var result = helper.deleteHolidayLeaveEarningSchemeInfo(entityData, data, deleteCompleteCallback);
        }
    }

    function deleteCompleteCallback(result, data) {

        if (result.messageCode == 0) {
            self.listInfo.remove(data);
        }
    }

    self.updateData = function (data) {

        var isValid = $("#" + "holidayLeaveEarningSchemeForm").validationEngine('validate');

        if (!isValid)
            return;

        var helper = new EmployeeHelper();

        if (self.errorInForm())
            return;

        var holidayLeaveEarningScheme = {};
        if (self.mode() == coreModeEdit)
            holidayLeaveEarningScheme.nid = self.nid();

        holidayLeaveEarningScheme.nid = self.nid();
        holidayLeaveEarningScheme.companyId = globalViewModel.companyId();
        holidayLeaveEarningScheme.name = self.name();
        holidayLeaveEarningScheme.description = self.description();
        holidayLeaveEarningScheme.type = self.type();
        holidayLeaveEarningScheme.refId = self.refId();
        holidayLeaveEarningScheme.startEffectiveDate = helper.getDate(self.startEffectiveDate());
        holidayLeaveEarningScheme.endEffectiveDate = helper.getDate(self.endEffectiveDate());
        holidayLeaveEarningScheme.lastUpdate = self.lastUpdate();


        var helper = new LeaveHelper();
        helper.saveUpdateHolidayLeaveEarningScheme(holidayLeaveEarningScheme, saveOrUpdateStatus)
    }

    function saveOrUpdateStatus(result) {
        if (result.messageCode == 0) {
            preparePageForLoading("holidayLeaveEarningSchemeListPage.jsp");
        }
    }

    self.cancelUpdate = function (data) {
        preparePageForLoading("holidayLeaveEarningSchemeListPage.jsp");
    }
}