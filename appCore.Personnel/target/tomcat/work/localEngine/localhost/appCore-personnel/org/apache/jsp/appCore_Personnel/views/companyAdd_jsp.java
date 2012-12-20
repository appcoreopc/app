package org.apache.jsp.appCore_Personnel.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class companyAdd_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("    <link href=\"../../css/themes/base/jquery.ui.all.css\" media=\"screen\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\r\n");
      out.write("        <link href=\"../../css/company.css\" media=\"screen\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\r\n");
      out.write("        <script language=\"javascript\" src=\"../../js/viewmodal/companyAddViewModel.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("        $(document).ready(function()\r\n");
      out.write("        {\r\n");
      out.write("\r\n");
      out.write("            $(document).unbind(\"parseComplete\");\r\n");
      out.write("\r\n");
      out.write("            $(\"#companyForm\").validationEngine();\r\n");
      out.write("\r\n");
      out.write("            var tab = $(\"#companyCodeSetupTabs\").tabs();\r\n");
      out.write("            var vm;\r\n");
      out.write("            var gridDataObject;\r\n");
      out.write("\r\n");
      out.write("            if (globalCurrentId != undefined && globalCurrentId.id != null)\r\n");
      out.write("            {\r\n");
      out.write("                vm = new CompanyAddViewModel(2, globalCurrentId.id);\r\n");
      out.write("                gridDataObject = vm.getView();\r\n");
      out.write("            }\r\n");
      out.write("            else\r\n");
      out.write("            {\r\n");
      out.write("                vm = new CompanyAddViewModel(1);\r\n");
      out.write("                gridDataObject = vm.getView();\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            var input = { \"id\" : coreCompanyPage, \"roleId\" : 1 };\r\n");
      out.write("            var coreCommand = new CoreCommand();\r\n");
      out.write("            coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject, vm);\r\n");
      out.write("\r\n");
      out.write("            $(document).bind(\"parseComplete\", function()\r\n");
      out.write("            {\r\n");
      out.write("                ko.applyBindings(vm, document.getElementById(\"companyCodeSetupTabs\"));\r\n");
      out.write("            });\r\n");
      out.write("\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("        <form id=\"companyForm\">\r\n");
      out.write("\r\n");
      out.write("        <div id=\"companyCodeSetupTabs\">\r\n");
      out.write("        <ul>\r\n");
      out.write("        <li><a href=\"#companyGeneralInfo\">General</a></li>\r\n");
      out.write("        <li><a href=\"#companyDetailInfo\">Details</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("\r\n");
      out.write("        <div id=\"companyGeneralInfo\" class=\"formEntry\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"sectionalForm\">\r\n");
      out.write("        <div class=\"leftSection\">\r\n");
      out.write("        <div class=\"labelSection\">Company Code</div><div class=\"inputSection\"><input type=\"text\" id=\"CompanyCode\"\r\n");
      out.write("        data-bind=\"value: companyCode\" class=\"validate[required], maxSize[10]\"/><i class=\"icon-tag-1\"></i></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"rightSection\">\r\n");
      out.write("        <div class=\"inlineLabelSection\">Registration</div><div class=\"inlineLabelSection\"><input type=\"text\"\r\n");
      out.write("        id=\"Registration\" data-bind=\"value : registration\" class=\"validate[required], maxSize[10]\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("        <div class=\"labelSection\">Company Name</div><div class=\"inputSection\"><input type=\"text\" id=\"CompanyName\"\r\n");
      out.write("        data-bind=\"value: companyName\" class=\"validate[required], maxSize[30]\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("        <div class=\"labelSection\">Address</div><div class=\"inputSection\"><input type=\"text\" id=\"Address\"\r\n");
      out.write("        data-bind=\"value : address\" class=\"validate[required], maxSize[30]\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("        <div class=\"labelSection\"></div><div class=\"inputSection\"><input type=\"text\" id=\"Address2\"\r\n");
      out.write("        data-bind=\"value : address2\" /></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("        <div class=\"labelSection\"></div><div class=\"inputSection\"><input type=\"text\" id=\"Address3\"\r\n");
      out.write("        data-bind=\"value : address3\" /></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("        <div class=\"labelSection\">City</div><div class=\"inputSection\"><input type=\"text\" id=\"City\" data-bind=\"value :\r\n");
      out.write("        city\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div id=\"companyDetailInfo\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("        <div class=\"labelSection\">Country</div><div class=\"inputSection\">\r\n");
      out.write("\r\n");
      out.write("        <select id=\"Country\" name=\"Country\" data-bind=\"value: country\" class=\"validate[required]\">\r\n");
      out.write("        <option value=\"Afganistan\">Afghanistan</option>\r\n");
      out.write("        <option value=\"Albania\">Albania</option>\r\n");
      out.write("        <option value=\"Algeria\">Algeria</option>\r\n");
      out.write("        <option value=\"American Samoa\">American Samoa</option>\r\n");
      out.write("        <option value=\"Andorra\">Andorra</option>\r\n");
      out.write("        <option value=\"Angola\">Angola</option>\r\n");
      out.write("        <option value=\"Anguilla\">Anguilla</option>\r\n");
      out.write("        <option value=\"Antigua &amp; Barbuda\">Antigua &amp; Barbuda</option>\r\n");
      out.write("        <option value=\"Argentina\">Argentina</option>\r\n");
      out.write("        <option value=\"Armenia\">Armenia</option>\r\n");
      out.write("        <option value=\"Aruba\">Aruba</option>\r\n");
      out.write("        <option value=\"Australia\">Australia</option>\r\n");
      out.write("        <option value=\"Austria\">Austria</option>\r\n");
      out.write("        <option value=\"Azerbaijan\">Azerbaijan</option>\r\n");
      out.write("        <option value=\"Bahamas\">Bahamas</option>\r\n");
      out.write("        <option value=\"Bahrain\">Bahrain</option>\r\n");
      out.write("        <option value=\"Bangladesh\">Bangladesh</option>\r\n");
      out.write("        <option value=\"Barbados\">Barbados</option>\r\n");
      out.write("        <option value=\"Belarus\">Belarus</option>\r\n");
      out.write("        <option value=\"Belgium\">Belgium</option>\r\n");
      out.write("        <option value=\"Belize\">Belize</option>\r\n");
      out.write("        <option value=\"Benin\">Benin</option>\r\n");
      out.write("        <option value=\"Bermuda\">Bermuda</option>\r\n");
      out.write("        <option value=\"Bhutan\">Bhutan</option>\r\n");
      out.write("        <option value=\"Bolivia\">Bolivia</option>\r\n");
      out.write("        <option value=\"Bonaire\">Bonaire</option>\r\n");
      out.write("        <option value=\"Bosnia &amp; Herzegovina\">Bosnia &amp; Herzegovina</option>\r\n");
      out.write("        <option value=\"Botswana\">Botswana</option>\r\n");
      out.write("        <option value=\"Brazil\">Brazil</option>\r\n");
      out.write("        <option value=\"British Indian Ocean Ter\">British Indian Ocean Ter</option>\r\n");
      out.write("        <option value=\"Brunei\">Brunei</option>\r\n");
      out.write("        <option value=\"Bulgaria\">Bulgaria</option>\r\n");
      out.write("        <option value=\"Burkina Faso\">Burkina Faso</option>\r\n");
      out.write("        <option value=\"Burundi\">Burundi</option>\r\n");
      out.write("        <option value=\"Cambodia\">Cambodia</option>\r\n");
      out.write("        <option value=\"Cameroon\">Cameroon</option>\r\n");
      out.write("        <option value=\"Canada\">Canada</option>\r\n");
      out.write("        <option value=\"Canary Islands\">Canary Islands</option>\r\n");
      out.write("        <option value=\"Cape Verde\">Cape Verde</option>\r\n");
      out.write("        <option value=\"Cayman Islands\">Cayman Islands</option>\r\n");
      out.write("        <option value=\"Central African Republic\">Central African Republic</option>\r\n");
      out.write("        <option value=\"Chad\">Chad</option>\r\n");
      out.write("        <option value=\"Channel Islands\">Channel Islands</option>\r\n");
      out.write("        <option value=\"Chile\">Chile</option>\r\n");
      out.write("        <option value=\"China\">China</option>\r\n");
      out.write("        <option value=\"Christmas Island\">Christmas Island</option>\r\n");
      out.write("        <option value=\"Cocos Island\">Cocos Island</option>\r\n");
      out.write("        <option value=\"Colombia\">Colombia</option>\r\n");
      out.write("        <option value=\"Comoros\">Comoros</option>\r\n");
      out.write("        <option value=\"Congo\">Congo</option>\r\n");
      out.write("        <option value=\"Cook Islands\">Cook Islands</option>\r\n");
      out.write("        <option value=\"Costa Rica\">Costa Rica</option>\r\n");
      out.write("        <option value=\"Cote DIvoire\">Cote D'Ivoire</option>\r\n");
      out.write("        <option value=\"Croatia\">Croatia</option>\r\n");
      out.write("        <option value=\"Cuba\">Cuba</option>\r\n");
      out.write("        <option value=\"Curaco\">Curacao</option>\r\n");
      out.write("        <option value=\"Cyprus\">Cyprus</option>\r\n");
      out.write("        <option value=\"Czech Republic\">Czech Republic</option>\r\n");
      out.write("        <option value=\"Denmark\">Denmark</option>\r\n");
      out.write("        <option value=\"Djibouti\">Djibouti</option>\r\n");
      out.write("        <option value=\"Dominica\">Dominica</option>\r\n");
      out.write("        <option value=\"Dominican Republic\">Dominican Republic</option>\r\n");
      out.write("        <option value=\"East Timor\">East Timor</option>\r\n");
      out.write("        <option value=\"Ecuador\">Ecuador</option>\r\n");
      out.write("        <option value=\"Egypt\">Egypt</option>\r\n");
      out.write("        <option value=\"El Salvador\">El Salvador</option>\r\n");
      out.write("        <option value=\"Equatorial Guinea\">Equatorial Guinea</option>\r\n");
      out.write("        <option value=\"Eritrea\">Eritrea</option>\r\n");
      out.write("        <option value=\"Estonia\">Estonia</option>\r\n");
      out.write("        <option value=\"Ethiopia\">Ethiopia</option>\r\n");
      out.write("        <option value=\"Falkland Islands\">Falkland Islands</option>\r\n");
      out.write("        <option value=\"Faroe Islands\">Faroe Islands</option>\r\n");
      out.write("        <option value=\"Fiji\">Fiji</option>\r\n");
      out.write("        <option value=\"Finland\">Finland</option>\r\n");
      out.write("        <option value=\"France\">France</option>\r\n");
      out.write("        <option value=\"French Guiana\">French Guiana</option>\r\n");
      out.write("        <option value=\"French Polynesia\">French Polynesia</option>\r\n");
      out.write("        <option value=\"French Southern Ter\">French Southern Ter</option>\r\n");
      out.write("        <option value=\"Gabon\">Gabon</option>\r\n");
      out.write("        <option value=\"Gambia\">Gambia</option>\r\n");
      out.write("        <option value=\"Georgia\">Georgia</option>\r\n");
      out.write("        <option value=\"Germany\">Germany</option>\r\n");
      out.write("        <option value=\"Ghana\">Ghana</option>\r\n");
      out.write("        <option value=\"Gibraltar\">Gibraltar</option>\r\n");
      out.write("        <option value=\"Great Britain\">Great Britain</option>\r\n");
      out.write("        <option value=\"Greece\">Greece</option>\r\n");
      out.write("        <option value=\"Greenland\">Greenland</option>\r\n");
      out.write("        <option value=\"Grenada\">Grenada</option>\r\n");
      out.write("        <option value=\"Guadeloupe\">Guadeloupe</option>\r\n");
      out.write("        <option value=\"Guam\">Guam</option>\r\n");
      out.write("        <option value=\"Guatemala\">Guatemala</option>\r\n");
      out.write("        <option value=\"Guinea\">Guinea</option>\r\n");
      out.write("        <option value=\"Guyana\">Guyana</option>\r\n");
      out.write("        <option value=\"Haiti\">Haiti</option>\r\n");
      out.write("        <option value=\"Hawaii\">Hawaii</option>\r\n");
      out.write("        <option value=\"Honduras\">Honduras</option>\r\n");
      out.write("        <option value=\"Hong Kong\">Hong Kong</option>\r\n");
      out.write("        <option value=\"Hungary\">Hungary</option>\r\n");
      out.write("        <option value=\"Iceland\">Iceland</option>\r\n");
      out.write("        <option value=\"India\">India</option>\r\n");
      out.write("        <option value=\"Indonesia\">Indonesia</option>\r\n");
      out.write("        <option value=\"Iran\">Iran</option>\r\n");
      out.write("        <option value=\"Iraq\">Iraq</option>\r\n");
      out.write("        <option value=\"Ireland\">Ireland</option>\r\n");
      out.write("        <option value=\"Isle of Man\">Isle of Man</option>\r\n");
      out.write("        <option value=\"Israel\">Israel</option>\r\n");
      out.write("        <option value=\"Italy\">Italy</option>\r\n");
      out.write("        <option value=\"Jamaica\">Jamaica</option>\r\n");
      out.write("        <option value=\"Japan\">Japan</option>\r\n");
      out.write("        <option value=\"Jordan\">Jordan</option>\r\n");
      out.write("        <option value=\"Kazakhstan\">Kazakhstan</option>\r\n");
      out.write("        <option value=\"Kenya\">Kenya</option>\r\n");
      out.write("        <option value=\"Kiribati\">Kiribati</option>\r\n");
      out.write("        <option value=\"Korea North\">Korea North</option>\r\n");
      out.write("        <option value=\"Korea Sout\">Korea South</option>\r\n");
      out.write("        <option value=\"Kuwait\">Kuwait</option>\r\n");
      out.write("        <option value=\"Kyrgyzstan\">Kyrgyzstan</option>\r\n");
      out.write("        <option value=\"Laos\">Laos</option>\r\n");
      out.write("        <option value=\"Latvia\">Latvia</option>\r\n");
      out.write("        <option value=\"Lebanon\">Lebanon</option>\r\n");
      out.write("        <option value=\"Lesotho\">Lesotho</option>\r\n");
      out.write("        <option value=\"Liberia\">Liberia</option>\r\n");
      out.write("        <option value=\"Libya\">Libya</option>\r\n");
      out.write("        <option value=\"Liechtenstein\">Liechtenstein</option>\r\n");
      out.write("        <option value=\"Lithuania\">Lithuania</option>\r\n");
      out.write("        <option value=\"Luxembourg\">Luxembourg</option>\r\n");
      out.write("        <option value=\"Macau\">Macau</option>\r\n");
      out.write("        <option value=\"Macedonia\">Macedonia</option>\r\n");
      out.write("        <option value=\"Madagascar\">Madagascar</option>\r\n");
      out.write("        <option value=\"Malaysia\">Malaysia</option>\r\n");
      out.write("        <option value=\"Malawi\">Malawi</option>\r\n");
      out.write("        <option value=\"Maldives\">Maldives</option>\r\n");
      out.write("        <option value=\"Mali\">Mali</option>\r\n");
      out.write("        <option value=\"Malta\">Malta</option>\r\n");
      out.write("        <option value=\"Marshall Islands\">Marshall Islands</option>\r\n");
      out.write("        <option value=\"Martinique\">Martinique</option>\r\n");
      out.write("        <option value=\"Mauritania\">Mauritania</option>\r\n");
      out.write("        <option value=\"Mauritius\">Mauritius</option>\r\n");
      out.write("        <option value=\"Mayotte\">Mayotte</option>\r\n");
      out.write("        <option value=\"Mexico\">Mexico</option>\r\n");
      out.write("        <option value=\"Midway Islands\">Midway Islands</option>\r\n");
      out.write("        <option value=\"Moldova\">Moldova</option>\r\n");
      out.write("        <option value=\"Monaco\">Monaco</option>\r\n");
      out.write("        <option value=\"Mongolia\">Mongolia</option>\r\n");
      out.write("        <option value=\"Montserrat\">Montserrat</option>\r\n");
      out.write("        <option value=\"Morocco\">Morocco</option>\r\n");
      out.write("        <option value=\"Mozambique\">Mozambique</option>\r\n");
      out.write("        <option value=\"Myanmar\">Myanmar</option>\r\n");
      out.write("        <option value=\"Nambia\">Nambia</option>\r\n");
      out.write("        <option value=\"Nauru\">Nauru</option>\r\n");
      out.write("        <option value=\"Nepal\">Nepal</option>\r\n");
      out.write("        <option value=\"Netherland Antilles\">Netherland Antilles</option>\r\n");
      out.write("        <option value=\"Netherlands\">Netherlands (Holland, Europe)</option>\r\n");
      out.write("        <option value=\"Nevis\">Nevis</option>\r\n");
      out.write("        <option value=\"New Caledonia\">New Caledonia</option>\r\n");
      out.write("        <option value=\"New Zealand\">New Zealand</option>\r\n");
      out.write("        <option value=\"Nicaragua\">Nicaragua</option>\r\n");
      out.write("        <option value=\"Niger\">Niger</option>\r\n");
      out.write("        <option value=\"Nigeria\">Nigeria</option>\r\n");
      out.write("        <option value=\"Niue\">Niue</option>\r\n");
      out.write("        <option value=\"Norfolk Island\">Norfolk Island</option>\r\n");
      out.write("        <option value=\"Norway\">Norway</option>\r\n");
      out.write("        <option value=\"Oman\">Oman</option>\r\n");
      out.write("        <option value=\"Pakistan\">Pakistan</option>\r\n");
      out.write("        <option value=\"Palau Island\">Palau Island</option>\r\n");
      out.write("        <option value=\"Palestine\">Palestine</option>\r\n");
      out.write("        <option value=\"Panama\">Panama</option>\r\n");
      out.write("        <option value=\"Papua New Guinea\">Papua New Guinea</option>\r\n");
      out.write("        <option value=\"Paraguay\">Paraguay</option>\r\n");
      out.write("        <option value=\"Peru\">Peru</option>\r\n");
      out.write("        <option value=\"Phillipines\">Philippines</option>\r\n");
      out.write("        <option value=\"Pitcairn Island\">Pitcairn Island</option>\r\n");
      out.write("        <option value=\"Poland\">Poland</option>\r\n");
      out.write("        <option value=\"Portugal\">Portugal</option>\r\n");
      out.write("        <option value=\"Puerto Rico\">Puerto Rico</option>\r\n");
      out.write("        <option value=\"Qatar\">Qatar</option>\r\n");
      out.write("        <option value=\"Republic of Montenegro\">Republic of Montenegro</option>\r\n");
      out.write("        <option value=\"Republic of Serbia\">Republic of Serbia</option>\r\n");
      out.write("        <option value=\"Reunion\">Reunion</option>\r\n");
      out.write("        <option value=\"Romania\">Romania</option>\r\n");
      out.write("        <option value=\"Russia\">Russia</option>\r\n");
      out.write("        <option value=\"Rwanda\">Rwanda</option>\r\n");
      out.write("        <option value=\"St Barthelemy\">St Barthelemy</option>\r\n");
      out.write("        <option value=\"St Eustatius\">St Eustatius</option>\r\n");
      out.write("        <option value=\"St Helena\">St Helena</option>\r\n");
      out.write("        <option value=\"St Kitts-Nevis\">St Kitts-Nevis</option>\r\n");
      out.write("        <option value=\"St Lucia\">St Lucia</option>\r\n");
      out.write("        <option value=\"St Maarten\">St Maarten</option>\r\n");
      out.write("        <option value=\"St Pierre &amp; Miquelon\">St Pierre &amp; Miquelon</option>\r\n");
      out.write("        <option value=\"St Vincent &amp; Grenadines\">St Vincent &amp; Grenadines</option>\r\n");
      out.write("        <option value=\"Saipan\">Saipan</option>\r\n");
      out.write("        <option value=\"Samoa\">Samoa</option>\r\n");
      out.write("        <option value=\"Samoa American\">Samoa American</option>\r\n");
      out.write("        <option value=\"San Marino\">San Marino</option>\r\n");
      out.write("        <option value=\"Sao Tome & Principe\">Sao Tome &amp; Principe</option>\r\n");
      out.write("        <option value=\"Saudi Arabia\">Saudi Arabia</option>\r\n");
      out.write("        <option value=\"Senegal\">Senegal</option>\r\n");
      out.write("        <option value=\"Seychelles\">Seychelles</option>\r\n");
      out.write("        <option value=\"Sierra Leone\">Sierra Leone</option>\r\n");
      out.write("        <option value=\"Singapore\">Singapore</option>\r\n");
      out.write("        <option value=\"Slovakia\">Slovakia</option>\r\n");
      out.write("        <option value=\"Slovenia\">Slovenia</option>\r\n");
      out.write("        <option value=\"Solomon Islands\">Solomon Islands</option>\r\n");
      out.write("        <option value=\"Somalia\">Somalia</option>\r\n");
      out.write("        <option value=\"South Africa\">South Africa</option>\r\n");
      out.write("        <option value=\"Spain\">Spain</option>\r\n");
      out.write("        <option value=\"Sri Lanka\">Sri Lanka</option>\r\n");
      out.write("        <option value=\"Sudan\">Sudan</option>\r\n");
      out.write("        <option value=\"Suriname\">Suriname</option>\r\n");
      out.write("        <option value=\"Swaziland\">Swaziland</option>\r\n");
      out.write("        <option value=\"Sweden\">Sweden</option>\r\n");
      out.write("        <option value=\"Switzerland\">Switzerland</option>\r\n");
      out.write("        <option value=\"Syria\">Syria</option>\r\n");
      out.write("        <option value=\"Tahiti\">Tahiti</option>\r\n");
      out.write("        <option value=\"Taiwan\">Taiwan</option>\r\n");
      out.write("        <option value=\"Tajikistan\">Tajikistan</option>\r\n");
      out.write("        <option value=\"Tanzania\">Tanzania</option>\r\n");
      out.write("        <option value=\"Thailand\">Thailand</option>\r\n");
      out.write("        <option value=\"Togo\">Togo</option>\r\n");
      out.write("        <option value=\"Tokelau\">Tokelau</option>\r\n");
      out.write("        <option value=\"Tonga\">Tonga</option>\r\n");
      out.write("        <option value=\"Trinidad &amp; Tobago\">Trinidad &amp; Tobago</option>\r\n");
      out.write("        <option value=\"Tunisia\">Tunisia</option>\r\n");
      out.write("        <option value=\"Turkey\">Turkey</option>\r\n");
      out.write("        <option value=\"Turkmenistan\">Turkmenistan</option>\r\n");
      out.write("        <option value=\"Turks &amp; Caicos Is\">Turks &amp; Caicos Is</option>\r\n");
      out.write("        <option value=\"Tuvalu\">Tuvalu</option>\r\n");
      out.write("        <option value=\"Uganda\">Uganda</option>\r\n");
      out.write("        <option value=\"Ukraine\">Ukraine</option>\r\n");
      out.write("        <option value=\"United Arab Erimates\">United Arab Emirates</option>\r\n");
      out.write("        <option value=\"United Kingdom\">United Kingdom</option>\r\n");
      out.write("        <option value=\"United States of America\">United States of America</option>\r\n");
      out.write("        <option value=\"Uraguay\">Uruguay</option>\r\n");
      out.write("        <option value=\"Uzbekistan\">Uzbekistan</option>\r\n");
      out.write("        <option value=\"Vanuatu\">Vanuatu</option>\r\n");
      out.write("        <option value=\"Vatican City State\">Vatican City State</option>\r\n");
      out.write("        <option value=\"Venezuela\">Venezuela</option>\r\n");
      out.write("        <option value=\"Vietnam\">Vietnam</option>\r\n");
      out.write("        <option value=\"Virgin Islands (Brit)\">Virgin Islands (Brit)</option>\r\n");
      out.write("        <option value=\"Virgin Islands (USA)\">Virgin Islands (USA)</option>\r\n");
      out.write("        <option value=\"Wake Island\">Wake Island</option>\r\n");
      out.write("        <option value=\"Wallis &amp; Futana Is\">Wallis &amp; Futana Is</option>\r\n");
      out.write("        <option value=\"Yemen\">Yemen</option>\r\n");
      out.write("        <option value=\"Zaire\">Zaire</option>\r\n");
      out.write("        <option value=\"Zambia\">Zambia</option>\r\n");
      out.write("        <option value=\"Zimbabwe\">Zimbabwe</option>\r\n");
      out.write("        </select>\r\n");
      out.write("        <input type=\"text\" id=\"CountryLongName\" name=\"CountryLongName\" />\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("        <div class=\"labelSection\">Postcode</div><div class=\"inputSection\"><input type=\"text\" id=\"Postcode\"\r\n");
      out.write("        data-bind=\"value: postcode\" class=\"validate[required]\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"sectionalForm\">\r\n");
      out.write("        <div class=\"leftSection\">\r\n");
      out.write("        <div class=\"labelSection\">Telephone</div><div class=\"inputSection\"><input type=\"text\" id=\"Telephone\"\r\n");
      out.write("        data-bind=\"value: tel\" class=\"validate[required]\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"rightSection\">\r\n");
      out.write("        <div class=\"inlineLabelSection\">Fax</div><div class=\"inlineLabelSection\"><input type=\"text\" id=\"Fax\"\r\n");
      out.write("        data-bind=\"value: fax\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("        <div class=\"labelSection\">Default Currency</div><div class=\"inputSection\">\r\n");
      out.write("        <select id=\"Currency\" data-bind=\"value: defaultCurrency\" name=\"Currency\" class=\"validate[required]\">\r\n");
      out.write("        <option value=\"MYR\">MYR</option>\r\n");
      out.write("        <option value=\"USD\">USD</option>\r\n");
      out.write("        <option value=\"EUR\">EUR</option>\r\n");
      out.write("        <option value=\"HKD\">HKD</option>\r\n");
      out.write("        </select>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("        <div class=\"labelSection\">Parent Company</div><div class=\"inputSection\"><input type=\"text\" id=\"ParentCompany\"\r\n");
      out.write("        data-bind=\"value: parentCompany\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("        <div class=\"labelSection\">Disabled</div><div class=\"inputSection\"><input type=\"checkbox\" id=\"Disabled\"\r\n");
      out.write("        data-bind=\"value: disabled\"/></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div>&nbsp;</div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"formRow\">\r\n");
      out.write("        <div class=\"labelSection\"></div><div class=\"inputSection\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div id=\"maintenanceCodeCommand\" class=\"maintenanceCommand\">\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <div>&nbsp;</div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
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
