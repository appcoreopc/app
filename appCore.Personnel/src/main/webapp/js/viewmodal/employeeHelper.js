var EmployeeHelper = function () {
    this.createDialogObject = function (title, message) {
        var dialogObject = { title:title, message:message, targetId:"confirmDiv" }
        return dialogObject;
    }

    this.getEnableAdd = function (aud) {
        if (aud.indexOf("A") > -1)
            return true;
        return false;
    }

    this.getEnableUpdate = function (aud) {
        if (aud.indexOf("U") > -1)
            return true;
        return false;
    }

    this.getEnableDelete = function (aud) {
        if (aud.indexOf("D") > -1)
            return true;
        return false;
    }


    this.getCancelInfo = function () {

        var cancelLinkInfo =
        {
            "text":"Cancel",
            //"icon":"icon-plus",
            "commandId":'ContactCancel',
            "link":this.centerPage,
            "targetControlId":"#userCommand",
            "callback":function () {
                cancelButton();
            }
        };

        return cancelLinkInfo;
    }

    function cancelButton() {
        var dialog = new CoreDialog();
        dialog.closeDialog("formDiv");
    }

    this.closeDialog = function () {
        var dialog = new CoreDialog();
        dialog.closeDialog("formDiv");
    }

    this.loadEmployeeAddPage = function () {
        var centerPage = "employeeAdd.jsp";
        preparePageForLoading(centerPage);
    }

    this.getIndustryCode = function (list) {
        var ajaxCore = new AjaxCore();
        var industryRequest = ajaxCore.sendRequestType(globalEmployeeIndustryList, null, "get");

        industryRequest.success(function (data, status, xhrObj) {
            for (var i = 0; i < data.length; i++) {
                var obj = data[i];
                list.push(obj);
            }
        });
    }

    this.getIndustryCodeByCompany = function (list, entity) {

        var entityObject = { "id":entity };

        var ajaxCore = new AjaxCore();
        var industryRequest = ajaxCore.sendRequest(globalEmployeeIndustryListByCompany, entityObject, "get");
        industryRequest.success(function (data, status, xhrObj) {
            for (var i = 0; i < data.length; i++) {
                var obj = data[i];
                list.push(obj);
            }
        });
    }


    this.deleteEmployee = function (targetData, callback) {
        var objectId = { "id":targetData.nid };
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestSequential(globalEmployeeDeleteUrl, objectId, "get");
        request.success(function (resultData) {
            callback(resultData, targetData);
        });
    }

    this.getSpecialtyCode = function (list) {
        var ajaxCore = new AjaxCore();
        var specialtyRequest = ajaxCore.sendRequestType(globalEmployeeSpecialtyList, null, "get");

        specialtyRequest.success(function (data, status, xhrObj) {
            for (var i = 0; i < data.length; i++) {
                var obj = data[i];
                list.push(obj);
            }
        });
    }

    this.getSpecialtyCodeByCompany = function (list, entity) {

        var entityObject = { id:entity };
        var ajaxCore = new AjaxCore();
        var specialtyRequest = ajaxCore.sendRequest(globalEmployeeSpecialtyListByCompany, entityObject, "get");

        specialtyRequest.success(function (data, status, xhrObj) {
            for (var i = 0; i < data.length; i++) {
                var obj = data[i];
                list.push(obj);
            }
        });
    }


    this.getIndustryCodeSequential = function () {
        var ajaxCore = new AjaxCore();
        console.log("request start");
        var request = ajaxCore.sendRequestSequentialType(globalEmployeeIndustryList, null, "get");
        console.log("request pending");
        return request;

    }


    this.getIndustryCodeAsArray = function () {
        var ajaxCore = new AjaxCore();
        var industryRequest = ajaxCore.sendRequestType(globalEmployeeIndustryList, null, "get");
        industryRequest.success(function (data, status, xhrObj) {
            return data;
        });
    }

    this.getLevelCode = function (list) {
        var ajaxCore = new AjaxCore();

        var levelRequest = ajaxCore.sendRequestType(globalEmployeeLevelList, null, "get");
        levelRequest.success(function (data, status, xhrObj) {
            for (var i = 0; i < data.length; i++) {
                var obj = data[i];
                list.push(obj);
            }
        });
    }

    this.getLevelCodeByCompany = function (list, entity) {

        var entityObject = { id:entity };
        var ajaxCore = new AjaxCore();

        var levelRequest = ajaxCore.sendRequest(globalEmployeeLevelListByCompany, entityObject, "get");
        levelRequest.success(function (data, status, xhrObj) {
            for (var i = 0; i < data.length; i++) {
                var obj = data[i];
                list.push(obj);
            }
        });
    }


    this.getAssociationMemberCode = function (list) {
        var ajaxCore = new AjaxCore();

        var levelRequest = ajaxCore.sendRequestType(globalEmployeeAssociationMemberTypeList, null, "get");
        levelRequest.success(function (data, status, xhrObj) {
            for (var i = 0; i < data.length; i++) {
                var obj = data[i];
                list.push(obj);
            }
        });
    }


    this.getAssociationMemberCodeByCompany = function (list, entity) {
        var entityObject = { id:entity };
        var ajaxCore = new AjaxCore();
        var levelRequest = ajaxCore.sendRequest(globalEmployeeAssociationMemberTypeListByCompany, entityObject, "get");
        levelRequest.success(function (data, status, xhrObj) {
            for (var i = 0; i < data.length; i++) {
                var obj = data[i];
                list.push(obj);
            }
        });
    }


    this.getFamilyMemberCode = function (list) {
        var ajaxCore = new AjaxCore();

        var levelRequest = ajaxCore.sendRequestType(globalEmployeeFamilyMemberTypelList, null, "get");
        levelRequest.success(function (data, status, xhrObj) {
            for (var i = 0; i < data.length; i++) {
                var obj = data[i];
                list.push(obj);
            }
        });
    }

    this.getFamilyMemberCodeByCompany = function (list, entity) {

        var entityObject = { id:entity };
        var ajaxCore = new AjaxCore();

        var levelRequest = ajaxCore.sendRequest(globalEmployeeFamilyMemberTypelList, entityObject, "get");
        levelRequest.success(function (data, status, xhrObj) {
            for (var i = 0; i < data.length; i++) {
                var obj = data[i];
                list.push(obj);
            }
        });
    }


    this.getFieldCode = function (list) {
        var ajaxCore = new AjaxCore();
        var fieldRequest = ajaxCore.sendRequestType(globalEmployeeFieldExpertiseList, null, "get");
        fieldRequest.success(function (data, status, xhrObj) {
            for (var i = 0; i < data.length; i++) {
                var obj = data[i];
                list.push(obj);
            }
        });
    }

    this.getFieldCodeByCompany = function (list, entity) {

        var entityObject = { id:entity };

        var ajaxCore = new AjaxCore();
        var fieldRequest = ajaxCore.sendRequest(globalEmployeeFieldExpertiseListByCompany, entityObject, "get");
        fieldRequest.success(function (data, status, xhrObj) {
            for (var i = 0; i < data.length; i++) {
                var obj = data[i];
                list.push(obj);
            }
        });
    }


    this.getSalutationCode = function (list) {
        var ajaxCore = new AjaxCore();

        var salutationRequest = ajaxCore.sendRequestType(globalEmployeeSalutationList, null, "get");
        salutationRequest.success(function (data, status, xhrObj) {
            for (var i = 0; i < data.length; i++) {
                var obj = data[i];
                list.push(obj);
            }
        });
    }

    this.getSalutationCodeByCompany = function (list, entity) {

        var entityObject = { id:entity };
        var ajaxCore = new AjaxCore();
        var salutationRequest = ajaxCore.sendRequest(globalEmployeeSalutationListByCompany, entityObject, "get");
        salutationRequest.success(function (data, status, xhrObj) {
            for (var i = 0; i < data.length; i++) {
                var obj = data[i];
                list.push(obj);
            }
        });
    }

    this.getCurrencyByCompany = function (list, entity) {
        var entityObject = { id:entity };
        var ajaxCore = new AjaxCore();
        var salutationRequest = ajaxCore.sendRequest(globalCurrencyListByCompany, entityObject, "get");
        salutationRequest.success(function (data, status, xhrObj) {
            for (var i = 0; i < data.length; i++) {
                var obj = data[i];
                list.push(obj);
            }
        });
    }

    this.getCurrency = function (list, entity) {
        var entityObject = { id:entity };
        var ajaxCore = new AjaxCore();
        var salutationRequest = ajaxCore.sendRequest(globalCurrencyList, entityObject, "get");
        salutationRequest.success(function (data, status, xhrObj) {
            for (var i = 0; i < data.length; i++) {
                var obj = data[i];
                list.push(obj);
            }
        });
    }

    this.getCompanyList = function (list) {
        var ajaxCore = new AjaxCore();
        var salutationRequest = ajaxCore.sendRequest(globalCompanyListUrl, null, "get");
        salutationRequest.success(function (data, status, xhrObj) {
            for (var i = 0; i < data.length; i++) {
                var obj = data[i];
                list.push(obj);
            }
        });
    }

    this.getRaceCode = function (list) {
        var ajaxCore = new AjaxCore();

        var salutationRequest = ajaxCore.sendRequestType(globalEmployeeRaceList, null, "get");
        salutationRequest.success(function (data, status, xhrObj) {
            for (var i = 0; i < data.length; i++) {
                var obj = data[i];
                list.push(obj);
            }
        });
    }

    this.getNationalityCode = function (list) {

        var ajaxCore = new AjaxCore();
        var salutationRequest = ajaxCore.sendRequestType(globalEmployeeNationalityList, null, "get");
        salutationRequest.success(function (data, status, xhrObj) {
            for (var i = 0; i < data.length; i++) {
                var obj = data[i];
                list.push(obj);
            }
        });
    }

    this.getReligionCode = function (list) {

        var ajaxCore = new AjaxCore();
        var salutationRequest = ajaxCore.sendRequestType(globalEmployeeReligionList, null, "get");
        salutationRequest.success(function (data, status, xhrObj) {
            for (var i = 0; i < data.length; i++) {
                var obj = data[i];
                list.push(obj);
            }
        });
    }


    this.getRaceCode = function (list) {
        var ajaxCore = new AjaxCore();

        var salutationRequest = ajaxCore.sendRequestType(globalEmployeeRaceList, null, "get");
        salutationRequest.success(function (data, status, xhrObj) {
            for (var i = 0; i < data.length; i++) {
                var obj = data[i];
                list.push(obj);
            }
        });
    }

    this.getCountryCode = function (list) {
        var ajaxCore = new AjaxCore();

        var salutationRequest = ajaxCore.sendRequestType(globalCountryList, null, "get");
        salutationRequest.success(function (data, status, xhrObj) {
            for (var i = 0; i < data.length; i++) {
                var obj = data[i];
                list.push(obj);
            }
        });
    }

    this.getCountryCodeByCompany = function (list, entity) {
        var entityObject = { id:entity };
        var ajaxCore = new AjaxCore();
        var salutationRequest = ajaxCore.sendRequest(globalCountryListByCompany, entityObject, "get");
        salutationRequest.success(function (data, status, xhrObj) {
            for (var i = 0; i < data.length; i++) {
                var obj = data[i];
                list.push(obj);
            }
        });
    }

    this.getGenderCode = function (list) {
        var ajaxCore = new AjaxCore();
        var genderRequest = ajaxCore.sendRequestType(globalEmployeeGenderList, null, "get");
        genderRequest.success(function (data, status, xhrObj) {
            for (var i = 0; i < data.length; i++) {
                var obj = data[i];
                list.push(obj);
            }
        });
    }

    this.getGenderCodeByCompany = function (list, entity) {
        var entityObject = { id:entity };
        var ajaxCore = new AjaxCore();
        var genderRequest = ajaxCore.sendRequest(globalEmployeeGenderListByCompany, entityObject, "get");
        genderRequest.success(function (data, status, xhrObj) {
            for (var i = 0; i < data.length; i++) {
                var obj = data[i];
                list.push(obj);
            }
        });
    }

    this.getMaritalStatusCodeByCompany = function (list, entity) {
        var entityObject = { id:entity };
        var ajaxCore = new AjaxCore();
        var maritalRequest = ajaxCore.sendRequest(globalEmployeeMaritalStatusListByCompany, entityObject, "get");
        maritalRequest.success(function (data, status, xhrObj) {
            for (var i = 0; i < data.length; i++) {
                var obj = data[i];
                list.push(obj);
            }
        });
    }

    this.getMaritalStatusCode = function (list) {
        var ajaxCore = new AjaxCore();
        var maritalRequest = ajaxCore.sendRequestType(globalEmployeeMaritalStatusList, null, "get");
        maritalRequest.success(function (data, status, xhrObj) {
            for (var i = 0; i < data.length; i++) {
                var obj = data[i];
                list.push(obj);
            }
        });
    }

    this.getDate = function (date) {
        if (date == null)
            return null;

        var day = date.substr(0, 2);
        var month = date.substr(3, 2);
        var year = date.substr(6, 4);

        var newDate = new Date(year, month, day);
        return newDate.format(year + "-" + month + "-" + day + " 00:00:00");
    }

    this.getDateTimestamp = function (date) {
        if (date == null)
            return null;

        return date.format("{FullYear}-{Month:2}-{Date:2} 00:00:00");
    }

    this.getDateOnly = function (date) {
        if (date == null)
            return null;
        return date.format("{Date:2}-{Month:2}-{FullYear}");
    }

    this.getDateFormatMMDDYYYY = function (givenDate, customSeparator) {
        var dataSeparator = "-";

        if (customSeparator != undefined)
            dataSeparator = customSeparator;

        var formattedDate = givenDate.getDate() + dataSeparator + this.getActualMonth(givenDate.getMonth()) +
            dataSeparator + givenDate.getFullYear();

        return formattedDate;
    }

    this.getActualMonth = function (value) {
        switch (value) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 4;
            case 4:
                return 5;
            case 5:
                return 6;
            case 6:
                return 7;
            case 7:
                return 8;
            case 8:
                return 9;
            case 9:
                return 10;
            case 10:
                return 11;
            case 11:
                return 12;
        }
    }

    this.isValidDate = function (d) {
        if (Object.prototype.toString.call(d) !== "[object Date]")
            return false;
        return !isNaN(d.getTime());
    }


    this.findCodeInList = function (code, codeList) {

        for (var i = 0; i < codeList.length; i++) {
            var element = codeList[i];
            if (element.nid == code) {
                return element.name;
            }
        }
        return "<Empty>";
    }

    this.getEditMode = function (mode) {
        switch (mode) {
            case 0:
                return "List";
            case 1:
                return "Add";
            case 2:
                return "Edit";
            default:
                return "";
        }
    }

    /*
     self.targetId = ko.observable();
     self.editMode = ko.observable();
     self.applicationScopeType = ko.observable();
     */

    this.setMaintenanceCodeEditMode = function (globalViewModel, id) {
        globalViewModel.targetId(id);
        globalViewModel.editMode(coreModeEdit);
        globalViewModel.applicationScopeType(coreApplicationTypeCode);
    }

    this.setMaintenanceCodeInsertMode = function (globalViewModel, id) {
        globalViewModel.targetId(id);
        globalViewModel.editMode(coreModeInsert);
        globalViewModel.applicationScopeType(coreApplicationTypeCode);
    }


    this.setCompanyEditMode = function (globalViewModel, id) {
        globalViewModel.targetId(id);
        globalViewModel.editMode(coreModeEdit);
        globalViewModel.applicationScopeType(coreApplicationTypeCompany);

    }

    this.setCompanyInsertMode = function (globalViewModel, id) {
        globalViewModel.targetId(id);
        globalViewModel.editMode(coreModeInsert);
        globalViewModel.applicationScopeType(coreApplicationTypeCompany);
    }

    this.setCompanyListMode = function (globalViewModel) {
        globalViewModel.editMode(coreModeList);
        globalViewModel.applicationScopeType(coreApplicationTypeCompany);
    }

    this.resetTargetIdNull = function (globalViewModel) {
        globalViewModel.targetId(null);
        globalViewModel.editMode(null);
        globalViewModel.applicationScopeType(null);

    }

}


