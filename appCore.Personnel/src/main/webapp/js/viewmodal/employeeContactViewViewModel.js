var EmployeeContactViewViewModel = function (dataSource, mode, audMode, employeeId) {

    var self = this;
    self.bindingSource = ko.observableArray(dataSource);

    self.totalRecordCount = ko.observable(dataSource.length-1);

    self.countryList = ko.observableArray();
    var helper = new EmployeeHelper();
    helper.getCountryCode(self.countryList);

    self.mode = ko.observable(0);
    self.enableAdd = ko.observable(false);
    self.enableUpdate = ko.observable(false);
    self.enableDelete = ko.observable(false);

    self.selectedItem = ko.observable();
    self.formPermission = ko.observable();


    if (audMode != undefined) {
        self.enableAdd = ko.observable(helper.getEnableAdd(audMode));
        self.enableUpdate = ko.observable(helper.getEnableUpdate(audMode));
        self.enableDelete = ko.observable(helper.getEnableDelete(audMode));
    }

    if (mode != coreModeList)
        self.mode = ko.observable(mode);


    //if (mode == coreModeEdit) {
    // getGeneralInfo(employeeId);
    // getContactInfo(employeeId);
    //}

    /*function getContactInfo(code) {

     var employeeCode = { id:code };
     var request = ajaxCore.sendRequestSequential(globalEmployeeGetUrl, employeeCode, "get");

     request.success(function (data, status, xhrObj) {

     var employeeGeneralInfo = new EmployeeGeneralInfo();
     employeeGeneralInfo.name(data.name);
     employeeGeneralInfo.code(data.code);
     employeeGeneralInfo.salutation(data.salutation);
     employeeGeneralInfo.firstName(data.firstName);
     employeeGeneralInfo.middleName(data.middleName);
     employeeGeneralInfo.lastName(data.lastName);

     employeeGeneralInfo.gender(data.gender);
     employeeGeneralInfo.birthDate(helper.getDateOnly(new Date(data.birthDate)));

     employeeGeneralInfo.age(data.age);
     employeeGeneralInfo.maritalStatus(data.maritalStatus);
     employeeGeneralInfo.marriageDate(helper.getDateOnly(new Date(data.marriageDate)));
     employeeGeneralInfo.race(data.race);

     employeeGeneralInfo.religion(data.religion);
     employeeGeneralInfo.nationality(data.nationality);

     employeeGeneralInfo.countryOrigin(data.countryOrigin);
     employeeGeneralInfo.disabled(data.disabled);

     self.bindingSource = ko.observableArray([employeeGeneralInfo]);

     });
     }*/

    self.getPermission = function () {
        return self.enableAdd() || self.enableDelete() || self.enableUpdate();
    }

    self.editData = function (item) {
        self.selectedItem(item);
        self.mode(0);
    }

    self.templateToUse = function (item) {

        if (item === self.selectedItem()) {
            return "employeeContactAddTemplate";
        }

        switch (self.mode()) {
            case 0:
                return "employeeContactTemplate";
            case 1:
            case 2:
                return "employeeContactAddTemplate";
            default:
                return "employeeContactTemplate";
        }
        return "employeeContactAddTemplate";

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

    self.getCountryCode = function (code) {
        return helper.findCodeInList(code, self.countryList());
    }

    self.remove = function (element) {
        self.initData.remove(element);
    }

}