<script language="javascript" src="../../js/viewmodal/jobSkillViewModel.js"></script>

<script type="text/javascript">


    var vm;

    $(document).ready(function()
	{
			vm = new JobSkillViewModel(1);
			var gridDataObject = vm.getView();
			var input = { "id" : coreJobSkillRequirement, "roleId" : 1 };
			var coreCommand = new CoreCommand();
			coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);
	});
			
</script>    
<form id="">

<div class="formSkillRequirement">
	<h1>Skill Requirement</h1>

	<div class="maintenanceCommand">
        <div id="skillCommand" class="maintenanceCommand">
        </div>
	</div>
	
	<div class="formRow">	
		&nbsp;
    </div>
    <div>
		<div id="gridSkillRequirement" style="height: 380px"></div>
	</div>
</div>

</form>