var UsersAddEditViewModel = function (mode, globalViewModel) {
    var self = this;
    this.centralPage = globalAdminHostPath + globalAdminCentralPage;
    self.mode = ko.observable(0);
    self.nid = ko.observable();
    self.globalViewModel = globalViewModel;
    self.userName = ko.observable();
    self.password = ko.observable();
    self.confirmPassword = ko.observable();
    self.fullName = ko.observable();
    self.email = ko.observable();

    self.errorExist = ko.observable();
    self.templateToUse = ko.observable();
    self.mode(mode);

    if (mode == coreModeEdit) {
        getUserDetails(self.globalViewModel.targetId());
    }

    function getUserDetails(targetId) {
        var ajaxCore = new AjaxCore();
        var companyRequest = { id:targetId};
        var request = ajaxCore.sendRequest(globalUserGet, companyRequest, "get");

        request.success(function (dataSource) {
            self.nid(dataSource.nid);
            self.userName(dataSource.username);
            self.password(dataSource.password);
            self.confirmPassword(dataSource.password);
            self.fullName(dataSource.fullName);
            self.email(dataSource.email);
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


    function emptyfunction()
    {

    }

    self.saveOrUpdateUser = function () {

        var isValid = $("#" + "userForm").validationEngine('validate');
        if (!isValid) {
            return;
        }

        if (self.password() !== self.confirmPassword()) {
            var dialog = new CoreDialog();
            var dialogMessage = { title : "Invalid password", message : "Password and confirm password is not the same" };
            dialog.createGeneralConfirmationDialog(dialogMessage, emptyfunction);
            return;
        }

        var user = {
            username:self.userName(),
            password:self.password(),
            email:self.email(),
            fullName:self.fullName(),
            companyId:self.globalViewModel.companyId()
        };

        if (self.mode() == coreModeEdit) {
            user.nid = self.nid();
        }

        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestType(globalUserSaveOrUpdate, user, "post");
        request.success(function (dataSource) {
            globalCurrentId = null;
            preparePageForLoading(globalAdminHostPath + "userList.jsp");
        });
    }
}