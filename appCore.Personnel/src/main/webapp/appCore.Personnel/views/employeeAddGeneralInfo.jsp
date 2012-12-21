
    <link href="../../css/themes/base/jquery.ui.all.css" media="screen" rel="stylesheet" type="text/css" />



        <script type="text/html" id="employeeGeneralInfoAddTemplate">

        <h4>General Information</h4>

        <div class="formRowView">
        <div class="viewLabelSection">Employee Id</div><div class="inputSection"> </div>
        </div>

        <div class="formRowView">
        <div class="viewLabelSection">Name</div><div class="inputSection"> <input
        type="text" id="Name"  data-bind="value : name" /></div>
        </div>


        <div class="sectionalFormView">
        <div class="leftSection">
        <div class="viewLabelSection">Salutation</div><div class="inputSection">

        <select id="salutation" data-bind="options: $root.salutationList, optionsText: 'name', optionsValue: 'nid', value : salutation">
        </select>

        </div>
        </div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">First name</div><div class="inputSection"> <input type="text" id="FirstName" data-bind="value: firstName" /></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Middle Name</div><div class="inputSection"> <input type="text" id="middleName" data-bind="value: middleName" /></div>
        </div>

        <div class="formRowView">
        <div class="viewLabelSection">Last Name </div><div class="inputSection"> <input type="text" id="lastName" data-bind="value: lastName" /></div>
        </div>


        <div class="formRowView">
        <span class="formRowRuler"></span>
        </div>

        <div class="sectionalFormView">
        <div class="leftSection">
        <div class="viewLabelSection">Gender</div><div class="inputSection">

        <select id="gender" data-bind="options: $root.genderList, optionsText: 'name', optionsValue: 'nid', value : gender">
        </select>

        </div>
        </div>
        </div>


        <div class="sectionalFormView">
        <div class="leftSection">
        <div class="viewLabelSection">Birth Date</div><div class="inputSection"> <input type="text" id="birthDate" data-bind="value: birthDate" /></div>
        </div>

        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Age</div><div class="inputSection"> <input type="text" id="age" data-bind="value: age" /></div>
        </div>


        <div class="sectionalFormView">
        <div class="leftSection">
        <div class="viewLabelSection">Marital Status</div><div class="inputSection">

        <select id="maritalStatus" data-bind="options: $root.maritalStatusList, optionsText: 'name', optionsValue: 'nid', value: maritalStatus">
        </select>

        </div>
        </div>

        </div>

        <div class="formRowView">
        <div class="viewLabelSection">Marriage Date</div><div class="inputSection" data-bind="value: marriageDate"></div>
        </div>


        <div class="formRowView">
        <span class="formRowRuler"></span>
        </div>

        <div class="formRowView">
        <div class="viewLabelSection">Race</div><div class="inputSection">

        <select id="race" data-bind="options: $root.raceList, optionsText: 'name', optionsValue: 'nid', value: race">
        </select>
        </div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Religion</div><div class="inputSection">

        <select id="religion" data-bind="options: $root.religionList, optionsText: 'name', optionsValue: 'nid', value: religion">
        </select>

        </div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Nationality</div><div class="inputSection">

        <select id="nationality" data-bind="options: $root.nationalityList, optionsText: 'name', optionsValue: 'nid', value: nationality">
        </select>

        </div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Country Origin</div><div class="inputSection">

        <select id="country" data-bind="options: $root.countryList, optionsText: 'name', optionsValue: 'nid', value: country, value : country">
        </select>

        </div>
        </div>

        </script>



        <form id="generalInfoForm">
            <div id="companyGeneralInfo" class="formEntry" data-bind="template : { name : templateToUse">
        </div>


        </form>