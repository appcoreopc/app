function KickStartCore()
{
	this.serverPath="http://localhost/CloudBuild";

    // Load core scripts 
	this.loadScript = function()
	{
		 if (typeof AjaxCore == 'undefined')
			$.getScript(this.serverPath + "/js/ajaxCore.js");  // ajax 
		if (typeof Authenticator == 'undefined')
			$.getScript(this.serverPath + "/js/login/ajaxCore.js");  // authenticator 
	 
	}
     
}