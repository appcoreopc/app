<script type="text/javascript">          

    var holidayService = globalHostname + "/app/Core/Calendar/Holiday";
    var groupHolidayService = globalHostname + "/app/Core/Calendar/HolidayGroup";
	var holidayGroupData = []; 
	var allHolidays = [];
	var currentWorkList=[]; 
	
	var HolidayDataObject = function()
	{
		this.id; 
		this.holidayId;
		this.isGrantAccess;
	}
	
	$(document).ready(function() 
	{
		 getAllHolidayGroupData(groupHolidayService + "/list", "get", "HolidayGroup");
		 getAllHolidaysData(holidayService + "/list", "get", "AvailableHoliday");
	 
		 $("#HolidayGroup").change(function()
		 {
			getListForDisplay("HolidayGroup", "AllocatedHoliday");
		 });
		 
		 // grant access
		 $("#availableToAllocated").click(function()
		 {
			grantHolidays("AvailableHoliday", "AllocatedHoliday");
		 });
		 
		 // revoke access 
		 $("#allocatedToAvailable").click(function()
		 {
			revokeHolidays("AllocatedHoliday", "AvailableHoliday");
		 });
	 
		 $("#saveBtn").click(function()
		 {
			getValidateData();
		 });
		 
		 $("#updateBtn").click(function()
		 {
				
				if (currentWorkList != undefined && currentWorkList.length > 0)
				{
					for (var i=0; i < currentWorkList.length; i++)
					{
						var hdo = currentWorkList[i]; 
						var ajaxCore = new AjaxCore(); 
						var request = ajaxCore.sendRequest(groupHolidayService + "/configuredHolidayGroup", hdo, "get"); 
					
						request.done(function(data)
						{
							
						}); 
					}
					
					currentWorkList = [];
				}
		 });
		 	 
		 $("#cancelBtn").click(function()
		 {
			var result = cancelFormChanges();
			if (result) 
			   window.location.replace("holidaySetup.jsp");
		 });
 	});
	
	function getAllHolidayGroupData(url, method, controlId)
	{
		var ajaxCore = new AjaxCore(); 
		var request = ajaxCore.sendRequestType(url, null, method); 
	
		request.done(function(data)
		{
			var i=0;
			$.each(data, function(key, value) 
			{   
				holidayGroupData[value.name] = value.holidays;
				appendDataToComboBox(controlId, value.nid, value.name);
				i++;
			});
		});
	}
	
	function getListForDisplay(sourceControlId, targetControlId)
	{
		var groupName = $("#" + sourceControlId + " option:selected").text();
		var assignedHolidays = holidayGroupData[groupName];
		
		if (assignedHolidays != undefined) 
		{
			var newList = allHolidays.slice(); 
		
				for (var i = 0; i < assignedHolidays.length; i++)
				{
					for (var k = 0; k < newList.length; k++)
					{ 
							if (newList[k].name == assignedHolidays[i].name)
							{
								newList.splice(k, 1);  // remove the list
							}
					}
				}
			
			clearComboBox(targetControlId);
			clearComboBox("AvailableHoliday");
			
			if (newList.length > 0) 
			{
				pushDataToComboBox("AvailableHoliday", newList);
			}
			
			pushDataToComboBox(targetControlId, assignedHolidays);
		}
		else 
		{
				appendAvailableHolidayDataToComboBox(allHolidays, targetControlId);
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
	
	function pushDataToComboBox(controlId, data)
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
	
	
	
	function revokeHolidays(sourceControlId, targetControlId)
	{
		var selectedItemList = $('#' + sourceControlId + " :selected");
		
		$.each(selectedItemList, function(key, value) 
		{
			var holidayGroup = $("#HolidayGroup option:selected").val(); 
			var holidayGroupText = $("#HolidayGroup option:selected").text(); 
			var assignedHolidays = holidayGroupData[holidayGroupText];
			
			var isAccessRevoked = false;
			var currentValue = parseInt(value.value);
			for (var i=0; i < assignedHolidays.length; i++)
			{
				if (assignedHolidays[i].nid == currentValue)
				{
					var hdo = new HolidayDataObject();
					hdo.id = holidayGroup;
					hdo.holidayId = value.value;
					hdo.isGrantAccess = false;
					currentWorkList.push(hdo);
					isAccessRevoked = true;
					break;
				}	
			}
			
			if (!isAccessRevoked)
			{
				removeCurrentWorkList(currentValue);
			}
			
			appendDataToComboBox(targetControlId, value.value, value.text);
		});
		selectedItemList.remove();
	}
	
	function grantHolidays(sourceControlId, targetControlId)
	{
		var selectedItemList = $('#' + sourceControlId + " :selected");
		
		$.each(selectedItemList, function(key, value) 
		{
			var holidayGroup = $("#HolidayGroup option:selected").val(); 
			var holidayGroupText = $("#HolidayGroup option:selected").text(); 
			var assignedHolidays = holidayGroupData[holidayGroupText];
				
			var alreadyGranted = false; 
			
			for (var i=0; i < assignedHolidays.length; i++)
			{
				var compareValue = parseInt(value.value);
				
				if (assignedHolidays[i].nid == compareValue)
				{
					removeCurrentWorkList(compareValue);
					alreadyGranted = true;
					break;
				}	
			}
			
			if (!alreadyGranted) 
			{	
				var hdo = new HolidayDataObject();
				hdo.id = holidayGroup;
				hdo.holidayId = value.value;
				hdo.isGrantAccess = true;
				currentWorkList.push(hdo);
			}
			
			appendDataToComboBox(targetControlId, value.value, value.text);
		});
		selectedItemList.remove();
	}
	
	function removeCurrentWorkList(id)
	{
		for (var i=0; i < currentWorkList.length; i++)
		{
			if (currentWorkList[i].holidayId == id)
			{
				currentWorkList.splice(i, 1);
			}
		}
	}
	
	function debugCurrentList()
	{
		for (var i=0; i < currentWorkList.length; i++)
		{
			alert(currentWorkList[i].id +  "; " + currentWorkList[i].holidayId  + ";" + currentWorkList[i].isGrantAccess);
		}
	}
	
	
	function appendDataToComboBox(controlId, value, textValue)
	{
		$('#' + controlId).append($("<option></option>").attr("value", value).text(textValue)); 
	}
	
	function test()
	{	
		var request = $.ajax(
        {
              url: globalHostname + "/app/Core/Calendar/HolidayGroup" + "/getTest",
              type: "get", 
              data: {id:1, nid : 1}, 
              dataType: "json",
              contentType: "application/json"
        });   
	}
	
	
</script>    

<form id="myform">

<div class="form">
  <div class="sectionalForm"> 
   </div>

   <div class="formRow">
		&nbsp;
    </div>
    
	<div class="sectionalForm"> 
   <div class="leftSection">
	<div class="labelSection">Available Holidays</div><div class="inputSection">
		<select id="AllHolidayGroup">
			<option value="0">All Holiday</option>
		</select>
		
	</div>
   </div> 
	
	<div class="rightSection">
		<div class="inlineLabelSection">Holiday Group</div><div class="inlineLabelSection">
			<select id="HolidayGroup">
			<option value="0">All Holiday</option>
		</select>
		</div>
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
		<button type="button" id="availableToAllocated">-></button>
		<button type="button" id="allocatedToAvailable"><-</button>
		<button type="button" id="updateBtn">Update</button>
		</div>
	</div>
   
   <div>&nbsp;</div>
</div>
</form>