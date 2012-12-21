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
		var request = ajaxCore.sendRequest(hostname + "/app/Core/Job/Grade/list", null, "get");
		
			request.success(function(data) 
			{
				  var grid = $("#grid").kendoGrid({
                        dataSource: {
						
						  transport: {
                                read:  {
                                    url: hostname + "/app/Core/Job/Grade/list",
                                    dataType: "json"
                                },
                                update: {
                                    url: hostname + "/app/Core/Job/Grade/saveOrUpdate",
                                    dataType: "json"
                                },
                                destroy: {
                                    url: hostname + "/app/Core/Job/Grade/delete",
                                    dataType: "json"
                                },
                                create: {
                                    url: hostname + "/app/Core/Job/Grade/add",
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
                                        code: { editable: false, validation: { required: true } },
                                        description : { editable: false, type: "string", validation: { required: true } },
                                        probationMonth: { editable: false, type: "number" },
                                        category: { editable: false, type: "string" },
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
                                field: "code",
                                width: 90,
                                title: "Grade Code"
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
                                field: "probationMonth",
                                width: 90,
                                title: "Probation (Month)"
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
								url: hostname + "/app/Core/Job/Grade/delete",
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
				goToPage("gradeAdd.jsp");
			});
	});
	
	function showDetails(e)
	{
		 e.preventDefault();
		 var dataItem = this.dataItem($(e.currentTarget).closest("tr"));
		 goToPage("gradeEdit.jsp?id=" + dataItem.nid );
	}

</script>    

<div class="form dataEntry">
	<h1>Grade </h1>
	
	<div class="formRow">
		Grade Code Maintenance
    </div>

	<div class="formRow">	
		&nbsp;
    </div>
	 
	<div class="maintenanceCommand"> 
		<button type="button" id="addBtn">Add New Grade</button>
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