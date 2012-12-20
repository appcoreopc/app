    <script language="javascript" src="../../js/viewmodal/employeeViewModel.js"></script>

        <script type="text/javascript">

        $(document).ready(function()
        {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequest(globalEmployeeUrl + "/list", null, "get");

        request.success(function(data)
        {
            var vm = new EmployeeViewModel();
            var gridDataObject = vm.getListView(data);
            var input = { "id" : coreEmployeePage, "roleId" : 1 };
            var coreCommand = new CoreCommand();
            coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);
        });
        });

        </script>

        <div class="form formOutline">

        <h1>Employee</h1>

        <div class="viewData">
        <div class="maintenanceCommand">
        </div>

        <div>
        <div id="employeeListViewGrid" style="height: 380px"></div>
        </div>

        </div>
        </div>