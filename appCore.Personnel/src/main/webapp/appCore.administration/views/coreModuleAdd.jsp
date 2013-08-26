    <link href="../../css/company.css" media="screen" rel="stylesheet" type="text/css" />
        <script language="javascript" src="../../js/viewmodal/Administration/coreModuleAddViewModel.js"></script>
        <script language="javascript" src="../../js/jquery.validationEngine-en.js"></script>

        <script type="text/javascript">

        var formName = "coreModuleForm";

        $(document).ready(function()
        {
            var vm;
            $.when(init()).done(bind());

            function init()
            {
                if (globalViewModel != undefined && globalViewModel.targetId() != null)
                {
                    vm = new CoreModuleInfoViewModel(coreModeEdit, globalViewModel);
                }
                else
                {
                    vm = new CoreModuleInfoViewModel(coreModeInsert, globalViewModel);
                }
            }

            function bind()
            {
                $("#coreModuleForm").setupViewBinding(vm, globalViewModel);
                $("#" + formName).validationEngine();
            }
        });

        </script>

        <form id="coreModuleForm">


        <div class="form">

        <div class="formMainContent">


        <div class="formRow">
        <div class="labelSectionBlockBold">Name</div>
        <span class='req'>&nbsp;</span>
        <div class="inputSectionBlock">
        <input type="text" id="name" data-bind="value : name" placeholder="name"/>
        </div>
        </div>


        <div class="formRow">
        <div class="labelSectionBlockBold">Description</div>
        <span class='req'>&nbsp;</span>
        <div class="inputSectionBlock">
        <input type="text" id="description" data-bind="value : description" placeholder="description"/>
        </div>
        </div>


        <div>
        <div class="maintenanceCommandSpace"></div>
        <div id="sectionCommand" class="maintenanceCommand">
        <button id="saveBtn" type="button" data-bind="visible : enableAdd || enableUpdate, click : updateData"
        class="command">Save</button>
        <button id="cancelBtn" type="button" data-bind="click : cancelUpdate" class="command">Cancel</button>
        </div>
        </div>

        </div>

        <div>
        &nbsp;
        </div>
        </div>


        </form>

