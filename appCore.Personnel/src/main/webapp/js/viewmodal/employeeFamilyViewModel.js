var EmployeeFamilyViewModel = function (initView, value, data) {

    var self = this;

    self.memberName = ko.observable();
    self.memberType = ko.observable();
    self.birthDate = ko.observable();
    self.age = ko.observable();
    self.salutation = ko.observable();
    self.gender = ko.observable();

    self.maritalStatus = ko.observable();
    self.salutation = ko.observable();
    self.identificationNo = ko.observable();

    self.working = ko.observable(true);
    self.studying = ko.observable(false);
    self.handicap = ko.observable(false);
    self.nominatedSpouse = ko.observable(false);

    self.attachments = ko.observable();
    self.remarks = ko.observable();

    self.genderList = ko.observableArray();
    self.maritalStatusList = ko.observableArray();
    self.salutationList = ko.observableArray();

    var helper = new EmployeeHelper();

    helper.getGenderCode(self.genderList);
    helper.getMaritalStatusCode(self.maritalStatusList);
    helper.getSalutationCode(self.salutationList);

    this.viewType = initView;

    this.getRole = function () {
        var input = { "id":globalEmployeeModule, "roleId":1 };
        return input;
    }

    this.getView = function () {

        var gridDataObject = {};

        switch (this.viewType) {
            case 0:
                var helper = new EmployeeHelper();
                var addLinkInfo =
                {
                    "text":"Add Family Info",
                    "commandId":'FamilyAdd',
                    "link":this.addPage,
                    "targetControlId":"#userCommand",
                    "ctrlId":"FamilyAddId",
                    "knockoutAttribute":"click: saveFamilyForm"
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

    this.saveFamilyForm = function () {

        var isValid = $("#" + "FamilyForm").validationEngine('validate');

        if (!isValid)
            return;

        var employeeFamily = new EmployeeFamily();

        employeeFamily.memberName = self.memberName();
        employeeFamily.memberType = self.memberType();

        employeeFamily.birthDate = helper.getDate(self.birthDate());

        employeeFamily.age = self.age();
        employeeFamily.salutation = self.salutation();
        employeeFamily.gender = self.gender();

        employeeFamily.maritalStatus = self.maritalStatus();
        employeeFamily.identificationNo = self.identificationNo();

        employeeFamily.working = self.working();

        employeeFamily.studying = self.studying();
        employeeFamily.handicap = self.handicap();
        employeeFamily.nominatedSpouse = self.nominatedSpouse();

        employeeFamily.attachments = self.attachments();
        employeeFamily.remarks = self.remarks();

        employeeFamily.employeeRefId = globalCurrentEmployee;

        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestType(globalEmployeeFamilyUrl, employeeFamily, "post");

        request.success(function (data, status, xhrObj) {
            helper.closeDialog();
        });
    }
}