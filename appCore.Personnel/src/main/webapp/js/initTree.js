var menuDataSource;

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