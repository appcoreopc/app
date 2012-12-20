        <link href="../../css/themes/base/jquery.ui.all.css" media="screen" rel="stylesheet" type="text/css" />

        <script language="javascript" src="../../js/viewmodal/employeeHelper.js"></script>
        <script language="javascript" src="../../js/viewmodal/employeeEmploymentViewModel.js"></script>

        <script type="text/javascript">

        $(document).ready(function()
        {

        $("#EmploymentForm").validationEngine();

        var ajaxCore = new AjaxCore();
        var vm = new EmployeeEmploymentViewModel(0);

        var gridDataObject = vm.getView();
        var input = vm.getRole();

        var coreCommand = new CoreCommand();
        coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);

        $(document).unbind("parseComplete");

        $(document).bind("parseComplete", function()
        {
            vm.loadInitData();
            ko.applyBindings(vm,  document.getElementById("employmentInfoAddDetailInfo"));
        });

        });

        </script>


        <form id="EmploymentForm">

        <div id="employmentInfoAddDetailInfo">

        <div class="sectionalForm">
        <div class="leftSection">
        <div class="labelSection">Employer Name</div><div class="inputSection"><input type="text" id="EmployerName"
        data-bind="value: employerName" class="validate[required, maxSize[40]]"/></div>
        </div>

        <div class="rightSection">
        <div class="inlineLabelSection">Job</div><div class="inlineLabelSection"><input type="text" id="Job"
        data-bind="value: job" class="validate[required, maxSize[40]]"/></div>
        </div>
        </div>

        <div class="formRow">
        <div class="labelSection">Industry</div><div class="inputSection"><select type="text" id="Industry"
        data-bind="options: industryList, optionsText: 'name', optionsValue: 'nid', value: industry"/></div>
        </div>


        <div class="sectionalForm">
        <div class="leftSection">
        <div class="labelSection">Start Date</div><div class="inputSection"><input type="text" id="StartDate"
        data-bind="datepicker: startDate, datepickerOptions: { minDate: new Date(), dateFormat : 'dd-mm-yy' }"/></div>
        </div>

        <div class="rightSection">
        <div class="inlineLabelSection">End Date</div><div class="inlineLabelSection"><input type="text" id="EndDate"
        data-bind="datepicker: endDate, datepickerOptions: { minDate: new Date(), dateFormat : 'dd-mm-yy' }"/></div>
        </div>
        </div>


        <div class="formRow">
        <div class="labelSection">Duration</div><div class="inputSection"><input type="text" id="Duration"
        data-bind="value: duration" class="validate[required]"/></div>
        </div>


        <div class="formRow">
        <div class="labelSection">Last Drawn Salary</div><div class="inputSection"><input type="text"
        id="LastDrawnSalary" data-bind="value: lastDrawnSalary" class="validate[required, custom[number]]"/></div>
        </div>


        <div class="formRow">
        <div class="labelSection">Resignation Reason</div><div class="inputSection"><input type="text"
        id="ResignationReason" data-bind="value: resignationReason" class="validate[required, maxSize[40]]"/></div>
        </div>


        <div class="formRow">
        <div class="labelSection">Remarks</div><div class="inputSection"><input type="text" id="Remarks"
        data-bind="value: remarks" class="validate[required, maxSize[40]]" /></div>
        </div>


        <div class="formRow">
        <div></div>
        </div>


        <div class="formRow">
        <div id="userCommand"></div>
        </div>


        </div>

        </form>