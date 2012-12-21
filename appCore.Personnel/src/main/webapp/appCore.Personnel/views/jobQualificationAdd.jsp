   <script language="javascript" src="../../js/viewmodal/jobQualificationViewModel.js"></script>
   <script type="text/javascript">

        var jobQualificationForm = "jobQualificationForm";

        $(document).ready(function()
        {
            $("#" + jobQualificationForm).validationEngine();

            var vm = new JobQualificationViewModel(1);
            var gridDataObject = vm.getView();

            var input = { "id" : coreJobQualification, "roleId" : 1 };
            var coreCommand = new CoreCommand();
            coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);
        });

        </script>

      <form id="jobQualificationForm">

        <div class="form">
        <h1>Qualification Requirement</h1>

        <div class="maintenanceCommand">
       <div id="qualificationCommand" class="maintenanceCommand">
       </div>
        </div>

        <div class="formRow">
        &nbsp;
        </div>
        <div>
        <div id="gridJobQualification" style="height: 380px"></div>
        </div>
        </div>
   </form>