Date.prototype.format = function (fmt) {
    var date = this;

    return fmt.replace(
        /\{([^}:]+)(?::(\d+))?\}/g,
        function (s, comp, pad) {
            var fn = date["get" + comp];

            if (fn) {
                var v = (fn.call(date) +
                    (/Month$/.test(comp) ? 1 : 0)).toString();

                return pad && (pad = pad - v.length)
                    ? new Array(pad + 1).join("0") + v
                    : v;
            } else {
                return s;
            }
        });
};


/*

 ko.bindingHandlers.datepicker = {

 init:function (element, valueAccessor, allBindingsAccessor)
 {
 //initialize datepicker with some optional options
 var options = allBindingsAccessor().datepickerOptions || {};

 //$(element).datepicker(options);
 $(element).datepicker({ dateFormat : "dd-mm-yy"});

 // $(element).after("<i class='icon-calendar'></i>");

 //handle the field changing
 ko.utils.registerEventHandler(element, "change", function () {
 var observable = valueAccessor();
 //$(element).datepicker( "option", "dateFormat", options);
 //$(element).datepicker( "option", "dateFormat", "yyyy-mm-dd");
 observable($(element).datepicker("getDate"));
 });

 //handle disposal (if KO removes by the template binding)
 ko.utils.domNodeDisposal.addDisposeCallback(element, function () {
 $(element).datepicker("destroy");
 });

 },
 update:function (element, valueAccessor) {

 var value = ko.utils.unwrapObservable(valueAccessor());
 var current = $(element).datepicker("getDate");
 if (value - current !== 0) {
 $(element).datepicker("setDate", current);
 }
 }
 };
 ;

 */


