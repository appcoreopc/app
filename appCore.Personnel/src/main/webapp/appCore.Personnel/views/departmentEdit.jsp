    <script type="text/javascript">

        var departmentForm = "departmentForm";
        var departmentPage = "department.jsp";
        var departmentGrid = "departmentGrid";

        $(document).ready(function()
        {

        $("#" + departmentForm).validationEngine();

        var value = globalCurrentId.nid;

        if (value != null)
        {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequest(globalHostname + "/app/Core/Department/get", { id : value}, "get");

        request.success(function(data)
        {
        if (data == null)
        return;

        $("#Nid").val(data.nid);
        $("#DepartmentCode").val(data.departmentCode);
        $("#DepartmentName").val(data.departmentName);
        $("#Remark").val(data.remark);
        $("#Enabled").attr("checked", data.enabled);

        var grid = $("#" + departmentGrid).kendoGrid({
        dataSource: {

        transport: {
        read: {
        url: globalHostname + "/app/Core/DepartmentInfo/listByRefEntity?id=" + value,
        dataType: "json"
        },
        update: {
        url: globalHostname + "/app/Core/DepartmentInfo/saveOrUpdate",
        dataType: "json"
        },
        destroy: {
        url: globalHostname + "/app/Core/DepartmentInfo/delete",
        dataType: "json"
        },
        createMessageBox: {
        url: globalHostname + "/app/Core/DepartmentInfo/add",
        dataType: "json"
        }
        },

        data: data,
        pageSize: 10,
        schema: {
        model: {
        id: "nid",
        fields: {
        nid: { editable: false },
        type: { type: "string" },
        value : { validation: { required: true } },
        description: { type: "string" },
        category: { validation: { required: true } }
        }
        }
        }

        },
        toolbar: ["create", "cancel"],
        editable : true,
        groupable: false,
        selectable : true,
        sortable: true,
        pageable: true,
        columns: [
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
        },
        {
        command : "destroy", title : "", width: 110
        }
        ],

        remove : function(e)
        {
        $.ajax({
        url: globalHostname + "/app/Core/DepartmentInfo/delete",
        data: {"id": e.model.nid},
        type : "get",
        dataType : "json"
        });
        }
        });
        }
        );
        }

        $("#saveBtn").click(function()
        {
        getValidateData();
        });

        $("#cancelBtn").click(function()
        {
        var result = cancelFormChanges();
        if (result)
        preparePageForLoading(departmentPage);
        });
        });


        function getValidateData()
        {
        var departmentInfoData = [];

        var grid = $("#" + departmentGrid).data("kendoGrid").dataSource.data();

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

        department.nid = $("#Nid").val();
        department.departmentCode = $("#DepartmentCode").val();
        department.departmentName = $("#DepartmentName").val();
        department.remark = $("#Remark").val();
        department.enabled = $('#Enabled').is(":checked");
        department.departmentInfo = departmentInfoData;

        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestType(globalHostname + "/app/Core/Department/saveOrUpdate", department,
        "post");

        request.success(function(data, status, xhrObj)
        {
        goHome();
        });
        }

        function goHome()
        {
        preparePageForLoading(departmentPage);
        }


        </script>

        <form id="departmentForm">

        <div class="form">

        <h1>Department</h1>
        <div class="formRow">

        </div>

        <div class="sectionalForm">
        <div class="leftSection"> <input type="hidden" id="Nid" name="Nid" />
        <div class="labelSection">Department Code</div><div class="inputSection"><input type="text" id="DepartmentCode"
        value="DepartmentCode"/></div>
        </div>

        <div class="rightSection">
        <div class="inlineLabelSection">Disabled</div><div class="inlineLabelSection"><input type="checkbox"
        id="Enabled" value="Disabled"/></div>
        </div>
        </div>

        <div class="formRow">
        <div class="labelSection">Department Name</div><div class="inputSection"><input type="text" id="DepartmentName"
        value="DepartmentName"/></div>
        </div>

        <div class="formRow">
        <div class="labelSection">Remark</div><div class="inputSection"><input type="text" id="Remark"
        value="Remark"/></div>
        </div>
        <div class="formRow">
        &nbsp;
        </div>

        <div>
        <div class="command">
        <button type="button" id="saveBtn">Save changes</button>
        <button type="button" id="cancelBtn">Cancel</button>
        </div>
        </div>
        <div class="formRow">
        &nbsp;
        </div>


        <div>
        <div id="departmentGrid" style="height: 380px"></div>
        </div>
        </div>
        </form>