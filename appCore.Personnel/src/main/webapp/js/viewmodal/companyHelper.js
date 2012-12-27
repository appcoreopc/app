var CompanyHelper = function () {
    this.deleteCompany = function (id) {
        var objectId = { "id":id };
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestSequential(globalCompanyDeleteUrl, objectId, "get");
        request.success(function (data) {
            return data.messageCode;
        });
    }

    this.deleteBranch = function (targetData, callback) {
        var objectId = { "id":targetData.nid };
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestSequential(globalBranchDeleteUrl, objectId, "get");
        request.success(function (resultData) {
            callback(resultData, targetData);
        });
    }

    this.deleteDivision = function (targetData, callback) {
        var objectId = { "id":targetData.nid };
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestSequential(globalDivisionDeleteUrl, objectId, "get");
        request.success(function (resultData) {
            callback(resultData, targetData);
        });
    }


    this.deleteUnit = function (targetData, callback) {
        var objectId = { "id":targetData.nid };
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestSequential(globalUnitDeleteUrl, objectId, "get");
        request.success(function (resultData) {
            callback(resultData, targetData);
        });
    }

    this.deleteDepartment = function (targetData, callback) {
        var objectId = { "id":targetData.nid };
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestSequential(globalDepartmentDeleteUrl, objectId, "get");
        request.success(function (resultData) {
            callback(resultData, targetData);
        });
    }

    this.deleteSection = function (targetData, callback) {
        var objectId = { "id":targetData.nid };
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestSequential(globalSectionDeleteUrl, objectId, "get");
        request.success(function (resultData) {
            callback(resultData, targetData);
        });
    }


    this.saveUpdateBranch = function (branchData, callBack) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestType(globalBranchSaveOrUpdateUrl, branchData, "post");
        request.success(function (data, status, xhrObj) {
            callBack(data);
        });
    }

    this.getBranch = function (branchData, callBack) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequest(globalBranchGetUrl, branchData, "get");
        request.success(function (data, status, xhrObj) {
            callBack(data);
        });
    }

    this.deleteBranchInfo = function (branchData, data, callBack)
    {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequest(globalBranchInfoDeleteUrl, branchData, "get");
        request.success(function (responseData, status, xhrObj) {
            callBack(responseData, data);
        });
    }

    this.saveOrUpdateBranchInfo = function (branchData, callBack) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestType(globalBranchInfoSaveOrUpdateUrl, branchData, "post");
        request.success(function (data, status, xhrObj) {
            callBack(data);
        });
    }

    this.getCodeType = function (globalViewModal, id) {
        var companyId = { "id":id };
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestSequential(globalCompanyDeleteUrl, companyId, "get");
        request.success(function (data) {
            return data.messageCode;
        });
    }
}