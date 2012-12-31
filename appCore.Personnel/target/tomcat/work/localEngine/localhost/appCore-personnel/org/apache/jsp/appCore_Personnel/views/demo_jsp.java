package org.apache.jsp.appCore_Personnel.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class demo_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("    <style>\r\n");
      out.write("        body { font-family: arial; font-size: 14px; }\r\n");
      out.write("\r\n");
      out.write("        .liveExample { padding: 1em; background-color: #EEEEDD; border: 1px solid #CCC; max-width: 655px; }\r\n");
      out.write("        .liveExample input { font-family: Arial; }\r\n");
      out.write("        .liveExample b { font-weight: bold; }\r\n");
      out.write("        .liveExample p { margin-top: 0.9em; margin-bottom: 0.9em; }\r\n");
      out.write("        .liveExample select[multiple] { width: 100%; height: 8em; }\r\n");
      out.write("        .liveExample h2 { margin-top: 0.4em; }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        .ko-grid { margin-bottom: 1em; width: 25em; border: 1px solid silver; background-color:White; }\r\n");
      out.write("        .ko-grid th { text-align:left; background-color: Black; color:White; }\r\n");
      out.write("        .ko-grid td, th { padding: 0.4em; }\r\n");
      out.write("        .ko-grid tr:nth-child(odd) { background-color: #DDD; }\r\n");
      out.write("        .ko-grid-pageLinks { margin-bottom: 1em; }\r\n");
      out.write("        .ko-grid-pageLinks a { padding: 0.5em; }\r\n");
      out.write("        .ko-grid-pageLinks a.selected { background-color: Black; color: White; }\r\n");
      out.write("        .liveExample { height:20em; overflow:auto } /* Mobile Safari reflows pages slowly, so fix the height to avoid\r\n");
      out.write("        the need for reflows */\r\n");
      out.write("\r\n");
      out.write("        li { list-style-type: disc; margin-left: 20px; }\r\n");
      out.write("        â\r\n");
      out.write("\r\n");
      out.write("        </style>\r\n");
      out.write("\r\n");
      out.write("        <script language=\"javascript\" src=\"../../js/viewmodal/branchViewModel.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <script src=\"../../js/jquery-1.7.2.min.js\"></script>\r\n");
      out.write("        <script language=\"javascript\" src=\"../../js/viewmodal/knockoutBindersControl.js\"></script>\r\n");
      out.write("        <script language=\"javascript\" src=\"../../js/knockoutjs/knockout-2.2.0.debug.js\"></script>\r\n");
      out.write("        <script language=\"javascript\" src=\"../../js/testGrid.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/html\" id=\"editTemplate\">\r\n");
      out.write("        <select data-bind=\"value : $data, options : $root.availableCountries\">\r\n");
      out.write("        </select>\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("        $(document).ready(function()\r\n");
      out.write("        {\r\n");
      out.write("        var initialData = [\r\n");
      out.write("        { name: \"Well-Travelled Kitt\", sales: 352, price: 75.95, salesDate : \"\" },\r\n");
      out.write("        { name: \"Speedy Coyote\", sales: 89, price: 190.00 },\r\n");
      out.write("        { name: \"Furious Lizard\", sales: 152, price: 25.00 },\r\n");
      out.write("        { name: \"Indifferent Monkey\", sales: 1, price: 99.95 },\r\n");
      out.write("        { name: \"Brooding Dragon\", sales: 0, price: 6350 },\r\n");
      out.write("        { name: \"Ingenious Tadpole\", sales: 39450, price: 0.35 },\r\n");
      out.write("        { name: \"Optimistic Snail\", sales: 420, price: 1.50 }\r\n");
      out.write("        ];\r\n");
      out.write("\r\n");
      out.write("        var PagedGridModel = function(items) {\r\n");
      out.write("\r\n");
      out.write("        var self = this;\r\n");
      out.write("\r\n");
      out.write("        self.items = ko.observableArray(items);\r\n");
      out.write("\r\n");
      out.write("        self.addItem = function()\r\n");
      out.write("        {\r\n");
      out.write("            self.items.push({ name: \"New item\", sales: 0, price: 100 });\r\n");
      out.write("        };\r\n");
      out.write("\r\n");
      out.write("        self.sortByName = function() {\r\n");
      out.write("        self.items.sort(function(a, b) {\r\n");
      out.write("            return a.name < b.name ? -1 : 1;\r\n");
      out.write("        });\r\n");
      out.write("        };\r\n");
      out.write("\r\n");
      out.write("        self.jumpToFirstPage = function()\r\n");
      out.write("        {\r\n");
      out.write("            this.gridViewModel.currentPageIndex(0);\r\n");
      out.write("        };\r\n");
      out.write("\r\n");
      out.write("        self.disableDelete = function()\r\n");
      out.write("        {\r\n");
      out.write("            this.gridViewModel.enableDelete(false);\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        var self = this;\r\n");
      out.write("        self.name = \"n  amenamename\";\r\n");
      out.write("        self.name2 = \"noname\";\r\n");
      out.write("        var miki=\"testing\";\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        this.gridViewModel = new ko.testGrid.ViewModel({\r\n");
      out.write("        data: self.items,\r\n");
      out.write("        columns: [\r\n");
      out.write("        { headerText: \"Item Name\", rowText: \"name\", renderTemplate : \"editTemplate\" },\r\n");
      out.write("        { headerText: \"Sales Count\", rowText: \"sales\"  },\r\n");
      out.write("        { headerText: \"Price\", rowText: function (item) { return \"$\" + item.price.toFixed(2) } }\r\n");
      out.write("        ],\r\n");
      out.write("        pageSize: 10,\r\n");
      out.write("        availableCountries : ko.observableArray(['France', 'Germany', 'Spain']),\r\n");
      out.write("        enableUpdate : ko.observable(false),\r\n");
      out.write("        enableAdd : ko.observable(false),\r\n");
      out.write("        enableDelete : ko.observable(true),\r\n");
      out.write("        test : \"demodemo\",\r\n");
      out.write("        deleteData : function(data)\r\n");
      out.write("        {\r\n");
      out.write("            self.items.remove(data);\r\n");
      out.write("        },\r\n");
      out.write("        updateData : function(data) { alert(data);}\r\n");
      out.write("        });\r\n");
      out.write("        };\r\n");
      out.write("\r\n");
      out.write("        var vm = new PagedGridModel(initialData);\r\n");
      out.write("        ko.applyBindings(vm);\r\n");
      out.write("\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div data-bind='testGrid: gridViewModel'> </div>\r\n");
      out.write("\r\n");
      out.write("        <button data-bind='click: addItem'>\r\n");
      out.write("        Add item\r\n");
      out.write("        </button>\r\n");
      out.write("\r\n");
      out.write("        <button data-bind='click: sortByName'>\r\n");
      out.write("        Sort by name\r\n");
      out.write("        </button>\r\n");
      out.write("\r\n");
      out.write("        <button data-bind='click: disableDelete'>\r\n");
      out.write("        Disable Delete\r\n");
      out.write("        </button>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <button data-bind='click: jumpToFirstPage, enable: gridViewModel.currentPageIndex'>\r\n");
      out.write("        Jump to first page\r\n");
      out.write("        </button>");
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
