var ComboControlRenderer = function () {
    this.createControl = function (data, targetId) {
        var parseHtml = "";
        for (var i = 0; i < data.length; i++) {
            parseHtml += "<option value=" + data[i].key + ">" + data[i].text + "</option>";
        }
        if (parseHtml.length > 0) {
            $("#" + targetId).append(parseHtml);
        }
    };
}

var DataParser = function () {

    this.parseKeyText = function (fieldValue, fieldText, data) {

        var keyTextList = [];
        if (data == undefined || data  == null)
            return keyTextList;

        for (var i = 0; i < data.length; i++) {

            var key = data[i][fieldValue];
            var text = data[i][fieldText];

            if (key != undefined && text != undefined)
                keyTextList.push({ "key":key, "text":text });
        }
        return keyTextList;
    };
}

/*
 var url = hostname + "/app/Core/Company/list";
 var dataObjects = {
 "url" : url,
 "targetControlId" : "company",
 "data" : null,
 "key" : "nid",
 "text" : "companyCode"
 };
 */

var ComboControl = function () {
    this.createControl = function (dataObjects) {

        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestType(dataObjects.url, dataObjects.data, "get");
        request.success(function (data) {
            var parser = new DataParser();
            var result = parser.parseKeyText(dataObjects.key, dataObjects.text, data);

            var ctl = new ComboControlRenderer();
            ctl.createControl(result, dataObjects.targetControlId);
        });
    }
}


var InfoWidgetControlRenderer = function () {
    this.maxRecordCount = 3;

    this.createControl = function (data, dataObjects) {


        var idxCount = data.length > this.maxRecordCount ? this.maxRecordCount : data.length;

        var parseHtml = "<div class='widget'><div class='widgetInfoHeader'><i class='" + dataObjects.icon + "'></i><h4>" + dataObjects.title + "</h4></div>";
        parseHtml += "<div class='widgetInfo'><ul>";

        for (var i = 0; i < idxCount; i++) {
            parseHtml += "<li>" + data[i].text + "</li>";
        }

        parseHtml += "<li>test</li>";
        parseHtml += "<li>test2</li>";
        parseHtml += "</ul>";
        parseHtml += "</div></div>";

        if (parseHtml.length > 0) {
            $("#" + dataObjects.targetControlId).append(parseHtml);
        }
    }
}


var CommandWidgetControlRenderer = function () {

    this.maxRecordCount = 3;

    this.objDataObjects;
    var objDataObjects;

    this.createControl = function (data, dataObjects, dataCount) {

        this.objDataObjects = dataObjects;

        objDataObjects = dataObjects;

        var idxCount = data.length > this.maxRecordCount ? this.maxRecordCount : data.length;
        var parsedHtml = "<div class='widget'><div class='widgetInfoHeader'><i class='icon-th'></i><h4>" + dataObjects.title + "</h4>";

        if (dataObjects.clickControlId != undefined)
            parsedHtml += "<a href='#' id='" + dataObjects.clickControlId + "'><i class='icon-right-open cmdLeft'></i></a>";

        parsedHtml += "</div>";
        parsedHtml += "<div class='widgetInfo'><ul>";

        for (var i = 0; i < idxCount; i++) {
            parsedHtml += "<li>" + data[i].text + "</li>";
        }

        parsedHtml += "<li>Total count <span class='widgetHighlight'> " + dataCount + "  </span>   </li>";
        parsedHtml += "</ul>";
        parsedHtml += "</div></div>";

        if (parsedHtml.length > 0) {
            $("#" + dataObjects.targetControlId).append(parsedHtml);
        }

        if (dataObjects.clickCode != undefined) {
            var ctrlEventExecutor = new EventCodeProvider();
            ctrlEventExecutor.createClickEventToControl(dataObjects.clickControlId, dataObjects.clickCode);
        }
    }

    function loadWidgetPage() {
        preparePageForLoading(globalCurrentPageToLoad);
    }
}


var EventCodeProvider = function () {
    this.createClickEventToControl = function (ctrlId, executeCode) {
        $("#" + ctrlId).click(function () {
            executeCode();
        });
    }

}

/*
 Sample code :-
 var d = {
 "url" : url,
 "targetControlId" : "viewPortWidget",
 "data" : null,
 "key" : "nid",
 "text" : "companyCode",
 "title" : "Company"
 };

 var widget = new WidgetControl();
 widget.createControl(d);

 */

var WidgetControl = function () {
    this.createControl = function (dataObjects) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestType(dataObjects.url, dataObjects.data, "get");

        request.success(function (data) {
            var parser = new DataParser();
            var result = parser.parseKeyText(dataObjects.key, dataObjects.text, data);

            var ctl = new InfoWidgetControlRenderer();
            ctl.createControl(result, dataObjects);
        });
    }
}

var WidgetCommandControl = function () {

    this.createControl = function (dataObjects) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestType(dataObjects.url, dataObjects.data, "get");

        request.success(function (data) {

            var parser = new DataParser();
            var result = parser.parseKeyText(dataObjects.key, dataObjects.text, data[dataObjects.list]);

            var ctl = new CommandWidgetControlRenderer();
            ctl.createControl(result, dataObjects, data.count);
        });
    }
}


// jeremy

var TestCodeExector = function () {
    this.execute = function (jsonCode) {
        jsonCode.test();
        jsonCode.test2();
    }
}