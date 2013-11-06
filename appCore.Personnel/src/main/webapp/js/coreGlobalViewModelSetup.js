(function ($) {
    $.fn.setupGlobalViewModel = function (setupCompleteCallBack) {
        try {

            globalViewModel = new GlobalViewModel();
            globalViewModel.companyId(sessionStorage.companyId);
            globalViewModel.companyName(sessionStorage.companyName);
            globalViewModel.username(sessionStorage.username);
            globalViewModel.userId(sessionStorage.userId);
            globalViewModel.employeeRole(sessionStorage.roles);

            ko.applyBindings(globalViewModel, document.getElementById("header"));

            if (setupCompleteCallBack != undefined) {
                setupCompleteCallBack();
            }
            return globalViewModel;
        }
        catch (ex) {
            console.log(ex);
        }
    }
})(jQuery);