var UsersAddEditViewModel = function (mode, companyId) {

    var self = this;
    var modelCompanyId = companyId;
    this.centralPage = globalAdminCentralPage;

    self.mode = ko.observable(0);
    self.nid = ko.observable();

    self.userName = ko.observable();
    self.password = ko.observable();
    self.confirmPassword = ko.observable();
    self.fullName = ko.observable();
    self.email = ko.observable();

    self.errorExist = ko.observable();

    self.templateToUse = ko.observable();

    self.mode(mode);

    if (mode == 2) {

        getUserDetails(modelCompanyId);
       }

    function getUserDetails(companyId) {

        var ajaxCore = new AjaxCore();
        var companyRequest = { id:companyId };

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
            "data":this.data,
            "columns":null,
            "model":null
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
            alert('invalid validation.')
            return;
        }

        var user = {
            username:self.userName(),
            password:self.password(),
            email:self.email(),
            fullName:self.fullName()
        };

        if (self.mode() == 2) {
            user.nid = self.nid();
        }

        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestType(globalUserSaveOrUpdate, user, "post");

        request.success(function (dataSource) {
            globalCurrentId = null;
            goToPage(globalPersonnelControlPanel);
        });
    }
}