    <link href="../../css/personnelEmployeeForm.css" media="screen" rel="stylesheet" type="text/css" />

        <script language="javascript" src="../../js/viewmodal/employeeViewModel.js"></script>
        <script language="javascript" src="../../js/coreDialog.js"></script>

        <script type="text/javascript">

        $(document).ready(function()
        {

            var tab = $("#codeSetupTabs").tabs({ cache : true});
            var ajaxCore = new AjaxCore();
            var vm = new EmployeeViewModel(0);

            var gridDataObject = vm.getView();
            var input = { "id" : globalEmployeeModule, "roleId" : 1 };

            var coreCommand = new CoreCommand();
            coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);

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


        <!--

        This is the add section
        <div id="codeSetupTabs">
        <ul>
        <li><a href="employeeAddGeneralInfo.jsp">General</a></li>
        <li><a href="employeeAddContacts.jsp">Contacts</a></li>
        <li><a href="employeeAddResidenceInfo.jsp">Residence</a></li>
        <li><a href="employeeAddFamily.jsp">Family</a></li>
        <li><a href="employeeAddQualification.jsp">Qualification</a></li> -- we have an issue here
        <li><a href="employeeAddMembership.jsp">Membership</a></li>
        <li><a href="employeeAddExpertise.jsp">Expertise</a></li>
        <li><a href="employeeAddEmploymentInfo.jsp">Employment</a></li>
        </ul>
        </div>
        -->