/*
 ko.bindingHandlers.datepicker = {
 init: function (element, valueAccessor, allBindingsAccessor) {
 //initialize datepicker with some optional options
 var options = allBindingsAccessor().datepickerOptions || {};
 $(element).datepicker(options);

 var value = ko.utils.unwrapObservable(valueAccessor());
 if (value != null)
 $(element).datepicker("setDate", value);

 //handle the field changing
 ko.utils.registerEventHandler(element, "change", function () {
 var observable = valueAccessor();
 observable($(element).val());

 //alert($(element).val());
 //alert($(element).datepicker("getDate"));
 //if (observable.isValid()) {
 //    observable($(element).datepicker("getDate"));
 //    $(element).blur();
 //}
 });

 //handle disposal (if KO removes by the template binding)
 ko.utils.domNodeDisposal.addDisposeCallback(element, function () {
 $(element).datepicker("destroy");
 });

 // ko.bindingHandlers.validationCore.init(element, valueAccessor, allBindingsAccessor);

 },
 update: function (element, valueAccessor) {
 var value = ko.utils.unwrapObservable(valueAccessor());

 //handle date data coming via json from Microsoft
 //if (String(value).indexOf('/Date(') == 0) {
 //    value = new Date(parseInt(value.replace(/\/Date\((.*?)\)\//gi, "$1")));
 //}

 var current = $(element).datepicker("getDate");

 if (value - current !== 0) {
 $(element).datepicker("setDate", value);
 }
 }
 };



 */

