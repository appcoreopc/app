<link href="../../css/dialogBox.css" media="screen" rel="stylesheet" type="text/css" />
<script language="javascript" src="../../js/viewmodal/branchViewModel.js"></script>
<script language="javascript" src="../../js/viewmodal/companyHelper.js"></script>
<script language="javascript" src="../../js/coreGlobalViewModelSetup.js"></script>

<script language="javascript" src="../../js/viewmodal/infoDataViewModel.js"></script>
<script language="javascript" src="../../js/viewmodal/branchInfoViewModel.js"></script>

    <script type="text/javascript">

    $(document).ready(function()
	{
            var vm;
            getData(globalViewModel.companyId());

            function getData(companyId)
            {
                var ajaxCore = new AjaxCore();
                var companyId = { id : companyId };
                var request = ajaxCore.sendRequest(globalBranchListByCompanyUrl, companyId, "get");

                request.success(function(data)
                {
                    $.when(init(data)).done(bind());
                });
            }

            function init(data)
            {
                vm = new BranchViewModel(0, data, globalViewModel);
            }

            function bind()
            {
                $("#branchDiv").setupViewBinding(vm, globalViewModel);
            }

    });


			
</script>    

<div id="branchDiv" class="form formOutline">
	
	<h1>Branch Maintenance</h1>
	
	<div class="viewData"> 
		<div class="maintenanceCommand">
        <button id="AddBranch" class="command" data-bind="click : addBranch">Add Branch</button>
		</div>
    <div>

    <div id="branchGrid" data-bind="dataGrid: gridViewModel"></div>
	</div>
	
	<div>
    </div>
</div>
</div>