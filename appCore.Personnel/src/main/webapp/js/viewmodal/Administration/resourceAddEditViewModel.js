var ResourceAddEditViewModel = function (mode, globalViewModel) {
    var self = this;
    this.centralPage = globalAdminHostPath + "resourceAccessList.jsp";
    self.mode = ko.observable(0);
    self.nid = ko.observable();
    self.globalViewModel = globalViewModel;

    self.resourceName = ko.observable();
    self.resourceLink = ko.observable();

    self.errorExist = ko.observable();
    self.templateToUse = ko.observable();
    self.mode(mode);

    if (mode == coreModeEdit) {
        getUserDetails(self.globalViewModel.targetId());
    }

    function getUserDetails(targetId) {
        var ajaxCore = new AjaxCore();
        var companyRequest = { id:targetId};
        var request = ajaxCore.sendRequest(globalResourceGetUrl, companyRequest, "get");

        request.success(function (dataSource) {
            self.nid(dataSource.nid);
            self.resourceName(dataSource.formId);
            self.resourceLink(dataSource.link);
        });
    }

    this.getView = function () {
        var gridDataObject =
        {
            "gridUrl":this.gridUrl,
            "data":this.data
        };

        switch (self.mode()) {
            case 1:
                var addLinkInfo = {
                    "text":"Save",
                    "link":this.centralPage,
                    "commandId":'codeAdd',
                    "targetControlId":"#maintenanceCodeCommand",
                    "knockoutAttribute":"click: saveOrUpdateUser"
                };

                var updateLinkInfo = {
                    "text":"Update",
                    "link":this.editPage
                };

                gridDataObject.addLinkInfo = addLinkInfo;
                gridDataObject.updateLinkInfo = updateLinkInfo;
                gridDataObject.editorMode = "Insert";
                return gridDataObject;

            case 2:

                var addLinkInfo = {
                    "text":"Save",
                    "link":this.centralPage,
                    "commandId":'codeAdd',
                    "targetControlId":"#maintenanceCodeCommand",
                    "knockoutAttribute":"click: saveOrUpdateUser"
                };

                var updateLinkInfo = {
                    "text":"Update",
                    "link":this.editPage
                };

                gridDataObject.addLinkInfo = addLinkInfo;
                gridDataObject.updateLinkInfo = updateLinkInfo;
                gridDataObject.editorMode = "Insert";
                return gridDataObject;

            default:
                return null;

        }
    }

    self.saveOrUpdateUser = function () {
        var isValid = $("#" + "userForm").validationEngine('validate');
        if (!isValid) {
            return;
        }

        var resource = {
            formId:self.resourceName(),
            link:self.resourceLink(),
            companyId:self.globalViewModel.companyId()
        };

        if (self.mode() == coreModeEdit) {
            resource.nid = self.nid();
        }

        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestType(globalResourceSaveOrUpdateUrl, resource, "post");
        request.success(function (dataSource) {
            globalCurrentId = null;
            preparePageForLoading(globalAdminHostPath + "resourceAccessList.jsp");
        });
    }
}