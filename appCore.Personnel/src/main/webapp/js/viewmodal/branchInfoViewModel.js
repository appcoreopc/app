var BranchInfoViewModel = function (globalViewModel) {

    var self = this;

    self.nid = ko.observable();
    self.code = ko.observable();
    self.name = ko.observable();
    self.description = ko.observable();
    self.disabled = ko.observable(false);

    self.listInfo = ko.observableArray();

    self.mode = ko.observable(coreModeInsert);
    self.enableAdd = ko.observable();
    self.enableUpdate = ko.observable();
    self.enableDelete = ko.observable();

    self.globalViewModel = globalViewModel;

    var viewColumns = [
        { headerText:"Branch Code", rowText:"branchCode" },
        { headerText:"Branch Name", rowText:"branchName" },
        { headerText:"Description", rowText:"description" },
        { headerText:"Disabled", rowText:"enable" }
    ];

    if (self.globalViewModel.applicationScopeType() != coreApplicationTypeBranch) {
        throw "Application Type is not branch.";
    }

    self.mode(self.globalViewModel.editMode());

    // get permission
    initializeApplication();

    function initializeApplication() {

        var input = { "id":coreBranchPage, "roleId":self.globalViewModel.employeeRole() };
        var coreCommand = new CoreCommand();
        var moduleResult = coreCommand.getPermission(hostAuthorizationUrl, input);
        var result = moduleResult.permission;

        var helper = new EmployeeHelper();
        self.enableAdd(helper.getEnableAdd(result));
        self.enableUpdate(helper.getEnableUpdate(result));
        self.enableDelete(helper.getEnableDelete(result));

        if (self.mode() == coreModeEdit) {
            var codeId = globalViewModel.targetId();

            var branchData = { id:codeId };
            var helper = new CompanyHelper();
            helper.getBranch(branchData, getBranchCallback);
        }
    }

    function getBranchCallback(data) {

        if (data != null) {
            self.nid(data.nid);
            self.code(data.branchCode);
            self.name(data.branchName);
            self.description(data.description);
            self.disabled(data.disabled);
        }
    }

    self.editData = function (data) {

    }

    self.templateToUse = function (item) {
        switch (self.mode()) {
            case 1:
            case 2:
                return "branchAddTemplate";
            default:
                return "branchAddTemplate";
        }
        return "branchAddTemplate";

    }.bind(this);

    function deleteFunction(data) {
        var dialog = new CoreDialog();
        var helper = new EmployeeHelper();
        var dialogObject = helper.createDialogObject("Delete record", "Do you want to remove this record?");
        var result = dialog.createConfirmationDialog(dialogObject, data, globalViewModel, self.codeType, deleteCallBack);
    }

    function deleteCallBack(status, data, globalViewModel, codeType) {
        if (status == true) {
            var helper = new CompanyHelper();
            var result = helper.deleteBranch(data, successCallback);
        }
    }

    function successCallback(result, data) {
        if (result.messageCode == 0) {
            self.listInfo.remove(data);
        }
    }

    function updateFunction(data) {
        globalViewModel.targetId(data.nid);
        globalViewModel.editMode(globalEditorModeEdit);
        globalViewModel.applicationScopeType(coreApplicationTypeBranch);
        preparePageForLoading("branchEdit.jsp");
    }

    self.updateData = function (data) {
        var isValid = $("#" + "branchForm").validationEngine('validate');
        if (!isValid)
            return;

        var branch = new Branch();
        if (self.mode() == coreModeEdit)
            branch.nid = self.nid();

        branch.companyId = self.globalViewModel.companyId();
        branch.branchCode = self.code();
        branch.branchName = self.name();
        branch.description = self.description();
        branch.disabled = self.disabled();

        var helper = new CompanyHelper();
        helper.saveUpdateBranch(branch, saveOrUpdateStatus)
    }

    function saveOrUpdateStatus(result) {
        if (result.messageCode == 0) {
            preparePageForLoading("branch.jsp");
        }
    }

    self.cancelUpdate = function (data) {
        preparePageForLoading("branch.jsp");
    }
}