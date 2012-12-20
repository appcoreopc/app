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

    var gridUrl = hostname + "/app/Core/DivisionInfo";

	$(document).ready(function() 
	{
	
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
				
			 $("#saveBtn").click(function()
			 {
				getValidateData();
			 });
			 
			 $("#cancelBtn").click(function()
			 {
				var result = cancelFormChanges();
				if (result) 
				   window.location.replace("division.jsp");
			 });
 	});

	function getValidateData()
	{
		var divisionInfoData = [];
	
        var grid = $("#grid").data("kendoGrid").dataSource.data();
 		$.each(grid, function (i, dataItem) 
		{
			var divisionInfo = new DivisionInfo(); 
			divisionInfo.type = dataItem.type; 
			divisionInfo.value = dataItem.value;
			divisionInfo.description = dataItem.description;
			divisionInfo.category = dataItem.category;
			divisionInfoData.push(divisionInfo);
		});
	 		
		var division = new Division(); 
		division.divisionCode = $("#DivisionCode").val(); 
		division.divisionName = $("#DivisionName").val(); 
		division.description = $("#Description").val(); 
		division.enabled = $('#Enabled').is(":checked"); 
		division.divisionInfo = divisionInfoData; 		
				
		var ajaxCore = new AjaxCore(); 
		var request = ajaxCore.sendRequestType(hostname + "/app/Core/Division/add", division, "post"); 
		
		request.success(function(data, status, xhrObj)
		{
			goToPage("division.jsp");
		});
		
	}
	
	
</script>    

<div class="form dataEntry">
		
  <div class="sectionalForm"> 
   <div class="leftSection">
	<div class="labelSection">Division Code</div><div class="inputSection"><input type="text" id="DivisionCode" value="DivisionCode"/></div>
   </div> 
	
	<div class="rightSection">
		<div class="inlineLabelSection">Disabled</div><div class="inlineLabelSection"><input type="checkbox" id="Enabled" value="Disabled"/></div>
	</div>
  </div>
	
    <div class="formRow">
		<div class="labelSection">Division Name</div><div class="inputSection"><input type="text" id="DivisionName" value="DivisionNames"/></div>
    </div>

	<div class="formRow">
		<div class="labelSection">Description</div><div class="inputSection"><input type="text" id="Description" value="Description"/></div>
	</div>
	
	<div> 
		<div class="command"><button type="button" id="saveBtn">Save</button>
		<button type="button" id="cancelBtn">Cancel</button>
		</div>
	</div>
	
	 <div>&nbsp;</div>
  
    <div>
	 <div> Division Info  </div>
		<div id="grid" style="height: 380px"></div>
	</div>
	
	
</div>

<%@ include file="/includes/footer.html" %>

</body>
</html>
