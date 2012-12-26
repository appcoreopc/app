        <script language="javascript" src="../../js/viewmodal/branchInfoViewModel.js"></script>
        <script language="javascript" src="../../js/jquery.validationEngine-en.js"></script>


            <script type="text/html" id="branchAddTemplate">

            <div class="form">
            <div class="sectionalForm">
            <div class="leftSection">
            <div class="labelSection">Branch Code</div><span class='req'>*</span><div class="inputSection"><input
            class="validate[required, maxSize[10]]" type="text" data-bind="value: code" id="BranchCode" name="BranchCode"
            placeholder="a new branch code"/></div>
            </div>

            <div class="rightSection">
            <div class="inlineLabelSection">Disabled </div><div class="inlineLabelSection"><input type="checkbox"
            id="Enabled" data-bind="checked : disabled" /></div>
            </div>
            </div>

            <div class="formRow">
            <div class="labelSection">Branch Name</div><span class='req'>*</span><div class="inputSection"><input
            type="text" class="validate[required, maxSize[80]]" data-bind="value : name" id="BranchName" placeholder="a new branch name"/></div>
            </div>


            <div class="formRow">
            <div class="labelSection">Description</div><span class='req'>&nbsp;</span><div class="inputSection"><input
            type="text" class="validate[required, maxSize[80]]" id="Description" data-bind="value : description"
            placeholder="description for new branch"/></div>
            </div>


            <div> <div class="maintenanceCommandSpace"></div>
            <div id="branchCommand" class="maintenanceCommand">
            <button id="saveBtn" type="button" data-bind="visible : enableAdd || enableUpdate, click : updateData"
            class="command">Save</button>
            <button id="cancelBtn" type="button" data-bind="click : cancelUpdate" class="command">Cancel</button>
            </div>
            </div>
            <div>&nbsp;
            </div>
            <div>

            <div> Branch Info </div>


            </div>
            </div>


            </script>


            <script type="text/javascript">

            var branchForm = "branchForm";
            $(document).ready(function()
            {
                $("#" + branchForm).validationEngine();
                 var vm = new BranchInfoViewModel(globalViewModel);
                ko.applyBindings(vm, document.getElementById("branchForm"));

            });

            </script>


        <form id="branchForm">
            <div id="branchMaintenance" data-bind="template : { name : templateToUse} ">
        </form>