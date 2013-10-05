insert into roles (companyId, rolename, description) values (1, 'General', 'General');
insert into roles (companyId, rolename, description) values (1, 'Group B', 'Group B');
insert into roles (companyId, rolename, description) values (2, 'General CompanyB', 'General CompanyB');

insert into category (categoryname, description) values ('CompanySetup', 'Company');
insert into category (categoryname, description) values ('Job', 'Job');
insert into category (categoryname, description) values ('Holiday', 'Holiday');

-- Type 
-- 1 - Personnel 
-- 2 - Admin
-- 3 - Leave
-- 4 - Payroll
-- 5 - User Profile

insert into forms (formid, link, category_nid, companyId, type) values ('Master Id Setup', 'masterIdSetup.jsp', 1, 1, 1);

insert into forms (formid, link, category_nid, companyId, type) values ('Company', 'company.jsp', 1, 1, 1);
insert into forms (formid, link, category_nid, companyId, type) values ('Branch', 'branch.jsp', 1, 1, 1);
insert into forms (formid, link, category_nid, companyId, type) values ('Division', 'division.jsp', 1, 1, 1);
insert into forms (formid, link, category_nid, companyId, type) values ('Department', 'department.jsp', 1, 1, 1);
insert into forms (formid, link, category_nid, companyId, type) values ('Section', 'section.jsp', 1, 1, 1);
insert into forms (formid, link, category_nid, companyId, type) values ('Unit', 'unit.jsp', 1, 1, 1);

-- insert into forms (formid, link, category_nid) values ('Employee', 'employeeAdd.jsp', 1);
insert into forms (formid, link, category_nid, companyId, type) values ('EmployeeList', 'employeeList.jsp', 1, 1, 1);

insert into forms (formid, link, category_nid, companyId, type) values ('Industry Code', 'maintenanceCode.jsp?id=1', 1, 1, 1);
insert into forms (formid, link, category_nid, companyId, type) values ('Gender Code', 'maintenanceCode.jsp?id=2', 1, 1, 1);
insert into forms (formid, link, category_nid, companyId, type) values ('Race Code', 'maintenanceCode.jsp?id=3', 1, 1, 1);
insert into forms (formid, link, category_nid, companyId, type) values ('Salutation Code', 'maintenanceCode.jsp?id=4', 1, 1, 1);
insert into forms (formid, link, category_nid, companyId, type) values ('Religion Code', 'maintenanceCode.jsp?id=5', 1, 1, 1);
insert into forms (formid, link, category_nid, companyId, type) values ('Nationality Code', 'maintenanceCode.jsp?id=6', 1, 1, 1);
insert into forms (formid, link, category_nid, companyId, type) values ('Marital Status Code', 'maintenanceCode.jsp?id=7', 1, 1, 1);
insert into forms (formid, link, category_nid, companyId, type) values ('Level Code', 'maintenanceCode.jsp?id=8', 1, 1, 1);
insert into forms (formid, link, category_nid, companyId, type) values ('Field Of ExpertiseCode', 'maintenanceCode.jsp?id=9', 1, 1, 1);
insert into forms (formid, link, category_nid, companyId, type) values ('Family Relation Type', 'maintenanceCode.jsp?id=10', 1, 1, 1);
insert into forms (formid, link, category_nid, companyId, type) values ('Employee Group', 'maintenanceCode.jsp?id=11', 1, 1, 1);
insert into forms (formid, link, category_nid, companyId, type) values ('Holiday Group', 'maintenanceCode.jsp?id=12', 1, 1, 1);
insert into forms (formid, link, category_nid, companyId, type) values ('Currency', 'maintenanceCode.jsp?id=13', 1, 1, 1);
insert into forms (formid, link, category_nid, companyId, type) values ('Configure Company', 'companyConfigurator.jsp', 1, 1, 1);

