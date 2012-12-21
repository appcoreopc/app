    <link rel="stylesheet" href="../../css/fontelloCustom.css"><!--[if IE 7]>
        <link rel="stylesheet" href="../../css/fontello-ie7.css"><![endif]-->


        <script language="javascript" src="../../js/coreComboControl.js"></script>

        <script type="text/javascript">

        var url = globalCompanyListUrl;

        var companyDataObjects = {
        "url" : url,
        "targetControlId" : "companyDropDownList",
        "data" : null,
        "key" : "nid",
        "list" : "companyList",
        "text" : "companyCode"
        };

        var comboControl = new ComboControl();
        comboControl.createControl(companyDataObjects);

        var branchUrl = globalBranchSummaryUrl + globalViewModel.companyId();

        var branchData = {
        "url" : branchUrl,
        "icon" : "icon-th-large-1",
        "targetControlId" : "viewPort",
        "data" : null,
        "key" : "nid",
        "text" : "branchCode",
        "title" : "Branch",
        "list" : "listBranch",
        "clickControlId" : "aBranchAdd",
        "clickCode" : function()
        {
        preparePageForLoading("branch.jsp");
        }
        };

        var divisionUrl = globalDivisionSummaryUrl + globalViewModel.companyId();

        var divisionData = {
        "url" : divisionUrl,
        "icon" : "icon-th-large-1",
        "targetControlId" : "viewPort",
        "data" : null,
        "key" : "nid",
        "text" : "divisionCode",
        "title" : "Division",
        "list" : "listDivision",
        "clickControlId" : "aDivisionAdd",
        "clickCode" : function()
        {
        preparePageForLoading("division.jsp");
        }
        };

        var unitUrl = globalHostname + "/app/Core/Division/getSummary?id=" + globalCurrentCompanyId;

        var unitData = {
        "url" : unitUrl,
        "icon" : "icon-th-large-1",
        "targetControlId" : "viewPort",
        "data" : null,
        "key" : "nid",
        "text" : "divisionCode",
        "title" : "Unit",
        "list" : "listDivision",
        "clickControlId" : "aUnitAdd",
        "clickCode" : function()
        {
        preparePageForLoading("unit.jsp");
        }
        };

        var departmentUrl = globalHostname + "/app/Core/Division/getSummary?id=" + globalCurrentCompanyId;

        var departmentData = {
        "url" : departmentUrl,
        "icon" : "icon-th-large-1",
        "targetControlId" : "viewPort",
        "data" : null,
        "key" : "nid",
        "text" : "divisionCode",
        "title" : "Department",
        "list" : "listDivision",
        "clickControlId" : "aDepartmentAdd",
        "clickCode" : function()
        {
        preparePageForLoading("department.jsp");
        }
        };


        var widget = new WidgetCommandControl();
        widget.createControl(branchData);
        widget.createControl(divisionData);
        //widget.createControl(unitData);
        //widget.createControl(departmentData);

        </script>

