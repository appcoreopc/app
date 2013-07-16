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
        var request = ajaxCore.sendRequest(globalRoleListByCompanyUrl, entityData, "get");
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

    this.configureRoleResource = function (entityData, callBack) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequest(globalConfigureRoleResourceUrl, entityData, "get");
        request.success(function (data, status, xhrObj) {
            callBack(data);
        });
    }


    this.getResourceList = function (entityData, callBack) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequest(globalResourceListByCompanyUrl, entityData, "get");
        request.success(function (data, status, xhrObj) {
            callBack(data);
        });
    }

    this.updatePassword = function (entityData, callBack) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequest(globalUserPasswordUpdateUrl, entityData, "get");
        request.success(function (data, status, xhrObj) {
               callBack(data);
        });
    }
}
