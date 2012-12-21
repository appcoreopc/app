package org.apache.jsp.appCore_Personnel.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class branchAddDemo_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("<script type=\"text/javascript\">          \r\n");
      out.write("\r\n");
      out.write("    var gridUrl = hostname + \"/app/Core/BranchInfo\";\r\n");
      out.write("\r\n");
      out.write("\tvar  model =  {\r\n");
      out.write("                    id: \"nid\",\r\n");
      out.write("                    fields: {\r\n");
      out.write("                        nid: { editable: false },\r\n");
      out.write("                        type: {  type: \"string\" },\r\n");
      out.write("                        value : {  validation: { required: true } },\r\n");
      out.write("                        description: {  type: \"string\" },\r\n");
      out.write("                        category: {  validation: { required: true } }\r\n");
      out.write("                           }\r\n");
      out.write("                   };\r\n");
      out.write("\t\t\t\t   \r\n");
      out.write("\t\tvar  columns = { \"columns\" : [ \r\n");
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
      out.write("                            }\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t]};\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\tvar addLinkInfo = { \r\n");
      out.write("\t\t\t    \"text\" : \"Save\", \r\n");
      out.write("\t\t\t\t\"link\" : \"branch.jsp\", \r\n");
      out.write("\t\t\t\t\"callback\" : saveForm.toString()\r\n");
      out.write("\t\t};\t\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\tvar updateLinkInfo = { \r\n");
      out.write("\t\t\t    \"text\" : \"Update\", \r\n");
      out.write("\t\t\t\t\"link\" : \"branchEdit.jsp\"\r\n");
      out.write("\t\t};\r\n");
      out.write("\t\r\n");
      out.write("\t$(document).ready(function() \r\n");
      out.write("\t{\r\n");
      out.write("\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t$(\"#myform\").validationEngine();\r\n");
      out.write("\t\r\n");
      out.write("\t\t\tvar gridDataObject = \r\n");
      out.write("\t\t\t{ \r\n");
      out.write("\t\t\t\t\t\"gridUrl\" : gridUrl,\r\n");
      out.write("\t\t\t\t\t\"columns\" : columns,\r\n");
      out.write("\t\t\t\t\t\"model\" : model, \r\n");
      out.write("\t\t\t\t\t\"addLinkInfo\" : addLinkInfo, \r\n");
      out.write("\t\t\t\t\t\"updateLinkInfo\" : updateLinkInfo, \r\n");
      out.write("\t\t\t\t\t\"appearance\" : coreGridAppearanceToobarCreateCancel\r\n");
      out.write("\t\t\t}; \r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\tvar input = { \"id\" : coreBranchPage, \"roleId\" : 1 };\r\n");
      out.write("\t\t\tvar coreCommand = new CoreCommand();\r\n");
      out.write("\t\t\tcoreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t$(\"#addBtn\").live(\"click\", function()\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\tsaveForm();\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t \r\n");
      out.write("\t\t\t$(\"#cancelBtn\").live(\"click\", function()\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\tvar result = cancelFormChanges();\r\n");
      out.write("\t\t\t\tif (result) \r\n");
      out.write("\t\t\t\t\tloadPage(\"branchDemo.jsp\");\r\n");
      out.write("\t\t\t\t   //window.location.replace(\"branch.jsp\");\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t\r\n");
      out.write(" \t});\r\n");
      out.write("\r\n");
      out.write("\tfunction saveForm()\r\n");
      out.write("\t{\r\n");
      out.write("\t\tvar isValid = $(\"#myform\").validationEngine('validate'); \r\n");
      out.write("\t\r\n");
      out.write("\t\tif (!isValid) \r\n");
      out.write("\t\t   return; \r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif ($(\"#myform\").validationEngine('validate'));\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\tvar branchInfoData = [];\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\tvar grid = $(\"#grid\").data(\"kendoGrid\").dataSource.data();\r\n");
      out.write("\t\t\t$.each(grid, function (i, dataItem) \r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\tvar branchInfo = new BranchInfo(); \r\n");
      out.write("\t\t\t\tbranchInfo.type = dataItem.type; \r\n");
      out.write("\t\t\t\tbranchInfo.value = dataItem.value;\r\n");
      out.write("\t\t\t\tbranchInfo.description = dataItem.description;\r\n");
      out.write("\t\t\t\tbranchInfo.category = dataItem.category;\r\n");
      out.write("\t\t\t\tbranchInfoData.push(branchInfo);\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\tvar branch = new Branch(); \r\n");
      out.write("\t\t\tbranch.branchCode = $(\"#BranchCode\").val(); \r\n");
      out.write("\t\t\tbranch.branchName = $(\"#BranchName\").val(); \r\n");
      out.write("\t\t\tbranch.description = $(\"#Description\").val(); \r\n");
      out.write("\t\t\tbranch.enabled = $('#Enabled').is(\":checked\"); \r\n");
      out.write("\t\t\tbranch.branchInfo = branchInfoData; \t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\tvar ajaxCore = new AjaxCore(); \r\n");
      out.write("\t\t\tvar request = ajaxCore.sendRequestType(hostname + \"/app/Core/Branch/add\", branch, \"post\"); \r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\trequest.success(function(data, status, xhrObj)\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\t//goToPage(\"branch.jsp\");\r\n");
      out.write("\t\t\t\tloadPage(\"branchDemo.jsp\");\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("</script>    \r\n");
      out.write("\r\n");
      out.write("<form id=\"myform\">\r\n");
      out.write("\r\n");
      out.write("<div class=\"form dataEntry\">\r\n");
      out.write("  <div class=\"sectionalForm\"> \r\n");
      out.write("   <div class=\"leftSection\">\r\n");
      out.write("\t<div class=\"labelSection\">Branch Code <span class='req'>*</span></div><div class=\"inputSection\"><input class=\"validate[required, maxSize[10]]\" type=\"text\" id=\"BranchCode\" name=\"BranchCode\" value=\"BranchCode\"/></div>\r\n");
      out.write("   </div> \r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"rightSection\">\r\n");
      out.write("\t\t<div class=\"inlineLabelSection\">Disabled </div><div class=\"inlineLabelSection\"><input type=\"checkbox\" id=\"Enabled\" /></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("  </div>\r\n");
      out.write("\t\r\n");
      out.write("    <div class=\"formRow\">\r\n");
      out.write("\t\t<div class=\"labelSection\">Branch Name <span class='req'>*</span> </div><div class=\"inputSection\"><input type=\"text\" class=\"validate[required, maxSize[80]]\" id=\"BranchName\" value=\"BranchName\"/></div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"formRow\">\r\n");
      out.write("\t\t<div class=\"labelSection\">Description</div><div class=\"inputSection\"><input type=\"text\" id=\"Description\" class=\"validate[required, maxSize[80]]\" value=\"Description\"/></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<div> <div class=\"maintenanceCommandSpace\"></div>\r\n");
      out.write("\t\t<div class=\"maintenanceCommand\">\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("   \r\n");
      out.write("   <div>&nbsp;\r\n");
      out.write("   </div>\r\n");
      out.write("  \r\n");
      out.write("    <div>\r\n");
      out.write("\t <div> Branch Info  </div>\r\n");
      out.write("\t\t<div id=\"grid\" style=\"height: 380px\"></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("</form>\r\n");
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
