insert into roles (rolename, description) values ('General', 'General');

insert into category (categoryname, description) values ('CompanySetup', 'Company');
insert into category (categoryname, description) values ('Job', 'Job');
insert into category (categoryname, description) values ('Holiday', 'Holiday');

insert into forms (formid, link, category_nid) values ('Master Id Setup', 'masterIdSetup.jsp', 1);

insert into forms (formid, link, category_nid) values ('Company', 'company.jsp', 1);
insert into forms (formid, link, category_nid) values ('Branch', 'branch.jsp', 1);
insert into forms (formid, link, category_nid) values ('Division', 'division.jsp', 1);
insert into forms (formid, link, category_nid) values ('Department', 'department.jsp', 1);
insert into forms (formid, link, category_nid) values ('Section', 'section.jsp', 1);
insert into forms (formid, link, category_nid) values ('Unit', 'unit.jsp', 1);

-- insert into forms (formid, link, category_nid) values ('Employee', 'employeeAdd.jsp', 1);
insert into forms (formid, link, category_nid) values ('EmployeeList', 'employeeList.jsp', 1);

insert into forms (formid, link, category_nid) values ('Industry Code', 'maintenanceCode.jsp?id=1', 1);
insert into forms (formid, link, category_nid) values ('Gender Code', 'maintenanceCode.jsp?id=2', 1);
insert into forms (formid, link, category_nid) values ('Race Code', 'maintenanceCode.jsp?id=3', 1);
insert into forms (formid, link, category_nid) values ('Salutation Code', 'maintenanceCode.jsp?id=4', 1);
insert into forms (formid, link, category_nid) values ('Religion Code', 'maintenanceCode.jsp?id=5', 1);
insert into forms (formid, link, category_nid) values ('Nationality Code', 'maintenanceCode.jsp?id=6', 1);
insert into forms (formid, link, category_nid) values ('Marital Status Code', 'maintenanceCode.jsp?id=7', 1);
insert into forms (formid, link, category_nid) values ('Level Code', 'maintenanceCode.jsp?id=8', 1);
insert into forms (formid, link, category_nid) values ('Field Of ExpertiseCode', 'maintenanceCode.jsp?id=9', 1);
insert into forms (formid, link, category_nid) values ('Family Relation Type', 'maintenanceCode.jsp?id=10', 1);
insert into forms (formid, link, category_nid) values ('Employee Group', 'maintenanceCode.jsp?id=11', 1);
insert into forms (formid, link, category_nid) values ('Holiday Group', 'maintenanceCode.jsp?id=12', 1);
insert into forms (formid, link, category_nid) values ('Currency', 'maintenanceCode.jsp?id=13', 1);

insert into forms (formid, link, category_nid) values ('Job Setup', 'jobSetup.jsp', 2);
insert into forms (formid, link, category_nid) values ('Configure Employee Group', 'configureEmployeeGroup.jsp', 2);
insert into forms (formid, link, category_nid) values ('Grade', 'grade.jsp', 2);
insert into forms (formid, link, category_nid) values ('Employment Type', 'employmentType.jsp', 2);

insert into forms (formid, link, category_nid) values ('HolidaySetup', 'holidaySetup.jsp', 3);
insert into forms (formid, link, category_nid) values ('Configure Employee Holiday', 'configureHolidayGroup.jsp', 3);


insert into forms_actions_role (forms_nid, role_nid, permission) values (1,1, 'AUD');
insert into forms_actions_role (forms_nid, role_nid, permission) values (2,1, 'AUD');
insert into forms_actions_role (forms_nid, role_nid, permission) values (3,1, 'AUD');
insert into forms_actions_role (forms_nid, role_nid, permission) values (4,1, 'AUD');
insert into forms_actions_role (forms_nid, role_nid, permission) values (5,1, 'AUD');
insert into forms_actions_role (forms_nid, role_nid, permission) values (6,1, 'AUD');
insert into forms_actions_role (forms_nid, role_nid, permission) values (7,1, 'AUD');
insert into forms_actions_role (forms_nid, role_nid, permission) values (8,1, 'AUD');
insert into forms_actions_role (forms_nid, role_nid, permission) values (9,1, 'AUD');
insert into forms_actions_role (forms_nid, role_nid, permission) values (10,1, 'AUD');
insert into forms_actions_role (forms_nid, role_nid, permission) values (11, 1,'AUD');
insert into forms_actions_role (forms_nid, role_nid, permission) values (12, 1,'AUD');
insert into forms_actions_role (forms_nid, role_nid, permission) values (13, 1,'AUD');


