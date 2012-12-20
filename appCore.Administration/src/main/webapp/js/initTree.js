 $(document).ready(function() 
 {
	   var request = $.ajax(
        {
              url: "http://localhost:8080/appCore-personnel/app/Core/CompanyEntity/list", 
              //url: hostname + "/app/Core/CompanyEntity/list", 
              type: "get", 
              data: null, 
              dataType: "json"
		
        });   
		if (menuDataSource != undefined) 
		 {
			 $('<div id="menuDiv">Menu</div>').appendTo('body');
			 $("#menuDiv").kendoMenu({
				dataSource: menuDataSource,
				select: onSelect
			});
		}
		
		 $("#logoutLink").click(function()
		 {
			var logoutWindow = $("#logoutWindow");
			 logoutWindow.kendoWindow({
                        width: "505px",
                        height: "315px",
                        title: "Logout",
			            actions: ["Refresh", "Maximize", "Close"]
                    });
			  logoutWindow.data("kendoWindow").content("<div>Do you want to logout?</div><div>&nbsp;</div><div><button type='button'>Logout</button>&nbsp;<button type='button' onclick=$('#logoutWindow').data('kendoWindow').close();>Cancel</button></div>");
			  logoutWindow.data("kendoWindow").center().open(); 
			  
		 });
		
		request.success(function(data)
		{
			if (data != undefined) 
			{
				$('<div class="treeDiv"><div id="treeView"></div></div>').appendTo('body');
				var treeview = $("#treeView").kendoTreeView({
					dataSource: data,
					select : function(e)
					{
						getNodeType(this.text(e.node), data);
					}
				});
			}
		});
	});
	
	function getNodeType(nodeName, data)
	{
	   if (data == null) 
			return;
		  
		for (var i=0; i < data.length; i++)
		{
			if (data[i].text == nodeName) 
			{
				alert(nodeName + ";type:[" + data[i].type + "]");
			}
			else 
			{
				getNodeType(nodeName, data[i].items);
			}
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
					goToPage(data[i].link);
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