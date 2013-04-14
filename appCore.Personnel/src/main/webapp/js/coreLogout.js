(function ($) {
    $.fn.setupLogout = function () {
        this.click(function () {

            var logoutControlId = "logoutWindow";
            $("<div id='" + logoutControlId + "'></div>").appendTo("body");

            var logoutWindow = $("#" + logoutControlId);

            logoutWindow.kendoWindow({
                width:"300px",
                height:"160px",
                title:"Logout",
                actions:["Close"]
            });

            logoutWindow.data("kendoWindow").content("<div class='logoutSpacer'></div>" +
                "<div class='logoutSpacer'></div>" +
                "<div class='logoutMessage'>Do you want to logout?</div><div>&nbsp;</div>" +
                "<div class='logoutSpacer'></div>" +
                "<div class='logoutCommand'>" +
                "<button type='button' onclick='" + "window.location.replace(globalIndexPage)'" + ">Logout</button>&nbsp;" +
                "<button type='button' onclick=$('#" + logoutControlId + "').data('kendoWindow').close();>Cancel</button></div>");

            logoutWindow.data("kendoWindow").center().open();
        });
    };
})(jQuery);