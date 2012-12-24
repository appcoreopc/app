    <script language="javascript" src="../../js/viewmodal/employeeViewModel.js"></script>

        <script type="text/javascript">

        $(document).ready(function()
        {
               var vm = new EmployeeViewModel(0, globalViewModel);
               var gridDataObject = vm.getListView();
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