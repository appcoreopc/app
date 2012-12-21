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

	var mainPage = "user.jsp";
	var User = function()
	{
		this.username; 
		this.password; 
	}
	
    var gridUrl = globalHostname + "/app/Users/Users";

	$(document).ready(function() 
	{
				
		$("#saveBtn").click(function()
		{
			getValidateData();
		});
			 
		$("#cancelBtn").click(function()
		{
				var result = cancelFormChanges();
				if (result) 
				   window.location.replace(mainPage);
		});
		
 	});

	function getValidateData()
	{
			
		var user = new User(); 
		user.username = $("#username").val(); 
		user.password = $("#password").val(); 
		
		var confirmpassword = $("#confirmpassword").val(); 
		
		if (confirmpassword == user.password) 
		{
			var ajaxCore = new AjaxCore(); 
			var request = ajaxCore.sendRequestType(gridUrl + "/add", user, "post"); 
		
			request.success(function(data, status, xhrObj)
			{
				if (data.messageCode < 0)
				{
					showMessage(data.messageDescription);
				}
				else 
				  goToPage(mainPage);
				
			});
		}
	}
	
	
</script>    

<div class="form dataEntry">
		
  <div class="sectionalForm"> 
   <div class="leftSection">
	<div class="labelSection">User name</div><div class="inputSection"><input type="text" id="username" value="username"/></div>
   </div> 
	
	<div class="rightSection">
		<div class="inlineLabelSection">Disabled</div><div class="inlineLabelSection"><input type="checkbox" id="Enabled" /></div>
	</div>
  </div>
	
    <div class="formRow">
		<div class="labelSection">Name</div><div class="inputSection"><input type="text" id="Name" value="Name"/></div>
    </div>

	<div class="formRow">
		<div class="labelSection">Password</div><div class="inputSection"><input type="password" id="password" value="password"/></div>
	</div>

	<div class="formRow">
		<div class="labelSection">Confirm Password</div><div class="inputSection"><input type="password" id="confirmpassword" value="password"/></div>
	</div>
	
	<div class="formRow">
		<div class="messageSection"></div>
	</div>
	
	<div class="formRow">
	</div>

	<div> 
		<div class="command"><button type="button" id="saveBtn">Save</button>
		<button type="button" id="cancelBtn">Cancel</button>
		</div>
	</div>
   
   <div>&nbsp;
   </div>
  
    <div>
	 <div>  &nbsp;
	 </div>
	</div>
</div>

<%@ include file="/includes/footer.html" %>

</body>
</html>
