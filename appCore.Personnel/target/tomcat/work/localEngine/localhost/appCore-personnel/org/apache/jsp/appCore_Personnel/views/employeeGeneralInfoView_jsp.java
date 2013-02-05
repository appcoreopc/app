package org.apache.jsp.appCore_Personnel.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class employeeGeneralInfoView_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <script language=\"javascript\" src=\"../../js/viewmodal/employeeHelper.js\"></script>\r\n");
      out.write("        <script language=\"javascript\" src=\"../../js/viewmodal/employeeGeneralInfoViewModel.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <link href=\"../../css/employeeGeneralAddForm.css\" media=\"screen\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("        <link href=\"../../css/employeeGeneralForm.css\" media=\"screen\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/html\" id=\"employeeGeneralInfoTemplate\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Employee Id</div><div class=\"inputSection\" data-bind=\"text: code\"> </div>\r\n");
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
      out.write("        <div class=\"formRowSpacer\">\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow darken\">\r\n");
      out.write("        <div class=\"labelSection\"></div><div class=\"inputSection\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"maintenanceCommand\">\r\n");
      out.write("\r\n");
      out.write("        <button id=\"generalInfoEdit\" type=\"button\" data-bind=\"visible : $root.enableUpdate, click: $root.editForm\"\r\n");
      out.write("        class=\"command\">Edit</button>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/html\" id=\"employeeGeneralInfoAddTemplate\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div id=\"employeeAddTabs\">\r\n");
      out.write("        <ul>\r\n");
      out.write("        <li><a href=\"#employeeGeneralInfo\">General</a></li>\r\n");
      out.write("        <li><a href=\"#employeeGeneralInfo2\">Basic Info</a></li>\r\n");
      out.write("        <li><a href=\"#employeeGeneralInfo3\">Details</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div id=\"employeeGeneralInfo\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Employee Id</div><div class=\"inputSection\">\r\n");
      out.write("        <input type=\"text\" id=\"Code\" data-bind=\"value : code\" />\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Name</div><div class=\"inputSection\"> <input\r\n");
      out.write("        type=\"text\" id=\"Name\" data-bind=\"value : name\" /></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"sectionalFormView\">\r\n");
      out.write("        <div class=\"leftSection\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Salutation</div><div class=\"inputSection\">\r\n");
      out.write("\r\n");
      out.write("        <select id=\"salutation\" data-bind=\"options: $root.salutationList, optionsText: 'name', optionsValue: 'nid',\r\n");
      out.write("        value : salutation\">\r\n");
      out.write("        </select>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">First name</div><div class=\"inputSection\"> <input type=\"text\" id=\"FirstName\"\r\n");
      out.write("        data-bind=\"value: firstName\" /></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Middle Name</div><div class=\"inputSection\"> <input type=\"text\" id=\"middleName\"\r\n");
      out.write("        data-bind=\"value: middleName\" /></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Last Name </div><div class=\"inputSection\"> <input type=\"text\" id=\"lastName\"\r\n");
      out.write("        data-bind=\"value: lastName\" /></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div id=\"employeeGeneralInfo2\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"sectionalFormView\">\r\n");
      out.write("        <div class=\"leftSection\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Gender</div><div class=\"inputSection\">\r\n");
      out.write("\r\n");
      out.write("        <select id=\"gender\" data-bind=\"options: $root.genderList, optionsText: 'name', optionsValue: 'nid', value :\r\n");
      out.write("        gender\">\r\n");
      out.write("        </select>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"sectionalFormView\">\r\n");
      out.write("        <div class=\"leftSection\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Birth Date</div><div class=\"inputSection\"> <input type=\"text\" id=\"birthDate\"\r\n");
      out.write("        data-bind=\"datepicker: birthDate,\r\n");
      out.write("        datepickerOptions: { dateFormat : 'dd-mm-yy'}, value: birthDate\" /></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Age</div><div class=\"inputSection\"> <input type=\"text\" id=\"age\" data-bind=\"value:\r\n");
      out.write("        age\" /></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"sectionalFormView\">\r\n");
      out.write("        <div class=\"leftSection\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Marital Status</div><div class=\"inputSection\">\r\n");
      out.write("\r\n");
      out.write("        <select id=\"maritalStatus\" data-bind=\"options: $root.maritalStatusList, optionsText: 'name', optionsValue:\r\n");
      out.write("        'nid', value : maritalStatus\">\r\n");
      out.write("        </select>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Marriage Date</div><div class=\"inputSection\"> <input type=\"text\" id=\"MarriageDate\"\r\n");
      out.write("        data-bind=\"datepicker: marriageDate, datepickerOptions: { dateFormat : 'dd-mm-yy'}, value : marriageDate\"\r\n");
      out.write("        /></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div id=\"employeeGeneralInfo3\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Race</div><div class=\"inputSection\">\r\n");
      out.write("\r\n");
      out.write("        <select id=\"race\" data-bind=\"options: $root.raceList, optionsText: 'name', optionsValue: 'nid', value: race\">\r\n");
      out.write("        </select>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Religion</div><div class=\"inputSection\">\r\n");
      out.write("\r\n");
      out.write("        <select id=\"religion\" data-bind=\"options: $root.religionList, optionsText: 'name', optionsValue: 'nid', value:\r\n");
      out.write("        religion\">\r\n");
      out.write("        </select>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"viewLabelSection\">Nationality</div><div class=\"inputSection\">\r\n");
      out.write("\r\n");
      out.write("        <select id=\"nationality\" data-bind=\"options: $root.nationalityList, optionsText: 'name', optionsValue: 'nid',\r\n");
      out.write("        value: nationality\">\r\n");
      out.write("        </select>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Country Origin</div><div class=\"inputSection\">\r\n");
      out.write("\r\n");
      out.write("        <select id=\"country\" data-bind=\"options: $root.countryList, optionsText: 'name', optionsValue: 'nid', value:\r\n");
      out.write("        countryOrigin\">\r\n");
      out.write("        </select>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowSpacer\">\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow darken\">\r\n");
      out.write("        <div class=\"labelSection\"></div><div class=\"inputSection\">\r\n");
      out.write("\r\n");
      out.write("        <div id=\"maintenanceCodeCommand\" class=\"maintenanceCommand\">\r\n");
      out.write("        <button id=\"generalInfoSave\" type=\"button\" data-bind=\"visible : $root.enableAdd, click: $root.saveDataForm\"\r\n");
      out.write("        class=\"command\"><i class=\"icon-ok saveCommandIcon\"></i>Save</button>\r\n");
      out.write("\r\n");
      out.write("        <button id=\"generalInfoCancel\" type=\"button\" data-bind=\"visible : $root.enableAdd, click: $root.cancelEdit\"\r\n");
      out.write("        class=\"command\"><i class=\"icon-cancel saveCommandIcon\"></i>Cancel</button>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("        var vm;\r\n");
      out.write("\r\n");
      out.write("        $(document).ajaxStop(function()\r\n");
      out.write("        {\r\n");
      out.write("            try\r\n");
      out.write("            {\r\n");
      out.write("                $(this).unbind(\"ajaxStop\");\r\n");
      out.write("                ko.applyBindings(vm, document.getElementById(\"companyGeneralInfo\"));\r\n");
      out.write("                var tab = $(\"#employeeAddTabs\").tabs();\r\n");
      out.write("            }\r\n");
      out.write("            catch (ex)\r\n");
      out.write("            {\r\n");
      out.write("                console.log(ex)\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        $(document).ready(function()\r\n");
      out.write("        {\r\n");
      out.write("            var input = { \"id\" : coreEmployeeGeneralViewPage, \"roleId\" : globalViewModel.employeeRole() };\r\n");
      out.write("            var coreCommand = new CoreCommand();\r\n");
      out.write("            var result = coreCommand.getPermission(hostAuthorizationUrl, input);\r\n");
      out.write("\r\n");
      out.write("            vm = new EmployeeGeneralInfoViewModel(globalViewModel.editMode(), result.permission, globalViewModel.targetId());\r\n");
      out.write("            vm.getGeneralInfo(globalViewModel.targetId());\r\n");
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