ko.bindingHandlers.datepicker = {
    init:function (element, valueAccessor, allBindingsAccessor) {
        //initialize datepicker with some optional options
        var options = allBindingsAccessor().datepickerOptions || {};
        $(element).datepicker(options);

        $(element).after("<i class='icon-calendar'></i>");

        var value = ko.utils.unwrapObservable(valueAccessor());
        if (value != null)
            $(element).datepicker("setDate", value);

        //handle the field changing
        ko.utils.registerEventHandler(element, "change", function () {
            var observable = valueAccessor();
            observable($(element).val());

            //alert($(element).val());
            //alert($(element).datepicker("getDate"));
            //if (observable.isValid()) {
            //    observable($(element).datepicker("getDate"));
            //    $(element).blur();
            //}
        });

        //handle disposal (if KO removes by the template binding)
        ko.utils.domNodeDisposal.addDisposeCallback(element, function () {
            $(element).datepicker("destroy");
        });

        // ko.bindingHandlers.validationCore.init(element, valueAccessor, allBindingsAccessor);

    },
    update:function (element, valueAccessor) {
        var value = ko.utils.unwrapObservable(valueAccessor());

        //handle date data coming via json from Microsoft
        //if (String(value).indexOf('/Date(') == 0) {
        //    value = new Date(parseInt(value.replace(/\/Date\((.*?)\)\//gi, "$1")));
        //}

        var current = $(element).datepicker("getDate");

        if (value - current !== 0) {
            $(element).datepicker("setDate", value);
        }
    }
};


