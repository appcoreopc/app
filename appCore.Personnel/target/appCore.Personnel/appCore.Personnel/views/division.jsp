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
  
    var gridUrl = hostname + "/app/Core/Division";
	
	$(document).ready(function() 
	{
		 var model = {
                        id: "nid",
                        fields: {
                                        nid: { editable: false },
                                        divisionCode: { editable: false, validation: { required: true } },
                                        divisionName: { editable: false, type: "string", validation: { required: true } },
                                        description: { editable: false, type: "string" },
                                        enabled: { editable: false, type: "number" }
                                }
                     };
					 
		 var columns = 	{ "columns" : 
						[ 
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
                            }
						]};
		
		var addLinkInfo = { 
			    "text" : "Add New Division", 
				"link" : "divisionAdd.jsp", 
				"callback" : goToPage
			};				
			
		var updateLinkInfo = { 
			    "text" : "Update", 
				"link" : "divisionEdit.jsp"
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
				
			var input = { "id" : coreDivisionPage, "roleId" : 1 };
			var coreCommand = new CoreCommand();
			coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);
		
		});
	});

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