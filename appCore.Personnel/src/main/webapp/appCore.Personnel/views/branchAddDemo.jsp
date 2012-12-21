
<script type="text/javascript">          

    var gridUrl = globalHostname + "/app/Core/BranchInfo";

	var  model =  {
                    id: "nid",
                    fields: {
                        nid: { editable: false },
                        type: {  type: "string" },
                        value : {  validation: { required: true } },
                        description: {  type: "string" },
                        category: {  validation: { required: true } }
                           }
                   };
				   
		var  columns = { "columns" : [ 
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
				"link" : "branch.jsp", 
				"callback" : saveForm.toString()
		};				
			
		var updateLinkInfo = { 
			    "text" : "Update", 
				"link" : "branchEdit.jsp"
		};
	
	$(document).ready(function() 
	{
	
		
			$("#myform").validationEngine();
	
			var gridDataObject = 
			{ 
					"gridUrl" : gridUrl,
					"columns" : columns,
					"model" : model, 
					"addLinkInfo" : addLinkInfo, 
					"updateLinkInfo" : updateLinkInfo, 
					"appearance" : globalCoreGridAppearanceToobarCreateCancel
			}; 
				
			var input = { "id" : coreBranchPage, "roleId" : 1 };
			var coreCommand = new CoreCommand();
			coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);
				
			$("#addBtn").live("click", function()
			{
				saveForm();
			});
			 
			$("#cancelBtn").live("click", function()
			{
				var result = cancelFormChanges();
				if (result) 
					loadPage("branchDemo.jsp");
				   //window.location.replace("branch.jsp");
			});
			
 	});

	function saveForm()
	{
		var isValid = $("#myform").validationEngine('validate'); 
	
		if (!isValid) 
		   return; 
		
		if ($("#myform").validationEngine('validate'));
		{
			var branchInfoData = [];
		
			var grid = $("#grid").data("kendoGrid").dataSource.data();
			$.each(grid, function (i, dataItem) 
			{
				var branchInfo = new BranchInfo(); 
				branchInfo.type = dataItem.type; 
				branchInfo.value = dataItem.value;
				branchInfo.description = dataItem.description;
				branchInfo.category = dataItem.category;
				branchInfoData.push(branchInfo);
			});
				
			var branch = new Branch(); 
			branch.branchCode = $("#BranchCode").val(); 
			branch.branchName = $("#BranchName").val(); 
			branch.description = $("#Description").val(); 
			branch.enabled = $('#Enabled').is(":checked"); 
			branch.branchInfo = branchInfoData; 		
					
			var ajaxCore = new AjaxCore(); 
			var request = ajaxCore.sendRequestType(globalHostname + "/app/Core/Branch/add", branch, "post");
			
			request.success(function(data, status, xhrObj)
			{
				loadPage("branchDemo.jsp");
			});
		}
		
	}
	
	
</script>    

<form id="myform">

<div class="form dataEntry">
  <div class="sectionalForm"> 
   <div class="leftSection">
	<div class="labelSection">Branch Code <span class='req'>*</span></div><div class="inputSection"><input class="validate[required, maxSize[10]]" type="text" id="BranchCode" name="BranchCode" value="BranchCode"/></div>
   </div> 
	
	<div class="rightSection">
		<div class="inlineLabelSection">Disabled </div><div class="inlineLabelSection"><input type="checkbox" id="Enabled" /></div>
	</div>
  </div>
	
    <div class="formRow">
		<div class="labelSection">Branch Name <span class='req'>*</span> </div><div class="inputSection"><input type="text" class="validate[required, maxSize[80]]" id="BranchName" value="BranchName"/></div>
    </div>

	<div class="formRow">
		<div class="labelSection">Description</div><div class="inputSection"><input type="text" id="Description" class="validate[required, maxSize[80]]" value="Description"/></div>
	</div>

	<div> <div class="maintenanceCommandSpace"></div>
		<div class="maintenanceCommand">
		</div>
	</div>
   
   <div>&nbsp;
   </div>
  
    <div>
	 <div> Branch Info  </div>
		<div id="grid" style="height: 380px"></div>
	</div>
</div>
</form>

