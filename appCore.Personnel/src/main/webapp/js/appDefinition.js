var globalHostname =  "http://localhost:8080/appCore-personnel";
var globalMenuServiceUrl = "/app/User/Forms/listMenu";
var globalCompanyServiceUrl = "/app/Core/CompanyEntity/list";
//var globalCurrentId;

var hostAuthorizationUrl = globalHostname + "/app/User/Forms/get";

var coreBranchPage = "Branch";
var coreEmployeePage = "Branch";
var coreEmployeeGeneralViewPage = "Branch";
var coreEmployeeContactViewPage = "Branch";
var coreEmployeeResidenceViewPage = "Branch";
var coreEmployeeFamilyViewPage = "Branch";
var coreEmployeeEmploymentViewPage = "Branch";
var coreEmployeeExpertiseViewPage = "Branch";
var coreDepartmentPage = "Department";
var coreCompanyPage = "Company";
var coreDivisionPage = "Division";
var coreUnitPage = "Unit";
var coreSectionPage = "Section";
var coreAdminPage = "Admin";
var coreUserPage = "User";
var coreGradePage = "Grade";
var coreEmploymentTypePage = "Employment Type";
var coreHolidaySetupPage = "HolidaySetup";
var coreHolidayGroupPage = "HolidayGroup";
var coreCodeMaintenancePage = "Branch";

var coreJobQualification = "Branch";

var coreJobExperience = "Branch";

var coreJobType= "Branch";

var coreJobSkillRequirement = "Branch";

var globalEmployeeModule = "Branch";

var globalCoreGridAppearanceToobarCreateCancel = "toolbarCreateCancel";

var globalEditorModeInsert = "Insert";

var globalEditorModeEdit = "Edit";

var globalIndexPage = globalHostname + "/index.jsp";

var globalCurrentCompanyId = 1;

var globalCurrentEmployee;

var globalFormMode = 0;

var globalCodeMaintenance;

var globalEmployeeUrl = globalHostname + "/app/Job/Employee";

var globalEmployeeSaveOrUpdateUrl = globalHostname + "/app/Job/Employee/saveOrUpdate";

var globalEmployeeListUrl = globalHostname + "/app/Job/Employee/list";

var globalEmployeeGetUrl = globalHostname + "/app/Job/Employee/get";

var globalEmployeeContactAddUrl = globalHostname + "/app/Job/EmployeeContact/add";

var globalEmployeeContactSaveOrUpdateUrl = globalHostname + "/app/Job/EmployeeContact/saveOrUpdate";

var globalEmployeeContactListUrl = globalHostname + "/app/Job/EmployeeContact/list";

var globalEmployeeContactGetUrl = globalHostname + "/app/Job/EmployeeContact/list";

var globalEmployeeContactGetByEmployeeUrl = globalHostname + "/app/Job/EmployeeContact/getByEmployee";

var globalCompanyUrl = globalHostname + "/app/Core/Company";

var globalCompanyListUrl = globalHostname + "/app/Core/Company/list";

var globalCompanyGetSummaryUrl = globalHostname + "/app/Core/Company/getSummary";

var globalCompanyAddUrl = globalHostname + "/app/Core/Company/add";

var globalCompanyDeleteUrl = globalHostname + "/app/Core/Company/delete";

var globalCompanySaveOrUpdateUrl = globalHostname + "/app/Core/Company/saveOrUpdate";

var globalCompanyGetUrl = globalHostname + "/app/Core/Company/get";

var globalCompanySaveOrUpdateUrl = globalHostname + "/app/Core/Company/saveOrUpdate";

var globalEmployeeResidenceListUrl = globalHostname + "/app/Job/EmployeeResidence/list";

var globalEmployeeResidencSaveUpdateUrl = globalHostname + "/app/Job/EmployeeResidence/saveOrUpdate";

var globalEmployeeResidenceGetByEmployeeUrl = globalHostname + "/app/Job/EmployeeResidence/getByEmployee";

var globalEmployeeEmploymentListUrl = globalHostname + "/app/Job/EmployeeEmployment/list";

var globalEmployeeEmploymentGetByEmployeeUrl = globalHostname + "/app/Job/EmployeeEmployment/getByEmployee";

var globalEmployeeGeneralInfoListUrl = globalHostname + "/app/Job/Employee/list";

var globalEmployeeEmployeeMembershipUrl = globalHostname + "/app/Job/EmployeeMembership/list";

