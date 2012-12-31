package org.apache.jsp.appCore_Personnel.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class employeeAddFamily_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <link href=\"../../css/employeeGeneralAddForm.css\" media=\"screen\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("        <script language=\"javascript\" src=\"../../js/viewmodal/employeeHelper.js\"></script>\r\n");
      out.write("        <script language=\"javascript\" src=\"../../js/viewmodal/employeeFamilyViewModel.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("        $(document).ready(function()\r\n");
      out.write("        {\r\n");
      out.write("            $(\"#FamilyForm\").validationEngine();\r\n");
      out.write("\r\n");
      out.write("            var vm = new EmployeeFamilyViewModel(0);\r\n");
      out.write("\r\n");
      out.write("            var gridDataObject = vm.getView();\r\n");
      out.write("            var input = vm.getRole();\r\n");
      out.write("\r\n");
      out.write("            var coreCommand = new CoreCommand();\r\n");
      out.write("            coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);\r\n");
      out.write("\r\n");
      out.write("            $(document).unbind(\"parseComplete\");\r\n");
      out.write("\r\n");
      out.write("            $(document).bind(\"parseComplete\", function()\r\n");
      out.write("            {\r\n");
      out.write("                ko.applyBindings(vm, document.getElementById(\"familyAddDetailInfo\"));\r\n");
      out.write("            });\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("        <form id=\"FamilyForm\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div id=\"familyAddDetailInfo\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"sectionalForm\">\r\n");
      out.write("        <div class=\"leftSection\">\r\n");
      out.write("        <div class=\"labelSection\">Member Name</div><div class=\"inputSection\"><input type=\"text\" id=\"MemberName\"\r\n");
      out.write("        data-bind=\"value: memberName\" class=\"validate[required], maxSize[30]\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"rightSection\">\r\n");
      out.write("        <div class=\"inlineLabelSection\">Member Type</div><div class=\"inlineLabelSection\"><input type=\"text\"\r\n");
      out.write("        id=\"MemberType\" data-bind=\"value: memberType\" class=\"validate[required]\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"sectionalForm\">\r\n");
      out.write("        <div class=\"leftSection\">\r\n");
      out.write("        <div class=\"labelSection\">Birth Date</div><div class=\"inputSection\"><input type=\"text\" id=\"BirthDate\"\r\n");
      out.write("        data-bind=\"datepicker: birthDate, datepickerOptions : { dateFormat : 'dd-mm-yy'}\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"rightSection\">\r\n");
      out.write("        <div class=\"inlineLabelSection\">Age</div><div class=\"inlineLabelSection\"><input type=\"text\" id=\"Age\"\r\n");
      out.write("        data-bind=\"value: age\" class=\"validate[required], custom[integer]\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"sectionalForm\">\r\n");
      out.write("        <div class=\"leftSection\">\r\n");
      out.write("        <div class=\"labelSection\">Salutation</div><div class=\"inputSection\">\r\n");
      out.write("\r\n");
      out.write("        <select id=\"Salutation\" data-bind=\"options: salutationList, optionsText: 'name', optionsValue: 'nid', value:\r\n");
      out.write("        salutation\" name=\"Salutation\">\r\n");
      out.write("        </select>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"rightSection\">\r\n");
      out.write("        <div class=\"inlineLabelSection\">Gender</div><div class=\"inlineLabelSection\">\r\n");
      out.write("\r\n");
      out.write("        <select id=\"Gender\" data-bind=\"options: genderList, optionsText: 'name', optionsValue: 'nid', value: gender\"\r\n");
      out.write("        name=\"Gender\">\r\n");
      out.write("        </select>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"sectionalForm\">\r\n");
      out.write("        <div class=\"labelSection\">Marital status</div><div class=\"inputSection\">\r\n");
      out.write("\r\n");
      out.write("        <select id=\"MaritalStatus\" data-bind=\"options: maritalStatusList, optionsText: 'name', optionsValue: 'nid',\r\n");
      out.write("        value: maritalStatus\" name=\"MaritalStatus\">\r\n");
      out.write("        </select>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"sectionalForm\">\r\n");
      out.write("        <div class=\"labelSection\">I/C No</div><div class=\"inputSection\"><input type=\"text\" id=\"IdentificationNo\"\r\n");
      out.write("        data-bind=\"value: identificationNo\" class=\"validate[required], maxSize[20]\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"sectionalForm\">\r\n");
      out.write("        <div class=\"labelSection\">Working</div><div class=\"inputSection\"><input type=\"checkbox\" data-bind=\"checked:\r\n");
      out.write("        working\" /></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"sectionalForm\">\r\n");
      out.write("        <div class=\"labelSection\">Studying</div><div class=\"inputSection\"><input type=\"checkbox\" data-bind=\"checked:\r\n");
      out.write("        studying\" /></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"sectionalForm\">\r\n");
      out.write("        <div class=\"labelSection\">Handicap</div><div class=\"inputSection\"><input type=\"checkbox\" data-bind=\"checked:\r\n");
      out.write("        handicap\" /></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"sectionalForm\">\r\n");
      out.write("        <div class=\"labelSection\">Nominated Spouse</div><div class=\"inputSection\"><input type=\"checkbox\"\r\n");
      out.write("        data-bind=\"checked: nominatedSpouse\" /></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"sectionalForm\">\r\n");
      out.write("        <div class=\"labelSection\">Attachments</div><div class=\"inputSection\"><input type=\"text\" id=\"Attachments\"\r\n");
      out.write("        data-bind=\"value: attachments\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"sectionalForm\">\r\n");
      out.write("        <div class=\"labelSection\">Remarks</div><div class=\"inputSection\"><input type=\"text\" id=\"Remarks\"\r\n");
      out.write("        data-bind=\"value: remarks\" class=\"validate[required], maxSize[40]\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"sectionalForm\">\r\n");
      out.write("        <div></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"sectionalForm\">\r\n");
      out.write("        <div id=\"userCommand\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
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
