package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index3_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html PUBLIC \"-//`W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>AppCore</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<link href=\"css/header.css\" media=\"screen\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"css/default.css\" media=\"screen\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"css/personnel.css\" media=\"screen\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\r\n");
      out.write("<script language=\"javascript\" src=\"js/ajaxCore.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script src=\"kendo/content/shared/js/people.js\"></script>\r\n");
      out.write("<script src=\"kendo/js/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"kendo/js/kendo.dataviz.min.js\"></script>\r\n");
      out.write("<script src=\"kendo/js/kendo.web.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script src=\"kendo/js/kendo.treeview.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<link href=\"kendo/styles/kendo.common.min.css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"kendo/styles/kendo.default.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script language=\"javascript\" src=\"js/carousel.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<div class=\"navbar navbar-top class\" id=\"header\">\r\n");
      out.write("  <div class=\"navbar-inner\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("      <a class=\"brand airbnb\" href=\"/\">appCore</a>\r\n");
      out.write("\r\n");
      out.write("      <ul class=\"nav logged-out\">\r\n");
      out.write("       <li><a href=\"app_dev.php/HowItWork\">Home</a></li><li class=\"divider-vertical\"></li>\r\n");
      out.write("\t\t<li><a href=\"/signup_login\">My Account</a>\r\n");
      out.write("        </li><li class=\"divider-vertical\"></li><li><a href=\"/login\" id=\"logoutLink\" onclick=\"return false;\">Log out</a>\r\n");
      out.write("        </li><li class=\"wishlist-nav divider-vertical\">\r\n");
      out.write("        </li><li class=\"wishlist-nav\"><a href=\"/wishlists\"><i class=\"heart\">0</i>Common Tasks</a>\r\n");
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
      out.write("            <li class=\"nav-header\">Choose language\r\n");
      out.write("              </li><li data-locale=\"da\" id=\"language_selector_da\"><a href=\"javascript:void(0);\">Dansk</a></li>\r\n");
      out.write("              <li data-locale=\"de\" id=\"language_selector_de\"><a href=\"javascript:void(0);\">Deutsch</a></li>\r\n");
      out.write("              <li data-locale=\"es\" id=\"language_selector_es\"><a href=\"javascript:void(0);\">Español</a></li>\r\n");
      out.write("              <li data-locale=\"fr\" id=\"language_selector_fr\"><a href=\"javascript:void(0);\">Français</a></li>\r\n");
      out.write("              <li data-locale=\"it\" id=\"language_selector_it\"><a href=\"javascript:void(0);\">Italiano</a></li>\r\n");
      out.write("              <li data-locale=\"hu\" id=\"language_selector_hu\"><a href=\"javascript:void(0);\">Magyar</a></li>\r\n");
      out.write("              <li data-locale=\"pl\" id=\"language_selector_pl\"><a href=\"javascript:void(0);\">Polski</a></li>\r\n");
      out.write("              <li data-locale=\"pt\" id=\"language_selector_pt\"><a href=\"javascript:void(0);\">Português</a></li>\r\n");
      out.write("              <li data-locale=\"cs\" id=\"language_selector_cs\"><a href=\"javascript:void(0);\">Cetina</a></li>\r\n");
      out.write("              <li data-locale=\"ru\" id=\"language_selector_ru\"><a href=\"javascript:void(0);\">???????</a></li>\r\n");
      out.write("              <li data-locale=\"zh\" id=\"language_selector_zh\"><a href=\"javascript:void(0);\">??(??)</a></li>\r\n");
      out.write("              <li data-locale=\"ko\" id=\"language_selector_ko\"><a href=\"javascript:void(0);\">???</a></li>\r\n");
      out.write("          </ul>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li class=\"divider-vertical\">\r\n");
      out.write("        </li><li class=\"dropdown\">\r\n");
      out.write("          <a href=\"javascript:void(0)\" class=\"dropdown-toggle\">\r\n");
      out.write("           <span class=\"value_currency\">MYR</span> <b class=\"caret\"></b>\r\n");
      out.write("          </a>\r\n");
      out.write("          <ul class=\"dropdown-menu currency-dropdown\">\r\n");
      out.write("            <li class=\"nav-header\">Choose currency\r\n");
      out.write("            </li><li data-currency=\"ARS\" id=\"currency_selector_ARS\"><a href=\"javascript:void(0);\"><i class=\"currency ARS dark\"></i> ARS</a>\r\n");
      out.write("            </li><li data-currency=\"AUD\" id=\"currency_selector_AUD\"><a href=\"javascript:void(0);\"><i class=\"currency AUD dark\"></i> AUD</a>\r\n");
      out.write("            </li><li data-currency=\"BRL\" id=\"currency_selector_BRL\"><a href=\"javascript:void(0);\"><i class=\"currency BRL dark\"></i> BRL</a>\r\n");
      out.write("            </li><li data-currency=\"CAD\" id=\"currency_selector_CAD\"><a href=\"javascript:void(0);\"><i class=\"currency CAD dark\"></i> CAD</a>\r\n");
      out.write("            </li><li data-currency=\"CHF\" id=\"currency_selector_CHF\"><a href=\"javascript:void(0);\"><i class=\"currency CHF dark\"></i> CHF</a>\r\n");
      out.write("            </li><li data-currency=\"CZK\" id=\"currency_selector_CZK\"><a href=\"javascript:void(0);\"><i class=\"currency CZK dark\"></i> CZK</a>\r\n");
      out.write("            </li><li data-currency=\"DKK\" id=\"currency_selector_DKK\"><a href=\"javascript:void(0);\"><i class=\"currency DKK dark\"></i> DKK</a>\r\n");
      out.write("            </li><li data-currency=\"EUR\" id=\"currency_selector_EUR\"><a href=\"javascript:void(0);\"><i class=\"currency EUR dark\"></i> EUR</a>\r\n");
      out.write("            </li><li data-currency=\"GBP\" id=\"currency_selector_GBP\"><a href=\"javascript:void(0);\"><i class=\"currency GBP dark\"></i> GBP</a>\r\n");
      out.write("            </li><li data-currency=\"HKD\" id=\"currency_selector_HKD\"><a href=\"javascript:void(0);\"><i class=\"currency HKD dark\"></i> HKD</a>\r\n");
      out.write("            </li><li data-currency=\"HUF\" id=\"currency_selector_HUF\"><a href=\"javascript:void(0);\"><i class=\"currency HUF dark\"></i> HUF</a>\r\n");
      out.write("            </li><li data-currency=\"ILS\" id=\"currency_selector_ILS\"><a href=\"javascript:void(0);\"><i class=\"currency ILS dark\"></i> ILS</a>\r\n");
      out.write("            </li><li data-currency=\"INR\" id=\"currency_selector_INR\"><a href=\"javascript:void(0);\"><i class=\"currency INR dark\"></i> INR</a>\r\n");
      out.write("            </li><li data-currency=\"JPY\" id=\"currency_selector_JPY\"><a href=\"javascript:void(0);\"><i class=\"currency JPY dark\"></i> JPY</a>\r\n");
      out.write("            </li><li data-currency=\"MXN\" id=\"currency_selector_MXN\"><a href=\"javascript:void(0);\"><i class=\"currency MXN dark\"></i> MXN</a>\r\n");
      out.write("            </li><li data-currency=\"NOK\" id=\"currency_selector_NOK\"><a href=\"javascript:void(0);\"><i class=\"currency NOK dark\"></i> NOK</a>\r\n");
      out.write("            </li><li data-currency=\"NZD\" id=\"currency_selector_NZD\"><a href=\"javascript:void(0);\"><i class=\"currency NZD dark\"></i> NZD</a>\r\n");
      out.write("            </li><li data-currency=\"PLN\" id=\"currency_selector_PLN\"><a href=\"javascript:void(0);\"><i class=\"currency PLN dark\"></i> PLN</a>\r\n");
      out.write("            </li><li data-currency=\"RUB\" id=\"currency_selector_RUB\"><a href=\"javascript:void(0);\"><i class=\"currency RUB dark\"></i> RUB</a>\r\n");
      out.write("            </li><li data-currency=\"SEK\" id=\"currency_selector_SEK\"><a href=\"javascript:void(0);\"><i class=\"currency SEK dark\"></i> SEK</a>\r\n");
      out.write("            </li><li data-currency=\"USD\" id=\"currency_selector_USD\"><a href=\"javascript:void(0);\"><i class=\"currency USD dark\"></i> USD</a>\r\n");
      out.write("            </li><li data-currency=\"ZAR\" id=\"currency_selector_ZAR\"><a href=\"javascript:void(0);\"><i class=\"currency ZAR dark\"></i> ZAR</a>\r\n");
      out.write("          </li></ul>\r\n");
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
      out.write("<style>\r\n");
      out.write("\r\n");
      out.write(".demo-section {\r\n");
      out.write("    width : 220px;\r\n");
      out.write("    border-radius: 8px 8px 8px 8px;\r\n");
      out.write("    box-shadow: 0 1px 1px rgba(0, 0, 0, 0.45), 0 0 30px rgba(0, 0, 0, 0.07) inset;\r\n");
      out.write("    margin: 20px auto;\r\n");
      out.write("    padding: 10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">                                         \r\n");
      out.write("   \r\n");
      out.write("   $(document).ready(function() \r\n");
      out.write("   {\r\n");
      out.write("\t\t\tcreateChart();\r\n");
      out.write("   });\r\n");
      out.write("   \r\n");
      out.write("   function createChart() {\r\n");
      out.write("                    $(\"#chart\").kendoChart({\r\n");
      out.write("                        theme: $(document).data(\"kendoSkin\") || \"default\",\r\n");
      out.write("                        title: {\r\n");
      out.write("                            text: \"Break-up of Spain Electricity Production for 2008\"\r\n");
      out.write("                        },\r\n");
      out.write("                        legend: {\r\n");
      out.write("                            position: \"bottom\",\r\n");
      out.write("                            labels: {\r\n");
      out.write("                                template: \"#= text # (#= value #%)\"\r\n");
      out.write("                            }\r\n");
      out.write("                        },\r\n");
      out.write("                        seriesDefaults: {\r\n");
      out.write("                            labels: {\r\n");
      out.write("                                visible: true,\r\n");
      out.write("                                format: \"{0}%\"\r\n");
      out.write("                            }\r\n");
      out.write("                        },\r\n");
      out.write("                        series: [{\r\n");
      out.write("                            type: \"pie\",\r\n");
      out.write("                            data: [ {\r\n");
      out.write("                                category: \"Hydro\",\r\n");
      out.write("                                value: 22\r\n");
      out.write("                            }, {\r\n");
      out.write("                                category: \"Solar\",\r\n");
      out.write("                                value: 2\r\n");
      out.write("                            }, {\r\n");
      out.write("                                category: \"Nuclear\",\r\n");
      out.write("                                value: 49\r\n");
      out.write("                            }, {\r\n");
      out.write("                                category: \"Wind\",\r\n");
      out.write("                                value: 27\r\n");
      out.write("                            } ]\r\n");
      out.write("                        }],\r\n");
      out.write("                        tooltip: {\r\n");
      out.write("                            visible: true,\r\n");
      out.write("                            format: \"{0}%\"\r\n");
      out.write("                        }\r\n");
      out.write("                    });\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write(" </script>    \r\n");
      out.write("\r\n");
      out.write("<div class=\"mainView\"> \r\n");
      out.write(" <div class=\"form dataEntry\">\r\n");
      out.write(" \r\n");
      out.write("  <div class='demo-section'>\r\n");
      out.write("\t<div id='chart'>\r\n");
      out.write("\t</div>\r\n");
      out.write(" </div>\r\n");
      out.write("\t<input type=\"button\"  id=\"cmd\" value='click me'/>\r\n");
      out.write("  </div> \r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
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
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
