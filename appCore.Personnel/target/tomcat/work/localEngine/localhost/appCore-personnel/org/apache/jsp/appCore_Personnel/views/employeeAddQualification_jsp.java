package org.apache.jsp.appCore_Personnel.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class employeeAddQualification_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("    <link href=\"../../css/themes/base/jquery.ui.all.css\" media=\"screen\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\r\n");
      out.write("        <script language=\"javascript\" src=\"../../js/viewmodal/employeeHelper.js\"></script>\r\n");
      out.write("        <script language=\"javascript\" src=\"../../js/viewmodal/employeeQualificationViewModel.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("        $(document).ready(function()\r\n");
      out.write("        {\r\n");
      out.write("\r\n");
      out.write("        $(\"#QualificationForm\").validationEngine();\r\n");
      out.write("\r\n");
      out.write("        var ajaxCore = new AjaxCore();\r\n");
      out.write("        var vm = new EmployeeQualificationViewModel(0);\r\n");
      out.write("\r\n");
      out.write("        var gridDataObject = vm.getView();\r\n");
      out.write("        var input = vm.getRole();\r\n");
      out.write("\r\n");
      out.write("        var coreCommand = new CoreCommand();\r\n");
      out.write("        coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);\r\n");
      out.write("\r\n");
      out.write("        $(document).unbind(\"parseComplete\");\r\n");
      out.write("\r\n");
      out.write("        $(document).bind(\"parseComplete\", function()\r\n");
      out.write("        {\r\n");
      out.write("            vm.loadInitData();\r\n");
      out.write("            ko.applyBindings(vm, document.getElementById(\"qualificationAddDetailInfo\"));\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <form id=\"QualificationForm\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div id=\"qualificationAddDetailInfo\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"sectionalForm\">\r\n");
      out.write("        <div class=\"leftSection\">\r\n");
      out.write("        <div class=\"labelSection\">Level</div><div class=\"inputSection\"><select type=\"text\" id=\"Level\"\r\n");
      out.write("        data-bind=\"options: levelList, optionsText: 'name', optionsValue: 'nid', value: level\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"rightSection\">\r\n");
      out.write("        <div class=\"inlineLabelSection\">Field</div><div class=\"inlineLabelSection\"><select type=\"text\" id=\"Field\"\r\n");
      out.write("        data-bind=\"options: fieldList, optionsText: 'name', optionsValue: 'nid', value: field\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("        <div class=\"labelSection\">Major</div><div class=\"inputSection\"><input type=\"text\" id=\"Majors\"\r\n");
      out.write("        data-bind=\"value: majors\" class=\"validate[required], maxSize[30]\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"sectionalForm\">\r\n");
      out.write("        <div class=\"leftSection\">\r\n");
      out.write("        <div class=\"labelSection\">Institution</div><div class=\"inputSection\"><input type=\"text\" id=\"Institution\"\r\n");
      out.write("        data-bind=\"value: institution\" class=\"validate[required], maxSize[40]\" /></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"rightSection\">\r\n");
      out.write("        <div class=\"inlineLabelSection\">Local/Oversea</div><div class=\"inlineLabelSection\"><input type=\"text\"\r\n");
      out.write("        id=\"LocalOversea\" data-bind=\"value: localOversea\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"sectionalForm\">\r\n");
      out.write("        <div class=\"leftSection\">\r\n");
      out.write("        <div class=\"labelSection\">Start Date</div><div class=\"inputSection\"><input type=\"text\" id=\"StartDate\"\r\n");
      out.write("        data-bind=\"datepicker: startDate, datepickerOptions: { dateFormat : 'dd-mm-yy'}\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"rightSection\">\r\n");
      out.write("        <div class=\"inlineLabelSection\">End Date</div><div class=\"inlineLabelSection\"><input type=\"text\" id=\"EndDate\"\r\n");
      out.write("        data-bind=\"datepicker: endDate, datepickerOptions: { dateFormat : 'dd-mm-yy'}\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("        <div class=\"labelSection\">Result (CGPA) </div><div class=\"inputSection\"><input type=\"text\" id=\"CGPA\"\r\n");
      out.write("        data-bind=\"value: CGPA\" class=\"validate[required], custom[number]\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("        <div class=\"labelSection\">Attachment</div><div class=\"inputSection\"><input type=\"text\" id=\"Attachment\"\r\n");
      out.write("        data-bind=\"value: attachment\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("        <div class=\"labelSection\">Remarks</div><div class=\"inputSection\"><input type=\"text\" id=\"QualificationRemark\"\r\n");
      out.write("        data-bind=\"value: remarks\" class=\"validate[required], maxSize[40]\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("        <div></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("        <div id=\"userCommand\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        </form>");
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
