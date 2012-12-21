<script type="text/javascript">          

    var gridUrl = globalHostname + "/app/Core/UnitInfo";
	var unitPage = "unit.jsp"; 
	
	var model =  {
                    id : "nid",
                    fields: {
                                nid: { editable: false },
                                type: {  type: "string" },
                                value : {  validation: { required: true } },
                                description: {  type: "string" },
                                category: {  validation: { required: true } }
                            }
                 };
				 
	var columns = { columns : 
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
			    "text" : "Add", 
				"link" : unitPage, 
				"commandId" : 'unitAdd', 
				"targetControlId" : "#unitCommand",
				"callback" : function() { saveForm(); }
		};				
			
		var updateLinkInfo = { 
			    "text" : "Update", 
				"link" : "unitEdit.jsp"
		};			
		
		var gridId = "gridUnit";
		var formName = "unitForm";
		
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
					
			var input = { "id" : coreSectionPage, "roleId" : 1 };
			var coreCommand = new CoreCommand();
			coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);
				
			$("#saveBtn").click(function()
			{
				saveForm();
			});
			 
			 $(".cancelCommand").click(function()
			 {
				var result = cancelFormChanges();
				if (result) 
				   preparePageForLoading(unitPage);
			 });
		});

	function saveForm()
	{
		var isValid = $("#" + formName).validationEngine('validate'); 
	
		if (!isValid) 
		   return; 
		
		if ($("#" + formName).validationEngine('validate'));
		{
			var unitInfoData = [];
		
			var grid = $("#" + gridId).data("kendoGrid").dataSource.data();
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
			unit.unitCode = $("#UnitCode").val(); 
			unit.unitName = $("#UnitName").val(); 
			unit.remark = $("#Remark").val(); 
			unit.enabled = $('#Enabled').is(":checked"); 
			unit.unitInfo = unitInfoData; 		
					
			var ajaxCore = new AjaxCore(); 
			var request = ajaxCore.sendRequestType(globalHostname + "/app/Core/Unit/add", unit, "post");
			
			request.success(function(data, status, xhrObj)
			{
				preparePageForLoading(unitPage);
			});
		}
	}
	
	
</script>    

<form id="unitForm"> 

<div class="form">
		
  <div class="sectionalForm"> 
   <div class="leftSection">
	<div class="labelSection">Unit Code</div><span class='req'>*</span><div class="inputSection"><input type="text" id="UnitCode" class="validate[required, maxSize[10]]" value="UnitCode"/></div>
   </div> 
	
	<div class="rightSection">
		<div class="inlineLabelSection">Disabled</div><div class="inlineLabelSection"><input type="checkbox" id="Enabled" /></div>
	</div>
  </div>
	
    <div class="formRow">
		<div class="labelSection">Unit Name</div><span class='req'>*</span><div class="inputSection"><input type="text" id="UnitName" class="validate[required, maxSize[20]]" value="UnitName"/></div>
    </div>

	<div class="formRow">
		<div class="labelSection">Remark</div><span class="fieldSpacer"></span><div class="inputSection"><input type="text" id="Remark" value="remark" class="validate[required, maxSize[80]]"/></div>
	</div>

	<div> <div class="maintenanceCommandSpace"></div>
		<div id="unitCommand" class="maintenanceCommand">
		</div>
	</div>
	
   <div>&nbsp;
   </div>
  
    <div>
	 <div> Unit Info  </div>
		<div id="gridUnit" style="height: 380px"></div>
	</div>
</div>
</form>