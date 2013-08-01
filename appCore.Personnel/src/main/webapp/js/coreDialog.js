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

        $("#" + commandObjects.targetId).load(commandObjects.url, function () {
            $("#" + commandObjects.targetId).dialog(
                {
                    title:commandObjects.title,
                    position:'center',
                    modal:true,
                    width:950
                });
        });
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
                show:{ effect:"fade", duration:800},
                modal:true,
                resizable:false,
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


    }


    // dialogObject - title & message is the main attribute //
    this.createDiscardConfirmationDialog = function (dialogObject, link, callBack) {

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
                show:{ effect:"fade", duration:800},
                modal:true,
                resizable:false,
                closeText:"",
                buttons:{"OK":function () {
                    $("#overlay").remove();
                    $(this).dialog("close");
                    callBack(true, link);

                },
                    "Cancel":function () {
                        $("#overlay").remove();
                        $(this).dialog("close");
                        callBack(false, link);
                    }
                }
            });

        $myDialog.dialog('open');
    }

    this.createPopupDialog = function (dialogObject, target) {

        var $myDialog = $("<div></div>")
            .html(dialogObject.message)
            .dialog(
            {
                dialogClass:'dialogTop',
                autoOpen:false,
                title:dialogObject.title,
                closeOnEscape:false,
                position:{
                    my:'left top',
                    at:'right bottom',
                    of:target
                },
                show:{ effect:"fade", duration:200},
                modal:true,
                resizable:false,
                closeText:"",
                buttons:{"OK":function () {
                    $(this).dialog("close");
                },
                    "Cancel":function () {
                        $(this).dialog("close");
                    }
                }
            });

        $myDialog.dialog('open');

        return $myDialog;
    }


    this.createMenuDialog = function (dialogObject, target) {
        var menuDialog = $("<div id='configureSetupView'></div>");
        menuDialog.appendTo(document.body);

        $("#configureSetupView").click(function () {

        });

    }

    this.createGeneralConfirmationDialog = function (dialogObject, dialogCallBack) {

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
                show:{ effect:"fade", duration:800},
                modal:true,
                resizable:false,
                closeText:"",
                buttons:{"OK":function () {
                    $("#overlay").remove();
                    $(this).dialog("close");
                    dialogCallBack(true);
                }
                }
            });
        $myDialog.dialog('open');
    }
}