<link href="../../css/company.css" media="screen" rel="stylesheet" type="text/css" />
<link href="../../css/dialogBox.css" media="screen" rel="stylesheet" type="text/css" />
<link href="../../css/entityJqueryUIOverride.css" media="screen" rel="stylesheet" type="text/css" />
<script language="javascript" src="../../js/viewmodal/Leave/infoDataViewModel.js"></script>
<script language="javascript" src="../../js/viewmodal/Leave/notificationAddViewModel.js"></script>
<script language="javascript" src="../../js/jquery.validationEngine-en.js"></script>


<script type="text/html" id="infoUpdateTemplate">

  <div class="formRowList">


    
    <div class="formRow">
      <div class="labelSectionBlockBold">Description</div>
      <span class='req'>&nbsp;</span>
      <div class="inputSectionBlock">
        <input type="text" id="nid" data-bind="value : nid" placeholder="nid"/>
      </div>
    </div>

    
    <div class="formRow">
      <div class="labelSectionBlockBold">Description</div>
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
        <input type="text" id="type" data-bind="value : type" placeholder="type"/>
      </div>
    </div>

    
    <div class="formRow">
      <div class="labelSectionBlockBold">Description</div>
      <span class='req'>&nbsp;</span>
      <div class="inputSectionBlock">
        <input type="text" id="refId" data-bind="value : refId" placeholder="refId"/>
      </div>
    </div>

    
    <div class="formRow">
      <div class="labelSectionBlockBold">Description</div>
      <span class='req'>&nbsp;</span>
      <div class="inputSectionBlock">
        <input type="text" id="startEffectiveDate" data-bind="value : startEffectiveDate" placeholder="startEffectiveDate"/>
      </div>
    </div>

    
    <div class="formRow">
      <div class="labelSectionBlockBold">Description</div>
      <span class='req'>&nbsp;</span>
      <div class="inputSectionBlock">
        <input type="text" id="endEffectiveDate" data-bind="value : endEffectiveDate" placeholder="endEffectiveDate"/>
      </div>
    </div>

    
    <div class="formRow">
      <div class="labelSectionBlockBold">Description</div>
      <span class='req'>&nbsp;</span>
      <div class="inputSectionBlock">
        <input type="text" id="lastUpdate" data-bind="value : lastUpdate" placeholder="lastUpdate"/>
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

<script type="text/html" id="infoViewTemplate">

  <div class="formRowList">
    <span class='columnDividerListView' data-bind="text : infoCategory"></span>
    <span class='columnDividerListView' data-bind="text : infoDescription"></span>
    <span class='columnDividerListView' data-bind="text : infoType"></span>
    <span class='columnDividerListView' data-bind="text : infoValue"></span>
    <span class='columnDividerListViewCmd'>
      <a href="#" data-bind="visible : $root.enableUpdate, click : $root.editInfoData">Edit</a>
    </span>
    <span class='columnDividerListViewCmd'>
      <a href="#" data-bind="visible : $root.enableDelete, click : $root.deleteInfoData">Delete</a>
    </span>
  </div>

</script>


<script type="text/html" id="infoAddTemplate">


  <span class="accordianRowHeader">
    <icon class="icon-plus-circle-1"></icon>
  </span>

  <div class="formAddRow">

    <div class='columnDivider'>
      <div class="labelSectionInfo">Category</div>
      <div class="inputSectionForm">
        <input id="notificationCategoryAdd" type="text" class="validate[required, maxSize[10]]" data-bind="value : $root.addInfoCategory" placeholder="new category"/>
      </div>

    </div>

    <div class='columnDivider'>
      <div class="labelSectionInfo">Description</div>
      <span class='req'>*</span>
      <div class="inputSectionForm">
        <input type="text" id="notificationDescriptionAdd" data-bind="value : $root.addInfoDescription" placeholder="new description"/>
      </div>
    </div>


    <div class='columnDivider'>
      <div class="labelSectionInfo">Type</div>
      <span class='req'>*</span>
      <div class="inputSectionForm">
        <input type="text" id="notificationTypeAdd" data-bind="value : $root.addInfoType" class="validate[required, maxSize[10]]" placeholder="new type"/>
      </div>
    </div>

    <div class='columnDivider'>
      <div class="labelSectionInfo">Value</div>
      <span class='req'>*</span>
      <div class="inputSectionForm">
        <input type="text" data-bind="value : $root.addInfoValue" placeholder="new value"/>
      </div>
    </div>

    <span class="formAddRowCommand">
      <button id="addBtn" type="button" data-bind="visible: $root.enableAdd, click: addInfo" class="command">Add</button>
      <button id="addCancelBtn" type="button" data-bind="visible: $root.enableAdd, click : $root.closeAddControl" class="command">Cancel</button>
    </span>

    <span class="formRowSpacer"></span>

  </div>


</script>











<script type="text/html" id="NotificationEntityAddTemplate">

  <div class="form">

    <div class="formMainContent">

            
      <div class="formRow">
        <div class="labelSectionBlockBold">Description</div>
        <span class='req'>&nbsp;</span>
        <div class="inputSectionBlock">
          <input type="text" id="nid" data-bind="value : nid" placeholder="nid"/>
        </div>
      </div>

             
      <div class="formRow">
        <div class="labelSectionBlockBold">Description</div>
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
          <input type="text" id="type" data-bind="value : type" placeholder="type"/>
        </div>
      </div>

             
      <div class="formRow">
        <div class="labelSectionBlockBold">Description</div>
        <span class='req'>&nbsp;</span>
        <div class="inputSectionBlock">
          <input type="text" id="refId" data-bind="value : refId" placeholder="refId"/>
        </div>
      </div>

             
      <div class="formRow">
        <div class="labelSectionBlockBold">Description</div>
        <span class='req'>&nbsp;</span>
        <div class="inputSectionBlock">
          <input type="text" id="startEffectiveDate" data-bind="value : startEffectiveDate" placeholder="startEffectiveDate"/>
        </div>
      </div>

             
      <div class="formRow">
        <div class="labelSectionBlockBold">Description</div>
        <span class='req'>&nbsp;</span>
        <div class="inputSectionBlock">
          <input type="text" id="endEffectiveDate" data-bind="value : endEffectiveDate" placeholder="endEffectiveDate"/>
        </div>
      </div>

             
      <div class="formRow">
        <div class="labelSectionBlockBold">Description</div>
        <span class='req'>&nbsp;</span>
        <div class="inputSectionBlock">
          <input type="text" id="lastUpdate" data-bind="value : lastUpdate" placeholder="lastUpdate"/>
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

    var formName = "notificationForm";
    $(document).ready(function()
    {
            var vm;
            $.when(init()).done(bind());
            
            function init()
            {

                 if (globalViewModel != undefined && globalViewModel.targetId() != null)
                 {  
                      vm = new NotificationInfoViewModel(coreModeEdit, globalViewModel);
                  }
                 else
                 {
                      vm = new NotificationInfoViewModel(coreModeInsert, globalViewModel);
                 }
            }
            
            function bind()
            {
                $("#notificationForm").setupViewBinding(vm, globalViewModel);
                $("#accordianNotification").accordion({collapsible : true, active: false});
                $("#" + formName).validationEngine();
            }
    });

</script>

<form id="notificationForm">
  <div id="notificationMaintenance" data-bind="template : { name : templateToUse} ">
        </form>