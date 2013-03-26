       <link href="../../css/employeeGeneralForm.css" media="screen" rel="stylesheet" type="text/css" />
        <script language="javascript" src="../../js/viewmodal/jobSetupQualificationViewViewModel.js"></script>
        <script language="javascript" src="../../js/viewmodal/employeeHelper.js"></script>

        <script type="text/html" id="jobSetupQualificationViewTemplate">

        <div class="formRowView">
        <div class="viewLabelSection">Level</div><div class="inputSection" data-bind="text: $root.getLevelCode(level)"></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Level Description</div><div class="inputSection" data-bind="text: levelDescription"></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Field of Study</div><div class="inputSection" data-bind="text: $root.getFieldOfStudyCode(fieldOfStudy)"></div>
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









        <script type="text/html" id="jobSetupQualificationViewAddTemplate">

        <div class="formRowView">
        <div class="viewLabelSection">Level</div><div class="inputSection">

        <select id="Industry" data-bind="options: $root.levelList, optionsText: 'name', optionsValue: 'nid', value : level">
        </select>

        </div>
        </div>



        <div class="formRowView">
        <div class="viewLabelSection">Level Description</div><div class="inputSection"> <input type='text' id='levelDescription'  data-bind="value : levelDescription" /></div>
        </div>


            <div class="formRowView">
            <div class="viewLabelSection">Field Of Study</div><div class="inputSection">

            <select id="FieldOfStudy" data-bind="options: $root.fieldOfStudyList, optionsText: 'name', optionsValue: 'nid', value : fieldOfStudy">
            </select>

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
            var request = ajaxCore.sendRequest(globalJobSetupQualificationListByJobSetupUrl, targetEntity, "get");

            request.success(function(dataSource)
            {
                var input = { "id" : coreEmployeeExpertiseViewPage, "roleId" : globalViewModel.employeeRole() };
                var coreCommand = new CoreCommand();
                var result = coreCommand.getPermission(hostAuthorizationUrl, input);

                try
                {
                    var vm = new JobSetupQualificationViewViewModel(dataSource, 0, result.permission, globalViewModel);
                    ko.applyBindings(vm, document.getElementById("jobSetupQualificationDataContent"));
                }
                catch (ex)
                {
                console.log(ex)
                }

        });

        });

        </script>

        <div id="jobSetupQualificationDataContent">

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





