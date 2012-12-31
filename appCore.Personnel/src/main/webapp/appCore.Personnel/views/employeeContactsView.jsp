        <link href="../../css/themes/base/jquery.ui.all.css" media="screen" rel="stylesheet" type="text/css" />
        <link href="../../kendo/styles/kendo.custom.min.css" rel="stylesheet">

        <script language="javascript" src="../../js/viewmodal/employeeContactViewViewModel.js"></script>
        <script language="javascript" src="../../js/viewmodal/employeeHelper.js"></script>

        <script type="text/html" id="employeeContactTemplate">

        <div class="formRowView">
        <div class="viewLabelSection">Email</div><div class="inputSection" data-bind="text: email"></div>
        </div>

        <div class="formRowView">
        <div class="viewLabelSection">H/P</div><div class="inputSection" data-bind="text: mobileNo"></div>
        </div>

        <div class="formRowView">
        <div class="viewLabelSection">Alternate Email</div><div class="inputSection" data-bind="text:
        alternateEmail"></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Ext No</div><div class="inputSection" data-bind="text: extNo"></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Correspondence Address </div><div
        class="inputSection" data-bind="text: correspondenceAddress1"></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection"></div><div class="inputSection" data-bind="text: correspondenceAddress2"></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection"></div><div class="inputSection" data-bind="text: correspondenceAddress3"></div>
        </div>

        <div class="formRowView">
        <div class="viewLabelSection">City</div><div class="inputSection" data-bind="text: city"></div>
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


        <div class="formRowSpacer">
        </div>


        <div class="formRow darken" data-bind="visible : $root.getPermission">
        <div class="labelSection"></div><div class="inputSection">

        <div id="contactInfoEditCommand" class="maintenanceCommand">

        <button id="contactEdit" type="button" data-bind="visible : $root.enableAdd, click: $root.editData"
        class="command">Edit</button>


        </div>
        </div>
        </div>

        <div class="formRowView">
        <span class="formRowRuler"></span>
        </div>

        </script>


        <script type="text/html" id="employeeContactAddTemplate">

        <div class="formRowView">
        <div class="viewLabelSection">Email</div><div class="inputSection"> <input type='text' id='email'
        data-bind="value: email" /></div>
        </div>

        <div class="formRowView">
        <div class="viewLabelSection">H/P</div><div class="inputSection"> <input type='text' id='mobileNo'
        data-bind="value: mobileNo" /></div>
        </div>

        <div class="formRowView">
        <div class="viewLabelSection">Alternate Email</div><div class="inputSection"> <input type='text'
        id='alternateEmail' data-bind="value: alternateEmail" /></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Ext No</div><div class="inputSection"> <input type='text' id='ExtNo'
        data-bind="text: extNo" /></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Correspondence Address </div><div
        class="inputSection"><input type='text' id='CorrespondenceAddress1' data-bind="text:
        correspondenceAddress1"></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection"></div><div class="inputSection"> <input type='text' id='CorrespondenceAddress2'
        data-bind="text: correspondenceAddress2" /></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection"></div><div class="inputSection"> <input type='text' id='CorresspondenceAddress3'
        data-bind="text: correspondenceAddress3" /></div>
        </div>

        <div class="formRowView">
        <div class="viewLabelSection">City</div><div class="inputSection"> <input type='text' id='City' data-bind="text:
        city" /></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Country</div><div class="inputSection">

        <select id="gender" data-bind="options: $root.countryList, optionsText: 'name', optionsValue: 'nid', value:
        country">
        </select>

        </div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Postcode</div><div class="inputSection"> <input type='text' id='PostCode'
        data-bind="text: postCode" /></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Tel No</div><div class="inputSection"> <input type='text' id='TelNo'
        data-bind="text: telNo" /></div>
        </div>


        <div class="formRow darken">
        <div class="labelSection"></div><div class="inputSection">

        <div id="employeeAddContactCommand" class="maintenanceCommand">
        <button id="contactInfoSave" type="button" data-bind="visible : $root.enableAdd, click: $root.saveDataForm"
        class="command">Save</button>

        <button id="contactCancel" type="button" data-bind="visible : $root.enableAdd, click: $root.cancelEdit"
        class="command">Cancel</button>
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
                var request = ajaxCore.sendRequest(globalEmployeeContactGetByEmployeeUrl, employeeId, "get");

                request.success(function(dataSource)
                {
                    var input = { "id" : coreEmployeeContactViewPage, "roleId" : globalViewModel.employeeRole() };
                    var coreCommand = new CoreCommand();
                    var result = coreCommand.getPermission(hostAuthorizationUrl, input);

                    var vm = new EmployeeContactViewViewModel(dataSource, 0, result.permission, globalCurrentEmployee);
                    ko.applyBindings(vm, document.getElementById("contactDataContent"));
                });
            }
        });

        </script>

            <div id="contactDataContent">

            <div data-bind="visible : bindingSource().length == 0" class="emptyData">
                <div>
                <ul>
                    <li class='emptyDataSpacer'> </li>
                    <li> No data available.</li>
                </ul>
                </div>
            </div>

            <div data-bind="template : {name : templateToUse, foreach :
                bindingSource}">
            </div>

         </div>