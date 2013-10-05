<link href="../../css/company.css" media="screen" rel="stylesheet" type="text/css" />
<link href="../../css/dialogBox.css" media="screen" rel="stylesheet" type="text/css" />
<link href="../../css/entityJqueryUIOverride.css" media="screen" rel="stylesheet" type="text/css" />
<script language="javascript" src="../../js/viewmodal/infoDataViewModel.js"></script>
<script language="javascript" src="../../js/viewmodal/Payroll/workPackageAddViewModel.js"></script>
<script language="javascript" src="../../js/jquery.validationEngine-en.js"></script>



<script type="text/html" id="WorkPackageEntityAddTemplate">

  <div class="form">

    <div class="formMainContent">

      <div class="formRow">
        <div class="labelSectionBlockBold">Work package name </div>
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
        <div class="labelSectionBlockBold">Application</div>
        <span class='req'>&nbsp;</span>
        <div class="inputSectionBlock">
          <input type="text" id="application" data-bind="value : application" placeholder="application"/>
        </div>
      </div>

             
      <div class="formRow">
        <div class="labelSectionBlockBold">Status</div>
        <span class='req'>&nbsp;</span>
        <div class="inputSectionBlock">
          <input type="text" id="status" data-bind="value : status" placeholder="status"/>
        </div>
      </div>

             
      <div class="formRow">
        <div class="labelSectionBlockBold">Setup Type</div>
        <span class='req'>&nbsp;</span>
        <div class="inputSectionBlock">
          <input type="text" id="setupType" data-bind="value : setupType" placeholder="setupType"/>
        </div>
      </div>

             
      <div class="formRow">
        <div class="labelSectionBlockBold">Type </div>
        <span class='req'>&nbsp;</span>
        <div class="inputSectionBlock">
          <input type="text" id="typeRefId" data-bind="value : typeRefId" placeholder="typeRefId"/>
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

    var formName = "workPackageForm";
    $(document).ready(function()
    {
            var vm;
            $.when(init()).done(bind());
            
            function init()
            {

                 if (globalViewModel != undefined && globalViewModel.targetId() != null)
                 {  
                      vm = new WorkPackageInfoViewModel(coreModeEdit, globalViewModel);
                  }
                 else
                 {
                      vm = new WorkPackageInfoViewModel(coreModeInsert, globalViewModel);
                 }
            }
            
            function bind()
            {
                $("#workPackageForm").setupViewBinding(vm, globalViewModel);
                $("#accordianWorkPackage").accordion({collapsible : true, active: false});
                $("#" + formName).validationEngine();
            }
    });

</script>

<form id="workPackageForm">
  <div id="workPackageMaintenance" data-bind="template : { name : templateToUse} ">
</form>