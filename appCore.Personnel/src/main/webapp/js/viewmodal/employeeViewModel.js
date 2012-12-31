var EmployeeViewModel = function (initView, globalViewModel, data) {

    var self = this;
    self.mode = initView;
    self.centralPage = "employeeAdd.jsp";
    self.editPage = "employeeAdd.jsp";
    self.addPage = "branchAdd.jsp";
    self.branchForm = "branchForm";
    self.gridUrl = globalEmployeeUrl;
    self.codeCommand = "#codeCommand";
    self.gridId = "gridBranch";

    this.data = null;

    self.gridData = ko.observableArray(data);
    self.globalViewModel = globalViewModel;

    self.enableAdd = ko.observable();
    self.enableUpdate = ko.observable();
    self.enableDelete = ko.observable();

    var viewColumns = [
        { headerText:"Employee Code", rowText:"code" },
        { headerText:"Employee Name", rowText:"name" },
        { headerText:"Gender", rowText:"gender" },
        { headerText:"Age", rowText:"age" }
    ];

    var model =
    {
        id:"nid",
        fields:{
            nid:{ editable:false },
            code:{ editable:false, type:"string" },
            name:{ editable:false, validation:{ required:true } },
            gender:{ editable:false, type:"string" },
            age:{ editable:false, validation:{ required:true } }
        }
    };

    var columns = { "columns":[
        {
            field:"code",
            width:90,
            title:"Code"
        },
        {
            field:"name",
            width:90,
            title:"Name"
        },
        {
            field:"gender",
            width:90,
            title:"Gender"
        },
        {
            field:"age",
            width:90,
            title:"Age"
        }
    ]};

    function goToAdd() {
        globalViewModel.targetId(null);
        globalViewModel.editMode(coreModeInsert);
        globalViewModel.applicationScopeType(coreApplicationTypeEmployee);
        preparePageForLoading("employeeGeneralInfoView.jsp");
    }

    function updateFunction(data) {

        globalViewModel.targetId(data.nid);
        globalViewModel.editMode(coreModeEdit);
        globalViewModel.applicationScopeType(coreApplicationTypeEmployee);
        preparePageForLoading("employeeAdd.jsp");
    }

    function deleteFunction(data) {
        var dialog = new CoreDialog();
        var helper = new EmployeeHelper();
        var dialogObject = helper.createDialogObject("Delete record", "Do you want to remove this record?");
        var result = dialog.createConfirmationDialog(dialogObject, data, globalViewModel, null, deleteCallBack);
    }

    function deleteCallBack(status, data, globalViewModel, codeType) {
        if (status == true) {
            var helper = new EmployeeHelper();
            var result = helper.deleteEmployee(data, successDeleteCallback);
        }
    }

    function successDeleteCallback(result, data) {
        if (result.messageCode == 0) {
            self.gridData.remove(data);
        }
    }

    self.getListView = function (companyId) {
        return generateEmployeeGrid(companyId);
    }

    function generateEmployeeGrid(companyId) {
        var gridMetaData =
        {
            "gridUrl":globalEmployeeUrl,
            "data":self.gridData,
            "columns":columns,
            "model":model
        };

        var addLinkInfo = {
            "text":"Add Employee",
            "commandId":'employeeAdd',
            "link":this.addPage,
            "callback":function () {
                goToAdd();
            }
        };

        var updateLinkInfo = {
            "text":"Update",
            "link":"employeeAdd.jsp"
        };

        gridMetaData.controlId = "employeeListViewGrid";
        gridMetaData.addLinkInfo = addLinkInfo;
        gridMetaData.updateLinkInfo = updateLinkInfo;
        gridMetaData.gridData = self.gridData;
        gridMetaData.viewColumns = viewColumns;
        gridMetaData.updateFunction = updateFunction;
        gridMetaData.deleteFunction = deleteFunction;
        return gridMetaData;
    }

    self.initializeViewModel = function () {

        var gridDataObject = self.getListView();
        var input = { "id":coreEmployeePage, "roleId":globalViewModel.employeeRole() };
        var coreCommand = new CoreCommand();

        var gridViewModel = coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);
        var permissionResult = coreCommand.getPermission(hostAuthorizationUrl, input);

        self.gridViewModel = gridViewModel;

        var helper = new EmployeeHelper();
        self.enableAdd(helper.getEnableAdd(permissionResult.permission));
        self.enableUpdate(helper.getEnableUpdate(permissionResult.permission));
        self.enableDelete(helper.getEnableDelete(permissionResult.permission));

    }

    self.initializeViewModel();
}