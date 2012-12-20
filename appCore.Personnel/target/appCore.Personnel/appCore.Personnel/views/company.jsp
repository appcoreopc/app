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
		var gridUrl = hostname + "/app/Core/Company";
		
		var model = {
                                    
						id: "nid",
                        fields: {
                                        nid: { editable: false },
                                        companyCode: { editable: false, validation: { required: true } },
                                        companyName: { editable: false, type: "string", validation: { required: true } },
                                        address : { editable: false, type: "string" },
                                        country : { editable: false, type: "string" }
                                    }
                    };
					
		var columns = { 
						"columns" : [ 
							{
                                field: "companyCode",
                                width: 90,
                                title: "Company Code"
                            }, 
							{
                                field: "companyName",
                                width: 90,
                                title: "Company Name"
                            },
							{
                                field: "address",
                                width: 90,
                                title: "Address"
                            }, 
							{
                                field: "country",
                                width: 90,
                                title: "Country"
                            }
						]};
		
		var addLinkInfo = { 
			    "text" : "Add New Company", 
				"link" : "companyAdd.jsp", 
				"callback" : goToPage
			};				
			
		var updateLinkInfo = { 
			    "text" : "Update", 
				"link" : "companyEdit.jsp"
			};
		
		var ajaxCore = new AjaxCore();
		var request = ajaxCore.sendRequest( gridUrl + "/list", null, "get");
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
				
			var input = { "id" : coreCompanyPage, "roleId" : 1 };
			var coreCommand = new CoreCommand();
			coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);
		
		});
			  
	});
	
	

</script>    

<div class="form dataEntry">
	<h1>Company </h1>
	
	<div class="formRow">
		Company Code Maintenance
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