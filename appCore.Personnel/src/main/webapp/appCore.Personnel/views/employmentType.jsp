    <script type="text/javascript">

        var employmentTypePage = "employmentType.jsp";

        var model = {
        id: "nid",
        fields:
        {
        nid: { editable: false },
        code: { editable: false, validation: { required: true } },
        description : { editable: false, type: "string", validation: { required: true } },
        category: { editable: false, type: "string" },
        disabled : { editable: false, type: "boolean" }
        }
        };

        var columns = {
        columns :[
        {
        field: "code",
        width: 90,
        title: "Code"
        },
        {
        field: "description",
        width: 90,
        title: "Description"
        },
        {
        field: "category",
        width: 90,
        title: "Category"
        },
        {
        field: "disabled",
        width: 90,
        title: "Disabled"
        }
        ]};

        var addLinkInfo = {
        "text" : "Add Employment Type",
        "link" : "employmentTypeAdd.jsp",
        "callback" : gotoPage.toString()
        };

        var updateLinkInfo = {
        "text" : "Update",
        "link" : "employmentTypeEdit.jsp"
        };

        var gridUrl = globalHostname + "/app/Core/Job/EmploymentType";

        $(document).ready(function()
        {
        var ajaxCore = new AjaxCore();
        request = ajaxCore.sendRequest(gridUrl + "/list", null, "get");

        request.success(function(data)
        {
        var gridDataObject =
        {
        "gridUrl" : gridUrl,
        "data" : data,
        "columns" : columns,
        "model" : model,
        "addLinkInfo" : addLinkInfo,
        "updateLinkInfo" : updateLinkInfo
        };

        var input = { "id" : coreEmploymentTypePage, "roleId" : 1 };
        var coreCommand = new CoreCommand();
        coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);
        });
        });

        function gotoPage()
        {
        preparePageForLoading("employmentTypeAdd.jsp");
        }

        </script>

        <div class="form">
        <h1>Employment Type </h1>

        <div class="viewData">
            <div class="maintenanceCommand">
            </div>
        </div>

        <div>
            <div id="grid" style="height: 380px"></div>
            </div>
        </div>