        <link href="../../css/themes/base/jquery.ui.all.css" media="screen" rel="stylesheet" type="text/css" />
        <link href="../../kendo/styles/kendo.custom.min.css" rel="stylesheet">
        <link href="../../css/employeeGeneralForm.css" media="screen" rel="stylesheet" type="text/css" />

        <script language="javascript" src="../../js/viewmodal/employeeQualificationViewViewModel.js"></script>
        <script language="javascript" src="../../js/viewmodal/employeeHelper.js"></script>



        <script type="text/html" id="employeeQualificationTemplate">

        <div class="formRowView">
        <div class="viewLabelSection">Level</div><div class="inputSection" data-bind="text: level"></div>
        </div>

        <div class="formRowView">
        <div class="viewLabelSection">Field</div><div class="inputSection" data-bind="text: fieldOfStudyDescription"></div>
        </div>

        <div class="formRowView">
        <div class="viewLabelSection">Major</div><div class="inputSection" data-bind="text: major"></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Institution</div><div class="inputSection" data-bind="text: institution"></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Local / Oversea </div><div class="inputSection" data-bind="text: localOrOversea"></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Start Date</div><div class="inputSection" data-bind="text: startDate"></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">End Date</div><div class="inputSection" data-bind="text: endDate"></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Result(CGPA/Grade)</div><div class="inputSection" data-bind="text: resultCGPA"></div>
        </div>

        <div class="formRowView">
        <div class="viewLabelSection">Attachment</div><div class="inputSection"></div>
        </div>

        <div class="formRowView">
        <div class="viewLabelSection">Remark</div><div class="inputSection" data-bind="text: remarks"></div>
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
        <span class="formRowRuler"></span>
        </div>

        </script>


        <script type="text/html" id="employeeQualificationAddTemplate">

        <div class="formRowView">
        <div class="viewLabelSection">Level</div><div class="inputSection"> <input type="text" data-bind="value: level" /></div>
        </div>

        <div class="formRowView">
        <div class="viewLabelSection">Field</div><div class="inputSection"> <input type="text"  data-bind="text: fieldOfStudyDescription" /></div>
        </div>

        <div class="formRowView">
        <div class="viewLabelSection">Major</div><div class="inputSection"> <input type="text" data-bind="text: major" /></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Institution</div><div class="inputSection"> <input type="text"  data-bind="text: institution" /></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Local / Oversea </div><div class="inputSection"> <input type="text"  data-bind="text: localOrOversea" /></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Start Date</div><div class="inputSection"> <input type="text"  data-bind="text: startDate" /></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">End Date</div><div class="inputSection"> <input type="text"  data-bind="text: endDate"></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Result(CGPA/Grade)</div><div class="inputSection"> <input type="text"  data-bind="text: resultCGPA"></div>
        </div>

        <div class="formRowView">
        <div class="viewLabelSection">Attachment</div><div class="inputSection"></div>
        </div>

        <div class="formRowView">
        <div class="viewLabelSection">Remark</div><div class="inputSection"> <input type="text"  data-bind="text: remarks" /></div>
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

        <div class="formRowSpacer">
        </div>


        <div class="formRowView">
        <span class="formRowRuler"></span>
        </div>

        </script>

        <script type="text/javascript">

        $(document).ready(function()
        {
            if (globalViewModel.targetId != null && globalViewModel.applicationScopeType() == coreApplicationTypeEmployee)
            {
                var ajaxCore = new AjaxCore();
                var employeeId = { id : globalViewModel.targetId()  };
                var request = ajaxCore.sendRequest(globalEmployeeQualificationGetByEmployeeUrl, employeeId, "get");

                request.success(function(dataSource)
                {
                    var input = { "id" : coreEmployeeContactViewPage, "roleId" : globalViewModel.employeeRole() };
                    var coreCommand = new CoreCommand();
                    var result = coreCommand.getPermission(hostAuthorizationUrl, input);

                    var vm = new EmployeeQualificationViewViewModel(dataSource, 0, result.permission, globalCurrentEmployee);
                    ko.applyBindings(vm, document.getElementById("qualificationDataContent"));
                });
            }
        });

        </script>

        <div id="qualificationDataContent">

        <div data-bind="visible : bindingSource().length == 0" class="emptyData">
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