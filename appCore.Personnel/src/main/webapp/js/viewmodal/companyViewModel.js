var CompanyViewModel = function (gridUrl, dataSource) {

    this.gridUrl = gridUrl;
    this.data = dataSource;

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
            preparePageForLoading("companyAdd.jsp");
        }
    };

    var updateLinkInfo = {
        "text":"Update",
        "link":"companyAdd.jsp"
        //"link":"companyEdit.jsp"
    };

    this.getView = function () {
        var gridDataObject =
        {
            "gridUrl":this.gridUrl,
            "data":this.data,
            "columns":columns,
            "model":model,
            "addLinkInfo":addLinkInfo,
            "updateLinkInfo":updateLinkInfo
        };
        return gridDataObject;
    }
}