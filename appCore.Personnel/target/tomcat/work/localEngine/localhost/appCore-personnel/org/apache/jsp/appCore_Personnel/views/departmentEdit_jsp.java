package org.apache.jsp.appCore_Personnel.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class departmentEdit_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<script type=\"text/javascript\">          \r\n");
      out.write("  \t\r\n");
      out.write("\tvar departmentForm = \"departmentForm\";\r\n");
      out.write("\tvar departmentPage = \"department.jsp\";\r\n");
      out.write("\tvar departmentGrid = \"departmentGrid\";\r\n");
      out.write("\t\t\r\n");
      out.write("\t$(document).ready(function() \r\n");
      out.write("\t{\r\n");
      out.write("\t\tvar value = globalCurrentId.nid;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif (value != null) \r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\tvar ajaxCore = new AjaxCore();\r\n");
      out.write("\t\t\tvar request = ajaxCore.sendRequest(hostname + \"/app/Core/Department/get\", { id : value}, \"get\");\r\n");
      out.write("\t\r\n");
      out.write("\t\t\trequest.success(function(data) \r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\tif (data == null) \r\n");
      out.write("\t\t\t\t\treturn;\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t$(\"#Nid\").val(data.nid);\r\n");
      out.write("\t\t\t\t$(\"#DepartmentCode\").val(data.departmentCode);\r\n");
      out.write("\t\t\t\t$(\"#DepartmentName\").val(data.departmentName);\r\n");
      out.write("\t\t\t\t$(\"#Remark\").val(data.remark);\r\n");
      out.write("\t\t\t\t$(\"#Enabled\").attr(\"checked\", data.enabled);\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\tvar grid = $(\"#\" + departmentGrid).kendoGrid({\r\n");
      out.write("                        dataSource: {\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t  transport: {\r\n");
      out.write("                                read:  {\r\n");
      out.write("                                    url: hostname + \"/app/Core/DepartmentInfo/listByRefEntity?id=\" + value,\r\n");
      out.write("                                    dataType: \"json\"\r\n");
      out.write("                                },\r\n");
      out.write("                                update: {\r\n");
      out.write("                                    url: hostname + \"/app/Core/DepartmentInfo/saveOrUpdate\",\r\n");
      out.write("                                    dataType: \"json\"\r\n");
      out.write("                                },\r\n");
      out.write("                                destroy: {\r\n");
      out.write("                                    url: hostname + \"/app/Core/DepartmentInfo/delete\",\r\n");
      out.write("                                    dataType: \"json\"\r\n");
      out.write("                                },\r\n");
      out.write("                                create: {\r\n");
      out.write("                                    url: hostname + \"/app/Core/DepartmentInfo/add\",\r\n");
      out.write("                                    dataType: \"json\"\r\n");
      out.write("                                } \r\n");
      out.write("\t\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("                            data: data,\r\n");
      out.write("                            pageSize: 10, \r\n");
      out.write("\t\t\t\t\t\t\tschema: {\r\n");
      out.write("                                model: {\r\n");
      out.write("                                    id: \"nid\",\r\n");
      out.write("                                    fields: {\t\r\n");
      out.write("                                        nid: { editable: false },\r\n");
      out.write("                                        type: {  type: \"string\" },\r\n");
      out.write("                                        value : {  validation: { required: true } },\r\n");
      out.write("                                        description: {  type: \"string\" },\r\n");
      out.write("                                        category: {  validation: { required: true } }\r\n");
      out.write("                                    }\r\n");
      out.write("                                }\r\n");
      out.write("                            }\r\n");
      out.write("\t\t\t\t\t\t\t \r\n");
      out.write("                        },\r\n");
      out.write("\t\t\t\t\t\ttoolbar: [\"create\", \"cancel\"],\r\n");
      out.write("\t\t\t\t\t\teditable : true,\r\n");
      out.write("\t\t\t\t\t\tgroupable: false,\r\n");
      out.write("\t\t\t\t\t\tselectable : true,\r\n");
      out.write("                        sortable: true,\r\n");
      out.write("                        pageable: true,\r\n");
      out.write("                        columns: [ \r\n");
      out.write("\t\t\t\t\t\t\t{\r\n");
      out.write("                                field: \"type\",\r\n");
      out.write("                                width: 90,\r\n");
      out.write("                                title: \"Type\"\r\n");
      out.write("                            }, \r\n");
      out.write("\t\t\t\t\t\t\t{\r\n");
      out.write("                                field: \"value\",\r\n");
      out.write("                                width: 90,\r\n");
      out.write("                                title: \"Value\"\r\n");
      out.write("                            },\r\n");
      out.write("\t\t\t\t\t\t\t{\r\n");
      out.write("                                field: \"description\",\r\n");
      out.write("                                width: 90,\r\n");
      out.write("                                title: \"Description\"\r\n");
      out.write("                            }, \r\n");
      out.write("\t\t\t\t\t\t\t{\r\n");
      out.write("                                field: \"category\",\r\n");
      out.write("                                width: 90,\r\n");
      out.write("                                title: \"Category\"\r\n");
      out.write("                            }, \r\n");
      out.write("\t\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\t     command : \"destroy\",  title : \"\", width: 110\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t],\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\tremove : function(e)\r\n");
      out.write("\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\t\t\t\turl: hostname + \"/app/Core/DepartmentInfo/delete\",\r\n");
      out.write("\t\t\t\t\t\t\t\tdata: {\"id\": e.model.nid},\r\n");
      out.write("\t\t\t\t\t\t\t\ttype : \"get\", \r\n");
      out.write("\t\t\t\t\t\t\t\tdataType : \"json\"\r\n");
      out.write("\t\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t    });\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t); \r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(\"#saveBtn\").click(function()\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\tgetValidateData();\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(\"#cancelBtn\").click(function()\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\tvar result = cancelFormChanges();\r\n");
      out.write("\t\t\t\tif (result) \r\n");
      out.write("\t\t\t\t   preparePageForLoading(departmentPage); \r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\tfunction getValidateData()\r\n");
      out.write("\t{\r\n");
      out.write("\t\tvar departmentInfoData = [];\r\n");
      out.write("\t\r\n");
      out.write("        var grid = $(\"#\" + departmentGrid).data(\"kendoGrid\").dataSource.data();\r\n");
      out.write(" \t\t\r\n");
      out.write("\t\t$.each(grid, function (i, dataItem) \r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\tvar departmentInfo = new DepartmentInfo(); \r\n");
      out.write("\t\t\tdepartmentInfo.type = dataItem.type; \r\n");
      out.write("\t\t\tdepartmentInfo.value = dataItem.value;\r\n");
      out.write("\t\t\tdepartmentInfo.description = dataItem.description;\r\n");
      out.write("\t\t\tdepartmentInfo.category = dataItem.category;\r\n");
      out.write("\t\t\tdepartmentInfoData.push(departmentInfo);\r\n");
      out.write("\t\t});\r\n");
      out.write("\t \t\t\r\n");
      out.write("\t\tvar department = new Department();\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tdepartment.nid = $(\"#Nid\").val(); \r\n");
      out.write("\t\tdepartment.departmentCode = $(\"#DepartmentCode\").val(); \r\n");
      out.write("\t\tdepartment.departmentName = $(\"#DepartmentName\").val(); \r\n");
      out.write("\t\tdepartment.remark = $(\"#Remark\").val(); \r\n");
      out.write("\t\tdepartment.enabled = $('#Enabled').is(\":checked\"); \r\n");
      out.write("\t\tdepartment.departmentInfo = departmentInfoData; \t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\tvar ajaxCore = new AjaxCore(); \r\n");
      out.write("\t\tvar request = ajaxCore.sendRequestType(hostname + \"/app/Core/Department/saveOrUpdate\", department, \"post\"); \r\n");
      out.write("\t\t\r\n");
      out.write("\t\trequest.success(function(data, status, xhrObj)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\tgoHome();\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction goHome()\r\n");
      out.write("\t{\r\n");
      out.write("\t\tpreparePageForLoading(departmentPage);\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("</script>    \r\n");
      out.write("\r\n");
      out.write("<form id=\"departmentForm\">\r\n");
      out.write("\r\n");
      out.write("<div class=\"form\">\r\n");
      out.write("\r\n");
      out.write("\t<h1>Department</h1>\r\n");
      out.write("\t<div class=\"formRow\">\r\n");
      out.write("\t\t\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"sectionalForm\"> \r\n");
      out.write("   <div class=\"leftSection\"> <input type=\"hidden\" id=\"Nid\" name=\"Nid\" />\r\n");
      out.write("\t<div class=\"labelSection\">Department Code</div><div class=\"inputSection\"><input type=\"text\" id=\"DepartmentCode\" value=\"DepartmentCode\"/></div>\r\n");
      out.write("   </div> \r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"rightSection\">\r\n");
      out.write("\t\t<div class=\"inlineLabelSection\">Disabled</div><div class=\"inlineLabelSection\"><input type=\"checkbox\" id=\"Enabled\" value=\"Disabled\"/></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("  </div>\r\n");
      out.write("\t\r\n");
      out.write("    <div class=\"formRow\">\r\n");
      out.write("\t\t<div class=\"labelSection\">Department Name</div><div class=\"inputSection\"><input type=\"text\" id=\"DepartmentName\" value=\"DepartmentName\"/></div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"formRow\">\r\n");
      out.write("\t\t<div class=\"labelSection\">Remark</div><div class=\"inputSection\"><input type=\"text\" id=\"Remark\" value=\"Remark\"/></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"formRow\">\t\r\n");
      out.write("\t\t&nbsp;\r\n");
      out.write("    </div>\r\n");
      out.write("\t \r\n");
      out.write("\t<div class=\"maintenanceCommand\"> \r\n");
      out.write("\t\t<button type=\"button\" id=\"saveBtn\">Save changes</button>\r\n");
      out.write("\t\t<button type=\"button\" id=\"cancelBtn\">Cancel</button>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"formRow\">\t\r\n");
      out.write("\t\t&nbsp;\r\n");
      out.write("    </div>\r\n");
      out.write("\t \r\n");
      out.write("\t \r\n");
      out.write("  <div>\r\n");
      out.write("\t\t<div id=\"departmentGrid\" style=\"height: 380px\"></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("</form>");
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
