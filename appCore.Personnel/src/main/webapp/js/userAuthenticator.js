var UserAuthenticator = function()
{
    this.authenticateUser = function(username, password)
    {
        var user = new User();
        user.Username = username;
        user.Password = password;

        var ajax = new AjaxCore();
        var request = ajax.sendRequest(globalUserValidationUrl, user, "get");
        request.success(function(msg)
        {
            if (msg.messageCode == 0)
            {
                //goToPage(msg.tagetLandingPage);
                goToPage(globallandingPage);
            }
            else
            {
                $("#loginInfo").addClass("errorMessage");
                $("#loginInfo").html(msg.messageDescription);
            }
        });
    }
}