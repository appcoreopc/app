        <link href="../../css/themes/base/jquery.ui.all.css" media="screen" rel="stylesheet" type="text/css" />
        <link href="../../css/employeeGeneralAddForm.css" media="screen" rel="stylesheet" type="text/css" />
        <script language="javascript" src="../../js/viewmodal/employeeHelper.js"></script>
        <script language="javascript" src="../../js/viewmodal/employeeQualificationViewModel.js"></script>

        <script type="text/javascript">

        $(document).ready(function()
        {

            $("#QualificationForm").validationEngine();

            var ajaxCore = new AjaxCore();
            var vm = new EmployeeQualificationViewModel(0, globalViewModel);

            var gridDataObject = vm.getView();
            var input = vm.getRole();

            var coreCommand = new CoreCommand();
            coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);
            vm.loadInitData();
            $("#qualificationAddDetailInfo").setupViewBinding(vm, globalViewModel);

        });

        </script>


        <form id="QualificationForm">


        <div id="qualificationAddDetailInfo">


        <div class="sectionalForm">
        <div class="leftSection">
        <div class="labelSection">Level</div><div class="inputSection"><select type="text" id="Level"
        data-bind="options: levelList, optionsText: 'name', optionsValue: 'nid', value: level"/></div>
        </div>

        <div class="rightSection">
        <div class="inlineLabelSection">Field</div><div class="inlineLabelSection"><select type="text" id="Field"
        data-bind="options: fieldList, optionsText: 'name', optionsValue: 'nid', value: field"/></div>
        </div>
        </div>


        <div class="sectionalForm">
        <div class="labelSection">Major</div><div class="inputSection"><input type="text" id="Majors"
        data-bind="value: majors" class="validate[required], maxSize[30]"/></div>
        </div>


        <div class="sectionalForm">
        <div class="leftSection">
        <div class="labelSection">Institution</div><div class="inputSection"><input type="text" id="Institution"
        data-bind="value: institution" class="validate[required], maxSize[40]" /></div>
        </div>

        <div class="rightSection">
        <div class="inlineLabelSection">Local/Oversea</div><div class="inlineLabelSection"><input type="checkbox"
        id="LocalOversea" data-bind="checked : localOversea"/></div>
        </div>
        </div>

        <div class="sectionalForm">
        <div class="leftSection">
        <div class="labelSection">Start Date</div><div class="inputSection"><input type="text" id="StartDate"
        data-bind="datepicker: startDate, datepickerOptions: { dateFormat : 'dd-mm-yy'}"/></div>
        </div>

        <div class="rightSectionInline">
        <div class="inlineLabelSection">End Date</div><div class="inlineLabelSectionExtra"><input type="text" id="EndDate"
        data-bind="datepicker: endDate, datepickerOptions: { dateFormat : 'dd-mm-yy'}"/></div>
        </div>
        </div>

        <div class="sectionalForm">
        <div class="labelSection">Result (CGPA) </div><div class="inputSection"><input type="text" id="CGPA"
        data-bind="value: CGPA" class="validate[required], custom[number]"/></div>
        </div>


        <div class="sectionalForm">
        <div class="labelSection">Attachment</div><div class="inputSection"><input type="text" id="Attachment"
        data-bind="value: attachment"/></div>
        </div>


        <div class="sectionalForm">
        <div class="labelSection">Remarks</div><div class="inputSection"><input type="text" id="QualificationRemark"
        data-bind="value: remarks"/></div>
        </div>


        <div class="sectionalForm">
        <div></div>
        </div>


        <div class="formRow">
        <div id="userCommand"></div>
        </div>

        </div>

        </form>