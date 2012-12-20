/*	
	CoreTextBox - used together with gridview for filter purposes. 
	
	targetControlId :  target control id to render 
	controlName : name of control 

	text : text - text property of the json data to be display in the control 
	value : value - value property of the json data to be used in the control 
	
	var textControlData = 
	{ 
			"controlType" : 0, 
			"targetControlId" : "filterByDiv", 
			"controlName" : textControlName,
			"filters" : [ { field : "formId", operator : "contains" }]
	};
	
*/

var CoreTextBox = function()
{	
	this.renderControl = function(controlData)
	{
		render(controlData);
		bindFilterFunction(controlData);
	}
	
	function render(controlData)
	{
		var html = "<input type='textbox' id='" + controlData.controlName + "'/>";
		$("#" + controlData.targetControlId).html(html);
	}
	
	function bindFilterFunction(controlData)
	{
		$("#" + controlData.controlName).keydown(function(event)
		{
			if (event.which == 13) 
			{
				var ds = $("#grid").data("kendoGrid").dataSource;
				var definedFilter = []; 
				for (var i=0; i < controlData.filters.length; i++)
				{
				    var filterElement = { field : controlData.filters[i].field, operator : controlData.filters[i].operator, value : $(this).val()};
					definedFilter.push(filterElement);
				}
				ds.filter(filterElement); 
			}
		});
	}
		
}
