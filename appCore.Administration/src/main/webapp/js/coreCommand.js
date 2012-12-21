var CoreCommand = function()
{	
	var deleteCommandId = "deleteBtn"; 
	var updateCommandId = "updBtn"; 
	var addCommandId = "addBtn";
	
	this.parseCommand = function(requestUrl, requestData, commandDataObject) 
	{
			var ajaxCore = new AjaxCore();
			var request = ajaxCore.sendRequest(requestUrl, requestData, "get");
			
			request.success(function(data) 
			{
				 getCommand(data, commandDataObject);
			}); 
	}
	
	function getCommand(data, commandDataObject) 
	{
		if (data == null || data.permission == null) 
		{
			goToPage(hostname);
		}
		var commandType = data.permission;
		
		switch (commandType)
		{
			case "AUD" : 
				createAddCommand(addCommandId, commandDataObject.addLinkInfo.text, commandDataObject.addLinkInfo.link, commandDataObject.addLinkInfo.callback);
				createUpdateDeleteCommand(commandDataObject);
				break;
		    case "UD" :
				createUpdateDeleteCommand(commandDataObject);
				break;
			case "AU": 
				createAddCommand(addCommandId, commandDataObject.addLinkInfo.text, commandDataObject.addLinkInfo.link, commandDataObject.addLinkInfo.callback);
				createUpdateCommand(commandDataObject);
				break;
			case "AD" :
				createAddCommand(addCommandId, commandDataObject.addLinkInfo.text, commandDataObject.addLinkInfo.link, commandDataObject.addLinkInfo.callback);
				createDeleteCommand(commandDataObject);
				break;
			case "D" :
				 createDeleteCommand(commandDataObject);
				 break;	
			case "U" : 
				createUpdateCommand(commandDataObject);
				break;
			case "A" : 
				createAddCommand(addCommandId, commandDataObject.addLinkInfo.text, commandDataObject.addLinkInfo.link, commandDataObject.addLinkInfo.callback);
				break; 
			default : 
				break; 
		}
	}
	
	this.createCommandButton = function(ctrlId, text, link, callBack)
	{
		createCommand(ctrlId, text, link);
		createAddBindingEventForControl(ctrlId, text, callBack);
	}
	
	function createUpdateDeleteCommand(commandDataObject)
	{
		var coreGrid = new CoreGrid(); 
		coreGrid.createGrid(commandDataObject.gridUrl, commandDataObject.data, commandDataObject.model, commandDataObject.columns, 4, commandDataObject.updateLinkInfo.link);
	}
	
	function createDeleteCommand(commandDataObject)
	{
		var coreGrid = new CoreGrid(); 
		coreGrid.createGrid(commandDataObject.gridUrl, commandDataObject.data, commandDataObject.model, commandDataObject.columns, 3);
	}
	
	function createUpdateCommand(commandDataObject)
	{
		var coreGrid = new CoreGrid(); 
		coreGrid.createGrid(commandDataObject.gridUrl, commandDataObject.data, commandDataObject.model, commandDataObject.columns, 1, commandDataObject.updateLinkInfo.link);
	}
	
	function createAddCommand(ctrlId, text, link)
	{
		if (text == undefined) 
		   text = "Add";
		   
		createCommand(ctrlId, text, link);
		createAddBindingEventForControl(ctrlId, link);
	}
	
	function createCommand(ctrlId, text, link)
	{
		appendCommandTo("<button class='command' type='button' id='" + ctrlId + "'>" + text + "</button>");
	}
	
	
	function createAddBindingEventForControl(ctrlId, link, callback)
	{
		$("#" + ctrlId).click(function() 
		{
			goToPage(link);
		});
	}	
	
	function appendCommandTo(markupToAppend)
	{
		$(markupToAppend).appendTo(".maintenanceCommand"); 
	}
}
