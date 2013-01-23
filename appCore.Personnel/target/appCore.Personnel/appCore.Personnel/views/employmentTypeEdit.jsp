<script type="text/javascript">          

    var gridUrl = globalHostname + "/app/Core/Job/EmploymentTypeInfo";
	var employmentTypePage =  "employmentType.jsp";
	
	$(document).ready(function() 
	{
	
		var value = globalCurrentId.nid;
		
		if (value != null) 
		{
			var ajaxCore = new AjaxCore();
			var request = ajaxCore.sendRequest(globalHostname + "/app/Core/Job/EmploymentType/get", { id : value }, "get");
	
			request.done(function(data)
			{
			
				if (data == null) 
					return;
			
				$("#Nid").val(data.nid);
				$("#Code").val(data.code);
				$("#Description").val(data.description);
				$("#Category").val(data.category);
				$("#Disabled").attr("checked", data.disableds);
	
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
                                    ids: "nid",
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
			}
				
			 $("#saveBtn").click(function()
			 {
				if (evt.handled !== true)
				{
					evt.handled = true; 
					getValidateData();
				}
			 });
			 
			 $("#cancelBtn2").click(function()
			 {
				if (evt.handled !== true)
				{
					evt.handled = true; 
					var result = cancelFormChanges();
					if (result) 
				   preparePageForLoading(employmentTypePage);
				}
				
			 });
 	});

	function getValidateData()
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
		employmentType.nid = $("#Nid").val();
		employmentType.code = $("#Code").val(); 
		employmentType.description = $("#Description").val(); 
		employmentType.category = $("#Category").val(); 
		employmentType.disabled = $('#Disabled').is(":checked"); 
		employmentType.employmentTypeInfo = employmentTypeInfoData; 		
				
		var ajaxCore = new AjaxCore(); 
		var request = ajaxCore.sendRequestType(globalHostname + "/app/Core/Job/EmploymentType/saveOrUpdate", employmentType, "post");
		
		request.success(function(data, status, xhrObj)
		{
			preparePageForLoading(employmentTypePage);
		});
		
	}
	
	
</script>    

<form id="myform">

<div class="form">
		
  <div class="sectionalForm"> 
   <div class="leftSection"><input type="hidden" id="Nid" name="Nid" />
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