var EmployeeExpertiseViewModel = function (initView, globalViewModel) {

    var self = this;
    self.industry = ko.observable();
    self.specialty = ko.observable();
    self.startDate = ko.observable();
    self.endDate = ko.observable();
    self.period = ko.observable();
    self.remarks = ko.observable();

    self.industryList = ko.observableArray();
    self.specialtyList = ko.observableArray();

    this.mode = initView;

    var helper = new EmployeeHelper();
    var ajaxCore = new AjaxCore();

    this.loadInitData = function () {

        helper.getIndustryCodeByCompany(self.industryList, globalViewModel.companyId());
        helper.getSpecialtyCodeByCompany(self.specialtyList, globalViewModel.companyId());
    }

    this.getRole = function () {
        var input = { "id":globalEmployeeModule, "roleId": globalViewModel.employeeRole() };
        return input;
    }

    this.getView = function () {

        var gridDataObject = {};

        switch (this.mode) {
            case 0:
                var helper = new EmployeeHelper();

                var addLinkInfo =
                {
                    "text":"Add Expertise",
                    "commandId":'ExpertiseAdd',
                    "link":this.addPage,
                    "targetControlId":"#userCommand",
                    "ctrlId":"expertiseAddId",
                    "knockoutAttribute":"click: saveExpertiseForm"
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

    this.saveExpertiseForm = function () {
        var employeeExpertise;

        var isValid = $("#" + "ExpertiseForm").validationEngine('validate');

        if (!isValid)
            return;

        employeeExpertise = new EmployeeExpertise();
        employeeExpertise.industry = self.industry();
        employeeExpertise.specialty = self.specialty();
        employeeExpertise.startDate = helper.getDate(self.startDate());
        employeeExpertise.endDate = helper.getDate(self.endDate());

        employeeExpertise.period = self.period();
        employeeExpertise.remarks = self.remarks();

        employeeExpertise.employeeRefId = globalViewModel.targetId()    ;
        var request = ajaxCore.sendRequestType(globalEmployeeExpertiseAddUrl, employeeExpertise, "post");

        request.success(function (data, status, xhrObj) {

            helper.closeDialog();
        });
    }
}