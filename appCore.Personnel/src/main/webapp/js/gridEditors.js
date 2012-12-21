	function dayTypeEditor(container, options)
	{
		var data = [
			{ text: "Off Day", value : 0 },
			{ text: "Rest Day", value : 1 }
			];

		$('<input data-bind="value:' + options.field + '"/>')
        .appendTo(container)
        .kendoDropDownList(
		{
            dataTextField: "text",
            dataValueField: "value",
            dataSource: data
        });
	}
	
	function dayClashedEditor(container, options)
	{
		var data = [
			{ text: "Move holiday to next working day", value : 1 },
			{ text: "Move holiday to prior working day", value : 2 },
			{ text: "Move day to next working day", value : 3 },
			{ text: "Move day to prior working day", value : 4 }
			];

		$('<input data-bind="value:' + options.field + '"/>')
        .appendTo(container)
        .kendoDropDownList({
            dataTextField: "text",
            dataValueField: "value",
            dataSource: data, 
			autobind : true
        });   

	}