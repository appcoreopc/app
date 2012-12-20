	<!DOCTYP+
E html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
		var request = ajaxCore.sendRequest(globalHostname + "/app/Core/Unit/list", null, "get");
		
			request.success(function(data) 
			{
				  var grid = $("#grid").kendoGrid({
                        dataSource: {
						
						  transport: {
                                read:  {
                                    url: globalHostname + "/app/Core/Unit/list",
                                    dataType: "json"
                                },
                                update: {
                                    url: globalHostname + "/app/Core//Unit/saveOrUpdate",
                                    dataType: "json"
                                },
                                destroy: {
                                    url: globalHostname + "/app/Core/Unit/delete",
                                    dataType: "json"
                                },
                                createMessageBox: {
                                    url: globalHostname + "/app/Core/Unit/add",
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
                                        unitCode: { editable: false, validation: { required: true } },
                                        unitName: { editable: false, type: "string", validation: { required: true } },
                                        remark: { editable: false, type: "string" },
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
                                field: "unitCode",
                                width: 90,
                                title: "Unit Code"
                            }, 
							{
                                field: "unitName",
                                width: 90,
                                title: "Unit Name"
                            },
							{
                                field: "remark",
                                width: 90,
                                title: "Remark"
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
								url: globalHostname + "/app/Core/Unit/delete",
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
				goToPage("unitAdd.jsp");
			});
	});
	
	function showDetails(e)
	{
		 e.preventDefault();
		 var dataItem = this.dataItem($(e.currentTarget).closest("tr"));
		 goToPage("unitEdit.jsp?id=" + dataItem.nid );
	}

</script>    

<div class="form dataEntry">
	<h1>Unit </h1>
	
	<div class="formRow">
		Unit Code Maintenance
    </div>

	<div class="formRow">	
		&nbsp;
    </div>
	 
	<div class="maintenanceCommand"> 
		<button type="button" id="addBtn">Add New Unit</button>
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