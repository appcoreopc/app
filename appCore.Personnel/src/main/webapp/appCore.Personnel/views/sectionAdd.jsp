<script type="text/javascript">          

    var gridUrl = globalHostname + "/app/Core/SectionInfo";
	var sectionPage = "section.jsp";
	
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
				"link" : sectionPage, 
				"commandId" : 'sectionAdd', 
				"targetControlId" : "#sectionCommand",
				"callback" : function() { saveForm();}
		};				
			
		var updateLinkInfo = { 
			    "text" : "Update", 
				"link" : "sectionEdit.jsp"
		};
	
		var formName = "sectionForm	";
		var gridId = "gridSection";
		
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
					   preparePageForLoading(sectionPage);
			});
 	});

	function saveForm()
	{
	
		var isValid = $("#" + formName).validationEngine('validate'); 
	
		if (!isValid) 
		   return; 
		
		if ($("#" + formName).validationEngine('validate'));
		{
			var sectionInfoData = [];
		
			var grid = $("#" + gridId).data("kendoGrid").dataSource.data();
			$.each(grid, function (i, dataItem) 
			{
				var sectionInfo = new SectionInfo(); 
				sectionInfo.type = dataItem.type; 
				sectionInfo.value = dataItem.value;
				sectionInfo.description = dataItem.description;
				sectionInfo.category = dataItem.category;
				sectionInfoData.push(sectionInfo);
			});
				
			var section = new Section(); 
			section.sectionCode = $("#SectionCode").val(); 
			section.sectionName = $("#SectionName").val(); 
			section.remark = $("#Remark").val(); 
			section.enabled = $('#Enabled').is(":checked"); 
			section.sectionInfo = sectionInfoData; 		
					
			var ajaxCore = new AjaxCore(); 
			var request = ajaxCore.sendRequestType(globalHostname + "/app/Core/Section/add", section, "post");
			
			request.success(function(data, status, xhrObj)
			{
				preparePageForLoading(sectionPage);
			});
		}
	}
	
</script>    

<form id="sectionForm">

<div class="form">
	
  <div class="sectionalForm"> 
   <div class="leftSection">
	<div class="labelSection">Section Code</div><span class='req'>*</span><div class="inputSection"><input type="text" id="SectionCode" class="validate[required, maxSize[10]]" value="SectionCode"/></div>
   </div> 
	
	<div class="rightSection">
		<div class="inlineLabelSection">Disabled</div><div class="inlineLabelSection"><input type="checkbox" id="Enabled" /></div>
	</div>
  </div>
	
    <div class="formRow">
		<div class="labelSection">Section Name</div><span class='req'>*</span><div class="inputSection"><input type="text" id="SectionName" class="validate[required, maxSize[20]]" value="SectionName"/></div>
    </div>

	<div class="formRow">
		<div class="labelSection">Remark</div><span class="fieldSpacer"></span><div class="inputSection"><input type="text" id="Remark" value="remark" class="validate[required, maxSize[80]]" /></div>
	</div>

	<div> <div class="maintenanceCommandSpace"></div>
		<div id="sectionCommand" class="maintenanceCommand">
		</div>
	</div>
   
   <div>&nbsp;
   </div>
  
    <div>
	 <div> Section Info  </div>
		<div id="gridSection" style="height: 380px"></div>
	</div>
</div>

</form> 