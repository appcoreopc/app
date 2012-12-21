    <script type="text/javascript">

        var gridUrl = globalHostname + "/app/Core/UnitInfo";

        var unitForm = "unitForm";
        var unitPage = "unit.jsp";
        var unitGrid = "unitGrid";

        $(document).ready(function()
        {
        $("#" + unitForm).validationEngine();

        var value = globalCurrentId.nid;

        if (value != null)
        {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequest(globalHostname + "/app/Core/Unit/get", { id : value }, "get");

        request.done(function(data)
        {

        if (data == null)
        return;

        $("#Nid").val(data.nid);
        $("#UnitCode").val(data.unitCode);
        $("#UnitName").val(data.unitName);
        $("#Remark").val(data.remark);
        $("#Enabled").attr("checked", data.enabled);


        var grid = $("#" + unitGrid).kendoGrid({
        dataSource: {

        transport: {
        read: {
        url: gridUrl + "/listByRefEntity?id=" + value,
        dataType: "json"
        },
        update: {
        url: gridUrl + "/saveOrUpdate",
        dataType: "json"
        },
        destroy: {
        url: gridUrl + "/delete",
        dataType: "json"
        },
        createMessageBox: {
        url: gridUrl + "/add",
        dataType: "json"
        }
        },
        data: [],
        pageSize: 10,
        schema: {
        model: {
        ids: "nid",
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
        editable : true,
        toolbar: ["create", "cancel"],
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
        url: gridUrl + "/delete",
        data: {"id": e.model.nid},
        type : "get",
        dataType : "json"
        });
        }

        });
        });
        }

        $("#saveBtn").click(function()
        {
        saveUnitForm();
        });

        $("#cancelBtn").click(function()
        {
        var result = cancelFormChanges();
        if (result)
        preparePageForLoading(unitPage);
        });
        });

        function saveUnitForm()
        {

        var unitInfoData = [];

        var grid = $("#" + unitGrid).data("kendoGrid").dataSource.data();
        $.each(grid, function (i, dataItem)
        {
        var unitInfo = new UnitInfo();
        unitInfo.type = dataItem.type;
        unitInfo.value = dataItem.value;
        unitInfo.description = dataItem.description;
        unitInfo.category = dataItem.category;
        unitInfoData.push(unitInfo);
        });

        var unit = new Unit();
        unit.nid = $("#Nid").val();

        unit.unitCode = $("#UnitCode").val();
        unit.unitName = $("#UnitName").val();
        unit.remark = $("#Remark").val();
        unit.enabled = $('#Enabled').is(":checked");
        unit.unitInfo = unitInfoData;

        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestType(globalHostname + "/app/Core/Unit/saveOrUpdate", unit, "post");

        request.done(function(data, status, xhrObj)
        {
        goHome();
        });
        }

        function goHome()
        {
        preparePageForLoading(unitPage);
        }

        </script>

        <form id="unitForm">

        <div class="form">

        <div class="sectionalForm">
        <div class="leftSection"><input type="hidden" id="Nid" name="Nid" />
        <div class="labelSection">Unit Code</div><div class="inputSection"><input type="text" id="UnitCode"
        value="UnitCode"/></div>
        </div>

        <div class="rightSection">
        <div class="inlineLabelSection">Disabled</div><div class="inlineLabelSection"><input type="checkbox"
        id="Enabled" /></div>
        </div>
        </div>

        <div class="formRow">
        <div class="labelSection">Unit Name</div><div class="inputSection"><input type="text" id="UnitName"
        value="UnitName"/></div>
        </div>

        <div class="formRow">
        <div class="labelSection">Remark</div><div class="inputSection"><input type="text" id="Remark"
        value="remark"/></div>
        </div>

        <div>
        <div class="command"><button type="button" id="saveBtn">Save</button>
        <button type="button" id="cancelBtn">Cancel</button>
        </div>
        </div>

        <div>&nbsp;
        </div>

        <div>
        <div> Unit Info </div>
        <div id="unitGrid" style="height: 380px"></div>
        </div>
        </div>
        </form>