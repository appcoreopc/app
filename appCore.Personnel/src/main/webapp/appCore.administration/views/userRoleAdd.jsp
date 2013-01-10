        <link href="../../css/themes/base/jquery.ui.all.css" media="screen" rel="stylesheet" type="text/css" />
        <link href="../../css/company.css" media="screen" rel="stylesheet" type="text/css" />

        <script language="javascript" src="../../js/viewmodal/Administration/UsersAddEditViewModel.js"></script>

        <script type="text/javascript">

        $(document).ready(function()
        {

                $("#userForm").validationEngine();

                var vm;
                var gridDataObject;

                if (globalViewModel != undefined && globalViewModel.targetId() != null)
                {
                    vm = new UsersAddEditViewModel(coreModeEdit, globalViewModel.targetId());
                    gridDataObject = vm.getView();
                }
                else
                {
                    vm = new UsersAddEditViewModel(coreModeInsert, globalViewModel.targetId());
                    gridDataObject = vm.getView();
                }

                var input = { "id" : coreCompanyPage, "roleId" : 1 };
                var coreCommand = new CoreCommand();
                coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject, vm);
                ko.applyBindings(vm, document.getElementById("companyCodeSetupTabs"));

                var tab = $("#companyCodeSetupTabs").tabs();

        });


        </script>

        <form id="userForm">

        <div id="companyCodeSetupTabs">
        <ul>
        <li><a href="#companyGeneralInfo">General</a></li>
        <li><a href="#companyDetailInfo" data-bind="visible : $root.mode > 1">Manage Rights</a></li>
        </ul>

        <div id="companyGeneralInfo" class="formEntry">

        <div class="sectionalForm">
        <div class="leftSection">
        <div class="labelSection">Role Name</div><div class="inputSection"><input type="text" id="UserName"
        data-bind="value: userName" class="validate[required], maxSize[10]"/><i class="icon-tag-1"></i></div>
        </div>

        <div class="rightSection">
        <div class="inlineLabelSection"></div><div class="inlineLabelSection"></div>
        </div>
        </div>

        <div class="formRow">
        <div class="labelSection">Description</div><div class="inputSection"><input type="text" id="Password"
        data-bind="value: password" class="validate[required], maxSize[30]"/></div>
        </div>



        </div>


        <div id="companyDetailInfo">


        <div class="formRow">
        <div class="labelSection">Postcode</div><div class="inputSection"><input type="text" id="Postcode"
        class="validate[required]"/></div>
        </div>


        <div class="sectionalForm">
        <div class="leftSection">
        <div class="labelSection">Telephone</div><div class="inputSection"><input type="text" id="Telephone"
        class="validate[required]"/></div>
        </div>

        <div class="rightSection">
        <div class="inlineLabelSection">Fax</div><div class="inlineLabelSection"><input type="text" id="Fax"/></div>
        </div>
        </div>

        <div class="formRow">
        <div class="labelSection">Default Currency</div><div class="inputSection">
        <select id="Currency" name="Currency" class="validate[required]">
        </select>
        </div>
        </div>

        <div class="formRow">
        <div class="labelSection">Parent Company</div><div class="inputSection"><select id="ParentCompany"></select></div>
        </div>


        <div class="formRow">
        <div class="labelSection">Disabled</div><div class="inputSection"><input type="checkbox" id="Disabled"/></div>
        </div>

        <div>&nbsp;</div>

        </div>

        <div>


        <div class="formRow">
        <div class="labelSection"></div><div class="inputSection">


        <div id="maintenanceCodeCommand" class="maintenanceCommand">
        </div>


        </div>
        </div>


        </div>
        <div>&nbsp;</div>

        </div>

        </form>