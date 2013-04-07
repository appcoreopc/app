    <link href="../../css/dialogBox.css" media="screen" rel="stylesheet" type="text/css" />
    <script language="javascript" src="../../js/viewmodal/companyViewModel.js"></script>
    <script language="javascript" src="../../js/viewmodal/companyHelper.js"></script>
    <script language="javascript" src="../../js/coreDefaultBinding.js"></script>

        <script type="text/javascript">

        $(document).ready(function()
        {
            var ajaxCore = new AjaxCore();
            var request = ajaxCore.sendRequest(globalCompanyListUrl, null, "get");

            request.success(function(data)
            {
                try
                {
                    var vm = new CompanyViewModel(globalCompanyUrl, data, globalViewModel);
                    var gridDataObject = vm.getView();
                    var input = { "id" : coreCompanyPage, "roleId" : globalViewModel.employeeRole() };
                    var coreCommand = new CoreCommand();
                    var gridViewModel = coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);
                    vm.gridViewModel = gridViewModel;
                    //ko.applyBindings(vm, document.getElementById("companyDiv"));
                    $("#companyDiv").setupViewBinding(vm, globalViewModel);

                }
                catch (ex)
                {
                    console.log(ex)
                }
            });
        });


        </script>

        <div class="form">
        <h1>Company </h1>

        <div class="viewData">
        <div class="maintenanceCommand">
        </div>
        </div>

        <div>

        <div id="companyDiv" data-bind="dataGrid: gridViewModel"></div>
        </div>
        </div>