
<script type="text/javascript">          

    var gridUrl = globalHostname + "/app/Core/BranchInfo";

	$(document).ready(function() 
	{
		$("#myform").validationEngine();
		
		var value = globalCurrentId.nid;
		
		var ajaxCore = new AjaxCore();
		var request = ajaxCore.sendRequest(globalHostname + "/app/Core/Branch/get", { id : value }, "get");
	
		request.done(function(data)
		{
			
				if (data == null) 
					return;
			
				$("#Nid").val(data.nid);
				$("#BranchCode").val(data.branchCode);
				$("#BranchName").val(data.branchName);
				$("#Description").val(data.description);
				$("#Enabled").attr("checked", data.enabled);
	
				var grid = $("#grid").kendoGrid({
                         dataSource: {
						
						  transport: {
                                read:  {
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
                                    id: "nid",
                                    fields: {
                                        nid: { editable: false },
                                        type: {  type: "string" },
                                        value : {  validation: { required: true } },
                                        description: {  type: "string" },
                                        category: {  validation: { required: true } }
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
							     command : "destroy",  title : "", width: 110
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
			
				
			 $("#saveBtn").live("click", function()
			 {
				getValidateData();
			 });
			 
			 $("#cancelBtn").click(function()
			 {
				var result = cancelFormChanges();
				if (result) 
				   window.location.replace("branch.jsp");
			 });
 	});

	function getValidateData()
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
				branch.nid = $("#Nid").val();
				branch.branchCode = $("#BranchCode").val(); 
				branch.branchName = $("#BranchName").val(); 
				branch.description = $("#Description").val(); 
				branch.enabled = $('#Enabled').is(":checked"); 
				branch.branchInfo = branchInfoData; 		
						
				var ajaxCore = new AjaxCore(); 
				var request = ajaxCore.sendRequestType(globalHostname + "/app/Core/Branch/saveOrUpdate", branch, "post");
				
				request.done(function(data, status, xhrObj)
				{
					goHome();
				});
		}
	}
	
	function goHome()
	{
		//window.location.replace("branch.jsp");
		loadPage("branchDemo.jsp");
		
	}
	
	
</script>    

<form id="myform">

<div class="form">
		
  <div class="sectionalForm"> 
   <div class="leftSection"><input type="hidden" id="Nid" name="Nid" />
	<div class="labelSection">Branch Code</div><div class="inputSection"><input type="text" class="validate[required, maxSize[10]]" id="BranchCode" value="BranchCode"/></div>
   </div> 
	
	<div class="rightSection">
		<div class="inlineLabelSection">Disabled</div><div class="inlineLabelSection"><input type="checkbox" id="Enabled" /></div>
	</div>
  </div>
	
    <div class="formRow">
		<div class="labelSection">Branch Name</div><div class="inputSection"><input type="text" class="validate[required, maxSize[80]]" id="BranchName" value="BranchName"/></div>
    </div>

	<div class="formRow">
		<div class="labelSection">Description</div><div class="inputSection"><input type="text" class="validate[required, maxSize[80]]" id="Description" value="Description"/></div>
	</div>

	<div> 
		<div class="command"><button type="button" id="saveBtn">Save</button>
		<button type="button" id="cancelBtn">Cancel</button>
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
