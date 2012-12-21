package org.apache.jsp.appCore_Personnel.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class codeSetup_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\t<script type=\"text/javascript\">          \r\n");
      out.write("\r\n");
      out.write("\tvar gridUrl = globalHostname + \"/app/Core/Branch\";\r\n");
      out.write("\t\r\n");
      out.write("\t$(document).ready(function() \r\n");
      out.write("\t{\r\n");
      out.write("\t\tvar model = {\r\n");
      out.write("                        \r\n");
      out.write("\t\t\t\t\t\tid: \"nid\",\r\n");
      out.write("                        fields: {\r\n");
      out.write("                                        nid: { editable: false },\r\n");
      out.write("                                        type: { editable: false, type: \"string\" },\r\n");
      out.write("                                        value : { editable: false, validation: { required: true } },\r\n");
      out.write("                                        description: { editable: false, type: \"string\" },\r\n");
      out.write("                                        category: { editable: false, validation: { required: true } }\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("                    };\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\tvar columns = { \"columns\" : [ \r\n");
      out.write("\t\t\t\t\t\t\t{\r\n");
      out.write("                                field: \"branchCode\",\r\n");
      out.write("                                width: 90,\r\n");
      out.write("                                title: \"Branch Code\"\r\n");
      out.write("                            }, \r\n");
      out.write("\t\t\t\t\t\t\t{\r\n");
      out.write("                                field: \"branchName\",\r\n");
      out.write("                                width: 90,\r\n");
      out.write("                                title: \"Branch Name\"\r\n");
      out.write("                            },\r\n");
      out.write("\t\t\t\t\t\t\t{\r\n");
      out.write("                                field: \"description\",\r\n");
      out.write("                                width: 90,\r\n");
      out.write("                                title: \"Description\"\r\n");
      out.write("                            }, \r\n");
      out.write("\t\t\t\t\t\t\t{\r\n");
      out.write("                                field: \"enabled\",\r\n");
      out.write("                                width: 90,\r\n");
      out.write("                                title: \"Disabled\"\r\n");
      out.write("                            }\r\n");
      out.write("\t\t\t\t\t\t]}; \r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\tvar addLinkInfo = { \r\n");
      out.write("\t\t\t    \"text\" : \"Add codes\", \r\n");
      out.write("\t\t\t\t\"link\" : \"codeAdd.jsp\", \r\n");
      out.write("\t\t\t\t\"callback\" : goToAdd.toString()\r\n");
      out.write("\t\t\t};\t\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar updateLinkInfo = { \r\n");
      out.write("\t\t\t    \"text\" : \"Update\", \r\n");
      out.write("\t\t\t\t\"link\" : \"branchEdit.jsp\"\r\n");
      out.write("\t\t\t};\r\n");
      out.write("\t\r\n");
      out.write("\t\tvar ajaxCore = new AjaxCore();\r\n");
      out.write("\t\tvar request = ajaxCore.sendRequest(gridUrl + \"/list\", null, \"get\");\r\n");
      out.write("\t\t\r\n");
      out.write("\t\trequest.success(function(data) \r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\tvar gridDataObject = \r\n");
      out.write("\t\t\t{ \r\n");
      out.write("\t\t\t\t\t\"gridUrl\" : gridUrl,\r\n");
      out.write("\t\t\t\t\t\"data\" : data,\r\n");
      out.write("\t\t\t\t\t\"columns\" : columns,\r\n");
      out.write("\t\t\t\t\t\"model\" : model, \r\n");
      out.write("\t\t\t\t\t\"addLinkInfo\" : addLinkInfo, \r\n");
      out.write("\t\t\t\t\t\"updateLinkInfo\" : updateLinkInfo\r\n");
      out.write("\t\t\t}; \r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\tvar input = { \"id\" : coreBranchPage, \"roleId\" : 1 };\r\n");
      out.write("\t\t\tvar coreCommand = new CoreCommand();\r\n");
      out.write("\t\t\tcoreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\tfunction goToAdd()\r\n");
      out.write("\t{\t\r\n");
      out.write("\t\tpreparePageForLoading(\"codeAdd.jsp\");\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("</script>    \r\n");
      out.write("\r\n");
      out.write("<div class=\"form\">\r\n");
      out.write("\t<h1>Code Setup  </h1>\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"formRow\">\r\n");
      out.write("\t\tCode Maintenance  \r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"formRow\">\t\r\n");
      out.write("\t\t&nbsp;\r\n");
      out.write("    </div>\r\n");
      out.write("\t \r\n");
      out.write("\t<div class=\"maintenanceCommand\"> \r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"formRow\">\t\r\n");
      out.write("\t\t&nbsp;\r\n");
      out.write("    </div>\r\n");
      out.write("\t \r\n");
      out.write("\t \r\n");
      out.write("  <div>\r\n");
      out.write("\t\t<div id=\"grid\" style=\"height: 380px\"></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
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
