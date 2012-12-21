<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>

<%@ include file="../includes/css_includes.html" %>
<%@ include file="../includes/js_includes.html" %>
<%@ include file="/includes/header.html" %>

<script type="text/javascript">          

    var gridUrl = hostname + "/app/Core/Job/GradeInfo";

	$(document).ready(function() 
	{
	
		var value = getParameterByName("id");
		
		if (value != null) 
		{
			var ajaxCore = new AjaxCore();
			var request = ajaxCore.sendRequest(hostname + "/app/Core/Job/Grade/get", { id : value }, "get");
	
			request.done(function(data)
			{
			
				if (data == null) 
					return;
			
				$("#Nid").val(data.nid);
				$("#Code").val(data.code);
				$("#Description").val(data.description);
				$("#Category").val(data.category);
				$("#ProbationMonth").val(data.probationMonth);
				$("#Disabled").attr("checked", data.disabled);
	
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
                                create: {
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
					
				})
			 }
				
			 $("#saveBtn").click(function()
			 {
				getValidateData();
			 });
			 
			 $("#cancelBtn").click(function()
			 {
				var result = cancelFormChanges();
				if (result) 
				   window.location.replace("grade.jsp");
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
		grade.nid = $("#Nid").val();
		grade.code = $("#Code").val(); 
		grade.description = $("#Description").val(); 
		grade.category = $("#Category").val(); 
		grade.probationMonth = $("#ProbationMonth").val(); 
		grade.disabled = $('#Disabled').is(":checked"); 
		grade.gradeInfo = gradeInfoData; 		
				
		var ajaxCore = new AjaxCore(); 
		var request = ajaxCore.sendRequestType(hostname + "/app/Core/Job/Grade/saveOrUpdate", grade, "post"); 
		
		request.success(function(data, status, xhrObj)
		{
			goToPage("grade.jsp");
		});
		
	}
	
	
</script>    

<div class="form dataEntry">
		
  <div class="sectionalForm"> 
   <div class="leftSection"><input type="hidden" id="Nid" name="Nid" />
	<div class="labelSection">Grade Code</div><div class="inputSection"><input type="text" id="Code" value="Code"/></div>
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

	<div class="formRow">
		<div class="labelSection">Probation Month</div><div class="inputSection"><input type="text" id="ProbationMonth" value="0"/></div>
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

<%@ include file="/includes/footer.html" %>

</body>
</html>
