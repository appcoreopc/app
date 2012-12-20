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

    var gridUrl = hostname + "/app/Core/Job/EmploymentTypeInfo";

	$(document).ready(function() 
	{
	
		var value = getParameterByName("id");
		
		if (value != null) 
		{
			var ajaxCore = new AjaxCore();
			var request = ajaxCore.sendRequest(hostname + "/app/Core/Job/EmploymentType/get", { id : value }, "get");
	
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
				 });
			}
				0
			 $("#saveBtn").click(function()
			 {
				getValidateData();
			 });
			 
			 $("#cancelBtn").click(function()
			 {
				var result = cancelFormChanges();
				if (result) 
				   window.location.replace("employmentType.jsp");
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
		var request = ajaxCore.sendRequestType(hostname + "/app/Core/Job/EmploymentType/saveOrUpdate", employmentType, "post"); 
		
		request.success(function(data, status, xhrObj)
		{
			goToPage("employmentType.jsp");
		});
		
	}
	
	
</script>    

<div class="form dataEntry">
		
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
		<button type="button" id="cancelBtn">Cancel</button>
		</div>
	</div>
   
   <div>&nbsp;</div>
  
    <div>
	 <div> Employment Type Info  </div>
		<div id="grid" style="height: 380px"></div>
	</div>
</div>

<%@ include file="/includes/footer.html" %>

</body>
</html>
