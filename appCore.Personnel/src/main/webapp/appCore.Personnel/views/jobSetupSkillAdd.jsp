    <link href="../../css/themes/base/jquery.ui.all.css" media="screen" rel="stylesheet" type="text/css" />
        <link href="../../css/employeeGeneralAddForm.css" media="screen" rel="stylesheet" type="text/css" />
        <script language="javascript" src="../../js/viewmodal/employeeHelper.js"></script>
        <script language="javascript" src="../../js/viewmodal/jobSetupSkillAddViewModel.js"></script>


        <script type="text/javascript">

        $(document).ready(function()
        {
           $("#JobSetupSkillForm").validationEngine();

            var ajaxCore = new AjaxCore();
            var vm = new JobSetupSkillAddViewModel(coreModeInsert, globalViewModel);

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


        <form id="JobSetupSkillForm">


        <div id="employeeExpertiseAddDetailInfo">


        <div class="sectionalForm">
        <div class="leftSection">
        <div class="labelSection">Skill</div><div class="inputSection"><select type="text" data-bind="options:
        skillList, optionsText: 'name', optionsValue: 'nid', value: skill" id="Skill" /></div>
        </div>

        <div class="rightSection">
        <div class="inlineLabelSection">Skill Level</div><div class="inlineLabelSection"><select type="text"
        data-bind="options: skillLevelList, optionsText: 'name', optionsValue: 'nid', value: level" id="SkillLevel"
        /></div>
        </div>
        </div>

        <div class="sectionalForm">
        <div class="leftSection">
        <div class="labelSection">Category</div><div class="inputSection"><input type="text" id="Category"
        data-bind="value : category"/></div>
        </div>

        <div class="rightSectionInline">
        <div class="inlineLabelSection">Category Description</div><div class="inlineLabelSectionExtra"><input
        type="text" data-bind="value : categoryDescription" id="categoryDescription" /></div>
        </div>
        </div>

        <div class="sectionalForm">
        <div class="labelSection">Description</div><div class="inputSection"><input type="text" id="Description"
        data-bind="value: description" class="validate[maxSize[40]]"/></div>
        </div>


        <div class="sectionalForm">
        <div></div>
        </div>


        <div class="formRow">
        <div id="userCommand"></div>
        </div>


        </div>

        </form>