<link href="../../css/company.css" media="screen" rel="stylesheet" type="text/css" />
<link href="../../css/dialogBox.css" media="screen" rel="stylesheet" type="text/css" />
<link href="../../css/entityJqueryUIOverride.css" media="screen" rel="stylesheet" type="text/css" />
<script language="javascript" src="../../js/viewmodal/Leave/holidayLeaveEarningSchemeAddViewModel.js"></script>
<script language="javascript" src="../../js/jquery.validationEngine-en.js"></script>



<script type="text/html" id="HolidayLeaveEarningSchemeEntityAddTemplate">

  <div class="form">

    <div class="formMainContent">


      <div class="formRow">
        <div class="labelSectionBlockBold">Name</div>
        <span class='req'>&nbsp;</span>
        <div class="inputSectionBlock">
          <input type="text" id="name" data-bind="value : name" placeholder="name"/>
        </div>
      </div>

             
      <div class="formRow">
        <div class="labelSectionBlockBold">Description</div>
        <span class='req'>&nbsp;</span>
        <div class="inputSectionBlock">
          <input type="text" id="description" data-bind="value : description" placeholder="description"/>
        </div>
      </div>


      <div class="formRow">
        <div class="labelSectionBlockBold">Description</div>
        <span class='req'>&nbsp;</span>
        <div class="inputSectionBlock">
          <input type="text" id="startEffectiveDate" data-bind="datepicker: startEffectiveDate, datepickerOptions: { dateFormat : 'dd-mm-yy'}, value : startEffectiveDate"  placeholder="startEffectiveDate"/>
        </div>
      </div>

             
      <div class="formRow">
        <div class="labelSectionBlockBold">Description</div>
        <span class='req'>&nbsp;</span>
        <div class="inputSectionBlock">
          <input type="text" id="endEffectiveDate" data-bind="datepicker: endEffectiveDate, datepickerOptions: { dateFormat :'dd-mm-yy'}, value : endEffectiveDate" placeholder="endEffectiveDate"/>
        </div>
      </div>

      <div>
        <div class="maintenanceCommandSpace"></div>
        <div id="sectionCommand" class="maintenanceCommand">
          <button id="saveBtn" type="button" data-bind="visible : enableAdd || enableUpdate, click : updateData"
          class="command">Save</button>
          <button id="cancelBtn" type="button" data-bind="click : cancelUpdate" class="command">Cancel</button>
        </div>
      </div>

    </div>

    <div>
      &nbsp;
    </div>
</div>

</script>


<script type="text/javascript">

    var formName = "holidayLeaveEarningSchemeForm";
    $(document).ready(function()
    {
            var vm;
            $.when(init()).done(bind());
            
            function init()
            {

                 if (globalViewModel != undefined && globalViewModel.targetId() != null)
                 {  
                      vm = new HolidayLeaveEarningSchemeInfoViewModel(coreModeEdit, globalViewModel);
                  }
                 else
                 {
                      vm = new HolidayLeaveEarningSchemeInfoViewModel(coreModeInsert, globalViewModel);
                 }
            }
            
            function bind()
            {
                $("#holidayLeaveEarningSchemeForm").setupViewBinding(vm, globalViewModel);
                $("#accordianHolidayLeaveEarningScheme").accordion({collapsible : true, active: false});
                $("#" + formName).validationEngine();
            }
    });

</script>

<form id="holidayLeaveEarningSchemeForm">
  <div id="holidayLeaveEarningSchemeMaintenance" data-bind="template : { name : templateToUse } ">
 </form>