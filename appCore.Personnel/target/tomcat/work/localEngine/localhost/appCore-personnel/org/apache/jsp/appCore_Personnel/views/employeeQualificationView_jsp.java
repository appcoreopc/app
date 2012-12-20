package org.apache.jsp.appCore_Personnel.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class employeeQualificationView_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("        <script language=\"javascript\" src=\"../../js/coreDataSourceHelper.js\"></script>\r\n");
      out.write("        <script language=\"javascript\" src=\"../../js/coreListView.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <link href=\"../../kendo/styles/kendo.custom.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/x-kendo-tmpl\" id=\"employeeQualificationTemplate\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Level</div><div class=\"inputSection\">#=level#</div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Field</div><div class=\"inputSection\">Field</div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Major</div><div class=\"inputSection\">Major</div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Institution</div><div class=\"inputSection\">Institution</div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Local/Oversea</div><div class=\"inputSection\">Local/Oversea</div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Start Date</div><div class=\"inputSection\">Start Date</div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">End Date</div><div class=\"inputSection\">End Date</div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Result (CGPA) </div><div class=\"inputSection\">CGPA</div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Attachment</div><div class=\"inputSection\">Attachment</div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Remarks</div><div class=\"inputSection\">QualificationRemark</div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <span class=\"formRowRuler\"></span>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        $(document).ready(function()\r\n");
      out.write("        {\r\n");
      out.write("\r\n");
      out.write("        var ajaxCore = new AjaxCore();\r\n");
      out.write("        var request = ajaxCore.sendRequest(globalEmployeeQualificationListUrl, null, \"get\");\r\n");
      out.write("\r\n");
      out.write("        request.success(function(dataSource)\r\n");
      out.write("        {\r\n");
      out.write("        var coreListView = new CoreListView();\r\n");
      out.write("        coreListView.createListView(\"qualificationDataContent\", dataSource, \"employeeQualificationTemplate\");\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("        <div id=\"qualificationDataContent\"></div>\r\n");
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
