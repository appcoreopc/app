    <script type="text/javascript">

        var model = {
        id: "nid",
        fields: {
        nid: { editable: false },
        holidayDate: { editable: false, type : "date" },
        name: { editable: false, type : "string" },
        recurring : { editable: false, type : "boolean" },
        lastUpdate : { editable: false, type : "string" }

        }
        };

        var columns = { columns : [
        {
        field: "holidayDate",
        width: 90,
        title: "Holiday Date", format : "{0:dd-MMM-yyyy}"
        },
        {
        field: "name",
        width: 90,
        title: "Name"
        },
        {
        field: "recurring",
        width: 90,
        title: "Recurring"
        },
        {
        field: "type",
        width: 90,
        title: "Type", template : '#= getHolidayTypeDisplayText(type) #'
        }
        ]};

        var addLinkInfo = {
        "text" : "Add new holiday",
        "link" : "holidaySetupAdd.jsp",
        "callback" : goToAdd.toString()
        };

        var updateLinkInfo = {
        "text" : "Update",
        "link" : "gradeEdit.jsp"
        };

        $(document).ready(function()
        {
        var gridUrl = globalHostname + "/app/Core/Calendar/Holiday";
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

        var input = { "id" : coreHolidaySetupPage, "roleId" : 1 };
        var coreCommand = new CoreCommand();
        coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);
        });

        $("#setupHolidayBtn").click(function()
        {
        preparePageForLoading("configureHolidayGroup.jsp");
        });
        });

        function goToAdd()
        {
        preparePageForLoading("holidaySetupAdd.jsp");
        }

        function getHolidayTypeDisplayText(dayType)
        {
        if (dayType == 1)
        return "Gazetted";
        else if (dayType == 0)
        return "Non-Gazetted";
        else
        return "Non-Gazetted";
        }

        </script>

        <div class="form">
        <h1>Holiday Setup</h1>

        <div class="viewData">
            <div class="maintenanceCommand">
                <button type="button" id="setupHolidayBtn">Configure Holiday Group</button>
            </div>
        </div>


        <div>
            <div id="grid" style="height: 380px"></div>
        </div>
    </div>
