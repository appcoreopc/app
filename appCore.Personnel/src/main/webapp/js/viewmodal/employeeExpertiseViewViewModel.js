var EmployeeExpertiseViewInfo = function (source) {

    var self = this;
    var helper = new EmployeeHelper();

    self.nid = ko.observable(source.nid);
    self.industry = ko.observable(source.industry);
    self.specialty = ko.observable(source.specialty);

    self.startDate = ko.observable(helper.getDateOnly(new Date(source.startDate)));
    self.endDate = ko.observable(helper.getDateOnly(new Date(source.endDate)));

    self.period = ko.observable(source.period);
    self.remarks = ko.observable(source.remarks);
    self.employeeRefId = ko.observable(source.employeeRefId);

}


var EmployeeExpertiseViewViewModel = function (dataSource, mode, audMode, employeeId) {

    var self = this;

    self.totalRecordCount = ko.observable(dataSource.length-1);
    self.bindingSource = ko.observableArray();
    self.industryList = ko.observableArray();
    self.specialtyList = ko.observableArray();

    // Making inline calls
    var helper = new EmployeeHelper();

    helper.getIndustryCode(self.industryList);
    helper.getSpecialtyCode(self.specialtyList)

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
            self.bindingSource.push(new EmployeeExpertiseViewInfo(dataSource[i]));
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
            return "employeeExpertiseAddTemplate";
        }

        switch (self.mode()) {
            case 0:
                return "employeeExpertiseTemplate";
            case 1:
            case 2:
                return "employeeExpertiseAddTemplate";
            default:
                return "employeeExpertiseTemplate";
        }
        return "employeeExpertiseAddTemplate";

    }.bind(this);

    self.cancelEdit = function () {

        self.editData();
        self.mode(0);
    }

    self.saveDataForm = function (data) {

        var source = data;
        var employeeExpertise = new EmployeeExpertise();

        if (source.nid != null || source.nid != undefined)
            employeeExpertise.nid = source.nid();

        employeeExpertise.industry = source.industry();
        employeeExpertise.specialty = source.specialty();
        employeeExpertise.startDate = helper.getDate(source.startDate().toString());
        employeeExpertise.endDate = helper.getDate(source.endDate().toString());

        employeeExpertise.period = source.period();
        employeeExpertise.remarks = source.remarks();
        employeeExpertise.employeeRefId = globalCurrentEmployee;

        var request = ajaxCore.sendRequestType(globalEmployeeExpertiseSaveOrUpdateUrl, employeeExpertise, "post");

        request.success(function (data, status, xhrObj) {
            self.editData();
        });
    }


    self.remove = function (element) {
        self.initData.remove(element);
    }

    self.getIndustryCode = function (industryCode) {
        return helper.findCodeInList(industryCode, self.industryList());
    }

    self.getSpecialtyCode = function (specialtyCode) {
        return helper.findCodeInList(specialtyCode, self.specialtyList());
    }

}