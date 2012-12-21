package org.apache.jsp.appCore_Personnel.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class employeeResidenceInfoView_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <link href=\"../../kendo/styles/kendo.custom.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <script language=\"javascript\" src=\"../../js/viewmodal/employeeResidenceViewViewModel.js\"></script>\r\n");
      out.write("        <script language=\"javascript\" src=\"../../js/viewmodal/employeeHelper.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/html\" id=\"employeeResidenceTemplate\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Permanent Add.</div><div class=\"inputSection\" data-bind=\"text:\r\n");
      out.write("        permanentAddress1\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\"></div><div class=\"inputSection\" data-bind=\"text: permanentAddress1\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\"></div><div class=\"inputSection\" data-bind=\"text: permanentAddress3\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">City</div><div class=\"inputSection\" data-bind=\"text: city\">\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Country</div><div class=\"inputSection\" data-bind=\"text:\r\n");
      out.write("        $root.getCountryCode(country)\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Postcode</div><div class=\"inputSection\" data-bind=\"text: postCode\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Tel No</div><div class=\"inputSection\" data-bind=\"text: telNo\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Emergency Contact 1</div><div class=\"inputSection\" data-bind=\"text:\r\n");
      out.write("        emergencyContact1\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Emergency Contact 2</div><div class=\"inputSection\" data-bind=\"text:\r\n");
      out.write("        emergencyContact2\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Contact No 1</div><div class=\"inputSection\" data-bind=\"text: contact1\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Contact No 2</div><div class=\"inputSection\" data-bind=\"text: contact2\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowSpacer\">\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <div class=\"formRow darken\" data-bind=\"visible : $root.getPermission\">\r\n");
      out.write("        <div class=\"labelSection\"></div><div class=\"inputSection\">\r\n");
      out.write("\r\n");
      out.write("        <div id=\"residenceInfoEditCommand\" class=\"maintenanceCommand\">\r\n");
      out.write("\r\n");
      out.write("        <button id=\"residenceEdit\" type=\"button\" data-bind=\"visible : $root.enableAdd, click: $root.editData\"\r\n");
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
      out.write("        <script type=\"text/html\" id=\"employeeResidenceAddTemplate\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Permanent Add.</div><div class=\"inputSection\"> <input type=\"text\" data-bind=\"value\r\n");
      out.write("        :\r\n");
      out.write("        permanentAddress1\" id=\"PermanentAddress1\" /></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\"></div><div class=\"inputSection\"> <input type='text' id='permanentAddress2'\r\n");
      out.write("        data-bind=\"value : permanentAddress2\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\"></div><div class=\"inputSection\"> <input type='text' id='permanentAddress3'\r\n");
      out.write("        data-bind=\"value : permanentAddress3\" /></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">City</div><div class=\"inputSection\"><input type='text' id='City' data-bind=\"value\r\n");
      out.write("        : city\" />\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Country</div><div class=\"inputSection\">\r\n");
      out.write("\r\n");
      out.write("        <select id=\"country\" data-bind=\"options: $root.countryList, optionsText: 'name', optionsValue: 'nid', value :\r\n");
      out.write("        country\">\r\n");
      out.write("        </select>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Postcode</div><div class=\"inputSection\"> <input type='text' id=\"PostCode\"\r\n");
      out.write("        data-bind=\"value : postCode\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Tel No</div><div class=\"inputSection\"> <input type=\"text\" id=\"TelNo\"\r\n");
      out.write("        data-bind=\"value : telNo\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Emergency Contact 1</div><div class=\"inputSection\"> <input type='text'\r\n");
      out.write("        id=\"EmergencyContact1\"\r\n");
      out.write("        data-bind=\"value : emergencyContact1\" />\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Emergency Contact 2</div><div class=\"inputSection\"> <input type='text'\r\n");
      out.write("        id='EmergencyContact2' data-bind=\"value : emergencyContact2\" /></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Contact No 1</div><div class=\"inputSection\"> <input type='text' id='Contact1'\r\n");
      out.write("        data-bind=\"value : contact1\" /></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Contact No 2</div><div class=\"inputSection\"> <input type='text' id='Contact2'\r\n");
      out.write("        data-bind=\"value : contact2\" /></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("         <div class=\"formRowSpacer\">\r\n");
      out.write("         </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow darken\" data-bind=\"visible : $root.getPermission\">\r\n");
      out.write("        <div class=\"labelSection\"></div><div class=\"inputSection\">\r\n");
      out.write("\r\n");
      out.write("        <div id=\"residenceInfoSaveCommand\" class=\"maintenanceCommand\">\r\n");
      out.write("\r\n");
      out.write("        <button id=\"residenceSave\" type=\"button\" data-bind=\"visible : $root.enableAdd, click: $root.saveDataForm\"\r\n");
      out.write("        class=\"command\">Save</button>\r\n");
      out.write("\r\n");
      out.write("        <button id=\"residenceCancel\" type=\"button\" data-bind=\"visible : $root.enableAdd, click: $root.cancelEdit\"\r\n");
      out.write("        class=\"command\">Cancel</button>\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
      out.write("            var request = ajaxCore.sendRequest(globalEmployeeResidenceGetByEmployeeUrl, employeeId, \"get\");\r\n");
      out.write("\r\n");
      out.write("            request.success(function(dataSource)\r\n");
      out.write("            {\r\n");
      out.write("                 var input = { \"id\" : coreEmployeeResidenceViewPage, \"roleId\" : globalViewModel.employeeRole() };\r\n");
      out.write("                 var coreCommand = new CoreCommand();\r\n");
      out.write("                 var result = coreCommand.getPermission(hostAuthorizationUrl, input);\r\n");
      out.write("\r\n");
      out.write("                 var vm = new EmployeeResidenceViewViewModel(dataSource, 0, result.permission, globalCurrentEmployee);\r\n");
      out.write("                 ko.applyBindings(vm, document.getElementById(\"residenceDataContent\"));\r\n");
      out.write("            });\r\n");
      out.write("\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("        <div id=\"residenceDataContent\" data-bind=\"template : {name : templateToUse , foreach :\r\n");
      out.write("        bindingSource}\">\r\n");
      out.write("\r\n");
      out.write("            <div data-bind=\"visible : $root.bindingSource().length == 0\" class=\"emptyData\">\r\n");
      out.write("            <div>\r\n");
      out.write("            <ul>\r\n");
      out.write("\r\n");
      out.write("            <li class='emptyDataSpacer'> </li>\r\n");
      out.write("            <li> No data available.</li>\r\n");
      out.write("            </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
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
