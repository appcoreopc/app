    <link href="../../css/themes/base/jquery.ui.all.css" media="screen" rel="stylesheet" type="text/css" />

       <link href="../../css/codeMaintenance.css" media="screen" rel="stylesheet" type="text/css" />
        <script language="javascript" src="../../js/viewmodal/codeMaintenanceViewModel.js"></script>
        <script language="javascript" src="../../js/viewmodal/employeeHelper.js"></script>

        <script type="text/javascript">

        var form = "codeForm";

        var codeType = parseInt(globalCodeMaintenance);
        var vm;
        var gridDataObject;

        $(document).ready(function()
        {
        $("#" + form).validationEngine();

        if (globalCurrentId != undefined && globalCurrentId.id != null)
        {
        vm = new CodeMaintenanceViewModel(2, codeType, globalCurrentId.id);
        gridDataObject = vm.getView();
        }
        else
        {
        vm = new CodeMaintenanceViewModel(1, codeType);
        gridDataObject = vm.getView();
        }


        var input = { "id" : coreCodeMaintenancePage, "roleId" : 1 };
        var coreCommand = new CoreCommand();
        coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject, vm);

        $(document).unbind("parseComplete");

        $(document).bind("parseComplete", function()
        {
        ko.applyBindings(vm);
        });
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
        <div class="labelSection">Name</div><span class='req'>*</span><div class="inputSection"><input
        type="text" id="DivisionCode" data-bind="value: name" class="validate[required, maxSize[10]]" /><i
        class="icon-tag-1"></i></div>
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
        /><i class="icon-calendar"></i></div>
        </div>

        <div class="formRow">
        <div class="labelSection">Effective End Date</div><span class='req'>*</span><div class="inputSection"><input
        type="text" id="EndEffectiveDate" data-bind="datepicker: endEffectiveDate, datepickerOptions: { dateFormat :
        'dd-mm-yy'}, value : endEffectiveDate, enable : !disabled()" class="validate[required, maxSize[80]]"
        /><i class="icon-calendar"></i></div>
        </div>

        <div class="formRowSpacer">
        </div>


        <div class="formRow darken">
        <div class="labelSection"></div><div class="inputSection">


        <div> <div class="maintenanceCommandSpace"></div>
        <div class="maintenanceCommand" id="maintenanceCodeCommand">
        </div>
        </div>


        </div>
        </div>


        </div>
        </form>
