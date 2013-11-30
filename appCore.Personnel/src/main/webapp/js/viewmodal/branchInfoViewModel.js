var BranchInfoViewModel = function (globalViewModel) {

    var self = this;
    self.nid = ko.observable();
    self.code = ko.observable();
    self.name = ko.observable();
    self.description = ko.observable();
    self.disabled = ko.observable(false);

    self.infoCategory = ko.observable();
    self.infoDescription = ko.observable();
    self.infoType = ko.observable();
    self.infoValue = ko.observable();

    self.commandText = ko.observable("Add");

    self.addInfoCategory = ko.observable();
    self.addInfoDescription = ko.observable();
    self.addInfoType = ko.observable();
    self.addInfoValue = ko.observable();

    self.listInfo = ko.observableArray();
    self.editData = ko.observable();

    self.mode = ko.observable(coreModeInsert);
    self.enableAdd = ko.observable();
    self.enableUpdate = ko.observable();
    self.enableDelete = ko.observable();

    self.globalViewModel = globalViewModel;

    self.showInfo = ko.observable(false);
    self.errorInForm = ko.observable(false);

    var viewColumns = [
        { headerText:"Branch Code", rowText:"branchCode" },
        { headerText:"Branch Name", rowText:"branchName" },
        { headerText:"Description", rowText:"description" },
        { headerText:"Disabled", rowText:"enable" }
    ];


    self.mode(self.globalViewModel.editMode());

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
            self.showInfo(true);
            var codeId = globalViewModel.targetId();
            var branchData = { id:codeId };
            var helper = new CompanyHelper();
            return helper.getBranch(branchData);
        }
        return null;
    }

    function getBranchCallback(data) {
        if (data != null) {
            self.nid(data.nid);
            self.code(data.branchCode);
            self.name(data.branchName);
            self.description(data.description);
            self.disabled(data.disabled);

            for (var i = 0; i < data.branchInfo.length; i++) {
                self.listInfo.push(new InfoDataViewModel(data.branchInfo[i]));
            }
        }
    }

    self.renderView = function () {
        try {

            $.when(initializeApplication()).done(function (a) {
                if (a != undefined && a != null) {
                    getBranchCallback(a);
                }
                bind();
            });
        }
        catch (e) {
            console.log(e);
        }
    }

    function bind() {

        $("#" + "targetDialogForm").setupViewBinding(self, globalViewModel);
        $("#accordian").accordion({collapsible:true, active:false});
        $("#" + "branchForm").validationEngine();
        $('#BranchCode').mask('AAAAAAAAAA');
    }

    self.cancelInfoData = function () {
        self.editData("");
    }

    self.editInfoData = function (data) {
        self.infoCategory = data.infoCategory;
        self.infoDescription = data.infoDescription;
        self.infoType = data.infoType;
        self.infoValue = data.infoValue;
        self.editData(data);
    }

    self.deleteInfoData = function (data) {
        var dialog = new CoreDialog();
        var helper = new EmployeeHelper();
        var dialogObject = helper.createDialogObject("Delete record", "Do you want to remove this record?");
        var result = dialog.createConfirmationDialog(dialogObject, data, globalViewModel, self.codeType, deleteInfoConfirmCallBack);
    }

    self.closeAddControl = function () {
        $("#accordian").accordion({collapsible:true, active:false});
    }

    self.updateInfoData = function (data) {

        var branchData = createUpdateBranchData(data);
        var helper = new CompanyHelper();
        helper.saveOrUpdateBranchInfo(branchData, updateDataSuccessCallback);
        self.editData("");
    }

    function createUpdateBranchData(data) {
        var branchData = {
            category:data.infoCategory(),
            description:data.infoDescription(),
            type:data.infoType(),
            value:data.infoValue(),
            refEntity:self.nid()
        };
        if (data.nid() != null)
            branchData.nid = data.nid();

        return branchData;
    }

    self.addInfo = function (data) {

        var validationStatusOk = true;

        if (self.addInfoCategory() == "" || self.addInfoCategory() == undefined) {
            $("#branchCategoryAdd").validationEngine('validate');
            validationStatusOk = false;
        }

        if (self.addInfoType() == "" || self.addInfoType() == undefined) {
            $("#branchTypeAdd").validationEngine('validate');
            validationStatusOk = false;
        }

        if (validationStatusOk) {
            var branchData = createBranchData();
            var helper = new CompanyHelper();
            helper.saveOrUpdateBranchInfo(branchData, addDataSuccessCallback);
        }
    }

    function createBranchData() {

        var branchData = {
            category:self.addInfoCategory(),
            description:self.addInfoDescription(),
            type:self.addInfoType(),
            value:self.addInfoValue(),
            refEntity:self.nid()
        };
        return branchData;
    }

    function addDataSuccessCallback(result) {

        if (result.messageCode != null) {
            var data = {
                category:self.addInfoCategory(),
                description:self.addInfoDescription(),
                type:self.addInfoType(),
                value:self.addInfoValue()
            };

            if (result.saveCode != null)
                data.nid = result.saveCode;

            var addItem = new InfoDataViewModel(data);
            self.listInfo.push(addItem);
            self.addInfoCategory("");
            self.addInfoDescription("");
            self.addInfoType("");
            self.addInfoValue("");
        }
    }

    self.addInfoData = function () {

        var data = {
            category:self.addInfoCategory(),
            description:self.addInfoDescription(),
            type:self.addInfoType(),
            value:self.addInfoValue()
        };

        var addItem = new InfoDataViewModel(data);

        self.listInfo.push(addItem);
        self.addInfoCategory("");
        self.addInfoDescription("");
        self.addInfoType("");
        self.addInfoValue("");
    }

    /*
    self.templateToUse = function (item) {
        switch (self.mode()) {
            case 1:
            case 2:
                return "companyEntityAddTemplate";
            default:
                return "companyEntityAddTemplate";
        }
        return "companyEntityAddTemplate";
    }.bind(this); */

    self.templateToUse = function () {
        switch (self.mode()) {
            case 1:
            case 2:
                return "companyEntityAddTemplate";
            default:
                return "companyEntityAddTemplate";
        }
        return "companyEntityAddTemplate";
    };

    self.infoTemplateToUse = function (item) {
        if (item === self.editData())
            return "infoUpdateTemplate";

        return "infoViewTemplate";
    }.bind(this);

    function deleteInfoConfirmCallBack(userResponse, data, globalViewModel, codeType) {

        if (userResponse == true) {
            var helper = new CompanyHelper();
            var branchData = { id:data.nid() };
            var result = helper.deleteBranchInfo(branchData, data, deleteCompleteCallback);
        }
    }

    function deleteCompleteCallback(result, data) {
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

        if (self.errorInForm())
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