var WidgetControlRenderer = function()
{
	this.createControl = function(data, targeatControlId)
	{
		var parseHtml = "<div class='widgetInfo>"; 
		parseHtml += "<ul>";
		for (var i= 0; i < data.length; i++)
		{
			parseHtml += "<li>" + data[i].key  + ">" +  data[i].text + "</li>";
		}
		if (parseHtml.length > 0) 
		{
			$("#" + targetId).append(parseHtml);
		}
		parseHtml += "</ul>";
		parseHtml += "</div>";
	}
}








