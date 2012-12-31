        <link href="../../css/themes/base/jquery.ui.all.css" media="screen" rel="stylesheet" type="text/css" />
        <link href="../../kendo/styles/kendo.custom.min.css" rel="stylesheet">


        <script language="javascript" src="../../js/viewmodal/employeeResidenceViewViewModel.js"></script>
        <script language="javascript" src="../../js/viewmodal/employeeHelper.js"></script>

        <script type="text/html" id="employeeResidenceTemplate">

        <div class="formRowView">
        <div class="viewLabelSection">Permanent Add.</div><div class="inputSection" data-bind="text:
        permanentAddress1"></div>
        </div>

        <div class="formRowView">
        <div class="viewLabelSection"></div><div class="inputSection" data-bind="text: permanentAddress1"></div>
        </div>

        <div class="formRowView">
        <div class="viewLabelSection"></div><div class="inputSection" data-bind="text: permanentAddress3"></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">City</div><div class="inputSection" data-bind="text: city">
        </div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Country</div><div class="inputSection" data-bind="text:
        $root.getCountryCode(country)"></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Postcode</div><div class="inputSection" data-bind="text: postCode"></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Tel No</div><div class="inputSection" data-bind="text: telNo"></div>
        </div>

        <div class="formRowView">
        <div class="viewLabelSection">Emergency Contact 1</div><div class="inputSection" data-bind="text:
        emergencyContact1"></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Emergency Contact 2</div><div class="inputSection" data-bind="text:
        emergencyContact2"></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Contact No 1</div><div class="inputSection" data-bind="text: contact1"></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Contact No 2</div><div class="inputSection" data-bind="text: contact2"></div>
        </div>


        <div class="formRowSpacer">
        </div>


            <div class="formRow darken" data-bind="visible : $root.getPermission">
        <div class="labelSection"></div><div class="inputSection">

        <div id="residenceInfoEditCommand" class="maintenanceCommand">

        <button id="residenceEdit" type="button" data-bind="visible : $root.enableAdd, click: $root.editData"
        class="command">Edit</button>


        </div>
        </div>
        </div>

        <div class="formRowView">
        <span class="formRowRuler"></span>
        </div>

        </script>


        <script type="text/html" id="employeeResidenceAddTemplate">

        <div class="formRowView">
        <div class="viewLabelSection">Permanent Add.</div><div class="inputSection"> <input type="text" data-bind="value
        :
        permanentAddress1" id="PermanentAddress1" /></div>
        </div>

        <div class="formRowView">
        <div class="viewLabelSection"></div><div class="inputSection"> <input type='text' id='permanentAddress2'
        data-bind="value : permanentAddress2"></div>
        </div>

        <div class="formRowView">
        <div class="viewLabelSection"></div><div class="inputSection"> <input type='text' id='permanentAddress3'
        data-bind="value : permanentAddress3" /></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">City</div><div class="inputSection"><input type='text' id='City' data-bind="value
        : city" />
        </div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Country</div><div class="inputSection">

        <select id="country" data-bind="options: $root.countryList, optionsText: 'name', optionsValue: 'nid', value :
        country">
        </select>

        </div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Postcode</div><div class="inputSection"> <input type='text' id="PostCode"
        data-bind="value : postCode"></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Tel No</div><div class="inputSection"> <input type="text" id="TelNo"
        data-bind="value : telNo"></div>
        </div>

        <div class="formRowView">
        <div class="viewLabelSection">Emergency Contact 1</div><div class="inputSection"> <input type='text'
        id="EmergencyContact1"
        data-bind="value : emergencyContact1" />
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Emergency Contact 2</div><div class="inputSection"> <input type='text'
        id='EmergencyContact2' data-bind="value : emergencyContact2" /></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Contact No 1</div><div class="inputSection"> <input type='text' id='Contact1'
        data-bind="value : contact1" /></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Contact No 2</div><div class="inputSection"> <input type='text' id='Contact2'
        data-bind="value : contact2" /></div>
        </div>


         <div class="formRowSpacer">
         </div>


        <div class="formRow darken" data-bind="visible : $root.getPermission">
        <div class="labelSection"></div><div class="inputSection">

        <div id="residenceInfoSaveCommand" class="maintenanceCommand">

        <button id="residenceSave" type="button" data-bind="visible : $root.enableAdd, click: $root.saveDataForm"
        class="command">Save</button>

        <button id="residenceCancel" type="button" data-bind="visible : $root.enableAdd, click: $root.cancelEdit"
        class="command">Cancel</button>


        </div>
        </div>
        </div>


        </script>


        <script type="text/javascript">

        $(document).ready(function()
        {
            var ajaxCore = new AjaxCore();
            var employeeId = { id : globalViewModel.targetId() };
            var request = ajaxCore.sendRequest(globalEmployeeResidenceGetByEmployeeUrl, employeeId, "get");

            request.success(function(dataSource)
            {
                 var input = { "id" : coreEmployeeResidenceViewPage, "roleId" : globalViewModel.employeeRole() };
                 var coreCommand = new CoreCommand();
                 var result = coreCommand.getPermission(hostAuthorizationUrl, input);

                 var vm = new EmployeeResidenceViewViewModel(dataSource, 0, result.permission, globalCurrentEmployee);
                 ko.applyBindings(vm, document.getElementById("residenceDataContent"));
            });

        });

        </script>

        <div id="residenceDataContent">

            <div data-bind="visible : $root.bindingSource().length == 0" class="emptyData">
            <div>
            <ul>

            <li class='emptyDataSpacer'> </li>
            <li> No data available.</li>
            </ul>
            </div>
            </div>

            <div data-bind="template : {name : templateToUse , foreach : bindingSource}">
            </div>

        </div>
