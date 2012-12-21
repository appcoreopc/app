var EmploymentInfoView = function (source) {

    var self = this;
    var helper = new EmployeeHelper();

    self.nid = ko.observable(source.nid);
    self.employerName = ko.observable(source.employerName);
    self.job = ko.observable(source.job);
    self.industry = ko.observable(source.industry);
    self.startDate = ko.observable(helper.getDateOnly(new Date(source.startDate)));
    self.endDate = ko.observable(helper.getDateOnly(new Date(source.endDate)));
    self.duration = ko.observable(source.duration);
    self.lastDrawnSalary = ko.observable(source.lastDrawnSalary);
    self.resignationReason = ko.observable(source.resignationReason);
    self.remarks = ko.observable(source.remarks);
    self.employeeRefId = ko.observable(source.employeeRefId);
}


var EmployeeEmploymentInfoViewModel = function (dataSource, mode, audMode, employeeId) {

    var self = this;
    self.bindingSource = ko.observableArray();
    self.industryList = ko.observableArray();
    self.permission = ko.observable(false);

    // Making inline calls
    var helper = new EmployeeHelper();
    helper.getIndustryCode(self.industryList);

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

    if (mode == 0 && dataSource != null) {
        for (var i = 0; i < dataSource.length; i++) {
            self.bindingSource.push(new EmploymentInfoView(dataSource[i]));
        }
    }

    self.getIndustryCode = function (industryCode) {
        return helper.findCodeInList(industryCode, self.industryList());
    }

    self.remove = function (element) {
        self.initData.remove(element);
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
            return "employeeEmploymentInfoAddTemplate";
        }

        switch (self.mode()) {
            case 0:
                return "employeeEmploymentInfoTemplate";
            case 1:
            case 2:
                return "employeeEmploymentInfoAddTemplate";
            default:
                return "employeeEmploymentInfoTemplate";
        }
        return "employeeEmploymentInfoTemplate";

    }.bind(this);

    self.cancelEdit = function () {
        self.editData();
        self.mode(0);
    }

    self.saveDataForm = function (data) {

        var source = data;

        var employeeEmployment = new EmployeeEmployment();

        if (source.nid() != null || source.nid() != undefined) {
            employeeEmployment.nid = source.nid();
        }

        employeeEmployment.employerName = source.employerName();
        employeeEmployment.job = source.job();
        employeeEmployment.industry = source.industry();
        employeeEmployment.startDate = helper.getDate(source.startDate().toString());
        employeeEmployment.endDate = helper.getDate(source.endDate().toString());
        employeeEmployment.duration = source.duration();
        employeeEmployment.lastDrawnSalary = source.lastDrawnSalary();
        employeeEmployment.resignationReason = source.resignationReason();
        employeeEmployment.remarks = source.remarks();

        employeeEmployment.employeeRefId = globalCurrentEmployee;

        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestType(globalEmployeeEmploymentSaveOrUpdateUrl, employeeEmployment, "post");

        request.success(function (data, status, xhrObj) {
            self.editData();
        });
    }

}