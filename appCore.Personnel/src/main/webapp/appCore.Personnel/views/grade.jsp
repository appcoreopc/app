    <link href="../../css/dialogBox.css" media="screen" rel="stylesheet" type="text/css" />

        <script language="javascript" src="../../js/viewmodal/gradeListViewModel.js"></script>
        <script language="javascript" src="../../js/viewmodal/companyHelper.js"></script>


        <script type="text/javascript">

        $(document).ready(function()
        {
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
        var request = ajaxCore.sendRequest(globalGradeTypeListByCompanyUrl, companyId, "get");

        request.success(function(data)
        {
             var vm = new GradeListViewModel(coreModeList, data, globalViewModel);
             $("#gradeTypeDiv").setupViewBinding(vm, globalViewModel);
        });
        }

        </script>

        <div class="forms">
        <h1>Grade Maintenance</h1>


        <div class="viewData">
        <div class="maintenanceCommand">
        </div>

        <div>
        <div id="gradeTypeDiv" data-bind="dataGrid: gridViewModel"></div>
        </div>

        </div>