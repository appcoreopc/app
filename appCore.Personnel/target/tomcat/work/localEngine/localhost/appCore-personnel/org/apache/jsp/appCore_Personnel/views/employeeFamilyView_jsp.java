package org.apache.jsp.appCore_Personnel.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class employeeFamilyView_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <link href=\"../../kendo/styles/kendo.custom.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("        <script language=\"javascript\" src=\"../../js/viewmodal/employeeFamilyViewViewModel.js\"></script>\r\n");
      out.write("        <script language=\"javascript\" src=\"../../js/viewmodal/employeeHelper.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/html\" id=\"employeeFamilyTemplate\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Member Name</div><div class=\"inputSection\" data-bind=\"text: memberName\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Member Type</div><div class=\"inputSection\" data-bind=\"text:\r\n");
      out.write("        $root.getMemberTypeCode(memberType())\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Birth Date</div><div class=\"inputSection\" data-bind=\"text: birthDate\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Age</div><div class=\"inputSection\" data-bind=\"text: age\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Salutation</div><div class=\"inputSection\" data-bind=\"text:\r\n");
      out.write("        $root.getSalutationCode(salutation())\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Gender</div><div class=\"inputSection\" data-bind=\"text:\r\n");
      out.write("        $root.getGenderCode(gender())\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Marital status</div><div class=\"inputSection\" data-bind=\"text:\r\n");
      out.write("        $root.getMaritalStatusCode(maritalStatus())\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">I/C No</div><div class=\"inputSection\" data-bind=\"text: identificationNo\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Working</div><div class=\"inputSection\" data-bind=\"text: working\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Studying</div><div class=\"inputSection\" data-bind=\"text: studying\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Handicap</div><div class=\"inputSection\" data-bind=\"text: handicap\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Nominated Spouse</div><div class=\"inputSection\" data-bind=\"text:\r\n");
      out.write("        nominatedSpouse\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Attachments</div><div class=\"inputSection\" data-bind=\"text: attachments\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Remarks</div><div class=\"inputSection\" data-bind=\"text: remarks\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowSpacer\">\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow darken\" data-bind=\"visible : $root.getPermission\">\r\n");
      out.write("        <div class=\"labelSection\"></div><div class=\"inputSection\">\r\n");
      out.write("\r\n");
      out.write("        <div id=\"familyInfoEditCommand\" class=\"maintenanceCommand\">\r\n");
      out.write("\r\n");
      out.write("        <button id=\"familyEdit\" type=\"button\" data-bind=\"visible : $root.enableAdd, click: $root.editData\"\r\n");
      out.write("        class=\"command\">Edit</button>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <span class=\"formRowRuler\"></span>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/html\" id=\"employeeFamilyAddTemplate\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Member Name</div><div class=\"inputSection\"> <input type='text' id=\"MemberName\" data-bind=\"value : memberName\" /></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Member Type</div><div class=\"inputSection\">\r\n");
      out.write("\r\n");
      out.write("        <select id=\"MemberType\" data-bind=\"options: $root.familyMemberTypeList, optionsText: 'name', optionsValue: 'nid', value : memberType\">\r\n");
      out.write("        </select>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Birth Date</div><div class=\"inputSection\"> <input type='text' id=\"BirthDate\" data-bind=\"datepicker: birthDate, datepickerOptions: { dateFormat :\r\n");
      out.write("        'dd-mm-yy'}, value : birthDate\" /></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Age</div><div class=\"inputSection\"> <input type='text' id='Age' data-bind=\"value : age\" /></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Salutation</div><div class=\"inputSection\">\r\n");
      out.write("\r\n");
      out.write("        <select id=\"Salutation\" data-bind=\"options: $root.salutationList, optionsText: 'name', optionsValue: 'nid', value : salutation\">\r\n");
      out.write("        </select>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Gender</div><div class=\"inputSection\">\r\n");
      out.write("\r\n");
      out.write("        <select id=\"Gender\" data-bind=\"options: $root.genderList, optionsText: 'name', optionsValue: 'nid', value : gender\">\r\n");
      out.write("        </select>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Marital status</div><div class=\"inputSection\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <select id=\"MaritalStatus\" data-bind=\"options: $root.maritalStatusList, optionsText: 'name', optionsValue: 'nid', value : maritalStatus\">\r\n");
      out.write("        </select>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">I/C No</div><div class=\"inputSection\"> <input type='text' id=\"IdentificationNo\" data-bind=\"value : identificationNo\" /></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Working</div><div class=\"inputSection\"> <input type='checkbox' id=\"Working\" data-bind=\"checked : working\" /></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Studying</div><div class=\"inputSection\"> <input type='checkbox' id=\"Studying\" data-bind=\"checked : studying\" /></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Handicap</div><div class=\"inputSection\"> <input type='checkbox' id=\"HandiCap\" data-bind=\"checked: handicap\" /></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Nominated Spouse</div><div class=\"inputSection\"> <input type='checkbox' id=\"NominatedSpouse\" data-bind=\"checked : nominatedSpouse\" /></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Attachments</div><div class=\"inputSection\">\r\n");
      out.write("        <input type='text' id='Attachments' data-bind=\"value : attachments\" /></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Remarks</div><div class=\"inputSection\"> <input type='text' id='Remarks' data-bind=\"value: remarks\" />\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowSpacer\">\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow darken\">\r\n");
      out.write("        <div class=\"labelSection\"></div><div class=\"inputSection\">\r\n");
      out.write("\r\n");
      out.write("        <div id=\"employeeAddContactCommand\" class=\"maintenanceCommand\">\r\n");
      out.write("        <button id=\"contactInfoSave\" type=\"button\" data-bind=\"visible : $root.enableAdd, click: $root.saveDataForm\"\r\n");
      out.write("        class=\"command\">Save</button>\r\n");
      out.write("\r\n");
      out.write("        <button id=\"contactCancel\" type=\"button\" data-bind=\"visible : $root.enableAdd, click: $root.cancelEdit\"\r\n");
      out.write("        class=\"command\">Cancel</button>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("        $(document).ready(function()\r\n");
      out.write("        {\r\n");
      out.write("            var ajaxCore = new AjaxCore();\r\n");
      out.write("            var employeeId = { id : globalCurrentId.nid };\r\n");
      out.write("            var request = ajaxCore.sendRequest(globalEmployeeFamilyGetByEmployeeUrl, employeeId, \"get\");\r\n");
      out.write("\r\n");
      out.write("            request.success(function(dataSource)\r\n");
      out.write("            {\r\n");
      out.write("                var input = { \"id\" : coreEmployeeFamilyViewPage, \"roleId\" : globalViewModel.employeeRole() };\r\n");
      out.write("                var coreCommand = new CoreCommand();\r\n");
      out.write("                var result = coreCommand.getPermission(hostAuthorizationUrl, input);\r\n");
      out.write("\r\n");
      out.write("                var vm = new EmployeeFamilyViewViewModel(dataSource, 0, result.permission, globalCurrentEmployee);\r\n");
      out.write("                ko.applyBindings(vm, document.getElementById(\"familyDataContent\"));\r\n");
      out.write("            });\r\n");
      out.write("\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("        <div id=\"familyDataContent\" data-bind=\"template : {name : templateToUse, foreach :\r\n");
      out.write("        bindingSource}\">\r\n");
      out.write("\r\n");
      out.write("        <div data-bind=\"visible : $root.bindingSource().length == 0\" class=\"emptyData\">\r\n");
      out.write("        <div>\r\n");
      out.write("        <ul>\r\n");
      out.write("\r\n");
      out.write("        <li class='emptyDataSpacer'> </li>\r\n");
      out.write("        <li> No data available.</li>\r\n");
      out.write("        </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
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
