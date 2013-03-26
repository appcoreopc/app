        <link href="../../css/dialogBox.css" media="screen" rel="stylesheet" type="text/css" />
        <script language="javascript" src="../../js/viewmodal/employeeViewModel.js"></script>

        <script type="text/javascript">

        $(document).ready(function()
        {
                $("#ui-datepicker-div").hide();

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
                var request = ajaxCore.sendRequest(globalEmployeeListByCompanyUrl, companyId, "get");

                request.success(function(data)
                {
                    var vm = new EmployeeViewModel(coreModeList, globalViewModel, data);
                    $("#employeeDiv").setupViewBinding(vm, globalViewModel);
                });
        }

        </script>

        <div class="forms">
        <h1>Employee Maintenance</h1>


        <div class="viewData">
        <div class="maintenanceCommand">
        </div>

        <div>
        <div id="employeeDiv" data-bind="dataGrid: gridViewModel"></div>
        </div>

        </div>
