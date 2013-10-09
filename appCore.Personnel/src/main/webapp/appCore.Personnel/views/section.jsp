    <link href="../../css/dialogBox.css" media="screen" rel="stylesheet" type="text/css" />

    <script language="javascript" src="../../js/viewmodal/sectionListViewModel.js"></script>
    <script language="javascript" src="../../js/viewmodal/companyHelper.js"></script>



        <script type="text/javascript">


        var vm;
        var formName = "sectionDiv";

        $(document).ready(function()
        {

            getData(globalViewModel.companyId());

            function getData(companyId)
            {
                var ajaxCore = new AjaxCore();
                var companyId = { id : companyId };
                var request = ajaxCore.sendRequest(globalSectionListByCompanyUrl, companyId, "get");

                request.success(function(data)
                {
                    $.when(init(data)).done(bind());
                });
            }

            function init(data)
            {
                var coreCommand = new CoreCommandHelper();
                vm = new SectionListViewModel(0, data, globalViewModel, coreCommand.createCommandInstance());
            }

            function bind()
            {
                $("#" + formName).setupViewBinding(vm, globalViewModel);
            }

        });

        </script>

        <div class="forms">
        <h1>Section Maintenance</h1>


        <div class="viewData">
        <div class="maintenanceCommand">
        </div>

        <div>
        <div id="sectionDiv" data-bind="dataGrid: gridViewModel"></div>
        </div>

        </div>
