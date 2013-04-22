(function ($) {
    $.fn.setupGlobalViewModel = function ()
    {
        try
        {
            var globalViewModel = new GlobalViewModel();
            globalViewModel.companyId(sessionStorage.companyId);
            globalViewModel.companyName(sessionStorage.companyName);
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