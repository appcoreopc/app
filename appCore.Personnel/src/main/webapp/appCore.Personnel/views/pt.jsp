<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>

<script language="javascript" src="../../js/coreGrid.js"></script>
<script language="javascript" src="../../js/coreMenu.js"></script>
<script language="javascript" src="../../js/coreCommand.js"></script>


<%@ include file="../includes/css_includes.html" %>
<%@ include file="../includes/js_includes.html" %>
<%@ include file="/includes/header.html" %>

<script type="text/javascript">          

    var Branch = function() 
	{
		this.branchCode = ""; 
		this.branchName = "";
		this.description = "";
		this.enabled = -1; 
		this.nid = -1;
	}
	
	var BranchInfo = function()
	{
		this.nid = 0; 
		this.category = ""; 
		this.Description = "";
		this.refEntity = 1; 
		this.type = ""; 
		this.value = "";
	}

	function getFormData()
	{
		var branch = new Branch(); 
		branch.branchCode = $("#BranchCode").val();
		branch.branchName = $("#BranchName").val();
		branch.description = $("#Description").val();
		branch.enabled = $("#Enabled").val();
		return branch;
	}
	
	var gridUrl = globalHostname + "/app/Core/Branch";
	
	$(document).ready(function() 
	{
		/* var coreMenu = new CoreMenu(); 
		coreMenu.createMenu();
		*/
		
		var model =  {
    						id: "nid",
                            fields: 
							{
                                    nid: { editable: false },
                                    type: { editable: false, type: "string" },
                                    value : { editable: false, validation: { required: true } },
                                    description: { editable: false, type: "string" },
                                    category: { editable: false, validation: { required: true } }
                            }
						};
									
		var columns = { 
							columns : [ 
							{
                                field: "branchCode",
                                width: 90,
                                title: "Branch Code"
                            }, 
							{
                                field: "branchName",
                                width: 90,
                                title: "Branch Name"
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
			    "text" : "Add My Button", 
				"link" : "branchAdd.jsp", 
				"callback" : goToPage
			};
			
		var gridData; 	
		
		var ajaxCore = new AjaxCore();
		var request = ajaxCore.sendRequest(gridUrl + "/list", null, "get");
		
		request.success(function(data) 
		{
				var gridDataObject = { 
					"gridUrl" : gridUrl,
					"data" : data,
					"columns" : columns,
					"model" : model, 
					"addLinkInfo" : addLinkInfo
				}; 
				
				var input = { "id" : "Test", "roleId" : 1 };
				var coreCommand = new CoreCommand();
				coreCommand.parseCommand("http://localhost:8080/appCore-personnel/app/User/Forms/get", input, gridDataObject);
		});
		
		/*	
		$("#addBtn").click(function()
		{
				goToPage("branchAdd.jsp");
		});
			
			$("#hideBtn").click(function()
			{
				
				var grid = $("#grid").data("kendoGrid");
				
				/* grid.columns = [
				            {
                                field: "branchCode",
                                width: 90,
                                title: "Branch Code"
                            }, 
							{
                                field: "branchName",
                                width: 90,
                                title: "Branch Name"
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
                            } ]; */
				
				//grid.hideColumn(grid.columns.length-1);
				//grid.hideColumn(grid.columns.length-2);
				//grid.showColumn(0);grid.showColumn(1);grid.showColumn(2);
				
				
				
				//resizeGrid();
			    /*  var dg =  $("#grid").kendoGrid({
				 
				 columms : [ 
							{
                                field: "branchCode",
                                width: 90,
                                title: "Branch Code"
                            }, 
							{
                                field: "branchName",
                                width: 90,
                                title: "Branch Name"
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
							
							]
							
							
				}); */
			 
			// }); 
				
	});
	
	
</script>    

<div class="form dataEntry">
	<h1>Branch </h1>
	
	<div class="formRow">
		Branch Code Maintenance
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