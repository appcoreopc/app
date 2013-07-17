        <link href="../../css/employeeGroup.css" media="screen" rel="stylesheet" type="text/css" />
        <link href="../../css/admin.css" media="screen" rel="stylesheet" type="text/css" />
        <script language="javascript" src="../../js/viewmodal/Administration/configureRoleRightsViewModel.js"></script>
        <script language="javascript" src="../../js/viewmodal/Administration/userHelper.js"></script>

        <script type="text/javascript">

        $(document).ready(function()
        {
            var vm = new ConfigureRoleRightsViewModel(globalViewModel);
            $("#configureRoleRight").setupViewBinding(vm, globalViewModel);
        });


        </script>

        <form id="configureRoleRight">

        <div class="form">
            <div class="sectionHead">Configure Resource Right</div>

        <div class="formRow">
        &nbsp;

        <div class="roleLabelSectionBlock">Role</div>

        <div class="inputSection">
        <select id="allEmployeeGroupList" data-bind="options: allRolesList, optionsText: 'rolename', optionsValue: 'rolename', optionsCaption : 'Choose a role' , value : currentlySelectedGroup">
        </select>
        </div>


        </div>

        <div class="formRow">
        &nbsp;
        </div>


        <div class="formRow">
        <div class="configureLabelSectionBlock">Assigned permissions</div>

        <div class="configureInputSectionBlock">
         <input type='checkbox' value='A' data-bind="checked : addPermission" /><span>Add</span>
         <input type='checkbox' value='U' data-bind="checked : updatePermission" /> <span>Update</span>
         <input type='checkbox' value='D' data-bind="checked : deletePermission" /> <span>Delete</span>
        </div>


        </div>


        <div class="formRow">
        &nbsp;
        </div>


        </div>


        <div class="sectionalForm">
        <div class="leftSection">
        <div class="configureLabelSectionBlock">Resources in system</div><div class="inputSectionList">

        <select multiple="true" id="moduleListedInSystem" data-bind="options: moduleNotInGroupList, optionsText: 'formName', optionsValue: 'nid', selectedOptions : selectionOfModule, event : { change : examinePermission } ">
        </select>

        </div>
        </div>


        <div class="rightSection">

        <div class="labelSectionBlockRight">Modules assigned to current role</div><div class="inlineLabelSection">
        <select multiple="true" id="currentlyAssignedGroup" data-bind="options: rightsCurrentlyAssignedToAGroup, optionsText: 'formName', optionsValue: 'nid', selectedOptions : selectionToRemove, event : { change : examinePermissionAllocatedModule }">
        </select>
        </div>

        </div>
        </div>

        <div class="formRow">
        &nbsp;
        </div>


        <div class="formRow">
        &nbsp;
        </div>

        <div>
        <div class="command"><button type="button" id="saveBtn" data-bind="click : updateData">Save Changes</button>
        <button type="button" id="assignToGroup" data-bind="click : assignToGroup">Assign To Group</button>
        <button type="button" id="removeFromGroup" data-bind="click : removeFromGroup">Remove From Group</button>
        <button type="button" id="cancelBtn" data-bind="click : cancelUpdate">Cancel</button>
        </div>
        </div>

        <div>&nbsp;</div>
        </div>
        </form>