/*

 codepicker:
 it is a control that is used to evaluate if code exist
 and created within the system.

 */

ko.bindingHandlers.codepicker = {

    init:function (element, valueAccessor, allBindingsAccessor) {

        $(element).after("<i class='icon-tag-1'></i>");

        var value = ko.utils.unwrapObservable(valueAccessor());

        //handle the field changing
        ko.utils.registerEventHandler(element, "change", function () {
            var observable = valueAccessor();
            observable($(element).val());
        });

        //handle disposal (if KO removes by the template binding)
        ko.utils.domNodeDisposal.addDisposeCallback(element, function () {
            $(element).datepicker("destroy");
        });

    },
    update:function (element, valueAccessor, allBindingsAccessor, viewModel) {

        //initialize with some optional options
        var options = allBindingsAccessor().codeEntity;

        if (options != undefined) {
            var value = ko.utils.unwrapObservable(valueAccessor());

            var codeTypeOption = options.codeType;
            var companyIdOption = options.companyId;

            var codeEntity = {
                codeName:value,
                codeType:parseInt(codeTypeOption),
                companyId:parseInt(companyIdOption)
            };

            if (value != undefined && value != "") {
                var ajaxCore = new AjaxCore();
                var request = ajaxCore.sendRequestType(globalCodeCheckExist, codeEntity, "post");
                request.success(function (data, status, xhrObj) {
                    if (data.messageCode == 0) {
                        $(element).next('i').next('span').remove();
                        $(element).next('i').after("<span><i class=icon-ok-circle-1></i></span>");
                    }
                    else {
                        if (viewModel.errorInForm != undefined) {
                            viewModel.errorInForm(true);
                        }
                        $(element).next('i').next('span').remove();
                        $(element).next('i').after("<span><i class=icon-cancel-circle-1></i></span>");

                    }
                });
            }
        }
    }
};

