    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AppCore</title>
        </head>
        <body>

        <link href="css/header.css" media="screen" rel="stylesheet" type="text/css" />
        <link href="css/default.css" media="screen" rel="stylesheet" type="text/css" />
        <link href="css/login.css" media="screen" rel="stylesheet" type="text/css" />
        <link href="css/ui-darkness/jquery-ui-1.8.23.custom.css" media="screen" rel="stylesheet" type="text/css" />

        <link rel="stylesheet" href="css/fontelloIndex.css"><!--[if IE 7]>
        <link rel="stylesheet" href="css/fontello-ie7.css"><![endif]-->

        <script language="javascript" src="js/ajaxCore.js"></script>
        <script language="javascript" src="js/jquery-1.7.2.min.js"></script>

        <script language="javascript" src="js/knockoutjs/knockout-2.2.0.debug.js"></script>
        <script language="javascript" src="js/globalViewModel.js"></script>

        <script language="javascript" src="js/appDefinition.js"></script>

        <script language="javascript" src="js/carousel.js"></script>
        <script language="javascript" src="js/coreDialog.js"></script>
        <script language="javascript" src="js/coreLoadMask.js"></script>
        <script language="javascript" src="js/coreCommonFunction.js"></script>
        <script language="javascript" src="js/userAuthenticator.js"></script>
        <script language="javascript" src="js/coreObjects.js"></script>

        <script type="text/javascript" src="js/rsa/jsbn.js"></script>
        <script type="text/javascript" src="js/rsa/jsbn2.js"></script>
        <script type="text/javascript" src="js/rsa/rsa.js"></script>
        <script type="text/javascript" src="js/rsa/sha1.js"></script>

        <%@include file="includes/indexHeader.html" %>

        <script type="text/javascript">

        $(document).ready(function()
        {

        var coreLoadMask = new CoreLoadMask();
        coreLoadMask.bindAjaxEvent("images/ajax-loader.gif");

        function authenticateUserCallBack(msg)
        {
            if (msg.messageCode == 0)
            {
                console.log(msg);
                sessionStorage.setItem("username", msg.username);
                sessionStorage.setItem("roles", msg.roles);
                //sessionStorage.setItem("username", "jeremy1");
                //sessionStorage.setItem("role", 1);
                sessionStorage.setItem("companyId", 1);
                sessionStorage.setItem("companyName", "AppCore");
                goToPage(msg.landingPage);
            }
            else
            {
                $("#loginInfo").addClass("errorMessage");
                $("#loginInfo").html(msg.messageDescription);
            }
        }

            $("#loginBtn").click(function()
            {
                var authenticator = new UserAuthenticator();
                authenticator.authenticateUser($("#username").val(),$("#password").val(), authenticateUserCallBack);
            });

            $("#password").keypress(function(e)
            {
                var code = e.which;
                if(code == 13)
                {
                     var authenticator = new UserAuthenticator();
                     authenticator.authenticateUser($("#username").val(),$("#password").val(), authenticateUserCallBack);
                }
            });
        });

        </script>

        <div class="mainView">

        <div class="form dataEntry">

        <div class="formRowSpacer">
        </div>


        <div class="formRow loginform">
        <div class="labelSection"></div><div class="inputSection">
        <h1><i class="icon-lock-2"></i> Sign In</h1> </div>
        </div>


        <div class="formRow">
        <div class="labelSection"></div>
        </div>


        <div class="formRow">
        <div class="labelSection">Username</div><div class="inputSection"><input type="text" id="username"
        name="username" value="" placeholder="username" /> </div>
        </div>

        <div class="formRow">
        <div class="labelSection">Password</div><div class="inputSection"><input type="password" id="password"
        name="password" value="" placeholder="password" /></div>
        </div>

        <div class="formRow">
        <div class="labelSection"></div><div class="inputSection">
        <div id="loginInfo" />
        </div>
        </div>


        <div class="spacer">
        </div>
        <div class="command">
        <button type="button" id="loginBtn">Sign In</button>
        </div>
        </div>


        <div class="formRowSpacer">
        </div>


        </div>

        <%@ include file="includes/footer.html" %>

        </body>
        </html>