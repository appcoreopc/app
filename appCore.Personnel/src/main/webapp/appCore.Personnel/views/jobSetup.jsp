        <link href="../../css/dialogBox.css" media="screen" rel="stylesheet" type="text/css" />
        <script language="javascript" src="../../js/viewmodal/jobSetupListViewModel.js"></script>
        <script language="javascript" src="../../js/viewmodal/companyHelper.js"></script>


        <script type="text/javascript">

        $(document).ready(function()
        {
            getData(globalViewModel.companyId());
        });

        function getData(companyId)
        {
            var ajaxCore = new AjaxCore();
            var companyId = { id : companyId };
            var request = ajaxCore.sendRequest(globalJobSetupListByCompanyUrl, companyId, "get");

            request.success(function(data)
            {
                var vm = new JobSetupListViewModel(coreModeList, data, globalViewModel);
                $("#jobSetupDiv").setupViewBinding(vm, globalViewModel);
            });
        }

        </script>

        <div class="forms">
        <h1>Job Setup Maintenance</h1>


        <div class="viewData">
        <div class="maintenanceCommand">
        </div>

        <div>
        <div id="jobSetupDiv" data-bind="dataGrid: gridViewModel"></div>
        </div>

        </div>
