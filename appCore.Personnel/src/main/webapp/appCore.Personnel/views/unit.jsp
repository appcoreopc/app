        <link href="../../css/dialogBox.css" media="screen" rel="stylesheet" type="text/css" />

        <script language="javascript" src="../../js/viewmodal/unitListViewModel.js"></script>
        <script language="javascript" src="../../js/viewmodal/companyHelper.js"></script>


        <script type="text/javascript">

        $(document).ready(function()
        {
            getData(globalViewModel.companyId());

            globalViewModel.companyId.subscribe(function(newValue)
            {
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
            var vm = new UnitListViewModel(0, data, globalViewModel);
            ko.applyBindings(vm, document.getElementById("unitDiv"));
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
