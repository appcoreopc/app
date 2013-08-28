    <link href="../../css/dialogBox.css" media="screen" rel="stylesheet" type="text/css" />
    <script language="javascript" src="../../js/viewmodal/companyViewModel.js"></script>
    <script language="javascript" src="../../js/viewmodal/companyHelper.js"></script>
    <script language="javascript" src="../../js/coreDefaultBinding.js"></script>

        <script type="text/javascript">

        $(document).ready(function()
        {
            var ajaxCore = new AjaxCore();
            var request = ajaxCore.sendRequest(globalCompanyListUrl, null, "get");
            var vm;

            request.success(function(data)
            {
                $.when(init(data)).done(bind());
            });

            function init(data)
            {
                vm = new CompanyViewModel(globalCompanyUrl, data, globalViewModel);
                var gridDataObject = vm.getView();
                var input = { "id" : coreCompanyPage, "roleId" : globalViewModel.employeeRole() };
                var coreCommand = new CoreCommand();
                var gridViewModel = coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);
                vm.gridViewModel = gridViewModel;
            }

            function bind()
            {
                $("#companyDiv").setupViewBinding(vm, globalViewModel);
            }
        });


        </script>

        <div class="form">
        <h1>Company </h1>

        <div class="viewData">
        <div class="maintenanceCommand">
        </div>


        <div>

        <div id="companyDiv" data-bind="dataGrid: gridViewModel"></div>
        </div>
        </div>
        </div>