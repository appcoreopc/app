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
		var appPath = "/app/Core/Calendar/Holiday";
		var ajaxCore = new AjaxCore();
		var request = ajaxCore.sendRequest(hostname +  appPath + "/list", null, "get");
		
			request.success(function(data) 
			{
				  var grid = $("#grid").kendoGrid({
                        dataSource: {
						
						  transport: {
                                read:  {
                                    url: hostname + appPath + "/list",
                                    dataType: "json"
                                },
                                update: {
                                    url: hostname + appPath + "/saveOrUpdate",
                                    dataType: "json"
                                },
                                destroy: {
                                    url: hostname + appPath + "/delete",
                                    dataType: "json"
                                },
                                create: {
                                    url: hostname + appPath + "/add",
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
                                        holidayDate: { editable: false, type : "date" },
                                        name: { editable: false, type : "string" },
                                        recurring : { editable: false, type : "boolean" },
                                        lastUpdate : { editable: false, type : "string" }
                                       
                                    }
                                }
                            }
							 
                        },
						editable : true,
						groupable: false,
						selectable : true,
                        sortable: true,
                        pageable: true,
						toolbar: ["save", "cancel"],
                        columns: [ 
							 {
                                field: "holidayDate",
                                width: 90,
                                title: "Holiday Date", format : "{0:dd-MMM-yyyy}"
                            }, 
							{
                                field: "name",
                                width: 90,
                                title: "Name"
                            }, 
							{
                                field: "recurring",
                                width: 90,
                                title: "Recurring"
                            }, 
							{
                                field: "type",
                                width: 90,
                                title: "Type", template : '#= getHolidayTypeDisplayText(type) #'
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
								url: hostname + appPath + "/delete",
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
				goToPage("holidaySetupAdd.jsp");
			});
			
			$("#setupHolidayBtn").click(function()
			{
				goToPage("configureHolidayGroup.jsp");
			});
	});
	
	function getHolidayTypeDisplayText(dayType)
	{
		if (dayType == 1) 
			return "Gazetted";
		else if (dayType == 0) 
		    return "Non-Gazetted";
		else 
			return "Non-Gazetted";
	}
	
	function showDetails(e)
	{
		 e.preventDefault();
		 var dataItem = this.dataItem($(e.currentTarget).closest("tr"));
		 goToPage("holidaySetupEdit.jsp?id=" + dataItem.nid );
	}

</script>    

<div class="form dataEntry">
	<h1>Holiday Setup</h1>
	
	<div class="formRow">
		Holiday Maintenance
    </div>

	<div class="formRow">	
		&nbsp;
    </div>
	 
	<div class="maintenanceCommand"> 
		<button type="button" id="addBtn">Add New Holiday</button>
		<button type="button" id="setupHolidayBtn">Configure Holiday Group</button>
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