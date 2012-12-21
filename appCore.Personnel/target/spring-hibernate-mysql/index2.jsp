<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AppCore</title>
</head>
<body>

<link href="css/header.css" media="screen" rel="stylesheet" type="text/css" />
<link href="css/default.css" media="screen" rel="stylesheet" type="text/css" />
<link href="css/personnel.css" media="screen" rel="stylesheet" type="text/css" />

<script language="javascript" src="js/ajaxCore.js"></script>

<script src="kendo/content/shared/js/people.js"></script>
<script src="kendo/js/jquery.min.js"></script>
<script src="kendo/js/kendo.web.min.js"></script>

<script src="kendo/js/kendo.treeview.min.js"></script>

<link href="kendo/styles/kendo.common.min.css" rel="stylesheet">
<link href="kendo/styles/kendo.default.min.css" rel="stylesheet">


<script language="javascript" src="js/carousel.js"></script>

<%@ include file="includes/header.html" %>

<style>

.demo-section {
    width : 220px;
    border-radius: 8px 8px 8px 8px;
    box-shadow: 0 1px 1px rgba(0, 0, 0, 0.45), 0 0 30px rgba(0, 0, 0, 0.07) inset;
    margin: 20px auto;
    padding: 10px;
}

</style>


<script type="text/javascript">                                         
   
   
   
   $(document).ready(function() 
   {
		
	    //var ajaxCore = new AjaxCore(); 
		//var request = ajaxCore.ajaxCore.sendRequest(hostname + "/app/Core/CompanyEntity/list", branch, "get"); 
		
		var request = $.ajax(
        {
              url: "http://localhost:8080/appCore-personnel/app/Core/CompanyEntity/list", 
              type: "get", 
              data: null, 
              dataType: "json"
              
        });   

		request.success(function(data)
		{
		
			var treeview = $("#treeView").kendoTreeView({
				dataSource: data
			});
		});
		
	});

 </script>    

<div class="mainView"> 
 <div class="form dataEntry">
 
  <div class='demo-section'>
	<div id='treeView'>
	</div>
 </div>
	<input type="button"  id="cmd" value='click me'/>
  </div> 
</div>

<%@ include file="includes/footer.html" %>

</body>
</html>


