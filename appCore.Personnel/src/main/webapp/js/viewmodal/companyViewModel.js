var CompanyViewModel = function (gridUrl, dataSource, globalVM) {

    var self = this;
    self.gridUrl = gridUrl;
    self.data = dataSource;
    self.globalVM = globalVM;
    self.gridData = ko.observableArray(dataSource);

    var viewColumns = [
        { headerText:"Company Code", rowText:"companyCode" },
        { headerText:"Company Name", rowText:"companyName" },
        { headerText:"Address", rowText:"address" },
        { headerText:"Country", rowText:"country" }

    ];


    var model = {
        id:"nid",
        fields:{
            nid:{ editable:false },
            companyCode:{ editable:false, validation:{ required:true } },
            companyName:{ editable:false, type:"string", validation:{ required:true } },
            address:{ editable:false, type:"string" },
            country:{ editable:false, type:"string" }
        }
    };

    var columns = {
        "columns":[
            {
                field:"companyCode",
                width:90,
                title:"Company Code"
            },
            {
                field:"companyName",
                width:90,
                title:"Company Name"
            },
            {
                field:"address",
                width:90,
                title:"Address"
            },
            {
                field:"country",
                width:90,
                title:"Country"
            }
        ]};

    var addLinkInfo = {
        "text":"Add New Company",
        "link":"companyAdd.jsp",
        "callback":function () {
            var helper = new EmployeeHelper();
            helper.resetTargetIdNull(self.globalVM);
            preparePageForLoading("companyAdd.jsp");
        }
    };

    var updateLinkInfo = {
        "text":"Update",
        "link":"companyAdd.jsp"
    };

    function updateFunction(data) {
        var helper = new EmployeeHelper();
        helper.setCompanyEditMode(self.globalVM, data.nid);
        preparePageForLoading("companyAdd.jsp");
    }

    function deleteFunction(data) {
        var helper = new CompanyHelper();
        var result = helper.deleteCompany(data.nid);
        self.gridData.remove(data);
    }

    this.getView = function () {

        var gridDataObject =
        {
            "gridUrl":self.gridUrl,
            "data":self.data,
            "gridData":self.gridData,
            "viewColumns":viewColumns,
            "updateFunction":updateFunction,
            "deleteFunction":deleteFunction,
            "columns":columns,
            "model":model,
            "addLinkInfo":addLinkInfo,
            "updateLinkInfo":updateLinkInfo
        };

        return gridDataObject;
    }
}