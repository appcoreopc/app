var CompanyHelper = function () {

    /*this.deleteCompany = function (id) {
     var objectId = { "id":id };
     var ajaxCore = new AjaxCore();
     var request = ajaxCore.sendRequestSequential(globalCompanyDeleteUrl, objectId, "get");
     request.success(function (data) {
     return data.messageCode;
     });
     }*/

    this.deleteCompany = function (data, callback) {
        var objectId = { "id":data.nid };
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestSequential(globalCompanyDeleteUrl, objectId, "get");
        request.success(function (resultData) {
            callback(resultData, data);
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


    this.deleteUser = function (targetData, callback) {
        var objectId = { "id":targetData.nid };
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestSequential(globalDeleteUsersUrl, objectId, "get");
        request.success(function (resultData) {
            callback(resultData, targetData);
        });
    }

    this.deleteRole = function (targetData, callback) {
        var objectId = { "id":targetData.nid };
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestSequential(globalRoleDeleteUrl, objectId, "get");
        request.success(function (resultData) {
            callback(resultData, targetData);
        });
    }

    this.deleteResource = function (targetData, callback) {
        var objectId = { "id":targetData.nid };
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestSequential(globalResourceDeleteUrl, objectId, "get");
        request.success(function (resultData) {
            callback(resultData, targetData);
        });
    }

    this.deleteHoliday = function (targetData, callback) {
        var objectId = { "id":targetData.nid };
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestSequential(globalHolidayDeleteUrl, objectId, "get");
        request.success(function (resultData) {
            callback(resultData, targetData);
        });
    }

    this.deleteJobSetup = function (targetData, callback) {
        var objectId = { "id":targetData.nid };
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestSequential(globalJobSetupDeleteUrl, objectId, "get");
        request.success(function (resultData) {
            callback(resultData, targetData);
        });
    }

    this.deleteEmploymentType = function (targetData, callback) {
        var objectId = { "id":targetData.nid };
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestSequential(globalEmploymentTypeDeleteUrl, objectId, "get");
        request.success(function (resultData) {
            callback(resultData, targetData);
        });
    }

    this.deleteGrade = function (targetData, callback) {
        var objectId = { "id":targetData.nid };
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestSequential(globalGradeDeleteUrl, objectId, "get");
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

    this.deleteDepartmentSelected = function (targetData) {
        var objectId = { "id":targetData.nid };
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestSequential(globalDepartmentDeleteUrl, objectId, "get");
        request.success(function (resultData) {
            //callback(resultData, targetData);

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

    this.saveUpdateBranch = function (entityData, callBack) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestType(globalBranchSaveOrUpdateUrl, entityData, "post");
        request.success(function (data, status, xhrObj) {
            callBack(data);
        });
    }

    this.saveUpdateMaintenanceCode = function (codeType, entityData, callBack) {
        var helper = new CodeMaintenanceHelper(codeType);
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestType(helper.getUrl() + "/saveOrUpdate", entityData, "post");
        request.success(function (data, status, xhrObj) {
            callBack(data);
        });
    }

    this.saveUpdateDivision = function (entityData, callBack) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestType(globalDivisionSaveOrUpdateUrl, entityData, "post");
        request.success(function (data, status, xhrObj) {
            callBack(data);
        });
    }

    this.saveUpdateHoliday = function (entityData, callBack) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestType(globalHolidaySaveOrUpdateUrl, entityData, "post");
        request.success(function (data, status, xhrObj) {
            callBack(data);
        });
    }


    this.saveUpdateDepartment = function (entityData, callBack) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestType(globalDepartmentSaveOrUpdateUrl, entityData, "post");
        request.success(function (data, status, xhrObj) {
            callBack(data);
        });
    }

    this.saveUpdateSection = function (entityData, callBack) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestType(globalSectionSaveOrUpdateUrl, entityData, "post");
        request.success(function (data, status, xhrObj) {
            callBack(data);
        });
    }

    this.configureUserRole = function (entityData, callBack) {

        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequest(globalEmployeeGroupConfigureUrl, entityData, "get");
        request.success(function (data, status, xhrObj) {
            callBack(data);
        });
    }

    this.configureEmployeeGroup = function (entityData, callBack) {

        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequest(globalEmployeeGroupConfigureUrl, entityData, "get");
        request.success(function (data, status, xhrObj) {
            callBack(data);
        });
    }

    this.configureHolidayGroup = function (entityData, callBack) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequest(globalHolidayGroupConfigureUrl, entityData, "get");
        request.success(function (data, status, xhrObj) {
            callBack(data);
        });
    }


    this.saveUpdateUnit = function (entityData, callBack) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestType(globalUnitSaveOrUpdateUrl, entityData, "post");
        request.success(function (data, status, xhrObj) {
            callBack(data);
        });
    }

    this.saveUpdateGrade = function (entityData, callBack) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestType(globalGradeSaveOrUpdateUrl, entityData, "post");
        request.success(function (data, status, xhrObj) {
            callBack(data);
        });
    }

    this.saveUpdateEmploymentType = function (entityData, callBack) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestType(globalEmploymentTypeSaveOrUpdateUrl, entityData, "post");
        request.success(function (data, status, xhrObj) {
            callBack(data);
        });
    }

    this.getBranch = function (branchData, callBack) {
        var ajaxCore = new AjaxCore();
        return ajaxCore.sendRequest(globalBranchGetUrl, branchData, "get");
        //var request = ajaxCore.sendRequest(globalBranchGetUrl, branchData, "get");
        //request.success(function (data, status, xhrObj) {
        // callBack(data);
        //});
    }

    this.getMaintenanceCode = function (codeType, maintenanceData, callBack) {
        var ajaxCore = new AjaxCore();
        var helper = new CodeMaintenanceHelper(codeType);
        var dateHelper = new EmployeeHelper();
        var request = ajaxCore.sendRequest(helper.getUrl() + "/get", maintenanceData, "get");

        request.success(function (data, status, xhrObj) {
            callBack(data);
        });
    }


    this.getDivision = function (entityData, callBack) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequest(globalDivisionGetUrl, entityData, "get");
        request.success(function (data, status, xhrObj) {
            callBack(data);
        });
    }

    this.getScriptWidget = function (entityData, callBack) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequest(globalScriptWidgetGetUrl, entityData, "get");
        request.success(function (data, status, xhrObj) {
            callBack(data);
        });
    }

    this.saveUpdateScriptWidget = function (entityData, callBack) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestType(globalSaveUpdateScriptWidgetUrl, entityData, "post");
        request.success(function (data, status, xhrObj) {
            callBack(data);
        });
    }

    this.deleteScriptWidget = function (data, callback) {
        var objectId = { "id":data.nid };
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestSequential(globalScriptWidgetDeleteUrl, objectId, "get");
        request.success(function (resultData) {
            callback(resultData, data);
        });
    }

    this.getHoliday = function (entityData, callBack) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequest(globalHolidaySetupGetUrl, entityData, "get");
        request.success(function (data, status, xhrObj) {
            callBack(data);
        });
    }


    this.getDepartment = function (entityData, callBack) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequest(globalDepartmentGetUrl, entityData, "get");
        request.success(function (data, status, xhrObj) {
            callBack(data);
        });
    }

    this.getSection = function (entityData, callBack) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequest(globalSectionGetUrl, entityData, "get");
        request.success(function (data, status, xhrObj) {
            callBack(data);
        });
    }

    this.getUnit = function (entityData, callBack) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequest(globalUnitGetUrl, entityData, "get");
        request.success(function (data, status, xhrObj) {
            callBack(data);
        });
    }

    this.getJobType = function (entityData, callBack) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequest(globalJobTypeGetUrl, entityData, "get");
        request.success(function (data, status, xhrObj) {
            callBack(data);
        });
    }


    this.getEmployees = function (entityData, callBack) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequest(globalEmployeeListByCompanyUrl, entityData, "get");
        request.success(function (data, status, xhrObj) {
            callBack(data);
        });
    }

    this.getCompanyAllInfo = function (entityData, callBack) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequest(globalGetAllCompanyInfoUrl, entityData, "get");
        request.success(function (data, status, xhrObj) {
            callBack(data);
        });
    }

    this.getEmployeeGroups = function (entityData, callBack) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequest(globalEmployeeGroupListByCompanyUrl, entityData, "get");
        request.success(function (data, status, xhrObj) {
            callBack(data);
        });
    }

    this.getHolidays = function (entityData, callBack) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequest(globalHolidaySetupListByCompanyUrl, entityData, "get");
        request.success(function (data, status, xhrObj) {
            callBack(data);
        });
    }

    this.getHolidayGroups = function (entityData, callBack) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequest(globalHolidayGroupListByCompanyUrl, entityData, "get");
        request.success(function (data, status, xhrObj) {
            callBack(data);
        });
    }


    this.getGrade = function (entityData, callBack) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequest(globalGradeGetUrl, entityData, "get");
        request.success(function (data, status, xhrObj) {
            callBack(data);
        });
    }


    this.getEmploymentType = function (entityData, callBack) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequest(globalEmploymentTypeGetUrl, entityData, "get");
        request.success(function (data, status, xhrObj) {
            callBack(data);
        });
    }

    this.deleteBranchInfo = function (entityData, data, callBack) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequest(globalBranchInfoDeleteUrl, entityData, "get");
        request.success(function (responseData, status, xhrObj) {
            callBack(responseData, data);
        });
    }

    this.deleteDivisionInfo = function (entityData, data, callBack) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequest(globalDivisionInfoDeleteUrl, entityData, "get");
        request.success(function (responseData, status, xhrObj) {
            callBack(responseData, data);
        });
    }


    this.deleteDepartmentInfo = function (entityData, data, callBack) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequest(globalDepartmentInfoDeleteUrl, entityData, "get");
        request.success(function (responseData, status, xhrObj) {
            callBack(responseData, data);
        });
    }


    this.deleteSectionInfo = function (entityData, data, callBack) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequest(globalSectionInfoDeleteUrl, entityData, "get");
        request.success(function (responseData, status, xhrObj) {
            callBack(responseData, data);
        });
    }


    this.deleteUnitInfo = function (entityData, data, callBack) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequest(globalUnitInfoDeleteUrl, entityData, "get");
        request.success(function (responseData, status, xhrObj) {
            callBack(responseData, data);
        });
    }

    this.deleteGradeInfo = function (entityData, data, callBack) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequest(globalGradeInfoDeleteUrl, entityData, "get");
        request.success(function (responseData, status, xhrObj) {
            callBack(responseData, data);
        });
    }

    this.deleteEmploymentTypeInfo = function (entityData, data, callBack) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequest(globalEmploymentTypeInfoDeleteUrl, entityData, "get");
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

    this.saveOrUpdateDivisionInfo = function (branchData, callBack) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestType(globalDivisionInfoSaveOrUpdateUrl, branchData, "post");
        request.success(function (data, status, xhrObj) {
            callBack(data);
        });
    }

    this.saveOrUpdateDepartmentInfo = function (entityData, callBack) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestType(globalDepartmentInfoSaveOrUpdateUrl, entityData, "post");
        request.success(function (data, status, xhrObj) {
            callBack(data);
        });
    }

    this.saveOrUpdateSectionInfo = function (entityData, callBack) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestType(globalSectionInfoSaveOrUpdateUrl, entityData, "post");
        request.success(function (data, status, xhrObj) {
            callBack(data);
        });
    }

    this.saveOrUpdateUnitInfo = function (entityData, callBack) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestType(globalUnitInfoSaveOrUpdateUrl, entityData, "post");
        request.success(function (data, status, xhrObj) {
            callBack(data);
        });
    }


    this.saveOrUpdateGradeInfo = function (entityData, callBack) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestType(globalGradeInfoSaveOrUpdateUrl, entityData, "post");
        request.success(function (data, status, xhrObj) {
            callBack(data);
        });
    }

    this.saveOrUpdateEmploymentTypeInfo = function (entityData, callBack) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestType(globalEmploymentTypeInfoSaveOrUpdateUrl, entityData, "post");
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

    this.saveUpdateCoreModule = function (entityData, callBack) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestType(globalCoreModuleSaveOrUpdateUrl, entityData, "post");
        request.success(function (data, status, xhrObj) {
            callBack(data);
        });
    }

    this.getCoreModule = function (entityData, callBack) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequest(globalCoreModuleGet, entityData, "get");
        request.success(function (data, status, xhrObj) {
            callBack(data);
        });
    }

    this.getSelectedItemGrid = function (dataValue) {
        var arrayToRemove = [];
        // push to a new array
        for (var i = 0; i < dataValue.length; i++) {
            if (dataValue[i].isSelected() == true) {
                arrayToRemove.push({'index':i, 'nid':dataValue[i].nid });
            }
        }
        return arrayToRemove;
    }
}