insert into forms (formid, link, category_nid, companyId, type) values ('Job Setup', 'jobSetup.jsp', 2, 1, 1);
insert into forms (formid, link, category_nid, companyId, type) values ('Configure Employee Group', 'configureEmployeeGroup.jsp', 2, 1, 1);
insert into forms (formid, link, category_nid, companyId, type) values ('Grade', 'grade.jsp', 2, 1, 1);
insert into forms (formid, link, category_nid, companyId, type) values ('Employment Type', 'employmentType.jsp', 2, 1, 1);

insert into forms (formid, link, category_nid, companyId, type) values ('HolidaySetup', 'holidaySetup.jsp', 3, 1, 1);
insert into forms (formid, link, category_nid, companyId, type) values ('Configure Employee Holiday', 'configureHolidayGroup.jsp', 3, 1, 1);

insert into forms (formid, link, category_nid, companyId, type) values ('Role', '../../appCore.administration/views/roleList.jsp', 1, 1, 1);
insert into forms (formid, link, category_nid, companyId, type) values ('Resource', '../../appCore.administration/views/resourceAccessList.jsp', 1, 1, 1);
insert into forms (formid, link, category_nid, companyId, type) values ('Manage Role Resource', '../../appCore.administration/views/configureRoleRights.jsp', 1, 1, 1);
insert into forms (formid, link, category_nid, companyId, type) values ('User', '../../appCore.administration/views/userList.jsp', 1, 1, 1);
insert into forms (formid, link, category_nid, companyId, type) values ('Manager Role User', '../../appCore.administration/views/configureUserRoles.jsp', 1, 1, 1);

insert into forms (formid, link, category_nid, companyId, type) values ('Manage Role', '../../appCore.administration/views/roleList.jsp', 1, 1, 2);
insert into forms (formid, link, category_nid, companyId, type) values ('Register Resource', '../../appCore.administration/views/resourceAccessList.jsp', 1, 1, 2);
insert into forms (formid, link, category_nid, companyId, type) values ('Configure Resource', '../../appCore.administration/views/configureRoleRights.jsp', 1, 1, 2);
insert into forms (formid, link, category_nid, companyId, type) values ('Manage User', 'userList.jsp', 1, 1, 2);
insert into forms (formid, link, category_nid, companyId, type) values ('Assign Role for User', '../../appCore.administration/views/configureUserRoles.jsp', 1, 1, 2);
insert into forms (formid, link, category_nid, companyId, type) values ('Change password', 'changePassword.jsp', 1, 1, 5);
insert into forms (formid, link, category_nid, companyId, type) values ('Test', 'test.jsp', 1, 1, 1);
insert into forms (formid, link, category_nid, companyId, type) values ('Manage UI Script', '../../appCore.administration/views/scriptWidgetListPage.jsp', 1, 1, 2);
insert into forms (formid, link, category_nid, companyId, type) values ('Core Module', '../../appCore.administration/views/coreModuleListPage.jsp', 1, 1, 2);
	
-- this is for payroll menu 
insert into forms (formid, link, category_nid, companyId, type) values ('Payroll script', '../../appCore.Payroll/views/payrollScriptListPage.jsp', 1, 1, 4);
insert into forms (formid, link, category_nid, companyId, type) values ('Payroll table setup', '../../appCore.Payroll/views/payrollTableListPage.jsp', 1, 1, 4);
insert into forms (formid, link, category_nid, companyId, type) values ('Payroll table value', '../../appCore.Payroll/views/payrollTableValueListPage.jsp', 1, 1, 4);
insert into forms (formid, link, category_nid, companyId, type) values ('Salary package', '../../appCore.Payroll/views/workPackageListPage.jsp', 1, 1, 4);
insert into forms (formid, link, category_nid, companyId, type) values ('Configure work package', '../../appCore.Payroll/views/configureWorkPackageListPage.jsp', 1, 1, 4);

