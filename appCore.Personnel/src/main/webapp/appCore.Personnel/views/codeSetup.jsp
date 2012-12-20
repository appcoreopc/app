	<script type="text/javascript">          

	var gridUrl = globalHostname + "/app/Core/Branch";
	
	$(document).ready(function() 
	{
		var model = {
                        
						id: "nid",
                        fields: {
                                        nid: { editable: false },
                                        type: { editable: false, type: "string" },
                                        value : { editable: false, validation: { required: true } },
                                        description: { editable: false, type: "string" },
                                        category: { editable: false, validation: { required: true } }
								}
                    };
						
		var columns = { "columns" : [ 
							{
                                field: "branchCode",
                                width: 90,
                                title: "Branch Code"
                            }, 
							{
                                field: "branchName",
                                width: 90,
                                title: "Branch Name"
                            },
							{
                                field: "description",
                                width: 90,
                                title: "Description"
                            }, 
							{
                                field: "enabled",
                                width: 90,
                                title: "Disabled"
                            }
						]}; 
				
			var addLinkInfo = { 
			    "text" : "Add codes", 
				"link" : "codeAdd.jsp", 
				"callback" : goToAdd.toString()
			};				
			
			var updateLinkInfo = { 
			    "text" : "Update", 
				"link" : "branchEdit.jsp"
			};
	
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
				
			var input = { "id" : coreBranchPage, "roleId" : 1 };
			var coreCommand = new CoreCommand();
			coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);
		});
	});
	
	function goToAdd()
	{	
		preparePageForLoading("codeAdd.jsp");
	}

	
</script>    

<div class="form">
	<h1>Code Setup  </h1>
	
	<div class="formRow">
		Code Maintenance  
    </div>

	<div class="formRow">	
		&nbsp;
    </div>
	 
	<div class="maintenanceCommand"> 

	</div>
	
	<div class="formRow">	
		&nbsp;
    </div>
	 
	 
  <div>
		<div id="grid" style="height: 380px"></div>
	</div>
</div>
