function cancelFormChanges() {
    var isAnswerYes = confirm("Discard current modification and exit form?");

    if (isAnswerYes) {
        var $inputs = $(':input');
        $inputs.each(function (index) {
            $(this).val('');
            $(this).attr('checked', false);
            var grid = $("#grid").data("kendoGrid");
            if (grid != null)
                grid.cancelChanges();
        });
    }
    else {
    }

    return isAnswerYes;
}

function cancelFormChangesWindow(ctrlId, link) {
    var dialog = new CoreDialog();
    var helper = new EmployeeHelper();
    var dialogObject = helper.createDialogObject("Discard changes", "Do you want to discard current modification and exit?");
    var result = dialog.createDiscardConfirmationDialog(dialogObject, link, commonDiscardConfirmationCallBack);
}

function commonDiscardConfirmationCallBack(status, link) {
    if (status == true) {
        preparePageForLoading(link);
    }
}


function getCheckedValue(id) {
    if ($('#' + id).is(":checked"))
        return 1;
    else
        return 0;
}

function getParameterByName(name) {
    name = name.replace(/[\[]/, "\\\[").replace(/[\]]/, "\\\]");
    var regexS = "[\\?&]" + name + "=([^&#]*)";
    var regex = new RegExp(regexS);
    var results = regex.exec(window.location.search);
    if (results == null)
        return "";
    else
        return decodeURIComponent(results[1].replace(/\+/g, " "));
}

function goToPage(name) {
    window.location.replace(name);
}

function showMessage(message) {
    $(".messageSection").append("<div class='alert'>" + message + "</div>");
}

var loadPageRequest;

function loadPage() {
    if (globalCurrentPageToLoad == undefined)
        return;

    if (ajaxCore == null)
        ajaxCore = new AjaxCore();

    loadPageRequest = ajaxCore.loadPage(globalCurrentPageToLoad);
    loadPageRequest.success(function (html) {
        $("#viewPort").html(html);
    });
}

function preparePageForLoading(page) {
    globalCurrentPageToLoad = page;
    var requestValue = getPageRequestParameter("id", page);

    if (requestValue != "")
        globalCodeMaintenance = requestValue;

    loadPage();
}

function getPageRequestParameter(name, url) {
    name = name.replace(/[\[]/, "\\\[").replace(/[\]]/, "\\\]");
    var regexS = "[\\?&]" + name + "=([^&#]*)";
    var regex = new RegExp(regexS);
    var results = regex.exec(url);
    if (results == null)
        return "";
    else
        return decodeURIComponent(results[1].replace(/\+/g, " "));
}