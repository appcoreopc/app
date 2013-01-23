        <link href="../../css/themes/base/jquery.ui.all.css" media="screen" rel="stylesheet" type="text/css" />
        <link href="../../css/employeeGeneralAddForm.css" media="screen" rel="stylesheet" type="text/css" />
        <script language="javascript" src="../../js/viewmodal/employeeHelper.js"></script>
        <script language="javascript" src="../../js/viewmodal/jobSetupExperienceAddViewModel.js"></script>

        <script type="text/javascript">

        $(document).ready(function()
        {
            $("#ExpertiseForm").validationEngine();

            var ajaxCore = new AjaxCore();
            var vm = new JobSetupExperienceAddViewModel(coreModeInsert, globalViewModel);

            var gridDataObject = vm.getView();
            var input = vm.getRole();

            try
            {
                var coreCommand = new CoreCommand();
                coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);
                vm.loadInitData();
                ko.applyBindings(vm, document.getElementById("employeeExpertiseAddDetailInfo"));
            }
            catch (ex)
            {
                console.log(ex)
            }

        });

        </script>


        <form id="ExpertiseForm">


        <div id="employeeExpertiseAddDetailInfo">


        <div class="sectionalForm">
        <div class="leftSection">
        <div class="labelSection">Expertise</div><div class="inputSection"><select type="text" data-bind="options:
        expertiseList, optionsText: 'name', optionsValue: 'nid', value: expertise" id="Expertise" /></div>
        </div>

        </div>


        <div class="sectionalForm">
        <div class="leftSection">
        <div class="labelSection">Year of Experience</div><div class="inputSection"><input type="text" id="YearOfExperience"
        data-bind="value : yearOfExperience"/></div>
        </div>

        </div>

        <div class="sectionalForm">
        <div class="labelSection">Expertise Description</div><div class="inputSection"><input type="text" id="Description" data-bind="value:
        description" class="validate[required, custom[number]]" /></div>
        </div>


        <div class="sectionalForm">
        <div></div>
        </div>


        <div class="formRow">
        <div id="userCommand"></div>
        </div>


        </div>

        </form>