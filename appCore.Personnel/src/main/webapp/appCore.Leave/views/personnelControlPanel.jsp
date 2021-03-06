    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

        <html>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        </head>
        <body>

        <link rel="stylesheet" type="text/css" href="../../css/sidebar/dark-glass/sidebar.css" />

        <%@ include file="../includes/css_includes.html" %>
        <%@ include file="../includes/js_includes.html" %>
        <%@ include file="/includes/header.html" %>

        <script language="javascript" src="../../js/coreComboControl.js"></script>

        <link rel="stylesheet" href="../../css/dialogBox.css">
        <link rel="stylesheet" href="../../css/fontello.css"><!--[if IE 7]>
        <link rel="stylesheet" href="../../css/fontello-ie7.css"><![endif]-->

        <!-- for sidebar -->
        <!-- <script type="text/javascript" src="..0/../js/ui/jquery-ui-1.8.23.custom.js"></script> -->

        <script type="text/javascript" src="../../js/jquery.sidebar.js"></script>
        <script type="text/javascript" src="../../js/coreDefaultBinding.js"></script>
        <script type="text/javascript" src="../../js/viewmodal/Leave/userEventCalendar.js"></script>

        <link rel="stylesheet" href="../../css/jquery-ui.css" />
        <link rel="stylesheet" href="../../css/personnelControlPanelOverride.css" />

        <script type="text/javascript" src="../../js/corePopupMenu.js"></script>
        <script type="text/javascript" src="../../js/coreRecentItem.js"></script>

        <script language="javascript" src="../../js/coreGlobalViewModelSetup.js"></script>
        <script language="javascript" src="../../js/coreLogout.js"></script>
        <script language="javascript" src="../../js/setupFullCalendar.js"></script>
        <script language="javascript" src="../../js/coreExecutor.js"></script>

        <!-- for sidebar -->

        <script type="text/javascript" src="../../js/coreNotificationStatus.js"></script>

        <ul id="recentItemSideBar">
        </ul>

        <script type="text/javascript">

            var coreLoadMask = new CoreLoadMask();
            coreLoadMask.bindAjaxEvent("../../images/ajax-loader.gif");

            var coreStatusNotification = new CoreStatusNotification();
            coreStatusNotification.createStatusNotification();

            if (sessionStorage.username == undefined || sessionStorage.username == null)
            {
                goToPage(globalHostname + "appCore-personnel/");
            }

            var globalViewModel = $(document).setupGlobalViewModel();

            $(document).ready(function()
            {
                var date = new Date();
                var d = date.getDate();
                var m = date.getMonth();
                var y = date.getFullYear();

                var opt =
                {
                    events:
                    [{
                    title:'All Day Event', start:new Date(y, m, 1)
                    }]
                };

                $("#viewPort").loadUserEventCalendar(opt);

                $("#logoutLink").setupLogout();

                $("ul#recentItemSideBar").sidebar();

                $("#companyDropDownList").change(function()
                {
                    globalCurrentCompanyId = $(this).find("option:selected").val();
                    globalViewModel.companyId(globalCurrentCompanyId);
                });

                globalViewModel.companyId.subscribe(function(newValue)
                {
                    $(".maintenanceCommand").empty();
                    getData(newValue);
                });

                $(document.body).configurePopupMenu('configureSettings', 'configureSetupView', globalLeaveMenuServiceUrl, globalViewModel.employeeRole(), "Navigate To ", 3);
                $(document.body).configurePopupMenu('adminSettings', 'configureAdminView', globalUserProfileServiceUrl, globalViewModel.employeeRole(), "Settings", 5);


                $("#createEntityButton").click(function(){
                     var target = $(this);
                     var dialogHelper = new CoreDialog();
                     var dialogObject = { title : "Create +", "message" : "<i>Click on the form</i>"};
                     var dialogCreateMenu = dialogHelper.createPopupDialog(dialogObject, target);
                });

                var currentPage = "globalPersonnelControlPanel.jsp";
                var ajaxCore = new AjaxCore();
                var request;
                var url = globalCompanyServiceUrl;

            });


        </script>

        <div class="form dataEntry">
        <h1></h1>

        <div class="formRow">
        </div>

        <div class="formRow">
        </div>

        <div class="formRow">
        </div>




        <div class="maintenanceControlCommand">

        </div>

        <div class="formRow">
        &nbsp;
        </div>

        <div id="viewPort">


        </div>
        </div>

        <%@include file="/includes/footer.html" %>

        </body>
        </html>

