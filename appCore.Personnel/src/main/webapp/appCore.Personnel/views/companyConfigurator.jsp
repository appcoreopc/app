        <link href="../../css/employeeGroup.css" media="screen" rel="stylesheet" type="text/css" />
        <script language="javascript" src="../../js/viewmodal/companyConfiguratorViewModel.js"></script>
        <script language="javascript" src="../../js/viewmodal/companyHelper.js"></script>
        <script language="javascript" src="../../js/jstree/jquery.jstree.js"></script>
        <link href="../../css/dialogBox.css" media="screen" rel="stylesheet" type="text/css" />

        <script type="text/javascript">

        $(document).ready(function()
        {
            var vm;
            $.when(init()).done(bind());

            function init()
            {
                vm = new CompanyConfiguratorViewModel(globalViewModel);
            }

            function bind()
            {
                $("#configureEmployeeGroupForm").setupViewBinding(vm, globalViewModel);
            }

        });

        </script>


        <form id="configureEmployeeGroupForm">

        <div>

        <input id="CreateDivsion" type="button" data-bind="click : createDivision" style="display:block; float:left;"
        value="CreateDivision" /> &nbsp;
        <input id="CreateDepartment" type="button" data-bind="click : createDepartment" style="display:block;
        float:left;"
        value="CreateDepartment" /> &nbsp;
        <input id="CreateSection" type="button" data-bind="click : createSection" style="display:block; float:left;"
        value="CreateSection" /> &nbsp;
        <input id="CreateUnit" type="button" data-bind="click : createUnit" style="display:block; float:left;"
        value="CreateUnit" /> &nbsp;
        <input id="Delete" type="button" data-bind="click : deleteNode" style="display:block; float:left;"
        value="Delete"
        />&nbsp;
        </div>

        <br/>
        <br/>

        <div id="entityTree">

        </div>


        <div id="companyEntityEditForm">
        <div data-bind="template : { name : templateToUse } "> </div>
        </div>


        </form>


        <script type="text/html" id="emptyTemplate">
        <div class="emptyDiv"></div>
        </script>


        <script type="text/html" id="divisionInfoUpdateTemplate">

        <div class="formRowSpacer">
        </div>
        <div class="formRowSpacer">
        </div>
        <div class="formRowSpacer">
        </div>


        <div class="formRowList">
        <span class='columnDivider'>
        <span class="labelSection">Division Code</span>
        <span class="inputSectionForm"><input type="text" data-bind="value : $root.nodeCode" placeholder="division code"/></span>
        </span>
        </div>


        <div class="formRowList">
        <span class='columnDivider'>
        <span class="labelSection">Division Name</span></span>
        <span class="inputSectionForm">
        <input type="text" data-bind="value : $root.nodeName" placeholder="division name"/></span>
        </span>
        </div>


        <div class="formRowList">
        <span class='columnDivider'>
        <span class="labelSection">Division Description</span></span>
        <span class="inputSectionForm">
        <input type="text" data-bind="value : $root.nodeDescription" placeholder="division description"/></span>
        </span>
        </div>


        <div class="formRowList">
        <span class='columnDivider'>
        <span class="labelSection">Disabled</span></span>
        <span class="inputSectionForm">
        <input type="checkbox" data-bind="checked : $root.disabled" placeholder="disabled"/></span>
        </span>
        </div>



        <div class="formRow">
        <span class='columnDivider'>
        <span class="labelSection"></span>
        <span class="inputSectionForm">
            <button id="divisionSaveBtn" class="command" type="button" data-bind="click : saveDivision">Save</button>
            <button id="divisionCancelBtn" class="command" type="button">Cancel</button></span>
        <span class="inputSectionForm"></span>
        </span>

        </div>

        </script>



        <script type="text/html" id="departmentInfoUpdateTemplate">

        <div class="formRowSpacer">
        </div>
        <div class="formRowSpacer">
        </div>
        <div class="formRowSpacer">
        </div>



        <div class="formRowList">

        <span class='columnDivider'>
        <span class="labelSection">Department Code</span>
        <span class="inputSectionForm"><input type="text" data-bind="value : $root.nodeCode" placeholder="info
        type"/></span>
        </span>

        </div>

        <div class="formRowList">
        <span class='columnDivider'>
        <span class="labelSection">Department Name</span></span>
        <span class="inputSectionForm">
        <input type="text" data-bind="value : $root.nodeName" placeholder="new name"/></span>
        </span>
        </div>



        <div class="formRowList">
        <span class='columnDivider'>
        <span class="labelSection">Description</span></span>
        <span class="inputSectionForm">
        <input type="text" data-bind="value : $root.nodeDescription" placeholder="new description"/></span>
        </span>

        </div>


        <div class="formRowList">
        <span class='columnDivider'>
        <span class="labelSection">Disabled</span></span>
        <span class="inputSectionForm">
        <input type="checkbox" data-bind="checked : $root.disabled" placeholder="disabled"/></span>
        </span>
        </div>


        <div class="formRow">

        <span class='columnDivider'>
        <span class="labelSection"></span>
        <span class="inputSectionForm">
            <button id="departmentSaveBtn" class="command" type="button" data-bind="click : saveDepartment">Save</button>
            <button id="departmentCancelBtn" class="command" type="button">Cancel</button></span>
        <span class="inputSectionForm"></span>
        </span>

        </div>


        </script>









        <script type="text/html" id="sectionInfoUpdateTemplate">

        <div class="formRowSpacer">
        </div>
        <div class="formRowSpacer">
        </div>
        <div class="formRowSpacer">
        </div>



        <div class="formRowList">

        <span class='columnDivider'>
        <span class="labelSection">Section Code</span>
        <span class="inputSectionForm"><input type="text" data-bind="value : $root.nodeCode" placeholder="info
        type"/></span>
        </span>

        </div>

        <div class="formRowList">
        <span class='columnDivider'>
        <span class="labelSection">Section Name</span></span>
        <span class="inputSectionForm">
        <input type="text" data-bind="value : $root.nodeName" placeholder="new name"/></span>
        </span>
        </div>



        <div class="formRowList">
        <span class='columnDivider'>
        <span class="labelSection">Remark</span></span>
        <span class="inputSectionForm">
        <input type="text" data-bind="value : $root.nodeDescription" placeholder="new description"/></span>
        </span>

        </div>


        <div class="formRowList">
        <span class='columnDivider'>
        <span class="labelSection">Disabled</span></span>
        <span class="inputSectionForm">
        <input type="checkbox" data-bind="checked : $root.disabled" placeholder="disabled"/></span>
        </span>
        </div>


        <div class="formRow">

        <span class='columnDivider'>
        <span class="labelSection"></span>
        <span class="inputSectionForm">
            <button id="sectionSaveBtn" class="command" type="button" data-bind="click : saveSection">Save</button>
            <button id="sectionCancelBtn" class="command" type="button">Cancel</button></span>
        <span class="inputSectionForm"></span>
        </span>

        </div>

        </script>






        <script type="text/html" id="unitInfoUpdateTemplate">

        <div class="formRowSpacer">
        </div>
        <div class="formRowSpacer">
        </div>
        <div class="formRowSpacer">
        </div>



        <div class="formRowList">

        <span class='columnDivider'>
        <span class="labelSection">Unit Code</span>
        <span class="inputSectionForm"><input type="text" data-bind="value : $root.nodeCode" placeholder="info
        type"/></span>
        </span>

        </div>

        <div class="formRowList">
        <span class='columnDivider'>
        <span class="labelSection">Unit Name</span></span>
        <span class="inputSectionForm">
        <input type="text" data-bind="value : $root.nodeName" placeholder="new name"/></span>
        </span>
        </div>



        <div class="formRowList">
        <span class='columnDivider'>
        <span class="labelSection">Remark</span></span>
        <span class="inputSectionForm">
        <input type="text" data-bind="value : $root.nodeDescription" placeholder="new description"/></span>
        </span>

        </div>


        <div class="formRowList">
        <span class='columnDivider'>
        <span class="labelSection">Disabled</span></span>
        <span class="inputSectionForm">
        <input type="checkbox" data-bind="checked : $root.disabled" placeholder="disabled"/></span>
        </span>
        </div>

        <div class="formRow">

        <span class='columnDivider'>
        <span class="labelSection"></span>
        <span class="inputSectionForm">
                <button id="unitSaveBtn" class="command" type="button" data-bind="click : saveUnit">Save</button>
                <button id="unitCancelBtn" class="command" type="button">Cancel</button></span>
        <span class="inputSectionForm"></span>
        </span>

        </div>


        </script>












