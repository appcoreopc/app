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

        <link rel="stylesheet" href="../../css/dialogBox.css">
        <link rel="stylesheet" href="../../css/fontello.css"><!--[if IE 7]>
        <link rel="stylesheet" href="../../css/fontello-ie7.css"><![endif]-->

        <!-- for sidebar -->
        <link rel="stylesheet" type="text/css" href="../../css/sidebar/dark-glass/sidebar.css" />
        <script type="text/javascript" src="../../js/ui/jquery-ui-1.8.23.custom.js"></script>
        <script type="text/javascript" src="../../js/jquery.sidebar.js"></script>

        <link rel="stylesheet" href="../../css/jquery-ui.css" />

        <script type="text/javascript" src="../../js/coreConfigureSetting.js"></script>

        <!-- for sidebar -->

        <script type="text/javascript" src="../../js/coreNotificationStatus.js"></script>

        <ul id="demo_menu1" >
        <li><a href="#" >jQuery</a></li>
        <li><a href="#" >Write</a></li>
        <li><a href="#" >Less</a></li>
        <li><a href="#" >Do</a></li>
        <li><a href="#" >More</a></li>
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

                $("ul#demo_menu1").sidebar();

                $("#companyDropDownList").change(function()
                {
                    globalCurrentCompanyId = $(this).find("option:selected").val();
                    globalViewModel.companyId(globalCurrentCompanyId);
                });

                $(document.body).configureSettings('configureSettings');

                $("#configureSetupAccordian2").accordion();

                $("#createEntityButton").click(function(){
                     var target = $(this);
                     var dialogHelper = new CoreDialog();
                     var dialogObject = { title : "Create +", "message" : "<i>Click on the form</i>"};
                     var dialogCreateMenu = dialogHelper.createPopupDialog(dialogObject, target);
                });
            });

            var currentPage = "globalPersonnelControlPanel.jsp";
            var ajaxCore = new AjaxCore();
            var request;
            var url = globalCompanyServiceUrl;
            preparePageForLoading("personnelSummaryWidget.jsp");

        </script>

        <div class="form dataEntry">
        <h1></h1>

        <div class="formRow">
        </div>

        <div class="formRow">
        </div>

        <div class="formRow">
        </div>


        <div class="formRowCompany">
        <div class="companyInfoDiv">Current company </div>
        <div class="companyInfoSelect"> <select id="companyDropDownList" class="company">
        </select><span class="createMany"><button id="createEntityButton" type="button" class="command">Create ..</button></span></div>
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




        <div id="configureSetupAccordian2" class="ui-accordion ui-widget ui-helper-reset ui-accordion-icons" role="tablist"><h3>CompanySetup</h3><div><p><a>Master Id Setup</a><a>Company</a><a>Branch</a><a>Division</a><a>Department</a><a>Section</a><a>Unit</a><a>EmployeeList</a><a>Industry Code</a><a>Gender Code</a><a>Race Code</a><a>Salutation Code</a><a>Religion Code</a><a>Nationality Code</a><a>Marital Status Code</a><a>Level Code</a><a>Field Of ExpertiseCode</a><a>Family Relation Type</a><a>Employee Group</a><a>Holiday Group</a><a>Currency</a><a>Configure Company</a><a>Job Setup</a><a>Configure Employee Group</a><a>Grade</a><a>Employment Type</a><a>HolidaySetup</a><a>Configure Employee Holiday</a></p></div><h3>Job</h3><div><p><a>Job Setup</a><a>Configure Employee Group</a><a>Grade</a><a>Employment Type</a><a>HolidaySetup</a><a>Configure Employee Holiday</a></p></div><h3>Holiday</h3><div><p><a>HolidaySetup</a><a>Configure Employee Holiday</a></p></div></div>d