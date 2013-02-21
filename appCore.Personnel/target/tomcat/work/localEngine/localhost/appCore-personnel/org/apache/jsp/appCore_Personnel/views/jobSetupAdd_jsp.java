package org.apache.jsp.appCore_Personnel.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class jobSetupAdd_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <link href=\"../../css/jobSetup.css\" media=\"screen\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("        <script language=\"javascript\" src=\"../../js/viewmodal/jobSetupCommandViewModel.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("        $(document).ready(function()\r\n");
      out.write("        {\r\n");
      out.write("\r\n");
      out.write("            if (globalViewModel.editMode() == coreModeEdit)\r\n");
      out.write("            {\r\n");
      out.write("                var ajaxCore = new AjaxCore();\r\n");
      out.write("                var targetEntity = { id : globalViewModel.targetId() };\r\n");
      out.write("                var request = ajaxCore.sendRequest(globalJobTypeGetUrl, targetEntity, \"get\");\r\n");
      out.write("\r\n");
      out.write("                request.success(function(dataSource)\r\n");
      out.write("                {\r\n");
      out.write("                    var vm = new JobSetupCommandViewModel(globalViewModel.editMode(), dataSource, globalViewModel);\r\n");
      out.write("                    bindVM(vm);\r\n");
      out.write("                });\r\n");
      out.write("            }\r\n");
      out.write("            else\r\n");
      out.write("            {\r\n");
      out.write("                var vm = new JobSetupCommandViewModel(globalViewModel.editMode(), null, globalViewModel);\r\n");
      out.write("                bindVM(vm);\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            var tab = $(\"#codeSetupTabs\").tabs({ cache : true});\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        function bindVM(vm)\r\n");
      out.write("        {\r\n");
      out.write("            try\r\n");
      out.write("            {\r\n");
      out.write("                var gridDataObject = vm.getCommandForForm();\r\n");
      out.write("                var input = { \"id\" : globalEmployeeModule, \"roleId\" : globalViewModel.employeeRole() };\r\n");
      out.write("                var coreCommand = new CoreCommand();\r\n");
      out.write("                coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);\r\n");
      out.write("                ko.applyBindings(vm, document.getElementById(\"jobSetupForm\"));\r\n");
      out.write("            }\r\n");
      out.write("            catch (ex)\r\n");
      out.write("            {\r\n");
      out.write("                console.log(ex);\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("    </script>\r\n");
      out.write("\r\n");
      out.write("    <form id=\"myform\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <div class=\"form\">\r\n");
      out.write("\r\n");
      out.write("            <div class=\"formMainContent\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("     <div id=\"jobSetupForm\">\r\n");
      out.write("        <div class=\"sectionalForm\">\r\n");
      out.write("        <div class=\"leftSection\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Job</div><div class=\"inputSection\">\r\n");
      out.write("        <input class=\"validate[required, maxSize[10]]\" type=\"text\" id=\"JobCode\" name=\"JobCode\" data-bind=\"value : jobCode\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"rightSection\">\r\n");
      out.write("        <div class=\"inlineLabelSection\">Disabled </div><div class=\"inlineLabelSection\"><input type=\"checkbox\" id=\"Enabled\" data-bind=\"checked : disabled\" /></div>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("            <div class=\"viewLabelSection\">Job Title</div><span class=\"fieldSpacer\"></span><div class=\"inputSection\">\r\n");
      out.write("        <input type=\"text\" id=\"JobTitle\" class=\"validate[required, maxSize[80]]\" data-bind=\"value : jobTitle\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("            <div class=\"viewLabelSection\">Job Category</div><span class=\"fieldSpacer\"></span><div class=\"inputSection\">\r\n");
      out.write("        <input type=\"text\" id=\"JobCategory\" class=\"validate[required, maxSize[80]]\" data-bind=\"value : jobCategory\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("        &nbsp;\r\n");
      out.write("        </div>\r\n");
      out.write("     </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"maintenanceCommand\">\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div id=\"codeSetupTabs\">\r\n");
      out.write("        <ul>\r\n");
      out.write("            <li><a href=\"jobDescriptionAdd.jsp\">Job Description</a></li>\r\n");
      out.write("            <li><a href=\"jobSetupQualificationView.jsp\">Qualification Requirement</a></li>\r\n");
      out.write("            <li><a href=\"jobSetupExperienceView.jsp\">Experience Requirement</a></li>\r\n");
      out.write("            <li><a href=\"jobSetupSkillView.jsp\">Skill Requirement</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("  </form>");
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
