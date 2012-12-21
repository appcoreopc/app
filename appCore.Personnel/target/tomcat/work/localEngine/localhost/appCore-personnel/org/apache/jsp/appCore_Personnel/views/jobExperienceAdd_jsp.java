package org.apache.jsp.appCore_Personnel.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class jobExperienceAdd_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<script language=\"javascript\" src=\"../../js/viewmodal/jobExperienceViewModel.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">          \r\n");
      out.write("\r\n");
      out.write("\t$(document).ready(function() \r\n");
      out.write("\t{\r\n");
      out.write("\t\t\tvar vm = new JobExperienceViewModel(1);\r\n");
      out.write("\t\t\tvar gridDataObject = vm.getView();\r\n");
      out.write("\t\t\tvar input = { \"id\" : coreJobExperience, \"roleId\" : 1 };\r\n");
      out.write("\t\t\tvar coreCommand = new CoreCommand();\r\n");
      out.write("\t\t\tcoreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);\r\n");
      out.write("\t});\r\n");
      out.write("\t\t\t\r\n");
      out.write("</script>    \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"jobExperienceForm\">\r\n");
      out.write("\t<h1>Experience Requirement</h1>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"maintenanceCommand\">\r\n");
      out.write("        <div id=\"experienceCommand\" class=\"maintenanceCommand\">\r\n");
      out.write("        </div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"formRow\">\t\r\n");
      out.write("\t\t&nbsp;\r\n");
      out.write("    </div>\r\n");
      out.write("    <div>\r\n");
      out.write("\t\t<div id=\"gridJobExperience\" style=\"height: 380px\"></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("</form>");
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