insert into level (name, description, companyRef) values ('Level1', 'Level1', 1);
insert into level (name, description, companyRef) values ('Level2', 'Level2', 1);
insert into level (name, description, companyRef) values ('Level3', 'Level3', 1);

insert into level (name, description, companyRef) values ('Level1', 'Level1', 2);
insert into level (name, description, companyRef) values ('Level2', 'Level2', 2);
insert into level (name, description, companyRef) values ('Level3', 'Level3', 2);


insert into fieldofexpertise (name, description, companyRef) values ('ExpertiseA', 'ExpertA', 1);
insert into fieldofexpertise (name, description, companyRef) values ('ExpertiseB', 'ExpertB', 1);
insert into fieldofexpertise (name, description, companyRef) values ('ExpertiseC', 'ExpertC', 1);

insert into fieldofexpertise (name, description, companyRef) values ('ExpertiseA', 'ExpertA', 2);
insert into fieldofexpertise (name, description, companyRef) values ('ExpertiseB', 'ExpertB', 2);
insert into fieldofexpertise (name, description, companyRef) values ('ExpertiseC', 'ExpertC', 2);


insert into industry (name, description, companyRef) values ('IT', 'IT', 1);
insert into industry (name, description, companyRef) values ('Account', 'Account', 1);
insert into industry (name, description, companyRef) values ('Business', 'Business', 1);


insert into industry (name, description, companyRef) values ('IT', 'IT', 2);
insert into industry (name, description, companyRef) values ('Account', 'Account', 2);


insert into gender (name, description, companyRef) values ('Male', 'Male', 1);
insert into gender (name, description, companyRef) values ('Female', 'Female', 1);

insert into gender (name, description, companyRef) values ('Male', 'Male', 2);
insert into gender (name, description, companyRef) values ('Female', 'Female', 2);


insert into salutation (name, description, companyRef) values ('Mr', 'Mr', 1);
insert into salutation (name, description, companyRef) values ('Mrs', 'Mrs', 1);
insert into salutation (name, description, companyRef) values ('Ms', 'Ms', 1);
insert into salutation (name, description, companyRef) values ('Dr', 'Dr',1 );


insert into salutation (name, description, companyRef) values ('Mr', 'Mr', 2);
insert into salutation (name, description, companyRef) values ('Mrs', 'Mrs', 2);
insert into salutation (name, description, companyRef) values ('Ms', 'Ms', 2);
insert into salutation (name, description, companyRef) values ('Dr', 'Dr', );


insert into maritalStatus (name, description, companyRef) values ('Single', 'Single', 1);
insert into maritalStatus (name, description, companyRef) values ('Married', 'Married', 1);
insert into maritalStatus (name, description, companyRef) values ('Divorced', 'Divorced', 1);

insert into maritalStatus (name, description, companyRef) values ('Single', 'Single', 2);
insert into maritalStatus (name, description, companyRef) values ('Married', 'Married', 2);
insert into maritalStatus (name, description, companyRef) values ('Divorced', 'Divorced', 2);



insert into Users (username, password) values ('user', 'user');
insert into Users (username, password) values ('user1', 'user1');
insert into Users (username, password) values ('user2', 'user2');
insert into Users (username, password) values ('jeremy', 'jeremy');

insert into userrole_assignment (roles_nid, assignedUsers_nid) values (1,1);
insert into userrole_assignment (roles_nid, assignedUsers_nid) values (1,2);



insert into employeeContact (email, alternateEmail, correspondenceAddress1, employeeRefId) values ('kepung@gmail.com', 'kepung@hotmail.com', 'test', 1);

insert into employeeResidence (Contact1, Contact3, Level, PermanentAddress1, PermanentAddress2, employeeRefId) values ('ct1', 'ct3', 1, '84, Jalan Lalala', 'Alam Jaya', 1);

insert into employeefamily (memberName, memberType, age,  employeeRefId) values ('Jeremy', 1, 20, 1);

insert into employeeExpertise (specialty, industry, remarks,  employeeRefId) values (1, 1, 'a remark', 1);

insert into employeequalification (level, leveldescription, major, remarks , employeeRefId) values ('level Good', 'expert level', 1, 'a remark again', 1);

insert into employeeMembership (membertype, association, remarks, employeeRefId) values (1, 'ACM', 'a remark again', 1);



