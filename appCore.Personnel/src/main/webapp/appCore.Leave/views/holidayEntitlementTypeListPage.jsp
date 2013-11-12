<link href="../../css/dialogBox.css" media="screen" rel="stylesh eet" type="text/css" />
<script language="javascript" src="../../js/viewmodal/Leave/holidayEntitlementTypeListViewModel.js"></script>
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
          var request = ajaxCore.sendRequest(globalHostname + "/app/Calendar/HolidayEntitlementType/listByCompany", companyId, "get");

          request.success(function(data)
          {
              $.when(init(data)).done(bind());      
          });
      }
      
      function init(data)
      {
          var coreCommand = new CoreCommandHelper();
          vm = new HolidayEntitlementTypeListViewModel(coreModeList, data, globalViewModel, coreCommand.createCommandInstance());
      
      }
      
      function bind()
      {
          $("#holidayEntitlementTypeTypeDiv").setupViewBinding(vm, globalViewModel);
      }
      
      
  });



</script>

<div class="forms">
  <h1>Holiday Entitlement Type Maintenance</h1>


  <div class="viewData">
    <div class="maintenanceCommand">
    </div>

    <div>
      <div id="holidayEntitlementTypeTypeDiv" data-bind="dataGrid: gridViewModel"></div>
    </div>

  </div>
</div>