        <link href="../../css/employeeGroup.css" media="screen" rel="stylesheet" type="text/css" />
        <script language="javascript" src="../../js/viewmodal/Administration/configureUserRoleViewModel.js"></script>
        <script language="javascript" src="../../js/viewmodal/Administration/userHelper.js"></script>


        <script type="text/javascript">

        $(document).ready(function()
        {
            var vm = new ConfigureUserRoleViewModel(globalViewModel);
            ko.applyBindings(vm, document.getElementById("configureEmployeeGroupForm"));
        });


        </script>

        <form id="configureEmployeeGroupForm">

        <div class="form">
        <div class="sectionalForm">
        </div>

        <div class="formRow">
        &nbsp;

            <div class="labelSectionBlock">User Role</div>

            <div class="inputSection">
            <select id="allEmployeeGroupList" data-bind="options: allRolesList, optionsText: 'rolename', optionsValue: 'rolename', optionsCaption : 'Choose a role' , value : currentlySelectedGroup">
            </select>
            </div>


            </div>

            <div class="formRow">
            &nbsp;
            </div>


            <div class="sectionalForm">
        <div class="leftSection">
        <div class="labelSectionBlock">User listed in system</div><div class="inputSectionList">

        <select multiple="true" id="usersNotInGroupList" data-bind="options: usersNotInGroupList, optionsText: 'username', optionsValue: 'nid', selectedOptions : selectionOfEmployee">
        </select>

        </div>
        </div>



            <div class="rightSection">

                <div class="labelSectionBlockRight">Users assigned to current role</div><div class="inlineLabelSection">
                <select id="currentlyAssignedGroup" data-bind="options : usersCurrentlyAssignedToAGroup, optionsText: 'username', optionsValue: 'nid', selectedOptions : selectionOfEmployeeToRemove " multiple="multiple">
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