        <link href="../../css/dialogBox.css" media="screen" rel="stylesheet" type="text/css" />
        <script language="javascript" src="../../js/viewmodal/codeMaintenanceViewModel.js"></script>
        <script language="javascript" src="../../js/viewmodal/codeMaintenanceHelper.js"></script>
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

            var codeType = parseInt(globalCodeMaintenance);

            if (codeType != null)
                {
                    var helper = new CodeMaintenanceHelper(codeType);
                    var gridUrl = helper.getUrl();
                    var ajaxCore = new AjaxCore();
                    var companyObject = { id : companyId };

                    var request = ajaxCore.sendRequest(gridUrl + "/listByCompany", companyObject, "get");
                    var vm;

                    request.success(function(data)
                    {
                        try
                        {
                        vm = new CodeMaintenanceViewModel(coreModeList, codeType, data, globalViewModel);
                        var gridDataObject = vm.getView();
                        var input = { "id" : coreCodeMaintenancePage, "roleId" : 1 };
                        var coreCommand = new CoreCommand();

                        var gridViewModel = coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject, vm);
                        vm.gridViewModel = gridViewModel;
                        ko.applyBindings(vm, document.getElementById("codeMaintenanceGrid"));
                        }
                        catch (ex)
                        {
                            console.log(ex)
                        }

                    });
                }
        }

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
