        <link href="../../css/themes/base/jquery.ui.all.css" media="screen" rel="stylesheet" type="text/css" />
        <link href="../../css/admin.css" media="screen" rel="stylesheet" type="text/css" />
        <script language="javascript" src="../../js/viewmodal/Administration/changePasswordViewModel.js"></script>
        <script language="javascript" src="../../js/viewmodal/Administration/userHelper.js"></script>

        <script type="text/javascript">

        $(document).ready(function()
        {
                $("#changePasswordForm").validationEngine();

                var vm;
                var gridDataObject;

                if (globalViewModel != undefined && globalViewModel.targetId() != null)
                {
                    vm = new ChangePasswordViewModel(globalViewModel);
                    gridDataObject = vm.getView();
                }
                else
                {
                    vm = new ChangePasswordViewModel(globalViewModel);
                    gridDataObject = vm.getView();
                }

                var input = { "id" : coreChangePasswordPage, "roleId" : globalViewModel.employeeRole() };
                var coreCommand = new CoreCommand();
                coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject, vm);
                $("#changePasswordForm").setupViewBinding(vm, globalViewModel);

                var tab = $("#userCodeSetupTabs").tabs();
        });

        </script>

        <form id="changePasswordForm">

        <div id="userCodeSetupTabs">
        <ul>
        <li><a href="#companyGeneralInfo">General</a></li>
        </ul>

        <div id="companyGeneralInfo" class="formEntry">


        <div class="formRow">
        <div class="labelSectionBlock">Old Password</div><div class="inputSectionBlock"><input type="password" id="OldPassword"
        data-bind="value: oldPassword" class="validate[required], maxSize[30]"/></div>
        </div>


        <div class="formRow">
        <div class="labelSectionBlock">New Password</div><div class="inputSectionBlock"><input type="password" id="NewPassword"
        data-bind="value: newPassword" class="validate[required], maxSize[30]"/></div>
        </div>

        <div class="formRow">
        <div class="labelSectionBlock">Confirm password</div><div class="inputSectionBlock"><input type="password" id="ConfirmPassword"
        data-bind="value : confirmPassword" class="validate[required], maxSize[30]"/></div>
        </div>

        </div>

        <div>

        <div class="formRow">
        <div class="labelSectionBlock"></div><div class="inputSectionBlock">

        <div id="passwordChangeCommand" class="adminButton">
            <button id="loginBtn" data-bind="click : updatePassword" type="button">Update</button>
            <button id="cancelBtn" data-bind="click : cancelUpdate" type="button">Cancel</button>
        </div>


        </div>
        </div>


        </div>
        <div>&nbsp;</div>

        </div>

        </form>