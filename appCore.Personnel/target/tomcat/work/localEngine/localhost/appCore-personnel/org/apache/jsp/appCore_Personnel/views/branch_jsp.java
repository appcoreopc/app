package org.apache.jsp.appCore_Personnel.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class branch_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<link href=\"../../css/dialogBox.css\" media=\"screen\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<script language=\"javascript\" src=\"../../js/viewmodal/branchViewModel.js\"></script>\r\n");
      out.write("<script language=\"javascript\" src=\"../../js/viewmodal/companyHelper.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    $(document).ready(function()\r\n");
      out.write("\t{\r\n");
      out.write("        getData(globalViewModel.companyId());\r\n");
      out.write("        globalViewModel.companyId.subscribe(function(newValue)\r\n");
      out.write("        {\r\n");
      out.write("            getData(newValue);\r\n");
      out.write("        });\r\n");
      out.write("    });\r\n");
      out.write("\r\n");
      out.write("    function getData(companyId)\r\n");
      out.write("    {\r\n");
      out.write("        var ajaxCore = new AjaxCore();\r\n");
      out.write("        var companyId = { id : companyId };\r\n");
      out.write("        var request = ajaxCore.sendRequest(globalBranchListByCompanyUrl, companyId, \"get\");\r\n");
      out.write("\r\n");
      out.write("        request.success(function(data)\r\n");
      out.write("        {\r\n");
      out.write("            var vm = new BranchViewModel(0, data, globalViewModel);\r\n");
      out.write("            var gridDataObject = vm.getView();\r\n");
      out.write("            var input = { \"id\" : coreBranchPage, \"roleId\" : 1 };\r\n");
      out.write("            var coreCommand = new CoreCommand();\r\n");
      out.write("            var gridViewModel = coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);\r\n");
      out.write("            vm.gridViewModel = gridViewModel;\r\n");
      out.write("            ko.applyBindings(vm, document.getElementById(\"branchDiv\"));\r\n");
      out.write("\r\n");
      out.write("        });\r\n");
      out.write("    }\r\n");
      out.write("\t\t\t\r\n");
      out.write("</script>    \r\n");
      out.write("\r\n");
      out.write("<div class=\"form formOutline\">\r\n");
      out.write("\t\r\n");
      out.write("\t<h1>Branch Maintenance</h1>\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"viewData\"> \r\n");
      out.write("\t\t<div class=\"maintenanceCommand\">\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("    <div>\r\n");
      out.write("    <div id=\"branchDiv\" data-bind=\"dataGrid: gridViewModel\"></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<div>\r\n");
      out.write("</div>\r\n");
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
