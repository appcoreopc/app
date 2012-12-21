    <script language="javascript" src="../../js/viewmodal/jobTypeViewModel.js"></script>

        <script type="text/javascript">

        $(document).ready(function()
        {
        var vm = new JobTypeViewModel(0);
        var gridDataObject = vm.getView();

        var input = { "id" : coreBranchPage, "roleId" : 1 };
        var coreCommand = new CoreCommand();
        coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);

        });

        </script>

        <div class="form">
        <h1>Job Setup</h1>


        <div class="viewData">
        <div id="jobTypeCommand" class="maintenanceCommand">
        </div>
        </div>


        <div>
        <div id="gridJobType" style="height: 380px"></div>
        </div>
        </div>
