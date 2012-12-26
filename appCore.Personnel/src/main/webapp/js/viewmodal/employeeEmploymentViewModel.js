
var EmployeeEmploymentViewModel = function (initView, value, data) {

    this.mode = initView;

    var self = this;

    self.employerName = ko.observable();
    self.job = ko.observable();
    self.industry = ko.observable();

    self.duration = ko.observable();
    self.lastDrawnSalary = ko.observable();
    self.resignationReason = ko.observable();

    self.startDate = ko.observable(new Date());
    self.endDate = ko.observable(new Date());
    self.remarks = ko.observable();

    self.industryList = ko.observableArray();

    var helper = new EmployeeHelper();

    this.loadInitData = function () {
        helper.getIndustryCode(self.industryList);
    }

    this.getRole = function () {
        var input = { "id":globalEmployeeModule, "roleId":1 };
        return input;
    }

    this.getView = function () {
        var gridDataObject = {};

        switch (this.mode) {
            case 0:
                var helper = new EmployeeHelper();

                var addLinkInfo =
                {
                    "text":"Add Employment Info",
                    "commandId":'EmploymentAdd',
                    "link":this.addPage,
                    "targetControlId":"#userCommand",
                    "ctrlId":"EmploymentAddId",
                    "knockoutAttribute":"click: saveExpertiseForm"
                }

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

    this.saveExpertiseForm = function ()
    {
        var isValid = $("#" + "EmploymentForm").validationEngine('validate');

        if (!isValid)
            return;

        var employeeEmployment = new EmployeeEmployment();
        employeeEmployment.employerName = self.employerName();
        employeeEmployment.job = self.job();
        employeeEmployment.industry = self.industry();
        employeeEmployment.startDate = helper.getDate(self.startDate());
        employeeEmployment.endDate = helper.getDate(self.endDate());
        employeeEmployment.duration = self.duration();
        employeeEmployment.lastDrawnSalary = self.lastDrawnSalary();
        employeeEmployment.resignationReason = self.resignationReason();
        employeeEmployment.remarks = self.remarks();

        employeeEmployment.employeeRefId = globalCurrentEmployee;

        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestType(globalEmployeeEmploymentUrl, employeeEmployment, "post");

        request.success(function (data, status, xhrObj) {
            helper.closeDialog();
        });
    }
}