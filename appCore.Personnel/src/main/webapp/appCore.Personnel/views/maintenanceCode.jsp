    <script language="javascript" src="../../js/viewmodal/codeMaintenanceViewModel.js"></script>
        <script language="javascript" src="../../js/viewmodal/codeMaintenanceHelper.js"></script>

        <script type="text/javascript">


        $(document).ready(function()
        {

        var codeType = parseInt(globalCodeMaintenance);

        if (codeType != null)
        {
            var helper = new CodeMaintenanceHelper(codeType);
            var gridUrl = helper.getUrl();

            var ajaxCore = new AjaxCore();
            var request = ajaxCore.sendRequest(gridUrl + "/list", null, "get");

            var vm;

            request.success(function(data)
            {
            vm = new CodeMaintenanceViewModel(0, codeType, data);
            var gridDataObject = vm.getView();

            var input = { "id" : coreDivisionPage, "roleId" : 1 };
            var coreCommand = new CoreCommand();
            coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject, vm);
            });

        }

        $(document).unbind("parseComplete");

            $(document).bind("parseComplete", function()
            {
            ko.applyBindings(vm);
            });

        });



        </script>

        <div class="forms">
        <h1 data-bind="text: title"></h1>

        <div class="viewData">
        <div class="maintenanceCommand">
        </div>
        </div>

        <div>

        <div id="codeGrid" style="height: 380px"></div>

        </div>
        </div>
