package org.apache.jsp.appCore_Personnel.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class companyConfigurator_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <script language=\"javascript\" src=\"../../js/viewmodal/companyConfiguratorViewModel.js\"></script>\r\n");
      out.write("        <script language=\"javascript\" src=\"../../js/viewmodal/companyHelper.js\"></script>\r\n");
      out.write("        <script language=\"javascript\" src=\"../../js/jstree/jquery.jstree.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("        $(document).ready(function()\r\n");
      out.write("        {\r\n");
      out.write("        try\r\n");
      out.write("        {\r\n");
      out.write("        var vm = new CompanyConfiguratorViewModel(globalViewModel);\r\n");
      out.write("        ko.applyBindings(vm, document.getElementById(\"configureEmployeeGroupForm\"));\r\n");
      out.write("        }\r\n");
      out.write("        catch (ex)\r\n");
      out.write("        {\r\n");
      out.write("        console.log(ex)\r\n");
      out.write("        }\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <form id=\"configureEmployeeGroupForm\">\r\n");
      out.write("\r\n");
      out.write("        <div>\r\n");
      out.write("\r\n");
      out.write("        <input id=\"CreateDivsion\" type=\"button\" data-bind=\"click : createDivision\" style=\"display:block; float:left;\"\r\n");
      out.write("        value=\"CreateDivision\" /> &nbsp;\r\n");
      out.write("        <input id=\"CreateDepartment\" type=\"button\" data-bind=\"click : createDepartment\" style=\"display:block;\r\n");
      out.write("        float:left;\"\r\n");
      out.write("        value=\"CreateDepartment\" /> &nbsp;\r\n");
      out.write("        <input id=\"CreateSection\" type=\"button\" data-bind=\"click : createSection\" style=\"display:block; float:left;\"\r\n");
      out.write("        value=\"CreateSection\" /> &nbsp;\r\n");
      out.write("        <input id=\"CreateUnit\" type=\"button\" data-bind=\"click : createUnit\" style=\"display:block; float:left;\"\r\n");
      out.write("        value=\"CreateUnit\" /> &nbsp;\r\n");
      out.write("        <input id=\"Delete\" type=\"button\" data-bind=\"click : deleteNode\" style=\"display:block; float:left;\"\r\n");
      out.write("        value=\"Delete\"\r\n");
      out.write("        />&nbsp;\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <br/>\r\n");
      out.write("        <br/>\r\n");
      out.write("\r\n");
      out.write("        <div id=\"entityTree\">\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div id=\"companyEntityEditForm\">\r\n");
      out.write("        <div data-bind=\"template : { name : templateToUse } \"> </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/html\" id=\"emptyTemplate\">\r\n");
      out.write("        <div class=\"emptyDiv\"></div>\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/html\" id=\"divisionInfoUpdateTemplate\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowSpacer\">\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"formRowSpacer\">\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"formRowSpacer\">\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowList\">\r\n");
      out.write("        <span class='columnDivider'>\r\n");
      out.write("        <span class=\"labelSection\">Division Name</span>\r\n");
      out.write("        <span class=\"inputSectionForm\"><input type=\"text\" data-bind=\"value : $root.nodeTitle\" placeholder=\"info\r\n");
      out.write("        type\"/></span>\r\n");
      out.write("        </span>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowList\">\r\n");
      out.write("        <span class='columnDivider'>\r\n");
      out.write("        <span class=\"labelSection\">Description</span></span>\r\n");
      out.write("        <span class=\"inputSectionForm\">\r\n");
      out.write("        <input type=\"text\" data-bind=\"value : $root.nodeTitle\" placeholder=\"new description\"/></span>\r\n");
      out.write("        </span>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("        <span class='columnDivider'>\r\n");
      out.write("        <span class=\"labelSection\"></span>\r\n");
      out.write("        <span class=\"inputSectionForm\"><button id=\"addBtn\" class=\"command\" type=\"button\">Save</button><button id=\"addBtn\" class=\"command\" type=\"button\">Cancel</button></span>\r\n");
      out.write("        <span class=\"inputSectionForm\"></span>\r\n");
      out.write("        </span>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/html\" id=\"departmentInfoUpdateTemplate\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowSpacer\">\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"formRowSpacer\">\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"formRowSpacer\">\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowList\">\r\n");
      out.write("\r\n");
      out.write("        <span class='columnDivider'>\r\n");
      out.write("        <span class=\"labelSection\">Department Name</span>\r\n");
      out.write("        <span class=\"inputSectionForm\"><input type=\"text\" data-bind=\"value : $root.nodeTitle\" placeholder=\"info\r\n");
      out.write("        type\"/></span>\r\n");
      out.write("        </span>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowList\">\r\n");
      out.write("\r\n");
      out.write("        <span class='columnDivider'>\r\n");
      out.write("        <span class=\"labelSection\">Description</span></span>\r\n");
      out.write("        <span class=\"inputSectionForm\">\r\n");
      out.write("        <input type=\"text\" data-bind=\"value : $root.nodeTitle\" placeholder=\"new description\"/></span>\r\n");
      out.write("        </span>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("\r\n");
      out.write("        <span class='columnDivider'>\r\n");
      out.write("        <span class=\"labelSection\"></span>\r\n");
      out.write("        <span class=\"inputSectionForm\"><button id=\"addBtn\" class=\"command\" type=\"button\">Save</button><button id=\"addBtn\" class=\"command\" type=\"button\">Cancel</button></span>\r\n");
      out.write("        <span class=\"inputSectionForm\"></span>\r\n");
      out.write("        </span>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </script>\r\n");
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
