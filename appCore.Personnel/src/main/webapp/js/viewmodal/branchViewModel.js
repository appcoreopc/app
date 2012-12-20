var BranchViewModel = function (initView, value, data) {

    this.viewType = initView;
    this.centralPage = "branch.jsp";
    this.editPage = "branchEdit.jsp";
    this.addPage = "branchAdd.jsp";
    this.branchForm = "branchForm";
    this.gridUrl = globalHostname + "/app/Core/Branch";
    this.gridInfoUrl = globalHostname + "/app/Core/BranchInfo";
    this.codeCommand = "#codeCommand";
    this.gridId = "gridBranch";
    this.data = data;

    this.valueData = value;

    var model = {

        id:"nid",
        fields:{
            nid:{ editable:false },
            type:{ editable:false, type:"string" },
            value:{ editable:false, validation:{ required:true } },
            description:{ editable:false, type:"string" },
            category:{ editable:false, validation:{ required:true } }
        }
    };

    var columns = { "columns":[
        {
            field:"branchCode",
            width:90,
            title:"Branch Code"
        },
        {
            field:"branchName",
            width:90,
            title:"Branch Name"
        },
        {
            field:"description",
            width:90,
            title:"Description"
        },
        {
            field:"enabled",
            width:90,
            title:"Disabled"
        }
    ]};

    var infoColumns = { "columns":[
        {
            field:"type",
            width:90,
            title:"Type"
        },
        {
            field:"value",
            width:90,
            title:"Value"
        },
        {
            field:"description",
            width:90,
            title:"Description"
        },
        {
            field:"category",
            width:90,
            title:"Category"
        }

    ]};

    var infoModel = {
        id:"nid",
        fields:{
            nid:{ editable:false },
            type:{  type:"string" },
            value:{  validation:{ required:true } },
            description:{  type:"string" },
            category:{  validation:{ required:true } }
        }
    };

    this.getAddPage = function () {
        return this.addPage;
    }

    this.getCentralPage = function () {
        return this.centralPage;
    }

    /* 0 = view mode
     *  1 = add mode
     *  2 = edit mode
     */

    this.getView = function () {
        var gridDataObject =
        {
            "gridUrl":this.gridUrl,
            "data":this.data,
            "columns":columns,
            "model":model
        };

        switch (this.viewType) {
            case 0:

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
                gridDataObject.controlId = this.gridId;
                gridDataObject.addLinkInfo = addLinkInfo;
                gridDataObject.updateLinkInfo = updateLinkInfo;

                return gridDataObject;

            case 1:

                var addLinkInfo = {
                    "text":"Save",
                    "link":this.centralPage,
                    "commandId":'branchAdd',
                    "targetControlId":this.codeCommand,
                    "callback":function () {
                        saveForm();
                    }
                };

                var updateLinkInfo = {
                    "text":"Update",
                    "link":this.editPage
                };

                gridDataObject.model = infoModel;
                gridDataObject.columns = infoColumns;
                gridDataObject.gridUrl = this.gridInfoUrl;
                gridDataObject.controlId = this.gridId;
                gridDataObject.appearance = globalCoreGridAppearanceToobarCreateCancel;
                gridDataObject.editorMode = "Insert";
                gridDataObject.addLinkInfo = addLinkInfo;
                gridDataObject.updateLinkInfo = updateLinkInfo;

                return gridDataObject;

            case 2:

                var transport = {
                    read:{
                        url:gridUrl + "/listByRefEntity?id=" + this.valueData,
                        dataType:"json"
                    },
                    update:{
                        url:gridUrl + "/saveOrUpdate",
                        dataType:"json"
                    },
                    destroy:{
                        url:gridUrl + "/delete",
                        dataType:"json"
                    },
                    createMessageBox:{
                        url:gridUrl + "/add",
                        dataType:"json"
                    }
                };

                var addLinkInfo =
                {
                    "text":"Save",
                    "link":this.centralPage,
                    "commandId":'branchUpdate',
                    "targetControlId":this.codeCommand,
                    "callback":function () {
                        updateBranch();
                    }
                };

                var updateLinkInfo = {
                    "text":"Update",
                    "link":this.editPage
                };

                var transport = {
                    read:{
                        url:gridUrl + "/listByRefEntity?id=" + this.valueData,
                        dataType:"json"
                    },
                    update:{
                        url:gridUrl + "/saveOrUpdate",
                        dataType:"json"
                    },
                    destroy:{
                        url:gridUrl + "/delete",
                        dataType:"json"
                    },
                    createMessageBox:{
                        url:gridUrl + "/add",
                        dataType:"json"
                    }
                };

                gridDataObject.model = infoModel;
                gridDataObject.columns = infoColumns;
                gridDataObject.gridUrl = this.gridInfoUrl;
                gridDataObject.controlId = this.gridId;
                gridDataObject.appearance = globalCoreGridAppearanceToobarCreateCancel;
                gridDataObject.editorMode = "Edit";
                gridDataObject.addLinkInfo = addLinkInfo;
                gridDataObject.updateLinkInfo = updateLinkInfo;
                gridDataObject.transport = transport;
                gridDataObject.valueData = this.valueData;

                return gridDataObject;
        }
        return gridDataObject;
    }

    function goToAdd() {
        preparePageForLoading("branchAdd.jsp");
    }

    function saveForm() {
        var isValid = $("#" + "branchForm").validationEngine('validate');

        if (!isValid)
            return;

        if ($("#" + "branchForm").validationEngine('validate'));
        {
            var branchInfoData = [];

            var grid = $("#" + "gridBranch").data("kendoGrid").dataSource.data();
            $.each(grid, function (i, dataItem) {
                var branchInfo = new BranchInfo();
                branchInfo.type = dataItem.type;
                branchInfo.value = dataItem.value;
                branchInfo.description = dataItem.description;
                branchInfo.category = dataItem.category;
                branchInfo.Description = undefined;
                branchInfoData.push(branchInfo);
            });

            var branch = new Branch();

            branch.companyId = globalCurrentCompanyId;

            branch.branchCode = $("#BranchCode").val();
            branch.branchName = $("#BranchName").val();
            branch.description = $("#Description").val();
            branch.enabled = $('#Enabled').is(":checked");
            branch.branchInfo = branchInfoData;

            // Warning : You have to use the following to refer to a request
            // url; additional parsing will not work;
            var ajaxCore = new AjaxCore();

            var request = ajaxCore.sendRequestType(globalHostname + "/app/Core/Branch/add", branch, "post");

            request.success(function (data, status, xhrObj) {
                preparePageForLoading("branch.jsp");
            });
        }
    }

    function updateBranch() {
        var isValid = $("#" + "branchForm").validationEngine('validate');

        if (!isValid)
            return;

        if (isValid) {
            var branchInfoData = [];
            var grid = $("#gridBranch").data("kendoGrid").dataSource.data();

            $.each(grid, function (i, dataItem) {
                var branchInfo = new BranchInfo();
                branchInfo.type = dataItem.type;
                branchInfo.value = dataItem.value;
                branchInfo.description = dataItem.description;
                branchInfo.category = dataItem.category;
                branchInfoData.push(branchInfo);
            });

            var branch = new Branch();
            branch.nid = $("#Nid").val();
            branch.branchCode = $("#BranchCode").val();
            branch.branchName = $("#BranchName").val();

            branch.description = $("#Description").val();
            branch.enabled = $('#Enabled').is(":checked");
            branch.branchInfo = branchInfoData;

            // Warning : You have to use the following to refer to a request
            // url; additional parsing will not work;
            var ajaxCore = new AjaxCore();
            var request = ajaxCore.sendRequestType(globalHostname + "/app/Core/Branch/saveOrUpdate", branch, "post");

            request.success(function (data, status, xhrObj) {
                preparePageForLoading("branch.jsp");
            });
        }
    }
}