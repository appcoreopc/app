    <link href="../../css/themes/base/jquery.ui.all.css" media="screen" rel="stylesheet" type="text/css" />
        <link href="../../kendo/styles/kendo.custom.min.css" rel="stylesheet">
        <link href="../../css/employeeView.css" media="screen" rel="stylesheet" type="text/css" />
        <link href="../../css/employeeGeneralForm.css" media="screen" rel="stylesheet" type="text/css" />

        <script language="javascript" src="../../js/viewmodal/employeeEmploymentInfoViewModel.js"></script>
        <script language="javascript" src="../../js/viewmodal/employeeHelper.js"></script>


        <script type="text/html" id="employeeEmploymentInfoTemplate">

        <div class="formRowView">

        <div class="formRowView">
        <div class="viewLabelSection">Employer Name</div><div class="inputSection" data-bind="text:
        employerName"></div></div>



        <div class="formRowView">
        <div class="viewLabelSection">Job</div><div class="inputSection" data-bind="text: job"></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Industry</div>

        <div class="inputSection" data-bind="text: $root.getIndustryCode(industry())"></div>

        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Start Date</div><div class="inputSection" data-bind="text: startDate"></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">End Date</div><div class="inputSection" data-bind="text: endDate"></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Duration</div><div class="inputSection" data-bind="text: duration"></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Last Drawn Salary</div><div class="inputSection" data-bind="text:
        lastDrawnSalary"></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Resignation Reason</div><div class="inputSection" data-bind="text:
        resignationReason"></div>
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



        <script type="text/html" id="employeeEmploymentInfoAddTemplate">

        <div class="formRowView">
        <div class="viewLabelSection">Employer Name</div><div class="inputSection">

        <input type="text" id="EmployerName"
        data-bind="value :
        employerName" />


        </div></div>


        <div class="formRowView">
        <div class="viewLabelSection">Job</div><div class="inputSection"> <input type="text" id="Job" data-bind="value : job" /></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Industry</div>
        <div class="inputSection">
        <select id="Industry" data-bind="options: $root.industryList, optionsText: 'name', optionsValue: 'nid', value : industry">
        </select>
        </div>
      </div>


        <div class="formRowView">
        <div class="viewLabelSection">Start Date</div><div class="inputSection"> <input type='text' id='StartDate'  data-bind="datepicker: startDate, datepickerOptions: { dateFormat :
        'dd-mm-yy'}, value : startDate" /></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">End Date</div><div class="inputSection"> <input type='text' id='EndDate'  data-bind="datepicker: endDate, datepickerOptions: { dateFormat :
        'dd-mm-yy'}, value : endDate" />
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Duration</div><div class="inputSection"> <input type="text" id="Duration" data-bind="value : duration" /></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Last Drawn Salary</div><div class="inputSection"> <input type="text" id="LastDrawnSalary" data-bind="value :
        lastDrawnSalary" /></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Resignation Reason</div><div class="inputSection"> <input type="text" id="ResignationReason" data-bind="value:
        resignationReason" /></div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Remarks</div><div class="inputSection"> <input type='text' id="Remarks" data-bind="value : remarks" /></div>
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
        var request = ajaxCore.sendRequest(globalEmployeeEmploymentGetByEmployeeUrl, employeeId, "get");

        request.success(function(dataSource)
        {
            var input = { "id" : coreEmployeeEmploymentViewPage, "roleId" : globalViewModel.employeeRole() };
            var coreCommand = new CoreCommand();
            var result = coreCommand.getPermission(hostAuthorizationUrl, input);
            var vm = new EmployeeEmploymentInfoViewModel(dataSource, 0, result.permission, globalCurrentEmployee);
            $("#employmentDataContent").setupViewBinding(vm, globalViewModel);

        });
        });

        </script>



        <div id="employmentDataContent">

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
