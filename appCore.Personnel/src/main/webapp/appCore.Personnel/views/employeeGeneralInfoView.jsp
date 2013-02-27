    <link href="../../css/themes/base/jquery.ui.all.css" media="screen" rel="stylesheet" type="text/css" />

        <link href="../../kendo/styles/kendo.custom.min.css" rel="stylesheet">
        <script language="javascript" src="../../js/viewmodal/employeeHelper.js"></script>
        <script language="javascript" src="../../js/viewmodal/employeeGeneralInfoViewModel.js"></script>

        <link href="../../css/employeeGeneralAddForm.css" media="screen" rel="stylesheet" type="text/css" />
        <link href="../../css/employeeGeneralForm.css" media="screen" rel="stylesheet" type="text/css" />
        <link href="../../css/employeeGeneralInfoView.css" media="screen" rel="stylesheet" type="text/css" />



        <script type="text/html" id="employeeGeneralInfoTemplate">


        <div class="formRowView">
        <div class="viewLabelSection">Employee Id</div><div class="inputSection" data-bind="text: code"> </div>
        </div>

        <div class="formRowView">
        <div class="viewLabelSection">Name</div><div class="inputSection" data-bind="text: name"></div>
        </div>


        <div class="sectionalFormView">
        <div class="leftSection">
        <div class="viewLabelSection">Salutation</div><div class="inputSection" data-bind="text:
        $root.getSalutationCode(salutation)"></div>
        </div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">First name</div><div class="inputSection" data-bind="text: firstName"></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Middle Name</div><div class="inputSection" data-bind="text: middleName"></div>
        </div>

        <div class="formRowView">
        <div class="viewLabelSection">Last Name </div><div class="inputSection" data-bind="text: lastName"></div>
        </div>


        <div class="formRowView">
        <span class="formRowRuler"></span>
        </div>

        <div class="sectionalFormView">
        <div class="leftSection">
        <div class="viewLabelSection">Gender</div><div class="inputSection" data-bind="text:
        $root.getGenderCode(gender)"></div>
        </div>
        </div>


        <div class="sectionalFormView">
        <div class="leftSection">
        <div class="viewLabelSection">Birth Date</div><div class="inputSection" data-bind="text: birthDate"></div>
        </div>

        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Age</div><div class="inputSection" data-bind="text: age"></div>
        </div>


        <div class="sectionalFormView">
        <div class="leftSection">
        <div class="viewLabelSection">Marital Status</div><div class="inputSection" data-bind="text:
        $root.getMaritalStatusCode(maritalStatus)"></div>
        </div>

        </div>

        <div class="formRowView">
        <div class="viewLabelSection">Marriage Date</div><div class="inputSection" data-bind="text: marriageDate"></div>
        </div>


        <div class="formRowView">
        <span class="formRowRuler"></span>
        </div>

        <div class="formRowView">
        <div class="viewLabelSection">Race</div><div class="inputSection" data-bind="text:
        $root.getRaceCode(race)"></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Religion</div><div class="inputSection" data-bind="text:
        $root.getReligionCode(religion)"></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Nationality</div><div class="inputSection" data-bind="text:
        $root.getNationalityCode(nationality)"></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Country Origin</div><div class="inputSection" data-bind="text:
        $root.getCountryCode(countryOrigin)"></div>
        </div>

        <div class="formRowSpacer">
        </div>

        <div class="formRow darken">
        <div class="labelSection"></div><div class="inputSection">

        <div class="maintenanceCommand">

        <button id="generalInfoEdit" type="button" data-bind="visible : $root.enableUpdate, click: $root.editForm"
        class="command">Edit</button>

        </div>
        </div>
        </div>


        </script>


        <script type="text/html" id="employeeGeneralInfoAddTemplate">


        <div id="employeeAddTabs">
        <ul>
        <li><a href="#employeeGeneralInfo">General</a></li>
        <li><a href="#employeeGeneralInfo2">Basic Info</a></li>
        <li><a href="#employeeGeneralInfo3">Details</a></li>
        </ul>


        <div id="employeeGeneralInfo">


        <div class="formRowView">
        <div class="viewLabelSection">Employee Id</div><div class="inputSection">
        <input type="text" id="Code" data-bind="value : code" class="validate[required, maxSize[10]]" />

        </div>
        </div>

        <div class="formRowView">
        <div class="viewLabelSection">Name</div><div class="inputSection"> <input
        type="text" id="Name" data-bind="value : name" class="validate[required, maxSize[10]]" /></div>
        </div>


        <div class="sectionalFormView">
        <div class="leftSection">
        <div class="viewLabelSection">Salutation</div><div class="inputSection">

        <select id="salutation" data-bind="options: $root.salutationList, optionsText: 'name', optionsValue: 'nid',
        value : salutation">
        </select>

        </div>
        </div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">First name</div><div class="inputSection"> <input type="text" id="FirstName"
        data-bind="value: firstName" /></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Middle Name</div><div class="inputSection"> <input type="text" id="middleName"
        data-bind="value: middleName" /></div>
        </div>

        <div class="formRowView">
        <div class="viewLabelSection">Last Name </div><div class="inputSection"> <input type="text" id="lastName"
        data-bind="value: lastName" /></div>
        </div>

        </div>

        <div id="employeeGeneralInfo2">


        <div class="sectionalFormView">
        <div class="leftSection">
        <div class="viewLabelSection">Gender</div><div class="inputSection">

        <select id="gender" data-bind="options: $root.genderList, optionsText: 'name', optionsValue: 'nid', value :
        gender">
        </select>

        </div>
        </div>
        </div>


        <div class="sectionalFormView">
        <div class="leftSection">
        <div class="viewLabelSection">Birth Date</div><div class="inputSection"> <input type="text" id="birthDate"
        data-bind="datepicker: birthDate,
        datepickerOptions: { dateFormat : 'dd-mm-yy'}, value: birthDate" /></div>
        </div>

        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Age</div><div class="inputSection"> <input type="text" id="age" data-bind="value:
        age" /></div>
        </div>


        <div class="sectionalFormView">
        <div class="leftSection">
        <div class="viewLabelSection">Marital Status</div><div class="inputSection">

        <select id="maritalStatus" data-bind="options: $root.maritalStatusList, optionsText: 'name', optionsValue:
        'nid', value : maritalStatus">
        </select>

        </div>
        </div>

        </div>

        <div class="formRowView">
        <div class="viewLabelSection">Marriage Date</div><div class="inputSection"> <input type="text" id="MarriageDate"
        data-bind="datepicker: marriageDate, datepickerOptions: { dateFormat : 'dd-mm-yy'}, value : marriageDate"
        /></div>
        </div>

        </div>


        <div id="employeeGeneralInfo3">


        <div class="formRowView">
        <div class="viewLabelSection">Race</div><div class="inputSection">

        <select id="race" data-bind="options: $root.raceList, optionsText: 'name', optionsValue: 'nid', value: race">
        </select>
        </div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Religion</div><div class="inputSection">

        <select id="religion" data-bind="options: $root.religionList, optionsText: 'name', optionsValue: 'nid', value:
        religion">
        </select>

        </div>
        </div>


        <div class="formRowView">

        <div class="viewLabelSection">Nationality</div><div class="inputSection">

        <select id="nationality" data-bind="options: $root.nationalityList, optionsText: 'name', optionsValue: 'nid',
        value: nationality">
        </select>

        </div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Country Origin</div><div class="inputSection">

        <select id="country" data-bind="options: $root.countryList, optionsText: 'name', optionsValue: 'nid', value:
        countryOrigin">
        </select>

        </div>
        </div>

        <div class="formRowSpacer">
        </div>


        </div>

        <div>

        <div class="formRow">
        <div class="labelSection"></div>

        <div class="inputSectionCommand">

        <div id="maintenanceCodeCommand" class="maintenanceCommand">
        <button id="generalInfoSave" type="button" data-bind="visible : $root.enableAdd, click: $root.saveDataForm"
        class="command"><i class="icon-ok saveCommandIcon"></i>Save</button>

        <button id="generalInfoCancel" type="button" data-bind="visible : $root.enableAdd, click: $root.cancelEdit"
        class="command"><i class="icon-cancel saveCommandIcon"></i>Cancel</button>
        </div>
        </div>
        </div>

        </div>

        </div>


        </script>


        <script type="text/javascript">

        var vm;

        $(document).ajaxStop(function()
        {
            try
            {
                $(this).unbind("ajaxStop");
                ko.applyBindings(vm, document.getElementById("companyGeneralInfo"));
                var tab = $("#employeeAddTabs").tabs();

                $("#employeeGeneralForm").validationEngine();
            }
            catch (ex)
            {
                console.log(ex)
            }
        });

        $(document).ready(function()
        {
            var input = { "id" : coreEmployeeGeneralViewPage, "roleId" : globalViewModel.employeeRole() };
            var coreCommand = new CoreCommand();
            var result = coreCommand.getPermission(hostAuthorizationUrl, input);
            vm = new EmployeeGeneralInfoViewModel(globalViewModel.editMode(), result.permission, globalViewModel.targetId());

        });

        </script>

        <form id="employeeGeneralForm">
        <div id="companyGeneralInfo" class="formEntry" data-bind="template : { name : templateToUse,
        foreach : bindingSource }">
        </div>
        </form>
