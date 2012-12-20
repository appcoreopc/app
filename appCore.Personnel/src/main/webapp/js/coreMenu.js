	var MenuItem = function()
	{
		this.text; 
		this.items = [];
	}	

    var CoreMenu = function()
	{
		var requestUrl = "http://localhost:8080/appCore-personnel/app/User/Forms_Role/getRoleById?id=1";
		
		this.createMenu = function() 
		{
			var ajaxCore = new AjaxCore();
			var request = ajaxCore.sendRequest(requestUrl, null, "get");
			request.success(function(data) 
			{
				var menuDataSource = convertDataToMenuDataSource(data);
				renderMenu(menuDataSource);
			}); 
		};
		
		function convertDataToMenuDataSource(data)
		{
			var menuDataSource = [];
			for	(var i=0; i < data.length; i++)
			{
				var menuItem = new MenuItem(); 
				menuItem.text = data[i].forms.formId;
				menuItem.link = data[i].forms.link;
				menuDataSource.push(menuItem);
			}
			return menuDataSource;
		}
		
		function renderMenu(data)
		{
			if (data != undefined) 
			{
				 $('<div id="menuDiv">Menu</div>').appendTo('body');
				 $("#menuDiv").kendoMenu({
					dataSource: data,
					select: onSelect
				});
			}
		}
		
		function getMenuNodeType(nodeName, data)
		{
			   if (data == null) 
					return;
		
				for (var i=0; i < data.length; i++)
				{
					if (data[i].text == nodeName) 
					{
						if (data[i].link != undefined && data[i].link != null)
						{
							preparePageForLoading(data[i].link);
						}
					}
					else 
					{
						getMenuNodeType(nodeName, data[i].items);
					}
				}
		}
	
		function onSelect(e)
		{
			var selectedItemText = $(e.item).children(".k-link").text();
			getMenuNodeType(selectedItemText, menuDataSource);
		}
	}