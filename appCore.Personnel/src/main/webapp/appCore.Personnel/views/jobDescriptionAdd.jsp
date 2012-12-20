
    <script language="javascript" src="../../js/viewmodal/jobTypeViewModel.js"></script>

        <script type="text/javascript">

        $(document).ready(function()
        {
            var vm = new JobTypeViewModel(1);
            var gridDataObject = vm.getView();
            var input = { "id" : coreJobType, "roleId" : 1 };
            var coreCommand = new CoreCommand();
            coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);
        });

        </script>


        <form id="jobDescriptionForm">

        <div class="jobTypeForm">

        <div class="maintenanceCommand">
            <div id="jobTypeCommand" class="maintenanceCommand">
            </div>
        </div>


        <div class="formRow">
        <div class="labelSection">Job Description</div><span class='req'>*</span>

        <div class="formRow">
            <textarea id="jobDescription"></textarea>
        </div>

        <div class="formRow">
        &nbsp;
        </div>


        </div>
    </form>