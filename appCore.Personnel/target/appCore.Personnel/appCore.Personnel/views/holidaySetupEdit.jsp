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

    var currentService = globalHostname + "/app/Core/Calendar/Holiday";

	$(document).ready(function() 
	{
	
		$("#HolidayDate").kendoDatePicker();
		$("#Type").kendoComboBox();
		$("#Recurring").kendoComboBox();
		 
		var value = getParameterByName("id");
		
		if (value != null) 
		{
			var ajaxCore = new AjaxCore();
			var request = ajaxCore.sendRequest(globalHostname + "/app/Core/Calendar/Holiday/get", { id : value }, "get");
	
			request.done(function(data)
			{
				if (data == null) 
					return;
				
				$("#Nid").val(data.nid);
				
				var holidayDatePicker = $("#HolidayDate").data("kendoDatePicker");
				var parsedDate = kendo.parseDate(data.holidayDate, "yyyy-MM-dd");
				holidayDatePicker.value(parsedDate);
				
				$("#Name").val(data.name);
				
				var type = $("#Type").data("kendoComboBox");
				type.value(data.type); 
				
				var recurring =  $("#Recurring").data("kendoComboBox");
				
				var finalRecurringState = data.recurring == true ? "1" : "0"; 
				recurring.value(finalRecurringState);
		   });
		}
	
		  
		 $("#saveBtn").click(function()
		 {
			getValidateData();
		 });
			 
		 $("#cancelBtn").click(function()
		 {
			var result = cancelFormChanges();
			if (result) 
			   window.location.replace("holidaySetup.jsp");
		 });
		 
 	});

	function getValidateData()
	{
		var holiday = new Holiday(); 
		holiday.nid = $("#Nid").val();
		holiday.name = $("#Name").val(); 
		
		var datepicker = $("#HolidayDate").data("kendoDatePicker");
		holiday.holidayDate = kendo.toString(datepicker.value(), "yyyy-MM-dd");
		holiday.type = $("#Type").data("kendoComboBox").value();; 
		holiday.recurring = $("#Recurring").data("kendoComboBox").value() == "1" ? true : false; 
		
	    var ajaxCore = new AjaxCore(); 
		var request = ajaxCore.sendRequestType(currentService + "/saveOrUpdate", holiday, "post"); 
		
		request.success(function(data, status, xhrObj)
		{
			goToPage("holidaySetup.jsp");
		}); 
	}
	
</script>    

<div class="form dataEntry">
		
  <div class="sectionalForm"> 
   
   <div class="formRow"><input type="hidden" id="Nid" name="Nid" />
		<div class="labelSection">Holiday Date</div><div class="inputSection"><input type="text" id="HolidayDate" /></div>
    </div>

	
    <div class="formRow">
		<div class="labelSection">Holiday Name</div><div class="inputSection"><input type="text" id="Name" value="Name"/></div>
    </div>

	<div class="formRow">
		<div class="labelSection">Type</div><div class="inputSection">
			<select id="Type">
				<option value="1">Gazetted</option>
				<option value="0">Non-Gazetted</option>
			</select>
		</div>
    </div>
	
	<div class="formRow">
		<div class="labelSection">Recurring</div><div class="inputSection">
			<select id="Recurring">
				<option value="1">Yes</option>
				<option value="0">No</option>
			</select>
		</div>
	</div>
	
	<div class="formRow">
		&nbsp;
	</div>

	<div> 
		<div class="command"><button type="button" id="saveBtn">Save</button>
		<button type="button" id="cancelBtn">Cancel</button>
		</div>
	</div>
   
   <div>&nbsp;</div>
</div>

<%@ include file="/includes/footer.html" %>

</body>
</html>
