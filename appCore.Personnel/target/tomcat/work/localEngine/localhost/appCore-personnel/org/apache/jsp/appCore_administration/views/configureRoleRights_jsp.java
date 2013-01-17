package org.apache.jsp.appCore_administration.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class configureRoleRights_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("    <link href=\"../../css/employeeGroup.css\" media=\"screen\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("        <script language=\"javascript\" src=\"../../js/viewmodal/Administration/configureRoleRightsViewModel.js\"></script>\r\n");
      out.write("        <script language=\"javascript\" src=\"../../js/viewmodal/Administration/userHelper.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("        $(document).ready(function()\r\n");
      out.write("        {\r\n");
      out.write("        var vm = new ConfigureRoleRightsViewModel(globalViewModel);\r\n");
      out.write("        ko.applyBindings(vm, document.getElementById(\"configureEmployeeGroupForm\"));\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("        <form id=\"configureEmployeeGroupForm\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"form\">\r\n");
      out.write("        <div class=\"sectionalForm\">\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("        &nbsp;\r\n");
      out.write("\r\n");
      out.write("        <div class=\"labelSectionBlock\">Role</div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"inputSection\">\r\n");
      out.write("        <select id=\"allEmployeeGroupList\" data-bind=\"options: allRolesList, optionsText: 'rolename', optionsValue:\r\n");
      out.write("        'rolename', optionsCaption : 'Choose a role' , value : currentlySelectedGroup\">\r\n");
      out.write("        </select>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("        &nbsp;\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"sectionalForm\">\r\n");
      out.write("        <div class=\"leftSection fixedWidth\">\r\n");
      out.write("        <div class=\"labelSectionBlock\">&nbsp;</div><div class=\"inputSectionList\">\r\n");
      out.write("        Add/Update/Delete\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"rightSection\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"labelSectionBlockRight\"></div><div class=\"inlineLabelSection\">\r\n");
      out.write("        <input type=\"checkbox\" id=\"Add\" />\r\n");
      out.write("        <input type=\"checkbox\" id=\"Update\" />\r\n");
      out.write("        <input type=\"checkbox\" id=\"Delete\" />\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("        &nbsp;\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"sectionalForm\">\r\n");
      out.write("        <div class=\"leftSection\">\r\n");
      out.write("        <div class=\"labelSectionBlock\">Modules in system</div><div class=\"inputSectionList\">\r\n");
      out.write("\r\n");
      out.write("        <select multiple=\"true\" id=\"moduleListedInSystem\" data-bind=\"options: moduleNotInGroupList, optionsText:\r\n");
      out.write("        'formId', optionsValue: 'nid', selectedOptions : selectionOfModule\">\r\n");
      out.write("        </select>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"rightSection\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"labelSectionBlockRight\">Modules assigned to current role</div><div class=\"inlineLabelSection\">\r\n");
      out.write("        <select id=\"currentlyAssignedGroup\" data-bind=\"options : rightsCurrentlyAssignedToAGroup, optionsText:\r\n");
      out.write("        'formName', optionsValue: 'formId', selectedOptions : selectionOfEmployeeToRemove \" multiple=\"multiple\">\r\n");
      out.write("        </select>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("        &nbsp;\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("        &nbsp;\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div>\r\n");
      out.write("        <div class=\"command\"><button type=\"button\" id=\"saveBtn\" data-bind=\"click : updateData\">Save Changes</button>\r\n");
      out.write("        <button type=\"button\" id=\"assignToGroup\" data-bind=\"click : assignToGroup\">Assign To Group</button>\r\n");
      out.write("        <button type=\"button\" id=\"removeFromGroup\" data-bind=\"click : removeFromGroup\">Remove From Group</button>\r\n");
      out.write("        <button type=\"button\" id=\"cancelBtn\" data-bind=\"click : cancelUpdate\">Cancel</button>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div>&nbsp;</div>\r\n");
      out.write("        </div>\r\n");
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
