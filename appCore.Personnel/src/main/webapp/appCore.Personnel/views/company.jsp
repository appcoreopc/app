    <script language="javascript" src="../../js/viewmodal/companyViewModel.js"></script>
        <script type="text/javascript">

        $(document).ready(function()
        {

        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequest(globalCompanyListUrl, null, "get");

        request.success(function(data)
        {
            var vm = new CompanyViewModel(globalCompanyUrl, data);
            var gridDataObject = vm.getView();

            var input = { "id" : coreCompanyPage, "roleId" : 1 };
            var coreCommand = new CoreCommand();
            coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);

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
        <div id="grid" style="height: 380px"></div>
        </div>
        </div>
