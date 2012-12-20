<script type="text/javascript">          

    var gridUrl = globalHostname + "/app/Core/Job/GradeInfo";
	var gradePage = "grade.jsp";
	
	$(document).ready(function() 
	{
	
		$("#myform").validationEngine();
		
		var grid = $("#grid").kendoGrid({
                         dataSource: {
						
						  transport: {
                                read:  {
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
				
			 $("#saveBtn").live("click", function(evt)
			 {
				if (evt.handled !== true)
				{ 
					evt.handled = true; 
					getValidateData();
				}
			 });
			 
			 $("#cancelBtn").live("click", function(evt)
			 {
				if (evt.handled !== true)
				{ 
					evt.handled = true; 
					var result = cancelFormChanges();
					if (result) 
					{
						preparePageForLoading(gradePage);
					}
				}
			 });
 	});

	function getValidateData()
	{
		var gradeInfoData = [];
	
        var grid = $("#grid").data("kendoGrid").dataSource.data();
 		$.each(grid, function (i, dataItem) 
		{
			var gradeInfo = new GradeInfo(); 
			gradeInfo.type = dataItem.type; 
			gradeInfo.value = dataItem.value;
			gradeInfo.description = dataItem.description;
			gradeInfo.category = dataItem.category;
			gradeInfoData.push(gradeInfo);
		});
	 		
		var grade = new Grade(); 
		grade.code = $("#Code").val(); 
		grade.description = $("#Description").val(); 
		grade.category = $("#Category").val(); 
		grade.probationMonth = $("#ProbationMonth").val(); 
		grade.disabled = $('#Disabled').is(":checked"); 
		grade.gradeInfo = gradeInfoData; 		
				
		var ajaxCore = new AjaxCore(); 
		var request = ajaxCore.sendRequestType(globalHostname + "/app/Core/Job/Grade/add", grade, "post");
		
		request.success(function(data, status, xhrObj)
		{
			preparePageForLoading(gradePage);
		});
		
	}
	
</script>    

<form id="myform">
 
<div class="form">
		
  <div class="sectionalForm"> 
   <div class="leftSection">
	<div class="labelSection">Grade Code</div><span class='req'>*</span><div class="inputSection"><input type="text" id="Code" class="validate[required, maxSize[10]]" value="Code"/></div>
   </div> 
	
	<div class="rightSection">
		<div class="inlineLabelSection">Disabled</div><div class="inlineLabelSection"><input type="checkbox" id="Disabled" /></div>
	</div>
  </div>
	
    <div class="formRow">
		<div class="labelSection">Description</div><span class='req'>*</span><div class="inputSection"><input type="text" id="Description" class="validate[required, maxSize[80]]" value="Description"/></div>
    </div>

	<div class="formRow">
		<div class="labelSection">Category</div><div class="inputSection"><input type="text" id="Category" class="validate[required, maxSize[10]]" value="Category"/></div>
	</div>

	<div class="formRow">
		<div class="labelSection">Probation Month</div><span class='req'>*</span><div class="inputSection"><input type="text" id="ProbationMonth" class="validate[required, max[12]]" value="0"/></div>
	</div>	
	
	<div> 
		<div class="command"><button type="button" id="saveBtn">Save</button>
		<button type="button" id="cancelBtn">Cancel</button>
		</div>
	</div>
   
   <div>&nbsp;</div>
  
    <div>
	 <div> Grade Info  </div>
		<div id="grid" style="height: 380px"></div>
	</div>
</div>

</form>