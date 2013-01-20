        <link href="../../css/themes/base/jquery.ui.all.css" media="screen" rel="stylesheet" type="text/css" />
        <link href="../../css/employeeGeneralAddForm.css" media="screen" rel="stylesheet" type="text/css" />

        <script language="javascript" src="../../js/viewmodal/employeeHelper.js"></script>
        <script language="javascript" src="../../js/viewmodal/employeeMembershipViewModel.js"></script>

        <script type="text/javascript">

        $(document).ready(function()
        {

            $("#MembershipForm").validationEngine();

            var ajaxCore = new AjaxCore();
            var vm = new EmployeeMembershipViewModel(0, globalViewModel);

            var gridDataObject = vm.getView();
            var input = vm.getRole();

            try
            {
                var coreCommand = new CoreCommand();
                coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);
                ko.applyBindings(vm, document.getElementById("MembershipAddDetailInfo"));
            }
            catch (ex)
            {
                console.log(ex)
            }

        });

        </script>


        <form id="MembershipForm">


        <div id="MembershipAddDetailInfo">


        <div class="sectionalForm">
        <div class="leftSection">
        <div class="labelSection">Association</div><div class="inputSection"><input type="text" id="Association"
        data-bind="value: association" class="validate[required]" data-prompt-position="bottomRight"/></div>
        </div>

        <div class="rightSection">
        <div class="inlineLabelSection">Member Type</div><div class="inlineLabelSection"><select
        id="MemberType" data-bind="options: memberTypeList, optionsText: 'name', optionsValue: 'nid', value: memberType"></select></div>
        </div>
        </div>


        <div class="sectionalForm">
        <div class="labelSection">Contact Details</div><div class="inputSection"><input type="text"
        id="MembershipContact" data-bind="value: membershipContact" class="validate[required]" data-prompt-position="bottomRight"/></div>
        </div>


        <div class="sectionalForm">
        <div class="leftSection">
        <div class="labelSection">Start Date</div><div class="inputSection"><input type="text" id="StartDate"
        data-bind="datepicker: startDate, datepickerOptions: { dateFormat : 'dd-mm-yy'}"/></div>
        </div>

        <div class="rightSectionInline">
        <div class="inlineLabelSection">End Date</div><div class="inlineLabelSectionExtra"><input type="text" id="EndDate"
        data-bind="datepicker: endDate, datepickerOptions: { dateFormat : 'dd-mm-yy'}"/></div>
        </div>
        </div>


        <div class="sectionalForm">
        <div class="labelSection">Membership period (in months)</div><div class="inputSection"><input type="text"
        id="MembershipPeriod" data-bind="value: membershipPeriod" class="validate[required]" /></div>
        </div>


        <div class="sectionalForm">
        <div class="labelSection">Enrollment Fees</div><div class="inputSection"><input type="text" id="EnrollmentFees"
        data-bind="value: enrollmentFees" class="validate[required, custom[integer]]" /></div>
        </div>


        <div class="sectionalForm">
        <div class="labelSection">Membership Fees</div><div class="inputSection"><input type="text" id="MembershipFees"
        data-bind="value: membershipFees" class="validate[required, custom[integer]]"/></div>
        </div>


        <div class="sectionalForm">
        <div class="labelSection">Attachment</div><div class="inputSection"><input type="text" id="Attachment"
        data-bind="value: attachment"/></div>
        </div>


        <div class="sectionalForm">
        <div class="labelSection">Remarks</div><div class="inputSection"><input type="text" id="Remarks"
        data-bind="value: remarks"/></div>
        </div>


        <div class="sectionalForm">
        <div></div>
        </div>


        <div class="formRow">
        <div id="userCommand"></div>
        </div>


        </div>

        </form>