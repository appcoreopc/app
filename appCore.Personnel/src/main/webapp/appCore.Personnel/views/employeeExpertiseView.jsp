    <link href="../../css/themes/base/jquery.ui.all.css" media="screen" rel="stylesheet" type="text/css" />
        <link href="../../kendo/styles/kendo.custom.min.css" rel="stylesheet">
        <link href="../../css/employeeGeneralForm.css" media="screen" rel="stylesheet" type="text/css" />

        <script language="javascript" src="../../js/viewmodal/employeeExpertiseViewViewModel.js"></script>
        <script language="javascript" src="../../js/viewmodal/employeeHelper.js"></script>

        <script type="text/html" id="employeeExpertiseTemplate">

        <div class="formRowView">
        <div class="viewLabelSection">Industry</div><div class="inputSection" data-bind="text: $root.getIndustryCode(industry())"></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Specialty</div><div class="inputSection" data-bind="text: $root.getSpecialtyCode(specialty())"></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Start Date</div><div class="inputSection" data-bind="text: startDate"></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">End Date</div><div class="inputSection" data-bind="text: endDate"></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Period</div><div class="inputSection" data-bind="text: period"></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Remarks</div><div class="inputSection" data-bind="text: remarks"></div>
        </div>

        <div class="formRowSpacer">
        </div>


        <div class="formRow darken" data-bind="visible : $root.getPermission">
        <div class="labelSection"></div><div class="inputSection">

        <div id="contactInfoEditCommand" class="maintenanceCommand">

        <button id="contactEdit" type="button" data-bind="visible : $root.enableAdd, click: $root.editData"
        class="command"><i class="icon-edit editCommandIcon"></i>Edit</button>


        </div>
        </div>
        </div>

        <div class="formRowView">
        <span class="formRowRuler" data-bind="visible : $index() < $root.totalRecordCount()"></span>
        </div>



        </script>










        <script type="text/html" id="employeeExpertiseAddTemplate">

        <div class="formRowView">
        <div class="viewLabelSection">Industry</div><div class="inputSection">

        <select id="Industry" data-bind="options: $root.industryList, optionsText: 'name', optionsValue: 'nid', value : industry">
        </select>

        </div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Specialty</div><div class="inputSection">

        <select id="Specialty" data-bind="options: $root.specialtyList, optionsText: 'name', optionsValue: 'nid', value : specialty">
        </select>

        </div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Start Date</div><div class="inputSection"> <input type='text' id='StartDate'  data-bind="datepicker: startDate, datepickerOptions: { dateFormat :
        'dd-mm-yy'}, value : startDate" /></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">End Date</div><div class="inputSection"> <input type='text' id='EndDate'  data-bind="datepicker: endDate, datepickerOptions: { dateFormat :
        'dd-mm-yy'}, value : endDate" /></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Period</div><div class="inputSection"> <input type='text' id='Period' data-bind="value : period"/></div>
        </div>

        <div class="formRowView">
        <div class="viewLabelSection">Remarks</div><div class="inputSection"> <input type='text' id='Remarks' data-bind="value : remarks" /></div>
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
        var request = ajaxCore.sendRequest(globalEmployeeExpertiseGetByEmployeeUrl, employeeId, "get");

        request.success(function(dataSource)
        {
            var input = { "id" : coreEmployeeExpertiseViewPage, "roleId" : globalViewModel.employeeRole() };
            var coreCommand = new CoreCommand();
            var result = coreCommand.getPermission(hostAuthorizationUrl, input);

            try
            {
                var vm = new EmployeeExpertiseViewViewModel(dataSource, 0, result.permission, globalCurrentEmployee);
                ko.applyBindings(vm, document.getElementById("expertiseDataContent"));
            }
            catch (ex)
            {
                console.log(ex)
            }

        });

        });

        </script>

        <div id="expertiseDataContent">

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





