        <link href="../../css/dialogBox.css" media="screen" rel="stylesheet" type="text/css" />
        <script language="javascript" src="../../js/viewmodal/Administration/userRightsListViewModel.js"></script>
        <script language="javascript" src="../../js/viewmodal/companyHelper.js"></script>

        <script type="text/javascript">

        $(document).ready(function()
        {
            var vm;
            getData(globalViewModel.companyId());

            function getData(companyId)
            {
                var ajaxCore = new AjaxCore();
                var companyId = { id : companyId };
                var request = ajaxCore.sendRequest(globalUserListListByCompanyUrl, companyId, "get");

                request.success(function(data)
                {
                    $.when(init(data)).done(bind());

                });
            }

            function init(data)
            {
                vm = new UserRightsListViewModel(coreModeList, data, globalViewModel);
            }

            function bind()
            {
                $("#userRightListDiv").setupViewBinding(vm, globalViewModel);
            }

        });


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
