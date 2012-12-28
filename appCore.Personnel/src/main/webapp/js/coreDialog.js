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
                width:850,
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


    this.createConfirmationDialog = function (dialogObject, data, globalViewModel, codeType, callBack) {

        var overlay = $('<div id="overlay"> </div>');
        overlay.appendTo(document.body);

        var $myDialog = $('<div></div>')
            .html(dialogObject.message)
            .dialog(
            {
                dialogClass:'dialogTop',
                autoOpen:false,
                title:dialogObject.title,
                closeOnEscape:false,
                position:"center",
                show:"fade",
                modal:true,
                closeText:"",
                buttons:{"OK":function () {
                    $("#overlay").remove();
                    $(this).dialog("close");
                    callBack(true, data, globalViewModel, codeType);

                },
                    "Cancel":function () {
                        $("#overlay").remove();
                        $(this).dialog("close");
                        callBack(false, data, globalViewModel, codeType);
                    }
                }
            });

        $myDialog.dialog('open');
        //$('#' + dialogObject.targetId).scrollTop("0");
    }
}