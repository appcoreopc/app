<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>

<%@ include file="../includes/css_includes.html" %>
<%@ include file="../includes/js_includes.html" %>
<%@ include file="/includes/header.html" %>

<script type="text/javascript">          

    var gridUrl = hostname + "/app/Core/Calendar/OffDayInfo";

	$(document).ready(function() 
	{
	
		$("#DayPerCycle").kendoNumericTextBox({
		  min: 0, value : 0 });
	  
		var grid = $("#grid").kendoGrid({
                         dataSource: {
						
						  transport: {
                                read:  {
                                    dataType: "json"
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
						 	data: [],
                            pageSize: 10, 
							schema: {
                                model: {
                                    ids: "nid",
                                    fields: {
                                        nid: { editable: false },
                                        dayNo: {  type: "date" },
                                        dayType : { type : "string" },
                                        description: {  type: "string" },
                                        dayTypeDescription : {  type : "string" },
                                        clashedAction : { type : "string" },
                                        nonClashedAction : { type : "string" }
                                    }
                                }
                            }
		                },
						editable : true,
						toolbar: ["create", "cancel"],
						groupable: false,
						selectable : true,
                        sortable: true,
                        pageable: true,
                        columns: [ 
							{
                                field: "dayNo",
                                width: 90,
                                title: "Day No", format : "{0:yyyy-MM-dd}"
                            }, 
							{
                                field: "dayType",
                                width: 90,
                                title: "Day Type", editor : dayTypeEditor
                            },
							{
                                field: "description",
                                width: 90,
                                title: "Description"
                            }, 
							{
                                field: "dayTypeDescription",
                                width: 90,
                                title: "Day Type Description"
                            }, 
							{
                                field: "clashedAction",
                                width: 90,
                                title: "Clash Action", editor : dayClashedEditor
                            },
							{
                                field: "nonClashedAction",
                                width: 90,
                                title: "Non Clash Action", editor : dayClashedEditor
                            },							
							{
							     command : "destroy",  title : "", width: 110
							}
						], 

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
				
			 $("#saveBtn").click(function()
			 {
				getValidateData();
			 });
			 
			 $("#cancelBtn").click(function()
			 {
				var result = cancelFormChanges();
				if (result) 
				   window.location.replace("offDay.jsp");
			 });
 	});
	
	function dayTypeEditor(container, options)
	{
		var data = [
			{ text: "Off Day", value : "Off Day" },
			{ text: "Rest Day", value : "Rest Day" }
			];

		$('<input data-bind="value:' + options.field + '"/>')
        .appendTo(container)
        .kendoDropDownList({
            dataTextField: "text",
            dataValueField: "value",
            dataSource: data
        });   
	}
	
	function dayClashedEditor(container, options)
	{
		var data = [
			{ text: "Move holiday to next working day" },
			{ text: "Move holiday to prior working day" },
			{ text: "Move day to next working day" },
			{ text: "Move day to prior working day" }
			];

		$('<input data-bind="value:' + options.field + '"/>')
        .appendTo(container)
        .kendoDropDownList({
            dataTextField: "text",
            dataValueField: "text",
            dataSource: data
        });   
	}
	
	function getClashedDayInInteger(source)
	{
		 if ( source == "Move holiday to next working day")
		    return 1; 
		 else if (source == "Move holiday to prior working day") 
			return 2; 
		 else if (source == "Move day to next working day") 
			return 3; 
		 else if (source == "Move day to prior working day")
		    return 4; 
	     else 
		    return 0;
	}

	function getValidateData()
	{
		var offdayInfoData = [];
	
        var grid = $("#grid").data("kendoGrid").dataSource.data();
 		$.each(grid, function (i, dataItem) 
		{
			var offdayInfo = new OffdayInfo(); 
			offdayInfo.dayNo = kendo.toString(dataItem.dayNo, "yyyy-MM-dd"); 
			
			var dayTypeValue = 0;
			if (dataItem.dayType == "Off Day") 
			  dayTypeValue = 0;
			else if (dataItem.dayType == "Rest Day")
			  dayTypeValue = 1;
			
			offdayInfo.dayType = dayTypeValue;
			
			offdayInfo.description = dataItem.description;
			offdayInfo.dayTypeDescription = dataItem.dayTypeDescription;
			offdayInfo.clashedAction = getClashedDayInInteger(dataItem.clashedAction);
			
			offdayInfo.nonClashedAction = getClashedDayInInteger(dataItem.nonClashedAction);
			offdayInfoData.push(offdayInfo);
		});
	 		
		var offday = new Offday(); 
		offday.patternName = $("#PatternName").val(); 
		offday.description = $("#Description").val(); 
		
		var dayPerCycleCtl = $("#DayPerCycle").data("kendoNumericTextBox");
		offday.dayPerCycle = dayPerCycleCtl.value();
		
		offday.remark = $("#Remark").val(); 
		offday.disabled = $('#Disabled').is(":checked"); 
		offday.offDayInfo = offdayInfoData; 		
				
		var ajaxCore = new AjaxCore(); 
		var request = ajaxCore.sendRequestType(hostname + "/app/Core/Calendar/OffDay/add", offday, "post"); 
		
		request.success(function(data, status, xhrObj)
		{
			goToPage("offDay.jsp");
		});
	}
	
	
	
	
	
</script>    

<div class="form dataEntry">
		
  <div class="sectionalForm"> 
   <div class="leftSection">
	<div class="labelSection">Pattern Name</div><div class="inputSection"><input type="text" id="PatternName" value="PatternName"/></div>
   </div> 
	
	<div class="rightSection">
		<div class="inlineLabelSection">Disabled</div><div class="inlineLabelSection"><input type="checkbox" id="Disabled" value="Disabled"/></div>
	</div>
  </div>

	<div class="formRow">
		<div class="labelSection">Description</div><div class="inputSection"><input type="text" id="Description" value="Description"/></div>
	</div>
	
	 <div class="formRow">
		<div class="labelSection">Day Per Cycle</div><div class="inputSection"><input type="text" id="DayPerCycle" value="0"/></div>
    </div>
	
	 <div class="formRow">
		<div class="labelSection">Remark</div><div class="inputSection"><input type="text" id="Remark" value="Remark"/></div>
    </div>
	
	<div> 
		<div class="command"><button type="button" id="saveBtn">Save</button>
		<button type="button" id="cancelBtn">Cancel</button>
		</div>
	</div>
	
	 <div>&nbsp;</div>
  
    <div>
	 <div> Off Day Info  </div>	
	 <div>&nbsp;</div>
		<div id="grid" style="height: 380px"></div>
	</div>
</div>

<%@ include file="/includes/footer.html" %>

</body>
</html>
