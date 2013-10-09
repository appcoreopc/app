<script language="javascript" src="../../js/viewmodal/jobExperienceViewModel.js"></script>

<script type="text/javascript">

    var vm;

    $(document).ready(function()
	{
			vm = new JobExperienceViewModel(1);
			var gridDataObject = vm.getView();
			var input = { "id" : coreJobExperience, "roleId" : 1 };
			var coreCommand = new CoreCommand();
			coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);
	});
			
</script>    


<div class="jobExperienceForm">
	<h1>Experience Requirement</h1>

	<div class="maintenanceCommand">
        <div id="experienceCommand" class="maintenanceCommand">
        </div>
	</div>
	
	<div class="formRow">	
		&nbsp;
    </div>
    <div>
		<div id="gridJobExperience" style="height: 380px"></div>
	</div>
</div>
</form>