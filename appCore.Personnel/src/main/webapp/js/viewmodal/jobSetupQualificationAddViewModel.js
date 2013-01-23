var JobSetupQualificationAddViewModel = function (initView, globalViewModel) {

    var self = this;
    self.level = ko.observable();
    self.description = ko.observable();
    self.fieldOfStudy = ko.observable();
    self.levelList = ko.observableArray();

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
            "level":self.level(),
            "description":self.description(),
            "fieldOfStudy":self.fieldOfStudy,
            "jobSetupRef":globalViewModel.targetId()
        };

        var request = ajaxCore.sendRequestType(globalJobSetupQualificationAddUrl, entityUpdateObject, "post");

        request.success(function (data, status, xhrObj) {
            helper.closeDialog();
        });
    }
}