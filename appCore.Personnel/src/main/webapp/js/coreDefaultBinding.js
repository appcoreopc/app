(function ($) {
    $.fn.setupViewBinding = function (vm, globalViewModel) {
        try {
            if (globalViewModel == undefined) {
                globalViewModel = $(document).setupGlobalViewModel();
            }
            // clean previously binded view model
            cleanUpPreviouslyBindedViewModel(globalViewModel.bindedViewModel());
            var currentElementId = $(this).attr('id');
            // apply bindings
            ko.applyBindings(vm, document.getElementById(currentElementId));
        }
        catch (ex) {
            console.log(ex);
        }
    };

    function cleanUpPreviouslyBindedViewModel(bindedViewModelId) {
        if (bindedViewModelId != null && bindedViewModelId != undefined) {
            if ($("#" + bindedViewModelId).length) {
                ko.cleanNode(bindedViewModelId);
            }
        }
    }

})(jQuery);