
        <script language="javascript" src="../../js/viewmodal/employeeCommandViewModel.js"></script>
        <script language="javascript" src="../../js/coreDialog.js"></script>

        <script type="text/javascript">

        var vm;

        $(document).ready(function()
        {
            vm = new EmployeeCommandViewModel();
            var gridDataObject = vm.getCommandForForm();

            var input = { "id" : globalEmployeeModule, "roleId" : globalViewModel.employeeRole() };
            var coreCommand = new CoreCommand();
            coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);

            var tab = $("#codeSetupTabs").tabs({ cache : true});

        });

        </script>

        <form id="myform">

        <div class="maintenanceCommand">
        </div>

        <div class="form">

        <div id="codeSetupTabs">
        <ul>
        <li><a href="employeeGeneralInfoView.jsp">General</a></li>
        <li><a href="employeeContactsView.jsp">Contacts</a></li>
        <li><a href="employeeResidenceInfoView.jsp">Residence</a></li>
        <li><a href="employeeFamilyView.jsp">Family</a></li>
        <li><a href="employeeQualificationView.jsp">Qualification</a></li>
        <li><a href="employeeMembershipView.jsp">Membership</a></li>
        <li><a href="employeeExpertiseView.jsp">Expertise</a></li>
        <li><a href="employeeEmploymentInfoView.jsp">Employment</a></li>
        </ul>
        </div>

        </div>
        </form>