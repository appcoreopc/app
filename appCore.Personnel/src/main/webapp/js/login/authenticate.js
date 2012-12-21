function Authenticator() 
{
   this.serverPath="http://localhost/CloudBuild";
   
  this.authenticate = function() 
  {
	  var userName = $('#username').val();
      var passwd = $('#password').val();
	  
	  if (userName && passwd)
	  {
		  this.authenticateLocalUser(userName, passwd);
	  }
	  else 
	  { 
	     // Remote login with facebook 
	  } 
   }

  this.authenticateLocalUser = function(userName, passwd)
  {
      $.ajax({
		type: "POST",
		url: this.serverPath + "/app_dev.php/Login/Authenticate/",
		data: { username: userName, password: passwd },
		dataType : "json",
		success: function(data) 
		{
		   if (data.success) 
		   {
				alert('success:' + data.name);
		   }
		   else 
		   {
				loginError();
		   }
        }
	}); 
  }

  function loginSucces() 
  {
	window.location.replace(this.serverPath + "/app_dev.php/Login/Success/");
  }

 function loginError()
 {
	window.location.replace(this.serverPath + "/app_dev.php/Login/AuthenticationError/");
 }

}
