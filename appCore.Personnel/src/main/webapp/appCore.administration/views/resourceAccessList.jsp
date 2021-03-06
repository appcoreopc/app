<link href="../../css/dialogBox.css" media="screen" rel="stylesheet" type="text/css" />
<script language="javascript" src="../../js/viewmodal/Administration/resourceAccessListViewModel.js"></script>
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

                var request = ajaxCore.sendRequest(globalResourceListByCompanyUrl, companyId, "get");

                request.success(function(data)
                {
                    $.when(init(data)).done(bind());
                });
            }

            function init(data)
            {
                var coreCommand = new CoreCommandHelper();
                vm = new FormsListViewModel(coreModeList, data, globalViewModel, coreCommand.createCommandInstance());
            }

            function bind()
            {
                $("#formsTypeDiv").setupViewBinding(vm, globalViewModel);
            }

    });



</script>

<div class="forms">
  <h1>Resource Maintenance</h1>

  <div class="viewData">
    <div class="maintenanceCommand">
    </div>

    <div>
      <div id="formsTypeDiv" data-bind="dataGrid: gridViewModel"></div>
    </div>

  </div>
</div>