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

    var gridUrl = hostname + "/app/Core/SectionInfo";

	$(document).ready(function() 
	{
	
		var value = getParameterByName("id");
		
		if (value != null) 
		{
			var ajaxCore = new AjaxCore();
			var request = ajaxCore.sendRequest(hostname + "/app/Core/Section/get", { id : value }, "get");
	
			request.done(function(data)
			{
			
				if (data == null) 
					return;
			
				$("#Nid").val(data.nid);
				$("#SectionCode").val(data.sectionCode);
				$("#SectionName").val(data.sectionName);
				$("#Remark").val(data.remark);
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

			
			 $("#saveBtn").click(function()
			 {
				getValidateData();
			 });
			 
			 $("#cancelBtn").click(function()
			 {
				var result = cancelFormChanges();
				if (result) 
				   window.location.replace("section.jsp");
			 });
 	});

	function getValidateData()
	{
		var sectionInfoData = [];
	
        var grid = $("#grid").data("kendoGrid").dataSource.data();
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
		section.nid = $("#Nid").val();
		section.sectionCode = $("#SectionCode").val(); 
		section.sectionName = $("#SectionName").val(); 
		section.remark = $("#Remark").val(); 
		section.enabled = $('#Enabled').is(":checked"); 
		section.sectionInfo = sectionInfoData; 		
				
		var ajaxCore = new AjaxCore(); 
		var request = ajaxCore.sendRequestType(hostname + "/app/Core/Section/saveOrUpdate", section, "post"); 
		
		request.done(function(data, status, xhrObj)
		{
			goHome();
		});
	}
	
	function goHome()
	{
		window.location.replace("section.jsp");
	}
</script>    

<div class="form dataEntry">
		
  <div class="sectionalForm"> 
   <div class="leftSection"><input type="hidden" id="Nid" name="Nid" />
	<div class="labelSection">Section Code</div><div class="inputSection"><input type="text" id="SectionCode" value="SectionCode"/></div>
   </div> 
	
	<div class="rightSection">
		<div class="inlineLabelSection">Disabled</div><div class="inlineLabelSection"><input type="checkbox" id="Enabled" /></div>
	</div>
  </div>
	
    <div class="formRow">
		<div class="labelSection">Section Name</div><div class="inputSection"><input type="text" id="SectionName" value="SectionName"/></div>
    </div>

	<div class="formRow">
		<div class="labelSection">Remark</div><div class="inputSection"><input type="text" id="Remark" value="remark"/></div>
	</div>

	<div> 
		<div class="command"><button type="button" id="saveBtn">Save</button>
		<button type="button" id="cancelBtn">Cancel</button>
		</div>
	</div>
   
   <div>&nbsp;
   </div>
  
    <div>
	 <div> Section Info  </div>
		<div id="grid" style="height: 380px"></div>
	</div>
</div>

<%@ include file="/includes/footer.html" %>

</body>
</html>
