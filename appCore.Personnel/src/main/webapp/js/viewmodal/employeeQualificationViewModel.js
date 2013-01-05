var EmployeeQualificationViewModel = function (initView, globalViewModel) {

    var self = this;
    this.mode = initView;
    this.addPage = "employeeAdd.jsp";

    self.level = ko.observable();
    self.field = ko.observable();
    self.majors = ko.observable();

    self.institution = ko.observable();
    self.localOversea = ko.observable();

    self.startDate = ko.observable();
    self.endDate = ko.observable();

    self.CGPA = ko.observable();

    self.attachment = ko.observable();
    self.remarks = ko.observable();

    self.levelList = ko.observableArray();
    self.fieldList = ko.observableArray();

    var helper = new EmployeeHelper();

    this.loadInitData = function () {
        helper.getLevelCodeByCompany(self.levelList, globalViewModel.companyId());
        helper.getFieldCodeByCompany(self.fieldList, globalViewModel.companyId);
    }

    this.getRole = function () {
        var input = { "id":globalEmployeeModule, "roleId":globalViewModel.employeeRole() };
        return input;
    }

    this.getView = function () {
        var gridDataObject = {};

        switch (this.mode) {

            case 0:
                var helper = new EmployeeHelper();
                var addLinkInfo =
                {
                    "text":"Add Qualification",
                    "commandId":'QualificationAdd',
                    "link":this.addPage,
                    "targetControlId":"#userCommand",
                    "ctrlId":"QualificationAddId",
                    "knockoutAttribute":"click: saveQualificationForm"
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

    this.saveQualificationForm = function () {

        var isValid = $("#" + "QualificationForm").validationEngine('validate');

        if (!isValid)
            return;

        var employeeQualification = new EmployeeQualification();
        employeeQualification.level = self.level();
        employeeQualification.major = self.majors();
        employeeQualification.fieldOfStudy = self.field();
        employeeQualification.institution = self.institution();
        employeeQualification.localOrOversea = self.localOversea();
        employeeQualification.resultCGPA = self.CGPA();

        employeeQualification.attachment = self.attachment();
        employeeQualification.remarks = self.remarks();
        employeeQualification.startDate = helper.getDate(self.startDate());
        employeeQualification.endDate = helper.getDate(self.endDate());

        employeeQualification.employeeRefId = globalViewModel.targetId();

        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestType(globalEmployeeQualificationUrl, employeeQualification, "post");

        request.success(function (data, status, xhrObj) {
            helper.closeDialog();
        });
    }

}