-- configure user navigation data 	

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
insert into forms_actions_role (forms_nid, role_nid, permission) values (25, 1,'AUD');
insert into forms_actions_role (forms_nid, role_nid, permission) values (26, 1,'AUD');
insert into forms_actions_role (forms_nid, role_nid, permission) values (27, 1,'AUD');
insert into forms_actions_role (forms_nid, role_nid, permission) values (29, 1,'AUD');
insert into forms_actions_role (forms_nid, role_nid, permission) values (30, 1,'AUD');
insert into forms_actions_role (forms_nid, role_nid, permission) values (31, 1,'AUD');
insert into forms_actions_role (forms_nid, role_nid, permission) values (32, 1,'AUD');
insert into forms_actions_role (forms_nid, role_nid, permission) values (33, 1,'AUD');
insert into forms_actions_role (forms_nid, role_nid, permission) values (34, 1,'AUD');
insert into forms_actions_role (forms_nid, role_nid, permission) values (35, 1,'AUD');
insert into forms_actions_role (forms_nid, role_nid, permission) values (36, 1,'AUD');
insert into forms_actions_role (forms_nid, role_nid, permission) values (37, 1,'AUD');
insert into forms_actions_role (forms_nid, role_nid, permission) values (38, 1,'AUD');
insert into forms_actions_role (forms_nid, role_nid, permission) values (39, 1,'AUD');
insert into forms_actions_role (forms_nid, role_nid, permission) values (40, 1,'AUD');
insert into forms_actions_role (forms_nid, role_nid, permission) values (1, 2,'AUD');
insert into forms_actions_role (forms_nid, role_nid, permission) values (41, 2,'AUD');
insert into forms_actions_role (forms_nid, role_nid, permission) values (42, 2,'AUD');
insert into forms_actions_role (forms_nid, role_nid, permission) values (43, 4,'AUD');
insert into forms_actions_role (forms_nid, role_nid, permission) values (44, 4,'AUD');
insert into forms_actions_role (forms_nid, role_nid, permission) values (45, 4,'AUD');
insert into forms_actions_role (forms_nid, role_nid, permission) values (46, 4,'AUD');
insert into forms_actions_role (forms_nid, role_nid, permission) values (47, 4,'AUD');


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

insert into userlandingPage (userId, landingPage) values (2, 'landingpage.jsp');

insert into Users (username, password, companyId) values ('user', 'user', 1);
insert into Users (username, password, companyId) values ('user1', 'user1', 1);
insert into Users (username, password, companyId) values ('user2', 'user2', 1);
insert into Users (username, password, companyId) values ('jeremy', 'jeremy', 1);

insert into userroleassignment (role_nid, user_nid) values (1,1);
insert into userroleassignment (role_nid, user_nid) values (1,2);
insert into userroleassignment (role_nid, user_nid) values (2,2);
insert into userroleassignment (role_nid, user_nid) values (3,2);
insert into userroleassignment (role_nid, user_nid) values (4,2);

insert into employeeContact (email, alternateEmail, correspondenceAddress1, employeeRefId) values ('kepung@gmail.com', 'kepung@hotmail.com', 'test', 1);

insert into employeeResidence (Contact1, Contact3, Level, PermanentAddress1, PermanentAddress2, employeeRefId) values ('ct1', 'ct3', 1, '84, Jalan Lalala', 'Alam Jaya', 1);

insert into employeefamily (memberName, memberType, age,  employeeRefId) values ('Jeremy', 1, 20, 1);

insert into employeeExpertise (specialty, industry, remarks,  employeeRefId) values (1, 1, 'a remark', 1);

insert into employeequalification (level, leveldescription, major, remarks, localoroversea, employeeRefId) values ('level Good', 'expert level', 1, 'a remark again',  true, 1);

insert into employeeMembership (membertype, association, remarks, employeeRefId) values (1, 'ACM', 'a remark again', 1);

insert into employeeemployment (employername, job, industry, employeerefid) values ('Google', 'Tester', 1, 1);
insert into employeeemployment (employername, job, industry, employeerefid) values ('IBM', 'Tester', 1, 1);

insert into AssociationMembershipType (name, description, companyref) values ('Professional Member', 'Professional Member', 1);
insert into AssociationMembershipType (name, description, companyref) values ('Normal Member', 'Normal Member', 1);

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
insert into company (companyName, companyCode, Address, Address2) values ('CompanyA', 'CodeA', 'Addr1', 'Addr2');
insert into company (companyName, companyCode, Address, Address2) values ('CompanyB', 'CodeB', 'Addr1', 'Addr2');


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

