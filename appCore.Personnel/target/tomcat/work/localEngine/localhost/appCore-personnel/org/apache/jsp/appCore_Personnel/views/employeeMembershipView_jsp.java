package org.apache.jsp.appCore_Personnel.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class employeeMembershipView_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <link href=\"../../css/employeeGeneralForm.css\" media=\"screen\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\r\n");
      out.write("        <script language=\"javascript\" src=\"../../js/viewmodal/employeeMembershipViewViewModel.js\"></script>\r\n");
      out.write("        <script language=\"javascript\" src=\"../../js/viewmodal/employeeHelper.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <link href=\"../../kendo/styles/kendo.custom.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/html\" id=\"employeeMembershipTemplate\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Association</div><div class=\"inputSection\" data-bind=\"text: association\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Member Type</div><div class=\"inputSection\" data-bind=\"text: $root.getMemberTypeCode(memberType())\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Contact Details</div><div class=\"inputSection\" data-bind=\"text:\r\n");
      out.write("        contactDetails\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Start Date</div><div class=\"inputSection\" data-bind=\"text: startDate\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">End Date</div><div class=\"inputSection\" data-bind=\"text: endDate\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Membership period (in months)</div><div\r\n");
      out.write("        class=\"inputSection\" data-bind=\"text: membershipPeriod\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Enrollment Fees</div><div class=\"inputSection\" data-bind=\"text:\r\n");
      out.write("        enrollmentFees\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Membership Fees</div><div class=\"inputSection\" data-bind=\"text:\r\n");
      out.write("        membershipFees\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Attachment</div><div class=\"inputSection\" data-bind=\"text: attachments\"></div>\r\n");
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
      out.write("        class=\"command\"><i class=\"icon-edit editCommandIcon\"></i>Edit</button>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <span class=\"formRowRuler\" data-bind=\"visible : $index() < $root.totalRecordCount()\"></span>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/html\" id=\"employeeMembershipAddTemplate\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Association</div><div class=\"inputSection\"> <input type=\"text\" id=\"Association\" data-bind=\"value : association\" /></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Member Type</div><div class=\"inputSection\">\r\n");
      out.write("\r\n");
      out.write("        <select id=\"MemberType\" data-bind=\"options: $root.associationList, optionsText: 'name', optionsValue: 'nid', value : memberType\">\r\n");
      out.write("        </select>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Contact Details</div><div class=\"inputSection\"> <input type=\"text\" id=\"ContactDetails\" data-bind=\"value :\r\n");
      out.write("        contactDetails\" /></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Start Date</div><div class=\"inputSection\"> <input type=\"text\" id=\"startDate\"  data-bind=\"datepicker: startDate, datepickerOptions: { dateFormat :\r\n");
      out.write("        'dd-mm-yy'}, value: startDate\" /></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">End Date</div><div class=\"inputSection\"> <input type=\"text\" id=\"endDate\"   data-bind=\"datepicker: endDate, datepickerOptions: { dateFormat :\r\n");
      out.write("        'dd-mm-yy'},value : endDate\" /></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Membership period (in months)</div><div\r\n");
      out.write("        class=\"inputSection\"> <input type=\"text\" id=\"MembershipPeriod\" data-bind=\"value : membershipPeriod\" /></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Enrollment Fees</div><div class=\"inputSection\"> <input type=\"text\" id=\"EnrollmentFees\"   data-bind=\"value :\r\n");
      out.write("        enrollmentFees\" /></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Membership Fees</div><div class=\"inputSection\"> <input type=\"text\" id=\"MembershipFees\"  data-bind=\"value :\r\n");
      out.write("        membershipFees\" /></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Attachment</div><div class=\"inputSection\"> <input type=\"text\" id=\"Attachments\"  data-bind=\"value : attachments\" /></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Remarks</div><div class=\"inputSection\"> <input type=\"text\" id=\"Remarks\"  data-bind=\"value : remarks\" /></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowSpacer\">\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow darken\">\r\n");
      out.write("        <div class=\"labelSection\"></div><div class=\"inputSection\">\r\n");
      out.write("\r\n");
      out.write("        <div id=\"employeeAddContactCommand\" class=\"maintenanceCommand\">\r\n");
      out.write("        <button id=\"contactInfoSave\" type=\"button\" data-bind=\"visible : $root.enableAdd, click: $root.saveDataForm\"\r\n");
      out.write("        class=\"command\"><i class=\"icon-ok saveCommandIcon\"></i>Save</button>\r\n");
      out.write("\r\n");
      out.write("        <button id=\"contactCancel\" type=\"button\" data-bind=\"visible : $root.enableAdd, click: $root.cancelEdit\"\r\n");
      out.write("        class=\"command\"><i class=\"icon-cancel saveCommandIcon\"></i>Cancel</button>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        $(document).ready(function()\r\n");
      out.write("        {\r\n");
      out.write("            var ajaxCore = new AjaxCore();\r\n");
      out.write("            var employeeId = { id : globalViewModel.targetId() };\r\n");
      out.write("            var request = ajaxCore.sendRequest(globalEmployeeEmployeeMembershipGetByEmployeeUrl, employeeId, \"get\");\r\n");
      out.write("\r\n");
      out.write("            request.success(function(dataSource)\r\n");
      out.write("            {\r\n");
      out.write("                var input = { \"id\" : coreEmployeeFamilyViewPage, \"roleId\" : globalViewModel.employeeRole() };\r\n");
      out.write("                var coreCommand = new CoreCommand();\r\n");
      out.write("                var result = coreCommand.getPermission(hostAuthorizationUrl, input);\r\n");
      out.write("\r\n");
      out.write("                try {\r\n");
      out.write("                    var vm = new EmployeeMembershipViewViewModel(dataSource, 0, result.permission, globalCurrentEmployee);\r\n");
      out.write("                    ko.applyBindings(vm, document.getElementById(\"membershipDataContent\"));\r\n");
      out.write("                }\r\n");
      out.write("                catch (ex)\r\n");
      out.write("                {\r\n");
      out.write("                    console.log(ex)\r\n");
      out.write("                }\r\n");
      out.write("            });\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("        <div id=\"membershipDataContent\">\r\n");
      out.write("            <div data-bind=\"visible : $root.bindingSource().length == 0\" class=\"emptyData\">\r\n");
      out.write("                <div>\r\n");
      out.write("                    <ul>\r\n");
      out.write("                        <li class='emptyDataSpacer'> </li>\r\n");
      out.write("                        <li> No data available.</li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("        <div data-bind=\"template : {name : templateToUse, foreach : bindingSource}\">\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        </div>");
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
