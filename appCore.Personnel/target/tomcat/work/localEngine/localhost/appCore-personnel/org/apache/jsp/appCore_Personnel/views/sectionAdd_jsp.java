package org.apache.jsp.appCore_Personnel.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class sectionAdd_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("    <link href=\"../../css/company.css\" media=\"screen\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("        <link href=\"../../css/dialogBox.css\" media=\"screen\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("        <script language=\"javascript\" src=\"../../js/viewmodal/infoDataViewModel.js\"></script>\r\n");
      out.write("        <script language=\"javascript\" src=\"../../js/viewmodal/sectionInfoViewModel.js\"></script>\r\n");
      out.write("        <script language=\"javascript\" src=\"../../js/jquery.validationEngine-en.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/html\" id=\"infoUpdateTemplate\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowList\">\r\n");
      out.write("\r\n");
      out.write("        <span class='columnDivider'>\r\n");
      out.write("        <span class=\"labelSection\">Category</span>\r\n");
      out.write("        <span class=\"inputSectionForm\"><input type=\"text\" data-bind=\"value : $root.infoCategory\" placeholder=\"info type\"/></span>\r\n");
      out.write("\r\n");
      out.write("        </span>\r\n");
      out.write("\r\n");
      out.write("        <span class='columnDivider'>\r\n");
      out.write("        <span class=\"labelSection\">Description</span></span>\r\n");
      out.write("        <span class=\"inputSectionForm\">\r\n");
      out.write("        <input type=\"text\" data-bind=\"value : $root.infoDescription\" placeholder=\"new description\"/></span>\r\n");
      out.write("        </span>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <span class='columnDivider'>\r\n");
      out.write("        <span class=\"labelSection\">Type</span></span>\r\n");
      out.write("        <span class=\"inputSectionForm\">\r\n");
      out.write("        <input type=\"text\" data-bind=\"value : $root.infoType\" placeholder=\"type\"/></span>\r\n");
      out.write("        </span>\r\n");
      out.write("\r\n");
      out.write("        <span class='columnDivider'>\r\n");
      out.write("        <span class=\"labelSection\">Value</span>\r\n");
      out.write("        <span class=\"inputSectionForm\">\r\n");
      out.write("        <input type=\"text\" data-bind=\"value : $root.infoValue\" placeholder=\"new value\"/></span>\r\n");
      out.write("        </span>\r\n");
      out.write("\r\n");
      out.write("        <span class=\"formRowCommand\">\r\n");
      out.write("        <span class=\"labelSectionCommand\"></span>\r\n");
      out.write("        <span class=\"inputSectionForm\">\r\n");
      out.write("        <button id=\"updateBtn\" type=\"button\" data-bind=\"visible : $root.enableUpdate, click : $root.updateInfoData\"\r\n");
      out.write("        class=\"command\">Update</button>\r\n");
      out.write("\r\n");
      out.write("        <button id=\"cancelUpdateBtn\" type=\"button\" data-bind=\"visible : $root.enableUpdate, click : $root.cancelInfoData\"\r\n");
      out.write("        class=\"command\">Cancel</button>\r\n");
      out.write("\r\n");
      out.write("        </span>\r\n");
      out.write("        </span>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <span class=\"formRowSpacer\">\r\n");
      out.write("        </span>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/html\" id=\"infoViewTemplate\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowList\">\r\n");
      out.write("        <span class='columnDividerListView' data-bind=\"text : infoCategory\"></span>\r\n");
      out.write("        <span class='columnDividerListView' data-bind=\"text : infoDescription\"></span>\r\n");
      out.write("        <span class='columnDividerListView' data-bind=\"text : infoType\"></span>\r\n");
      out.write("        <span class='columnDividerListView' data-bind=\"text : infoValue\"></span>\r\n");
      out.write("        <span class='columnDividerListViewCmd'><a href=\"#\" data-bind=\"visible : $root.enableUpdate, click : $root.editInfoData\">Edit</a></span>\r\n");
      out.write("        <span class='columnDividerListViewCmd'><a href=\"#\" data-bind=\"visible : $root.enableDelete, click : $root.deleteInfoData\">Delete</a></span>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/html\" id=\"infoAddTemplate\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <span class=\"accordianRowHeader\"><icon class=\"icon-plus-circle-1\"></icon></span>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formAddRow\">\r\n");
      out.write("\r\n");
      out.write("        <div class='columnDivider'>\r\n");
      out.write("        <div class=\"labelSection\">Category</div>\r\n");
      out.write("        <div class=\"inputSectionForm\"><input type=\"text\"  data-bind=\"value : $root.addInfoCategory\" placeholder=\"new category\"/></div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class='columnDivider'>\r\n");
      out.write("        <div class=\"labelSection\">Description</div><span class='req'>*</span>\r\n");
      out.write("        <div class=\"inputSectionForm\">\r\n");
      out.write("        <input type=\"text\" data-bind=\"value : $root.addInfoDescription\" placeholder=\"new description\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class='columnDivider'>\r\n");
      out.write("        <div class=\"labelSection\">Type</div><span class='req'>*</span>\r\n");
      out.write("        <div class=\"inputSectionForm\">\r\n");
      out.write("        <input type=\"text\" data-bind=\"value : $root.addInfoType\" placeholder=\"new type\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class='columnDivider'>\r\n");
      out.write("        <div class=\"labelSection\">Value</div><span class='req'>*</span>\r\n");
      out.write("        <div class=\"inputSectionForm\">\r\n");
      out.write("        <input type=\"text\" data-bind=\"value : $root.addInfoValue\" placeholder=\"new value\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <span class=\"formAddRowCommand\">\r\n");
      out.write("        <button id=\"addBtn\" type=\"button\" data-bind=\"visible: $root.enableAdd, click: addInfo\" class=\"command\">Add</button>\r\n");
      out.write("        <button id=\"addCancelBtn\" type=\"button\" data-bind=\"visible: $root.enableAdd, click : $root.closeAddControl\" class=\"command\">Cancel</button>\r\n");
      out.write("        </span>\r\n");
      out.write("\r\n");
      out.write("        <span class=\"formRowSpacer\"></span>\r\n");
      out.write("\r\n");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/html\" id=\"companyEntityAddTemplate\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"form\">\r\n");
      out.write("        <div class=\"sectionalForm\">\r\n");
      out.write("        <div class=\"leftSection\">\r\n");
      out.write("        <div class=\"labelSection\">Section  Code</div><span class='req'>*</span><div class=\"inputSection\"><input\r\n");
      out.write("        class=\"validate[required, maxSize[10]]\" type=\"text\" data-bind=\"value: code\" id=\"SectionCode\" name=\"SectionCode\"\r\n");
      out.write("        placeholder=\"a new section code\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"rightSection\">\r\n");
      out.write("        <div class=\"inlineLabelSection\">Disabled </div><div class=\"inlineLabelSection\"><input type=\"checkbox\"\r\n");
      out.write("        id=\"Enabled\" data-bind=\"checked : disabled\" /></div>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("        <div class=\"labelSection\">Section Name</div><span class='req'>*</span><div class=\"inputSection\"><input\r\n");
      out.write("        type=\"text\" class=\"validate[required, maxSize[80]]\" data-bind=\"value : name\" id=\"SectionName\" placeholder=\"a new section name\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("        <div class=\"labelSection\">Description</div><span class='req'>&nbsp;</span><div class=\"inputSection\"><input\r\n");
      out.write("        type=\"text\" class=\"validate[required, maxSize[80]]\" id=\"Description\" data-bind=\"value : description\"\r\n");
      out.write("        placeholder=\"description for new section\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div> <div class=\"maintenanceCommandSpace\"></div>\r\n");
      out.write("        <div id=\"sectionCommand\" class=\"maintenanceCommand\">\r\n");
      out.write("        <button id=\"saveBtn\" type=\"button\" data-bind=\"visible : enableAdd || enableUpdate, click : updateData\"\r\n");
      out.write("        class=\"command\">Save</button>\r\n");
      out.write("        <button id=\"cancelBtn\" type=\"button\" data-bind=\"click : cancelUpdate\" class=\"command\">Cancel</button>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div>&nbsp;\r\n");
      out.write("        </div>\r\n");
      out.write("        <div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"subHeader\"> Section Info </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowSpacer\"></div>\r\n");
      out.write("\r\n");
      out.write("        <div id=\"accordianSection\" class=\"formRowAddContainer\" data-bind=\"template : { name : 'infoAddTemplate'}, visible : enableAdd \"></div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowSpacer\"></div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"emptyData\" data-bind=\"visible : $root.listInfo().length == 0\">\r\n");
      out.write("        <div>\r\n");
      out.write("        <ul>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <li class=\"emptyDataSpacer\"> </li>\r\n");
      out.write("        <li> No data available.</li>\r\n");
      out.write("        </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRowHeader\" data-bind=\"visible : $root.listInfo().length > 0\">\r\n");
      out.write("        <span class='columnDividerListView'>Category</span>\r\n");
      out.write("        <span class='columnDividerListView'>Description</span>\r\n");
      out.write("        <span class='columnDividerListView'>Type</span>\r\n");
      out.write("        <span class='columnDividerListView'>Value</span>\r\n");
      out.write("        <span class='columnDividerListViewCmd' data-bind='visible: $root.enableUpdate'>Edit</span>\r\n");
      out.write("        <span class='columnDividerListViewCmd' data-bind='visible: $root.enableDelete'>Delete</span>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formList\" data-bind=\"visible : ($root.listInfo().length > 0 && enableUpdate) || ($root.listInfo().length > 0 && enableDelete),\r\n");
      out.write("        template : { name :  infoTemplateToUse, foreach : listInfo}\"></div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("        var formName = \"sectionForm\";\r\n");
      out.write("        $(document).ready(function()\r\n");
      out.write("        {\r\n");
      out.write("            $(\"#\" + formName).validationEngine();\r\n");
      out.write("            var vm = new SectionInfoViewModel(globalViewModel);\r\n");
      out.write("            ko.applyBindings(vm, document.getElementById(\"sectionForm\"));\r\n");
      out.write("            $(\"#accordianSection\").accordion({collapsible : true, active: false});\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("        <form id=\"sectionForm\">\r\n");
      out.write("        <div id=\"sectionMaintenance\" data-bind=\"template : { name : templateToUse} \">\r\n");
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
