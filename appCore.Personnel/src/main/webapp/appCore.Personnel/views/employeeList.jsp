        <link href="../../css/dialogBox.css" media="screen" rel="stylesheet" type="text/css" />
        <script language="javascript" src="../../js/viewmodal/employeeViewModel.js"></script>

        <script type="text/javascript">

        $(document).ready(function()
        {
            var vm;

            $("#ui-datepicker-div").hide();
            getData(globalViewModel.companyId());

            function getData(companyId)
            {
                var ajaxCore = new AjaxCore();
                var companyId = { id : companyId };
                var request = ajaxCore.sendRequest(globalEmployeeListByCompanyUrl, companyId, "get");

                request.success(function(data)
                {
                    $.when(init(data)).done(bind());
                });
            }

            function init(data)
            {
                var coreCommand = new CoreCommandHelper();
                vm = new EmployeeViewModel(coreModeList, globalViewModel, data, coreCommand.createCommandInstance());
            }

            function bind()
            {
                $("#employeeDiv").setupViewBinding(vm, globalViewModel);
            }

        });



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
