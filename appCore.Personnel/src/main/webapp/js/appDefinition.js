var globalHostname = "http://localhost:8080/appCore-personnel";
var globalMenuServiceUrl = "/app/User/Forms/listMenu";
var globalCompanyServiceUrl = "/app/Core/CompanyEntity/list";

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
var coreGradePage = "Branch";
var coreEmploymentTypePage = "Branch";
var coreHolidaySetupPage = "Branch";
var coreHolidayGroupPage = "HolidayGroup";
var coreCodeMaintenancePage = "Branch";
var coreUserPage = "Branch";

var coreJobQualification = "Branch";

var coreJobExperience = "Branch";

var coreJobType = "Branch";

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

var globalEmployeeListByCompanyUrl = globalHostname + "/app/Job/Employee/listByCompany";

var globalEmployeeGroupListByCompanyUrl = globalHostname + "/app/Job/EmployeeGroup/listByCompany";

var globalRoleList = globalHostname + "/app/User/Roles/list";

var globalEmployeeSaveOrUpdateUrl = globalHostname + "/app/Job/Employee/saveOrUpdate";

var globalEmployeeDeleteUrl = globalHostname + "/app/Job/Employee/delete";

var globalEmployeeListUrl = globalHostname + "/app/Job/Employee/list";

var globalEmployeeGetUrl = globalHostname + "/app/Job/Employee/get";

var globalEmployeeContactAddUrl = globalHostname + "/app/Job/EmployeeContact/add";

var globalEmployeeContactSaveOrUpdateUrl = globalHostname + "/app/Job/EmployeeContact/saveOrUpdate";

var globalEmployeeContactListUrl = globalHostname + "/app/Job/EmployeeContact/list";

var globalEmployeeContactGetUrl = globalHostname + "/app/Job/EmployeeContact/list";

var globalEmployeeContactGetByEmployeeUrl = globalHostname + "/app/Job/EmployeeContact/getByEmployee";

var globalEmployeeQualificationGetByEmployeeUrl = globalHostname + "/app/Job/EmployeeQualification/getByEmployee";

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

var globalEmployeeSpecialtyList = globalHostname + "/app/Job/Specialty/list";

var globalEmployeeSpecialtyListByCompany = globalHostname + "/app/Job/Specialty/listByCompany";

var globalEmployeeIndustryListByCompany = globalHostname + "/app/Job/Industry/listByCompany";

var globalEmployeeLevelList = globalHostname + "/app/Job/Level/list";

var globalEmployeeLevelListByCompany = globalHostname + "/app/Job/Level/listByCompany";

var globalEmployeeAssociationMemberTypeList = globalHostname + "/app/Job/AssociationMembershipType/list";

var globalEmployeeAssociationMemberTypeListByCompany = globalHostname + "/app/Job/AssociationMembershipType/listByCompany";

var globalEmployeeFamilyMemberTypelList = globalHostname + "/app/Job/FamilyRelationType/list";

var globalEmployeeFamilyMemberTypelListByCompany = globalHostname + "/app/Job/FamilyRelationType/listByCompany";

var globalEmployeeFieldExpertiseList = globalHostname + "/app/Job/FieldOfExpertise/list";

var globalEmployeeFieldExpertiseListByCompany = globalHostname + "/app/Job/FieldOfExpertise/listByCompany";

var globalEmployeeSalutationList = globalHostname + "/app/Job/Salutation/list";

var globalEmployeeSalutationListByCompany = globalHostname + "/app/Job/Salutation/listByCompany";

var globalCurrencyListByCompany = globalHostname + "/app/Job/Currency/listByCompany";

var globalCurrencyList = globalHostname + "/app/Job/Currency/list";

var globalEmployeeRaceList = globalHostname + "/app/Job/Race/list";

var globalCodeCheckExist = globalHostname + "/app/Core/CodeChecker/checkExist";

var globalEmployeeNationalityList = globalHostname + "/app/Job/Nationality/list";

var globalEmployeeReligionList = globalHostname + "/app/Job/Religion/list";

var globalCountryList = globalHostname + "/app/Job/Country/list";

var globalCountryListByCompany = globalHostname + "/app/Job/Country/listByCompany";

var globalEmployeeMaritalStatusList = globalHostname + "/app/Job/MaritalStatus/list";

var globalEmployeeMaritalStatusListByCompany = globalHostname + "/app/Job/MaritalStatus/listByCompany";

var globalEmployeeGenderExpertiseList = globalHostname + "/app/Job/Gender/list";

var globalEmployeeGenderExpertiseListByCompany = globalHostname + "/app/Job/Gender/listByCompany";

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

var globalUserList = globalHostname + "/app/Users/Users/listByCompany";

var globalUserGet = globalHostname + "/app/Users/Users/get";
var globalUserSaveOrUpdate = globalHostname + "/app/Users/Users/saveOrUpdate";

var globalBranchInfoDeleteUrl = globalHostname + "/app/Core/BranchInfo/delete";
var globalDivisionInfoDeleteUrl = globalHostname + "/app/Core/DivisionInfo/delete";
var globalDepartmentInfoDeleteUrl = globalHostname + "/app/Core/DepartmentInfo/delete";
var globalSectionInfoDeleteUrl = globalHostname + "/app/Core/SectionInfo/delete";
var globalUnitInfoDeleteUrl = globalHostname + "/app/Core/UnitInfo/delete";
var globalGradeInfoDeleteUrl = globalHostname + "/app/Core/Job/GradeInfo/delete";
var globalEmploymentTypeInfoDeleteUrl = globalHostname + "/app/Core/Job/EmploymentTypeInfo/delete";
var globalBranchDeleteUrl = globalHostname + "/app/Core/Branch/delete";
var globalBranchSaveOrUpdateUrl = globalHostname + "/app/Core/Branch/saveOrUpdate";
var globalDivisionSaveOrUpdateUrl = globalHostname + "/app/Core/Division/saveOrUpdate";
var globalDepartmentSaveOrUpdateUrl = globalHostname + "/app/Core/Department/saveOrUpdate";
var globalSectionSaveOrUpdateUrl = globalHostname + "/app/Core/Section/saveOrUpdate";


