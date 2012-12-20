    <link href="../../css/themes/base/jquery.ui.all.css" media="screen" rel="stylesheet" type="text/css" />

        <script language="javascript" src="../../js/viewmodal/employeeHelper.js"></script>
        <script language="javascript" src="../../js/viewmodal/employeeMembershipViewModel.js"></script>

        <script type="text/javascript">

        $(document).ready(function()
        {

        $("#MembershipForm").validationEngine();

        var ajaxCore = new AjaxCore();
        var vm = new EmployeeMembershipViewModel(0);

        var gridDataObject = vm.getView();
        var input = vm.getRole();

        var coreCommand = new CoreCommand();
        coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);

        $(document).unbind("parseComplete");

        $(document).bind("parseComplete", function()
        {
            ko.applyBindings(vm, document.getElementById("MembershipAddDetailInfo"));
        });


        });

        </script>


        <form id="MembershipForm">


        <div id="MembershipAddDetailInfo">


        <div class="sectionalForm">
        <div class="leftSection">
        <div class="labelSection">Association</div><div class="inputSection"><input type="text" id="Association"
        data-bind="value: association" class="validate[required]"/></div>
        </div>

        <div class="rightSection">
        <div class="inlineLabelSection">Member Type</div><div class="inlineLabelSection"><input type="text"
        id="MemberType" data-bind="value: memberType" /></div>
        </div>
        </div>


        <div class="formRow">
        <div class="labelSection">Contact Details</div><div class="inputSection"><input type="text"
        id="MembershipContact" data-bind="value: membershipContact" class="validate[required]"/></div>
        </div>


        <div class="sectionalForm">
        <div class="leftSection">
        <div class="labelSection">Start Date</div><div class="inputSection"><input type="text" id="StartDate"
        data-bind="datepicker: startDate, datepickerOptions: { dateFormat : 'dd-mm-yy'}"/></div>
        </div>

        <div class="rightSection">
        <div class="inlineLabelSection">End Date</div><div class="inlineLabelSection"><input type="text" id="EndDate"
        data-bind="datepicker: endDate, datepickerOptions: { dateFormat : 'dd-mm-yy'}"/></div>
        </div>
        </div>


        <div class="formRow">
        <div class="labelSection">Membership period (in months)</div><div class="inputSection"><input type="text"
        id="MembershipPeriod" data-bind="value: membershipPeriod" class="validate[required]" /></div>
        </div>


        <div class="formRow">
        <div class="labelSection">Enrollment Fees</div><div class="inputSection"><input type="text" id="EnrollmentFees"
        data-bind="value: enrollmentFees" class="validate[required, custom[integer]]" /></div>
        </div>


        <div class="formRow">
        <div class="labelSection">Membership Fees</div><div class="inputSection"><input type="text" id="MembershipFees"
        data-bind="value: membershipFees" class="validate[required, custom[integer]]"/></div>
        </div>


        <div class="formRow">
        <div class="labelSection">Attachment</div><div class="inputSection"><input type="text" id="Attachment"
        data-bind="value: attachment"/></div>
        </div>


        <div class="formRow">
        <div class="labelSection">Remarks</div><div class="inputSection"><input type="text" id="Remarks"
        data-bind="value: remarks" class="validate[required, maxSize[40]]"/></div>
        </div>


        <div class="formRow">
        <div></div>
        </div>


        <div class="formRow">
        <div id="userCommand"></div>
        </div>


        </div>

        </form>