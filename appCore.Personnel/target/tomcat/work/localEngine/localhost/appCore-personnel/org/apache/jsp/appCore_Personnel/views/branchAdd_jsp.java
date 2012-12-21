package org.apache.jsp.appCore_Personnel.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class branchAdd_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("    <script language=\"javascript\" src=\"../../js/viewmodal/branchViewModel.js\"></script>\r\n");
      out.write("        <script language=\"javascript\" src=\"../../js/jquery.validationEngine-en.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("        var gridUrl = globalHostname + \"/app/Core/BranchInfo\";\r\n");
      out.write("        var branchForm = \"branchForm\";\r\n");
      out.write("\r\n");
      out.write("        $(document).ready(function()\r\n");
      out.write("        {\r\n");
      out.write("        $(\"#\" + branchForm).validationEngine();\r\n");
      out.write("\r\n");
      out.write("        var vm = new BranchViewModel(1);\r\n");
      out.write("        var gridDataObject = vm.getView();\r\n");
      out.write("\r\n");
      out.write("        var input = { \"id\" : coreBranchPage, \"roleId\" : 1 };\r\n");
      out.write("        var coreCommand = new CoreCommand();\r\n");
      out.write("        coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("        <form id=\"branchForm\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"form\">\r\n");
      out.write("        <div class=\"sectionalForm\">\r\n");
      out.write("        <div class=\"leftSection\">\r\n");
      out.write("        <div class=\"labelSection\">Branch Code</div><span class='req'>*</span><div class=\"inputSection\"><input\r\n");
      out.write("        class=\"validate[required, maxSize[10]]\" type=\"text\" id=\"BranchCode\" name=\"BranchCode\" placeholder=\"a new branch code\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"rightSection\">\r\n");
      out.write("        <div class=\"inlineLabelSection\">Disabled </div><div class=\"inlineLabelSection\"><input type=\"checkbox\"\r\n");
      out.write("        id=\"Enabled\" /></div>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("        <div class=\"labelSection\">Branch Name</div><span class='req'>*</span><div class=\"inputSection\"><input\r\n");
      out.write("        type=\"text\" class=\"validate[required, maxSize[80]]\" id=\"BranchName\" placeholder=\"a new branch name\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("        <div class=\"labelSection\">Description</div><span class='req'>&nbsp;</span><div class=\"inputSection\"><input\r\n");
      out.write("        type=\"text\" class=\"validate[required, maxSize[80]]\" id=\"Description\" placeholder=\"description for new branch\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div> <div class=\"maintenanceCommandSpace\"></div>\r\n");
      out.write("        <div id=\"branchCommand\" class=\"maintenanceCommand\">\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div>&nbsp;\r\n");
      out.write("        </div>\r\n");
      out.write("        <div>\r\n");
      out.write("        <div> Branch Info </div>\r\n");
      out.write("        <div id=\"gridBranch\" style=\"height: 380px\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
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
