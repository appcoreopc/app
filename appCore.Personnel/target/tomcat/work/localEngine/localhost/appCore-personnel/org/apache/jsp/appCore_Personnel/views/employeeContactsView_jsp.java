package org.apache.jsp.appCore_Personnel.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class employeeContactsView_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <link href=\"../../css/employeeGeneralForm.css\" media=\"screen\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\r\n");
      out.write("        <script language=\"javascript\" src=\"../../js/viewmodal/employeeContactViewViewModel.js\"></script>\r\n");
      out.write("        <script language=\"javascript\" src=\"../../js/viewmodal/employeeHelper.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/html\" id=\"employeeContactTemplate\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Email</div><div class=\"inputSection\" data-bind=\"text: email\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">H/P</div><div class=\"inputSection\" data-bind=\"text: mobileNo\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Alternate Email</div><div class=\"inputSection\" data-bind=\"text:\r\n");
      out.write("        alternateEmail\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Ext No</div><div class=\"inputSection\" data-bind=\"text: extNo\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Correspondence Address </div><div\r\n");
      out.write("        class=\"inputSection\" data-bind=\"text: correspondenceAddress1\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\"></div><div class=\"inputSection\" data-bind=\"text: correspondenceAddress2\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\"></div><div class=\"inputSection\" data-bind=\"text: correspondenceAddress3\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">City</div><div class=\"inputSection\" data-bind=\"text: city\"></div>\r\n");
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
      out.write("\r\n");
      out.write("        <div class=\"formRowSpacer\">\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow darken\" data-bind=\"visible : $root.getPermission\">\r\n");
      out.write("        <div class=\"labelSection\"></div><div class=\"inputSection\">\r\n");
      out.write("\r\n");
      out.write("        <div id=\"contactInfoEditCommand\" class=\"maintenanceCommand\">\r\n");
      out.write("\r\n");
      out.write("        <button id=\"contactEdit\" type=\"button\" data-bind=\"visible : $root.enableAdd, click: $root.editData\">\r\n");
      out.write("        <i class=\"icon-edit editCommandIcon\"></i>Edit</button>\r\n");
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
      out.write("        <script type=\"text/html\" id=\"employeeContactAddTemplate\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Email</div><div class=\"inputSection\"> <input type='text' id='email'\r\n");
      out.write("        data-bind=\"value: email\" /></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">H/P</div><div class=\"inputSection\"> <input type='text' id='mobileNo'\r\n");
      out.write("        data-bind=\"value: mobileNo\" /></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Alternate Email</div><div class=\"inputSection\"> <input type='text'\r\n");
      out.write("        id='alternateEmail' data-bind=\"value: alternateEmail\" /></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Ext No</div><div class=\"inputSection\"> <input type='text' id='ExtNo'\r\n");
      out.write("        data-bind=\"text: extNo\" /></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Correspondence Address </div><div\r\n");
      out.write("        class=\"inputSection\"><input type='text' id='CorrespondenceAddress1' data-bind=\"text:\r\n");
      out.write("        correspondenceAddress1\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\"></div><div class=\"inputSection\"> <input type='text' id='CorrespondenceAddress2'\r\n");
      out.write("        data-bind=\"text: correspondenceAddress2\" /></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\"></div><div class=\"inputSection\"> <input type='text' id='CorresspondenceAddress3'\r\n");
      out.write("        data-bind=\"text: correspondenceAddress3\" /></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">City</div><div class=\"inputSection\"> <input type='text' id='City' data-bind=\"text:\r\n");
      out.write("        city\" /></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Country</div><div class=\"inputSection\">\r\n");
      out.write("\r\n");
      out.write("        <select id=\"gender\" data-bind=\"options: $root.countryList, optionsText: 'name', optionsValue: 'nid', value:\r\n");
      out.write("        country\">\r\n");
      out.write("        </select>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Postcode</div><div class=\"inputSection\"> <input type='text' id='PostCode'\r\n");
      out.write("        data-bind=\"text: postCode\" /></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <div class=\"viewLabelSection\">Tel No</div><div class=\"inputSection\"> <input type='text' id='TelNo'\r\n");
      out.write("        data-bind=\"text: telNo\" /></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow darken\">\r\n");
      out.write("        <div class=\"labelSection\"></div><div class=\"inputSection\">\r\n");
      out.write("\r\n");
      out.write("        <div id=\"employeeAddContactCommand\" class=\"maintenanceCommand\">\r\n");
      out.write("        <button id=\"contactInfoSave\" type=\"button\" data-bind=\"visible : $root.enableAdd, click: $root.saveDataForm\"> <i class=\"icon-ok saveCommandIcon\"></i>Save</button>\r\n");
      out.write("\r\n");
      out.write("        <button id=\"contactCancel\" type=\"button\" data-bind=\"visible : $root.enableAdd, click: $root.cancelEdit\"> <i class=\"icon-cancel saveCommandIcon\"></i>Cancel</button>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowSpacer\">\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowView\">\r\n");
      out.write("        <span class=\"formRowRuler\"></span>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        $(document).ready(function()\r\n");
      out.write("        {\r\n");
      out.write("            if (globalViewModel.targetId != null && globalViewModel.applicationScopeType() == coreApplicationTypeEmployee)\r\n");
      out.write("            {\r\n");
      out.write("                var ajaxCore = new AjaxCore();\r\n");
      out.write("                var employeeId = { id : globalViewModel.targetId()  };\r\n");
      out.write("                var request = ajaxCore.sendRequest(globalEmployeeContactGetByEmployeeUrl, employeeId, \"get\");\r\n");
      out.write("\r\n");
      out.write("                request.success(function(dataSource)\r\n");
      out.write("                {\r\n");
      out.write("                    var input = { \"id\" : coreEmployeeContactViewPage, \"roleId\" : globalViewModel.employeeRole() };\r\n");
      out.write("                    var coreCommand = new CoreCommand();\r\n");
      out.write("                    var result = coreCommand.getPermission(hostAuthorizationUrl, input);\r\n");
      out.write("\r\n");
      out.write("                    var vm = new EmployeeContactViewViewModel(dataSource, 0, result.permission, globalCurrentEmployee);\r\n");
      out.write("                    ko.applyBindings(vm, document.getElementById(\"contactDataContent\"));\r\n");
      out.write("                });\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("            <div id=\"contactDataContent\">\r\n");
      out.write("\r\n");
      out.write("            <div data-bind=\"visible : bindingSource().length == 0\" class=\"emptyData\">\r\n");
      out.write("                <div>\r\n");
      out.write("                <ul>\r\n");
      out.write("                    <li class='emptyDataSpacer'> </li>\r\n");
      out.write("                    <li> No data available.</li>\r\n");
      out.write("                </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div data-bind=\"template : {name : templateToUse, foreach :\r\n");
      out.write("                bindingSource}\">\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("         </div>");
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
