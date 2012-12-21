package org.apache.jsp.appCore_Personnel.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class holidaySetupAdd_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

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

      out.write("<script type=\"text/javascript\">          \r\n");
      out.write("\r\n");
      out.write("    var currentService = hostname + \"/app/Core/Calendar/Holiday\";\r\n");
      out.write("\r\n");
      out.write("\t$(\"#myform\").validationEngine();\r\n");
      out.write("\t\r\n");
      out.write("\t$(document).ready(function() \r\n");
      out.write("\t{\r\n");
      out.write("\t\t $(\"#HolidayDate\").kendoDatePicker();\r\n");
      out.write("\t\t $(\"#Type\").kendoComboBox();\r\n");
      out.write("\t\t $(\"#Recurring\").kendoComboBox();\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t $(\"#saveBtn\").live(\"click\", function()\r\n");
      out.write("\t\t {\r\n");
      out.write("\t\t\tif (evt.handled !== true)\r\n");
      out.write("\t\t\t{ \r\n");
      out.write("\t\t\t\tevt.handled = true; \r\n");
      out.write("\t\t\t\tgetValidateData();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t });\r\n");
      out.write("\t\t\t \r\n");
      out.write("\t\t $(\"#cancelBtn\").live(\"click\", function(evt)\r\n");
      out.write("\t\t {\r\n");
      out.write("\t\t\tif (evt.handled !== true)\r\n");
      out.write("\t\t\t{ \r\n");
      out.write("\t\t\t\tevt.handled = true; \r\n");
      out.write("\t\t\t\tvar result = cancelFormChanges();\r\n");
      out.write("\t\t\t\tif (result) \r\n");
      out.write("\t\t\t\t\tpreparePageForLoading(\"holidaySetup.jsp\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t });\r\n");
      out.write(" \t});\r\n");
      out.write("\r\n");
      out.write("\tfunction getValidateData()\r\n");
      out.write("\t{\r\n");
      out.write("\t \t\t\r\n");
      out.write("\t\tvar holiday = new Holiday(); \r\n");
      out.write("\t\tholiday.name = $(\"#Name\").val(); \r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar datepicker = $(\"#HolidayDate\").data(\"kendoDatePicker\");\r\n");
      out.write("\t\tholiday.holidayDate = kendo.toString(datepicker.value(), \"yyyy-MM-dd\");\r\n");
      out.write("\t\tholiday.type = $(\"#Type\").data(\"kendoComboBox\").value();\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tholiday.recurring = $(\"#Recurring\").data(\"kendoComboBox\").value() == \"1\" ? true : false; \r\n");
      out.write("\t\t\r\n");
      out.write("\t    var ajaxCore = new AjaxCore(); \r\n");
      out.write("\t\tvar request = ajaxCore.sendRequestType(currentService + \"/add\", holiday, \"post\"); \r\n");
      out.write("\t\t\r\n");
      out.write("\t\trequest.success(function(data, status, xhrObj)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\t// goToPage(\"holidaySetup.jsp\");\r\n");
      out.write("\t\t\tpreparePageForLoading(\"holidaySetup.jsp\");\r\n");
      out.write("\t\t}); \r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("</script>    \r\n");
      out.write("\r\n");
      out.write("<form id=\"myform\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"form\">\r\n");
      out.write("\t\t\r\n");
      out.write("  <div class=\"sectionalForm\"> \r\n");
      out.write("   \r\n");
      out.write("   <div class=\"formRow\">\r\n");
      out.write("\t\t<div class=\"labelSection\">Holiday Date</div><span class='req'>*</span><div class=\"inputSection\"><input type=\"text\" class=\"validate[required]\" id=\"HolidayDate\" /></div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("    <div class=\"formRow\">\r\n");
      out.write("\t\t<div class=\"labelSection\">Holiday Name</div><span class='req'>*</span><div class=\"inputSection\"><input type=\"text\" id=\"Name\" class=\"validate[required, maxSize[20]]\"  value=\"Name\"/></div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"formRow\">\r\n");
      out.write("\t\t<div class=\"labelSection\">Type</div><span class='req'>*</span><div class=\"inputSection\">\r\n");
      out.write("\t\t\t<select id=\"Type\" class=\"validate[required]\" >\r\n");
      out.write("\t\t\t\t<option value=\"1\">Gazetted</option>\r\n");
      out.write("\t\t\t\t<option value=\"0\">Non-Gazetted</option>\r\n");
      out.write("\t\t\t</select>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("    </div>\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"formRow\">\r\n");
      out.write("\t\t<div class=\"labelSection\">Recurring</div><span class='req'>*</span><div class=\"inputSection\">\r\n");
      out.write("\t\t\t<select id=\"Recurring\" class=\"validate[required]\" >\r\n");
      out.write("\t\t\t\t<option value=\"1\">Yes</option>\r\n");
      out.write("\t\t\t\t<option value=\"0\">No</option>\r\n");
      out.write("\t\t\t</select>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"formRow\">\r\n");
      out.write("\t\t&nbsp;\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\t<div> \r\n");
      out.write("\t\t<div class=\"command\"><button type=\"button\" id=\"saveBtn\">Save</button>\r\n");
      out.write("\t\t<button type=\"button\" id=\"cancelBtn\">Cancel</button>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("   \r\n");
      out.write("   <div>&nbsp;</div>\r\n");
      out.write("</div>\r\n");
      out.write("</form>");
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
