package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class landingpage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(2);
    _jspx_dependants.add("/includes/header.html");
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
      out.write("        <title>appCore Landing Page</title>\r\n");
      out.write("        </head>\r\n");
      out.write("        <body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <link href=\"css/header.css\" media=\"screen\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("        <link href=\"css/default.css\" media=\"screen\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("        <link href=\"css/personnel.css\" media=\"screen\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("        <link href=\"css/landingpage.css\" media=\"screen\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\r\n");
      out.write("\t    <link rel=\"stylesheet\" href=\"css/fontelloIndex.css\"><!--[if IE 7]>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/fontello-ie7.css\"><![endif]-->\r\n");
      out.write("\r\n");
      out.write("        <script language=\"javascript\" src=\"js/jquery-1.7.2.min.js\"></script>\r\n");
      out.write("        <script language=\"javascript\" src=\"js/carousel.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        ");
      out.write("<div class=\"navbar navbar-top class\" id=\"header\">\r\n");
      out.write("    <div class=\"navbar-inner\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <a class=\"brand airbnb\" href=\"/\">appCore</a>\r\n");
      out.write("\r\n");
      out.write("            <ul class=\"nav logged-out\">\r\n");
      out.write("                <li><a href=\"personnelControlPanel.jsp\"><i class=\"icon-home\"></i></a></li>\r\n");
      out.write("                </li>\r\n");
      out.write("            </ul>\r\n");
      out.write("\r\n");
      out.write("            <ul class=\"nav logged-in\">\r\n");
      out.write("                <li class=\"dropdown\">\r\n");
      out.write("                    <a href=\"javascript:void(0)\" class=\"dropdown-toggle\">\r\n");
      out.write("                        <i class=\"user\"></i>\r\n");
      out.write("                        Hi, <span class=\"value_name\">User</span>! <b class=\"caret\"></b>\r\n");
      out.write("                    </a>\r\n");
      out.write("                    <ul class=\"dropdown-menu\">\r\n");
      out.write("                        <li><a href=\"/home/dashboard\">Dashboard</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <a href=\"/rooms\">\r\n");
      out.write("                                <span style=\"display: none;\" class=\"singular\">Your Listing</span>\r\n");
      out.write("                                <span class=\"plural\">Your Listings</span>\r\n");
      out.write("                            </a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li><a href=\"/trips/upcoming\">Your Trips</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li class=\"divider\">\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li><a href=\"/users/show\">Profile</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li><a href=\"/account\">Account</a></li>\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <a>Log Out</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("\r\n");
      out.write("                </li>\r\n");
      out.write("                <li class=\"divider-vertical\">\r\n");
      out.write("                </li>\r\n");
      out.write("                <li><a href=\"/home/inbox\"><i class=\"mail\">Mail</i><i class=\"alert-count fade\">0</i></a>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li class=\"divider-vertical\">\r\n");
      out.write("                </li>\r\n");
      out.write("                <li class=\"button_wish_list\"><a href=\"/wishlists\"><i class=\"heart\">0</i> Wish Lists</a>\r\n");
      out.write("                </li>\r\n");
      out.write("            </ul>\r\n");
      out.write("\r\n");
      out.write("            <ul class=\"nav pull-right\">\r\n");
      out.write("                <li class=\"dropdown\">\r\n");
      out.write("                    <a href=\"javascript:void(0)\" class=\"dropdown-toggle help-toggle\">\r\n");
      out.write("\r\n");
      out.write("                    </a>\r\n");
      out.write("                    <ul class=\"dropdown-menu help-dropdown\">\r\n");
      out.write("                        <li class=\"nav-header\">Need help on this page? <a\r\n");
      out.write("                                class=\"lighter small right unstyled help-center-link hidden\" href=\"/help\">Visit the Help\r\n");
      out.write("                            Center</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li class=\"loading\"></li>\r\n");
      out.write("                        <li class=\"all_faqs mt10 hidden\"><a href=\"/help/topic/hosting\">See all FAQs</a></li>\r\n");
      out.write("                        <li class=\"nav-custom blue hidden\">\r\n");
      out.write("                            <form method=\"get\" action=\"/help/search\" accept-charset=\"UTF-8\">\r\n");
      out.write("                                <div style=\"margin:0;padding:0;display:inline\"><input type=\"hidden\" value=\"?\"\r\n");
      out.write("                                                                                      name=\"utf8\"></div>\r\n");
      out.write("                                <input type=\"text\" role=\"textbox\" placeholder=\"Search Help\" name=\"q\" id=\"q\"\r\n");
      out.write("                                       class=\"search-input\">\r\n");
      out.write("                                <button class=\"btn blue only-icon\" type=\"submit\">\r\n");
      out.write("                                    <i class=\"icon-search\"></i>\r\n");
      out.write("                                </button>\r\n");
      out.write("                            </form>\r\n");
      out.write("                        </li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </li>\r\n");
      out.write("\r\n");
      out.write("                <li class=\"usernamePlacement\" data-bind=\"visible : username != undefined\"><i class=\"icon-user\"></i></li>\r\n");
      out.write("                <li class=\"usernamePlacement\" data-bind=\"text : username\"></li>\r\n");
      out.write("                <li class=\"wishlist-nav divider-vertical\"></li>\r\n");
      out.write("                <li><a href=\"/login\" id=\"logoutLink\" onclick=\"return false;\">Log out</a></li>\r\n");
      out.write("                <li data-bind=\"visible : username != undefined\" class=\"wishlist-nav divider-vertical\"></li>\r\n");
      out.write("                <li><a href=\"../../help.jsp\" class=\"yellow btn\" id=\"list-your-space\">Help</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"logoutWindow\">\r\n");
      out.write("\r\n");
      out.write("</div>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"overview\">\r\n");
      out.write("        <div class=\"categories\">\r\n");
      out.write("        <ul>\r\n");
      out.write("        <li class=\"column first\">\r\n");
      out.write("        <a href=\"/appCore-personnel/appCore.Administration/view/admin.jsp\" class=\"block callout\">\r\n");
      out.write("        <img width=\"118\" height=\"114\" alt=\"\" src=\"images/camera.png\">\r\n");
      out.write("        <h2>Administration</h2>\r\n");
      out.write("        <p>Many your application users and configuration.\r\n");
      out.write("\r\n");
      out.write("        <span class=\"more\">Learn more</span>\r\n");
      out.write("        </p>\r\n");
      out.write("        </a>\r\n");
      out.write("        </li>\r\n");
      out.write("\r\n");
      out.write("        <li class=\"column\">\r\n");
      out.write("        <a href=\"/appCore-personnel/appCore.Personnel/views/personnelControlPanel.jsp\" class=\"block callout\"\r\n");
      out.write("        onclick=\"s_objectID=&quot;http://www.apple.com/iphone/from-the-app-store/social-networking.html_1&quot;;return\r\n");
      out.write("        this.s_oc?this.s_oc(e):true\">\r\n");
      out.write("        <img width=\"118\" height=\"114\" alt=\"\" src=\"images/camera.png\">\r\n");
      out.write("        <h2>Personnel</h2>\r\n");
      out.write("        <p>Update your company, branch, division and employee information.\r\n");
      out.write("        <span class=\"more\">Learn more</span>\r\n");
      out.write("        </p>\r\n");
      out.write("        </a>\r\n");
      out.write("        </li>\r\n");
      out.write("\r\n");
      out.write("        <li class=\"column\">\r\n");
      out.write("        <a href=\"/iphone/from-the-app-store/social-networking.html\" class=\"block callout\"\r\n");
      out.write("        onclick=\"s_objectID=&quot;http://www.apple.com/iphone/from-the-app-store/social-networking.html_1&quot;;return\r\n");
      out.write("        this.s_oc?this.s_oc(e):true\">\r\n");
      out.write("        <img width=\"118\" height=\"114\" alt=\"\" src=\"images/js.png\">\r\n");
      out.write("        <h2>Leave Management</h2>\r\n");
      out.write("        <p>Manage and apply leave and let the world know you're taking leave.\r\n");
      out.write("        <span class=\"more\">Learn more</span>\r\n");
      out.write("        </p>\r\n");
      out.write("        </a>\r\n");
      out.write("        </li>\r\n");
      out.write("\r\n");
      out.write("        <li class=\"column\">\r\n");
      out.write("        <a href=\"/iphone/from-the-app-store/social-networking.html\" class=\"block callout\"\r\n");
      out.write("        onclick=\"s_objectID=&quot;http://www.apple.com/iphone/from-the-app-store/social-networking.html_1&quot;;return\r\n");
      out.write("        this.s_oc?this.s_oc(e):true\">\r\n");
      out.write("        <img width=\"118\" height=\"114\" alt=\"\" src=\"images/apple.png\">\r\n");
      out.write("        <h2>Payroll</h2>\r\n");
      out.write("        <p>Process month employee salary and income tax.\r\n");
      out.write("        <span class=\"more\">Learn more</span>\r\n");
      out.write("        </p>\r\n");
      out.write("        </a>\r\n");
      out.write("        </li>\r\n");
      out.write("\r\n");
      out.write("        </ul>\r\n");
      out.write("        </div>\r\n");
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
      out.write("        </body>\r\n");
      out.write("        </html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
