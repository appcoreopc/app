package org.apache.jsp.appCore_Personnel.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class employeeAdd_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("    <link href=\"../../css/personnelEmployeeForm.css\" media=\"screen\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <script language=\"javascript\" src=\"../../js/viewmodal/employeeCommandViewModel.js\"></script>\r\n");
      out.write("        <script language=\"javascript\" src=\"../../js/coreDialog.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("        $(document).ready(function()\r\n");
      out.write("        {\r\n");
      out.write("            var vm = new EmployeeCommandViewModel();\r\n");
      out.write("            var gridDataObject = vm.getCommandForForm();\r\n");
      out.write("\r\n");
      out.write("            var input = { \"id\" : globalEmployeeModule, \"roleId\" : globalViewModel.employeeRole() };\r\n");
      out.write("            var coreCommand = new CoreCommand();\r\n");
      out.write("            coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);\r\n");
      out.write("\r\n");
      out.write("            var tab = $(\"#codeSetupTabs\").tabs({ cache : true});\r\n");
      out.write("\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("        <form id=\"myform\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"maintenanceCommand\">\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"form\">\r\n");
      out.write("\r\n");
      out.write("        <div id=\"codeSetupTabs\">\r\n");
      out.write("        <ul>\r\n");
      out.write("        <li><a href=\"employeeGeneralInfoView.jsp\">General</a></li>\r\n");
      out.write("        <li><a href=\"employeeContactsView.jsp\">Contacts</a></li>\r\n");
      out.write("        <li><a href=\"employeeResidenceInfoView.jsp\">Residence</a></li>\r\n");
      out.write("        <li><a href=\"employeeFamilyView.jsp\">Family</a></li>\r\n");
      out.write("        <li><a href=\"employeeQualificationView.jsp\">Qualification</a></li>\r\n");
      out.write("        <li><a href=\"employeeMembershipView.jsp\">Membership</a></li>\r\n");
      out.write("        <li><a href=\"employeeExpertiseView.jsp\">Expertise</a></li>\r\n");
      out.write("        <li><a href=\"employeeEmploymentInfoView.jsp\">Employment</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        </form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <!--\r\n");
      out.write("\r\n");
      out.write("        This is the add section\r\n");
      out.write("        <div id=\"codeSetupTabs\">\r\n");
      out.write("        <ul>\r\n");
      out.write("        <li><a href=\"employeeAddGeneralInfo.jsp\">General</a></li>\r\n");
      out.write("        <li><a href=\"employeeAddContacts.jsp\">Contacts</a></li>\r\n");
      out.write("        <li><a href=\"employeeAddResidenceInfo.jsp\">Residence</a></li>\r\n");
      out.write("        <li><a href=\"employeeAddFamily.jsp\">Family</a></li>\r\n");
      out.write("        <li><a href=\"employeeAddQualification.jsp\">Qualification</a></li> -- we have an issue here\r\n");
      out.write("        <li><a href=\"employeeAddMembership.jsp\">Membership</a></li>\r\n");
      out.write("        <li><a href=\"employeeAddExpertise.jsp\">Expertise</a></li>\r\n");
      out.write("        <li><a href=\"employeeAddEmploymentInfo.jsp\">Employment</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("        -->");
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
