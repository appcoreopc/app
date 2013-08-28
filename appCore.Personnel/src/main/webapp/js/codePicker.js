/*
 codepicker :
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

        });

    },
    update:function (element, valueAccessor, allBindingsAccessor, viewModel) {

        //initialize with some optional options
        var options = allBindingsAccessor().codeEntity;
        var mode = viewModel.mode();
        var oldCodeValue = ko.utils.domData.get(element, "code");

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
                if (oldCodeValue == undefined || oldCodeValue == null) {
                    console.log('setting value for the first time');
                    $(element).val(value);
                    ko.utils.domData.set(element, "code", value);
                }

                oldCodeValue = ko.utils.domData.get(element, "code");
                console.log('oldCodeValue');
                console.log(oldCodeValue);
                console.log('value');
                console.log(value);

                if (oldCodeValue != value) {

                    console.log('executing web request');
                    var ajaxCore = new AjaxCore();
                    var request = ajaxCore.sendRequestType(globalCodeCheckExist, codeEntity, "post");

                    request.success(function (data, status, xhrObj) {
                        if (data.messageCode == 0) {
                            $(element).next('i').next('span').remove();
                            $(element).next('i').after("<span><i class=icon-ok-circle-1></i></span>");
                            if (viewModel.errorInForm != undefined) {
                                viewModel.errorInForm(false);
                            }
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
                else {
                    $(element).next('i').next('span').remove();
                    $(element).next('i').after("<span><i class=icon-ok-circle-1></i></span>");
                    if (viewModel.errorInForm != undefined) {
                        viewModel.errorInForm(false);
                    }
                }
                // request ends
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
                        }

                        $(element).next('i').next('span').remove();
                        $(element).next('i').after("<span><i class=icon-cancel-circle-1></i></span>");

                    }
                });
            }
        }
    }
};

