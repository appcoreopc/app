    /* 
		Mode : 
		0 - readonly 
		1 - edit with just a link 
		2 - edit with add/cancel feature
		3 - delete grid view 
		4 - enabled all grid feature
	*/

	var CoreGrid = function()
	{
		var editUrl;
		var controlIdName = "grid";
		
		this.createGrid = function(gridUrl, data, model, columns, mode, urlEdit, controlId) 
		{ 
			editUrl = urlEdit;
			
			if (controlId != undefined )
			    controlIdName = controlId; 
			
			switch (mode) 
			{
				case 0: 
					createReadOnlyGrid(gridUrl, data, model, columns);
					break; 
				case 1: 
					createEditEnabledOnlyGrid(gridUrl, data, model, columns);
					break;
				case 2: 
					createEditModeOnlyGrid(gridUrl, data, model, columns);
					break;
				case 3: 
					createDeleteOnlyGrid(gridUrl, data, model, columns);
					break;
				case 4: 
					createAllFeatureGrid(gridUrl, data, model, columns);
					break;
				default: 
					createReadOnlyGrid(gridUrl, data, model, columns);
					break;
			}
		}
		
		function createAllFeatureGrid(gridUrl, data, model, columns)
		{
				var deleteObject = { command : "destroy",  title : "", width: 50 };
				columns.columns.push(deleteObject);
				
				var editObject = { command : { text: "Edit", click: showDetails },  title : "", width: 50 };
				columns.columns.push(editObject);
			
				$("#" + controlIdName).kendoGrid({
								dataSource: {
								
								transport: {
										read:  {
											dataType: "json",
											url: gridUrl + "/list",
										},
										update: {
											url: gridUrl + "/saveOrUpdate",
											dataType: "json"
										},
										destroy: {
											url: gridUrl + "/delete",
											dataType: "json"
										},
										create: {
											url: gridUrl + "/add",
											dataType: "json"
										} 
									},
									data: data,
									pageSize: 10, 
									schema: {
										model: model 
									}
								},
								
								editable : true,
								resizable:true,
								reorderable: true,
								groupable: false,
								selectable : true,
								sortable: true,
								pageable: true,
								columns: columns.columns, 
								remove : function(e)
								{
									$.ajax({
										url: gridUrl + "/delete",
										data: {"id": e.model.nid},
										type : "get", 
										dataType : "json"
										});
								}
						});
		}
		
		
		function createDeleteOnlyGrid(gridUrl, data, model, columns)
		{
				var editObject = { command : "destroy",  title : "", width: 50 };
				columns.columns.push(editObject);
			
				$("#" + controlIdName).kendoGrid({
								dataSource: {
								
								transport: {
										read:  {
											dataType: "json",
											url: gridUrl + "/list",
										},
										update: {
											url: gridUrl + "/saveOrUpdate",
											dataType: "json"
										},
										destroy: {
											url: gridUrl + "/delete",
											dataType: "json"
										},
										create: {
											url: gridUrl + "/add",
											dataType: "json"
										} 
									},
									data: data,
									pageSize: 10, 
									schema: {
										model: model 
									}
								},
								
								editable : true,
								resizable:true,
								reorderable: true,
								groupable: false,
								selectable : true,
								sortable: true,
								pageable: true,
								columns: columns.columns, 
								remove : function(e)
								{
									$.ajax({
										url: gridUrl + "/delete",
										data: {"id": e.model.nid},
										type : "get", 
										dataType : "json"
										});
								}
						});
		}
			
			
		function createEditModeOnlyGrid(gridUrl, data, model, columns)
		{
			
				var editObject = { command : "destroy",  title : "", width: 50 };
				columns.columns.push(editObject);
			
				$("#" + controlIdName).kendoGrid({
								dataSource: {
								
								transport: {
										read:  {
											dataType: "json",
											url: gridUrl + "/list",
										},
										update: {
											url: gridUrl + "/saveOrUpdate",
											dataType: "json"
										},
										destroy: {
											url: gridUrl + "/delete",
											dataType: "json"
										},
										create: {
											url: gridUrl + "/add",
											dataType: "json"
										} 
									},
									data: data,
									pageSize: 10, 
									schema: {
										model: model 
									}
								},
								toolbar: ["create", "cancel"],
								editable : true,
								resizable:true,
								reorderable: true,
								groupable: false,
								selectable : true,
								sortable: true,
								pageable: true,
								columns: columns.columns, 
								remove : function(e)
								{
									$.ajax({
										url: gridUrl + "/delete",
										data: {"id": e.model.nid},
										type : "get", 
										dataType : "json"
										});
								}
						});
		
		}
			
		function createEditEnabledOnlyGrid(gridUrl, data, model, columns)
		{
			
				var editObject = { command : { text: "Edit", click: showDetails },  title : "", width: 50 };
				columns.columns.push(editObject);
			
				$("#" + controlIdName).kendoGrid({
								dataSource: {
								
								transport: {
										read:  {
											dataType: "json",
											url: gridUrl + "/list",
										},
										update: {
											url: gridUrl + "/saveOrUpdate",
											dataType: "json"
										},
										destroy: {
											url: gridUrl + "/delete",
											dataType: "json"
										},
										create: {
											url: gridUrl + "/add",
											dataType: "json"
										} 
									},
									data: data,
									pageSize: 10, 
									schema: {
										model: model 
									}
								},
								
								editable : true,
								resizable:true,
								reorderable: true,
								groupable: false,
								selectable : true,
								sortable: true,
								pageable: true,
								columns: columns.columns
						});
			}
			
			function createReadOnlyGrid(gridUrl, data, dataModel, columns)
			{
				
				$("#" + controlIdName).kendoGrid({
								dataSource: {
								
								transport: {
										read:  {
											dataType: "json",
											url: gridUrl + "/list",
										},
										update: {
											url: gridUrl + "/saveOrUpdate",
											dataType: "json"
										},
										destroy: {
											url: gridUrl + "/delete",
											dataType: "json"
										},
										create: {
											url: gridUrl + "/add",
											dataType: "json"
										} 
									},
									data: data,
									pageSize: 10, 
									schema: {
										model: dataModel 
									}
								},
								
								editable : true,
								resizable:true,
								reorderable: true,
								groupable: false,
								selectable : true,
								sortable: true,
								pageable: true,
								columns: columns.columns
						});
			}
			
			function showDetails(e)
			{
				e.preventDefault();
				var dataItem = this.dataItem($(e.currentTarget).closest("tr"));
				window.location.replace(editUrl + "?id=" + dataItem.nid);
			}
	}	