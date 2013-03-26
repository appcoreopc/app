        <link href="../../css/employeeGeneralForm.css" media="screen" rel="stylesheet" type="text/css" />

        <script language="javascript" src="../../js/viewmodal/employeeHelper.js"></script>
        <script language="javascript" src="../../js/viewmodal/jobTypeViewModel.js"></script>

        <script type="text/javascript">

        $(document).ready(function()
        {
            $("#jobTypeForm").validationEngine();

            var input = { "id" : coreJobType, "roleId" : globalViewModel.employeeRole() };
            var coreCommand = new CoreCommand();
            var result = coreCommand.getPermission(hostAuthorizationUrl, input);
            var vm = new JobTypeViewModel(globalViewModel.editMode(), globalViewModel.targetId(), result.permission, globalViewModel);
            $("#jobDescriptionContent").setupViewBinding(vm, globalViewModel);

        });

        </script>


        <script type="text/html" id="employeeEditJobDescriptionTemplate">


        <form id="jobTypeDataForm">


        <div class="jobTypeForm">

        <div class="formRow">

        <div class="viewLabelSection">Job Description</div><span class='req'>*</span>
        <div class="jobSetuFormRow">
            <textarea id="jobDescription" class="validate[required]" data-bind="value : description"></textarea>
        </div>

        </div>

        <div class="formRow">
        &nbsp;
        </div>

        </div>

        </form>

        </script>


        <script type="text/html" id="employeeJobDescriptionTemplate">

        <div class="jobTypeForm">


        <div class="formRow">

        <div class="viewLabelSection">Job Description</div>
        <div class="formRow">
        <span data-bind="text : description"></span>
        </div>

        </div>

        <div class="formRow">
        &nbsp;
        </div>

        <div id="contactInfoEditCommand" class="maintenanceCommand">

        <button id="contactEdit" type="button" data-bind="visible : $root.enableAdd, click: $root.editData">
        <i class="icon-edit editCommandIcon"></i>Edit</button>


        </div>

        </div>

        </script>


        <div id="jobDescriptionContent">

            <div data-bind="template : { name : templateToUse }">
            </div>

        </div>