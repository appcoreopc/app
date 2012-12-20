    <script type="text/javascript">

        var gridUrl = globalHostname + "/app/Core/DivisionInfo";
        var divisionPage = "division.jsp";

        var model = {
        id: "nid",
        fields: {
        nid: { editable: false },
        type: { type: "string" },
        value : { validation: { required: true } },
        description: { type: "string" },
        category: { validation: { required: true } }
        }
        };

        var columns = {
        columns :
        [
        {
        field: "type",
        width: 90,
        title: "Type"
        },
        {
        field: "value",
        width: 90,
        title: "Value"
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
        }
        ]};

        var addLinkInfo = {
        "text" : "Save",
        "link" : divisionPage,
        "commandId" : 'divisionAdd',
        "targetControlId" : "#divisionCommand",
        "callback" : function()
        {
                saveForm();
        }
        };

        var updateLinkInfo = {
        "text" : "Update",
        "link" : "divisionEdit.jsp"
        };

        var gridId = "gridDivision";
        var formName = "divisionForm";

        $(document).ready(function()
        {
        $("#" + formName).validationEngine({});

        var gridDataObject =
        {
        "gridUrl" : gridUrl,
        "columns" : columns,
        "model" : model,
        "addLinkInfo" : addLinkInfo,
        "updateLinkInfo" : updateLinkInfo,
        "controlId" : gridId,
        "appearance" : globalCoreGridAppearanceToobarCreateCancel,
        "editorMode" : "Insert"
        };

        var input = { "id" : coreDivisionPage, "roleId" : 1 };
        var coreCommand = new CoreCommand();
        coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);

        $(".cancelCommand").click(function()
        {
        var result = cancelFormChanges();
        if (result)
        preparePageForLoading(divisionPage);
        });
        });

        function saveForm()
        {
        var isValid = $("#" + formName).validationEngine('validate');

        if (!isValid)
        return;

        if ($("#" + formName).validationEngine('validate'));
        {
        var divisionInfoData = [];

        var grid = $("#" + gridId).data("kendoGrid").dataSource.data();
        $.each(grid, function (i, dataItem)
        {
        var divisionInfo = new DivisionInfo();
        divisionInfo.type = dataItem.type;
        divisionInfo.value = dataItem.value;
        divisionInfo.description = dataItem.description;
        divisionInfo.category = dataItem.category;
        divisionInfoData.push(divisionInfo);
        });

        var division = new Division();
        division.divisionCode = $("#DivisionCode").val();
        division.divisionName = $("#DivisionName").val();
        division.description = $("#Description").val();
        division.enabled = $('#Enabled').is(":checked");
        division.divisionInfo = divisionInfoData;

        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestType(globalHostname + "/app/Core/Division/add", division, "post");

        request.success(function(data, status, xhrObj)
        {
        preparePageForLoading(divisionPage);
        });
        }
        }


        </script>

        <form id="divisionForm">

        <div class="form">

        <div class="sectionalForm">
        <div class="leftSection">
        <div class="labelSection">Division Code</div><span class='req'>*</span><div class="inputSection"><input
        type="text" id="DivisionCode" class="validate[required, maxSize[10]]" value="DivisionCode"/></div>
        </div>

        <div class="rightSection">
        <div class="inlineLabelSection">Disabled</div><div class="inlineLabelSection"><input type="checkbox"
        id="Enabled" value="Disabled"/></div>
        </div>
        </div>

        <div class="formRow">
        <div class="labelSection">Division Name</div><span class='req'>*</span><div class="inputSection"><input
        type="text" id="DivisionName" class="validate[required, maxSize[20]]" value="DivisionNames"/></div>
        </div>

        <div class="formRow">
        <div class="labelSection">Description</div><span class='req'>*</span><div class="inputSection"><input
        type="text" id="Description" class="validate[required, maxSize[80]]" value="Description"/></div>
        </div>

        <div> <div class="maintenanceCommandSpace"></div>
        <div class="maintenanceCommand" id="divisionCommand">
        </div>
        </div>

        <div>&nbsp;</div>

        <div>
        <div> Division Info </div>
        <div id="gridDivision" style="height: 380px"></div>
        </div>
        </div>

        </form>