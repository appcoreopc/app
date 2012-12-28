package org.apache.jsp.appCore_Personnel.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class personnelSummaryWidget_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("    <link rel=\"stylesheet\" href=\"../../css/fontelloCustom.css\"><!--[if IE 7]>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"../../css/fontello-ie7.css\"><![endif]-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <script language=\"javascript\" src=\"../../js/coreComboControl.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("        var url = globalCompanyListUrl;\r\n");
      out.write("\r\n");
      out.write("        var companyDataObjects = {\r\n");
      out.write("        \"url\" : url,\r\n");
      out.write("        \"targetControlId\" : \"companyDropDownList\",\r\n");
      out.write("        \"data\" : null,\r\n");
      out.write("        \"key\" : \"nid\",\r\n");
      out.write("        \"list\" : \"companyList\",\r\n");
      out.write("        \"text\" : \"companyCode\"\r\n");
      out.write("        };\r\n");
      out.write("\r\n");
      out.write("        var comboControl = new ComboControl();\r\n");
      out.write("        comboControl.createControl(companyDataObjects);\r\n");
      out.write("\r\n");
      out.write("        var branchUrl = globalBranchSummaryUrl + globalViewModel.companyId();\r\n");
      out.write("\r\n");
      out.write("        var branchData = {\r\n");
      out.write("        \"url\" : branchUrl,\r\n");
      out.write("        \"icon\" : \"icon-th-large-1\",\r\n");
      out.write("        \"targetControlId\" : \"viewPort\",\r\n");
      out.write("        \"data\" : null,\r\n");
      out.write("        \"key\" : \"nid\",\r\n");
      out.write("        \"text\" : \"branchCode\",\r\n");
      out.write("        \"title\" : \"Branch\",\r\n");
      out.write("        \"list\" : \"listBranch\",\r\n");
      out.write("        \"clickControlId\" : \"aBranchAdd\",\r\n");
      out.write("        \"clickCode\" : function()\r\n");
      out.write("        {\r\n");
      out.write("            preparePageForLoading(\"branch.jsp\");\r\n");
      out.write("        }\r\n");
      out.write("        };\r\n");
      out.write("\r\n");
      out.write("        var divisionUrl = globalDivisionSummaryUrl + globalViewModel.companyId();\r\n");
      out.write("\r\n");
      out.write("        var divisionData = {\r\n");
      out.write("        \"url\" : divisionUrl,\r\n");
      out.write("        \"icon\" : \"icon-th-large-1\",\r\n");
      out.write("        \"targetControlId\" : \"viewPort\",\r\n");
      out.write("        \"data\" : null,\r\n");
      out.write("        \"key\" : \"nid\",\r\n");
      out.write("        \"text\" : \"divisionCode\",\r\n");
      out.write("        \"title\" : \"Division\",\r\n");
      out.write("        \"list\" : \"listDivision\",\r\n");
      out.write("        \"clickControlId\" : \"aDivisionAdd\",\r\n");
      out.write("        \"clickCode\" : function()\r\n");
      out.write("        {\r\n");
      out.write("            preparePageForLoading(\"division.jsp\");\r\n");
      out.write("        }\r\n");
      out.write("        };\r\n");
      out.write("\r\n");
      out.write("        var unitUrl = globalHostname + \"/app/Core/Division/getSummary?id=\" + globalCurrentCompanyId;\r\n");
      out.write("\r\n");
      out.write("        var unitData = {\r\n");
      out.write("        \"url\" : unitUrl,\r\n");
      out.write("        \"icon\" : \"icon-th-large-1\",\r\n");
      out.write("        \"targetControlId\" : \"viewPort\",\r\n");
      out.write("        \"data\" : null,\r\n");
      out.write("        \"key\" : \"nid\",\r\n");
      out.write("        \"text\" : \"divisionCode\",\r\n");
      out.write("        \"title\" : \"Unit\",\r\n");
      out.write("        \"list\" : \"listDivision\",\r\n");
      out.write("        \"clickControlId\" : \"aUnitAdd\",\r\n");
      out.write("        \"clickCode\" : function()\r\n");
      out.write("        {\r\n");
      out.write("            preparePageForLoading(\"unit.jsp\");\r\n");
      out.write("        }\r\n");
      out.write("        };\r\n");
      out.write("\r\n");
      out.write("        var departmentUrl = globalHostname + \"/app/Core/Division/getSummary?id=\" + globalCurrentCompanyId;\r\n");
      out.write("\r\n");
      out.write("        var departmentData = {\r\n");
      out.write("        \"url\" : departmentUrl,\r\n");
      out.write("        \"icon\" : \"icon-th-large-1\",\r\n");
      out.write("        \"targetControlId\" : \"viewPort\",\r\n");
      out.write("        \"data\" : null,\r\n");
      out.write("        \"key\" : \"nid\",\r\n");
      out.write("        \"text\" : \"divisionCode\",\r\n");
      out.write("        \"title\" : \"Department\",\r\n");
      out.write("        \"list\" : \"listDivision\",\r\n");
      out.write("        \"clickControlId\" : \"aDepartmentAdd\",\r\n");
      out.write("        \"clickCode\" : function()\r\n");
      out.write("        {\r\n");
      out.write("            preparePageForLoading(\"department.jsp\");\r\n");
      out.write("        }\r\n");
      out.write("        };\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        var widget = new WidgetCommandControl();\r\n");
      out.write("        widget.createControl(branchData);\r\n");
      out.write("        widget.createControl(divisionData);\r\n");
      out.write("        //widget.createControl(unitData);\r\n");
      out.write("        //widget.createControl(departmentData);\r\n");
      out.write("\r\n");
      out.write("        </script>\r\n");
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
