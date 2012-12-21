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
  
	$(document).ready(function() 
	{
	
		var ajaxCore = new AjaxCore();
		var request = ajaxCore.sendRequest(globalHostname + "/app/Core/Division/list", null, "get");
		
			request.success(function(data) 
			{
				  var grid = $("#grid").kendoGrid({
                        dataSource: {
						
						  transport: {
                                read:  {
                                    url: globalHostname + "/app/Core/Division/list",
                                    dataType: "json"
                                },
                                update: {
                                    url: globalHostname + "/app/Core/Division/saveOrUpdate",
                                    dataType: "json"
                                },
                                destroy: {
                                    url: globalHostname + "/app/Core/Division/delete",
                                    dataType: "json"
                                },
                                createMessageBox: {
                                    url: globalHostname + "/app/Core/Division/add",
                                    dataType: "json"
                                } 
							},
						
                            data: data,
                            pageSize: 10, 
							schema: {
                                model: {
                                    id: "nid",
                                    fields: {
                                        nid: { editable: false },
                                        divisionCode: { editable: false, validation: { required: true } },
                                        divisionName: { editable: false, type: "string", validation: { required: true } },
                                        description: { editable: false, type: "string" },
                                        enabled: { editable: false, type: "number" }
                                    }
                                }
                            }
							 
                        },
						editable : true,
						groupable: false,
						selectable : true,
                        sortable: true,
                        pageable: true,
                        columns: [ 
							{
                                field: "divisionCode",
                                width: 90,
                                title: "Division Code"
                            }, 
							{
                                field: "divisionName",
                                width: 90,
                                title: "Division Name"
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
                            }, 
							{
							     command : { text: "Edit", click: showDetails },  title : "", width: 50
							},
							{
							     command : "destroy",  title : "", width: 50
							}
						], 
						remove : function(e)
						{
							$.ajax({
								url: globalHostname + "/app/Core/Division/delete",
								data: {"id": e.model.nid},
								type : "get", 
								dataType : "json"
								});
						}
						
                    });
				}
			);
		
		$("#addBtn").click(function()
		{
			goToPage("divisionAdd.jsp");
		});
			
	});

	function showDetails(e)
	{
		 e.preventDefault();
		 var dataItem = this.dataItem($(e.currentTarget).closest("tr"));
		 window.location.replace("divisionEdit.jsp?id="+dataItem.nid);
	}
	
</script>    

<div class="form dataEntry">
	<h1>Division </h1>
	
	<div class="formRow">
		Division Code Maintenance
    </div>

	<div class="formRow">	
		&nbsp;
    </div>
	 
	<div class="maintenanceCommand"> 
		<button type="button" id="addBtn">Add New Division</button>
	</div>
	<div class="formRow">	
		&nbsp;
    </div>
	 
	 
  <div>
		<div id="grid" style="height: 380px"></div>
	</div>
</div>

<%@ include file="/includes/footer.html" %>

</body>
</html>