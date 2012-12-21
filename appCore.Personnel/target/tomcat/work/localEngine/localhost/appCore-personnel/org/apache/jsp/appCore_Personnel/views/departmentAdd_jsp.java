package org.apache.jsp.appCore_Personnel.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class departmentAdd_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("        var gridUrl = globalHostname + \"/app/Core/DepartmentInfo\";\r\n");
      out.write("        var departmentPage = \"department.jsp\";\r\n");
      out.write("\r\n");
      out.write("        var model = {\r\n");
      out.write("        id : \"nid\",\r\n");
      out.write("        fields:\r\n");
      out.write("        {\r\n");
      out.write("        nid: { editable: false },\r\n");
      out.write("        type: { type: \"string\" },\r\n");
      out.write("        value : { validation: { required: true } },\r\n");
      out.write("        description: { type: \"string\" },\r\n");
      out.write("        category: { validation: { required: true } }\r\n");
      out.write("        }\r\n");
      out.write("        };\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        var columns = { columns : [\r\n");
      out.write("        {\r\n");
      out.write("        field: \"type\",\r\n");
      out.write("        width: 90,\r\n");
      out.write("        title: \"Type\"\r\n");
      out.write("        },\r\n");
      out.write("        {\r\n");
      out.write("        field: \"value\",\r\n");
      out.write("        width: 90,\r\n");
      out.write("        title: \"Value\"\r\n");
      out.write("        },\r\n");
      out.write("        {\r\n");
      out.write("        field: \"description\",\r\n");
      out.write("        width: 90,\r\n");
      out.write("        title: \"Description\"\r\n");
      out.write("        },\r\n");
      out.write("        {\r\n");
      out.write("        field: \"category\",\r\n");
      out.write("        width: 90,\r\n");
      out.write("        title: \"Category\"\r\n");
      out.write("        }\r\n");
      out.write("        ]};\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        var addLinkInfo = {\r\n");
      out.write("        \"text\" : \"Add\",\r\n");
      out.write("        \"link\" : departmentPage,\r\n");
      out.write("        \"commandId\" : 'departmentAdd',\r\n");
      out.write("        \"targetControlId\" : \"#departmentCommand\",\r\n");
      out.write("        \"callback\" : function() { saveForm(); }\r\n");
      out.write("        };\r\n");
      out.write("\r\n");
      out.write("        var updateLinkInfo = {\r\n");
      out.write("        \"text\" : \"Update\",\r\n");
      out.write("        \"link\" : departmentPage\r\n");
      out.write("        };\r\n");
      out.write("\r\n");
      out.write("        var gridId = \"gridDepartment\";\r\n");
      out.write("        var formName = \"departmentform\";\r\n");
      out.write("\r\n");
      out.write("        $(document).ready(function()\r\n");
      out.write("        {\r\n");
      out.write("        $(\"#\" + formName).validationEngine();\r\n");
      out.write("\r\n");
      out.write("        var gridDataObject =\r\n");
      out.write("        {\r\n");
      out.write("        \"gridUrl\" : gridUrl,\r\n");
      out.write("        \"columns\" : columns,\r\n");
      out.write("        \"model\" : model,\r\n");
      out.write("        \"addLinkInfo\" : addLinkInfo,\r\n");
      out.write("        \"updateLinkInfo\" : updateLinkInfo,\r\n");
      out.write("        \"controlId\" : gridId,\r\n");
      out.write("        \"appearance\" : globalCoreGridAppearanceToobarCreateCancel,\r\n");
      out.write("        \"editorMode\" : \"Insert\"\r\n");
      out.write("        };\r\n");
      out.write("\r\n");
      out.write("        var input = { \"id\" : coreDepartmentPage, \"roleId\" : 1 };\r\n");
      out.write("        var coreCommand = new CoreCommand();\r\n");
      out.write("        coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);\r\n");
      out.write("\r\n");
      out.write("        $(\".cancelCommand\").click(function()\r\n");
      out.write("        {\r\n");
      out.write("        var result = cancelFormChanges();\r\n");
      out.write("        if (result)\r\n");
      out.write("        preparePageForLoading(departmentPage);\r\n");
      out.write("        });\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        function saveForm()\r\n");
      out.write("        {\r\n");
      out.write("        var isValid = $(\"#\" + formName).validationEngine('validate');\r\n");
      out.write("\r\n");
      out.write("        if (!isValid)\r\n");
      out.write("        return;\r\n");
      out.write("\r\n");
      out.write("        if ($(\"#\" + formName).validationEngine('validate'));\r\n");
      out.write("        {\r\n");
      out.write("\r\n");
      out.write("        var departmentInfoData = [];\r\n");
      out.write("\r\n");
      out.write("        var grid = $(\"#\" + gridId).data(\"kendoGrid\").dataSource.data();\r\n");
      out.write("        $.each(grid, function (i, dataItem)\r\n");
      out.write("        {\r\n");
      out.write("        var departmentInfo = new DepartmentInfo();\r\n");
      out.write("        departmentInfo.type = dataItem.type;\r\n");
      out.write("        departmentInfo.value = dataItem.value;\r\n");
      out.write("        departmentInfo.description = dataItem.description;\r\n");
      out.write("        departmentInfo.category = dataItem.category;\r\n");
      out.write("        departmentInfoData.push(departmentInfo);\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        var department = new Department();\r\n");
      out.write("        department.departmentCode = $(\"#DepartmentCode\").val();\r\n");
      out.write("        department.departmentName = $(\"#DepartmentName\").val();\r\n");
      out.write("        department.remark = $(\"#Remark\").val();\r\n");
      out.write("        department.enabled = $('#Enabled').is(\":checked\");\r\n");
      out.write("        department.departmentInfo = departmentInfoData;\r\n");
      out.write("\r\n");
      out.write("        var ajaxCore = new AjaxCore();\r\n");
      out.write("        var request = ajaxCore.sendRequestType(globalHostname + \"/app/Core/Department/add\", department, \"post\");\r\n");
      out.write("\r\n");
      out.write("        request.success(function(data, status, xhrObj)\r\n");
      out.write("        {\r\n");
      out.write("        preparePageForLoading(departmentPage);\r\n");
      out.write("        });\r\n");
      out.write("        }\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("        <form id=\"departmentform\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"form\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"sectionalForm\">\r\n");
      out.write("        <div class=\"leftSection\">\r\n");
      out.write("        <div class=\"labelSection\">Department Code</div><span class='req'>*</span><div class=\"inputSection\"><input\r\n");
      out.write("        type=\"text\" id=\"DepartmentCode\" class=\"validate[required, maxSize[10]]\" value=\"DepartmentCode\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"rightSection\">\r\n");
      out.write("        <div class=\"inlineLabelSection\">Disabled</div><div class=\"inlineLabelSection\"><input type=\"checkbox\"\r\n");
      out.write("        id=\"Enabled\" value=\"Disabled\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("        <div class=\"labelSection\">Department Name</div><span class='req'>*</span><div class=\"inputSection\"><input\r\n");
      out.write("        type=\"text\" class=\"validate[required, maxSize[20]]\" id=\"DepartmentName\" value=\"DepartmentName\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("        <div class=\"labelSection\">Description</div><span class='req'>*</span><div class=\"inputSection\"><input\r\n");
      out.write("        type=\"text\" id=\"Description\" class=\"validate[smaxSize[80]]\" value=\"Description\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div> <div class=\"maintenanceCommandSpace\"></div>\r\n");
      out.write("        <div id=\"departmentCommand\" class=\"maintenanceCommand\">\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div>&nbsp;</div>\r\n");
      out.write("\r\n");
      out.write("        <div>\r\n");
      out.write("        <div> Department Info </div>\r\n");
      out.write("        <div id=\"gridDepartment\" style=\"height: 380px\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        </form>\r\n");
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
