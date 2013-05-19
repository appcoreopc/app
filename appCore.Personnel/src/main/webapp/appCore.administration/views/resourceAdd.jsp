        <link href="../../css/themes/base/jquery.ui.all.css" media="screen" rel="stylesheet" type="text/css" />
        <link href="../../css/company.css" media="screen" rel="stylesheet" type="text/css" />

        <script language="javascript" src="../../js/viewmodal/Administration/resourceAddEditViewModel.js"></script>

        <script type="text/javascript">

        $(document).ready(function()
        {

                $("#userForm").validationEngine();

                var vm;
                var gridDataObject;

                if (globalViewModel != undefined && globalViewModel.targetId() != null)
                {
                    console.log("edit mode");
                    vm = new ResourceAddEditViewModel(coreModeEdit, globalViewModel);
                    gridDataObject = vm.getView();
                }
                else
                {
                    vm = new ResourceAddEditViewModel(coreModeInsert, globalViewModel);
                    gridDataObject = vm.getView();
                }

                var input = { "id" : coreCompanyPage, "roleId" : globalViewModel.employeeRole() };
                var coreCommand = new CoreCommand();
                coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject, vm);
                ko.applyBindings(vm, document.getElementById("resourceCodeSetupTabs"));

                var tab = $("#resourceCodeSetupTabs").tabs();

        });


        </script>

        <form id="resourceForm">

        <div id="resourceCodeSetupTabs">
        <ul>
        <li><a href="#companyGeneralInfo">General</a></li>
        <li><a href="#companyDetailInfo" data-bind="visible : $root.mode > 1">Register Resource</a></li>
        </ul>

        <div id="companyGeneralInfo" class="formEntry">

        <div class="sectionalForm">
        <div class="leftSection">
        <div class="labelSectionBlock">Resource name</div><div class="inputSectionBlock"><input type="text" id="ResourceName"
        data-bind="value: resourceName" class="validate[required], maxSize[10]"/><i class="icon-tag-1"></i></div>
        </div>

        <div class="rightSection">
        <div class="inlineLabelSection"></div><div class="inlineLabelSection"></div>
        </div>
        </div>

        <div class="formRow">
        <div class="labelSectionBlock">Resource link</div><div class="inputSectionBlock"><input type="text" id="ResourceLink"
        data-bind="value: resourceLink" class="validate[required], maxSize[30]"/></div>
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