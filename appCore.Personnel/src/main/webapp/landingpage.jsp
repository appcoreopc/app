    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>appCore Landing Page</title>
        </head>
        <body>



        <link href="css/header.css" media="screen" rel="stylesheet" type="text/css" />
        <link href="css/default.css" media="screen" rel="stylesheet" type="text/css" />
        <link href="css/personnel.css" media="screen" rel="stylesheet" type="text/css" />
        <link href="css/landingpage.css" media="screen" rel="stylesheet" type="text/css" />

	    <link rel="stylesheet" href="css/fontelloIndex.css"><!--[if IE 7]>
        <link rel="stylesheet" href="css/fontello-ie7.css"><![endif]-->

        <script language="javascript" src="js/jquery-1.7.2.min.js"></script>
        <script language="javascript" src="js/carousel.js"></script>

        <%@ include file="includes/header.html" %>



        <div class="landingView">




        <div class="overview">
        <div class="categories">
        <ul>
        <li class="column first">
        <a href="/appCore-personnel/appCore.Administration/view/admin.jsp" class="block callout">
        <i class="icon-wrench-2"></i>
        <h2>Administration</h2>
        <p>Manage your application users and configuration.

        <span class="more">Learn more</span>
        </p>
        </a>
        </li>

        <li class="column">
        <a href="/appCore-personnel/appCore.Personnel/views/personnelControlPanel.jsp" class="block callout"
        onclick="s_objectID=&quot;http://www.apple.com/iphone/from-the-app-store/social-networking.html_1&quot;;return
        this.s_oc?this.s_oc(e):true">
        <i class="icon-users"></i>
        <h2>Personnel</h2>
        <p>Update your company, branch, division and employee information.
        <span class="more">Learn more</span>
        </p>
        </a>
        </li>

        <li class="column">
        <a href="/iphone/from-the-app-store/social-networking.html" class="block callout"
        onclick="s_objectID=&quot;http://www.apple.com/iphone/from-the-app-store/social-networking.html_1&quot;;return
        this.s_oc?this.s_oc(e):true">
        <i class="icon-calendar"></i>
        <h2>Leave Management</h2>
        <p>Manage and apply leave and let the world know you're taking leave.
        <span class="more">Learn more</span>
        </p>
        </a>
        </li>

        <li class="column">
        <a href="/iphone/from-the-app-store/social-networking.html" class="block callout"
        onclick="s_objectID=&quot;http://www.apple.com/iphone/from-the-app-store/social-networking.html_1&quot;;return
        this.s_oc?this.s_oc(e):true">
        <i class="icon-money"></i>
        <h2>Payroll</h2>
        <p>Process month employee salary and income tax.
        <span class="more">Learn more</span>
        </p>
        </a>
        </li>

        </ul>
        </div>
        </div>



        </div>



        <%@ include file="includes/footer.html" %>
        </body>
        </html>


