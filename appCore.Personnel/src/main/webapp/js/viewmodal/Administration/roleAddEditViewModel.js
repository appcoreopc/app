var RoleAddEditViewModel = function (mode, globalViewModel) {
    var self = this;
    this.centralPage = globalAdminHostPath + "roleList.jsp  ";
    self.mode = ko.observable(0);

    self.nid = ko.observable();
    self.globalViewModel = globalViewModel;
    self.roleName = ko.observable();
    self.description = ko.observable();

    self.errorExist = ko.observable();
    self.templateToUse = ko.observable();
    self.mode(mode);

    if (mode == coreModeEdit) {
        getUserDetails(self.globalViewModel.targetId());
    }

    function getUserDetails(targetId) {
        var ajaxCore = new AjaxCore();
        var roleRequest = { id:targetId};
        var request = ajaxCore.sendRequest(globalRoleGetUrl, roleRequest, "get");

        request.success(function (dataSource) {
            self.nid(dataSource.nid);
            self.roleName(dataSource.rolename);
            self.description(dataSource.description);
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

        var role = {
            rolename:self.roleName(),
            description:self.description(),
            companyId:self.globalViewModel.companyId()
        };

        if (self.mode() == coreModeEdit) {
            role.nid = self.nid();
        }

        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestType(globalRoleSaveOrUpdateUrl, role, "post");
        request.success(function (dataSource) {
            globalCurrentId = null;
            preparePageForLoading(globalAdminHostPath + "roleList.jsp");
        });
    }
}