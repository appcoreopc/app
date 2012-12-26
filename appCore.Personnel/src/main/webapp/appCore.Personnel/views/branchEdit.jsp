<script language="javascript" src="../../js/viewmodal/branchViewModel.js"></script>
<script type="text/javascript">

	$(document).ready(function() 
	{
		var value = globalViewModel.targetId();
        $("#" + branchForm).validationEngine();
				
			if (value != null) 
			{
					var ajaxCore = new AjaxCore();
					var request = ajaxCore.sendRequest(globalHostname + "/app/Core/Branch/get", { id : value }, "get");
				
					request.done(function(data)
					{
                        if (data == null)
                            return;

                        $("#Nid").val(data.nid);
                        $("#BranchCode").val(data.branchCode);
                        $("#BranchName").val(data.branchName);
                        $("#Description").val(data.description);
                        $("#Enabled").attr("checked", data.enabled);

                        var vm = new BranchViewModel(2, value, data);
                        var addPage = vm.getAddPage();
                        var centralPage = vm.getCentralPage();

                        var gridDataObject = vm.getView();
                        var input = { "id" : coreBranchPage, "roleId" : 1 };
                        var coreCommand = new CoreCommand();
                        coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);
				});
			}
 	});

 	
</script>


    <form id="branchForm">
    <div class="form">

    <div class="sectionalForm">
    <div class="leftSection"><input type="hidden" id="Nid" name="Nid" />
    <div class="labelSection">Branch Code</div><div class="inputSection"><input type="text" class="validate[required,
    maxSize[10]]" id="BranchCode" value="BranchCode"/></div>
    </div>

    <div class="rightSection">
    <div class="inlineLabelSection">Disabled</div><div class="inlineLabelSection"><input type="checkbox" id="Enabled"
    /></div>
    </div>
    </div>

    <div class="formRow">
    <div class="labelSection">Branch Name</div><div class="inputSection"><input type="text" class="validate[required,
    maxSize[80]]" id="BranchName" value="BranchName"/></div>
    </div>

    <div class="formRow">
    <div class="labelSection">Description</div><div class="inputSection"><input type="text" class="validate[required,
    maxSize[80]]" id="Description" value="Description"/></div>
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