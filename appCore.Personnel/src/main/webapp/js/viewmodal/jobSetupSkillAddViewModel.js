var JobSetupSkillAddViewModel = function (initView, globalViewModel) {

    var self = this;

    self.skill = ko.observable();
    self.level = ko.observable();
    self.category = ko.observable();
    self.categoryDescription = ko.observable();
    self.description = ko.observable();

    self.skillList = ko.observableArray();
    self.skillLevelList = ko.observableArray();
    self.categoryList = ko.observableArray();

    this.mode = initView;

    var helper = new EmployeeHelper();
    var ajaxCore = new AjaxCore();

    this.loadInitData = function () {
    }

    this.getRole = function () {
        var input = { "id":globalEmployeeModule, "roleId":globalViewModel.employeeRole() };
        return input;
    }

    this.getView = function () {
        var gridDataObject = {};
        switch (this.mode) {
            case coreModeInsert:
                var helper = new EmployeeHelper();
                var addLinkInfo =
                {
                    "text":"Add Skill",
                    "commandId":'jobSetupSkillAdd',
                    "link":this.addPage,
                    "targetControlId":"#userCommand",
                    "ctrlId":"jobSetupSkillAddId",
                    "knockoutAttribute":"click: saveForm"
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

    this.saveForm = function () {
        var employeeExpertise;
        var isValid = $("#JobSetupSkillForm").validationEngine('validate');

        if (!isValid)
            return;

        var entityUpdateObject =
        {
            "expertise":self.expertise(),
            "yearOfExperience":self.yearOfExperience(),
            "description":self.description(),
            "jobSetupRef":globalViewModel.targetId()
        };

        var request = ajaxCore.sendRequestType(globalJobSetupExperienceAddUrl, entityUpdateObject, "post");
        request.success(function (data, status, xhrObj) {
            helper.closeDialog();
        });
    }
}