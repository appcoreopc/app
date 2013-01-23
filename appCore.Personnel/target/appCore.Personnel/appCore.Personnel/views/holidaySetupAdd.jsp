<script type="text/javascript">          

    var currentService = globalHostname + "/app/Core/Calendar/Holiday";

	$("#myform").validationEngine();
	
	$(document).ready(function() 
	{
		 $("#HolidayDate").kendoDatePicker();
		 $("#Type").kendoComboBox();
		 $("#Recurring").kendoComboBox();
		  
		 $("#saveBtn").live("click", function()
		 {
			if (evt.handled !== true)
			{ 
				evt.handled = true; 
				getValidateData();
			}
		 });
			 
		 $("#cancelBtn").live("click", function(evt)
		 {
			if (evt.handled !== true)
			{ 
				evt.handled = true; 
				var result = cancelFormChanges();
				if (result) 
					preparePageForLoading("holidaySetup.jsp");
			}
		 });
 	});

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
			// goToPage("holidaySetup.jsp");
			preparePageForLoading("holidaySetup.jsp");
		}); 
		
	}
	
	
</script>    

<form id="myform">


<div class="form">
		
  <div class="sectionalForm"> 
   
   <div class="formRow">
		<div class="labelSection">Holiday Date</div><span class='req'>*</span><div class="inputSection"><input type="text" class="validate[required]" id="HolidayDate" /></div>
    </div>

	
    <div class="formRow">
		<div class="labelSection">Holiday Name</div><span class='req'>*</span><div class="inputSection"><input type="text" id="Name" class="validate[required, maxSize[20]]"  value="Name"/></div>
    </div>

	<div class="formRow">
		<div class="labelSection">Type</div><span class='req'>*</span><div class="inputSection">
			<select id="Type" class="validate[required]" >
				<option value="1">Gazetted</option>
				<option value="0">Non-Gazetted</option>
			</select>
		</div>
    </div>
	
	<div class="formRow">
		<div class="labelSection">Recurring</div><span class='req'>*</span><div class="inputSection">
			<select id="Recurring" class="validate[required]" >
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
</form>