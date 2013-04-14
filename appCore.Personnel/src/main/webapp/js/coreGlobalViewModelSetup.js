(function ($) {
    $.fn.setupGlobalViewModel = function ()
    {
        try
        {
            var globalViewModel = new GlobalViewModel();
            globalViewModel.companyId(1);
            globalViewModel.companyName("AppCoreDev");
            globalViewModel.username = sessionStorage.username;
            globalViewModel.employeeRole(sessionStorage.roles);
            ko.applyBindings(globalViewModel, document.getElementById("header"));
            return globalViewModel;
        }
        catch(ex)
        {
            console.log(ex);
        }
    }

})(jQuery);