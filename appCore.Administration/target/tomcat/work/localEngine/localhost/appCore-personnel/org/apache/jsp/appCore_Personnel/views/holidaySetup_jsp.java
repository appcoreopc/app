package org.apache.jsp.appCore_Personnel.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class holidaySetup_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title></title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<link href=\"../../css/header.css\" media=\"screen\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"../../css/default.css\" media=\"screen\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"../../css/personnel.css\" media=\"screen\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\r\n");
      out.write("<link href=\"../../kendo/styles/kendo.common.min.css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"../../kendo/styles/kendo.default.min.css\" rel=\"stylesheet\">\r\n");
      out.write('\r');
      out.write('\n');
      out.write("<script language=\"javascript\" src=\"../../js/jquery-1.7.2.min.js\"></script>\r\n");
      out.write("<script language=\"javascript\" src=\"../../js/carousel.js\"></script>\r\n");
      out.write("<script language=\"javascript\" src=\"../../js/ajaxCore.js\"></script>\r\n");
      out.write("<script language=\"javascript\" src=\"../../js/coreObjects.js\"></script>\r\n");
      out.write("<script language=\"javascript\" src=\"../../js/coreCommonFunction.js\"></script>\r\n");
      out.write("<script language=\"javascript\" src=\"../../js/appDefinition.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script language=\"javascript\" src=\"../../js/initTree.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script src=\"../../kendo/content/shared/js/people.js\"></script>\r\n");
      out.write("<script src=\"../../kendo/js/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"../../kendo/js/kendo.web.min.js\"></script>\r\n");
      out.write("\t\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("\r\n");
      out.write("</script>");
      out.write('\r');
      out.write('\n');
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
      out.write(" <div class='treeDiv'>\r\n");
      out.write("\t<div id='treeView'>\r\n");
      out.write("\t</div>\r\n");
      out.write(" </div>\r\n");
      out.write(" \r\n");
      out.write("<div id=\"menuDiv\">Menu</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"logoutWindow\">\r\n");
      out.write("\r\n");
      out.write("</div>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">          \r\n");
      out.write("  \r\n");
      out.write("\t$(document).ready(function() \r\n");
      out.write("\t{\r\n");
      out.write("\t\tvar appPath = \"/app/Core/Calendar/Holiday\";\r\n");
      out.write("\t\tvar ajaxCore = new AjaxCore();\r\n");
      out.write("\t\tvar request = ajaxCore.sendRequest(hostname +  appPath + \"/list\", null, \"get\");\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\trequest.success(function(data) \r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\t  var grid = $(\"#grid\").kendoGrid({\r\n");
      out.write("                        dataSource: {\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t  transport: {\r\n");
      out.write("                                read:  {\r\n");
      out.write("                                    url: hostname + appPath + \"/list\",\r\n");
      out.write("                                    dataType: \"json\"\r\n");
      out.write("                                },\r\n");
      out.write("                                update: {\r\n");
      out.write("                                    url: hostname + appPath + \"/saveOrUpdate\",\r\n");
      out.write("                                    dataType: \"json\"\r\n");
      out.write("                                },\r\n");
      out.write("                                destroy: {\r\n");
      out.write("                                    url: hostname + appPath + \"/delete\",\r\n");
      out.write("                                    dataType: \"json\"\r\n");
      out.write("                                },\r\n");
      out.write("                                create: {\r\n");
      out.write("                                    url: hostname + appPath + \"/add\",\r\n");
      out.write("                                    dataType: \"json\"\r\n");
      out.write("                                } \r\n");
      out.write("\t\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("                            data: data,\r\n");
      out.write("                            pageSize: 10, \r\n");
      out.write("\t\t\t\t\t\t\tschema: {\r\n");
      out.write("                                model: {\r\n");
      out.write("                                    id: \"nid\",\r\n");
      out.write("                                    fields: {\r\n");
      out.write("                                        nid: { editable: false },\r\n");
      out.write("                                        holidayDate: { editable: false, type : \"date\" },\r\n");
      out.write("                                        name: { editable: false, type : \"string\" },\r\n");
      out.write("                                        recurring : { editable: false, type : \"boolean\" },\r\n");
      out.write("                                        lastUpdate : { editable: false, type : \"string\" }\r\n");
      out.write("                                       \r\n");
      out.write("                                    }\r\n");
      out.write("                                }\r\n");
      out.write("                            }\r\n");
      out.write("\t\t\t\t\t\t\t \r\n");
      out.write("                        },\r\n");
      out.write("\t\t\t\t\t\teditable : true,\r\n");
      out.write("\t\t\t\t\t\tgroupable: false,\r\n");
      out.write("\t\t\t\t\t\tselectable : true,\r\n");
      out.write("                        sortable: true,\r\n");
      out.write("                        pageable: true,\r\n");
      out.write("\t\t\t\t\t\ttoolbar: [\"save\", \"cancel\"],\r\n");
      out.write("                        columns: [ \r\n");
      out.write("\t\t\t\t\t\t\t {\r\n");
      out.write("                                field: \"holidayDate\",\r\n");
      out.write("                                width: 90,\r\n");
      out.write("                                title: \"Holiday Date\", format : \"{0:dd-MMM-yyyy}\"\r\n");
      out.write("                            }, \r\n");
      out.write("\t\t\t\t\t\t\t{\r\n");
      out.write("                                field: \"name\",\r\n");
      out.write("                                width: 90,\r\n");
      out.write("                                title: \"Name\"\r\n");
      out.write("                            }, \r\n");
      out.write("\t\t\t\t\t\t\t{\r\n");
      out.write("                                field: \"recurring\",\r\n");
      out.write("                                width: 90,\r\n");
      out.write("                                title: \"Recurring\"\r\n");
      out.write("                            }, \r\n");
      out.write("\t\t\t\t\t\t\t{\r\n");
      out.write("                                field: \"type\",\r\n");
      out.write("                                width: 90,\r\n");
      out.write("                                title: \"Type\", template : '#= getHolidayTypeDisplayText(type) #'\r\n");
      out.write("                            }, \r\n");
      out.write("\t\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\t     command : { text: \"Edit\", click: showDetails },  title : \"\", width: 50\r\n");
      out.write("\t\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\t     command : \"destroy\",  title : \"\", width: 50\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t], \r\n");
      out.write("\t\t\t\t\t\tremove : function(e)\r\n");
      out.write("\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\t\t\t\turl: hostname + appPath + \"/delete\",\r\n");
      out.write("\t\t\t\t\t\t\t\tdata: {\"id\": e.model.nid},\r\n");
      out.write("\t\t\t\t\t\t\t\ttype : \"get\", \r\n");
      out.write("\t\t\t\t\t\t\t\tdataType : \"json\"\r\n");
      out.write("\t\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t    });\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t);\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t$(\"#addBtn\").click(function()\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\tgoToPage(\"holidaySetupAdd.jsp\");\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t$(\"#setupHolidayBtn\").click(function()\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\tgoToPage(\"configureHolidayGroup.jsp\");\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\tfunction getHolidayTypeDisplayText(dayType)\r\n");
      out.write("\t{\r\n");
      out.write("\t\tif (dayType == 1) \r\n");
      out.write("\t\t\treturn \"Gazetted\";\r\n");
      out.write("\t\telse if (dayType == 0) \r\n");
      out.write("\t\t    return \"Non-Gazetted\";\r\n");
      out.write("\t\telse \r\n");
      out.write("\t\t\treturn \"Non-Gazetted\";\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction showDetails(e)\r\n");
      out.write("\t{\r\n");
      out.write("\t\t e.preventDefault();\r\n");
      out.write("\t\t var dataItem = this.dataItem($(e.currentTarget).closest(\"tr\"));\r\n");
      out.write("\t\t goToPage(\"holidaySetupEdit.jsp?id=\" + dataItem.nid );\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("</script>    \r\n");
      out.write("\r\n");
      out.write("<div class=\"form dataEntry\">\r\n");
      out.write("\t<h1>Holiday Setup</h1>\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"formRow\">\r\n");
      out.write("\t\tHoliday Maintenance\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"formRow\">\t\r\n");
      out.write("\t\t&nbsp;\r\n");
      out.write("    </div>\r\n");
      out.write("\t \r\n");
      out.write("\t<div class=\"maintenanceCommand\"> \r\n");
      out.write("\t\t<button type=\"button\" id=\"addBtn\">Add New Holiday</button>\r\n");
      out.write("\t\t<button type=\"button\" id=\"setupHolidayBtn\">Configure Holiday Group</button>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"formRow\">\t\r\n");
      out.write("\t\t&nbsp;\r\n");
      out.write("    </div>\r\n");
      out.write("\t \r\n");
      out.write("  <div>\r\n");
      out.write("\t\t<div id=\"grid\" style=\"height: 380px\"></div>\r\n");
      out.write("\t</div>\r\n");
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
      out.write("</html>");
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
