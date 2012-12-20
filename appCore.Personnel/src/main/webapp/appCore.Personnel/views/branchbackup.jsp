<script language="javascript" src="../../js/viewmodal/branchViewModel.js"></script>	

<script type="text/javascript">          
    var gridUrl = globalHostname + "/app/Core/Branch";

    $(document).ready(function()
	{
		var ajaxCore = new AjaxCore();
		var request = ajaxCore.sendRequest(gridUrl + "/list", null, "get");
			
		request.success(function(data)
		{
			var vm = new BranchViewModel(0, 0, data); 
			var addPage = vm.getAddPage(); 
			var centralPage = vm.getCentralPage();
		
			var gridDataObject = vm.getView();
			var input = { "id" : coreBranchPage, "roleId" : 1 };
			var coreCommand = new CoreCommand();
			coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);
		});
	});
			
</script>    

<div class="form">
	<h1>Branch Maintenance</h1>
	<div class="maintenanceCommand">
	</div>

	<div class="formRow">
		&nbsp;
    </div>

    <div>
		<div id="gridBranch" style="height: 380px"></div>
	</div>
</div>
