        <link href="../../css/dialogBox.css" media="screen" rel="stylesheet" type="text/css" />

        <script language="javascript" src="../../js/viewmodal/holidaySetupListViewModel.js"></script>
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
            var request = ajaxCore.sendRequest(globalHolidaySetupListByCompanyUrl, companyId, "get");

            request.success(function(data)
            {
                var vm = new HolidaySetupListViewModel(coreModeList, data, globalViewModel);
                $("#holidaySetupDiv").setupViewBinding(vm, globalViewModel);
            });
        }

        </script>

        <div class="forms">
        <h1>Holidays Available</h1>

        <div class="viewData">
        <div class="maintenanceCommand">
        </div>

        <div>
        <div id="holidaySetupDiv" data-bind="dataGrid: gridViewModel"></div>
        </div>

        </div>
