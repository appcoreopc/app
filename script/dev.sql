insert into roles (rolename, description) values ('General', 'General');

insert into category (categoryname, description) values ('CompanySetup', 'Company');
insert into category (categoryname, description) values ('Job', 'Job');
insert into category (categoryname, description) values ('Holiday', 'Holiday');


insert into forms (formid, link, category_nid) values ('Company', 'company.jsp', 1);
insert into forms (formid, link, category_nid) values ('Branch', 'branch.jsp', 1);
insert into forms (formid, link, category_nid) values ('Division', 'division.jsp', 1);
insert into forms (formid, link, category_nid) values ('Department', 'department.jsp', 1);
insert into forms (formid, link, category_nid) values ('Section', 'section.jsp', 1);
insert into forms (formid, link, category_nid) values ('Unit', 'unit.jsp', 1);
insert into forms (formid, link, category_nid) values ('Code Setup', 'codeSetup.jsp', 1);
insert into forms (formid, link, category_nid) values ('Employee', 'employeeAdd.jsp', 1);
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


insert into forms (formid, link, category_nid) values ('Job Setup', 'jobSetup.jsp', 2);
insert into forms (formid, link, category_nid) values ('Employee Group', 'employeeGroup.jsp', 2);
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

insert into employeeContact (email, alternateEmail, correspondenceAddress1, employeeRefId) values ('kepung@gmail.com', 'kepung@hotmail.com', 'test', 1);

insert into employeeResidence (Contact1, Contact3, Level, PermanentAddress1, PermanentAddress2, employeeRefId) values ('ct1', 'ct3', 1, '84, Jalan Lalala', 'Alam Jaya', 1);

insert into employeefamily (memberName, memberType, age,  employeeRefId) values ('Jeremy', 1, 20, 1);

insert into employeeExpertise (specialty, industry, remarks,  employeeRefId) values (1, 1, 'a remark', 1);

insert into employeequalification (level, leveldescription, major, remarks , employeeRefId) values ('level Good', 'expert level', 1, 'a remark again', 1);

insert into employeeMembership (membertype, association, remarks, employeeRefId) values (1, 'ACM', 'a remark again', 1);


insert into employeeemployment (employername, job, industry) values ('Google', 'Tester', 1);
insert into employeeemployment (employername, job, industry) values ('IBM', 'Tester', 1);

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


insert into division (divisionCode, divisionName, CompanyId) values ('Div1', 'Div1', 1);
insert into division (divisionCode, divisionName, CompanyId) values ('Div2', 'Div3', 1);
insert into division (divisionCode, divisionName, CompanyId) values ('Div3', 'Div', 1);

insert into company (companyName, companyCode, Address, Address2) values ('CompanyA', 'CodeA', 'Addr1', 'Addr2');
insert into company (companyName, companyCode, Address, Address2) values ('CompanyB', 'CodeB', 'Addr1', 'Addr2');