var globalEmployeeEmployeeMembershipGetByEmployeeUrl = globalHostname + "/app/Job/EmployeeMembership/getByEmployee";

var globalEmployeeQualificationListUrl = globalHostname + "/app/Job/EmployeeQualification/list";

var globalEmployeeExpertiseListUrl = globalHostname + "/app/Job/EmployeeExpertise/list";

var globalEmployeeExpertiseGetByEmployeeUrl = globalHostname + "/app/Job/EmployeeExpertise/getByEmployee";

var globalEmployeeFamilyListUrl = globalHostname + "/app/Job/EmployeeFamily/list";

var globalEmployeeFamilyGetByEmployeeUrl = globalHostname + "/app/Job/EmployeeFamily/getByEmployee";

var globalEmployeeExpertiseAddUrl = globalHostname + "/app/Job/EmployeeExpertise/add";

var globalEmployeeExpertiseSaveOrUpdateUrl = globalHostname + "/app/Job/EmployeeExpertise/saveOrUpdate";

var globalEmployeeIndustryList = globalHostname + "/app/Job/Industry/list";

var globalEmployeeLevelList = globalHostname + "/app/Job/Level/list";

var globalEmployeeAssociationMemberTypelList = globalHostname + "/app/Job/AssociationMembershipType/list";

var globalEmployeeFamilyMemberTypelList = globalHostname + "/app/Job/FamilyRelationType/list";

var globalEmployeeFieldExpertiseList = globalHostname + "/app/Job/FieldOfExpertise/list";

var globalEmployeeSalutationList = globalHostname + "/app/Job/Salutation/list";

var globalEmployeeRaceList = globalHostname + "/app/Job/Race/list";

var globalEmployeeNationalityList = globalHostname + "/app/Job/Nationality/list";

var globalEmployeeReligionList = globalHostname + "/app/Job/Religion/list";

var globalCountryList = globalHostname + "/app/Job/Country/list";

var globalEmployeeMaritalStatusExpertiseList = globalHostname + "/app/Job/MaritalStatus/list";

var globalEmployeeGenderExpertiseList = globalHostname + "/app/Job/Gender/list";

var globallandingPage = "landingpage.jsp";

var globalCompanyCentralPage = "company.jsp";

var globalEmployeeQualificationUrl = globalHostname + "/app/Job/EmployeeQualification/add";

var globalEmployeeEmploymentUrl = globalHostname + "/app/Job/EmployeeEmployment/add";

var globalEmployeeEmploymentSaveOrUpdateUrl = globalHostname + "/app/Job/EmployeeEmployment/saveOrUpdate";

var globalEmployeeMembershipUrl = globalHostname + "/app/Job/EmployeeMembership/add";

var globalEmployeeMembershipSaveOrUpdateUrl = globalHostname + "/app/Job/EmployeeMembership/saveOrUpdate";

var globalEmployeeResidenceUrl = globalHostname + "/app/Job/EmployeeResidence/add";

var globalEmployeeFamilyUrl = globalHostname + "/app/Job/EmployeeFamily/add";

var globalEmployeeFamilySaveOrUpdateUrl = globalHostname + "/app/Job/EmployeeFamily/saveOrUpdate";

var globalEmployeeSpecialtyList = globalHostname + "/app/Job/Industry/list";

/* Event definition */

var appGlobalEventLoadDataComplete = "DataLoadComplete";

var globalBranchSummaryUrl = globalHostname + "/app/Core/Branch/getSummary?id=";

var globalBranchListByCompanyUrl = globalHostname + "/app/Core/Branch/listByCompany";
var globalBranchDeleteUrl = globalHostname + "/app/Core/Branch/delete";
var globalBranchSaveOrUpdateUrl = globalHostname + "/app/Core/Branch/saveOrUpdate";
var globalBranchGetUrl = globalHostname + "/app/Core/Branch/get"

var globalDivisionSummaryUrl = globalHostname + "/app/Core/Division/getSummary?id=";

var globalPersonnelControlPanel = "personnelControlPanel.jsp";

var globalUserValidationUrl = globalHostname + "/app/Users/Users/validateLogin";

var coreModeList = 0;
var coreModeInsert = 1;
var coreModeEdit = 2;

var coreApplicationTypeCompany = 0;
var coreApplicationTypeEmployee = 1;
var coreApplicationTypeCode = 2;
var coreApplicationTypeBranch = 3;