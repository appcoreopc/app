var JobSetupExperienceAddViewModel = function (initView, globalViewModel) {

    var self = this;
    self.expertise = ko.observable();
    self.description = ko.observable();
    self.yearOfExperience = ko.observable();
    self.expertiseList = ko.observableArray();
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
                    "text":"Add Qualification",
                    "commandId":'jobSetupQualificationAdd',
                    "link":this.addPage,
                    "targetControlId":"#userCommand",
                    "ctrlId":"jobSetupQualificationAddId",
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
        var isValid = $("#" + "JobSetupQualificationForm").validationEngine('validate');

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