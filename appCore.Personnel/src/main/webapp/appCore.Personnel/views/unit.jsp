        <link href="../../css/dialogBox.css" media="screen" rel="stylesheet" type="text/css" />

        <script language="javascript" src="../../js/viewmodal/unitListViewModel.js"></script>
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
            var request = ajaxCore.sendRequest(globalUnitListByCompanyUrl, companyId, "get");

            request.success(function(data)
            {
                 var coreCommand = new CoreCommandHelper();
                 var vm = new UnitListViewModel(coreModeList, data, globalViewModel, coreCommand.createCommandInstance());
                 $("#unitDiv").setupViewBinding(vm, globalViewModel);
            });
        }

        </script>

        <div class="forms">
        <h1>Unit Maintenance</h1>


        <div class="viewData">
        <div class="maintenanceCommand">
        </div>

        <div>
        <div id="unitDiv" data-bind="dataGrid: gridViewModel"></div>
        </div>

        </div>
