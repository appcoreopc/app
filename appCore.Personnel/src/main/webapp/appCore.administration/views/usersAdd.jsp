        <link href="../../css/company.css" media="screen" rel="stylesheet" type="text/css" />

        <script language="javascript" src="../../js/viewmodal/Administration/usersAddEditViewModel.js"></script>

        <script type="text/javascript">

        $(document).ready(function()
        {
                $("#userForm").validationEngine();
                var vm;

                $.when(init()).done(bind());

                function init()
                {
                    var gridDataObject;

                    if (globalViewModel != undefined && globalViewModel.targetId() != null)
                    {
                        vm = new UsersAddEditViewModel(coreModeEdit, globalViewModel);
                        gridDataObject = vm.getView();
                    }
                    else
                    {
                        vm = new UsersAddEditViewModel(coreModeInsert, globalViewModel);
                        gridDataObject = vm.getView();
                    }

                    var input = { "id" : coreCompanyPage, "roleId" : globalViewModel.employeeRole() };
                    var coreCommand = new CoreCommand();
                    coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject, vm);
                }

                function bind()
                {
                    $("#userCodeSetupTabs").setupViewBinding(vm, globalViewModel);
                }

                var tab = $("#userCodeSetupTabs").tabs();
        });


        </script>

        <form id="userForm">

        <div id="userCodeSetupTabs">
        <ul>
        <li><a href="#companyGeneralInfo">General</a></li>
        <li><a href="#companyDetailInfo" data-bind="visible : $root.mode > 1">Manage Rights</a></li>
        </ul>

        <div id="companyGeneralInfo" class="formEntry">

        <div class="sectionalForm">
        <div class="leftSection">
        <div class="labelSectionBlock">Username</div><div class="inputSectionBlock"><input type="text" id="UserName"
        data-bind="value: userName" class="validate[required], maxSize[10]"/><i class="icon-tag-1"></i></div>
        </div>

        <div class="rightSection">
        <div class="inlineLabelSection"></div><div class="inlineLabelSection"></div>
        </div>
        </div>

        <div class="formRow">
        <div class="labelSectionBlock">Password</div><div class="inputSectionBlock"><input type="password" id="Password"
        data-bind="value: password" class="validate[required], maxSize[30]"/></div>
        </div>

        <div class="formRow">
        <div class="labelSectionBlock">Confirm password</div><div class="inputSectionBlock"><input type="password" id="ConfirmPassword"
        data-bind="value : confirmPassword" class="validate[required], maxSize[30]"/></div>
        </div>


        <div class="formRow">
        <div class="labelSectionBlock">Full Name</div><div class="inputSectionBlock"><input type="text" id="FullName"
        data-bind="value : fullName" /></div>
        </div>

        <div class="formRow">
        <div class="labelSectionBlock">Email</div><div class="inputSectionBlock"><input type="text" id="email"
        data-bind="value : email" /></div>
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