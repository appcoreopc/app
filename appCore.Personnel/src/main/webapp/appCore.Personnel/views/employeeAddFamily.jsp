        <link href="../../css/themes/base/jquery.ui.all.css" media="screen" rel="stylesheet" type="text/css" />
        <link href="../../css/employeeGeneralAddForm.css" media="screen" rel="stylesheet" type="text/css" />

        <script language="javascript" src="../../js/viewmodal/employeeHelper.js"></script>
        <script language="javascript" src="../../js/viewmodal/employeeFamilyViewModel.js"></script>

        <script type="text/javascript">

        var vm;
        var formName = "familyAddDetailInfo";

        $(document).ready(function()
        {
            $("#FamilyForm").validationEngine();

            vm = new EmployeeFamilyViewModel(0, globalViewModel);

            var gridDataObject = vm.getView();
            var input = vm.getRole();

            var coreCommand = new CoreCommand();
            coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);
            $("#" + formName).setupViewBinding(vm, globalViewModel);
        });

        </script>

        <form id="FamilyForm">


        <div id="familyAddDetailInfo">

        <div class="sectionalForm">
        <div class="leftSection">
        <div class="labelSection">Member Name</div><div class="inputSection"><input type="text" id="MemberName"
        data-bind="value: memberName" class="validate[required], maxSize[30]" data-prompt-position="bottomRight"/></div>
        </div>

        <div class="rightSection">
        <div class="rightLabelSection">Member Type</div><div class="inlineLabelSection"><select
        id="MemberType" data-bind="options: memberTypeList, optionsText: 'name', optionsValue: 'nid', value: memberType" class="validate[required]"></select></div>
        </div>
        </div>


        <div class="sectionalForm">
        <div class="leftSection">
        <div class="labelSection">Birth Date</div><div class="inputSection"><input type="text" id="BirthDate"
        data-bind="datepicker: birthDate, datepickerOptions : { dateFormat : 'dd-mm-yy'}"/></div>
        </div>

        <div class="rightSection">
        <div class="rightLabelSection">Age</div><div class="inlineLabelSection"><input type="text" id="Age"
        data-bind="value: age" class="validate[required], custom[integer]"/></div>
        </div>
        </div>


        <div class="sectionalForm">
        <div class="leftSection">
        <div class="labelSection">Salutation</div><div class="inputSection">

        <select id="Salutation" data-bind="options: salutationList, optionsText: 'name', optionsValue: 'nid', value:
        salutation" name="Salutation">
        </select>

        </div>
        </div>

        <div class="rightSection">
        <div class="rightLabelSection">Gender</div><div class="inlineLabelSection">

        <select id="Gender" data-bind="options: genderList, optionsText: 'name', optionsValue: 'nid', value: gender"
        name="Gender">
        </select>

        </div>
        </div>
        </div>


        <div class="sectionalForm">
        <div class="labelSection">Marital status</div><div class="inputSection">

        <select id="MaritalStatus" data-bind="options: maritalStatusList, optionsText: 'name', optionsValue: 'nid',
        value: maritalStatus" name="MaritalStatus">
        </select>


        </div>
        </div>

        <div class="sectionalForm">
        <div class="labelSection">I/C No</div><div class="inputSection"><input type="text" id="IdentificationNo"
        data-bind="value: identificationNo" class="validate[required], maxSize[20]"/></div>
        </div>
`

        <div class="sectionalForm">
        <div class="labelSection">Working</div><div class="inputSection"><input type="checkbox" data-bind="checked:
        working" /></div>
        </div>

        <div class="sectionalForm">
        <div class="labelSection">Studying</div><div class="inputSection"><input type="checkbox" data-bind="checked:
        studying" /></div>
        </div>

        <div class="sectionalForm">
        <div class="labelSection">Handicap</div><div class="inputSection"><input type="checkbox" data-bind="checked:
        handicap" /></div>
        </div>


        <div class="sectionalForm">
        <div class="labelSection">Nominated Spouse</div><div class="inputSection"><input type="checkbox"
        data-bind="checked: nominatedSpouse" /></div>
        </div>

        <div class="sectionalForm">
        <div class="labelSection">Attachments</div><div class="inputSection"><input type="text" id="Attachments"
        data-bind="value: attachments"/></div>
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