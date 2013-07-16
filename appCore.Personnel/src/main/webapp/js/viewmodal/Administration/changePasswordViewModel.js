var ChangePasswordViewModel = function (globalViewModel) {
    var self = this;
    self.oldPassword = ko.observable();
    self.newPassword = ko.observable();
    self.confirmPassword = ko.observable();

    function successCallback(result, data) {
        if (result.messageCode == 0) {
            self.gridData.remove(data);
        }
    }

    self.updatePassword = function () {

        if (self.newPassword() == "")
            alert('password must contain valid characters');

        if (self.confirmPassword() == "")
            alert('password must contain valid characters');

        if (self.newPassword() != self.confirmPassword())
            alert('new password and confirm password do not match.');

        var passwordUpdateInfo = {
            "id":sessionStorage.userId,
            "oldPassword":self.oldPassword,
            "newPassword":self.newPassword
        };

        var helper = new UserHelper();
        helper.updatePassword(passwordUpdateInfo, updateSuccessCallback);
    }

    function updateSuccessCallback(result, data) {
        if (result.messageCode == 0) {

        }
    }

    self.getView = function () {
        var gridDataObject =
        {
            "gridUrl":this.gridUrl,
            "data":this.data,
            "columns":null,
            "model":null
        };

        var addLinkInfo = {
            "text":"Add Branch",
            "commandId":'branchAdd',
            "link":this.addPage,
            "callback":function () {
                goToAdd()
            }
        };

        var updateLinkInfo = {
            "text":"Update",
            "link":this.editPage
        };

        gridDataObject.gridData = self.gridData;
        gridDataObject.updateFunction = self.updatePassword;
        gridDataObject.deleteFunction = deleteFunction;
        gridDataObject.controlId = this.gridId;
        gridDataObject.addLinkInfo = addLinkInfo;
        gridDataObject.updateLinkInfo = updateLinkInfo;
        return gridDataObject;
    }

    self.initializeViewModel = function () {
        var gridDataObject = this.getView();
        var input = { "id":coreBranchPage, "roleId":globalViewModel.employeeRole() };
        var coreCommand = new CoreCommand();
        var gridViewModel = coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);
        self.gridViewModel = gridViewModel;
    }

    function goToAdd() {
        globalViewModel.applicationScopeType(coreApplicationTypeBranch);
        globalViewModel.editMode(coreModeInsert);
        preparePageForLoading("branchAdd.jsp");
    }

    self.cancelUpdate = function () {
        preparePageForLoading(globalEmptyMainPage);
    }

    self.initializeViewModel();
}