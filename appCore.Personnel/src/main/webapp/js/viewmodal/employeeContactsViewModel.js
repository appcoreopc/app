var EmployeeContactsViewModel = function (initView, value, data) {

    var self = this;
    this.viewType = initView;

    self.email = ko.observable();
    self.alternateEmail = ko.observable();

    self.correspondenceAddress = ko.observable();
    self.correspondenceAddress2 = ko.observable();
    self.correspondenceAddress3 = ko.observable();

    self.city = ko.observable();
    self.postcode = ko.observable();

    self.hp = ko.observable();
    self.extNo = ko.observable();

    self.country = ko.observable();
    self.telNo = ko.observable();

    this.getRole = function () {
        var input = { "id":globalEmployeeModule, "roleId":1 };
        return input;
    }

    this.getView = function () {

        var gridDataObject = { };

        switch (this.viewType) {
            case 0:

                var helper = new EmployeeHelper();

                var addLinkInfo =
                {
                    "text":"Add Contact",
                    "commandId":'ContactAdd',
                    "link":this.addPage,
                    "targetControlId":"#userCommand",
                    "ctrlId":"ContactAddId",
                    "knockoutAttribute":"click: saveContactsForm"
                };

                var cancelLinkInfo = helper.getCancelInfo();

                var updateLinkInfo = {
                    "text":"Update",
                    "link":this.editPage
                };
                gridDataObject.editorMode = "Insert";
                gridDataObject.addLinkInfo = addLinkInfo;
                gridDataObject.cancelLinkInfo = cancelLinkInfo;
                return gridDataObject;
            default:
                break;
        }
    }

    this.saveContactsForm = function () {

        var isValid = $("#" + "contactForm").validationEngine('validate');

        if (!isValid)
            return;

        var employeeContact = new EmployeeContact();
        employeeContact.email = self.email();
        employeeContact.alternateEmail = self.alternateEmail();

        employeeContact.correspondenceAddress2 = self.correspondenceAddress();
        employeeContact.correspondenceAddress3 = self.correspondenceAddress2();
        employeeContact.correspondenceAddress1 = self.correspondenceAddress3();
        employeeContact.city = self.city();

        // employeeContact.country = self.country();
        // please remove this.
        employeeContact.country = self.country();
        employeeContact.country = 1;

        employeeContact.telNo = self.telNo();
        employeeContact.mobileNo = self.hp();
        employeeContact.extNo = self.extNo();

        employeeContact.employeeRefId = globalCurrentEmployee;

        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestType(globalEmployeeContactAddUrl, employeeContact, "post");

        request.success(function (data, status, xhrObj) {
            var helper = new EmployeeHelper();
            helper.closeDialog();
        });
    }
}