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

	var gridUrl = globalHostname + "/app/Users/Users";
	$(document).ready(function() 
	{
		var model = {
                        id: "nid",
                        fields:{
                                        nid: { editable: false },
                                        username : { editable: false, type: "string" }
                                }
                    };
						
		var columns = { "columns" : [ 
							{
                                field: "username",
                                width: 90,
                                title: "User Name"
                            }
						]}; 
				
			var addLinkInfo = { 
			    "text" : "Add new user", 
				"link" : "userAdd.jsp", 
				"callback" : goToPage
			};				
			
			var updateLinkInfo = { 
			    "text" : "Update", 
				"link" : "userEdit.jsp"
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
				
			var input = { "id" : coreUserPage, "roleId" : 1 };
			var coreCommand = new CoreCommand();
			coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);
		});
	});
 
</script>    

<div class="form dataEntry">
	<h1>User Administration</h1>
	
	<div class="formRow">
		User Maintenance 
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