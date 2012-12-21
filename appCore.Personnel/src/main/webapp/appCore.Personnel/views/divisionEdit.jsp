    <script type="text/javascript">

        var gridUrl = globalHostname + "/app/Core/DivisionInfo";
        var divisionForm = "divisionForm";
        var divisionPage = "division.jsp";
        var divisionGrid = "gridDivision";

        $(document).ready(function()
        {

        $("#" + divisionForm).validationEngine();
        var value = globalCurrentId.nid;

        if (value != null)
        {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequest(globalHostname + "/app/Core/Division/get", { id : value }, "get");

        request.done(function(data)
        {
        if (data == null)
        return;

        $("#Nid").val(data.nid);
        $("#DivisionCode").val(data.divisionCode);
        $("#DivisionName").val(data.divisionName);
        $("#Description").val(data.description);
        $("#Enabled").attr("checked", data.enabled);

        var grid = $("#" + divisionGrid).kendoGrid({
        dataSource: {

        transport: {
        read: {
        url : gridUrl + "/listByRefEntity?id=" + value,
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
        saveDivisionForm();
        });

        $("#cancelBtn").click(function()
        {
        var result = cancelFormChanges();
        if (result)
        preparePageForLoading(divisionPage);
        });
        });

        function saveDivisionForm()
        {
        var divisionInfoData = [];

        var grid = $("#" + divisionGrid).data("kendoGrid").dataSource.data();
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

        division.nid = $("#Nid").val();
        division.divisionCode = $("#DivisionCode").val();
        division.divisionName = $("#DivisionName").val();
        division.description = $("#Description").val();
        division.enabled = $('#Enabled').is(":checked");
        division.divisionInfo = divisionInfoData;

        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestType(globalHostname + "/app/Core/Division/saveOrUpdate", division, "post");

        request.done(function(data, status, xhrObj)
        {
        goHome();
        });
        }

        function goHome()
        {
        preparePageForLoading(divisionPage);
        }


        </script>

        <form id="divisionForm">

        <div class="form">

        <div class="sectionalForm">
        <div class="leftSection"><input type="hidden" id="Nid" name="Nid" />
        <div class="labelSection">Division Code</div><div class="inputSection"><input type="text" id="DivisionCode"
        value="DivisionCode"/></div>
        </div>

        <div class="rightSection">
        <div class="inlineLabelSection">Disabled</div><div class="inlineLabelSection"><input type="checkbox"
        id="Enabled" value="Disabled"/></div>
        </div>
        </div>

        <div class="formRow">
        <div class="labelSection">Division Name</div><div class="inputSection"><input type="text" id="DivisionName"
        value="DivisionName"/></div>
        </div>

        <div class="formRow">
        <div class="labelSection">Description</div><div class="inputSection"><input type="text" id="Description"
        value="Description"/></div>
        </div>

        <div>
        <div class="command"><button type="button" id="saveBtn">Save</button>
        <button type="button" id="cancelBtn">Cancel</button>
        </div>
        </div>

        <div>&nbsp;</div>

        <div>
        <div> Division Info </div>
        <div id="gridDivision" style="height: 380px"></div>
        </div>

        </div>
        </form>