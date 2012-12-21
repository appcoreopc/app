var hostname =  "http://localhost:8080/appCore-personnel";
var hostAuthorizationUrl = "http://localhost:8080/appCore-personnel/app/User/Forms/get";

var coreBranchPage = "Test";
var coreDepartmentPage = "Test";
var coreCompanyPage = "Test";
var coreDivisionPage = "Test";
var coreUnitPage = "Test";
var coreSectionPage = "Test";


var menuDataSource = [
        {
            text: "Setup",
            items: 
			[
                { text: "Company", link : "company.jsp" },
                { text: "Branch", link : "branch.jsp" },
                { text: "Division", link : "division.jsp" },
                { text: "Department", link : "department.jsp" },
                { text: "Section", link : "section.jsp" },
                { text: "Unit", link : "unit.jsp" },
             	{ text: "Id Master Table", link : "unit.jsp" }
            ],
			
        }, 
		{   
			text : "Job", 
			items: 
			[	
                { text: "Job Setup", link : "jobSetup.jsp" },
                { text: "Grade", link : "grade.jsp" },
                { text: "Employee Group", link : "employeeGroup.jsp" },
                { text: "Employment Type", link : "employmentType.jsp" }
            ]
		}, 
		{   
			text : "Holiday", 
			items: 
			[	
                { text: "Gazetted/NonGazetted Setup", link : "holidaySetup.jsp" },
                { text: "Holiday Group", link : "holidayGroup.jsp" },
                { text: "Configure Holiday Group", link : "offDay.jsp" },
                { text: "Configure Employee Holiday", link : "workDayGeneration.jsp" },
                { text: "Holiday Setup", link : "holidaySetup.jsp" }
            ]
		}
	];