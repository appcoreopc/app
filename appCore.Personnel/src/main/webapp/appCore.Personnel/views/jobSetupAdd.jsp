        <link href="../../css/themes/base/jquery.ui.all.css" media="screen" rel="stylesheet" type="text/css" />
        <script language="javascript" src="../../js/viewmodal/jobSetupCommandViewModel.js"></script>

        <script type="text/javascript">

        $(document).ready(function()
        {

            if (globalViewModel.editMode() == coreModeEdit)
            {
                var ajaxCore = new AjaxCore();
                var targetEntity = { id : globalViewModel.targetId() };
                var request = ajaxCore.sendRequest(globalJobTypeGetUrl, targetEntity, "get");

                request.success(function(dataSource)
                {
                    var vm = new JobSetupCommandViewModel(globalViewModel.editMode(), dataSource, globalViewModel);
                    bindVM(vm);
                });
            }
            else
            {
                var vm = new JobSetupCommandViewModel(globalViewModel.editMode(), null, globalViewModel);
                bindVM(vm);
            }

            var tab = $("#codeSetupTabs").tabs({ cache : true});
        });

        function bindVM(vm)
        {
            try
            {
                var gridDataObject = vm.getCommandForForm();
                var input = { "id" : globalEmployeeModule, "roleId" : globalViewModel.employeeRole() };
                var coreCommand = new CoreCommand();
                coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);
                ko.applyBindings(vm, document.getElementById("jobSetupForm"));
            }
            catch (ex)
            {
                console.log(ex);
            }
        }

    </script>

    <form id="myform">


    <div class="form">

     <div id="jobSetupForm">
        <div class="sectionalForm">
        <div class="leftSection">
        <div class="viewLabelSection">Job</div><div class="inputSection">
        <input class="validate[required, maxSize[10]]" type="text" id="JobCode" name="JobCode" data-bind="value : jobCode"/></div>
        </div>

        <div class="rightSection">
        <div class="inlineLabelSection">Disabled </div><div class="inlineLabelSection"><input type="checkbox" id="Enabled" data-bind="checked : disabled" /></div>
        </div>
        </div>


        <div class="formRow">
            <div class="viewLabelSection">Job Title</div><span class="fieldSpacer"></span><div class="inputSection">
        <input type="text" id="JobTitle" class="validate[required, maxSize[80]]" data-bind="value : jobTitle"/></div>
        </div>

        <div class="formRow">
            <div class="viewLabelSection">Job Category</div><span class="fieldSpacer"></span><div class="inputSection">
        <input type="text" id="JobCategory" class="validate[required, maxSize[80]]" data-bind="value : jobCategory"/></div>
        </div>

        <div class="formRow">
        &nbsp;
        </div>
     </div>

        <div class="maintenanceCommand">
        </div>


        <div id="codeSetupTabs">
        <ul>
            <li><a href="jobDescriptionAdd.jsp">Job Description</a></li>
            <li><a href="jobSetupQualificationView.jsp">Qualification Requirement</a></li>
            <li><a href="jobSetupExperienceView.jsp">Experience Requirement</a></li>
            <li><a href="jobSetupSkillView.jsp">Skill Requirement</a></li>
        </ul>


    </div>

    </div>
  </form>