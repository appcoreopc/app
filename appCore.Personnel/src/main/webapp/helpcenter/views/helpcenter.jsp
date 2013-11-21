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
        <%@ include file="/includes/helpHeader.html" %>


        <script language="javascript" src="../../js/coreComboControl.js"></script>

        <link rel="stylesheet" href="../../css/dialogBox.css">
        <link rel="stylesheet" href="../../css/fontello.css"><!--[if IE 7]>
        <link rel="stylesheet" href="../../css/fontello-ie7.css"><![endif]-->

        <!-- for sidebar -->
        <script type="text/javascript" src="../../js/ui/jquery-ui-1.8.23.custom.js"></script>
        <script type="text/javascript" src="../../js/jquery.sidebar.js"></script>
        <script type="text/javascript" src="../../js/coreDefaultBinding.js"></script>

        <link rel="stylesheet" href="../../css/jquery-ui.css" />
        <link rel="stylesheet" href="../../css/personnelControlPanelOverride.css" />
        <link rel="stylesheet" href="../../css/helpcenter.css" />

        <style>

        .popover-title {
        background-color: #F7F7F7;
        border-bottom: 1px solid #EBEBEB;
        border-radius: 5px 5px 0 0;
        font-size: 14px;
        font-weight: normal;
        line-height: 18px;
        margin: 0;
        padding: 8px 14px;
        }

        .popover {
        background-clip: padding-box;
        background-color: #FFFFFF;
        border: 1px solid rgba(0, 0, 0, 0.2);
        border-radius: 6px 6px 6px 6px;
        box-shadow: 0 5px 10px rgba(0, 0, 0, 0.2);
        display: none;
        left: 0;
        max-width: 276px;
        padding: 1px;
        position: absolute;
        text-align: left;
        top: 0;
        white-space: normal;
        z-index: 1010;
        }

        .fade {
        opacity: 0;
        transition: opacity 0.15s linear 0s;
        }

        .fade.in {
        opacity: 1;
        }

        .support-Content {
        border: 1px solid #DADADA;
        border-radius: 3px 3px 3px 3px;
        margin: 2px;
        padding: 2px;
        }

        .cIndex-Status img {
        width: 48px;
        height: 48px;
        }

        #close {
        float: right;
        font-size: 0.85em;
        margin-right: 0;
        text-transform: uppercase;
        }

        .cIndex-Status span {
        font-size: 90%;
        }

        .cIndex-Name a:link,a:visited {
        color: #095197;
        text-decoration: none;
        font-size: 14px;
        }

        .cIndex-Actions a.btn-primary {
        background-color: #006DCC;
        background-image: linear-gradient(to bottom, #0088CC, #0044CC);
        background-repeat: repeat-x;
        border-color: rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.25);
        color: #FFFFFF;
        text-shadow: 0 -1px 0 rgba(0, 0, 0, 0.25);
        }

        .cIndex-Actions a.btn {
        -moz-border-bottom-colors: none;
        -moz-border-left-colors: none;
        -moz-border-right-colors: none;
        -moz-border-top-colors: none;
        background-color: #F5F5F5;
        background-image: linear-gradient(to bottom, #FFFFFF, #E6E6E6);
        background-repeat: repeat-x;
        border-color: #CCCCCC #CCCCCC #B3B3B3;
        border-image: none;
        border-radius: 4px 4px 4px 4px;
        border-style: solid;
        border-width: 1px;
        box-shadow: 0 1px 0 rgba(255, 255, 255, 0.2) inset, 0 1px 2px
        rgba(0, 0, 0, 0.05);
        color: #333333;
        cursor: pointer;
        display: inline-block;
        float: none;
        font-size: 14px;
        height: auto;
        line-height: 20px;
        margin-bottom: 0;
        padding: 4px 12px;
        text-align: center;
        text-shadow: 0 1px 1px rgba(255, 255, 255, 0.75);
        text-transform: none;
        vertical-align: middle;
        text-decoration: none;
        }

        .popover {
        position: absolute;
        top: 0;
        left: 0;
        z-index: 1010;
        display: none;
        max-width: 600px;
        padding: 1px;
        text-align: left;
        white-space: normal;
        background-color: #ffffff;
        border: 1px solid #ccc;
        border: 1px solid rgba(0, 0, 0, 0.2);
        -webkit-border-radius: 6px;
        -moz-border-radius: 6px;
        border-radius: 6px;
        -webkit-box-shadow: 0 5px 10px rgba(0, 0, 0, 0.2);
        -moz-box-shadow: 0 5px 10px rgba(0, 0, 0, 0.2);
        box-shadow: 0 5px 10px rgba(0, 0, 0, 0.2);
        -webkit-background-clip: padding-box;
        -moz-background-clip: padding;
        background-clip: padding-box;
        }

        .popover-content {

        }

        </style>


        <script type="text/javascript" src="../../js/corePopupMenu.js"></script>
        <script type="text/javascript" src="../../js/coreRecentItem.js"></script>

        <script language="javascript" src="../../js/coreGlobalViewModelSetup.js"></script>
        <script language="javascript" src="../../js/coreLogout.js"></script>
        <script language="javascript" src="../../js/coreSideBar.js"></script>
        <script language="javascript" src="../../js/coreMessageNotification.js"></script>

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
                $("#logoutLink").setupLogout();
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

