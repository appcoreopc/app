(function ($) {
    $.fn.setupViewBinding = function (vm, globalViewModel) {
        try {

            if (globalViewModel == undefined) {
                globalViewModel = $(document).setupGlobalViewModel();
            }

            var currentElementId = $(this).attr('id');
            if (currentElementId != undefined && currentElementId != null) {
                globalViewModel.bindedControlId(currentElementId);
                ko.applyBindings(vm, document.getElementById(currentElementId));
            }
            else {
                globalViewModel.bindedControlId(null);
            }
        }
        catch (ex) {
            var myStackTrace = ex.stack;
            console.log(myStackTrace);
        }
    };
})(jQuery);