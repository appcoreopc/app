        <link href="../../css/dialogBox.css" media="screen" rel="stylesheet" type="text/css" />
        <script language="javascript" src="../../js/viewmodal/Administration/userRightsListViewModel.js"></script>
        <script language="javascript" src="../../js/viewmodal/companyHelper.js"></script>


        <script type="text/javascript">

        $(document).ready(function()
        {
            getData(globalViewModel.userRole());
            globalViewModel.userRole.subscribe(function(newValue)
            {
                $(".maintenanceCommand").empty();
                getData(newValue);
            });
        });

        function getData(companyId)
        {
            var ajaxCore = new AjaxCore();
            var companyId = { id : companyId };

            var request = ajaxCore.sendRequest(globalUserList, companyId, "get");
            request.success(function(data)
            {
                var vm = new UserRightsListViewModel(coreModeList, data, globalViewModel);
                ko.applyBindings(vm, document.getElementById("userRightListDiv"));
            });
        }

        </script>

        <div class="forms">
        <h1>User Maintenance</h1>


        <div class="viewData">
        <div class="maintenanceCommand">
        </div>

        <div>
        <div id="userRightListDiv" data-bind="dataGrid: gridViewModel"></div>
        </div>

        </div>