insert into department (departmentCode, departmentName, CompanyId, divisionId) values ('DeptA', 'DepartmentA', 1, 1);
insert into department (departmentCode, departmentName, CompanyId, divisionId) values ('DeptB', 'DepartmentB', 1, 1);
insert into department (departmentCode, departmentName, CompanyId, divisionId) values ('DeptC', 'DepartmentC', 1, 2);

insert into department (departmentCode, departmentName, CompanyId, divisionId) values ('Dept1', 'BBBBBBDepartment', 2, 4);
insert into department (departmentCode, departmentName, CompanyId, divisionId) values ('Dept2', 'CCCCCCDepartment', 2, 4);

insert into section (sectionCode, sectionName, CompanyId, departmentId) values ('SectA', 'SectionA', 1, 1);
insert into section (sectionCode, sectionName, CompanyId, departmentId) values ('SectB', 'SectionB', 1, 1);

insert into section (sectionCode, sectionName, CompanyId, departmentId) values ('Sect11111', 'Section1111', 2, 4);
insert into section (sectionCode, sectionName, CompanyId, departmentId) values ('Sect22222', 'Section2222', 2, 4);

insert into unit (unitCode, unitName, CompanyId, sectionId) values ('Unit1', 'Unit1Name', 1, 1);
insert into unit (unitCode, unitName, CompanyId, sectionId) values ('Unit2', 'Unit2Name', 1, 1);
insert into unit (unitCode, unitName, CompanyId, sectionId) values ('Unit3', 'Unit3Name', 1, 1);

insert into unit (unitCode, unitName, CompanyId, sectionId) values ('UnitAAAA', 'UnitAAAAA', 2, 3);
insert into unit (unitCode, unitName, CompanyId, sectionId) values ('UnitBBBB', 'UnitBBBBB', 2, 3);

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

insert into jobsetupQualification (level, description, fieldOfStudy, jobSetupRef) values (1, 'Level 1', 1, 1);
insert into jobsetupQualification (level, description, fieldOfStudy, jobSetupRef) values (1, 'Level 2', 1, 1);
insert into jobsetupQualification (level, description, fieldOfStudy, jobSetupRef) values (1, 'Level 3', 1, 1);

insert into jobsetupExperience (expertise, description, experienceYears, jobSetupRef) values (1, 'Level 1', 1, 269);
insert into jobsetupSkill (skill, level, category, categorydescription, jobSetupRef) values (1, 1, 1, 'category description', 269);

insert into UserProfileConfiguration (userId, DefaultCompanyId) values (1, 1);
insert into UserProfileConfiguration (userId, DefaultCompanyId) values (2, 1);
insert into UserProfileConfiguration (userId, DefaultCompanyId) values (3, 1);

insert into UserLanding (userId, ScriptId, Enabled, ApplicationType) values (2, 1, true, 16);
insert into UserLanding (userId, ScriptId, Enabled, ApplicationType) values (2, 2, true, 16);
insert into UserLanding (userId, ScriptId, Enabled, ApplicationType) values (2, 3, true, 16);

insert into ScriptWidget(CompanyId, ScriptName, ScriptPath) values (1, 'Script1', 'js/test.js');
insert into ScriptWidget(CompanyId, ScriptName, ScriptPath) values (2, 'Script1', 'js/test.js');
insert into ScriptWidget(CompanyId, ScriptName, ScriptPath) values (3, 'Script1', 'js/test.js');

insert into CoreModule(CompanyId, Description, Name) values (1, 'Personnel', 'Personnel');
insert into CoreModule(CompanyId, Description, Name) values (1, 'Administration', 'Administration');
insert into CoreModule(CompanyId, Description, Name) values (1, 'Leave', 'Leave');
insert into CoreModule(CompanyId, Description, Name) values (1, 'Payroll', 'Payroll');
insert into CoreModule(CompanyId, Description, Name) values (1, 'User Profile', 'User Profile');