insert into employeeemployment (employername, job, industry, employeerefid) values ('Google', 'Tester', 1, 1);
insert into employeeemployment (employername, job, industry, employeerefid) values ('IBM', 'Tester', 1, 1);

insert into AssociationMembershipType (name, description) values ('Professional Member', 'Professional Member');
insert into AssociationMembershipType (name, description) values ('Normal Member', 'Normal Member');

insert into FamilyRelationType (name, description, companyRef) values ('Brother', 'Brother', 1);
insert into FamilyRelationType (name, description, companyRef) values ('Sister', 'Sister', 1);
insert into FamilyRelationType (name, description, companyRef) values ('Aunty', 'Aunty', 1);
insert into FamilyRelationType (name, description, companyRef) values ('Father', 'Father', 1);
insert into FamilyRelationType (name, description, companyRef) values ('Mother', 'Mother', 1);
insert into FamilyRelationType (name, description, companyRef) values ('Grand Father', 'Grand Father', 1);
insert into FamilyRelationType (name, description, companyRef) values ('Grand Mother', 'Grand Mother', 1);
	
insert into Country (name, description, companyRef) values ('Malaysia', 'Malaysia', 1);
insert into Country (name, description, companyRef) values ('Singapore', 'Singapore', 1);
insert into Country (name, description, companyRef) values ('US', 'US', 1);
insert into Country (name, description, companyRef) values ('India', 'India', 1);


insert into Country (name, description, companyRef) values ('Malaysia', 'Malaysia', 2);
insert into Country (name, description, companyRef) values ('Singapore', 'Singapore', 2);
insert into Country (name, description, companyRef) values ('US', 'US', 2);
insert into Country (name, description, companyRef) values ('India', 'India', 2);

insert into nationality (name, description, companyRef) values ('American', 'American', 1);
insert into nationality (name, description, companyRef) values ('British', 'British', 1);
insert into nationality (name, description, companyRef) values ('Malaysian', 'Malaysian', 1);

insert into race (name, description, companyRef) values ('Chinese', 'Chinese', 1);
insert into race (name, description, companyRef) values ('Malay', 'Malay', 1);
insert into race (name, description, companyRef) values ('Indian', 'Indian', 1);

insert into Currency (name, description, companyRef) values ('USD', 'USD', 1);
insert into Currency (name, description, companyRef) values ('MYR', 'MYR', 1);
insert into Currency (name, description, companyRef) values ('SGD', 'SGD', 1);
insert into Currency (name, description, companyRef) values ('PESO', 'PESO', 1);


insert into religion (name, description, companyRef) values ('Christian', 'Christian', 1);
insert into religion (name, description, companyRef) values ('Jewish', 'Jewish', 1);
insert into religion (name, description, companyRef) values ('Buddhist', 'Buddhist', 1);
insert into religion (name, description, companyRef) values ('Islam', 'Islam', 1);

insert into employee (name, firstname, lastname, companyref) values ('jeremy', 'jeremy', 'woo', 1);

insert into branch (branchCode, BranchName, CompanyId) values ('B1', 'Branch One', 1);
insert into branch (branchCode, BranchName, CompanyId) values ('B2', 'Branch Two', 1);
insert into branch (branchCode, BranchName, CompanyId) values ('B3', 'Branch Three', 1);

insert into branch (branchCode, BranchName, CompanyId) values ('Branch1', 'Branch One', 2);
insert into branch (branchCode, BranchName, CompanyId) values ('BranchB2', 'Branch Two', 2);
insert into branch (branchCode, BranchName, CompanyId) values ('BranchB3', 'Branch Three', 2);
	
insert into branch (branchCode, BranchName, CompanyId) values ('Branch4', 'Branch One', 1);
insert into branch (branchCode, BranchName, CompanyId) values ('Branch5', 'Branch Two', 1);
insert into branch (branchCode, BranchName, CompanyId) values ('Branch6', 'Branch Three', 1);


insert into branchinfo (category, description, type, value, refEntity) values ('cat1', 'cat1description', 'type1', 'val1', 7);
insert into branchinfo (category, description, type, value, refEntity) values ('cat2', 'cat2description', 'type2', 'val2', 7);
insert into branchinfo (category, description, type, value, refEntity) values ('cat3', 'cat3description', 'type3', 'val3', 7);
insert into branchinfo (category, description, type, value, refEntity) values ('cat4', 'cat4description', 'type4', 'val4', 7);

insert into division (divisionCode, divisionName, CompanyId) values ('Div1', 'Div1', 1);
insert into division (divisionCode, divisionName, CompanyId) values ('Div2', 'Div3', 1);
insert into division (divisionCode, divisionName, CompanyId) values ('Div3', 'Div', 1);

