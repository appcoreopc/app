function AjaxCore()
{
	//default configuration 
	this.dataType = "json"; 
	this.requestType = "POST";
	
	// ajax send Request data 
	this.sendRequest = function(url, dataSource, callBack)
	{
		$.ajax({
		type: this.requestType,
		url: url,
		data: dataSource, 
		dataType : this.dataType,
		success: function(data) 
		{
	       callBack(data);
        }
		}); 
	}
	
	this.srd = function(url, dataSource, callBack)
	{
	    alert("DataType " + this.dataType +  "; requestType " + this.requestType + "; url:" + url);
		
		$.ajax({
		type: this.requestType,
		url: url,
		data: dataSource, 
		dataType : this.dataType,
		success: function(data) 
		{
	       callBack(data);
        }
		}); 
	}
	
}