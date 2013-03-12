(function ($) {

    $.fn.setupViewBinding = function (vm, globalViewModel) {
        try {
            // clean previously binded view model
            cleanUpPreviouslyBindedViewModel(globalViewModel.bindedViewModel());

            var currentElementId = $(this).attr('id');

            // apply bindings
            ko.applyBindings(vm, document.getElementById(currentElementId));

            // add record to the bindedViewModel for removal later;
            globalViewModel.bindedViewModel(currentElementId);
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