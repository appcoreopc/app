    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

        <html>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        </head>
        <body>


        <%@ include file="../includes/css_includes.html" %>
        <%@ include file="../includes/js_includes.html" %>
        <%@ include file="/includes/header.html" %>

        <script language="javascript" src="../../js/coreComboControl.js"></script>

        <link rel="stylesheet" href="../../css/fontello.css"><!--[if IE 7]>
        <link rel="stylesheet" href="../../css/fontello-ie7.css"><![endif]-->

        <script type="text/javascript">

        var coreLoadMask = new CoreLoadMask();
        coreLoadMask.bindAjaxEvent("../../images/ajax-loader.gif");

        if (sessionStorage.username == undefined || sessionStorage.username == null)
            {
                goToPage("http://localhost:8080/appCore-personnel/");
            }

            try
            {
                var globalViewModel = new GlobalViewModel();
                globalViewModel.employeeRole(1);
                globalViewModel.companyId(1);
                globalViewModel.companyName("AppCoreDev");
                globalViewModel.username = sessionStorage.username;
                ko.applyBindings(globalViewModel, document.getElementById("header"));
            }
            catch(ex)
            {
                console.log(ex);
            }

            $(document).ready(function()
            {
                $("#companyDropDownList").change(function()
                {
                    globalCurrentCompanyId = $(this).find("option:selected").val();
                    globalViewModel.companyId(globalCurrentCompanyId);
                });
            });

            var currentPage = "globalPersonnelControlPanel.jsp";
            var ajaxCore = new AjaxCore();
            var request;
            var url = globalCompanyServiceUrl;
            preparePageForLoading("personnelSummaryWidget.jsp");

        </script>

        <div class="form dataEntry">
        <h1>My Page</h1>

        <div class="formRow">

        </div>

        <div class="formRow">
        <div class="companyInfoDiv"><img src="../../images/company.png"> Current company </div> <select id="companyDropDownList" class="company">
        </select>


        </div>


        <div class="maintenanceControlCommand">

        </div>

        <div class="formRow">
        &nbsp;

        </div>

        <div id="viewPort">

        </div>
        </div>

        <%@ include file="/includes/footer.html" %>

        </body>
        </html>