insert into division (divisionCode, divisionName, CompanyId) values ('DivSector2', 'DivSector2', 2);
insert into division (divisionCode, divisionName, CompanyId) values ('DivSector3', 'DeiSector3', 2);


insert into company (companyName, companyCode, Address, Address2) values ('CompanyA', 'CodeA', 'Addr1', 'Addr2');
insert into company (companyName, companyCode, Address, Address2) values ('CompanyB', 'CodeB', 'Addr1', 'Addr2');


insert into department (departmentCode, departmentName, CompanyId) values ('DeptA', 'DepartmentA', 1);
insert into department (departmentCode, departmentName, CompanyId) values ('DeptB', 'DepartmentB', 1);
insert into department (departmentCode, departmentName, CompanyId) values ('DeptC', 'DepartmentC', 1);

insert into department (departmentCode, departmentName, CompanyId) values ('Dept1', 'BBBBBBDepartment', 2);
insert into department (departmentCode, departmentName, CompanyId) values ('Dept2', 'CCCCCCDepartment', 2);



insert into section (sectionCode, sectionName, CompanyId) values ('SectA', 'SectionA', 1);
insert into section (sectionCode, sectionName, CompanyId) values ('SectB', 'SectionB', 1);

insert into section (sectionCode, sectionName, CompanyId) values ('Sect11111', 'Section1111', 2);
insert into section (sectionCode, sectionName, CompanyId) values ('Sect22222', 'Section2222', 2);


insert into unit (unitCode, unitName, CompanyId) values ('Unit1', 'Unit1Name', 1);
insert into unit (unitCode, unitName, CompanyId) values ('Unit2', 'Unit2Name', 1);
insert into unit (unitCode, unitName, CompanyId) values ('Unit3', 'Unit3Name', 1);

insert into unit (unitCode, unitName, CompanyId) values ('UnitAAAA', 'UnitAAAAA', 2);
insert into unit (unitCode, unitName, CompanyId) values ('UnitBBBB', 'UnitBBBBB', 2);


insert into divisioninfo (category, description, type, value, refEntity) values ('DivInfo1', 'Div1Desc', 'DivType1', 'Div1Value', 1);
insert into divisioninfo (category, description, type, value, refEntity) values ('DivInfo2', 'Div2Desc', 'DivType2', 'Div2Value', 1);
insert into divisioninfo (category, description, type, value, refEntity) values ('DivInfo3', 'Div3Desc', 'DivType3', 'Div3Value', 1);


insert into departmentInfo (category, description, type, value, refEntity) values ('DepInfo1', 'DepInfoDesc1', 'DeptInfoType1', 'DepInfoVal1', 1);
insert into departmentInfo (category, description, type, value, refEntity) values ('DepInfo2', 'DepInfoDesc2', 'DeptInfoType2', 'DepInfoVal2', 1);
insert into departmentInfo (category, description, type, value, refEntity) values ('DepInfo3', 'DepInfoDesc3', 'DeptInfoType3', 'DepInfoVal3', 1);

insert into departmentInfo (category, description, type, value, refEntity) values ('DepInfoA', 'DepInfoDescA', 'DeptInfoTypeA', 'DepInfoValA', 2);
insert into departmentInfo (category, description, type, value, refEntity) values ('DepInfoB', 'DepInfoDescB', 'DeptInfoTypeB', 'DepInfoValB', 2);

insert into departmentInfo (category, description, type, value, refEntity) values ('DPP', 'DP', 'DPTYPE', 'DPValue', 3);
	
	
insert into sectionInfo (category, description, type, value, refEntity) values ('Sec1', 'Sec1Desc1', 'Sec1', 'Sec1Val', 1);
insert into sectionInfo (category, description, type, value, refEntity) values ('Sec2', 'Sec1Desc2', 'Sec2', 'Sec2Val', 1);
insert into sectionInfo (category, description, type, value, refEntity) values ('Sec3', 'Sec1Desc3', 'Sec3', 'Sec3Val', 1);

insert into sectionInfo (category, description, type, value, refEntity) values ('SecA', 'SecAAAA', 'SecAAA', 'SecValueA', 2);
insert into sectionInfo (category, description, type, value, refEntity) values ('SecB', 'SecBBBB', 'SecBBB', 'SecValueB', 2);


