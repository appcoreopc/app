(function ($) {

    $.fn.initCoreMessageNotification = function (globalViewModel, callback) {

        if (globalViewModel != undefined) {
            var currentElementId = $(this).attr('id');

            globalViewModel.message.subscribe(function (message) {

                if (typeof message != 'undefined') {
                    switch (message.messageType) {
                        case coreMessageInfo:
                            var content = parseInfo(message.message);
                            showMessage(currentElementId, content);
                            break;
                        case coreMessageError:
                            var content = parseError(message.message);
                            showMessage(currentElementId, content);
                            break;
                        case coreMessageWarning:
                            var content = parseInfo(message.message);
                            showMessage(currentElementId, content);
                            break;
                    }
                }

                function parseInfo(message) {
                    var alertContentMarkup = "<div class='alert'>";
                    alertContentMarkup += "<button data-dismiss='alert' class='close' type='button'>×</button>";
                    alertContentMarkup += "<strong>" + message + "</strong></div>";
                    return alertContentMarkup;
                }

                function parseError(message) {
                    var alertContentMarkup = "<div class='alert  alert-error fade in'>";
                    alertContentMarkup += "<button data-dismiss='alert' class='close' type='button'>×</button>";
                    alertContentMarkup += "<strong>" + message + "</strong></div>";
                    return alertContentMarkup;
                }

                function showMessage(ctrl, content) {
                    $("#" + ctrl).html("");
                    $(content).appendTo("#" + ctrl);
                    $("#" + ctrl).fadeIn().delay(2000).fadeOut();
                }
            });
        }
    }
})(jQuery);