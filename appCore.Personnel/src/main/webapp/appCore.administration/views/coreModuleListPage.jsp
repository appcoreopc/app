<link href="../../css/dialogBox.css" media="screen" rel="stylesh eet" type="text/css" />
<script language="javascript" src="../../js/viewmodal/Administration/coreModuleListViewModel.js"></script>
<script language="javascript" src="../../js/viewmodal/companyHelper.js"></script>

<script type="text/javascript">

  $(document).ready(function()
  {
          getData(globalViewModel.companyId());

          function getData(companyId)
          {
              var ajaxCore = new AjaxCore();
              var companyId = { id : companyId };
              var request = ajaxCore.sendRequest(globalCoreModuleListByCompany, companyId, "get");
              var vm;

              request.success(function(data)
              {
                    $.when(init(data)).done(bind());
              });
           }

        function init(data)
        {
            var coreCommand = new CoreCommandHelper();
            vm = new CoreModuleListViewModel(coreModeList, data, globalViewModel, coreCommand.createCommandInstance());
        }

        function bind()
        {
            $("#coreModuleTypeDiv").setupViewBinding(vm, globalViewModel);
        }
  });

</script>

<div class="forms">
  <h1>Core Module Maintenance</h1>


  <div class="viewData">
    <div class="maintenanceCommand">
    </div>

    <div>
      <div id="coreModuleTypeDiv" data-bind="dataGrid: gridViewModel"></div>
    </div>

  </div>
</div>