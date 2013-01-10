var CoreCommand = function () {

    var deleteCommandId = "deleteBtn";
    var updateCommandId = "updBtn";
    var addCommandId = "addBtn";
    var cancelCommandId = "cancelBtn";
    var cancelCommandText = "Cancel";

    this.parseCommand = function (requestUrl, requestData, commandDataObject) {
        var dataPermission = this.getPermission(requestUrl, requestData);
        var gridViewModel = getCommand(dataPermission, commandDataObject);
        $(document).trigger("parseComplete");
        return gridViewModel;
    }

    this.getPermission = function (requestUrl, requestData) {
        var ajaxCore = new AjaxCore();
        var commandType;
        var request = ajaxCore.sendRequestSequential(requestUrl, requestData, "get");
        request.success(function (data) {
            commandType = data;
        });
        return commandType;
    }

    function getCommand(data, commandDataObject) {

        if (commandDataObject.addLinkInfo.commandId != undefined) {
            addCommandId = commandDataObject.addLinkInfo.commandId;
        }

        if (data == null || data.permission == null) {
            // goToPage(hostname);
        }

        var commandType = data.permission;

        switch (commandType) {
            case "AUD" :
                createAddUpdateDeleteView(commandDataObject);
                break;
            case "UD" :
                createUpdateDeleteCommand(commandDataObject);
                break;
            case "AU":
                createAddCommand(addCommandId, commandDataObject.addLinkInfo);
                createUpdateCommand(commandDataObject);
                break;
            case "AD" :
                createAddCommand(addCommandId, commandDataObject.addLinkInfo);
                createDeleteCommand(commandDataObject);
                break;
            case "D" :
                createDeleteCommand(commandDataObject);
                break;
            case "U" :
                createUpdateCommand(commandDataObject);
                break;
            case "A" :
                createAddCommand(addCommandId, commandDataObject.addLinkInfo);
                break;
            default :
                break;
        }

        var coreSimpleGrid = new CoreSimpleGrid();
        return coreSimpleGrid.createGrid(commandDataObject);
    }

    this.createCommandButton = function (ctrlId, text, link, callBack) {

        createCommand(ctrlId, text, undefined);
        createAddBindingEventForControl(ctrlId, text, callBack);
    }

    // Insert and update mode are differentiated
    // by the grid creation
    // editorMode = Insert is used during page insert mode whereby Grid are typically
    // editorMode = Update is used during page insert mode whereby Grid contains information
    function createAddUpdateDeleteView(commandDataObject) {

        if (commandDataObject.editorMode != undefined && commandDataObject.editorMode == globalEditorModeInsert) {

            createAddCommand(addCommandId, commandDataObject.addLinkInfo);
            createCancelCommand(cancelCommandId, cancelCommandText, commandDataObject.addLinkInfo.link, commandDataObject.cancelLinkInfo, commandDataObject.addLinkInfo.targetControlId);
            createGridInsertMode(commandDataObject);
        }
        else if (commandDataObject.editorMode != undefined && commandDataObject.editorMode == globalEditorModeEdit) {

            createAddCommand(addCommandId, commandDataObject.addLinkInfo);
            createCancelCommand(cancelCommandId, cancelCommandText, commandDataObject.addLinkInfo.link, commandDataObject.cancelLinkInfo, commandDataObject.addLinkInfo.targetControlId);
            createGridEditMode(commandDataObject);
        }
        else {

            createAddCommand(addCommandId, commandDataObject.addLinkInfo);
            createUpdateDeleteCommand(commandDataObject);
        }
    }

    function createGridEditMode(commandDataObject) {
        commandDataObject.mode = 6;
        var coreGrid = new CoreGrid();
        coreGrid.createGrid(commandDataObject);
    }

    function createUpdateDeleteCommand(commandDataObject) {

        if (commandDataObject.appearance != undefined && commandDataObject.appearance == globalCoreGridAppearanceToobarCreateCancel) {
            commandDataObject.mode = 2;
            createCancelCommand(cancelCommandId, cancelCommandText, commandDataObject.addLinkInfo.link, commandDataObject.cancelLinkInfo, commandDataObject.addLinkInfo.targetControlId);
        }
        else {
            commandDataObject.mode = 4;
        }

        var coreGrid = new CoreGrid();
        //coreGrid.createGridFilter(commandDataObject);
        coreGrid.createGrid(commandDataObject);
    }

    function createDeleteCommand(commandDataObject) {
        commandDataObject.mode = 3;
        var coreGrid = new CoreGrid();
        coreGrid.createGrid(commandDataObject);
    }

    function createUpdateCommand(commandDataObject) {
        commandDataObject.mode = 1;
        var coreGrid = new CoreGrid();
        coreGrid.createGrid(commandDataObject);
    }

    function createGridInsertMode(commandDataObject) {
        commandDataObject.mode = 5;
        var coreGrid = new CoreGrid();
        coreGrid.createGrid(commandDataObject);
    }

    function createAddCommand(ctrlId, commandDataObject) {

        if (commandDataObject.text == undefined)
            commandDataObject.text = "Add";

        if (commandDataObject.length != undefined) {

            for (var i = 0; i < commandDataObject.length; i++) {
                var obj = commandDataObject[i];
                createCommand(obj.ctrlId, obj.text, obj, obj.targetControlId);
                createJsonBindingEventForControl(obj.ctrlId, obj.callback);
            }
        }
        else if (commandDataObject.knockoutAttribute != undefined) {
            createCommand(ctrlId, commandDataObject.text, commandDataObject, commandDataObject.targetControlId);
        }
        else {
            createCommand(ctrlId, commandDataObject.text, commandDataObject, commandDataObject.targetControlId);
            // createAddBindingEventForControl(ctrlId, commandDataObject.callback);
            createJsonBindingEventForControl(ctrlId, commandDataObject.callback);
        }
    }

    function createCancelCommand(cancellationControlId, cancellationText, cancellationLink, cancelCommandObject, controlIdToAppendTo) {

        if (cancellationText == undefined)
            cancellationText = "Cancel";

        if (cancelCommandObject == null) {
            createCommand(cancellationControlId, cancellationText, cancelCommandObject, controlIdToAppendTo);
            createCancelBindingEventForControl(cancellationControlId, cancellationLink);
        }
        else
        {

            createCommand(cancellationControlId, cancellationText, cancelCommandObject, controlIdToAppendTo);
            createJsonBindingEventForControl(cancellationControlId, cancelCommandObject.callback);
        }
    }

    function createCancelBindingEventForControl(ctrlId, link) {

        /*$("#" + ctrlId).click(function () {
         var result = cancelFormChanges();
         if (result)
         preparePageForLoading(link);
         });
         */

        var dummyWindowDivId = ctrlId + "cancelWindow";
        $("#" + ctrlId).after("<div id='" + dummyWindowDivId + "'></div>");

        $("#" + ctrlId).click(function () {
            cancelFormChangesWindow(dummyWindowDivId, link);
        });
    }

    function createCancelBindingEventCallbackForControl(cancellationControlId, cancellationCallback) {
        $("#" + cancellationControlId).click(function () {
            var result = cancelFormChanges();
            if (result)
                cancellationCallback();
        });
    }

    function createCommand(ctrlId, text, commandObject, controlIdToAppendTo) {

        if (commandObject != undefined && commandObject.icon != undefined && controlIdToAppendTo != undefined) {

            appendCommandToCtrlId("<button class='" + commandObject.icon + " command' type='button' id='" + ctrlId + "'>" + text + "</button>", controlIdToAppendTo);
        }
        else if (commandObject != undefined && commandObject.icon != undefined) {

            appendCommandTo("<button class='" + commandObject.icon + " command' type='button' id='" + ctrlId + "'>" + text + "</button>");
        }
        else if (controlIdToAppendTo == undefined) {
            appendCommandTo("<button class='command' type='button' id='" + ctrlId + "'>" + text + "</button>");
        }
        else if (commandObject != null && commandObject.knockoutAttribute != undefined) {
            appendCommandToCtrlId("<button class='command' data-bind='" + commandObject.knockoutAttribute + "' type='button' id='" + ctrlId + "'>" + text + "</button>", controlIdToAppendTo);
        }
        else {
            appendCommandToCtrlId("<button class='command' type='button' id='" + ctrlId + "'>" + text + "</button>", controlIdToAppendTo);
        }
    }

    /*
     Deprecated function
     */

    function createAddBindingEventForControl(ctrlId, callback) {

        if (callback != undefined) {
            $("#" + ctrlId).click(function () {
                var executeCallBack = eval('(' + callback + ')');
                executeCallBack();
            });
        }
    }

    function createJsonBindingEventForControl(ctrlId, callback) {
        $("#" + ctrlId).click(function () {
            callback();
        });
    }

    // Why are controls added twice here?
    function appendCommandTo(markupToAppend) {
        $(markupToAppend).appendTo(".maintenanceCommand");
    }

    // targetControlId supports css / id based control syntaxx
    function appendCommandToCtrlId(markupToAppend, targetControlId) {
        $(markupToAppend).appendTo(targetControlId);
    }
}