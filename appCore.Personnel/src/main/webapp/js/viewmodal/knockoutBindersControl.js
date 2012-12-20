/*
ko.bindingHandlers.datepicker = {

    init:function (element, valueAccessor, allBindingsAccessor) {
        //initialize datepicker with some optional options
        var options = allBindingsAccessor().datepickerOptions || {};
        $(element).datepicker(options);

        $(element).after("<i class='icon-calendar'></i>");

        //handle the field changing
        ko.utils.registerEventHandler(element, "change", function () {
            var observable = valueAccessor();
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

*/
