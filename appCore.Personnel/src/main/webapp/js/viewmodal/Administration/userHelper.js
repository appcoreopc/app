var UserHelper = function()
{
    this.getUsers = function (entityData, callBack) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequest(globalUserList, entityData, "get");
        request.success(function (data, status, xhrObj) {
            callBack(data);
        });
    }

    this.getUserRoles = function (entityData, callBack) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequest(globalRoleList, entityData, "get");
        request.success(function (data, status, xhrObj) {
            callBack(data);
        });
    }

    this.configureUserRole = function (entityData, callBack) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequest(globalConfigureUserRoleUrl, entityData, "get");
        request.success(function (data, status, xhrObj) {
            callBack(data);
        });
    }
}
