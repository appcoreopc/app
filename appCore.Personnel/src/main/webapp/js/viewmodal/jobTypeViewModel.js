var JobTypeViewModel = function (mode, jobTypeId, permission, globalViewModel) {

    var self = this;
    var helper = new EmployeeHelper();
    self.mode = ko.observable(0);

    self.description = ko.observable();

    self.enableAdd = ko.observable(false);
    self.enableUpdate = ko.observable(false);
    self.enableDelete = ko.observable(false);

    self.selectedItem = ko.observable();
    self.formPermission = ko.observable();

    if (permission != undefined) {
        self.enableAdd = ko.observable(helper.getEnableAdd(permission));
        self.enableUpdate = ko.observable(helper.getEnableUpdate(permission));
        self.enableDelete = ko.observable(helper.getEnableDelete(permission));
    }

    if (mode != coreModeList)
        self.mode = ko.observable(mode);

    if (self.mode() == coreModeEdit) {
        var entityData = { id: jobTypeId };
        var companyHelper = new CompanyHelper();
        companyHelper.getJobType(entityData, getEntityGetDataCallback);
    }

    function getEntityGetDataCallback(data) {

        if (data != null) {
            self.description(data.description);
        }
    }


    self.getPermission = function () {
        return self.enableAdd() || self.enableDelete() || self.enableUpdate();
    }

    self.editData = function (item) {
        self.selectedItem(item);
        self.mode(0);
    }

    self.templateToUse = function (item) {
        switch (self.mode()) {
            case 0:
                return "employeeJobDescriptionTemplate";
            case 1:
            case 2:
                return "employeeEditJobDescriptionTemplate";
            default:
                return "employeeJobDescriptionTemplate";
        }
        return "employeeEditJobDescriptionTemplate";

    }.bind(this);

    self.cancelEdit = function () {
        self.editData();
        self.mode(0);
    }

    self.saveDataForm = function (data) {
        var source = data;
        var contact = new EmployeeContact();

        if (source.nid != null || source.nid != undefined)
            contact.nid = data.nid;

        contact.level = source.level;
        contact.email = source.email;
        contact.mobileNo = source.mobileNo;
        contact.alternateEmail = source.alternateEmail;
        contact.extNo = source.extNo;
        contact.correspondenceAddress1 = source.correspondenceAddress1;
        contact.correspondenceAddress2 = source.correspondenceAddress2;
        contact.correspondenceAddress3 = source.correspondenceAddress3;
        contact.city = source.city;
        contact.country = source.country;
        contact.telNo = source.telNo;
        contact.employeeRefId = globalCurrentEmployee;

        var request = ajaxCore.sendRequestType(globalEmployeeContactSaveOrUpdateUrl, contact, "post");
        request.success(function (data, status, xhrObj) {
            self.editData();
        });

    }

   self.remove = function (element) {
        self.initData.remove(element);
    }
}