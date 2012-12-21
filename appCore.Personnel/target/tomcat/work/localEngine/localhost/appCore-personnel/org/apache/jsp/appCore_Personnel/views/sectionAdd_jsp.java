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

      out.write("<script type=\"text/javascript\">          \r\n");
      out.write("\r\n");
      out.write("    var gridUrl = globalHostname + \"/app/Core/SectionInfo\";\r\n");
      out.write("\tvar sectionPage = \"section.jsp\";\r\n");
      out.write("\t\r\n");
      out.write("\tvar model =  {\r\n");
      out.write("                    id : \"nid\",\r\n");
      out.write("                    fields: {\r\n");
      out.write("                       nid: { editable: false },\r\n");
      out.write("                        type: {  type: \"string\" },\r\n");
      out.write("                        value : {  validation: { required: true } },\r\n");
      out.write("                        description: {  type: \"string\" },\r\n");
      out.write("                                        category: {  validation: { required: true } }\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("                  };\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t var columns = { columns : [ \r\n");
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
      out.write("\t\t\t\t\t]};\r\n");
      out.write("\t\r\n");
      out.write("\t\tvar addLinkInfo = { \r\n");
      out.write("\t\t\t    \"text\" : \"Add\", \r\n");
      out.write("\t\t\t\t\"link\" : sectionPage, \r\n");
      out.write("\t\t\t\t\"commandId\" : 'sectionAdd', \r\n");
      out.write("\t\t\t\t\"targetControlId\" : \"#sectionCommand\",\r\n");
      out.write("\t\t\t\t\"callback\" : function() { saveForm();}\r\n");
      out.write("\t\t};\t\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\tvar updateLinkInfo = { \r\n");
      out.write("\t\t\t    \"text\" : \"Update\", \r\n");
      out.write("\t\t\t\t\"link\" : \"sectionEdit.jsp\"\r\n");
      out.write("\t\t};\r\n");
      out.write("\t\r\n");
      out.write("\t\tvar formName = \"sectionForm\t\";\r\n");
      out.write("\t\tvar gridId = \"gridSection\";\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(document).ready(function() \r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\t$(\"#\" + formName).validationEngine();\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar gridDataObject = \r\n");
      out.write("\t\t\t{ \r\n");
      out.write("\t\t\t\t\t\t\"gridUrl\" : gridUrl,\r\n");
      out.write("\t\t\t\t\t\t\"columns\" : columns,\r\n");
      out.write("\t\t\t\t\t\t\"model\" : model, \r\n");
      out.write("\t\t\t\t\t\t\"addLinkInfo\" : addLinkInfo, \r\n");
      out.write("\t\t\t\t\t\t\"updateLinkInfo\" : updateLinkInfo, \r\n");
      out.write("\t\t\t\t\t\t\"controlId\" : gridId,\r\n");
      out.write("\t\t\t\t\t\t\"appearance\" : globalCoreGridAppearanceToobarCreateCancel,\r\n");
      out.write("\t\t\t\t\t\t\"editorMode\" : \"Insert\"\r\n");
      out.write("\t\t\t}; \r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\tvar input = { \"id\" : coreSectionPage, \"roleId\" : 1 };\r\n");
      out.write("\t\t\tvar coreCommand = new CoreCommand();\r\n");
      out.write("\t\t\tcoreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t$(\"#saveBtn\").click(function()\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\tsaveForm();\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t\t \r\n");
      out.write("\t\t\t$(\".cancelCommand\").click(function()\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\t\tvar result = cancelFormChanges();\r\n");
      out.write("\t\t\t\t\tif (result) \r\n");
      out.write("\t\t\t\t\t   preparePageForLoading(sectionPage);\r\n");
      out.write("\t\t\t});\r\n");
      out.write(" \t});\r\n");
      out.write("\r\n");
      out.write("\tfunction saveForm()\r\n");
      out.write("\t{\r\n");
      out.write("\t\r\n");
      out.write("\t\tvar isValid = $(\"#\" + formName).validationEngine('validate'); \r\n");
      out.write("\t\r\n");
      out.write("\t\tif (!isValid) \r\n");
      out.write("\t\t   return; \r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif ($(\"#\" + formName).validationEngine('validate'));\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\tvar sectionInfoData = [];\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\tvar grid = $(\"#\" + gridId).data(\"kendoGrid\").dataSource.data();\r\n");
      out.write("\t\t\t$.each(grid, function (i, dataItem) \r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\tvar sectionInfo = new SectionInfo(); \r\n");
      out.write("\t\t\t\tsectionInfo.type = dataItem.type; \r\n");
      out.write("\t\t\t\tsectionInfo.value = dataItem.value;\r\n");
      out.write("\t\t\t\tsectionInfo.description = dataItem.description;\r\n");
      out.write("\t\t\t\tsectionInfo.category = dataItem.category;\r\n");
      out.write("\t\t\t\tsectionInfoData.push(sectionInfo);\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\tvar section = new Section(); \r\n");
      out.write("\t\t\tsection.sectionCode = $(\"#SectionCode\").val(); \r\n");
      out.write("\t\t\tsection.sectionName = $(\"#SectionName\").val(); \r\n");
      out.write("\t\t\tsection.remark = $(\"#Remark\").val(); \r\n");
      out.write("\t\t\tsection.enabled = $('#Enabled').is(\":checked\"); \r\n");
      out.write("\t\t\tsection.sectionInfo = sectionInfoData; \t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\tvar ajaxCore = new AjaxCore(); \r\n");
      out.write("\t\t\tvar request = ajaxCore.sendRequestType(globalHostname + \"/app/Core/Section/add\", section, \"post\");\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\trequest.success(function(data, status, xhrObj)\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\tpreparePageForLoading(sectionPage);\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("</script>    \r\n");
      out.write("\r\n");
      out.write("<form id=\"sectionForm\">\r\n");
      out.write("\r\n");
      out.write("<div class=\"form\">\r\n");
      out.write("\t\r\n");
      out.write("  <div class=\"sectionalForm\"> \r\n");
      out.write("   <div class=\"leftSection\">\r\n");
      out.write("\t<div class=\"labelSection\">Section Code</div><span class='req'>*</span><div class=\"inputSection\"><input type=\"text\" id=\"SectionCode\" class=\"validate[required, maxSize[10]]\" value=\"SectionCode\"/></div>\r\n");
      out.write("   </div> \r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"rightSection\">\r\n");
      out.write("\t\t<div class=\"inlineLabelSection\">Disabled</div><div class=\"inlineLabelSection\"><input type=\"checkbox\" id=\"Enabled\" /></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("  </div>\r\n");
      out.write("\t\r\n");
      out.write("    <div class=\"formRow\">\r\n");
      out.write("\t\t<div class=\"labelSection\">Section Name</div><span class='req'>*</span><div class=\"inputSection\"><input type=\"text\" id=\"SectionName\" class=\"validate[required, maxSize[20]]\" value=\"SectionName\"/></div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"formRow\">\r\n");
      out.write("\t\t<div class=\"labelSection\">Remark</div><span class=\"fieldSpacer\"></span><div class=\"inputSection\"><input type=\"text\" id=\"Remark\" value=\"remark\" class=\"validate[required, maxSize[80]]\" /></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<div> <div class=\"maintenanceCommandSpace\"></div>\r\n");
      out.write("\t\t<div id=\"sectionCommand\" class=\"maintenanceCommand\">\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("   \r\n");
      out.write("   <div>&nbsp;\r\n");
      out.write("   </div>\r\n");
      out.write("  \r\n");
      out.write("    <div>\r\n");
      out.write("\t <div> Section Info  </div>\r\n");
      out.write("\t\t<div id=\"gridSection\" style=\"height: 380px\"></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</form> ");
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