insert into unitInfo (category, description, type, value, refEntity) values ('UnitA', 'UnitADesc', 'UnitAVal', 'UnitValA', 1);
insert into unitInfo (category, description, type, value, refEntity) values ('UnitB', 'UnitBDesc', 'UnitBVal', 'UnitValB', 1);
insert into unitInfo (category, description, type, value, refEntity) values ('UnitC', 'UnitCDesc', 'UnitCVal', 'UnitValC', 1);

insert into unitInfo (category, description, type, value, refEntity) values ('Unit1', 'Unit1Desc', 'Unit1Val', 'UnitVal1', 2);
insert into unitInfo (category, description, type, value, refEntity) values ('UUUUU', 'UDESCCCCC', 'UVALLLL', 'UValvalval', 2);



insert into grade (code, category, description, companyref) values ('Grade1', 'Cat1', 'Description1', 1);
insert into grade (code, category, description, companyref) values ('Grade2', 'Cat2', 'Description2', 1);
insert into grade (code, category, description, companyref) values ('Grade3', 'Cat3', 'Description3', 1);
insert into grade (code, category, description, companyref) values ('Grade4', 'Cat4', 'Description4', 1);

insert into grade (code, category, description, companyref) values ('GradeAAA', 'CatAAA', 'DescriptionAAA', 2);
insert into grade (code, category, description, companyref) values ('GradeBBB', 'CatBBB', 'DescriptionBBB', 2);


insert into employmentType (code, category, description, companyref) values ('Permanent', 'Permanent', 'Perment/Forever', 1);
insert into employmentType (code, category, description, companyref) values ('Temporary', 'Temprary', 'Temporary/Possible Permanent', 1);
insert into employmentType (code, category, description, companyref) values ('Part Time', 'Part Time', 'Part Time-Desc', 1);

insert into employmentType (code, category, description, companyref) values ('Permanent', 'Permanent', 'Perment', 2);
insert into employmentType (code, category, description, companyref) values ('Temporary', 'Temprary', 'Temporary', 2);
insert into employmentType (code, category, description, companyref) values ('Part Time', 'Part Time', 'Parttimers', 2);


	
insert into jobtype (code, jobcategory, description, companyref) values ('Job2', 'Job2Type', 'Job2Desc', 1);
insert into jobtype (code, jobcategory, description, companyref) values ('Job3', 'Job3Type', 'Job3Desc', 1);


insert into jobtype (code, jobcategory, description, companyref) values ('JobA', 'JobAType', 'JobADesc', 2);
insert into jobtype (code, jobcategory, description, companyref) values ('JobB', 'JobBType', 'JobBDesc', 2);


insert into EmployeeGroup (name, description, companyref) values ('Emp1', 'Emp1',  1);
insert into EmployeeGroup (name, description, companyref) values ('Emp2', 'Emp2',  1);
insert into EmployeeGroup (name, description, companyref) values ('Emp3	', 'Emp3',  1);

insert into EmployeeGroup (name, description, companyref) values ('EmpA', 'EmpA', 2);
insert into EmployeeGroup (name, description, companyref) values ('EmpB', 'EmpB', 2);


	
insert into holiday (name,description, holidaydate, recurring, companyRef) values ('New Year', 'New Year', '2012-01-01', true, 1);
insert into holiday (name,description, holidaydate, recurring, companyRef) values ('Company Holiday #1', 'Company Holiday', '2012-12-26', true, 1);
insert into holiday (name,description, holidaydate, recurring, companyRef) values ('Company Holiday #2', 'Company Holiday', '2012-12-27', true, 1);


insert into holiday (name,description, holidaydate, recurring, companyRef) values ('Christmas', 'Merry Merry Christmas', '2012-12-25', true, 2);
insert into holiday (name,description, holidaydate, recurring, companyRef) values ('New Year', 'New Year', '2012-01-01', true, 2);


insert into HolidayGroup (name, description, companyRef) values ('General Worker', 'General Worker', 1);
insert into HolidayGroup (name, description, companyRef) values ('Developer', 'Developer', 1);
insert into HolidayGroup (name, description, companyRef) values ('Contractors', 'Contractors', 1);

insert into HolidayGroup (name, description, companyRef) values ('General WorkerB', 'General Worker', 2);
insert into HolidayGroup (name, description, companyRef) values ('DeveloperB', 'Developer', 2);
insert into HolidayGroup (name, description, companyRef) values ('ContractorsB', 'Contractors', 2);


insert into EmployeeGroup_Assignment (EmployeeGroup_nid, assignedEmployees_nid) values (1, 1);

