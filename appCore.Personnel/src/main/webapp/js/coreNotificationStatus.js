var CoreStatusNotification = function () {
    this.createStatusNotification = function () {
        var statusNotificationObject = $('<div id="statusNotification"></div>');
        statusNotificationObject.appendTo(document.body);

        $(document).on("showNotificationStatus", function (e) {
            e.preventDefault();
            $("#statusNotification").show();
            $("#statusNotification").html(e.message);
            $("#statusNotification").fadeOut(1000);
        })

        $(document).on("showNotificationErrorStatus", function (e) {
            e.preventDefault();
            $("#statusNotification").show();
            $("#statusNotification").html(e.message);

        })

        $(document).on("hideNotificationStatus", function (event) {
            $("#statusNotification").fadeOut(1000);
        })

        $(document).on("hideNotificationErrorStatus", function (event) {
            $("#statusNotification").fadeOut(1000);
        })
    }
}

function showStatusNotification(messageToShow) {
    $.event.trigger({
        type:"showNotificationStatus",
        message:messageToShow
    });
}

function showErrorStatusNotification(messageToShow) {
    $.event.trigger({
        type:"showNotificationErrorStatus",
        message:messageToShow
    });
}
