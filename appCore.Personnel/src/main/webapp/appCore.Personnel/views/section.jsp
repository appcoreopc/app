    <script type="text/javascript">

        var gridUrl = globalHostname + "/app/Core/Section";

        var model = {
        id: "nid",
        fields: {
        nid: { editable: false },
        sectionCode: { editable: false, validation: { required: true } },
        sectionName: { editable: false, type: "string", validation: { required: true } },
        remark: { editable: false, type: "string" },
        enabled: { editable: false, type: "number" }
        }
        };

        var columns = { columns: [
        {
        field: "sectionCode",
        width: 90,
        title: "Section Code"
        },
        {
        field: "sectionName",
        width: 90,
        title: "Section Name"
        },
        {
        field: "remark",
        width: 90,
        title: "Remark"
        },
        {
        field: "enabled",
        width: 90,
        title: "Disabled"
        }
        ]};

        var addLinkInfo = {
        "text" : "Add New Section",
        "link" : "sectionAdd.jsp",
        "callback" : function() { goToAdd(); }
        };

        var updateLinkInfo = {
        "text" : "Update",
        "link" : "sectionEdit.jsp"
        };


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

        var input = { "id" : coreSectionPage, "roleId" : 1 };
        var coreCommand = new CoreCommand();
        coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);
        });
        });

        function goToAdd()
        {
            preparePageForLoading("sectionAdd.jsp");
        }


        </script>

        <div class="forms">
        <h1>Section </h1>

        <div class="viewData">
        <div class="maintenanceCommand">
        </div>
        </div>

        <div>

        <div id="grid" style="height: 380px"></div>

        </div>
        </div>
