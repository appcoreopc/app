package org.apache.jsp.appCore_administration.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class usersAdd_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <link href=\"../../css/company.css\" media=\"screen\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\r\n");
      out.write("        <script language=\"javascript\" src=\"../../js/viewmodal/Administration/UsersAddEditViewModel.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("        $(document).ready(function()\r\n");
      out.write("        {\r\n");
      out.write("\r\n");
      out.write("                $(\"#userForm\").validationEngine();\r\n");
      out.write("\r\n");
      out.write("                var vm;\r\n");
      out.write("                var gridDataObject;\r\n");
      out.write("\r\n");
      out.write("                if (globalViewModel != undefined && globalViewModel.targetId() != null)\r\n");
      out.write("                {\r\n");
      out.write("                    vm = new UsersAddEditViewModel(coreModeEdit, globalViewModel.targetId());\r\n");
      out.write("                    gridDataObject = vm.getView();\r\n");
      out.write("                }\r\n");
      out.write("                else\r\n");
      out.write("                {\r\n");
      out.write("                    vm = new UsersAddEditViewModel(coreModeInsert, globalViewModel.targetId());\r\n");
      out.write("                    gridDataObject = vm.getView();\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("                var input = { \"id\" : coreCompanyPage, \"roleId\" : 1 };\r\n");
      out.write("                var coreCommand = new CoreCommand();\r\n");
      out.write("                coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject, vm);\r\n");
      out.write("                ko.applyBindings(vm, document.getElementById(\"companyCodeSetupTabs\"));\r\n");
      out.write("\r\n");
      out.write("                var tab = $(\"#companyCodeSetupTabs\").tabs();\r\n");
      out.write("\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("        <form id=\"userForm\">\r\n");
      out.write("\r\n");
      out.write("        <div id=\"companyCodeSetupTabs\">\r\n");
      out.write("        <ul>\r\n");
      out.write("        <li><a href=\"#companyGeneralInfo\">General</a></li>\r\n");
      out.write("        <li><a href=\"#companyDetailInfo\" data-bind=\"visible : $root.mode > 1\">Manage Rights</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("\r\n");
      out.write("        <div id=\"companyGeneralInfo\" class=\"formEntry\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"sectionalForm\">\r\n");
      out.write("        <div class=\"leftSection\">\r\n");
      out.write("        <div class=\"labelSection\">Username</div><div class=\"inputSection\"><input type=\"text\" id=\"UserName\"\r\n");
      out.write("        data-bind=\"value: userName\" class=\"validate[required], maxSize[10]\"/><i class=\"icon-tag-1\"></i></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"rightSection\">\r\n");
      out.write("        <div class=\"inlineLabelSection\"></div><div class=\"inlineLabelSection\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("        <div class=\"labelSection\">Password</div><div class=\"inputSection\"><input type=\"text\" id=\"Password\"\r\n");
      out.write("        data-bind=\"value: password\" class=\"validate[required], maxSize[30]\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("        <div class=\"labelSection\">Confirm password</div><div class=\"inputSection\"><input type=\"text\" id=\"ConfirmPassword\"\r\n");
      out.write("        data-bind=\"value : confirmPassword\" class=\"validate[required], maxSize[30]\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("        <div class=\"labelSection\">Full Name</div><div class=\"inputSection\"><input type=\"text\" id=\"FullName\"\r\n");
      out.write("        data-bind=\"value : fullName\" /></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("        <div class=\"labelSection\">Email</div><div class=\"inputSection\"><input type=\"text\" id=\"email\"\r\n");
      out.write("        data-bind=\"value : email\" /></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div id=\"companyDetailInfo\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("        <div class=\"labelSection\">Postcode</div><div class=\"inputSection\"><input type=\"text\" id=\"Postcode\"\r\n");
      out.write("        class=\"validate[required]\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"sectionalForm\">\r\n");
      out.write("        <div class=\"leftSection\">\r\n");
      out.write("        <div class=\"labelSection\">Telephone</div><div class=\"inputSection\"><input type=\"text\" id=\"Telephone\"\r\n");
      out.write("        class=\"validate[required]\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"rightSection\">\r\n");
      out.write("        <div class=\"inlineLabelSection\">Fax</div><div class=\"inlineLabelSection\"><input type=\"text\" id=\"Fax\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("        <div class=\"labelSection\">Default Currency</div><div class=\"inputSection\">\r\n");
      out.write("        <select id=\"Currency\" name=\"Currency\" class=\"validate[required]\">\r\n");
      out.write("        </select>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("        <div class=\"labelSection\">Parent Company</div><div class=\"inputSection\"><select id=\"ParentCompany\"></select></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("        <div class=\"labelSection\">Disabled</div><div class=\"inputSection\"><input type=\"checkbox\" id=\"Disabled\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div>&nbsp;</div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("        <div class=\"labelSection\"></div><div class=\"inputSection\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div id=\"maintenanceCodeCommand\" class=\"maintenanceCommand\">\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <div>&nbsp;</div>\r\n");
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
