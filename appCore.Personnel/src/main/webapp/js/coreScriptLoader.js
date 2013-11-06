(function ($) {
    $.fn.loadUserScript = function (userId, applicationType) {
        var serviceUrl = globalUserLandingServiceUrlGet;
        var ajaxCore = new AjaxCore();
        var requestData = { 'userId':userId, 'applicationType':applicationType }
        var requestMenu = ajaxCore.sendRequest(serviceUrl, requestData, 'get');
        requestMenu.done(function (data) {
            if (data != null) {

                $.each(data, function (index, value) {
                    if (value.scriptPath != undefined) {
                        if (value.scriptPath != null) {
                            try {
                                $.getScript(value.scriptPath, function (data, textStatus, jqhr) {
                                    $(document).loadControl(userId);
                                });
                            }
                            catch (ex) {
                                throw 'loadable control using loadUserScript must implement loadControl method' + ex.message;
                            }

                        }
                    }
                });
            }
        });
    };
})(jQuery);