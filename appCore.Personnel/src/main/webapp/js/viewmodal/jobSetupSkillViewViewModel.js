var JobSetupSkillViewInfo = function (source) {
    var self = this;
    self.nid = ko.observable(source.nid);
    self.jobSetupRef = ko.observable(source.jobSetupRef);

    self.skill = ko.observable(source.skill);
    self.level = ko.observable(source.level);
    self.description = ko.observable(source.description);

    self.category = ko.observable(source.category);
    self.categoryDescription = ko.observable(source.categoryDescription);
}

var JobSetupSkillViewViewModel = function (dataSource, mode, audMode, globalViewModel) {

    var self = this;
    self.totalRecordCount = ko.observable(dataSource.length - 1);
    self.bindingSource = ko.observableArray();

    self.levelList = ko.observableArray();

    var helper = new EmployeeHelper();

    helper.getLevelCodeByCompany(self.levelList, globalViewModel.companyId());

    self.mode = ko.observable(0);
    self.enableAdd = ko.observable(false);
    self.enableUpdate = ko.observable(false);
    self.enableDelete = ko.observable(false);

    self.selectedItem = ko.observable();

    self.skill = ko.observable();
    self.level = ko.observable();
    self.description = ko.observable();

    self.category = ko.observable();
    self.categoryDescription = ko.observable();

    if (audMode != undefined) {
        self.enableAdd = ko.observable(helper.getEnableAdd(audMode));
        self.enableUpdate = ko.observable(helper.getEnableUpdate(audMode));
        self.enableDelete = ko.observable(helper.getEnableDelete(audMode));
    }

    if (mode == 0 && dataSource != null) {
        for (var i = 0; i < dataSource.length; i++) {
            self.bindingSource.push(new JobSetupSkillViewInfo(dataSource[i]));
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
            return "jobSetupSkillViewAddTemplate";
        }

        switch (self.mode()) {
            case 0:
                return "jobSetupSkillViewTemplate";
            case 1:
            case 2:
                return "jobSetupSkillViewAddTemplate";
            default:
                return "jobSetupSkillViewTemplate";
        }
        return "jobSetupSkillViewAddTemplate";

    }.bind(this);

    self.cancelEdit = function () {
        self.editData();
        self.mode(0);
    }


    self.saveDataForm = function (data) {

        var source = data;
        var jobSetupSkill = new JobSetupSkill();

        if (source.nid != null || source.nid != undefined)
            jobSetupSkill.nid = source.nid();

        jobSetupSkill.skill = source.skill();
        jobSetupSkill.level = source.level();
        jobSetupSkill.category = source.category();
        jobSetupSkill.categoryDescription = source.categoryDescription();
        jobSetupSkill.description = source.description();
        jobSetupSkill.jobSetupRef = source.jobSetupRef();

        var request = ajaxCore.sendRequestType(globalJobSetupSkillSaveOrUpdateUrl, jobSetupSkill, "post");

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