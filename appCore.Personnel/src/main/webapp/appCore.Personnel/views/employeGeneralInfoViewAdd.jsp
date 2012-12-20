    <link href="../../css/themes/base/jquery.ui.all.css" media="screen" rel="stylesheet" type="text/css" />

        <link href="../../kendo/styles/kendo.custom.min.css" rel="stylesheet">

        <script language="javascript" src="../../js/viewmodal/employeeHelper.js"></script>
        <script language="javascript" src="../../js/viewmodal/employeeGeneralInfoViewModel.js"></script>


        <script type="text/html" id="employeeGeneralInfoTemplate">

        <h4>General Information</h4>

        <div class="formRowView">
        <div class="viewLabelSection">Employee Id</div><div class="inputSection"> </div>
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

        </script>


        <script type="text/javascript">


        $(document).ready(function()
        {

        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequest(globalEmployeeGeneralInfoListUrl, null, "get");

        request.success(function(dataSource)
        {
            var vm = new EmployeeGeneralInfoViewModel(dataSource);
            ko.applyBindings(vm, document.getElementById("companyGeneralInfo"));

        });

        });

        </script>

        <div id="companyGeneralInfo" class="formEntry" data-bind="template : { name : 'employeeGeneralInfoTemplate',
        foreach : bindingSource }">
        </div>
