var EmploymentTypeListViewModel = function (initView, data, globalViewModel) {

    mode = initView;
    this.gridUrl = globalHostname + "/app/Core/Branch";
    this.codeCommand = "#codeCommand";
    this.gridId = "gridBranch";

    this.data = data;

    self.gridData = ko.observableArray(data);

    self.globalViewModel = globalViewModel;

    var viewColumns = [
        { headerText:"Code", rowText:"code" },
        { headerText:"Description", rowText:"description" },
        { headerText:"Category", rowText:"category" },
        { headerText:"Disabled", rowText:"disabled" }
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
                    "text":"Add Employment Type",
                    "commandId":'employmentTypeAdd',
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

    self.initializeViewModel = function () {
        var gridDataObject = getView();
        var input = { "id":coreEmploymentTypePage, "roleId": globalViewModel.employeeRole() };
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
            var result = helper.deleteEmploymentType(data, successDeleteCallback);
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
        globalViewModel.applicationScopeType(coreApplicationTypeEmploymentType);
        preparePageForLoading("employmentTypeAdd.jsp");
    }

    function goToAdd() {
        globalViewModel.applicationScopeType(coreApplicationTypeEmploymentType);
        globalViewModel.editMode(coreModeInsert);
        preparePageForLoading("employmentTypeAdd.jsp");
    }

    self.initializeViewModel();
}