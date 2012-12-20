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

	var gridUrl = globalHostname + "/app/User/Forms";
	
		var model = {
                    id: "nid",
                    fields:
						{
                            nid: { editable: false },
                            formId : { editable: false, type: "string" },
                            categoryName : { editable: false, type: "string" }
                        }
                };
						
		var columns = { "columns" : [ 
							{
                                field: "formId",
                                width: 90,
                                title: "Resource Definition"
                            },
							{
                                field: "categoryName",
                                width: 90,
                                title: "Category"
                            }
						]}; 
				
		var addLinkInfo = { 
			    "text" : "Add new", 
				"link" : "userAdd.jsp", 
				"callback" : goToPage
			};				
			
		var updateLinkInfo = { 
			    "text" : "Update", 
				"link" : "userEdit.jsp"
			};
	
		var listGridUrl = globalHostname + "/app/User/Category/list";
		
		var selectControlName = "category";
		
		var controlData = 
		{ 
			"controlType" : 0, 
			"targetControlId" : "categoryDiv", 
			"controlName" : selectControlName,
			"value" : "nid", 
			"text" : "categoryName",
			"url" : listGridUrl,
			"filters" : [ { field : "formId", operator : "contains" }]
		};

		var textControlName = "filterBy";
		
		var textControlData = 
		{ 
			"controlType" : 0, 
			"targetControlId" : "filterByDiv", 
			"controlName" : textControlName,
			"filters" : [ { field : "formId", operator : "contains" }]
		};
	
	$(document).ready(function() 
	{
		renderGridControl(); 		
	});
	
	function filterGrid(value)
	{
		  var ds = $("#grid").data("kendoGrid").dataSource;
		  ds.filter([ { field : "formId", operator : "contains", "value" : value }]);
	}
	
	function renderGridControl()
	{
		$(".maintenanceCommand").empty();
		
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
					"updateLinkInfo" : updateLinkInfo,
					"listBoxDataObject" : controlData, 
					"textDataObject" : textControlData
			}; 
				
			var input = { "id" : coreUserPage, "roleId" : 1 };
			var coreCommand = new CoreCommand();
			coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);
		});

	}
 
</script>    

<div class="form dataEntry">
	<h1>Role based access administration</h1>
	
	<div class="formRow">
		Resource access configuration by role.  
    </div>

	<div class="formRow">	
		&nbsp;
    </div>

	 
	<div class="maintenanceCommand"> 
		
	</div>


	<div class="formRow">	
		&nbsp;
    </div>

	
<div class="sectionalForm"> 
   <div class="leftSection">
   <div class="labelSection">Filter by</div><div class="inputSection"><div id="filterByDiv"></div></div>
   </div> 
	
	<div class="rightSection">
		<div class="inlineLabelSection">Category</div><div class="inlineLabelSection">
				<div id="categoryDiv"></div>
		</div>
	</div>
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