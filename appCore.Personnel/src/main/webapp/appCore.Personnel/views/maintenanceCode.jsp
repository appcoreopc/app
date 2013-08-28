        <link href="../../css/dialogBox.css" media="screen" rel="stylesheet" type="text/css" />
        <script language="javascript" src="../../js/viewmodal/codeMaintenanceViewModel.js"></script>
        <script language="javascript" src="../../js/viewmodal/codeMaintenanceHelper.js"></script>
        <script type="text/javascript">

        $(document).ready(function()
        {
            var vm;
            var codeType;

            $("#ui-datepicker-div").hide();
            getData(globalViewModel.companyId());

            function getData(companyId)
            {
                codeType = parseInt(globalCodeMaintenance);
                if (codeType != null)
                {
                    var helper = new CodeMaintenanceHelper(codeType);
                    var gridUrl = helper.getUrl();
                    var ajaxCore = new AjaxCore();
                    var companyObject = { id : companyId };
                    var request = ajaxCore.sendRequest(gridUrl + "/listByCompany", companyObject, "get");

                    request.success(function(data)
                    {
                        $.when(init(data)).done(bind());
                    });
                }
            }

            function init(data)
            {
                vm = new CodeMaintenanceViewModel(coreModeList, codeType, data, globalViewModel);
                var gridDataObject = vm.getView();
                var input = { "id" : coreCodeMaintenancePage, "roleId" : 1 };
                var coreCommand = new CoreCommand();

                var gridViewModel = coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject, vm);
                vm.gridViewModel = gridViewModel;
            }

            function bind()
            {
                $("#codeMaintenanceGrid").setupViewBinding(vm, globalViewModel);
            }
        });



        </script>

        <div id="codeMaintenanceGrid" class="forms">
        <h1 data-bind="text: title"></h1>

        <div class="viewData">
        <div class="maintenanceCommand">
        </div>
        </div>

        <div>

        <div data-bind="dataGrid: gridViewModel"></div>

        </div>
        </div>
