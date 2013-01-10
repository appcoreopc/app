        <link href="../../css/employeeGroup.css" media="screen" rel="stylesheet" type="text/css" />
        <script language="javascript" src="../../js/viewmodal/configureEmployeeGroupViewModel.js"></script>
        <script language="javascript" src="../../js/viewmodal/companyHelper.js"></script>


        <script type="text/javascript">

        $(document).ready(function()
        {
            var vm = new ConfigureUserRightsViewModel(globalViewModel);
            ko.applyBindings(vm, document.getElementById("unitDiv"));
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
            <select id="allEmployeeGroupList" data-bind="options: allEmployeeGroupList, optionsText: 'name', optionsValue: 'name', optionsCaption : 'Choose an employee group' , value : currentlySelectedGroup">
            </select>
            </div>


            </div>

            <div class="formRow">
            &nbsp;
            </div>



            <div class="sectionalForm">
        <div class="leftSection">
        <div class="labelSectionBlock">Modules listed in system</div><div class="inputSectionList">

        <select multiple="true" id="employeeNotInGroupList" data-bind="options: employeeNotInGroupList, optionsText: 'name', optionsValue: 'nid', selectedOptions : selectionOfEmployee">
        </select>

        </div>
        </div>



            <div class="rightSection">

                <div class="labelSectionBlockRight">Modules assigned to a role</div><div class="inlineLabelSection">
                <select id="currentlyAssignedGroup" data-bind="options : employeesCurrentlyAssignedToAGroup, optionsText: 'name', optionsValue: 'nid', selectedOptions : selectionOfEmployeeToRemove " multiple="multiple">
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