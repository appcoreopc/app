

        <link href="../../css/company.css" media="screen" rel="stylesheet" type="text/css" />


            <script language="javascript" src="../../js/viewmodal/Administration/roleAddEditViewModel.js"></script>
        <script type="text/javascript">

        $(document).ready(function()
        {

                $("#userForm").validationEngine();

                var vm;
                var gridDataObject;

                if (globalViewModel != undefined && globalViewModel.targetId() != null)
                {
                    vm = new RoleAddEditViewModel(coreModeEdit, globalViewModel);
                    gridDataObject = vm.getView();
                }
                else
                {
                    vm = new RoleAddEditViewModel(coreModeInsert, globalViewModel);
                    gridDataObject = vm.getView();
                }

                var input = { "id" : coreCompanyPage, "roleId" : globalViewModel.employeeRole() };
                var coreCommand = new CoreCommand();
                coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject, vm);
                ko.applyBindings(vm, document.getElementById("roleCodeSetupTabs"));

                var tab = $("#roleCodeSetupTabs").tabs();

        });


        </script>

        <form id="userForm">

        <div id="roleCodeSetupTabs">
        <ul>
        <li><a href="#companyGeneralInfo">General</a></li>
        <li><a href="#companyDetailInfo" data-bind="visible : $root.mode > 1">Manage Rights</a></li>
        </ul>

        <div id="companyGeneralInfo" class="formEntry">

        <div class="sectionalForm">
        <div class="leftSection">
        <div class="labelSectionBlock">Role Name</div><div class="inputSectionBlock"><input type="text" id="RoleName"
        data-bind="value: roleName" class="validate[required], maxSize[10]"/><i class="icon-tag-1"></i></div>
        </div>

        <div class="rightSection">
        <div class="inlineLabelSection"></div><div class="inlineLabelSection"></div>
        </div>
        </div>

        <div class="formRow">
        <div class="labelSectionBlock">Description</div><div class="inputSectionBlock"><input type="text" id="Description"
        data-bind="value: description" class="validate[required], maxSize[30]"/></div>
        </div>



        </div>

        <div>


        <div class="formRow">
        <div class="labelSectionBlock"></div><div class="inputSectionBlock">


        <div id="maintenanceCodeCommand" class="maintenanceCommand commandAlign">
        </div>


        </div>
        </div>


        </div>
        <div>&nbsp;</div>

        </div>

        </form>