/*
 Mode :
 0 - readonly
 1 - edit with just a link
 2 - edit with add/cancel feature
 3 - delete grid view
 4 - enabled all grid feature
 */

var CoreDialog = function () {
    this.createMessageBox = function (dialogControlData) {

        $(".ui-dialog").dialog("destroy");
        $(".ui-dialog").remove();

        $("#" + dialogControlData.dialogControlId).dialog("destroy");
        $("#" + dialogControlData.dialogControlId).remove();

        var uiWidth = $("#" + dialogControlData.bindingControlId).width();
        var uiPosition = $("#" + dialogControlData.bindingControlId).position();
        uiPositionLeft = uiPosition.left + uiWidth + 16;

        $("<div id='" + dialogControlData.dialogControlId + "'>" + dialogControlData.textMessage + "</div>").appendTo("body").dialog(
            {
                position:[uiPositionLeft, uiPosition.top],
                height:'80',
                title:dialogControlData.title,
                closeOnEscape:false,
                open:function (event, ui) {

                }
            });
    }

    this.createLoadDialog = function (commandObjects) {

        $("<div id='" + commandObjects.targetId + "'>" + "</div>").appendTo("body");

        $("#" + commandObjects.targetId).dialog(
            {
                title:commandObjects.title,
                position:'center',
                modal:true,
                height:"auto",
                width: 850,
                open:function () {
                    $("#" + commandObjects.targetId).load(commandObjects.url, function () {
                    });
                }
            }
        );
    }

    this.closeDialog = function (targetId) {
        $("#" + targetId).dialog('close');
    }
}