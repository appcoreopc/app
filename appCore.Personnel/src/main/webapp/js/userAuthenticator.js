var UserAuthenticator = function () {
    this.authenticateUser = function (username, password, callBack) {
        var user = new User();
        user.Username = username;
        user.Password = password;

        var ajax = new AjaxCore();
        var request = ajax.sendRequest(globalUserValidationUrl, user, "get");
        request.success(function (msg) {
            callBack(msg);
        });
    }
}