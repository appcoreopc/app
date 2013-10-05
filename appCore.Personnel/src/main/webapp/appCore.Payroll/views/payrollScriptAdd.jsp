<link href="../../css/company.css" media="screen" rel="stylesheet" type="text/css" />
<link href="../../css/dialogBox.css" media="screen" rel="stylesheet" type="text/css" />
<link href="../../css/entityJqueryUIOverride.css" media="screen" rel="stylesheet" type="text/css" />
<script language="javascript" src="../../js/viewmodal/infoDataViewModel.js"></script>
<script language="javascript" src="../../js/viewmodal/Payroll/payrollScriptAddViewModel.js"></script>
<script language="javascript" src="../../js/jquery.validationEngine-en.js"></script>


<script type="text/html" id="infoUpdateTemplate">

  <div class="formRowList">


    <div class="formRow">
      <div class="labelSectionBlockBold">Script Name</div>
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
      <div class="labelSectionBlockBold">Script Path</div>
      <span class='req'>&nbsp;</span>
      <div class="inputSectionBlock">
        <input type="text" id="scriptPath" data-bind="value : scriptPath" placeholder="scriptPath"/>
      </div>
    </div>


    
    <span class="formRowCommand">
      <span class="labelSectionCommand"></span>
      <span class="inputSectionForm">
        <button id="updateBtn" type="button" data-bind="visible : $root.enableUpdate, click : $root.updateInfoData"
        class="command">Update</button>

        <button id="cancelUpdateBtn" type="button" data-bind="visible : $root.enableUpdate, click : $root.cancelInfoData"
        class="command">Cancel</button>

      </span>
    </span>

  </div>

  <span class="formRowSpacer">
  </span>



</script>



<script type="text/html" id="PayrollScriptEntityAddTemplate">

  <div class="form">

    <div class="formMainContent">


    <div class="formRow">
    <div class="labelSectionBlockBold">Script Name</div>
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
    <div class="labelSectionBlockBold">Script Path</div>
    <span class='req'>&nbsp;</span>
    <div class="inputSectionBlock">
    <input type="text" id="scriptPath" data-bind="value : scriptPath" placeholder="scriptPath"/>
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

    var formName = "payrollScriptForm";
    $(document).ready(function()
    {
            var vm;
            $.when(init()).done(bind());
       
            function init()
            {
                if (globalViewModel != undefined && globalViewModel.targetId() != null)
                {
                    vm = new PayrollScriptInfoViewModel(coreModeEdit, globalViewModel);
                }
                else
                {
                    vm = new PayrollScriptInfoViewModel(coreModeInsert, globalViewModel);
                }
            }
            
            function bind()
            {
                $("#payrollScriptForm").setupViewBinding(vm, globalViewModel);
                $("#accordianPayrollScript").accordion({collapsible : true, active: false});
                $("#" + formName).validationEngine();
            }
    });

</script>

<form id="payrollScriptForm">
    <div id="payrollScriptMaintenance" data-bind="template : { name : templateToUse} ">
 </form>