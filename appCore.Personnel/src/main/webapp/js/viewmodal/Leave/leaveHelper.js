var LeaveHelper = function () {

    var globalLeaveEntitlementGetUrl = globalHostname + "/app/Calendar/HolidayEntitlementType/get";
    var globalLeaveEntitlementListByCompanyUrl = globalHostname + "/app/Calendar/HolidayEntitlementType/listByCompany";
    var globalLeaveEntitlementDeleteUrl = globalHostname + "/app/Calendar/HolidayEntitlementType/delete";
    var globalLeaveEntitlementSaveOrUpdateUrl = globalHostname + "/app/Calendar/HolidayEntitlementType/saveOrUpdate";

    var globalReplacementTypeSaveOrUpdateUrl = globalHostname + "/app/Calendar/HolidayReplacementType/saveOrUpdate";
    var globalReplacementTypeGetUrl = globalHostname + "/app/Calendar/HolidayReplacementType/get";
    var globalLeaveReplacementTypeDeleteUrl = globalHostname + "/app/Calendar/HolidayReplacementType/delete";
    var globalReplacementTypeListByCompanyUrl = globalHostname + "/app/Calendar/HolidayReplacementType/listByCompany";

    var globalLeaveEarningSchemeSaveOrUpdateUrl = globalHostname + "/app/Calendar/HolidayLeaveEarningScheme/saveOrUpdate";
    var globalLeaveEarningSchemeGetUrl = globalHostname + "/app/Calendar/HolidayLeaveEarningScheme/get";
    var globalLeaveEarningSchemeListByCompanyUrl = globalHostname + "/app/Calendar/HolidayLeaveEarningScheme/listByCompany";
    var globalLeaveEarningSchemeDeleteUrl = globalHostname + "/app/Calendar/HolidayLeaveEarningScheme/delete";

    var globalEmployeeHolidayGetUrl = globalHostname + "/app/Calendar/EmployeeHoliday/get";
    var globalEmployeeHolidaySaveOrUpdateUrl = globalHostname + "/app/Calendar/EmployeeHoliday/saveOrUpdate";

    this.listByCompanyEmployee = function (entityData) {
        var ajaxCore = new AjaxCore();
        return ajaxCore.sendRequest(globalEmployeeListByCompanyUrl, entityData, "get");
    }

    this.listByCompanyHolidayEntitlementType = function (entityData) {
        var ajaxCore = new AjaxCore();
        return ajaxCore.sendRequest(globalLeaveEntitlementListByCompanyUrl, entityData, "get");
    }


    this.listByCompanyHolidayLeaveEarningScheme = function (entityData) {
        var ajaxCore = new AjaxCore();
        return ajaxCore.sendRequest(globalLeaveEarningSchemeListByCompanyUrl, entityData, "get");
    }

    this.listByCompanyLeaveReplacementType = function (entityData) {
        var ajaxCore = new AjaxCore();
        return ajaxCore.sendRequest(globalReplacementTypeListByCompanyUrl, entityData, "get");
    }

    this.getEmployeeHoliday = function (entityData) {
        var ajaxCore = new AjaxCore();
        return ajaxCore.sendRequest(globalEmployeeHolidayGetUrl, entityData, "get");
    }

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

    this.getLeaveApprovalProcess = function (entityData, callBack) {
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

    this.saveUpdateEmployeeHoliday = function (entityData, callBack) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestType(globalEmployeeHolidaySaveOrUpdateUrl, entityData, "post");
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
