var EmployeeMembershipViewInfo = function (source) {

    var self = this;
    var helper = new EmployeeHelper();

    self.nid = ko.observable(source.nid);

    self.association = ko.observable(source.association);
    self.memberType = ko.observable(source.memberType);

    self.contactDetails = ko.observable(source.contactDetails);

    self.startDate = ko.observable(helper.getDateOnly(new Date(source.startDate)));
    self.endDate = ko.observable(helper.getDateOnly(new Date(source.endDate)));

    self.membershipPeriod = ko.observable(source.membershipPeriod);
    self.enrollmentFees = ko.observable(source.enrollmentFees);
    self.membershipFees = ko.observable(source.membershipFees);

    self.attachments = ko.observable(source.attachments);
    self.remarks = ko.observable(source.remarks);

    self.employeeRefId = ko.observable(source.employeeRefId);

}

var EmployeeMembershipViewViewModel = function (dataSource, mode, audMode, employeeId) {

    var self = this;

    self.totalRecordCount = ko.observable(dataSource.length-1);
    self.mode = ko.observable(0);
    self.enableAdd = ko.observable(false);
    self.enableUpdate = ko.observable(false);
    self.enableDelete = ko.observable(false);

    self.selectedItem = ko.observable();
    self.formPermission = ko.observable();

    // Making inline calls
    var helper = new EmployeeHelper();

    if (audMode != undefined) {
        self.enableAdd = ko.observable(helper.getEnableAdd(audMode));
        self.enableUpdate = ko.observable(helper.getEnableUpdate(audMode));
        self.enableDelete = ko.observable(helper.getEnableDelete(audMode));
    }

    self.associationList = ko.observableArray();

    self.bindingSource = ko.observableArray();

    if (mode == 0 && dataSource != null) {
        for (var i = 0; i < dataSource.length; i++) {
            self.bindingSource.push(new EmployeeMembershipViewInfo(dataSource[i]));
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

        if (item === self.selectedItem()) {
            return "employeeMembershipAddTemplate";
        }

        switch (self.mode()) {
            case 0:
                return "employeeMembershipTemplate";
            case 1:
            case 2:
                return "employeeMembershipAddTemplate";
            default:
                return "employeeMembershipTemplate";
        }
        return "employeeMembershipAddTemplate";

    }.bind(this);

    self.cancelEdit = function () {
        self.editData();
        self.mode(0);
    }

    self.saveDataForm = function (data) {

        var employeeMembership = new EmployeeMembership();

        if (data.nid() != null || data.nid() != undefined)
            employeeMembership.nid = data.nid();

        employeeMembership.association = data.association();
        employeeMembership.memberType = data.memberType();

        employeeMembership.contactDetails = data.contactDetails();

        employeeMembership.startDate = helper.getDate(data.startDate().toString());
        employeeMembership.endDate = helper.getDate(data.endDate().toString());

        employeeMembership.membershipPeriod = data.membershipPeriod();
        employeeMembership.enrollmentFees = data.enrollmentFees();
        employeeMembership.membershipFees = data.membershipFees();

        employeeMembership.attachments = data.attachments();
        employeeMembership.remarks = data.remarks();

        employeeMembership.employeeRefId = globalCurrentEmployee;

        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestType(globalEmployeeMembershipSaveOrUpdateUrl, employeeMembership, "post");

        request.success(function (data, status, xhrObj) {
            self.editData();
        });
    }

    helper.getAssociationMemberCode(self.associationList);

    self.remove = function (element) {
        self.initData.remove(element);
    }

    self.getMemberTypeCode = function (memberTypeCode) {
        return helper.findCodeInList(memberTypeCode, self.associationList());
    }
}