    <link href="../../css/dialogBox.css" media="screen" rel="stylesheet" type="text/css" />
    <script language="javascript" src="../../js/viewmodal/departmentListViewModel.js"></script>
    <script language="javascript" src="../../js/viewmodal/companyHelper.js"></script>


        <script type="text/javascript">

        $(document).ready(function()
        {

            var vm;
            getData(globalViewModel.companyId());

            function getData(companyId)
            {
                var ajaxCore = new AjaxCore();
                var companyId = { id : companyId };
                var request = ajaxCore.sendRequest(globalDepartmentListByCompanyUrl, companyId, "get");

                request.success(function(data)
                {
                    $.when(init(data)).done(bind());
                });
            }

            function init(data)
            {
                var coreCommand = new CoreCommandHelper();
                vm = new DepartmentListViewModel(0, data, globalViewModel, coreCommand.createCommandInstance());
                vm.renderView();
            }

            function bind()
            {
                $("#departmentForm").setupViewBinding(vm, globalViewModel);
            }

        });


        </script>

        <div class="forms" id="departmentForm">
        <h1>Department Maintenance</h1>

        <div class="viewData">
        <div class="maintenanceCommand">

        <div data-bind="actionGrid : gridActionViewModel">
        </div>

        <!--
        <div class="commandMenuDiv">
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Actions..<b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="#" data-bind="click : goToAdd, visible : gridViewModel.enableAdd">Add</a></li>
                    <li><a href="#" data-bind="click : selectAll, visible : gridViewModel.enableAdd">Select all</a></li>
                    <li><a href="#" data-bind="click : deleteSelected, visible : gridViewModel.enableDelete">Delete</a></li>
                    <li><a href="#" data-bind="click : goToAdd, visible : gridViewModel.enableAdd">Print</a></li>
                    <li><a href="#" data-bind="click : goToAdd, visible : gridViewModel.enableAdd">Export</a></li>
                </ul>
            </li>
        </div>

         -->

        </div>

        <div>
        <div id="departmentDiv" data-bind="dataGrid: gridViewModel"></div>
        </div>

        </div>
