var menuDataSource;

$(document).ready(function () {

    /*var ajaxCore = new AjaxCore();
    var requestMenu = ajaxCore.sendRequest(globalHostname + globalMenuServiceUrl, null, 'get');
    requestMenu.done(function (data) {
        menuDataSource = data;

        if (menuDataSource != undefined) {
            $('<div id="menuDiv">Menu</div>').appendTo('body');
            $("#menuDiv").kendoMenu({
                dataSource:menuDataSource,
                select: onSelectMenuItemKendo
            });
        }
    });
*/
    /*var request = ajaxCore.sendRequest(globalHostname + globalCompanyServiceUrl, null, 'get');
     request.success(function (data) {
     if (!$.isEmptyObject(data)) {
     if (data != undefined) {
     $('<div class="treeDiv"><div id="treeView"></div></div>').appendTo('body');
     var treeview = $("#treeView").kendoTreeView({
     dataSource:data,
     select:function (e) {
     getNodeType(this.text(e.node), data);
     }
     });
     }
     }
     });
     */


    $("#logoutLink").click(function () {
        var logoutWindow = $("#logoutWindow");

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
            "<button type='button' onclick=$('#logoutWindow').data('kendoWindow').close();>Cancel</button></div>");

        logoutWindow.data("kendoWindow").center().open();

    });


});

function getNodeType(nodeName, data) {
    if (data == null)
        return;

    for (var i = 0; i < data.length; i++) {
        if (data[i].text == nodeName) {
            // alert(nodeName + ";type:[" + data[i].type + "]");
        }
        else {
            getNodeType(nodeName, data[i].items);
        }
    }
}

function getMenuNodeType(nodeName, data) {
    if (data == null)
        return;

    for (var i = 0; i < data.length; i++) {
        if (data[i].text == nodeName) {
            if (data[i].link != undefined && data[i].link != null) {
                preparePageForLoading(data[i].link);
            }
        }
        else {
            getMenuNodeType(nodeName, data[i].items);
        }
    }
}

function onSelectMenuItemKendo(e) {
    var selectedItemText = $(e.item).children(".k-link").text();
    getMenuNodeType(selectedItemText, menuDataSource);
}