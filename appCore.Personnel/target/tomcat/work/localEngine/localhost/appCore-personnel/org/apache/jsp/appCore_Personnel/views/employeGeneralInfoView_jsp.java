package org.apache.jsp.appCore_Personnel.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class employeGeneralInfoView_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <link href=\"../../kendo/styles/kendo.custom.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("        <script language=\"javascript\" src=\"../../js/viewmodal/employeeHelper.js\"></script>\r\n");
      out.write("        <script language=\"javascript\" src=\"../../js/viewmodal/employeeGeneralInfoViewModel.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/html\" id=\"employeeGeneralInfoTemplate\">\r\n");
      out.write("\r\n");
      out.write("        <h4>General Information</h4>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Employee Id</div><div class=\"inputSection\"> </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Name</div><div class=\"inputSection\" data-bind=\"text: name\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"sectionalFormView\">\r\n");
      out.write("        <div class=\"leftSection\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Salutation</div><div class=\"inputSection\" data-bind=\"text:\r\n");
      out.write("        $root.getSalutationCode(salutation)\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">First name</div><div class=\"inputSection\" data-bind=\"text: firstName\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Middle Name</div><div class=\"inputSection\" data-bind=\"text: middleName\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Last Name </div><div class=\"inputSection\" data-bind=\"text: lastName\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <span class=\"formRowRuler\"></span>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"sectionalFormView\">\r\n");
      out.write("        <div class=\"leftSection\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Gender</div><div class=\"inputSection\" data-bind=\"text:\r\n");
      out.write("        $root.getGenderCode(gender)\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"sectionalFormView\">\r\n");
      out.write("        <div class=\"leftSection\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Birth Date</div><div class=\"inputSection\" data-bind=\"text: birthDate\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Age</div><div class=\"inputSection\" data-bind=\"text: age\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"sectionalFormView\">\r\n");
      out.write("        <div class=\"leftSection\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Marital Status</div><div class=\"inputSection\" data-bind=\"text:\r\n");
      out.write("        $root.getMaritalStatusCode(maritalStatus)\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Marriage Date</div><div class=\"inputSection\" data-bind=\"text: marriageDate\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <span class=\"formRowRuler\"></span>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Race</div><div class=\"inputSection\" data-bind=\"text:\r\n");
      out.write("        $root.getRaceCode(race)\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Religion</div><div class=\"inputSection\" data-bind=\"text:\r\n");
      out.write("        $root.getReligionCode(religion)\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Nationality</div><div class=\"inputSection\" data-bind=\"text:\r\n");
      out.write("        $root.getNationalityCode(nationality)\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Country Origin</div><div class=\"inputSection\" data-bind=\"text:\r\n");
      out.write("        $root.getCountryCode(countryOrigin)\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/html\" id=\"employeeGeneralInfoAddTemplate\">\r\n");
      out.write("\r\n");
      out.write("        <h4>General Information</h4>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Employee Id</div><div class=\"inputSection\"> </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Name</div><div class=\"inputSection\"> <input\r\n");
      out.write("        type=\"text\" id=\"Name\"  data-bind=\"value : name\" /></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"sectionalFormView\">\r\n");
      out.write("        <div class=\"leftSection\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Salutation</div><div class=\"inputSection\" data-bind=\"text:\r\n");
      out.write("        $root.getSalutationCode(salutation)\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">First name</div><div class=\"inputSection\" data-bind=\"text: firstName\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Middle Name</div><div class=\"inputSection\" data-bind=\"text: middleName\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Last Name </div><div class=\"inputSection\" data-bind=\"text: lastName\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <span class=\"formRowRuler\"></span>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"sectionalFormView\">\r\n");
      out.write("        <div class=\"leftSection\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Gender</div><div class=\"inputSection\" data-bind=\"text:\r\n");
      out.write("        $root.getGenderCode(gender)\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"sectionalFormView\">\r\n");
      out.write("        <div class=\"leftSection\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Birth Date</div><div class=\"inputSection\" data-bind=\"text: birthDate\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Age</div><div class=\"inputSection\" data-bind=\"text: age\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"sectionalFormView\">\r\n");
      out.write("        <div class=\"leftSection\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Marital Status</div><div class=\"inputSection\" data-bind=\"text:\r\n");
      out.write("        $root.getMaritalStatusCode(maritalStatus)\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Marriage Date</div><div class=\"inputSection\" data-bind=\"text: marriageDate\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <span class=\"formRowRuler\"></span>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Race</div><div class=\"inputSection\" data-bind=\"text:\r\n");
      out.write("        $root.getRaceCode(race)\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Religion</div><div class=\"inputSection\" data-bind=\"text:\r\n");
      out.write("        $root.getReligionCode(religion)\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Nationality</div><div class=\"inputSection\" data-bind=\"text:\r\n");
      out.write("        $root.getNationalityCode(nationality)\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Country Origin</div><div class=\"inputSection\" data-bind=\"text:\r\n");
      out.write("        $root.getCountryCode(countryOrigin)\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        $(document).ready(function()\r\n");
      out.write("        {\r\n");
      out.write("\r\n");
      out.write("            var ajaxCore = new AjaxCore();\r\n");
      out.write("            var request = ajaxCore.sendRequest(globalEmployeeGeneralInfoListUrl, null, \"get\");\r\n");
      out.write("            var vm;\r\n");
      out.write("\r\n");
      out.write("        request.success(function(dataSource)\r\n");
      out.write("            {\r\n");
      out.write("                if (globalCurrentEmployee == null)\r\n");
      out.write("                {\r\n");
      out.write("                    vm = new EmployeeGeneralInfoViewModel(dataSource);\r\n");
      out.write("                }\r\n");
      out.write("                else\r\n");
      out.write("                {\r\n");
      out.write("                    vm = new EmployeeGeneralInfoViewModel(dataSource, 1);\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("                // var vm = new EmployeeGeneralInfoViewModel(dataSource);\r\n");
      out.write("                ko.applyBindings(vm, document.getElementById(\"companyGeneralInfo\"));\r\n");
      out.write("            });\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("        <div id=\"companyGeneralInfo\" class=\"formEntry\" data-bind=\"template : { name : templateToUse,\r\n");
      out.write("        foreach : bindingSource }\">\r\n");
      out.write("        </div>\r\n");
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
