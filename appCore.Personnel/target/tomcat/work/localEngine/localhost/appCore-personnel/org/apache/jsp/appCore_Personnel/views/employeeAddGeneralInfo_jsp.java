package org.apache.jsp.appCore_Personnel.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class employeeAddGeneralInfo_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("    <link href=\"../../css/themes/base/jquery.ui.all.css\" media=\"screen\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <form id=\"generalInfoForm\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div id=\"companyGeneralInfo\" class=\"formEntry\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("        <div class=\"labelSection\">Employee Id</div><div class=\"inputSection\"><input type=\"text\" id=\"EmployeeId\"\r\n");
      out.write("        value=\"EmployeeId\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("        <div class=\"labelSection\">Name</div><div class=\"inputSection\"><input type=\"text\" id=\"Name\"\r\n");
      out.write("        value=\"Name\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"sectionalForm\">\r\n");
      out.write("        <div class=\"leftSection\">\r\n");
      out.write("        <div class=\"labelSection\">Salutation</div><div class=\"inputSection\">\r\n");
      out.write("\r\n");
      out.write("        <select id=\"Salutation\" name=\"Salutation\">\r\n");
      out.write("        <option value=\"MYR\">Mr</option>\r\n");
      out.write("        <option value=\"USD\">Mrs</option>\r\n");
      out.write("        <option value=\"EUR\">Dr</option>\r\n");
      out.write("        </select>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"rightSection\">\r\n");
      out.write("        <div class=\"inlineLabelSection\">First Name</div><div class=\"inlineLabelSection\"><input type=\"text\"\r\n");
      out.write("        id=\"FirstName\" value=\"FirstName\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"sectionalForm\">\r\n");
      out.write("        <div class=\"leftSection\">\r\n");
      out.write("        <div class=\"labelSection\">Gender</div><div class=\"inputSection\">\r\n");
      out.write("\r\n");
      out.write("        <select id=\"Gender\" name=\"Gender\">\r\n");
      out.write("        <option value=\"M\">Male</option>\r\n");
      out.write("        <option value=\"F\">Female</option>\r\n");
      out.write("\r\n");
      out.write("        </select>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"rightSection\">\r\n");
      out.write("        <div class=\"inlineLabelSection\">Middle Name</div><div class=\"inlineLabelSection\"><input type=\"text\"\r\n");
      out.write("        id=\"Middle Name\" value=\"Middle Name\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"sectionalForm\">\r\n");
      out.write("        <div class=\"leftSection\">\r\n");
      out.write("        <div class=\"labelSection\">Birth Date</div><div class=\"inputSection\">\r\n");
      out.write("\r\n");
      out.write("        <input type=\"text\"\r\n");
      out.write("        id=\"dob\" value=\"dob\"/>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"rightSection\">\r\n");
      out.write("        <div class=\"inlineLabelSection\">Last Name</div><div class=\"inlineLabelSection\"><input type=\"text\"\r\n");
      out.write("        id=\"Last Name\" value=\"Last Name\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("        <div class=\"labelSection\">Age</div><div class=\"inputSection\">\r\n");
      out.write("        <input type=\"text\" id=\"AgeYear\" value=\"AgeYear\"/>YY <input type=\"text\" id=\"AgeMonth\" value=\"AgeMonth\"/>MM</div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"sectionalForm\">\r\n");
      out.write("        <div class=\"leftSection\">\r\n");
      out.write("        <div class=\"labelSection\">Marital Status</div><div class=\"inputSection\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <select id=\"MaritalStatus\" name=\"MaritalStatus\">\r\n");
      out.write("        <option value=\"M\">Married</option>\r\n");
      out.write("        <option value=\"S\">Single</option>\r\n");
      out.write("        <option value=\"D\">Divorced</option>\r\n");
      out.write("\r\n");
      out.write("        </select>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"rightSection\">\r\n");
      out.write("        <div class=\"inlineLabelSection\">Marriage Date</div><div class=\"inlineLabelSection\"><input type=\"text\"\r\n");
      out.write("        id=\"MarriageDate\" value=\"MarriageDate\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("        <div class=\"labelSection\">Race</div><div class=\"inputSection\"><input type=\"text\" id=\"Race\"\r\n");
      out.write("        value=\"Race\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("        <div class=\"labelSection\">Religion</div><div class=\"inputSection\"><input type=\"text\" id=\"Religion\"\r\n");
      out.write("        value=\"Religion\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("        <div class=\"labelSection\">Nationality</div><div class=\"inputSection\"><input type=\"text\" id=\"Nationality\"\r\n");
      out.write("        value=\"Nationality\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("        <div class=\"labelSection\">Country Origin</div><div class=\"inputSection\"><input type=\"text\" id=\"CountryOrigin\"\r\n");
      out.write("        value=\"CountryOrigin\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
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
