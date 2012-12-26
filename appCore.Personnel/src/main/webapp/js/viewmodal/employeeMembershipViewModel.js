var EmployeeMembershipViewModel = function (initView, value, data) {

    this.mode = initView;

    var self = this;

    self.association = ko.observable();
    self.memberType = ko.observable();
    self.membershipContact = ko.observable();

    self.startDate = ko.observable();
    self.endDate = ko.observable();

    self.membershipPeriod = ko.observable();
    self.enrollmentFees = ko.observable();
    self.membershipFees = ko.observable();

    self.attachment = ko.observable();
    self.remarks = ko.observable();

    self.memberTypeList = ko.observableArray();

    this.getRole = function () {
        var input = { "id":globalEmployeeModule, "roleId":1 };
        return input;
    }

    var helper = new EmployeeHelper();

    this.loadInitData = function () {

    }

    this.getView = function () {

        var gridDataObject =
        {
        };

        switch (this.mode) {
            case 0:
                var helper = new EmployeeHelper();
                var addLinkInfo =
                {
                    "text":"Add Membership",
                    "commandId":'MembershipAdd',
                    "link":this.addPage,
                    "targetControlId":"#userCommand",
                    "ctrlId":"MembershipAddId",
                    "knockoutAttribute":"click: saveMembershipForm"
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

    this.saveMembershipForm = function () {

        var isValid = $("#" + "MembershipForm").validationEngine('validate');

        if (!isValid)
            return;

        var employeeMembership = new EmployeeMembership();
        employeeMembership.association = self.association();
        employeeMembership.memberType = self.memberType();
        employeeMembership.contactDetails = self.membershipContact();
        employeeMembership.startDate = helper.getDate(self.startDate());
        employeeMembership.endDate = helper.getDate(self.endDate());

        employeeMembership.membershipPeriod = self.membershipPeriod();
        employeeMembership.enrollmentFees = self.enrollmentFees();
        employeeMembership.membershipFees = self.membershipFees();

        employeeMembership.attachments = self.attachment();
        employeeMembership.remarks = self.remarks();

        employeeMembership.employeeRefId = globalCurrentEmployee;

        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestType(globalEmployeeMembershipUrl, employeeMembership, "post");

        request.success(function (data, status, xhrObj) {
            helper.closeDialog();
        });
    }
}