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

    this.getCodeType = function (globalViewModal, id) {
        var companyId = { "id":id };
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestSequential(globalCompanyDeleteUrl, companyId, "get");
        request.success(function (data) {
            return data.messageCode;
        });
    }

}