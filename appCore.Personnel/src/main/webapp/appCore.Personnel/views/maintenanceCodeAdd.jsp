
       <link href="../../css/themes/base/jquery.ui.all.css" media="screen" rel="stylesheet" type="text/css" />
       <link href="../../css/dialogBoxEdit.css" media="screen" rel="stylesheet" type="text/css" />

       <link href="../../css/codeMaintenance.css" media="screen" rel="stylesheet" type="text/css" />
       <script language="javascript" src="../../js/viewmodal/codeMaintenanceViewModel.js"></script>
       <script language="javascript" src="../../js/viewmodal/employeeHelper.js"></script>

        <script type="text/javascript">

        var form = "codeForm";

        var vm;
        var codeType = parseInt(globalCodeMaintenance);
        var gridDataObject;

        $(document).ready(function()
        {
            $("#" + form).validationEngine();

            if (globalViewModel != undefined && globalViewModel.targetId() != null && globalViewModel.editMode() == coreModeEdit)
            {
                vm = new CodeMaintenanceViewModel(coreModeEdit, codeType, globalViewModel.targetId, globalViewModel);
                gridDataObject = vm.getView();
            }
            else
            {
                vm = new CodeMaintenanceViewModel(coreModeInsert, codeType, null, globalViewModel);
                gridDataObject = vm.getView();
            }

            $("#codeForm").setupViewBinding(vm, globalViewModel);

        });

        function getEmptyDate(date)
        {
            return "empty";
        }


        </script>


        <form id="codeForm">

        <div class="whiteform">

        <div class="formRowTitle">


       <div class="labelSection codeTitle" data-bind="text: title"></div>

        </div>

        <div class="formRowSpacer">
        </div>

        <div class="sectionalForm">
        <div class="leftSection">
        <div class="labelSection">Name</div><span class='req'>*</span><div class="inputSection">
           <input type="text" id="code" data-bind="codepicker : name, codeEntity : { codeType : $root.codeType(), companyId : $root.companyId() }" class="validate[required, maxSize[10]]" /></div>


        </div>

        <div class="rightSection">
        <div class="inlineLabelSection">Disabled</div><div class="inlineLabelSection"><input type="checkbox"
        id="Enabled" data-bind="checked : disabled" value="Disabled"/></div>
        </div>
        </div>

        <div class="formRow">
        <div class="labelSection">Description</div><span class='req'>*</span><div class="inputSection"><input
        type="text" id="DivisionName" data-bind="value: description" class="validate[required, maxSize[20]]"/><i
        class="icon-doc2"></i></div>
        </div>

        <div class="formRow">
        <div class="labelSection">Effective Start Date</div><span class='req'>*</span><div class="inputSection"><input
        type="text" id="SartEffectiveDate" data-bind="datepicker: startEffectiveDate, datepickerOptions: { dateFormat :
        'dd-mm-yy'}, value : startEffectiveDate, enable : !disabled()" class="validate[required, maxSize[80]]"
        /></div>
        </div>

        <div class="formRow">
        <div class="labelSection">Effective End Date</div><span class='req'>*</span><div class="inputSection"><input
        type="text" id="EndEffectiveDate" data-bind="datepicker: endEffectiveDate, datepickerOptions: { dateFormat :
        'dd-mm-yy'}, value : endEffectiveDate, enable : !disabled()" class="validate[required, maxSize[80]]"
        /></div>
        </div>


        <div class="formRow">
        <div class="labelSection"></div>


        <div> <div class="maintenanceCommandSpace"></div>
        <div class="maintenanceCommand" data-bind="visible : $root.enableAdd || $root.enableUpdate" id="maintenanceCodeCommand">

           <button id="saveBtn" type="button" class="command" data-bind="click : saveDataForm, text: commandText">Add New Code</button>
           <button id="cancelBtn" type="button" class="command" data-bind="click : cancelChanges">Cancel</button>
        </div>
        </div>



        </div>


        </div>
        </form>
