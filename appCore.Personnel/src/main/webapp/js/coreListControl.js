/*	
	controlType :  0 - select;  1 = listbox 
	
	targetControlId :  target control id to render 
	controlName : name of control 

	text : text - text property of the json data to be display in the control 
	value : value - value property of the json data to be used in the control 
	
	field : field to filter 
	operator : operator for filter
	
	var controlData = 
		{ 
			"controlType" : 0, 
			"targetControlId" : "categoryDiv", 
			"controlName" : selectControlName,
			"value" : "nid", 
			"text" : "categoryName",
			"url" : listGridUrl,
			"field" : "formId", 
			"operator" : "contains"
		};
		
	
*/

var CoreListControl = function()
{	
	this.renderControl = function(url, controlData)
	{
		var ajaxCore = new AjaxCore();
		var request = ajaxCore.sendRequest(url, null, "get");
			
		request.success(function(data) 
		{
			render(data, controlData);
		}); 
	}
	
	function render(data, controlData)
	{
		renderByControlType(data, controlData);
	}
	
	function renderByControlType(data, controlData)
	{
		switch (controlData.controlType)
		{
			case 0: 
				renderSelect(data, controlData); 
				bindEventToControl(controlData);
				break;
			case 1:
				renderSelectList(data, controlData); 
				break; 
		}
	}
	
	function renderSelect(data, controlData)
	{
		var html = "<select id='" + controlData.controlName + "'>";
		for (var i=0; i < data.length; i++)
		{
			html += "<option value='" + data[i][controlData.value] + "'>" + data[i][controlData.text] + "</option>";
		}
		html += "</select>"; 
		
		$("#" + controlData.targetControlId).html(html);
		
	}
	
	function renderSelectList(data, controlData)
	{
		var html = "<select multiple='multiple' id='" + controlData.controlName + "'>";
		for (var i = 0; i < data.length; i++)
		{
			html += "<option value='" + data[i][controlData.value] + "'>" + data[i][controlData.text] + "</option>";
		}
		html += "</select>"; 
		$("#" + controlData.targetControlId).html(html);
	}
	
	function bindEventToControl(controlData)
	{
		$("#" + controlData.controlName).click(function()
		{
			var value = $('#' + controlData.controlName + ' option:selected').text();
			var ds = $("#grid").data("kendoGrid").dataSource;
			
			var definedFilter = []; 
			for (var i=0; i < controlData.filters.length; i++)
			{
				    var filterElement = { field : controlData.filters[i].field, operator : controlData.filters[i].operator, value : value };
					definedFilter.push(filterElement);
			}
			ds.filter(filterElement); 
		});
	}
}
