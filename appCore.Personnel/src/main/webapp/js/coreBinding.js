(function ($) {
    $.fn.coreBinding = function (vm, globalViewModel) {
        try {
            var currentElementId = $(this).attr('id');
            ko.applyBindings(vm, document.getElementById(currentElementId));
        }
        catch (ex) {
            var myStackTrace = e.stack || e.stacktrace || "";
            console.log(myStackTrace);
        }
    };

})(jQuery);