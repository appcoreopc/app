    <link href="../../css/themes/base/jquery.ui.all.css" media="screen" rel="stylesheet" type="text/css" />
    <link href="../../css/employeeGeneralForm.css" media="screen" rel="stylesheet" type="text/css" />

        <script language="javascript" src="../../js/viewmodal/employeeMembershipViewViewModel.js"></script>
        <script language="javascript" src="../../js/viewmodal/employeeHelper.js"></script>

        <link href="../../kendo/styles/kendo.custom.min.css" rel="stylesheet">

        <script type="text/html" id="employeeMembershipTemplate">

        <div class="formRowView">
        <div class="viewLabelSection">Association</div><div class="inputSection" data-bind="text: association"></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Member Type</div><div class="inputSection" data-bind="text: $root.getMemberTypeCode(memberType())"></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Contact Details</div><div class="inputSection" data-bind="text:
        contactDetails"></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Start Date</div><div class="inputSection" data-bind="text: startDate"></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">End Date</div><div class="inputSection" data-bind="text: endDate"></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Membership period (in months)</div><div
        class="inputSection" data-bind="text: membershipPeriod"></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Enrollment Fees</div><div class="inputSection" data-bind="text:
        enrollmentFees"></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Membership Fees</div><div class="inputSection" data-bind="text:
        membershipFees"></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Attachment</div><div class="inputSection" data-bind="text: attachments"></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Remarks</div><div class="inputSection" data-bind="text: remarks"></div>
        </div>

        <div class="formRowSpacer">
        </div>


        <div class="formRow darken" data-bind="visible : $root.getPermission">
        <div class="labelSection"></div><div class="inputSection">

        <div id="familyInfoEditCommand" class="maintenanceCommand">

        <button id="familyEdit" type="button" data-bind="visible : $root.enableAdd, click: $root.editData"
        class="command"><i class="icon-edit editCommandIcon"></i>Edit</button>


        </div>
        </div>
        </div>

        <div class="formRowView">
        <span class="formRowRuler" data-bind="visible : $index() < $root.totalRecordCount()"></span>
        </div>

        </script>



        <script type="text/html" id="employeeMembershipAddTemplate">

        <div class="formRowView">
        <div class="viewLabelSection">Association</div><div class="inputSection"> <input type="text" id="Association" data-bind="value : association" /></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Member Type</div><div class="inputSection">

        <select id="MemberType" data-bind="options: $root.associationList, optionsText: 'name', optionsValue: 'nid', value : memberType">
        </select>

        </div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Contact Details</div><div class="inputSection"> <input type="text" id="ContactDetails" data-bind="value :
        contactDetails" /></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Start Date</div><div class="inputSection"> <input type="text" id="startDate"  data-bind="datepicker: startDate, datepickerOptions: { dateFormat :
        'dd-mm-yy'}, value: startDate" /></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">End Date</div><div class="inputSection"> <input type="text" id="endDate"   data-bind="datepicker: endDate, datepickerOptions: { dateFormat :
        'dd-mm-yy'},value : endDate" /></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Membership period (in months)</div><div
        class="inputSection"> <input type="text" id="MembershipPeriod" data-bind="value : membershipPeriod" /></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Enrollment Fees</div><div class="inputSection"> <input type="text" id="EnrollmentFees"   data-bind="value :
        enrollmentFees" /></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Membership Fees</div><div class="inputSection"> <input type="text" id="MembershipFees"  data-bind="value :
        membershipFees" /></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Attachment</div><div class="inputSection"> <input type="text" id="Attachments"  data-bind="value : attachments" /></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Remarks</div><div class="inputSection"> <input type="text" id="Remarks"  data-bind="value : remarks" /></div>
        </div>

        <div class="formRowSpacer">
        </div>


        <div class="formRow darken">
        <div class="labelSection"></div><div class="inputSection">

        <div id="employeeAddContactCommand" class="maintenanceCommand">
        <button id="contactInfoSave" type="button" data-bind="visible : $root.enableAdd, click: $root.saveDataForm"
        class="command"><i class="icon-ok saveCommandIcon"></i>Save</button>

        <button id="contactCancel" type="button" data-bind="visible : $root.enableAdd, click: $root.cancelEdit"
        class="command"><i class="icon-cancel saveCommandIcon"></i>Cancel</button>
        </div>
        </div>
        </div>

        <div class="formRowView">
        <span class="formRowRuler"></span>
        </div>

        </script>



        <script type="text/javascript">

        $(document).ready(function()
        {
            var ajaxCore = new AjaxCore();
            var employeeId = { id : globalViewModel.targetId() };
            var request = ajaxCore.sendRequest(globalEmployeeEmployeeMembershipGetByEmployeeUrl, employeeId, "get");

            request.success(function(dataSource)
            {
                var input = { "id" : coreEmployeeFamilyViewPage, "roleId" : globalViewModel.employeeRole() };
                var coreCommand = new CoreCommand();
                var result = coreCommand.getPermission(hostAuthorizationUrl, input);

                var vm = new EmployeeMembershipViewViewModel(dataSource, 0, result.permission, globalCurrentEmployee);
                $("#membershipDataContent").setupViewBinding(vm, globalViewModel);

            });
        });

        </script>

        <div id="membershipDataContent">
            <div data-bind="visible : $root.bindingSource().length == 0" class="emptyData">
                <div>
                    <ul>
                        <li class='emptyDataSpacer'> </li>
                        <li> No data available.</li>
                    </ul>
                </div>
            </div>

        <div data-bind="template : {name : templateToUse, foreach : bindingSource}">
        </div>

        </div>