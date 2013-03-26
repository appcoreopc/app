        <link href="../../css/employeeGeneralForm.css" media="screen" rel="stylesheet" type="text/css" />

        <script language="javascript" src="../../js/viewmodal/jobSetupExperienceViewViewModel.js"></script>
        <script language="javascript" src="../../js/viewmodal/employeeHelper.js"></script>

        <script type="text/html" id="jobSetupExperienceViewTemplate">

        <div class="formRowView">
        <div class="viewLabelSection">Expertise</div><div class="inputSection" data-bind="text: $root.getExpertiseCode(expertise)"></div>
        </div>


        <div class="formRowView">
            <div class="viewLabelSection">Years Of Experience</div><div class="inputSection" data-bind="text: experienceYears"></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Expertise Description</div><div class="inputSection" data-bind="text: expertiseDescription"></div>
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




        <script type="text/html" id="jobSetupExperienceViewAddTemplate">

        <div class="formRowView">
        <div class="viewLabelSection">Expertise</div><div class="inputSection">

        <select id="Industry" data-bind="options: $root.expertiseList, optionsText: 'name', optionsValue: 'nid', value : expertise">
        </select>

        </div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Years Of Experience</div><div class="inputSection"> <input type='text' id='YearExperience' data-bind="value : experienceYears" /></div>
        </div>


        <div class="formRowView">
            <div class="viewLabelSection">Expertise Description</div><div class="inputSection">
            <input type='text' id='description' data-bind="value : expertiseDescription"/>
            </div>
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

            var targetEntity = { id : globalViewModel.targetId() };
            var request = ajaxCore.sendRequest(globalJobSetupExperienceListByJobSetupUrl, targetEntity, "get");

            request.success(function(dataSource)
            {
                var input = { "id" : coreEmployeeExpertiseViewPage, "roleId" : globalViewModel.employeeRole() };
                var coreCommand = new CoreCommand();
                var result = coreCommand.getPermission(hostAuthorizationUrl, input);

                var vm = new JobSetupExperienceViewViewModel(dataSource, 0, result.permission, globalViewModel);
                $("#jobSetupExperienceDataContent").setupViewBinding(vm, globalViewModel);

        });

        });

        </script>

        <div id="jobSetupExperienceDataContent">

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




