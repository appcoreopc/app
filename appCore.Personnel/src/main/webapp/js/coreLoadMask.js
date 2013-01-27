var CoreLoadMask = function () {

    this.bindAjaxEvent = function (imagePath) {

        $("<div id='" + "loadingStatusIndicator" + "'><img src='" + imagePath + "' />" + "</div>").appendTo("body");
        $("#" + "loadingStatusIndicator").bind({
            ajaxStart:function () {
                $(this).show();
            },
            ajaxStop:function () {
                $(this).hide();
            }
        });
    }
}