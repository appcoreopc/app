    <script language="javascript" src="../../js/viewmodal/configureEmployeeGroupViewModel.js"></script>
        <script language="javascript" src="../../js/viewmodal/companyHelper.js"></script>


        <script type="text/javascript">

        $(document).ready(function()
        {
            var vm = new ConfigureEmployeeGroupViewModel(globalViewModel);
            ko.applyBindings(vm, document.getElementById("unitDiv"));
        });


        </script>

        <form id="configureEmployeeGroupForm">

        <div class="form">
        <div class="sectionalForm">
        </div>

        <div class="formRow">
        &nbsp;
        </div>

        <div class="sectionalForm">
        <div class="leftSection">
        <div class="labelSection">Employee Not Assigned To Group</div><div class="inputSection">

        <select multiple="true" data-bind="options: employeeNotInGroupList, optionsText: 'name', optionsValue: 'nid', selectedOptions : selectionOfEmployee">
        </select>

        </div>
        </div>

        <div class="rightSection">
        <div class="inlineLabelSection">Currently Selected Group</div><div class="inlineLabelSection">
        <select id="EmployeeGroup" data-bind="options: allEmployeeGroupList, optionsText: 'name', optionsValue: 'name', optionsCaption : 'Choose an employee group' , value : currentlySelectedGroup">
        </select>
        </div>
        </div>
        </div>

        <div class="formRow">
        &nbsp;
        </div>

        <div class="sectionalForm">
        <div class="leftSection">
        <div class="labelSection"></div><div class="inputSection">

        </div>
        </div>

        <div class="rightSection">
        <div class="inlineLabelSection">Employee Available In Group</div><div class="inlineLabelSection">
        <select id="AllocatedHoliday" data-bind="options : employeesCurrentlyAssignedToAGroup, optionsText: 'name', optionsValue: 'nid', selectedOptions : selectionOfEmployeeToRemove " multiple="multiple">
        </select>
        </div>
        </div>
        </div>

        <div class="formRow">
        &nbsp;
        </div>

        <div>
        <div class="command"><button type="button" id="saveBtn" data-bind="click : updateData">Save Changes</button>
        <button type="button" id="cancelBtn" data-bind="click : cancelUpdate">Cancel</button>
        <button type="button" id="assignToGroup" data-bind="click : assignToGroup">Assign To Group</button>
        <button type="button" id="removeFromGroup" data-bind="click : removeFromGroup">Remove From Group</button>
        </div>
        </div>

        <div>&nbsp;</div>
        </div>
        </form>