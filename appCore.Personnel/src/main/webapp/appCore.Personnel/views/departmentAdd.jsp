    <script type="text/javascript">

        var gridUrl = globalHostname + "/app/Core/DepartmentInfo";
        var departmentPage = "department.jsp";

        var model = {
        id : "nid",
        fields:
        {
        nid: { editable: false },
        type: { type: "string" },
        value : { validation: { required: true } },
        description: { type: "string" },
        category: { validation: { required: true } }
        }
        };


        var columns = { columns : [
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
        "text" : "Add",
        "link" : departmentPage,
        "commandId" : 'departmentAdd',
        "targetControlId" : "#departmentCommand",
        "callback" : function() { saveForm(); }
        };

        var updateLinkInfo = {
        "text" : "Update",
        "link" : departmentPage
        };

        var gridId = "gridDepartment";
        var formName = "departmentform";

        $(document).ready(function()
        {
        $("#" + formName).validationEngine();

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

        var input = { "id" : coreDepartmentPage, "roleId" : 1 };
        var coreCommand = new CoreCommand();
        coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);

        $(".cancelCommand").click(function()
        {
        var result = cancelFormChanges();
        if (result)
        preparePageForLoading(departmentPage);
        });
        });

        function saveForm()
        {
        var isValid = $("#" + formName).validationEngine('validate');

        if (!isValid)
        return;

        if ($("#" + formName).validationEngine('validate'));
        {

        var departmentInfoData = [];

        var grid = $("#" + gridId).data("kendoGrid").dataSource.data();
        $.each(grid, function (i, dataItem)
        {
        var departmentInfo = new DepartmentInfo();
        departmentInfo.type = dataItem.type;
        departmentInfo.value = dataItem.value;
        departmentInfo.description = dataItem.description;
        departmentInfo.category = dataItem.category;
        departmentInfoData.push(departmentInfo);
        });

        var department = new Department();
        department.departmentCode = $("#DepartmentCode").val();
        department.departmentName = $("#DepartmentName").val();
        department.remark = $("#Remark").val();
        department.enabled = $('#Enabled').is(":checked");
        department.departmentInfo = departmentInfoData;

        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestType(globalHostname + "/app/Core/Department/add", department, "post");

        request.success(function(data, status, xhrObj)
        {
        preparePageForLoading(departmentPage);
        });
        }
        }


        </script>

        <form id="departmentform">

        <div class="form">

        <div class="sectionalForm">
        <div class="leftSection">
        <div class="labelSection">Department Code</div><span class='req'>*</span><div class="inputSection"><input
        type="text" id="DepartmentCode" class="validate[required, maxSize[10]]" value="DepartmentCode"/></div>
        </div>

        <div class="rightSection">
        <div class="inlineLabelSection">Disabled</div><div class="inlineLabelSection"><input type="checkbox"
        id="Enabled" value="Disabled"/></div>
        </div>
        </div>

        <div class="formRow">
        <div class="labelSection">Department Name</div><span class='req'>*</span><div class="inputSection"><input
        type="text" class="validate[required, maxSize[20]]" id="DepartmentName" value="DepartmentName"/></div>
        </div>

        <div class="formRow">
        <div class="labelSection">Description</div><span class='req'>*</span><div class="inputSection"><input
        type="text" id="Description" class="validate[smaxSize[80]]" value="Description"/></div>
        </div>

        <div> <div class="maintenanceCommandSpace"></div>
        <div id="departmentCommand" class="maintenanceCommand">
        </div>
        </div>

        <div>&nbsp;</div>

        <div>
        <div> Department Info </div>
        <div id="gridDepartment" style="height: 380px"></div>
        </div>
        </div>
        </form>

