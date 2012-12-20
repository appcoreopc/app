package org.apache.jsp.appCore_Personnel.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class demo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("    <script src=\"../../js/jquery-1.7.2.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <script language=\"javascript\" src=\"../../js/ui/jquery-ui-1.8.23.custom.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <script language=\"javascript\" src=\"../../js/viewmodal/knockoutBindersControl.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <script src=\"../../kendo/js/kendo.web.min.js\"></script>\r\n");
      out.write("    <script language=\"javascript\" src=\"../../js/knockoutjs/knockout-2.2.0.debug.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">          \r\n");
      out.write("\r\n");
      out.write("    var Detail = function(subscription)\r\n");
      out.write("    {\r\n");
      out.write("        var self = this;\r\n");
      out.write("\r\n");
      out.write("        subscription.subscribe(function (newValue)\r\n");
      out.write("        {\r\n");
      out.write("            if (newValue==1)\r\n");
      out.write("            {\r\n");
      out.write("                        self.companyName(\"Microsoft\");\r\n");
      out.write("            }\r\n");
      out.write("            else if (newValue==2)\r\n");
      out.write("            {\r\n");
      out.write("                    self.companyName(\"Google\");\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        self.companyName = ko.observable();\r\n");
      out.write("\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    $(document).ready(function()\r\n");
      out.write("\t{\r\n");
      out.write("            var vm = {\r\n");
      out.write("                companyCode : ko.observable(1)\r\n");
      out.write("            };\r\n");
      out.write("\r\n");
      out.write("    var child = new Detail(vm.companyCode);\r\n");
      out.write("\r\n");
      out.write("    ko.applyBindings(vm, document.getElementById(\"Summary\"));\r\n");
      out.write("    ko.applyBindings(child, document.getElementById(\"Details\"));\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("   \t});\r\n");
      out.write("\t\t\t\r\n");
      out.write("</script>    \r\n");
      out.write("\r\n");
      out.write("<div class=\"form formOutline\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <div class=\"viewData\">\r\n");
      out.write("\r\n");
      out.write("    <div id=\"Summary\">\r\n");
      out.write("    <div id=\"gridBranch\" style=\"height: 380px\">\r\n");
      out.write("    <input type=\"text\" data-bind=\"value : companyCode\" />\r\n");
      out.write("    </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <div id=\"Details\">\r\n");
      out.write("\r\n");
      out.write("    <span data-bind=\"text : companyName\"></span>\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <div>\r\n");
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
