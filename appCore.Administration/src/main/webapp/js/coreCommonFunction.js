	function cancelFormChanges()
	{
		var isAnswerYes = confirm("Discard current modification and exit form?");
		
		if (isAnswerYes)
		{
			var $inputs = $(':input');
			$inputs.each(function(index) 
			{
				$(this).val('');
				$(this).attr('checked', false);
				var grid = $("#grid").data("kendoGrid");
				if (grid != null) 
					grid.cancelChanges();
			});
		}
		else 
		{
		}
		
		return isAnswerYes;
	}
	
	function getCheckedValue(id)
	{
		if ($('#' + id).is(":checked"))
		 return 1;
		else 
		 return 0;
	}
	
	
	function getParameterByName(name)
	{
        name = name.replace(/[\[]/, "\\\[").replace(/[\]]/, "\\\]");
        var regexS = "[\\?&]" + name + "=([^&#]*)";
        var regex = new RegExp(regexS);
        var results = regex.exec(window.location.search);
		if(results == null)
			return "";
		else
			return decodeURIComponent(results[1].replace(/\+/g, " "));
	}
	
	function goToPage(name)
	{
		window.location.replace(name);
	}
	