var globalEmployeeGroupConfigureUrl = globalHostname + "/app/Job/EmployeeGroup/configuredEmployeeGroup";
var globalConfigureUserRoleUrl = globalHostname + "/app/User/Roles/configuredRole";

var globalUnitSaveOrUpdateUrl = globalHostname + "/app/Core/Unit/saveOrUpdate";
var globalGradeSaveOrUpdateUrl = globalHostname + "/app/Core/Job/Grade/saveOrUpdate";
var globalEmploymentTypeSaveOrUpdateUrl = globalHostname + "/app/Core/Job/EmploymentType/saveOrUpdate";
var globalBranchInfoSaveOrUpdateUrl = globalHostname + "/app/Core/BranchInfo/saveOrUpdate";

var globalDivisionInfoSaveOrUpdateUrl = globalHostname + "/app/Core/DivisionInfo/saveOrUpdate";
var globalDepartmentInfoSaveOrUpdateUrl = globalHostname + "/app/Core/DepartmentInfo/saveOrUpdate";

var globalSectionInfoSaveOrUpdateUrl = globalHostname + "/app/Core/SectionInfo/saveOrUpdate";
var globalUnitInfoSaveOrUpdateUrl = globalHostname + "/app/Core/UnitInfo/saveOrUpdate";
var globalGradeInfoSaveOrUpdateUrl = globalHostname + "/app/Core/Job/GradeInfo/saveOrUpdate";
var globalEmploymentTypeInfoSaveOrUpdateUrl = globalHostname + "/app/Core/Job/EmploymentTypeInfo/saveOrUpdate";
var globalEmploymentTypeSaveOrUpdateUrl = globalHostname + "/app/Core/Job/EmploymentType/saveOrUpdate";

var globalBranchGetUrl = globalHostname + "/app/Core/Branch/get"

var globalDivisionGetUrl = globalHostname + "/app/Core/Division/get"

var globalDepartmentGetUrl = globalHostname + "/app/Core/Department/get"

var globalSectionGetUrl = globalHostname + "/app/Core/Section/get"

var globalUnitGetUrl = globalHostname + "/app/Core/Unit/get"

var globalGradeGetUrl = globalHostname + "/app/Core/Job/Grade/get"

var globalEmploymentTypeGetUrl = globalHostname + "/app/Core/Job/EmploymentType/get"

var globalDivisionSummaryUrl = globalHostname + "/app/Core/Division/getSummary?id=";

var globalDivisionListByCompanyUrl = globalHostname + "/app/Core/Division/listByCompany";

var globalSectionListByCompanyUrl = globalHostname + "/app/Core/Section/listByCompany";

var globalUnitListByCompanyUrl = globalHostname + "/app/Core/Unit/listByCompany";

var globalUserList = globalHostname + "/app/Users/Users/list";

var globalHolidaySetupListByCompanyUrl = globalHostname + "/app/Core/Calendar/Holiday/listByCompany";

var globalJobSetupListByCompanyUrl = globalHostname + "/app/Core/Job/JobType/listByCompany";

var globalGradeTypeListByCompanyUrl = globalHostname + "/app/Core/Job/Grade/listByCompany";
var globalEmploymentTypeListByCompanyUrl = globalHostname + "/app/Core/Job/EmploymentType/listByCompany";
var globalDepartmentListByCompanyUrl = globalHostname + "/app/Core/Department/listByCompany";

var globalDivisionDeleteUrl = globalHostname + "/app/Core/Division/delete";
var globalUnitDeleteUrl = globalHostname + "/app/Core/Unit/delete";

var globalDeleteUsersUrl = globalHostname + "/app/Users/Users/delete";

var globalHolidayDeleteUrl = globalHostname + "/app/Core/Calendar/Holiday/delete";

var globalJobSetupDeleteUrl = globalHostname + "/app/Core/Job/JobType/delete";
var globalEmploymentTypeDeleteUrl = globalHostname + "/app/Core/Job/EmploymentType/delete";
var globalGradeDeleteUrl = globalHostname + "/app/Core/Job/Grade/delete";
var globalSectionDeleteUrl = globalHostname + "/app/Core/Section/delete";
var globalDepartmentDeleteUrl = globalHostname + "/app/Core/Department/delete";

var globalPersonnelControlPanel = "personnelControlPanel.jsp";
var globalUserValidationUrl = globalHostname + "/app/Users/Users/validateLogin";

var globalAdminCentralPage = "userList.jsp";

var coreModeList = 0;
var coreModeInsert = 1;
var coreModeEdit = 2;


var coreApplicationTypeCompany = 0;
var coreApplicationTypeEmployee = 1;
var coreApplicationTypeCode = 2;
var coreApplicationTypeBranch = 3;
var coreApplicationTypeGradeType = 4;
var coreApplicationTypeUnit = 5;
var coreApplicationTypeSection = 6;
var coreApplicationTypeDepartment = 7;
var coreApplicationTypeEmploymentType = 8;
var coreApplicationMaintenanceCode = 9;
var coreApplicationTypeDivision = 10;
var coreApplicationTypeHolidayConfigure = 11;

var coreAdministrationUserManager = 12;
var coreAdministrationUserRights = 13;

