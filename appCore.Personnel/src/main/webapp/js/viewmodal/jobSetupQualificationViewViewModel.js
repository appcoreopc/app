var JobSetupQualificationViewInfo = function (source) {
    var self = this;
    self.nid = ko.observable(source.nid);
    self.jobSetupRef = ko.observable(source.jobSetupRef);
    self.level = ko.observable(source.level);
    self.levelDescription = ko.observable(source.description);
    self.fieldOfStudy = ko.observable(source.fieldOfStudy);
}

var JobSetupQualificationViewViewModel = function (dataSource, mode, audMode, globalViewModel) {

    var self = this;
    self.totalRecordCount = ko.observable(dataSource.length - 1);
    self.bindingSource = ko.observableArray();

    self.levelList = ko.observableArray();
    self.fieldOfStudyList = ko.observableArray();

    var helper = new EmployeeHelper();

    helper.getLevelCodeByCompany(self.levelList, globalViewModel.companyId());
    helper.getFieldCodeByCompany(self.fieldOfStudyList, globalViewModel.companyId());

    self.mode = ko.observable(0);
    self.enableAdd = ko.observable(false);
    self.enableUpdate = ko.observable(false);
    self.enableDelete = ko.observable(false);

    self.selectedItem = ko.observable();

    self.level = ko.observable();
    self.levelDescription = ko.observable();
    self.fieldOfStudy = ko.observable();

    if (audMode != undefined) {
        self.enableAdd = ko.observable(helper.getEnableAdd(audMode));
        self.enableUpdate = ko.observable(helper.getEnableUpdate(audMode));
        self.enableDelete = ko.observable(helper.getEnableDelete(audMode));
    }

    if (mode == 0 && dataSource != null) {
        for (var i = 0; i < dataSource.length; i++) {
            self.bindingSource.push(new JobSetupQualificationViewInfo(dataSource[i]));
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
            return "jobSetupQualificationViewAddTemplate";
        }

        switch (self.mode()) {
            case 0:
                return "jobSetupQualificationViewTemplate";
            case 1:
            case 2:
                return "jobSetupQualificationViewAddTemplate";
            default:
                return "jobSetupQualificationViewTemplate";
        }
        return "jobSetupQualificationViewAddTemplate";

    }.bind(this);

    self.cancelEdit = function () {
        self.editData();
        self.mode(0);
    }


    self.saveDataForm = function (data) {

        var source = data;
        var jobSetupQualification = new JobSetupQualification();

        if (source.nid != null || source.nid != undefined)
            jobSetupQualification.nid = source.nid();

        jobSetupQualification.level = source.level();
        jobSetupQualification.description = source.levelDescription();
        jobSetupQualification.fieldOfStudy = source.fieldOfStudy();
        jobSetupQualification.jobSetupRef = source.jobSetupRef();

        var request = ajaxCore.sendRequestType(globalJobSetupQualificationSaveOrUpdateUrl, jobSetupQualification, "post");

        request.success(function (data, status, xhrObj) {
            self.editData();
        });
    }

    self.remove = function (element) {
        self.initData.remove(element);
    }

    self.getLevelCode = function (code) {
        return helper.findCodeInList(code(), self.levelList());
    }

    self.getFieldOfStudyCode = function (code) {
        return helper.findCodeInList(code(), self.fieldOfStudyList());
    }
}