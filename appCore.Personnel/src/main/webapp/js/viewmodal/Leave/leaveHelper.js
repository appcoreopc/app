var LeaveHelper = function () {

    this.getHolidayEntitlementType = function (entityData, callBack) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequest(globalLeaveEntitlementGetUrl, entityData, "get");
        request.success(function (data, status, xhrObj) {
            callBack(data);
        });
    }

    this.getHolidayLeaveEarningScheme = function (entityData, callBack) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequest(globalLeaveEarningSchemeGetUrl, entityData, "get");
        request.success(function (data, status, xhrObj) {
            callBack(data);
        });
    }

    this.getHolidayReplacementType = function (entityData, callBack) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequest(globalReplacementTypeGetUrl, entityData, "get");
        request.success(function (data, status, xhrObj) {
            callBack(data);
        });
    }

    this.deleteHolidayEntitlementType = function (data, callback) {
        var objectId = { "id":data.nid };
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestSequential(globalLeaveEntitlementDeleteUrl, objectId, "get");
        request.success(function (resultData) {
            callback(resultData, data);
        });
    }

    this.saveUpdateHolidayEntitlementType = function (entityData, callBack) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestType(globalLeaveEntitlementSaveOrUpdateUrl, entityData, "post");
        request.success(function (data, status, xhrObj) {
            callBack(data);
        });
    }

    this.saveUpdateHolidayLeaveEarningScheme = function (entityData, callBack) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestType(globalLeaveEarningSchemeSaveOrUpdateUrl, entityData, "post");
        request.success(function (data, status, xhrObj) {
            callBack(data);
        });
    }

    this.saveUpdateHolidayReplacementType = function (entityData, callBack) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestType(globalReplacementTypeSaveOrUpdateUrl, entityData, "post");
        request.success(function (data, status, xhrObj) {
            callBack(data);
        });
    }

    this.deleteHolidayLeaveEarningScheme = function (data, callback) {
        var objectId = { "id":data.nid };
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestSequential(globalLeaveEarningSchemeDeleteUrl, objectId, "get");
        request.success(function (resultData) {
            callback(resultData, data);
        });
    }

    this.deleteHolidayReplacementType = function (data, callback) {
        var objectId = { "id":data.nid };
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestSequential(globalLeaveReplacementTypeDeleteUrl, objectId, "get");
        request.success(function (resultData) {
            callback(resultData, data);
        });
    }

}
