    <script language="javascript" src="../../js/viewmodal/branchViewModel.js"></script>
        <script language="javascript" src="../../js/jquery.validationEngine-en.js"></script>

        <script type="text/javascript">

        var gridUrl = globalHostname + "/app/Core/BranchInfo";
        var branchForm = "branchForm";

        $(document).ready(function()
        {
        $("#" + branchForm).validationEngine();

        var vm = new BranchViewModel(1);
        var gridDataObject = vm.getView();

        var input = { "id" : coreBranchPage, "roleId" : 1 };
        var coreCommand = new CoreCommand();
        coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);
        });

        </script>

        <form id="branchForm">

        <div class="form">
        <div class="sectionalForm">
        <div class="leftSection">
        <div class="labelSection">Branch Code</div><span class='req'>*</span><div class="inputSection"><input
        class="validate[required, maxSize[10]]" type="text" id="BranchCode" name="BranchCode" placeholder="a new branch code"/></div>
        </div>

        <div class="rightSection">
        <div class="inlineLabelSection">Disabled </div><div class="inlineLabelSection"><input type="checkbox"
        id="Enabled" /></div>
        </div>
        </div>

        <div class="formRow">
        <div class="labelSection">Branch Name</div><span class='req'>*</span><div class="inputSection"><input
        type="text" class="validate[required, maxSize[80]]" id="BranchName" placeholder="a new branch name"/></div>
        </div>


        <div class="formRow">
        <div class="labelSection">Description</div><span class='req'>&nbsp;</span><div class="inputSection"><input
        type="text" class="validate[required, maxSize[80]]" id="Description" placeholder="description for new branch"/></div>
        </div>


        <div> <div class="maintenanceCommandSpace"></div>
        <div id="branchCommand" class="maintenanceCommand">
        </div>
        </div>
        <div>&nbsp;
        </div>
        <div>
        <div> Branch Info </div>
        <div id="gridBranch" style="height: 380px"></div>
        </div>
        </div>
        </form>