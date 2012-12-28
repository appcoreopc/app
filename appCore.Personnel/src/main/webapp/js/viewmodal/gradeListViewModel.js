var GradeListViewModel = function (initView, data, globalViewModel) {

    mode = initView;
    this.gridUrl = globalHostname + "/app/Core/Branch";
    this.codeCommand = "#codeCommand";
    this.gridId = "gridBranch";

    this.data = data;
    self.gridData = ko.observableArray(data);

    self.globalViewModel = globalViewModel;

    var viewColumns = [
        { headerText:"Grade Code", rowText:"code" },
        { headerText:"Description", rowText:"description" },
        { headerText:"Category", rowText:"category" },
        { headerText:"Probation", rowText:"probationMonth" }
    ];

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

    function getView() {
        var gridDataObject =
        {
            "gridUrl":this.gridUrl,
            "data":this.data,
            "columns":columns,
            "model":model
        };

        switch (mode) {
            case 0:
                var addLinkInfo = {
                    "text":"Add Grade",
                    "commandId":'gradeAdd',
                    "callback":function () {
                        goToAdd()
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
        }
        return gridDataObject;
    }

    self.initializeViewModel = function ()
    {
        var gridDataObject = getView();
        var input = { "id":coreGradePage, "roleId": globalViewModel.employeeRole() };
        var coreCommand = new CoreCommand();

        var gridViewModel = coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);
        self.gridViewModel = gridViewModel;
    }

    function deleteFunction(data) {
        var dialog = new CoreDialog();
        var helper = new EmployeeHelper();
        var dialogObject = helper.createDialogObject("Delete record", "Do you want to remove this record?");
        var result = dialog.createConfirmationDialog(dialogObject, data, globalViewModel, null, deleteCallBack);
    }

    function deleteCallBack(status, data, globalViewModel, codeType) {
        if (status == true) {
            var helper = new CompanyHelper();
            var result = helper.deleteGrade(data, successDeleteCallback);
        }
    }

    function successDeleteCallback(result, data) {
        if (result.messageCode == 0) {
            self.gridData.remove(data);
        }
    }

    function updateFunction(data) {
        globalViewModel.targetId(data.nid);
        globalViewModel.editMode(coreModeEdit);
        globalViewModel.applicationScopeType(coreApplicationTypeGradeType);
        preparePageForLoading("gradeAdd.jsp");
    }

    function goToAdd() {
        globalViewModel.applicationScopeType(coreApplicationTypeGradeType);
        globalViewModel.editMode(coreModeInsert);
        preparePageForLoading("gradeAdd.jsp");
    }

    self.initializeViewModel();
}