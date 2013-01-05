package org.apache.jsp.appCore_Personnel.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class employeeAddExpertise_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("        <link href=\"../../css/themes/base/jquery.ui.all.css\" media=\"screen\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("        <link href=\"../../css/employeeGeneralAddForm.css\" media=\"screen\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("        <script language=\"javascript\" src=\"../../js/viewmodal/employeeHelper.js\"></script>\r\n");
      out.write("        <script language=\"javascript\" src=\"../../js/viewmodal/employeeExpertiseViewModel.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("        $(document).ready(function()\r\n");
      out.write("        {\r\n");
      out.write("            $(\"#ExpertiseForm\").validationEngine();\r\n");
      out.write("\r\n");
      out.write("            var ajaxCore = new AjaxCore();\r\n");
      out.write("            var vm = new EmployeeExpertiseViewModel(0, globalViewModel);\r\n");
      out.write("\r\n");
      out.write("            var gridDataObject = vm.getView();\r\n");
      out.write("            var input = vm.getRole();\r\n");
      out.write("\r\n");
      out.write("            var coreCommand = new CoreCommand();\r\n");
      out.write("            coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);\r\n");
      out.write("            vm.loadInitData();\r\n");
      out.write("            ko.applyBindings(vm, document.getElementById(\"employeeExpertiseAddDetailInfo\"));\r\n");
      out.write("\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <form id=\"ExpertiseForm\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div id=\"employeeExpertiseAddDetailInfo\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"sectionalForm\">\r\n");
      out.write("        <div class=\"leftSection\">\r\n");
      out.write("        <div class=\"labelSection\">Industry</div><div class=\"inputSection\"><select type=\"text\" data-bind=\"options:\r\n");
      out.write("        industryList, optionsText: 'name', optionsValue: 'nid', value: industry\" id=\"Industry\" /></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"rightSection\">\r\n");
      out.write("        <div class=\"inlineLabelSection\">Specialty</div><div class=\"inlineLabelSection\"><select type=\"text\"\r\n");
      out.write("        data-bind=\"options: specialtyList, optionsText: 'name', optionsValue: 'nid', value: specialty\" id=\"Specialty\"\r\n");
      out.write("        /></div>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"sectionalForm\">\r\n");
      out.write("        <div class=\"leftSection\">\r\n");
      out.write("        <div class=\"labelSection\">Start Date</div><div class=\"inputSection\"><input type=\"text\" id=\"StartDate\"\r\n");
      out.write("        data-bind=\"datepicker: startDate, datepickerOptions: { dateFormat : 'dd-mm-yy'}\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"rightSectionInline\">\r\n");
      out.write("        <div class=\"inlineLabelSection\">End Date</div><div class=\"inlineLabelSectionExtra\"><input type=\"text\"\r\n");
      out.write("        data-bind=\"datepicker: endDate, datepickerOptions: { dateFormat : 'dd-mm-yy'}\" id=\"EndDate\" /></div>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"sectionalForm\">\r\n");
      out.write("        <div class=\"labelSection\">Period</div><div class=\"inputSection\"><input type=\"text\" id=\"Period\" data-bind=\"value:\r\n");
      out.write("        period\" class=\"validate[required, custom[number]]\" /></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"sectionalForm\">\r\n");
      out.write("        <div class=\"labelSection\">Remarks</div><div class=\"inputSection\"><input type=\"text\" id=\"Remarks\"\r\n");
      out.write("        data-bind=\"value: remarks\" class=\"validate[maxSize[40]]\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"sectionalForm\">\r\n");
      out.write("        <div></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("        <div id=\"userCommand\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
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
