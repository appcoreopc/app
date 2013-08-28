    <script language="javascript" src="../../js/viewmodal/codeMaintenanceViewModel.js"></script>

        <script type="text/javascript">

        var form = "codeForm";

        var codeType = parseInt(globalCodeMaintenance);

        $(document).ready(function()
        {
            $("#" + form).validationEngine();

            var vm = new CodeMaintenanceViewModel(1, codeType);
            var gridDataObject = vm.getView();

            var input = { "id" : coreCodeMaintenancePage, "roleId" : 1 };
            var coreCommand = new CoreCommand();
            coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject, vm);

        });


        </script>


        <form id="codeForm">

        <div class="form">

        <div class="formRow">
        <div class="labelSection" data-bind="text: title"></div>
        </div>


        <div class="sectionalForm">
        <div class="leftSection">
        <div class="labelSection">Name</div><span class='req'>*</span><div class="inputSection"><input
        type="text" id="DivisionCode" data-bind="value: name" class="validate[required, maxSize[10]]" /></div>
        </div>

        <div class="rightSection">
        <div class="inlineLabelSection">Disabled</div><div class="inlineLabelSection"><input type="checkbox"
        id="Enabled" value="Disabled"/></div>
        </div>
        </div>

        <div class="formRow">
        <div class="labelSection">Description</div><span class='req'>*</span><div class="inputSection"><input
        type="text" id="DivisionName" data-bind="value: description" class="validate[required, maxSize[20]]"/></div>
        </div>

        <div class="formRow">
        <div class="labelSection">Effective Start Date</div><span class='req'>*</span><div class="inputSection"><input
        type="text" id="SartEffectiveDate" data-bind="value: startEffectiveDate" class="validate[required, maxSize[80]]"
        /></div>
        </div>

        <div class="formRow">
        <div class="labelSection">Effective End Date</div><span class='req'>*</span><div class="inputSection"><input
        type="text" id="EndEffectiveDate" data-bind="value: endEffectiveDate" class="validate[required, maxSize[80]]"
        /></div>
        </div>


        <div> <div class="maintenanceCommandSpace"></div>
        <div class="maintenanceCommand" id="maintenanceCodeCommand">
        </div>
        </div>

        </div>

        </form>