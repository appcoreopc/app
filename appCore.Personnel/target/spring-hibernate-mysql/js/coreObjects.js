
  var Offday = function()
  {
	  this.nid;
	  this.patternName; 
	  this.description;
	  this.dayPerCycle;
	  this.disabled;
	  this.remark;
	  this.offDayInfo;
  }
  
  var OffdayInfo = function()
  {
	  this.nid;
	  this.dayNo; 
	  this.dayType;
	  this.description;
	  this.dayTypeDescription;
	  this.clashedAction;
	  this.nonClashedAction;
	  this.refEntity; 
  }
  
  var HolidayGroup = function()
  {
	  this.nid;
	  this.name; 
	  this.description;
  }
  
  var Holiday = function()
  {
	  this.nid;
	  this.name; 
	  this.holidayDate; 
	  this.description;
	  this.type; 
	  this.recurring; 
	  this.refEntity;
  }

  var Company = function()
  {
	  this.nid;
	  this.companyCode; 
	  this.companyName;
	  this.address;
	  //this.address2;
	  //this.address3;
	  this.city;
	  this.country; 
	  this.defaultCurrency;
	  this.postcode;
	  this.registration;
	  this.parentCompany;
	  this.tel;
	  this.fax;
	  this.disabled; 
  }
  
  var Grade = function()
  {
	  this.nid;
	  this.code; 
	  this.description;
	  this.category; 
	  this.probationMonth; 
	  this.disabled;
  }
  
  var EmploymentType = function()
  {
	  this.nid;
	  this.code; 
	  this.description;
	  this.category; 
	  this.disabled;
  }
  

  var Division = function()
  {
	  this.nid;
	  this.divisionCode; 
	  this.divisionName;
	  this.description; 
	  this.companyId;
	  this.enabled; 
  }
   
   var Section = function()
   {
	  this.nid;
      this.sectionCode; 
	  this.sectionName;
	  this.departmentId;
	  this.enabled; 
	  this.remark;
	  this.sectionInfo;
   };
   
   var Department = function()
   {
      this.nid;
	  this.departmentCode; 
	  this.departmentName;
	  this.divisionId;
	  this.detailInfo; 
	  this.enabled; 
	  this.remark;
	  this.departmentInfo;
   };  

  var Unit = function()
   {
      this.nid;
	  this.unitCode; 
	  this.unitName; 
      this.remark; 
	  this.enabled;
	  this.unitInfo;
	  this.sectionId; 
   };
   
   var Branch = function()
   {
	  this.nid;
      this.branchCode; 
	  this.branchName;
	  this.description;
	  this.enabled; 
	  this.lastUpdated;
	  this.branchInfo;
   };
   
   var DivisionInfo = function()
   {
      this.type; 
	  this.value; 
      this.category; 
	  this.description;
   };
   
   var UnitInfo = function()
   {
      this.type; 
	  this.value; 
      this.category; 
	  this.description;
   };
   
   var BranchInfo = function()
   {
      this.type; 
	  this.value; 
      this.category; 
	  this.description;
   };
   
   var SectionInfo = function()
   {
      this.typse; 
	  this.value; 
      this.category; 
	  this.description;
   };
   
   var GradeInfo = function()
   {
      this.typse; 
	  this.value; 
      this.category; 
	  this.description;
   };
   
   var EmploymentTypeInfo = function()
   {
      this.typse; 
	  this.value; 
      this.category; 
	  this.description;
   };
 
   var DepartmentInfo = function()
   {
      this.typse; 
	  this.value; 
      this.category; 
	  this.description;
   };
 
  