<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AppCore</title>
</head>
<body>

<link href="css/header.css" media="screen" rel="stylesheet" type="text/css" />
<link href="css/default.css" media="screen" rel="stylesheet" type="text/css" />
<link href="css/login.css" media="screen" rel="stylesheet" type="text/css" />
<link href="css/ui-darkness/jquery-ui-1.8.23.custom.css" media="screen" rel="stylesheet" type="text/css" />

<script language="javascript" src="js/ajaxCore.js"></script>

<script language="javascript" src="js/jquery-1.7.2.min.js"></script>
<script language="javascript" src="js/jquery-ui-1.8.23.custom.min.js"></script>
<script language="javascript" src="js/carousel.js"></script>

<%@ include file="includes/header.html" %>

<script type="text/javascript">                                         
   
   var User = function()
   {
		this.Nid; 
		this.Username; 
		this.Password;
		this.LastLogin; 
   }
   
   
   var usernameDialog = "usernameDialog";
   var passwordDialog = "passwordDialog";
   
   $(document).ready(function() 
   {
		
		$("#username").focusin(function() 
		{
		
			setControlText("username", usernameDialog, "Please enter your name.");
		
			/* $( "#" + usernameDialog).dialog("destroy");
			$( "#" + passwordDialog).dialog("destroy");
			
			$( "#" + usernameDialog).remove();
			$( "#" + passwordDialog).remove();
			
			var uiWidth = $( "#username").width();
			var uiPosition = $( "#username").position();
			uiPositionLeft = uiPosition.left + uiWidth + 30;
			
			$("<div id='" + usernameDialog + "'>Please enter your username.</div>").appendTo("body").dialog(
			{ 
				position : [uiPositionLeft, uiPosition.top], 
				height : '80', 
				closeOnEscape : false,
				open: function(event, ui) 
					{ 
						$(".ui-dialog-titlebar").hide(); 
					}
			}); */
		});
		
		$("#password").focusin(function() 
		{
			setControlText("password", passwordDialog, "Please enter your password.");
		});
		
		
		
		$("#loginBtn").click(function() 
		{
				var user = new User(); 
				user.Username = $("#username").val();
				user.Password = $("#password").val();
				
				var ajax = new AjaxCore(); 
				var request = ajax.sendRequest("http://localhost:8080/appCore-personnel/app/Users/Users/validateLogin", user, "get");
				
				request.success(function(msg)
				{
				
					if (msg.messageCode == 0)
					{
						window.location.replace("landingpage.jsp");
					}
					else 
					{
						$("#loginInfo").addClass("errorMessage");
						$("#loginInfo").html(msg.messageDescription);
					}
				});
		})
	});
	
	function setControlText(triggeringControlId, controlId, textMessage) 
	{
			
			$(".ui-dialog").dialog("destroy");
			$(".ui-dialog").remove();
			
			$( "#" + controlId).dialog("destroy");
			$( "#" + controlId).remove();
			
			var uiWidth = $( "#" + triggeringControlId).width();
			var uiPosition = $( "#" + triggeringControlId).position();
			uiPositionLeft = uiPosition.left + uiWidth + 16;
			
			$("<div id='" + controlId + "'>" + textMessage +  "</div>").appendTo("body").dialog(
			{ 
				position : [uiPositionLeft, uiPosition.top], 
				height : '80', 
				closeOnEscape : false,
				open: function(event, ui) 
					{ 
						$(".ui-dialog-titlebar").hide(); 
					}
			});
	}
	

 </script>    

<div class="mainView"> 
 
 <div class="form dataEntry">
	
	<div class="formRow">
   		<div id="loginInfo" /> 
	 </div>
	 
	 <div class="formRow loginform">
   		<h1> Login to Human Resource Management</h1>
	 </div>
	 
	<div class="formRow">
   		<div class="labelSection">Username</div><div class="inputSection"><input type="text" id="username" name="username" value="" /> </div>
	 </div>
	 
	<div class="formRow">
		<div class="labelSection">Password</div><div class="inputSection"><input type="password" id="password" name="password" value="" /></div>
	</div> 

	<div class="spacer">
	 </div>
	<div class="command"> 
		<button type="button" id="loginBtn">Login</button>
		<button type="button" id="cancelBtn">Cancel</button>
	</div>
</div> 

</div>

<%@ include file="includes/footer.html" %>

</body>
</html>


