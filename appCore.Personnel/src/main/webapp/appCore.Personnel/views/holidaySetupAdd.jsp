    <link href="../../css/company.css" media="screen" rel="stylesheet" type="text/css" />
        <link href="../../css/dialogBox.css" media="screen" rel="stylesheet" type="text/css" />

        <script language="javascript" src="../../js/viewmodal/holidaySetupAddViewModel.js"></script>
        <script language="javascript" src="../../js/jquery.validationEngine-en.js"></script>
        <script type="text/javascript" src="../../js/coreDefaultBinding.js"></script>

        <script type="text/html" id="holidaySetupAddTemplate">

        <div class="form">

        <div class="formMainContent">

        <div class="sectionalFormHeader">Holiday setup</div>


        <div class="formRow">
        <div class="labelSectionBlockBold">Holiday Date</div><span class='req'>*</span><div class="inputSectionBlock">
        <input type="text" id="HolidayDate" data-bind="datepicker: holidayDate, datepickerOptions: { dateFormat :
        'dd-mm-yy'}, value : holidayDate"/>
        </div>
        </div>

        <div class="formRow">
        <div class="labelSectionBlock">Holiday Name</div><span class='req'>*</span><div class="inputSectionBlock">
        <input type="text" id="Enabled" data-bind="value : holidayName" /></div>
        </div>


        <div class="formRow">
        <div class="labelSectionBlock">Type</div><span class='req'>*</span><div class="inputSectionBlock">
        <select id="holidayType" data-bind="value: holidayType">
        <option value="1">Gazetted</option>
        <option value="0">Non-Gazetted</option>
        </select>
        </div>
        </div>


        <div class="formRow">
        <div class="labelSectionBlock">Recurring</div><span class='req'>&nbsp;</span><div class="inputSectionBlock">
        <select id="recurring" data-bind="value: recurring">
        <option value="true">Yes</option>
        <option value="false">No</option>
        </select>

        </div>
        </div>


        <div> <div class="maintenanceCommandSpace"></div>
        <div id="divisionCommand" class="maintenanceCommand">
        <button id="saveBtn" type="button" data-bind="visible : enableAdd || enableUpdate, click : updateData"
        class="command">Save</button>
        <button id="cancelBtn" type="button" data-bind="click : cancelUpdate" class="command">Cancel</button>
        </div>
        </div>

        </div>

        <div>&nbsp;
        </div>

        </div>

        </script>


        <script type="text/javascript">

        var formName = "holidayAddForm";

        $(document).ready(function()
        {
            $("#" + formName).validationEngine();
            var vm = new HolidaySetupAddViewModel(globalViewModel);
            $("#holidayAddForm").setupViewBinding(vm, globalViewModel);
        });

        </script>


        <form id="holidayAddForm">
        <div id="holidaySetupAddMaintenance" data-bind="template : { name : templateToUse} ">
        </form>