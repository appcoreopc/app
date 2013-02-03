package org.apache.jsp.appCore_Personnel.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class demoId_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("    <style>\r\n");
      out.write("        body { font-family: arial; font-size: 14px; }\r\n");
      out.write("\r\n");
      out.write("        .liveExample { padding: 1em; background-color: #EEEEDD; border: 1px solid #CCC; max-width: 655px; }\r\n");
      out.write("        .liveExample input { font-family: Arial; }\r\n");
      out.write("        .liveExample b { font-weight: bold; }\r\n");
      out.write("        .liveExample p { margin-top: 0.9em; margin-bottom: 0.9em; }\r\n");
      out.write("        .liveExample select[multiple] { width: 100%; height: 8em; }\r\n");
      out.write("        .liveExample h2 { margin-top: 0.4em; }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        .ko-grid { margin-bottom: 1em; width: 25em; border: 1px solid silver; background-color:White; }\r\n");
      out.write("        .ko-grid th { text-align:left; background-color: Black; color:White; }\r\n");
      out.write("        .ko-grid td, th { padding: 0.4em; }\r\n");
      out.write("        .ko-grid tr:nth-child(odd) { background-color: #DDD; }\r\n");
      out.write("        .ko-grid-pageLinks { margin-bottom: 1em; }\r\n");
      out.write("        .ko-grid-pageLinks a { padding: 0.5em; }\r\n");
      out.write("        .ko-grid-pageLinks a.selected { background-color: Black; color: White; }\r\n");
      out.write("        .liveExample { height:20em; overflow:auto } /* Mobile Safari reflows pages slowly, so fix the height to avoid\r\n");
      out.write("        the need for reflows */\r\n");
      out.write("\r\n");
      out.write("        li { list-style-type: disc; margin-left: 20px; }\r\n");
      out.write("        â\r\n");
      out.write("\r\n");
      out.write("        </style>\r\n");
      out.write("\r\n");
      out.write("        <script language=\"javascript\" src=\"../../js/viewmodal/branchViewModel.js\"></script>\r\n");
      out.write("        <script src=\"../../js/ajaxCore.js\"></script>\r\n");
      out.write("        <script src=\"../../js/appDefinition.js\"></script>\r\n");
      out.write("        <script src=\"../../js/jquery-1.7.2.min.js\"></script>\r\n");
      out.write("        <script language=\"javascript\" src=\"../../js/viewmodal/knockoutBindersControl.js\"></script>\r\n");
      out.write("        <script language=\"javascript\" src=\"../../js/knockoutjs/knockout-2.2.0.debug.js\"></script>\r\n");
      out.write("        <script language=\"javascript\" src=\"../../js/testGrid.js\"></script>\r\n");
      out.write("        <script language=\"javascript\" src=\"../../js/viewmodal/employeeHelper.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("        $(document).ready(function()\r\n");
      out.write("        {\r\n");
      out.write("\r\n");
      out.write("            var ajaxCore = new AjaxCore();\r\n");
      out.write("            var fieldRequest = ajaxCore.sendRequest(\"http://localhost:8080/appCore-personnel/app/Core/Branch/edit\", null, \"get\");\r\n");
      out.write("            fieldRequest.success(function (data, status, xhrObj) {\r\n");
      out.write("                console.log(data);\r\n");
      out.write("            });\r\n");
      out.write("\r\n");
      out.write("            var SimplePage = function()\r\n");
      out.write("            {\r\n");
      out.write("                var self = this;\r\n");
      out.write("                self.code = ko.observable();\r\n");
      out.write("\r\n");
      out.write("                self.codeType = ko.observable(2);\r\n");
      out.write("                self.companyId = ko.observable('1');\r\n");
      out.write("\r\n");
      out.write("                self.fakeSubmit = function()\r\n");
      out.write("                {\r\n");
      out.write("                     alert(\"value: \" + self.code());\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("                self.change = function()\r\n");
      out.write("                {\r\n");
      out.write("                    self.companyId(333);\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            var vm = new SimplePage();\r\n");
      out.write("            ko.applyBindings(vm);\r\n");
      out.write("\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("        <input type=\"text\" data-bind=\"codepicker : code, codeEntity : { codeType : $root.codeType(), companyId : $root.companyId() }\" />\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <button data-bind=\"click : fakeSubmit\">Click </button>\r\n");
      out.write("        <button data-bind=\"click : change\">Click </button>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
