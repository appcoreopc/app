<script type="text/javascript">          

    var gridUrl = globalHostname + "/app/Core/Job/EmploymentTypeInfo";
	
	var model = {
                    ids: "nid",
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
					
			var employmentTypeLink = "employmentType.jsp";
			
			var addLinkInfo = { 
			    "text" : "Save", 
				"link" : employmentTypeLink, 
				"callback" : saveForm.toString()
			};	

		$(document).ready(function() 
		{
			var gridDataObject = 
			{ 
					"gridUrl" : gridUrl,
					"columns" : columns,
					"model" : model, 
					"addLinkInfo" : addLinkInfo, 
					"appearance" : globalCoreGridAppearanceToobarCreateCancel
			}; 
				
			var input = { "id" : coreEmploymentTypePage, "roleId" : 1 };
			var coreCommand = new CoreCommand();
			coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);
		
			 $("#saveBtn").live("click", function(evt)
			 {
				if (evt.handled !== true)
				{ 
					evt.handled = true; 
					saveForm();
				}
			 });
				
		 	 $("#cancelBtn2").live("click", function(evt)
			 {
				if (evt.handled !== true)
				{ 
					evt.handled = true; 
					var result = cancelFormChanges();
					if (result) 
					{
						preparePageForLoading(employmentTypeLink);
					}
				}
			 });
 	});

	function saveForm()
	{
		var employmentTypeInfoData = [];
	
        var grid = $("#grid").data("kendoGrid").dataSource.data();
 		$.each(grid, function (i, dataItem) 
		{
			var employmentTypeInfo = new EmploymentTypeInfo(); 
			employmentTypeInfo.type = dataItem.type; 
			employmentTypeInfo.value = dataItem.value;
			employmentTypeInfo.description = dataItem.description;
			employmentTypeInfo.category = dataItem.category;
			employmentTypeInfoData.push(employmentTypeInfo);
		});
	 		
		var employmentType = new EmploymentType(); 
		employmentType.code = $("#Code").val(); 
		employmentType.description = $("#Description").val(); 
		employmentType.category = $("#Category").val(); 
		employmentType.disabled = $('#Disabled').is(":checked"); 
		employmentType.employmentTypeInfo = employmentTypeInfoData; 		
				
		var ajaxCore = new AjaxCore(); 
		var request = ajaxCore.sendRequestType(globalHostname + "/app/Core/Job/EmploymentType/add", employmentType, "post");
		
		request.success(function(data, status, xhrObj)
		{
			preparePageForLoading(employmentTypeLink);
		});
		
	}
	
	
</script>    

<form id="myform">

<div class="form">
		
  <div class="sectionalForm"> 
   <div class="leftSection">
	<div class="labelSection">Employment Type Code</div><div class="inputSection"><input type="text" id="Code" value="Code"/></div>
   </div> 
	
	<div class="rightSection">
		<div class="inlineLabelSection">Disabled</div><div class="inlineLabelSection"><input type="checkbox" id="Disabled" /></div>
	</div>
  </div>
	
    <div class="formRow">
		<div class="labelSection">Description</div><div class="inputSection"><input type="text" id="Description" value="Description"/></div>
    </div>

	<div class="formRow">
		<div class="labelSection">Category</div><div class="inputSection"><input type="text" id="Category" value="Category"/></div>
	</div>

	<div> 
		<div class="command"><button type="button" id="saveBtn">Save</button>
		<button type="button" id="cancelBtn2">Cancel</button>
		</div>
	</div>
   
   <div>&nbsp;</div>
  
    <div>
	 <div> Employment Type Info  </div>
		<div id="grid" style="height: 380px"></div>
	</div>
</div>

</form>