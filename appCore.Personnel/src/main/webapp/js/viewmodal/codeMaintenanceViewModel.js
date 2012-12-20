/*
 initView - defined what type of view you're trying to defined

 0 - list view / overall view with grid
 1 - insert mode
 2 - edit mode

 codeType -

 */

var CodeMaintenanceViewModel = function (initView, codeType, data) {

    var self = this;
    self.viewType = ko.observable(initView);
    self.title = ko.observable();

    self.nid = ko.observable("");
    self.name = ko.observable("");
    self.description = ko.observable("");
    self.startEffectiveDate = ko.observable("");
    self.endEffectiveDate = ko.observable("");
    self.disabled = ko.observable("");
    self.companyRef = ko.observable("");
    self.lastUpdate = ko.observable("");

    this.centralPage = "maintenanceCode.jsp";
    this.editPage = "maintenanceCodeAdd.jsp";
    this.addPage = "maintenanceCodeAdd.jsp";
    this.branchForm = "codeForm";

    this.gridUrl = "";
    this.codeCommand = "#maintenanceCodeCommand";
    this.gridId = "codeGrid";
    this.data = data;
    this.codeType = codeType;

    var form = "codeForm";


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


    if (self.viewType() == 2)
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

    this.getView = function () {

        var gridDataObject =
        {
            "gridUrl":this.gridUrl,
            "data":this.data,
            "columns":columns,
            "model":model
        };

        switch (self.viewType()) {

            case 0:
                var helper = new CodeMaintenanceHelper(this.codeType);
                gridDataObject.gridUrl = helper.getUrl();
                this.title = ko.observable(helper.getTitle(this.codeType));

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

    this.saveDataForm = function () {

        var helper = new EmployeeHelper();
        var code = new GenericCodeMaintenance();

        if (self.viewType() == 2)
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
            globalCurrentId = null;
            preparePageForLoading("maintenanceCode.jsp");
        });
    }

    function goToAdd() {
        preparePageForLoading("maintenanceCodeAdd.jsp");
    }
}