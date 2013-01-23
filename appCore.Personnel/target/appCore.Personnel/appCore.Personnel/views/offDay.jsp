<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//	EN" "http://www.w3.org/TR/html4/loose.dtd">
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
  
    var currentService = globalHostname + "/app/Core/Calendar/OffDay";
	$(document).ready(function() 
	{
	   
		var ajaxCore = new AjaxCore();
		var request = ajaxCore.sendRequest(currentService + "/list", null, "get");
	
		  request.success(function(data) 
		  {
			  var grid = $("#grid").kendoGrid({
                        dataSource: {
						
						  transport: {
                                read:  {
                                    url: currentService + "/list",
                                    dataType: "json"
                                },
                                update: {
                                    url: currentService + "/saveOrUpdate",
                                    dataType: "json"
                                },
                                destroy: {
                                    url: currentService + "/delete",
                                    dataType: "json"
                                },
                                createMessageBox: {
                                    url: currentService + "/add",
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
                                        PatternName : { editable: false, validation: { required: true } },
                                        dayPerCycle : { editable: false, type: "number", validation: { required: true } },
                                        description : { editable: false, type: "string" },
                                        disabled : { editable: false, type: "boolean" }
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
                                field: "patternName",
                                width: 90,
                                title: "Pattern Name"
                            }, 
							{
                                field: "dayPerCycle",
                                width: 90,
                                title: "Day Per Cycle"
                            },
							{
                                field: "description",
                                width: 90,
                                title: "Description"
                            }, 
							{
                                field: "disabled",
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
								url: globalHostname + "/app/Core/Calendar/OffDay/delete",
								data: {"id": e.model.nid},
								type : "get", 
								dataType : "json"
								});
						}
						
                     });
				});
	
			$("#addBtn").click(function()
			{
				goToPage("offDayAdd.jsp");
			});
	
	});
	
	function showDetails(e)
	{
		 e.preventDefault();
		 var dataItem = this.dataItem($(e.currentTarget).closest("tr"));
		 goToPage("offDayEdit.jsp?id=" + dataItem.nid);
	}

</script>    

<div class="form dataEntry">
	<h1>Off Day </h1>
	
	<div class="formRow">
		Off Day Maintenance
    </div>
	<div class="formRow">	
		&nbsp;
    </div>
	<div class="maintenanceCommand"> 
		<button type="button" id="addBtn">Add New Offday Configuration</button>
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