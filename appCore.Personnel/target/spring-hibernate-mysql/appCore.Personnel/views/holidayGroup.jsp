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
  
	var cnt=0;
	
	$(document).ready(function() 
	{
		var appPath = "/app/Core/Calendar/HolidayGroup";
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
                                    //url: hostname + appPath + "/saveOrUpdate",
                                    dataType: "json"
                                },
                                destroy: {
                                    url: hostname + appPath + "/delete",
                                    dataType: "json"
                                },
                                create: {
                                    // url: hostname + appPath + "/add",
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
                                        name: { editable: true, type : "string" },
                                        description: { editable: true, type : "string" }
                                       
                                    }
                                }
                            }
							 
                        },
						editable : true,
						groupable: false,
						selectable : true,
                        sortable: true,
                        pageable: true,
						toolbar: ["create", "save" ],
                        columns: [ 
							 {
                                field: "name",
                                width: 90,
                                title: "Name",
                            }, 
							{
                                field: "description",
                                width: 90,
                                title: "Description"
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
						,
						saveChanges : function(e)
						{
							
							for (var i=0; i < e.sender._data.length; i++)
							{
								cnt++;
								console.log(cnt);
								if (e.sender._data[i].isNew())
								{
									var holidayGroup = new HolidayGroup(); 
									holidayGroup.name =  e.sender._data[i].name;
									holidayGroup.description =  e.sender._data[i].description;
									ajaxCore.sendRequest(hostname +  appPath + "/add", holidayGroup, "get");
								}
								else 
								{
									var holidayGroup = new HolidayGroup(); 
									holidayGroup.nid =  e.sender._data[i].nid;
									holidayGroup.name =  e.sender._data[i].name;
									holidayGroup.lastUpdate =  '2012-01-01';
									holidayGroup.description =  e.sender._data[i].description;
									ajaxCore.sendRequestType(hostname +  appPath + "/saveOrUpdate", holidayGroup, "post");
								}
							}
						 }
						
					});
				}
			);
			
			$("#addBtn").click(function()
			{
				alert('we go');
				var grid = $("#grid").data("kendoGrid");
				grid.toolbar = ["create"];
				grid.refresh();
				// 	var grid = $("#grid").data("kendoGrid");
				
			});
	});
	
	function showDetails(e)
	{
		 e.preventDefault();
		 var dataItem = this.dataItem($(e.currentTarget).closest("tr"));
		 goToPage("holidaySetupEdit.jsp?id=" + dataItem.nid );
	}

</script>    

<div class="form dataEntry">
	<h1>Holiday Group Setup</h1>
	
	<div class="formRow">
		Holiday Group Maintenance
    </div>

	<div class="formRow">	
		&nbsp;
    </div>
	 
	<div class="maintenanceCommand"> 
		
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
</html>0