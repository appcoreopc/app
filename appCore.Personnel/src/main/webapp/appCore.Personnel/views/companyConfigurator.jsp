    <link href="../../css/employeeGroup.css" media="screen" rel="stylesheet" type="text/css" />
        <script language="javascript" src="../../js/viewmodal/companyConfiguratorViewModel.js"></script>
        <script language="javascript" src="../../js/viewmodal/companyHelper.js"></script>
        <script language="javascript" src="../../js/jstree/jquery.jstree.js"></script>

        <script type="text/javascript">

        $(document).ready(function()
        {
        try
        {
        var vm = new CompanyConfiguratorViewModel(globalViewModel);
        ko.applyBindings(vm, document.getElementById("configureEmployeeGroupForm"));
        }
        catch (ex)
        {
        console.log(ex)
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
        <span class="labelSection">Division Name</span>
        <span class="inputSectionForm"><input type="text" data-bind="value : $root.nodeTitle" placeholder="info
        type"/></span>
        </span>
        </div>

        <div class="formRowList">
        <span class='columnDivider'>
        <span class="labelSection">Description</span></span>
        <span class="inputSectionForm">
        <input type="text" data-bind="value : $root.nodeTitle" placeholder="new description"/></span>
        </span>
        </div>



        <div class="formRow">
        <span class='columnDivider'>
        <span class="labelSection"></span>
        <span class="inputSectionForm"><button id="addBtn" class="command" type="button">Save</button><button id="addBtn" class="command" type="button">Cancel</button></span>
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
        <span class="labelSection">Department Name</span>
        <span class="inputSectionForm"><input type="text" data-bind="value : $root.nodeTitle" placeholder="info
        type"/></span>
        </span>

        </div>

        <div class="formRowList">

        <span class='columnDivider'>
        <span class="labelSection">Description</span></span>
        <span class="inputSectionForm">
        <input type="text" data-bind="value : $root.nodeTitle" placeholder="new description"/></span>
        </span>

        </div>

        <div class="formRow">

        <span class='columnDivider'>
        <span class="labelSection"></span>
        <span class="inputSectionForm"><button id="addBtn" class="command" type="button">Save</button><button id="addBtn" class="command" type="button">Cancel</button></span>
        <span class="inputSectionForm"></span>
        </span>

        </div>



        </script>
