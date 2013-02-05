package org.apache.jsp.appCore_Personnel.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class personnelControlPanel_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(4);
    _jspx_dependants.add("/appCore.Personnel/views/../includes/css_includes.html");
    _jspx_dependants.add("/appCore.Personnel/views/../includes/js_includes.html");
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
      out.write("\r\n");
      out.write("        <html>\r\n");
      out.write("        <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title></title>\r\n");
      out.write("        </head>\r\n");
      out.write("        <body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        ");
      out.write("<link href=\"../../css/header.css\" media=\"screen\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"../../css/default.css\" media=\"screen\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\r\n");
      out.write("<link href=\"../../css/personnel.css\" media=\"screen\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\r\n");
      out.write("<link href=\"../../css/validationEngine.jquery.css\" media=\"screen\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"../../css/template.css\" media=\"screen\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\r\n");
      out.write("<link href=\"../../kendo/styles/kendo.common.min.css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"../../kendo/styles/kendo.default.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        ");
      out.write("<script src=\"../../js/jquery-1.7.2.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script language=\"javascript\" src=\"../../js/knockoutjs/knockout-2.2.0.debug.js\"></script>\r\n");
      out.write("<script language=\"javascript\" src=\"../../js/globalViewModel.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script language=\"javascript\" src=\"../../js/carousel.js\"></script>\r\n");
      out.write("<script language=\"javascript\" src=\"../../js/ajaxCore.js\"></script>\r\n");
      out.write("<script language=\"javascript\" src=\"../../js/coreDialog.js\"></script>\r\n");
      out.write("<script language=\"javascript\" src=\"../../js/coreLoadMask.js\"></script>\r\n");
      out.write("<script language=\"javascript\" src=\"../../js/coreObjects.js\"></script>\r\n");
      out.write("<script language=\"javascript\" src=\"../../js/coreCommonFunction.js\"></script>\r\n");
      out.write("<script language=\"javascript\" src=\"../../js/appDefinition.js\"></script>\r\n");
      out.write("<script language=\"javascript\" src=\"../../js/coreGrid.js\"></script>\r\n");
      out.write("<script language=\"javascript\" src=\"../../js/coreMenu.js\"></script>\r\n");
      out.write("<script language=\"javascript\" src=\"../../js/coreCommand.js\"></script>\r\n");
      out.write("<script language=\"javascript\" src=\"../../js/coreListControl.js\"></script>\r\n");
      out.write("<script language=\"javascript\" src=\"../../js/initTree.js\"></script>\r\n");
      out.write("<script language=\"javascript\" src=\"../../js/jquery.validationEngine.js\"></script>\r\n");
      out.write("<script language=\"javascript\" src=\"../../js/jquery.validationEngine-en.js\"></script>\r\n");
      out.write("<script language=\"javascript\" src=\"../../js/ui/jquery-ui-1.8.23.custom.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script language=\"javascript\" src=\"../../js/viewmodal/knockoutBindersControl.js\"></script>\r\n");
      out.write("<script language=\"javascript\" src=\"../../js/coreSimpleGrid.js\"></script>\r\n");
      out.write("<script language=\"javascript\" src=\"../../js/simpleGrid.js\"></script>\r\n");
      out.write("<script language=\"javascript\" src=\"../../js/viewmodal/employeeHelper.js\"></script>\r\n");
      out.write("<script src=\"../../kendo/js/kendo.web.min.js\"></script>\r\n");
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
      out.write("        <script language=\"javascript\" src=\"../../js/coreComboControl.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"../../css/fontello.css\"><!--[if IE 7]>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"../../css/fontello-ie7.css\"><![endif]-->\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("        var coreLoadMask = new CoreLoadMask();\r\n");
      out.write("        coreLoadMask.bindAjaxEvent(\"../../images/ajax-loader.gif\");\r\n");
      out.write("\r\n");
      out.write("        if (sessionStorage.username == undefined || sessionStorage.username == null)\r\n");
      out.write("            {\r\n");
      out.write("                goToPage(\"http://localhost:8080/appCore-personnel/\");\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            try\r\n");
      out.write("            {\r\n");
      out.write("                var globalViewModel = new GlobalViewModel();\r\n");
      out.write("                globalViewModel.employeeRole(1);\r\n");
      out.write("                globalViewModel.companyId(1);\r\n");
      out.write("                globalViewModel.companyName(\"AppCoreDev\");\r\n");
      out.write("                globalViewModel.username = sessionStorage.username;\r\n");
      out.write("                ko.applyBindings(globalViewModel, document.getElementById(\"header\"));\r\n");
      out.write("            }\r\n");
      out.write("            catch(ex)\r\n");
      out.write("            {\r\n");
      out.write("                console.log(ex);\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            $(document).ready(function()\r\n");
      out.write("            {\r\n");
      out.write("                $(\"#companyDropDownList\").change(function()\r\n");
      out.write("                {\r\n");
      out.write("                    globalCurrentCompanyId = $(this).find(\"option:selected\").val();\r\n");
      out.write("                    globalViewModel.companyId(globalCurrentCompanyId);\r\n");
      out.write("                });\r\n");
      out.write("            });\r\n");
      out.write("\r\n");
      out.write("            var currentPage = \"globalPersonnelControlPanel.jsp\";\r\n");
      out.write("            var ajaxCore = new AjaxCore();\r\n");
      out.write("            var request;\r\n");
      out.write("            var url = globalCompanyServiceUrl;\r\n");
      out.write("            preparePageForLoading(\"personnelSummaryWidget.jsp\");\r\n");
      out.write("\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"form dataEntry\">\r\n");
      out.write("        <h1></h1>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("        <div class=\"companyInfoDiv\"><img src=\"../../images/company.png\"> Current company </div> <select id=\"companyDropDownList\" class=\"company\">\r\n");
      out.write("        </select>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"maintenanceControlCommand\">\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("        &nbsp;\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div id=\"viewPort\">\r\n");
      out.write("\r\n");
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
