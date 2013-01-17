    <link href="../../css/employeeGroup.css" media="screen" rel="stylesheet" type="text/css" />
        <script language="javascript" src="../../js/viewmodal/Administration/configureRoleRightsViewModel.js"></script>
        <script language="javascript" src="../../js/viewmodal/Administration/userHelper.js"></script>

        <script type="text/javascript">

        $(document).ready(function()
        {
        var vm = new ConfigureRoleRightsViewModel(globalViewModel);
        ko.applyBindings(vm, document.getElementById("configureEmployeeGroupForm"));
        });


        </script>

        <form id="configureEmployeeGroupForm">

        <div class="form">
        <div class="sectionalForm">
        </div>

        <div class="formRow">
        &nbsp;

        <div class="labelSectionBlock">Role</div>

        <div class="inputSection">
        <select id="allEmployeeGroupList" data-bind="options: allRolesList, optionsText: 'rolename', optionsValue:
        'rolename', optionsCaption : 'Choose a role' , value : currentlySelectedGroup">
        </select>
        </div>


        </div>

        <div class="formRow">
        &nbsp;
        </div>


        <div class="sectionalForm">
        <div class="leftSection fixedWidth">
        <div class="labelSectionBlock">&nbsp;</div><div class="inputSectionList">
        Add/Update/Delete
        </div>
        </div>

        <div class="rightSection">

        <div class="labelSectionBlockRight"></div><div class="inlineLabelSection">
        <input type="checkbox" id="Add" />
        <input type="checkbox" id="Update" />
        <input type="checkbox" id="Delete" />
        </div>

        </div>
        </div>


        <div class="formRow">
        &nbsp;
        </div>


        </div>


        <div class="sectionalForm">
        <div class="leftSection">
        <div class="labelSectionBlock">Modules in system</div><div class="inputSectionList">

        <select multiple="true" id="moduleListedInSystem" data-bind="options: moduleNotInGroupList, optionsText:
        'formId', optionsValue: 'nid', selectedOptions : selectionOfModule">
        </select>

        </div>
        </div>


        <div class="rightSection">

        <div class="labelSectionBlockRight">Modules assigned to current role</div><div class="inlineLabelSection">
        <select id="currentlyAssignedGroup" data-bind="options : rightsCurrentlyAssignedToAGroup, optionsText:
        'formName', optionsValue: 'formId', selectedOptions : selectionOfEmployeeToRemove " multiple="multiple">
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