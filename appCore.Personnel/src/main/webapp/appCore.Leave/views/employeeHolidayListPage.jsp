<link href="../../css/dialogBox.css" media="screen" rel="stylesh eet" type="text/css" />
<script language="javascript" src="../../js/viewmodal/Leave/employeeHolidayListViewModel.js"></script>
<script language="javascript" src="../../js/viewmodal/companyHelper.js"></script>

<script type="text/javascript">

  $(document).ready(function()
  {
      var vm;
      var empList;
      var entitlementList;
      var earningLeaveList;
      var replacementList;

    function getData(companyId)
    {
        var ajaxCore = new AjaxCore();
        var companyId = { id : companyId };
        var request = ajaxCore.sendRequest(globalHostname + "/app/Calendar/EmployeeHoliday/listByCompany", companyId, "get");
        request.success(function(data)
        {
            $.when(init(data)).done(bind());
        });
    }

    $.when(listByCompanyEmployee(), getEntitlementTypeData(), getLeaveEarningScheme(), getLeaveReplacementType()).done(
    function(getDataResponse, getEntitlementResponse, getEarningLeaveResponse, getLeaveReplacementResponse)
    {
         empList = getDataResponse[0];
         entitlementList = getEntitlementResponse[0];
         earningLeaveList = getEarningLeaveResponse[0];
         replacementList = getLeaveReplacementResponse[0];
         getData(globalViewModel.companyId());
    });

    function listByCompanyEmployee() {
        var helper = new LeaveHelper();
        var entityData = { id:globalViewModel.companyId() };
        return helper.listByCompanyEmployee(entityData);
    }

    function getEntitlementTypeData() {
        var helper = new LeaveHelper();
        var entityData = { id:globalViewModel.companyId() };
        return helper.listByCompanyHolidayEntitlementType(entityData);
    }

    function getLeaveReplacementType() {
        var helper = new LeaveHelper();
        var entityData = { id:globalViewModel.companyId() };
        return helper.listByCompanyLeaveReplacementType(entityData);
    }

    function getLeaveEarningScheme() {
        var helper = new LeaveHelper();
        var entityData = { id:globalViewModel.companyId() };
        return helper.listByCompanyHolidayLeaveEarningScheme(entityData);
    }

    function init(data)
    {
          var coreCommand = new CoreCommandHelper();
          vm = new EmployeeHolidayListViewModel(coreModeList, data, globalViewModel, coreCommand.createCommandInstance(), empList, entitlementList, earningLeaveList, replacementList);
    }

      function bind()
      {
          $("#employeeHolidayTypeDiv").setupViewBinding(vm, globalViewModel);
      }

  });



</script>

<div class="forms">
  <h1>Employee Leave Maintenance</h1>


  <div class="viewData">
    <div class="maintenanceCommand">
    </div>

    <div>
      <div id="employeeHolidayTypeDiv" data-bind="dataGrid: gridViewModel"></div>
    </div>

  </div>
</div>