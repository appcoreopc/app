<link href="../../css/company.css" media="screen" rel="stylesheet" type="text/css" />
<link href="../../css/dialogBox.css" media="screen" rel="stylesheet" type="text/css" />
<link href="../../css/entityJqueryUIOverride.css" media="screen" rel="stylesheet" type="text/css" />
<script language="javascript" src="../../js/viewmodal/infoDataViewModel.js"></script>
<script language="javascript" src="../../js/viewmodal/Leave/employeeHolidayAddViewModel.js"></script>
<script language="javascript" src="../../js/jquery.validationEngine-en.js"></script>

<script type="text/html" id="EmployeeHolidayEntityAddTemplate">

  <div class="form">

    <div class="formMainContent">

      <div class="formRow">
        <div class="labelSectionBlockBold">Employee Name</div>
        <span class='req'>&nbsp;</span>
        <div class="inputSectionBlock">
          <select id="nid" data-bind="options: entityList, optionsText: 'name', optionsValue: 'nid', value: employeeId, optionsCaption: 'Select...'" placeholder="name">
          </select>
        </div>
      </div>

             
      <div class="formRow">
        <div class="labelSectionBlockBold">Entitlement</div>
        <span class='req'>&nbsp;</span>
        <div class="inputSectionBlock">
          <select id="holidayEntitlementType" data-bind="options: holidayEntitlementType, optionsText: 'name', optionsValue: 'nid', value: currentHolidayEntitlementType, optionsCaption: 'Select...'">
          </select>
        </div>
      </div>

    <div class="formRow">
        <div class="labelSectionBlockBold">Leave Replacement Type</div>
        <span class='req'>&nbsp;</span>
        <div class="inputSectionBlock">
            <select id="holidayReplacementType" data-bind="options: leaveReplacementType, optionsText: 'name', optionsValue: 'nid', value: currentLeaveReplacementType, optionsCaption: 'Select...'" placeholder="holidayEntitlementType">
            </select>
        </div>
    </div>

      <div class="formRow">
        <div class="labelSectionBlockBold">Leave Earning Scheme</div>
        <span class='req'>&nbsp;</span>
        <div class="inputSectionBlock">
          <select id="leaveEarningScheme" data-bind="options: leaveEarningScheme, optionsText: 'name', optionsValue: 'nid' , value: currentLeaveEarningScheme, optionsCaption: 'Select...'" placeholder="leaveEarningScheme">
          </select>
        </div>
      </div>


      <div class="formRow">
        <div class="labelSectionBlockBold">Approval Process</div>
        <span class='req'>&nbsp;</span>
        <div class="inputSectionBlock">
          <input type="text" id="leaveWorkflow" data-bind="value : currentWorkflowId" placeholder="leaveWorkflow"/>
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

    var formName = "employeeHolidayForm";


    $(document).ready(function()
    {
            var vm;

            if (globalViewModel != undefined && globalViewModel.targetId() != null)
            {
                vm = new EmployeeHolidayInfoViewModel(coreModeEdit, globalViewModel);
            }
            else
            {
                vm = new EmployeeHolidayInfoViewModel(coreModeInsert, globalViewModel);
            }
            vm.renderView();

    });


</script>

<form id="employeeHolidayForm">
  <div id="employeeHolidayMaintenance" data-bind="template : { name : templateToUse} ">
</form>