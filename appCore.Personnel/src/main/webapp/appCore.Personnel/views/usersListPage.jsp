<link href="../../css/dialogBox.css" media="screen" rel="stylesh eet" type="text/css" />
<script language="javascript" src="../../js/viewmodal/usersListViewModel.js"></script>
<script language="javascript" src="../../js/viewmodal/companyHelper.js"></script>

<script type="text/javascript">

  $(document).ready(function()
  {
  getData(globalViewModel.companyId());
  });

  function getData(companyId)
  {
      var ajaxCore = new AjaxCore();
      var companyId = { id : companyId };
      var request = ajaxCore.sendRequest(globalHostname + "/app/Users/Users/listByCompany", companyId, "get");

        request.success(function(data)
        {
        var coreCommand = new CoreCommandHelper();
        var vm = new UsersListViewModel(coreModeList, data, globalViewModel, coreCommand.createCommandInstance());
				  $("#usersTypeDiv").setupViewBinding(vm, globalViewModel);
      });
   }

</script>

<div class="forms">
  <h1>Users Maintenance</h1>


  <div class="viewData">
    <div class="maintenanceCommand">
    </div>

    <div>
      <div id="usersTypeDiv" data-bind="dataGrid: gridViewModel"></div>
    </div>

  </div>
</div>