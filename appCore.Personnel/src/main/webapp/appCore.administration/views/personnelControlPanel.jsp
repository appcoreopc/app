    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

        <html>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        </head>
        <body>


        <%@ include file="../includes/css_includes.html" %>
        <%@ include file="../includes/js_includes.html" %>
-        <%@ include file="/includes/adminHeader.html" %>

        <script language="javascript" src="../../js/viewmodal/Administration/adminGlobalViewModel.js"></script>
        <script language="javascript" src="../../js/coreComboControl.js"></script>

        <link rel="stylesheet" href="../../css/fontello.css"><!--[if IE 7]>
        <link rel="stylesheet" href="../../css/fontello-ie7.css"><![endif]-->

        <script type="text/javascript">

        var globalViewModel = new AdminGlobalViewModel();
        globalViewModel.userName(1);
        globalViewModel.userRole(1);

        $(document).ready(function()
        {
            //$("#companyDropDownList").change(function()
            //{
            //    globalCurrentCompanyId = $(this).find("option:selected").val();
            //    globalViewModel.companyId(globalCurrentCompanyId);
            //});
        });

        var currentPage = "globalPersonnelControlPanel.jsp";
        var ajaxCore = new AjaxCore();
        var request;
        var url = globalCompanyServiceUrl;

        preparePageForLoading("userList.jsp");

        </script>

        <div class="form dataEntry">

        <div class="formRow">
        &nbsp;
        </div>

        <div class="formRow">
        &nbsp;
        </div>



        <div class="formRow">
        <div> <!-- Current company --> </div>
        </div>

        <div class="formRow">
        <!-- <select id="companyDropDownList" class="company"> -->
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