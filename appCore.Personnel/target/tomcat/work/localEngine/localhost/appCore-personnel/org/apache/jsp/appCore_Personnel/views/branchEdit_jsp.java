package org.apache.jsp.appCore_Personnel.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class branchEdit_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<script language=\"javascript\" src=\"../../js/viewmodal/branchViewModel.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("\t$(document).ready(function() \r\n");
      out.write("\t{\r\n");
      out.write("\t\tvar value = globalViewModel.targetId();\r\n");
      out.write("        $(\"#\" + branchForm).validationEngine();\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\tif (value != null) \r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\t\tvar ajaxCore = new AjaxCore();\r\n");
      out.write("\t\t\t\t\tvar request = ajaxCore.sendRequest(globalHostname + \"/app/Core/Branch/get\", { id : value }, \"get\");\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\trequest.done(function(data)\r\n");
      out.write("\t\t\t\t\t{\r\n");
      out.write("                        if (data == null)\r\n");
      out.write("                            return;\r\n");
      out.write("\r\n");
      out.write("                        $(\"#Nid\").val(data.nid);\r\n");
      out.write("                        $(\"#BranchCode\").val(data.branchCode);\r\n");
      out.write("                        $(\"#BranchName\").val(data.branchName);\r\n");
      out.write("                        $(\"#Description\").val(data.description);\r\n");
      out.write("                        $(\"#Enabled\").attr(\"checked\", data.enabled);\r\n");
      out.write("\r\n");
      out.write("                        var vm = new BranchViewModel(2, value, data);\r\n");
      out.write("                        var addPage = vm.getAddPage();\r\n");
      out.write("                        var centralPage = vm.getCentralPage();\r\n");
      out.write("\r\n");
      out.write("                        var gridDataObject = vm.getView();\r\n");
      out.write("                        var input = { \"id\" : coreBranchPage, \"roleId\" : 1 };\r\n");
      out.write("                        var coreCommand = new CoreCommand();\r\n");
      out.write("                        coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t}\r\n");
      out.write(" \t});\r\n");
      out.write("\r\n");
      out.write(" \t\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <form id=\"branchForm\">\r\n");
      out.write("    <div class=\"form\">\r\n");
      out.write("\r\n");
      out.write("    <div class=\"sectionalForm\">\r\n");
      out.write("    <div class=\"leftSection\"><input type=\"hidden\" id=\"Nid\" name=\"Nid\" />\r\n");
      out.write("    <div class=\"labelSection\">Branch Code</div><div class=\"inputSection\"><input type=\"text\" class=\"validate[required,\r\n");
      out.write("    maxSize[10]]\" id=\"BranchCode\" value=\"BranchCode\"/></div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"rightSection\">\r\n");
      out.write("    <div class=\"inlineLabelSection\">Disabled</div><div class=\"inlineLabelSection\"><input type=\"checkbox\" id=\"Enabled\"\r\n");
      out.write("    /></div>\r\n");
      out.write("    </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"formRow\">\r\n");
      out.write("    <div class=\"labelSection\">Branch Name</div><div class=\"inputSection\"><input type=\"text\" class=\"validate[required,\r\n");
      out.write("    maxSize[80]]\" id=\"BranchName\" value=\"BranchName\"/></div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"formRow\">\r\n");
      out.write("    <div class=\"labelSection\">Description</div><div class=\"inputSection\"><input type=\"text\" class=\"validate[required,\r\n");
      out.write("    maxSize[80]]\" id=\"Description\" value=\"Description\"/></div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div> <div class=\"maintenanceCommandSpace\"></div>\r\n");
      out.write("    <div id=\"branchCommand\" class=\"maintenanceCommand\">\r\n");
      out.write("    </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div>&nbsp;\r\n");
      out.write("    </div>\r\n");
      out.write("    <div>\r\n");
      out.write("    <div> Branch Info </div>\r\n");
      out.write("    <div id=\"gridBranch\" style=\"height: 380px\"></div>\r\n");
      out.write("    </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    </form>");
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
