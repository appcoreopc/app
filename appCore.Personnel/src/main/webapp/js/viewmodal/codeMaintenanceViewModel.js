var CodeMaintenanceViewModel = function (initView, codeType, data, globalViewModel) {

    var self = this;
    self.mode = ko.observable(initView);
    self.title = ko.observable();

    self.nid = ko.observable("");
    self.name = ko.observable("");
    self.description = ko.observable("");
    self.startEffectiveDate = ko.observable("");
    self.endEffectiveDate = ko.observable("");
    self.disabled = ko.observable("");
    self.companyRef = ko.observable("");
    self.lastUpdate = ko.observable("");

    self.enableAdd = ko.observable();
    self.enableUpdate = ko.observable();
    self.enableDelete = ko.observable();

    this.centralPage = "maintenanceCode.jsp";
    this.editPage = "maintenanceCodeAdd.jsp";
    this.addPage = "maintenanceCodeAdd.jsp";
    this.branchForm = "codeForm";

    this.gridUrl = "";
    this.codeCommand = "#maintenanceCodeCommand";
    this.gridId = "codeGrid";
    this.data = data;
    self.codeType = codeType;

    var form = "codeForm";

    if (initView == 0)
        self.gridData = ko.observableArray(data);

    var viewColumns = [
        { headerText:"Code Name", rowText:"name" },
        { headerText:"Description", rowText:"description" },
        { headerText:"Start Effective Date", rowText:"startEffectiveDate" },
        { headerText:"End Effective Date", rowText:"endEffectiveDate" }

    ];

    var model = {
        id:"nid",
        fields:{
            nid:{ editable:false },
            name:{  type:"string" },
            description:{  type:"string" },
            startEffectiveDate:{  validation:{ required:true } },
            endEffectiveDate:{  validation:{ required:true } }
        }
    };

    var columns = {
        columns:[
            {
                field:"name",
                width:90,
                title:"Name"
            },
            {
                field:"description",
                width:90,
                title:"Description"
            },
            {
                field:"startEffectiveDate",
                width:90,
                title:"Start Effective Date",
                template:'#= kendo.toString(new Date(startEffectiveDate),"dd MMM yyyy") #'

            },
            {
                field:"endEffectiveDate",
                width:90,
                title:"End Effective Date",
                template:'#= kendo.toString(new Date(endEffectiveDate),"dd MMM yyyy") #'
            }
        ]};


    if (self.mode() == coreModeEdit)
        getDataForm(data);

    this.getAddPage = function () {
        return this.addPage;
    }

    function getGridDate(date) {
        return new Date(date);
    }

    this.getCentralPage = function () {
        return this.centralPage;
    }

    function updateFunction(data) {

        var helper = new EmployeeHelper();
        helper.setMaintenanceCodeEditMode(globalViewModel, data.nid);
        preparePageForLoading("maintenanceCodeAdd.jsp");
    }

    function deleteFunction(data) {


        var dialog = new CoreDialog();
        var helper = new EmployeeHelper();
        var dialogObject = helper.createDialogObject("Delete record", "Do you want to remove this record?");
        var result = dialog.createConfirmationDialog(dialogObject, data, globalViewModel, self.codeType, deleteCallBack);
    }

    function deleteCallBack(status, data, globalViewModel, codeType) {

        if (status == true) {
            var helper = new CodeMaintenanceHelper(codeType);
            var result = helper.deletMaintenanceCode(globalViewModel.companyId, data.nid, codeType);
            self.gridData.remove(data);
        }
    }

    this.getView = function () {
        var gridDataObject =
        {
            "gridUrl":this.gridUrl,
            "data":this.data,
            "columns":columns,
            "model":model
        };

        switch (self.mode()) {

            case 0:
                var helper = new CodeMaintenanceHelper(this.codeType);
                gridDataObject.gridUrl = helper.getUrl();
                self.title = ko.observable(helper.getTitle(this.codeType));

                var addLinkInfo = {
                    "text":"Add New Code",
                    "link":this.addPage,
                    "callback":function () {
                        goToAdd();
                    }
                };

                var updateLinkInfo = {
                    "text":"Update",
                    "link":this.editPage
                };

                gridDataObject.gridData = self.gridData;
                gridDataObject.viewColumns = viewColumns;
                gridDataObject.updateFunction = updateFunction;
                gridDataObject.deleteFunction = deleteFunction;
                gridDataObject.controlId = this.gridId;
                gridDataObject.addLinkInfo = addLinkInfo;
                gridDataObject.updateLinkInfo = updateLinkInfo;
                return gridDataObject;

            case 1:


                var helper = new CodeMaintenanceHelper(this.codeType);
                gridDataObject.gridUrl = helper.getUrl();
                this.title = ko.observable(helper.getTitle(this.codeType));

                var addLinkInfo = {
                    "text":"Save",
                    "link":this.centralPage,
                    "commandId":'codeAdd',
                    "targetControlId":this.codeCommand,
                    "knockoutAttribute":"click: saveDataForm"
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

                var helper = new CodeMaintenanceHelper(this.codeType);
                gridDataObject.gridUrl = helper.getUrl();
                this.title = ko.observable(helper.getTitle(this.codeType));

                var addLinkInfo = {
                    "text":"Save",
                    "link":this.centralPage,
                    "commandId":'codeAdd',
                    "targetControlId":this.codeCommand,
                    "knockoutAttribute":"click: saveDataForm"
                };

                var updateLinkInfo = {
                    "text":"Update",
                    "link":this.editPage
                };

                gridDataObject.addLinkInfo = addLinkInfo;
                gridDataObject.updateLinkInfo = updateLinkInfo;
                gridDataObject.editorMode = "Insert";
                return gridDataObject;
        }
        return gridDataObject;
    }

    function getDataForm(nid) {

        var helper = new CodeMaintenanceHelper(this.codeType);
        var dateHelper = new EmployeeHelper();

        var code = { id:nid  };
        var request = ajaxCore.sendRequest(helper.getUrl() + "/get", code, "get");

        request.success(function (data, status, xhrObj) {
            self.name(data.name);
            self.nid(data.nid);
            self.description(data.description);
            var startDate = new Date(data.startEffectiveDate);
            var endDate = new Date(data.endEffectiveDate);

            self.startEffectiveDate(dateHelper.getDateOnly(startDate));
            self.endEffectiveDate(dateHelper.getDateOnly(endDate));

            self.disabled(data.disabled);
            self.lastUpdate(data.lastUpdate);
        });
    }

    self.cancelChanges = function()
    {
        var dialog = new CoreDialog();
        var helper = new EmployeeHelper();
        var dialogObject = helper.createDialogObject("Cancel changes", "Do you want to cancel your changes?");
        var result = dialog.createConfirmationDialog(dialogObject, null, globalViewModel, null, deleteCancelCallBack);
    }

    function deleteCancelCallBack(status, data, globalViewModel, codeType) {

        if (status == true) {
            preparePageForLoading("maintenanceCode.jsp");
        }
    }


    this.saveDataForm = function () {

        var helper = new EmployeeHelper();
        var code = new GenericCodeMaintenance();

        if (self.mode() == 2)
            code.nid = self.nid();

        self.companyRef(globalCurrentCompanyId);
        code.name = self.name();
        code.description = self.description();

        code.startEffectiveDate = helper.getDate(self.startEffectiveDate());
        code.endEffectiveDate = helper.getDate(self.endEffectiveDate());
        code.disabled = self.disabled();

        code.lastUpdate = helper.getDateTimestamp(new Date());
        code.companyRef = self.companyRef();


        var helper = new CodeMaintenanceHelper(this.codeType);
        var ajaxCore = new AjaxCore();

        var request = ajaxCore.sendRequestType(helper.getUrl() + "/saveOrUpdate", code, "post");
        request.success(function (data, status, xhrObj) {

            globalViewModel.targetId(null);
            globalViewModel.editMode(null);
            globalViewModel.applicationScopeType(coreApplicationMaintenanceCode);
            preparePageForLoading("maintenanceCode.jsp");
        });
    }

    function goToAdd()
    {
        globalViewModel.targetId(null);
        globalViewModel.applicationScopeType(coreApplicationMaintenanceCode);
        globalViewModel.editMode(coreModeInsert);
        preparePageForLoading("maintenanceCodeAdd.jsp");
    }


    function initializeApp()
    {
        var input = { "id" : coreCodeMaintenancePage, "roleId" : globalViewModel.employeeRole() };
        var coreCommand = new CoreCommand();
        var result = coreCommand.getPermission(hostAuthorizationUrl, input);

        var helper = new EmployeeHelper();
        self.enableAdd(helper.getEnableAdd(result.permission));
        self.enableUpdate(helper.getEnableUpdate(result.permission));
        self.enableDelete(helper.getEnableDelete(result.permission));
    }

    initializeApp();
}