var CoreCommand = function () {
    var deleteCommandId = "deleteBtn";
    var updateCommandId = "updBtn";
    var addCommandId = "addBtn";
    var cancelCommandId = "cancelBtn";
    var cancelCommandText = "Cancel";

    var editorModeInsert = "Insert";
    var editorModeEdit = "Edit";

    this.parseCommand = function (requestUrl, requestData, commandDataObject) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequest(requestUrl, requestData, "get");

        request.success(function (data) {
            getCommand(data, commandDataObject);
        });
    }

    function getCommand(data, commandDataObject) {
        if (commandDataObject.addLinkInfo.commandId != undefined)
            addCommandId = commandDataObject.addLinkInfo.commandId;

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
    }

    this.createCommandButton = function (ctrlId, text, link, callBack) {
        createCommand(ctrlId, text, link);
        createAddBindingEventForControl(ctrlId, text, callBack);
    }

    function createAddUpdateDeleteView(commandDataObject) {

        if (commandDataObject.editorMode != undefined && commandDataObject.editorMode == editorModeInsert) {
            createAddCommand(addCommandId, commandDataObject.addLinkInfo);
            createCancelCommand(cancelCommandId, cancelCommandText, commandDataObject.addLinkInfo.link, null, commandDataObject.addLinkInfo.targetControlId);
            createGridInsertMode(commandDataObject);
        }
        else if (commandDataObject.editorMode != undefined && commandDataObject.editorMode == editorModeEdit) {
            createAddCommand(addCommandId, commandDataObject.addLinkInfo);
            createCancelCommand(cancelCommandId, cancelCommandText, commandDataObject.addLinkInfo.link, null, commandDataObject.addLinkInfo.targetControlId);
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
            createCancelCommand(cancelCommandId, cancelCommandText, commandDataObject.addLinkInfo.link, null, commandDataObject.addLinkInfo.targetControlId);
        }
        else {
            commandDataObject.mode = 4;
        }

        var coreGrid = new CoreGrid();
        //coreGrid.createGridFilter(commandDataObject);
        coreGrid.createGrid(commandDataObject);
    }

    function createDeleteCommand(commandDataObject) {
        var coreGrid = new CoreGrid();
        commandDataObject.mode = 3;
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

        // Jeremy

        createCommand(ctrlId, commandDataObject.text, commandDataObject.link, commandDataObject.targetControlId);
        createAddBindingEventForControl(ctrlId, commandDataObject.callback);

    }

    function createCancelCommand(ctrlId, text, link, callback, targetControlId) {
        if (text == undefined)
            text = "Cancel";

        createCommand(ctrlId, text, "", targetControlId);
        createCancelBindingEventForControl(ctrlId, link, callback);
    }

    function createCancelBindingEventForControl(ctrlId, link, callback) {
        $("#" + ctrlId).click(function () {
            var result = cancelFormChanges();
            if (result)
                window.location.replace(link);
        });
    }

    function createCommand(ctrlId, text, link, targetControlId) {
        if (targetControlId == undefined) {
            appendCommandTo("<button class='command' type='button' id='" + ctrlId + "'>" + text + "</button>");
        }
        else {
            appendCommandToCtrlId("<button class='command' type='button' id='" + ctrlId + "'>" + text + "</button>", targetControlId);
        }
    }

    function createAddBindingEventForControl(ctrlId, callback) {
        $("#" + ctrlId).click(function () {
            var executeCallBack = eval('(' + callback + ')');
            executeCallBack();
        });
    }

    // Why are controls added twice here?
    function appendCommandTo(markupToAppend) {
        $(markupToAppend).appendTo(".maintenanceCommand");
    }

    function appendCommandToCtrlId(markupToAppend, targetControlId) {
        $(markupToAppend).appendTo(targetControlId);
    }
}