var EmployeeQualificationViewViewModel = function (dataSource, mode, audMode, employeeId) {

    var self = this;

    self.totalRecordCount = ko.observable(dataSource.length-1);
    self.bindingSource = ko.observableArray(dataSource);
    self.countryList = ko.observableArray();

    var helper = new EmployeeHelper();
    helper.getCountryCode(self.countryList);

    self.mode = ko.observable(0);
    self.enableAdd = ko.observable(false);
    self.enableUpdate = ko.observable(false);
    self.enableDelete = ko.observable(false);

    self.selectedItem = ko.observable();
    self.formPermission = ko.observable();

    self.test = ko.observable(false);

    if (audMode != undefined)
    {
        self.enableAdd = ko.observable(helper.getEnableAdd(audMode));
        self.enableUpdate = ko.observable(helper.getEnableUpdate(audMode));
        self.enableDelete = ko.observable(helper.getEnableDelete(audMode));
    }

    if (mode != coreModeList)
        self.mode = ko.observable(mode);


    self.getPermission = function () {
        return self.enableAdd() || self.enableDelete() || self.enableUpdate();
    }

    self.editData = function (item)
    {
        self.selectedItem(item);
        self.mode(0);
    }

    self.templateToUse = function (item) {

        if (item === self.selectedItem())
        {
            return "employeeQualificationAddTemplate";
        }

        switch (self.mode()) {
            case 0:
                return "employeeQualificationTemplate";
            case 1:
            case 2:
                return "employeeQualificationAddTemplate";
            default:
                return "employeeQualificationTemplate";
        }
        return "employeeQualificationAddTemplate";

    }.bind(this);

    self.cancelEdit = function ()
    {
        self.editData();
        self.mode(0);
    }

    self.saveDataForm = function (data)
    {
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

    self.getCountryCode = function (code) {
        return helper.findCodeInList(code, self.countryList());
    }

    self.remove = function (element) {
        self.initData.remove(element);
    }

}