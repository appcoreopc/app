        <link href="../../css/employeeGeneralAddForm.css" media="screen" rel="stylesheet" type="text/css" />
        <script language="javascript" src="../../js/viewmodal/employeeHelper.js"></script>
        <script language="javascript" src="../../js/viewmodal/jobSetupQualificationAddViewModel.js"></script>

        <script type="text/javascript">

        $(document).ready(function()
        {
            $("#JobSetupQualificationForm").validationEngine();

            var ajaxCore = new AjaxCore();
            var vm = new JobSetupQualificationAddViewModel(coreModeInsert, globalViewModel);

            var gridDataObject = vm.getView();
            var input = vm.getRole();

            var coreCommand = new CoreCommand();
            coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);
            vm.loadInitData();
            $("#employeeExpertiseAddDetailInfo").setupViewBinding(vm, globalViewModel);

        });

        </script>


        <form id="JobSetupQualificationForm">


        <div id="employeeExpertiseAddDetailInfo">


        <div class="jobSetupSectionalForm">
        <div class="leftSection">
        <div class="labelSection">Level</div><div class="inputSection"><select type="text" data-bind="options:
        levelList, optionsText: 'name', optionsValue: 'nid', value: level" id="Level" /></div>
        </div>

        <div class="rightSection">
        <div class="inlineLabelSection">Level Description</div><div class="inlineLabelSection"><input type="text"
        data-bind="value: description" id="Description"
        /></div>
        </div>
        </div>


        <div class="jobSetupSectionalForm">
        <div class="leftSection">
        <div class="labelSection">Field of Study</div><div class="inputSection"><input type="text" id="FieldOfStudy"
        data-bind="value : fieldOfStudy"/></div>
        </div>


        <div class="jobSetupSectionalForm">
        <div></div>
        </div>


        <div class="formRow">
            <div id="userCommand"></div>
        </div>


        </div>

        </form>