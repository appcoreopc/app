        <link href="../../css/themes/base/jquery.ui.all.css" media="screen" rel="stylesheet" type="text/css" />
        <link href="../../css/employeeGeneralAddForm.css" media="screen" rel="stylesheet" type="text/css" />
        <script language="javascript" src="../../js/viewmodal/employeeHelper.js"></script>
        <script language="javascript" src="../../js/viewmodal/employeeExpertiseViewModel.js"></script>

        <script type="text/javascript">

        $(document).ready(function()
        {

        $("#ExpertiseForm").validationEngine();

        var ajaxCore = new AjaxCore();
        var vm = new EmployeeExpertiseViewModel(0);

        var gridDataObject = vm.getView();
        var input = vm.getRole();

        var coreCommand = new CoreCommand();
        coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);

        $(document).unbind("parseComplete");

        $(document).bind("parseComplete", function()
        {
        vm.loadInitData();
        ko.applyBindings(vm, document.getElementById("employeeExpertiseAddDetailInfo"));
        });

        });

        </script>


        <form id="ExpertiseForm">


        <div id="employeeExpertiseAddDetailInfo">


        <div class="sectionalForm">
        <div class="leftSection">
        <div class="labelSection">Industry</div><div class="inputSection"><select type="text" data-bind="options:
        industryList, optionsText: 'name', optionsValue: 'nid', value: industry" id="Industry" /></div>
        </div>

        <div class="rightSection">
        <div class="inlineLabelSection">Specialty</div><div class="inlineLabelSection"><select type="text"
        data-bind="options: industryList, optionsText: 'name', optionsValue: 'nid', value: specialty" id="Specialty"
        /></div>
        </div>
        </div>


        <div class="sectionalForm">
        <div class="leftSection">
        <div class="labelSection">Start Date</div><div class="inputSection"><input type="text" id="StartDate"
        data-bind="datepicker: startDate, datepickerOptions: { dateFormat : 'dd-mm-yy'}"/></div>
        </div>

        <div class="rightSection">
        <div class="inlineLabelSection">End Date</div><div class="inlineLabelSection"><input type="text"
        data-bind="datepicker: endDate, datepickerOptions: { dateFormat : 'dd-mm-yy'}" id="EndDate" /></div>
        </div>
        </div>


        <div class="sectionalForm">
        <div class="labelSection">Period</div><div class="inputSection"><input type="text" id="Period" data-bind="value:
        period" class="validate[required, custom[number]]" /></div>
        </div>


        <div class="sectionalForm">
        <div class="labelSection">Remarks</div><div class="inputSection"><input type="text" id="Remarks"
        data-bind="value: remarks" class="validate[maxSize[40]]"/></div>
        </div>


        <div class="sectionalForm">
        <div></div>
        </div>


        <div class="sectionalForm">
        <div id="userCommand"></div>
        </div>


        </div>

        </form>