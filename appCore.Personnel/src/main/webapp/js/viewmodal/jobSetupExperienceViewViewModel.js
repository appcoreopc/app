var JobSetupExperienceViewInfo = function (source) {

    var self = this;
    self.nid = ko.observable(source.nid);
    self.jobSetupRef = ko.observable(source.jobSetupRef);
    self.expertise = ko.observable(source.expertise);
    self.expertiseDescription = ko.observable(source.description);
    self.experienceYears = ko.observable(source.experienceYears);
}

var JobSetupExperienceViewViewModel = function (dataSource, mode, audMode, globalViewModel) {

    var self = this;
    self.totalRecordCount = ko.observable(dataSource.length - 1);
    self.bindingSource = ko.observableArray();

    self.expertiseList = ko.observableArray();

    var helper = new EmployeeHelper();
    helper.getFieldCode(self.expertiseList, globalViewModel.companyId());

    self.mode = ko.observable(0);
    self.enableAdd = ko.observable(false);
    self.enableUpdate = ko.observable(false);
    self.enableDelete = ko.observable(false);

    self.selectedItem = ko.observable();

    self.expertise = ko.observable();
    self.experienceYears = ko.observable();
    self.expertiseDescription = ko.observable();


    if (audMode != undefined) {
        self.enableAdd = ko.observable(helper.getEnableAdd(audMode));
        self.enableUpdate = ko.observable(helper.getEnableUpdate(audMode));
        self.enableDelete = ko.observable(helper.getEnableDelete(audMode));
    }

    if (mode == 0 && dataSource != null) {
        for (var i = 0; i < dataSource.length; i++) {
            self.bindingSource.push(new JobSetupExperienceViewInfo(dataSource[i]));
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
            return "jobSetupExperienceViewAddTemplate";
        }

        switch (self.mode()) {
            case 0:
                return "jobSetupExperienceViewTemplate";
            case 1:
            case 2:
                return "jobSetupExperienceViewAddTemplate";
            default:
                return "jobSetupExperienceViewTemplate";
        }
        return "jobSetupExperienceViewAddTemplate";

    }.bind(this);

    self.cancelEdit = function () {
        self.editData();
        self.mode(0);
    }

    self.saveDataForm = function (data) {

        var source = data;
        var jobSetupExperience = new JobSetupExperience();

        if (source.nid != null || source.nid != undefined)
            jobSetupExperience.nid = source.nid();

        jobSetupExperience.expertise = source.expertise();
        jobSetupExperience.description = source.expertiseDescription();
        jobSetupExperience.experienceYears = source.experienceYears();
        jobSetupExperience.jobSetupRef = source.jobSetupRef();

        var request = ajaxCore.sendRequestType(globalJobSetupExperienceSaveOrUpdateUrl, jobSetupExperience, "post");

        request.success(function (data, status, xhrObj) {
            self.editData();
        });
    }

    self.remove = function (element) {
        self.initData.remove(element);
    }

    self.getExpertiseCode = function (code) {
        return helper.findCodeInList(code(), self.expertiseList());
    }

}