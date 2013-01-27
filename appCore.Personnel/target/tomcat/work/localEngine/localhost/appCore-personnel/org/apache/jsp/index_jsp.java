package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(2);
    _jspx_dependants.add("/includes/indexHeader.html");
    _jspx_dependants.add("/includes/footer.html");
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("    <!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("        <html>\r\n");
      out.write("        <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>AppCore</title>\r\n");
      out.write("        </head>\r\n");
      out.write("        <body>\r\n");
      out.write("\r\n");
      out.write("        <link href=\"css/header.css\" media=\"screen\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("        <link href=\"css/default.css\" media=\"screen\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("        <link href=\"css/login.css\" media=\"screen\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("        <link href=\"css/ui-darkness/jquery-ui-1.8.23.custom.css\" media=\"screen\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/fontelloIndex.css\"><!--[if IE 7]>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/fontello-ie7.css\"><![endif]-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <script language=\"javascript\" src=\"js/ajaxCore.js\"></script>\r\n");
      out.write("        <script language=\"javascript\" src=\"js/jquery-1.7.2.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <script language=\"javascript\" src=\"js/knockoutjs/knockout-2.2.0.debug.js\"></script>\r\n");
      out.write("        <script language=\"javascript\" src=\"js/globalViewModel.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <script language=\"javascript\" src=\"js/appDefinition.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <script language=\"javascript\" src=\"js/carousel.js\"></script>\r\n");
      out.write("        <script language=\"javascript\" src=\"js/coreDialog.js\"></script>\r\n");
      out.write("        <script language=\"javascript\" src=\"js/coreLoadMask.js\"></script>\r\n");
      out.write("        <script language=\"javascript\" src=\"js/coreCommonFunction.js\"></script>\r\n");
      out.write("        <script language=\"javascript\" src=\"js/userAuthenticator.js\"></script>\r\n");
      out.write("        <script language=\"javascript\" src=\"js/coreObjects.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        ");
      out.write("<div class=\"navbar navbar-top class\" id=\"header\">\r\n");
      out.write("  <div class=\"navbar-inner\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("      <a class=\"brand airbnb\" href=\"/\">appCore</a>\r\n");
      out.write("\r\n");
      out.write("      <ul class=\"nav logged-out\">\r\n");
      out.write("\r\n");
      out.write("      </li></ul>\r\n");
      out.write("\r\n");
      out.write("      <ul class=\"nav logged-in\">\r\n");
      out.write("        <li class=\"dropdown\">\r\n");
      out.write("          <a href=\"javascript:void(0)\" class=\"dropdown-toggle\">\r\n");
      out.write("            <i class=\"user\"></i>\r\n");
      out.write("            Hi, <span class=\"value_name\">User</span>! <b class=\"caret\"></b>\r\n");
      out.write("          </a>\r\n");
      out.write("          <ul class=\"dropdown-menu\">\r\n");
      out.write("            <li><a href=\"/home/dashboard\">Dashboard</a>\r\n");
      out.write("            </li><li>\r\n");
      out.write("              <a href=\"/rooms\">\r\n");
      out.write("                <span style=\"display: none;\" class=\"singular\">Your Listing</span>\r\n");
      out.write("                <span class=\"plural\">Your Listings</span>\r\n");
      out.write("              </a>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li><a href=\"/trips/upcoming\">Your Trips</a>\r\n");
      out.write("            </li><li class=\"divider\">\r\n");
      out.write("            </li><li><a href=\"/users/show\">Profile</a>\r\n");
      out.write("            </li><li><a href=\"/account\">Account</a>\r\n");
      out.write("            </li><li>\r\n");
      out.write("              <a>Log Out</a>\r\n");
      out.write("            </li>\r\n");
      out.write("          </ul>\r\n");
      out.write("\t\t  \r\n");
      out.write("        </li>\r\n");
      out.write("        <li class=\"divider-vertical\">\r\n");
      out.write("        </li><li><a href=\"/home/inbox\"><i class=\"mail\">Mail</i><i class=\"alert-count fade\">0</i></a>\r\n");
      out.write("        </li><li class=\"divider-vertical\">\r\n");
      out.write("        </li><li class=\"button_wish_list\"><a href=\"/wishlists\"><i class=\"heart\">0</i> Wish Lists</a>\r\n");
      out.write("      </li></ul>\r\n");
      out.write("\r\n");
      out.write("      <ul class=\"nav pull-right\">\r\n");
      out.write("        <li class=\"dropdown\">\r\n");
      out.write("          <a href=\"javascript:void(0)\" class=\"dropdown-toggle help-toggle\">\r\n");
      out.write("            \r\n");
      out.write("          </a>\r\n");
      out.write("          <ul class=\"dropdown-menu help-dropdown\">\r\n");
      out.write("            <li class=\"nav-header\">Need help on this page? <a class=\"lighter small right unstyled help-center-link hidden\" href=\"/help\">Visit the Help Center</a>\r\n");
      out.write("            </li><li class=\"loading\"></li>\r\n");
      out.write("            <li class=\"all_faqs mt10 hidden\"><a href=\"/help/topic/hosting\">See all FAQs</a></li>\r\n");
      out.write("            <li class=\"nav-custom blue hidden\">\r\n");
      out.write("              <form method=\"get\" action=\"/help/search\" accept-charset=\"UTF-8\">\r\n");
      out.write("                <div style=\"margin:0;padding:0;display:inline\"><input type=\"hidden\" value=\"?\" name=\"utf8\"></div>\r\n");
      out.write("                <input type=\"text\" role=\"textbox\" placeholder=\"Search Help\" name=\"q\" id=\"q\" class=\"search-input\">\r\n");
      out.write("                <button class=\"btn blue only-icon\" type=\"submit\">\r\n");
      out.write("                  <i class=\"icon-search\"></i>\r\n");
      out.write("                </button>\r\n");
      out.write("              </form>\r\n");
      out.write("            </li>\r\n");
      out.write("          </ul>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li class=\"divider-vertical\">\r\n");
      out.write("        </li><li class=\"dropdown\">\r\n");
      out.write("          <a href=\"javascript:void(0)\" class=\"dropdown-toggle\">\r\n");
      out.write("            <i class=\"globe\"></i> <span class=\"value_language\">English</span> <b class=\"caret\"></b>\r\n");
      out.write("          </a>\r\n");
      out.write("          <ul class=\"dropdown-menu language-dropdown\">\r\n");
      out.write("\r\n");
      out.write("        </li>\r\n");
      out.write("        <li class=\"divider-vertical\">\r\n");
      out.write("        </li><li class=\"dropdown\">\r\n");
      out.write("          <a href=\"javascript:void(0)\" class=\"dropdown-toggle\">\r\n");
      out.write("           <span class=\"value_currency\">MYR</span> <b class=\"caret\"></b>\r\n");
      out.write("          </a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li><a href=\"/rooms/new\" class=\"yellow btn\" id=\"list-your-space\">Help</a></li>\r\n");
      out.write("      </ul>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"logoutWindow\">\r\n");
      out.write("\r\n");
      out.write("</div>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("        $(document).ready(function()\r\n");
      out.write("        {\r\n");
      out.write("\r\n");
      out.write("        var coreLoadMask = new CoreLoadMask();\r\n");
      out.write("        coreLoadMask.bindAjaxEvent(\"images/ajax-loader.gif\");\r\n");
      out.write("\r\n");
      out.write("        function authenticateUserCallBack(msg)\r\n");
      out.write("        {\r\n");
      out.write("            if (msg.messageCode == 0)\r\n");
      out.write("            {\r\n");
      out.write("                //sessionStorage.setItem(\"username\", msg.username);\r\n");
      out.write("                //sessionStorage.setItem(\"role\", msg.employeeRole);\r\n");
      out.write("                sessionStorage.setItem(\"username\", \"jeremy1\");\r\n");
      out.write("                sessionStorage.setItem(\"role\", 1);\r\n");
      out.write("                sessionStorage.setItem(\"companyId\", 1);\r\n");
      out.write("                sessionStorage.setItem(\"companyName\", \"AppCore\");\r\n");
      out.write("                goToPage(globallandingPage);\r\n");
      out.write("            }\r\n");
      out.write("            else\r\n");
      out.write("            {\r\n");
      out.write("                $(\"#loginInfo\").addClass(\"errorMessage\");\r\n");
      out.write("                $(\"#loginInfo\").html(msg.messageDescription);\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("            $(\"#loginBtn\").click(function()\r\n");
      out.write("            {\r\n");
      out.write("                var authenticator = new UserAuthenticator();\r\n");
      out.write("                authenticator.authenticateUser($(\"#username\").val(),$(\"#password\").val(), authenticateUserCallBack);\r\n");
      out.write("            });\r\n");
      out.write("\r\n");
      out.write("            $(\"#password\").keypress(function(e)\r\n");
      out.write("            {\r\n");
      out.write("                var code = e.which;\r\n");
      out.write("                if(code == 13)\r\n");
      out.write("                    {\r\n");
      out.write("                        var authenticator = new UserAuthenticator();\r\n");
      out.write("                        authenticator.authenticateUser($(\"#username\").val(),$(\"#password\").val(), authenticateUserCallBack);\r\n");
      out.write("                }\r\n");
      out.write("            });\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"mainView\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"form dataEntry\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowSpacer\">\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow loginform\">\r\n");
      out.write("        <div class=\"labelSection\"></div><div class=\"inputSection\">\r\n");
      out.write("        <h1><i class=\"icon-lock-2\"></i> Sign In</h1> </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("        <div class=\"labelSection\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("        <div class=\"labelSection\">Username</div><div class=\"inputSection\"><input type=\"text\" id=\"username\"\r\n");
      out.write("        name=\"username\" value=\"\" placeholder=\"username\" /> </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("        <div class=\"labelSection\">Password</div><div class=\"inputSection\"><input type=\"password\" id=\"password\"\r\n");
      out.write("        name=\"password\" value=\"\" placeholder=\"password\" /></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("        <div class=\"labelSection\"></div><div class=\"inputSection\">\r\n");
      out.write("        <div id=\"loginInfo\" />\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"spacer\">\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"command\">\r\n");
      out.write("        <button type=\"button\" id=\"loginBtn\">Sign In</button>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowSpacer\">\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        ");
      out.write("<div class=\"container\">\r\n");
      out.write("      <div class=\"row\" id=\"footer\">\r\n");
      out.write("        <div class=\"span3\">\r\n");
      out.write("          <h5>Explore</h5>\r\n");
      out.write("          <ul class=\"footer-links unstyled\">\r\n");
      out.write("            <li><a href=\"/wishlists/airbnb_picks\">Products</a></li>\r\n");
      out.write("            <li><a href=\"/mobile\">Mobile</a></li>\r\n");
      out.write("            <li><a href=\"http://tv.airbnb.com\">Platform</a></li>\r\n");
      out.write("            <li><a href=\"/safety\">Complaints</a></li>\r\n");
      out.write("          </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"span3\">\r\n");
      out.write("          <h5>Worldwide</h5>\r\n");
      out.write("          <ul class=\"footer-links unstyled\">\r\n");
      out.write("            <li><a href=\"/new-york-city\">New York</a></li>\r\n");
      out.write("            <li><a href=\"/san-francisco\">San Francisco</a></li>\r\n");
      out.write("            <li><a href=\"/paris-france\">Paris</a></li>\r\n");
      out.write("          </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"span3\">\r\n");
      out.write("          <h5>Company</h5>\r\n");
      out.write("          <ul class=\"footer-links unstyled\">\r\n");
      out.write("            <li><a href=\"/about\">About</a></li>\r\n");
      out.write("            <li><a href=\"/jobs\">Jobs</a></li>\r\n");
      out.write("            <li><a href=\"http://blog.airbnb.com\">Blog</a></li>\r\n");
      out.write("            <li><a href=\"/help\">Help</a></li>\r\n");
      out.write("            <li><a href=\"/terms\">Terms &amp; Privacy</a></li>\r\n");
      out.write("          </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"span3\">\r\n");
      out.write("          <h5>Join us on</h5>\r\n");
      out.write("          <ul class=\"social-links unstyled\">\r\n");
      out.write("            <li><a class=\"twitter\" href=\"http://twitter.com/airbnb\">Twitter</a></li> \r\n");
      out.write("            <li><a class=\"facebook\" href=\"http://www.facebook.com/airbnb\">Facebook</a></li> \r\n");
      out.write("            <li><a class=\"google\" href=\"https://plus.google.com/115781326273917331624\">Google</a></li>\r\n");
      out.write("            <li><a class=\"youtube\" href=\"http://www.youtube.com/airbnb\">YouTube</a></li> \r\n");
      out.write("          </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div> \r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </body>\r\n");
      out.write("        </html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
