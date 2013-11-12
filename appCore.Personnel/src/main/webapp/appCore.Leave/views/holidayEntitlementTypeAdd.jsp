<link href="../../css/company.css" media="screen" rel="stylesheet" type="text/css" />
<link href="../../css/dialogBox.css" media="screen" rel="stylesheet" type="text/css" />
<link href="../../css/entityJqueryUIOverride.css" media="screen" rel="stylesheet" type="text/css" />
<script language="javascript" src="../../js/viewmodal/Leave/infoDataViewModel.js"></script>
<script language="javascript" src="../../js/viewmodal/Leave/holidayEntitlementTypeAddViewModel.js"></script>
<script language="javascript" src="../../js/jquery.validationEngine-en.js"></script>

<script type="text/html" id="HolidayEntitlementTypeEntityAddTemplate">

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
        <div class="labelSectionBlockBold">Start Effective Date</div>
        <div class="inputSectionBlock">
          <input type="text" id="startEffectiveDate" data-bind="datepicker: startEffectiveDate, datepickerOptions: { dateFormat : 'dd-mm-yy'}, value : startEffectiveDate" placeholder="startEffectiveDate"/>
        </div>
      </div>

             
      <div class="formRow">
        <div class="labelSectionBlockBold">End Effective Date</div>
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

    var formName = "holidayEntitlementTypeForm";
    $(document).ready(function()
    {
            try
            {
                var vm;
                $.when(init()).done(bind());
            }
            catch (e)
            {
                console.log(e.message);
            }

            function init()
            {
                if (globalViewModel != undefined && globalViewModel.targetId() != null)
                {
                    vm = new HolidayEntitlementTypeInfoViewModel(coreModeEdit, globalViewModel);
                }
                else
                {
                    vm = new HolidayEntitlementTypeInfoViewModel(coreModeInsert, globalViewModel);
                }
            }

            function bind()
            {
                $("#holidayEntitlementTypeForm").setupViewBinding(vm, globalViewModel);
                $("#" + formName).validationEngine();
            }
    });

</script>

<form id="holidayEntitlementTypeForm">
  <div id="holidayEntitlementTypeMaintenance" data-bind="template : { name : templateToUse} ">
</form>