var HolidaySetupAddViewModel = function (globalViewModel) {
    var self = this;
    self.nid = ko.observable();
    self.code = ko.observable();
    self.holidayDate = ko.observable();
    self.holidayName = ko.observable();
    self.holidayType = ko.observable(false);
    self.recurring = ko.observable(false);

    self.commandText = ko.observable("Add");

    self.mode = ko.observable(coreModeInsert);
    self.enableAdd = ko.observable();
    self.enableUpdate = ko.observable();
    self.enableDelete = ko.observable();

    self.globalViewModel = globalViewModel;

    if (self.globalViewModel.applicationScopeType() != coreApplicationTypeHolidayConfigure) {
        throw "Application Type is not HolidaySetup.";
    }

    self.mode(self.globalViewModel.editMode());

    initializeApplication();

    function initializeApplication() {

        var input = { "id":coreHolidaySetupPage, "roleId":self.globalViewModel.employeeRole() };
        var coreCommand = new CoreCommand();
        var moduleResult = coreCommand.getPermission(hostAuthorizationUrl, input);
        var result = moduleResult.permission;

        var helper = new EmployeeHelper();

        self.enableAdd(helper.getEnableAdd(result));
        self.enableUpdate(helper.getEnableUpdate(result));
        self.enableDelete(helper.getEnableDelete(result));

        if (self.mode() == coreModeEdit) {
            var codeId = globalViewModel.targetId();

            var entityData = { id:codeId };
            var helper = new CompanyHelper();
            helper.getHoliday(entityData, getHolidayCallback);
        }
    }

    function getHolidayCallback(data) {

        if (data != null) {

            var helper = new EmployeeHelper();
            self.nid(data.nid);
            self.holidayDate(helper.getDateOnly(new Date(data.holidayDate)));
            self.holidayName(data.name);
            self.holidayType(data.type);

            if (data.recurring == true) {
                console.log('recurring');
                self.recurring("true");
            }
            else {
                self.recurring("false");
            }
        }
    }

    self.editData = ko.observable();

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
        var entityInfoData = createEntityData();
        var helper = new CompanyHelper();
        helper.saveOrUpdateDivisionInfo(entityInfoData, addDataSuccessCallback);
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

    self.templateToUse = function (item) {
        switch (self.mode()) {
            case 1:
            case 2:
                return "holidaySetupAddTemplate";
            default:
                return "holidaySetupAddTemplate";
        }
        return "holidaySetupAddTemplate";

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

    self.updateData = function (data) {
        var isValid = $("#" + "holidayAddForm").validationEngine('validate');

        if (!isValid)
            return;

        var helper = new EmployeeHelper();

        var holiday = new Holiday();
        if (self.mode() == coreModeEdit)
            holiday.nid = self.nid();

        holiday.companyRef = self.globalViewModel.companyId();
        holiday.name = self.holidayName();
        holiday.holidayDate = helper.getDate(self.holidayDate().toString());

        holiday.type = self.holidayType();
        holiday.recurring = self.recurring();

        var helper = new CompanyHelper();
        helper.saveUpdateHoliday(holiday, saveOrUpdateStatus)
    }

    function saveOrUpdateStatus(result) {
        if (result.messageCode == 0) {
            preparePageForLoading("holidaySetup.jsp");
        }
    }

    self.cancelUpdate = function (data) {
        preparePageForLoading("holidaySetup.jsp");
    }
}