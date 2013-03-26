    <link href="../../css/themes/base/jquery.ui.all.css" media="screen" rel="stylesheet" type="text/css" />
        <link href="../../kendo/styles/kendo.custom.min.css" rel="stylesheet">
        <link href="../../css/employeeGeneralForm.css" media="screen" rel="stylesheet" type="text/css" />

        <script language="javascript" src="../../js/viewmodal/employeeFamilyViewViewModel.js"></script>
        <script language="javascript" src="../../js/viewmodal/employeeHelper.js"></script>


        <script type="text/html" id="employeeFamilyTemplate">


        <div class="formRowView">
        <div class="viewLabelSection">Member Name</div><div class="inputSection" data-bind="text: memberName"></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Member Type</div><div class="inputSection" data-bind="text:
        $root.getMemberTypeCode(memberType())"></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Birth Date</div><div class="inputSection" data-bind="text: birthDate"></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Age</div><div class="inputSection" data-bind="text: age"></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Salutation</div><div class="inputSection" data-bind="text:
        $root.getSalutationCode(salutation())"></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Gender</div><div class="inputSection" data-bind="text:
        $root.getGenderCode(gender())"></div>
        </div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Marital status</div><div class="inputSection" data-bind="text:
        $root.getMaritalStatusCode(maritalStatus())"></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">I/C No</div><div class="inputSection" data-bind="text: identificationNo"></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Working</div><div class="inputSection" data-bind="text: working"></div>
        </div>

        <div class="formRowView">
        <div class="viewLabelSection">Studying</div><div class="inputSection" data-bind="text: studying"></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Handicap</div><div class="inputSection" data-bind="text: handicap"></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Nominated Spouse</div><div class="inputSection" data-bind="text:
        nominatedSpouse"></div>
        </div>

        <div class="formRowView">
        <div class="viewLabelSection">Attachments</div><div class="inputSection" data-bind="text: attachments"></div>
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





        <script type="text/html" id="employeeFamilyAddTemplate">


        <div class="formRowView">
        <div class="viewLabelSection">Member Name</div><div class="inputSection"> <input type='text' id="MemberName" data-bind="value : memberName" /></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Member Type</div><div class="inputSection">

        <select id="MemberType" data-bind="options: $root.familyMemberTypeList, optionsText: 'name', optionsValue: 'nid', value : memberType">
        </select>

        </div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Birth Date</div><div class="inputSection"> <input type='text' id="BirthDate" data-bind="datepicker: birthDate, datepickerOptions: { dateFormat :
        'dd-mm-yy'}, value : birthDate" /></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Age</div><div class="inputSection"> <input type='text' id='Age' data-bind="value : age" /></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Salutation</div><div class="inputSection">

        <select id="Salutation" data-bind="options: $root.salutationList, optionsText: 'name', optionsValue: 'nid', value : salutation">
        </select>


        </div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Gender</div><div class="inputSection">

        <select id="Gender" data-bind="options: $root.genderList, optionsText: 'name', optionsValue: 'nid', value : gender">
        </select>

        </div>
        </div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Marital status</div><div class="inputSection">


        <select id="MaritalStatus" data-bind="options: $root.maritalStatusList, optionsText: 'name', optionsValue: 'nid', value : maritalStatus">
        </select>


        </div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">I/C No</div><div class="inputSection"> <input type='text' id="IdentificationNo" data-bind="value : identificationNo" /></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Working</div><div class="inputSection"> <input type='checkbox' id="Working" data-bind="checked : working" /></div>
        </div>

        <div class="formRowView">
        <div class="viewLabelSection">Studying</div><div class="inputSection"> <input type='checkbox' id="Studying" data-bind="checked : studying" /></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Handicap</div><div class="inputSection"> <input type='checkbox' id="HandiCap" data-bind="checked: handicap" /></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Nominated Spouse</div><div class="inputSection"> <input type='checkbox' id="NominatedSpouse" data-bind="checked : nominatedSpouse" /></div>
        </div>

        <div class="formRowView">
        <div class="viewLabelSection">Attachments</div><div class="inputSection">
        <input type='text' id='Attachments' data-bind="value : attachments" /></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Remarks</div><div class="inputSection"> <input type='text' id='Remarks' data-bind="value: remarks" />
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


        </script>


        <script type="text/javascript">

        $(document).ready(function()
        {
            var ajaxCore = new AjaxCore();
            var employeeId = { id : globalViewModel.targetId()};
            var request = ajaxCore.sendRequest(globalEmployeeFamilyGetByEmployeeUrl, employeeId, "get");

            request.success(function(dataSource)
            {
                var input = { "id" : coreEmployeeFamilyViewPage, "roleId" : globalViewModel.employeeRole() };
                var coreCommand = new CoreCommand();
                var result = coreCommand.getPermission(hostAuthorizationUrl, input);

                var vm = new EmployeeFamilyViewViewModel(dataSource, 0, result.permission, globalCurrentEmployee);
                $("#familyDataContent").setupViewBinding(vm, globalViewModel);
            });

        });

        </script>

        <div id="familyDataContent">

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
