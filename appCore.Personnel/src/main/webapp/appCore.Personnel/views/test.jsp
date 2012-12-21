<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>

<%@ include file="../includes/css_includes.html" %>
<%@ include file="../includes/js_includes.html" %>
<%@ include file="/includes/header.html" %>

<script type="text/javascript">          


 var Section = function()
   {
      this.sectionCode; 
	  this.sectionName;
	  this.departmentId;
	  this.detailInfo; 
	  this.enabled; 
	  this.remark;
   };
   

   var Department = function()
   {
      this.departmentCode; 
	  this.departmentName;
	  this.divisionId;
	  this.detailInfo; 
	  this.enabled; 
	  this.remark;
	  this.section= []; 
   };

  
	$(document).ready(function() 
	{
	
	  var s1 = new Section();
	   s1.sectionCode = "s5";
	   s1.sectionName = "s1_name";
	   s1.departmentId = 1; 
	   s1.enabled = 1; 
	   s1.remark = "testtestest";
	   
	     
	   var s2 = new Section();
	   s2.sectionCode = "s2";
	   s2.sectionName = "s1_name";
	   s2.departmentId = 1; 
	   s2.enabled = 1; 
	   s2.remark = "testtestest";
	   
	   var s = [ s1, s2 ];
	   
	   var d = new Department(); 
	   d.departmentCode = "d1";
	   d.departmentName = "dName";
	   d.remark = "testing testing"; 
	   d.enabled = 1; 
	   d.divisionId = 2;
	   d.detailInfo = 1; 
	   d.section = s;
	   
		//var ajaxCore = new AjaxCore();
		//var request = ajaxCore.sendRequest(hostname + "/app/Core/Department/add", d, "post");
		
		$.ajax(
            {
              url: globalHostname + "/app/Core/Department/add",
              type: "POST", 
              data: JSON.stringify( d ), 
              dataType: "json",
              contentType: "application/json"
            } );    
	
});

</script>    

<div class="form dataEntry">
	<h1>Department </h1>
	
	<div class="formRow">
		Department Code Maintenance
    </div>

	<div class="formRow">	
		&nbsp;
    </div>
	 
	<div class="maintenanceCommand"> 
		<button type="button" id="addBtn">Add New Department</button>
		<button type="button" id="updateBtn">Edit Department</button>
	</div>
	<div class="formRow">	
		&nbsp;
    </div>
	 
	 
  <div>
		<div id="grid" style="height: 380px"></div>
	</div>
</div>

<%@ include file="/includes/footer.html" %>

</body>
</html>