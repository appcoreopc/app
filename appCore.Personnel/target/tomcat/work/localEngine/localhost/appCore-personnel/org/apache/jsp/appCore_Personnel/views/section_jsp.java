package org.apache.jsp.appCore_Personnel.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class section_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        var gridUrl = globalHostname + \"/app/Core/Section\";\r\n");
      out.write("\r\n");
      out.write("        var model = {\r\n");
      out.write("        id: \"nid\",\r\n");
      out.write("        fields: {\r\n");
      out.write("        nid: { editable: false },\r\n");
      out.write("        sectionCode: { editable: false, validation: { required: true } },\r\n");
      out.write("        sectionName: { editable: false, type: \"string\", validation: { required: true } },\r\n");
      out.write("        remark: { editable: false, type: \"string\" },\r\n");
      out.write("        enabled: { editable: false, type: \"number\" }\r\n");
      out.write("        }\r\n");
      out.write("        };\r\n");
      out.write("\r\n");
      out.write("        var columns = { columns: [\r\n");
      out.write("        {\r\n");
      out.write("        field: \"sectionCode\",\r\n");
      out.write("        width: 90,\r\n");
      out.write("        title: \"Section Code\"\r\n");
      out.write("        },\r\n");
      out.write("        {\r\n");
      out.write("        field: \"sectionName\",\r\n");
      out.write("        width: 90,\r\n");
      out.write("        title: \"Section Name\"\r\n");
      out.write("        },\r\n");
      out.write("        {\r\n");
      out.write("        field: \"remark\",\r\n");
      out.write("        width: 90,\r\n");
      out.write("        title: \"Remark\"\r\n");
      out.write("        },\r\n");
      out.write("        {\r\n");
      out.write("        field: \"enabled\",\r\n");
      out.write("        width: 90,\r\n");
      out.write("        title: \"Disabled\"\r\n");
      out.write("        }\r\n");
      out.write("        ]};\r\n");
      out.write("\r\n");
      out.write("        var addLinkInfo = {\r\n");
      out.write("        \"text\" : \"Add New Section\",\r\n");
      out.write("        \"link\" : \"sectionAdd.jsp\",\r\n");
      out.write("        \"callback\" : function() { goToAdd(); }\r\n");
      out.write("        };\r\n");
      out.write("\r\n");
      out.write("        var updateLinkInfo = {\r\n");
      out.write("        \"text\" : \"Update\",\r\n");
      out.write("        \"link\" : \"sectionEdit.jsp\"\r\n");
      out.write("        };\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        $(document).ready(function()\r\n");
      out.write("        {\r\n");
      out.write("        var ajaxCore = new AjaxCore();\r\n");
      out.write("        var request = ajaxCore.sendRequest(gridUrl + \"/list\", null, \"get\");\r\n");
      out.write("\r\n");
      out.write("        request.success(function(data)\r\n");
      out.write("        {\r\n");
      out.write("        var gridDataObject =\r\n");
      out.write("        {\r\n");
      out.write("        \"gridUrl\" : gridUrl,\r\n");
      out.write("        \"data\" : data,\r\n");
      out.write("        \"columns\" : columns,\r\n");
      out.write("        \"model\" : model,\r\n");
      out.write("        \"addLinkInfo\" : addLinkInfo,\r\n");
      out.write("        \"updateLinkInfo\" : updateLinkInfo\r\n");
      out.write("        };\r\n");
      out.write("\r\n");
      out.write("        var input = { \"id\" : coreSectionPage, \"roleId\" : 1 };\r\n");
      out.write("        var coreCommand = new CoreCommand();\r\n");
      out.write("        coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);\r\n");
      out.write("        });\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        function goToAdd()\r\n");
      out.write("        {\r\n");
      out.write("            preparePageForLoading(\"sectionAdd.jsp\");\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"forms\">\r\n");
      out.write("        <h1>Section </h1>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"viewData\">\r\n");
      out.write("        <div class=\"maintenanceCommand\">\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div>\r\n");
      out.write("\r\n");
      out.write("        <div id=\"grid\" style=\"height: 380px\"></div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
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
