function AjaxCore()
{
	//default configuration 
	this.dataType = "json"; 
	this.requestType = "POST";
	this.contentType = "application/json";
	
	// ajax send Request data 
	this.sendRequest = function(url, dataSource, requestType)
	{
		if (requestType != undefined)
		{
			this.requestType = requestType;
		}
		
		if (url == undefined)
			throw "Url for Ajax request is not available.";
		
		var request = $.ajax({
			type: this.requestType,
			url: url,
			data: dataSource, 
			dataType : this.dataType,
			contentType : "application/json"
		});

		return request;
	}
	
	this.sendRequestType = function(url, dataSource, requestType)
	{
		if (requestType != undefined)
		{
			this.requestType = requestType;
		}
		
		if (url == undefined)
			throw "Url for Ajax request is not available.";
		
		var request = $.ajax(
        {
              url: url, 
              type: this.requestType, 
              data: JSON.stringify(dataSource), 
              dataType: "json",
              contentType: "application/json"
        });   

		return request;
	}
	
	this.srd = function(url, dataSource, requestType)
	{
	    alert("DataType " + this.dataType +  "; requestType " + this.requestType + "; url:" + url);
		
		$.ajax({
			type: this.requestType,
			url: url,
			data: dataSource, 
			dataType : this.dataType
		}); 
	}
}