ko.bindingHandlers.tcodepicker = {

    init:function (element, valueAccessor, allBindingsAccessor) {

        $(element).after("<i class='icon-tag-1'></i>");

        var value = ko.utils.unwrapObservable(valueAccessor());

        //handle the field changing
        ko.utils.registerEventHandler(element, "change", function () {
            var observable = valueAccessor();
            observable($(element).val());
        });

        //handle disposal (if KO removes by the template binding)
        ko.utils.domNodeDisposal.addDisposeCallback(element, function () {
            $(element).datepicker("destroy");
        });

    },
    update:function (element, valueAccessor, allBindingsAccessor, viewModel) {

        //initialize with some optional options
        var options = allBindingsAccessor().codeEntity;

        if (options != undefined) {
            var value = ko.utils.unwrapObservable(valueAccessor());

            var codeTypeOption = options.codeType;
            var companyIdOption = options.companyId;

            var codeEntity = {
                codeName:value,
                codeType:parseInt(codeTypeOption),
                companyId:parseInt(companyIdOption)
            };

            if (value != undefined && value != "") {
                var ajaxCore = new AjaxCore();
                var request = ajaxCore.sendRequestType(globalCodeCheckExist, codeEntity, "post");
                request.success(function (data, status, xhrObj) {
                    if (data.messageCode == 0) {
                        $(element).next('i').next('span').remove();
                        $(element).next('i').after("<span><i class=icon-ok-circle-1></i></span>");
                    }
                    else {

                        if (viewModel.errorInForm != undefined) {
                            viewModel.errorInForm(true);
                            console.log(viewModel.errorInForm());
                        }

                        $(element).next('i').next('span').remove();
                        $(element).next('i').after("<span><i class=icon-cancel-circle-1></i></span>");

                    }
                });
            }
        }
    }
};

