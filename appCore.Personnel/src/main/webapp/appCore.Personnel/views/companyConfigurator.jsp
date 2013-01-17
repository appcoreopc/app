    <link href="../../css/employeeGroup.css" media="screen" rel="stylesheet" type="text/css" />
        <script language="javascript" src="../../js/viewmodal/companyConfiguratorViewModel.js"></script>
        <script language="javascript" src="../../js/viewmodal/companyHelper.js"></script>
        <script language="javascript" src="../../js/jstree/jquery.jstree.js"></script>

        <script type="text/javascript">

        $(document).ready(function()
        {
            var vm = new CompanyConfiguratorViewModel(globalViewModel);
            ko.applyBindings(vm, document.getElementById("configureEmployeeGroupForm"));
        });

        </script>




        <form id="configureEmployeeGroupForm">

        <div>

        <input id="CreateBranch" type="button" data-bind="click : createBranch" style="display:block; float:left;"
        value="CreateBranch" /> &nbsp;
        <input id="CreateDivsion" type="button" data-bind="click : createDivision" style="display:block; float:left;"
        value="CreateDivision" /> &nbsp;
        <input id="CreateDepartment" type="button" data-bind="click : createDepartment" style="display:block; float:left;"
        value="CreateDepartment" /> &nbsp;
        <input id="CreateSection" type="button" data-bind="click : createSection" style="display:block; float:left;"
        value="CreateSection" /> &nbsp;
        <input id="CreateUnit" type="button" data-bind="click : createUnit" style="display:block; float:left;"
        value="CreateUnit" /> &nbsp;
        <input id="Delete" type="button" data-bind="click : deleteNode" style="display:block; float:left;" value="Delete"
        />&nbsp;
        </div>

        <br/>
        <br/>

        <div id="entityTree">

        </div>

        </form>