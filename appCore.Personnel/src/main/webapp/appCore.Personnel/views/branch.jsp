<link href="../../css/dialogBox.css" media="screen" rel="stylesheet" type="text/css" />
<script language="javascript" src="../../js/viewmodal/branchViewModel.js"></script>
<script language="javascript" src="../../js/viewmodal/companyHelper.js"></script>

<script type="text/javascript">


    $(document).ready(function()
	{
        getData(globalViewModel.companyId());
        globalViewModel.companyId.subscribe(function(newValue)
        {
            $(".maintenanceCommand").empty();
            getData(newValue);
        });
    });

    function getData(companyId)
    {
        var ajaxCore = new AjaxCore();
        var companyId = { id : companyId };
        var request = ajaxCore.sendRequest(globalBranchListByCompanyUrl, companyId, "get");

        request.success(function(data)
        {
            var vm = new BranchViewModel(0, data, globalViewModel);
            var gridDataObject = vm.getView();
            var input = { "id" : coreBranchPage, "roleId" : 1 };
            var coreCommand = new CoreCommand();
            var gridViewModel = coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);
            vm.gridViewModel = gridViewModel;
            ko.applyBindings(vm, document.getElementById("branchDiv"));

        });
    }
			
</script>    

<div class="form formOutline">
	
	<h1>Branch Maintenance</h1>
	
	<div class="viewData"> 
		<div class="maintenanceCommand">
		</div>

    <div>
    <div id="branchDiv" data-bind="dataGrid: gridViewModel"></div>
	</div>
	
	<div>
</div>
