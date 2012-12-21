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
  
	var gridUrl = hostname + "/app/Core/Department";
	
	$(document).ready(function() 
	{
	
		var model = {
                        id: "nid",
                        fields: {
                                        nid: { editable: false },
                                        departmentCode: { editable: false, validation: { required: true } },
                                        departmentName: { editable: false, type: "string", validation: { required: true } },
                                        remark: { editable: false, type: "string" },
                                        enabled: { editable: false, type: "boolean" }
								}
                     };
		
		var columns = { "columns" : [ 
							{
                                field: "departmentCode",
                                width: 90,
                                title: "Department Code"
                            }, 
							{
                                field: "departmentName",
                                width: 90,
                                title: "Department Name"
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
                            }
						]
					};
		
		var addLinkInfo = { 
			    "text" : "Add New Department", 
				"link" : "departmentAdd.jsp", 
				"callback" : goToPage
			};				
			
		var updateLinkInfo = { 
			    "text" : "Update", 
				"link" : "departmentEdit.jsp"
			};
		
		var ajaxCore = new AjaxCore();
		var request = ajaxCore.sendRequest(gridUrl + "/list", null, "get");
	
		request.success(function(data) 
		{
			var gridDataObject = 
			{ 
					"gridUrl" : gridUrl,
					"data" : data,
					"columns" : columns,
					"model" : model, 
					"addLinkInfo" : addLinkInfo, 
					"updateLinkInfo" : updateLinkInfo
			}; 
				
			var input = { "id" : coreDepartmentPage, "roleId" : 1 };
			var coreCommand = new CoreCommand();
			coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);
				
		});
		
	});
	
	
</script>    

<div class="form dataEntry">
	<h1>Department </h1>
	
	<div class="formRow">
		Department Code Maintenance
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
</html>