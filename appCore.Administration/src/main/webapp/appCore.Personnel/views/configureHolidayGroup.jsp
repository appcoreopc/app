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

    var currentService = hostname + "/app/Core/Calendar/Holiday";
	var holidayGroupData = []; 
	var allHolidays = [];
	
	$(document).ready(function() 
	{
		 
		 getDataForComboCtl(hostname + "/app/Core/Calendar/HolidayGroup/list", "get", "HolidayGroup");
		 
		 getAllHolidaysData(hostname + "/app/Core/Calendar/Holiday/list", "get", "AvailableHoliday");
	 
		 $("#HolidayGroup").change(function()
		 {
			GetListForDisplay();
		 });
		 
		 $("#availableToAllocated").click(function()
		 {
			moveDataFromSourceToTargetComboBox("AvailableHoliday", "AllocatedHoliday");
		 });
		 
		 $("#allocatedToAvailable").click(function()
		 {
			moveDataFromSourceToTargetComboBox("AllocatedHoliday", "AvailableHoliday");
		 });
	 
		 $("#saveBtn").click(function()
		 {
			getValidateData();
		 });
		 
		 $("#updateBtn").click(function()
		 {
			  alert("HolidayGroup " + $("#HolidayGroup").val()); 
			  
			   $("#AllocatedHoliday option").each(function()
				{
					alert($(this).val());
				});
		 });
		 
		 
		 $("#testBtn").click(function()
		 {
			test();
		 });
			 
		 $("#cancelBtn").click(function()
		 {
			var result = cancelFormChanges();
			if (result) 
			   window.location.replace("holidaySetup.jsp");
		 });
 	});
	
	function getDataForComboCtl(url, method, controlId)
	{
		var ajaxCore = new AjaxCore(); 
		var request = ajaxCore.sendRequestType(url, null, method); 
	
		request.done(function(data)
		{
			var i=0;
			$.each(data, function(key, value) 
			{   
				holidayGroupData[value.name] = [];
				holidayGroupData[value.name].push(value.holidays);
				appendDataToComboBox(controlId, value.name, value.name);
				i++;
			});
		});
	}
	
	function GetListForDisplay()
	{
		var groupName = $("#HolidayGroup").val();
		var assignedHolidays = holidayGroupData[groupName];
		
		if (assignedHolidays != undefined) 
		{
			var newList = allHolidays.slice(); 
			var renderList = []; 
		
			for (var i = 0; i < assignedHolidays.length; i++)
			{
				for (var j = 0; j < assignedHolidays[0].length; j++)
				{
					for (var k = 0; k < newList.length; k++)
					{
						if (newList[k].name = assignedHolidays[0][j].name)
						{
							newList.splice(j, 1);  // remove the list
						}
						else 
						{
							renderList.push(assignedHolidays[0][j]);
						}
					}
				} 
			}
			
			clearComboBox("AvailableHoliday");
			
			if (renderList.length > 0) 
			{
				appendDataToComboBox("AvailableHoliday", renderList);
			}
		}
		else 
		{
			appendAvailableHolidayDataToComboBox(allHolidays, "AvailableHoliday");
		}
	}

	function getAllHolidaysData(url, method, controlId)
	{
		var ajaxCore = new AjaxCore(); 
		var request = ajaxCore.sendRequestType(url, null, method); 
	
		request.done(function(data)
		{
			appendDataToComboBoxAllHoliday(data, controlId); 
		});
	}
	
	function clearComboBox(controlId) 
	{
		$('#' + controlId).empty();
	}
	
	function appendDataToComboBoxAllHoliday(data, controlId)
	{
		var i = 0;
		$.each(data, function(key, value) 
		{   
			allHolidays[i] = { name : value.name, nid : value.nid };
			appendDataToComboBox(controlId, value.nid, value.name);
			i++;
		});
	}
	
	function appendAvailableHolidayDataToComboBox(data, controlId)
	{
		clearComboBox(controlId);
		$.each(data, function(key, value)
		{
		   appendDataToComboBox(controlId, value.nid, value.name);
		});
	}
	
	function appendDataToComboBox(controlId, data)
	{
		$.each(data, function(key, value)
		{
			appendDataToComboBox(controlId, value.nid, value.name);
		});
	}
	
	function getValidateData()
	{
		var holiday = new Holiday(); 
		holiday.name = $("#Name").val(); 
		
		var datepicker = $("#HolidayDate").data("kendoDatePicker");
		holiday.holidayDate = kendo.toString(datepicker.value(), "yyyy-MM-dd");
		holiday.type = $("#Type").data("kendoComboBox").value();
		
		holiday.recurring = $("#Recurring").data("kendoComboBox").value() == "1" ? true : false; 
		
	    var ajaxCore = new AjaxCore(); 
		var request = ajaxCore.sendRequestType(currentService + "/add", holiday, "post"); 
		
		request.success(function(data, status, xhrObj)
		{
			goToPage("holidaySetup.jsp");
		}); 
	}
	
	function moveDataFromSourceToTargetComboBox(sourceControlId, targetControlId)
	{
		var selectedItemList = $('#' + sourceControlId + " :selected");
		
		$.each(selectedItemList, function(key, value) 
		{
			appendDataToComboBox(targetControlId, value.value, value.text);
		});
		selectedItemList.remove();
	}
	
	function appendDataToComboBox(controlId, value, textValue)
	{
		$('#' + controlId).append($("<option></option>").attr("value", value).text(textValue)); 
	}
	
	
	
	function test()
	{	
		var request = $.ajax(
        {
              url: hostname + "/app/Core/Calendar/HolidayGroup" + "/getTest", 
              type: "get", 
              data: {id:1, nid : 1}, 
              dataType: "json",
              contentType: "application/json"
        });   
	}
	
	
</script>    

<div class="form dataEntry">
		
  <div class="sectionalForm"> 
   
   </div>

	<div class="formRow">
		&nbsp;
    </div>
	
	
    <div class="formRow">
		<div class="labelSection">Holiday Group</div><div class="inputSection">
		<select id="HolidayGroup">
			<option value="0">None</option>
		</select>
		
		</div>
    </div>
	
	<div class="formRow">
		&nbsp;
    </div>
	
	
	<div class="sectionalForm"> 
   <div class="leftSection">
	<div class="labelSection">Available Holidays</div><div class="inputSection">
		<select id="AvailableHoliday" multiple="multiple">
		</select>
		
	</div>
   </div> 
	
	<div class="rightSection">
		<div class="inlineLabelSection">Allocated Holidays</div><div class="inlineLabelSection">
			<select id="AllocatedHoliday" multiple="multiple">
	    	</select>
		</div>
	</div>
  </div>
	
	<div class="formRow">
		&nbsp;
    </div>

	<div> 
		<div class="command"><button type="button" id="saveBtn">Save Changes</button>
		<button type="button" id="cancelBtn">Cancel</button>
		<button type="button" id="testBtn">Test</button>
		
		<button type="button" id="availableToAllocated">-></button>
		<button type="button" id="allocatedToAvailable"><-</button>
		
		
		<button type="button" id="updateBtn">Update</button>
		</div>
	</div>
   
   <div>&nbsp;</div>
</div>

<%@ include file="/includes/footer.html" %>

</body>
</html>
	