    <script type="text/javascript">


        var model = {
        id: "nid",
        fields:
        {
        nid: { editable: false },
        code: { editable: false, validation: { required: true } },
        description :
        {
        editable: false, type: "string", validation: { required: true } },
        probationMonth: { editable: false, type: "number" },
        category: { editable: false, type: "string" },
        disabled : { editable: false, type: "boolean" }
        }
        };

        var columns = { columns : [
        {
        field: "code",
        width: 90,
        title: "Grade Code"
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
        field: "probationMonth",
        width: 90,
        title: "Probation (Month)"
        }
        ]};

        var addLinkInfo = {
        "text" : "Add Grade",
        "link" : "gradeAdd.jsp",
        "callback" : goToAdd.toString()
        };

        var updateLinkInfo = {
        "text" : "Update",
        "link" : "gradeEdit.jsp"
        };

        var gridUrl = globalHostname + "/app/Core/Job/Grade";

        $(document).ready(function()
        {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequest(gridUrl + "/list", null, "get");
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

        var input = { "id" : coreGradePage, "roleId" : 1 };
        var coreCommand = new CoreCommand();
        coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);
        });
        });

        function goToAdd()
        {
        preparePageForLoading("gradeAdd.jsp");
        }

        </script>

        <div class="form">
        <h1>Grade </h1>

        <div class="viewData">
        <div class="maintenanceCommand">
        </div>
        </div>

        <div>
        <div id="grid" style="height: 380px"></div>
        </div>
        </div>
