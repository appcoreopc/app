package com.appCore.personnel.Core.Helpers;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.Requests.CodeRequest;
import com.appCore.Requests.RequestStatus;

@Service("codeCheckerService")
@Transactional
public class CodeCheckerHelper {

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	public RequestStatus checkExist(CodeRequest codeRequest)
	{
		
		Session session = sessionFactory.getCurrentSession();
		Query query = getQueryByCodeType(session, codeRequest);
		
		if (query.list().size() == 0) 
		{
			return RequestStatusHelper.CodeCheckStatusOk("Code Ok", 0);
		}
		else 
		{
			return RequestStatusHelper.CodeCheckStatusDuplicate("Code already exist.", -1);
		}
	}
	
	
	/*
	 * 1 - Industry
	 * 2 - Gender
	 * 3 - Race
	 * 4 - Salutation 
	 * 5 - Religion
	 * 6 - Nationality 
	 * 7 - MaritalStatus 
	 * 8 - Level 
	 * 9 - FieldOfExpertise
	 * 10 - FamilyRelationType
	 * 11 - EmployeeGroup
	 * 12 - HolidayGroup
	 * 13 - Company
	 * 14 - Branch
	 * 15 - Division 
	 * 16 - Department 
	 * 17 - Section 
	 * 18 - Unit 
	 * 19 - Users
	 * 20 - EmploymentType
	 * 21 - Grade
	 * 22 - Holiday 
	 * 
	 */
	 
	private static Query getQueryByCodeType(Session session, CodeRequest codeRequest)
	{
		switch (codeRequest.getCodeType())
		{
			case 1: 
				String industryStringQuery =  "FROM Industry WHERE Name = :codeName AND CompanyRef = :companyId";
				Query industryQuery = session.createQuery(industryStringQuery);
				industryQuery.setParameter("codeName", codeRequest.getCodeName());
				industryQuery.setParameter("companyId", codeRequest.getCompanyId());
				return industryQuery;
			case 2: 
				String genderStringQuery = "FROM Gender WHERE Name = :codeName AND CompanyRef = :companyId";
				Query genderQuery = session.createQuery(genderStringQuery);
				genderQuery.setParameter("codeName", codeRequest.getCodeName());
				genderQuery.setParameter("companyId", codeRequest.getCompanyId());
				return genderQuery;
			case 3: 
				String raceStringQuery = "FROM Race WHERE Name = :codeName AND CompanyRef = :companyId";
				Query raceQuery = session.createQuery(raceStringQuery);
				raceQuery.setParameter("codeName", codeRequest.getCodeName());
				raceQuery.setParameter("companyId", codeRequest.getCompanyId());
				return raceQuery;
			case 4: 
				String salutationStringQuery = "FROM Salutation WHERE Name = :codeName AND CompanyRef = :companyId";
				Query salutationQuery = session.createQuery(salutationStringQuery);
				salutationQuery.setParameter("codeName", codeRequest.getCodeName());
				salutationQuery.setParameter("companyId", codeRequest.getCompanyId());
				return salutationQuery;
			case 5: 
				String religionStringQuery = "FROM Religion WHERE Name = :codeName AND CompanyRef = :companyId";
				Query religionQuery = session.createQuery(religionStringQuery);
				religionQuery.setParameter("codeName", codeRequest.getCodeName());
				religionQuery.setParameter("companyId", codeRequest.getCompanyId());
				return religionQuery;
			case 6:
				String nationalityStringQuery = "FROM Nationality WHERE Name = :codeName AND CompanyRef = :companyId";
				Query nationalityQuery = session.createQuery(nationalityStringQuery);
				nationalityQuery.setParameter("codeName", codeRequest.getCodeName());
				nationalityQuery.setParameter("companyId", codeRequest.getCompanyId());
				return nationalityQuery;
			case 7: 
				String maritalStatusStringQuery =  "FROM MaritalStatus WHERE Name = :codeName AND CompanyRef = :companyId";
				Query maritalStatusSQuery = session.createQuery(maritalStatusStringQuery);
				maritalStatusSQuery.setParameter("codeName", codeRequest.getCodeName());
				maritalStatusSQuery.setParameter("companyId", codeRequest.getCompanyId());
				return maritalStatusSQuery;
			case 8: 
				String levelStringQuery = "FROM Level WHERE Name = :codeName AND CompanyRef = :companyId";
				Query levelQuery = session.createQuery(levelStringQuery);
				levelQuery.setParameter("codeName", codeRequest.getCodeName());
				levelQuery.setParameter("companyId", codeRequest.getCompanyId());
				return levelQuery;
			case 9: 
				String fieldOfExpertiseStringQuery = "FROM FieldOfExpertise WHERE Name = :codeName AND CompanyRef = :companyId";
				Query fieldOfExpertiseQuery = session.createQuery(fieldOfExpertiseStringQuery);
				fieldOfExpertiseQuery.setParameter("codeName", codeRequest.getCodeName());
				fieldOfExpertiseQuery.setParameter("companyId", codeRequest.getCompanyId());
				return fieldOfExpertiseQuery;
			case 10: 
				String familyRelationTypeStringQuery =  "FROM FamilyRelationType WHERE Name = :codeName AND CompanyRef = :companyId";
				Query familyRelationTypeQuery = session.createQuery(familyRelationTypeStringQuery);
				familyRelationTypeQuery.setParameter("codeName", codeRequest.getCodeName());
				familyRelationTypeQuery.setParameter("companyId", codeRequest.getCompanyId());
				return familyRelationTypeQuery;
			case 11: 
				String employeeGroupStringQuery = "FROM EmployeeGroup WHERE Name = :codeName AND CompanyRef = :companyId";
				Query employeeGroupQuery = session.createQuery(employeeGroupStringQuery);
				employeeGroupQuery.setParameter("codeName", codeRequest.getCodeName());
				employeeGroupQuery.setParameter("companyId", codeRequest.getCompanyId());
				return employeeGroupQuery;
			case 12: 
				String holidayGroupStringQuery =  "FROM HolidayGroup WHERE Name = :codeName AND CompanyRef = :companyId";
				Query holidayGroupQuery = session.createQuery(holidayGroupStringQuery);
				holidayGroupQuery.setParameter("codeName", codeRequest.getCodeName());
				holidayGroupQuery.setParameter("companyId", codeRequest.getCompanyId());
				return holidayGroupQuery;
			case 13: 
				String companyStringQuery = "FROM Company WHERE CompanyCode = :codeName";
				Query companyQuery = session.createQuery(companyStringQuery);
				companyQuery.setParameter("codeName", codeRequest.getCodeName());
				companyQuery.setParameter("companyId", codeRequest.getCompanyId());
				return companyQuery;
			case 14: 
				String branchStringQuery = "FROM Branch WHERE BranchCode = :codeName AND CompanyId = :companyId";
				Query branchQuery = session.createQuery(branchStringQuery);
				branchQuery.setParameter("codeName", codeRequest.getCodeName());
				branchQuery.setParameter("companyId", codeRequest.getCompanyId());
				return branchQuery;
			case 15: 
				String divisionStringQuery = "FROM Division WHERE DivisionCode = :codeName AND CompanyId = :companyId";
				Query divisionQuery = session.createQuery(divisionStringQuery);
				divisionQuery.setParameter("codeName", codeRequest.getCodeName());
				divisionQuery.setParameter("companyId", codeRequest.getCompanyId());
				return divisionQuery;
			case 16: 
				String departmentStringQuery = "FROM Department WHERE DepartmentCode = :codeName AND CompanyId = :companyId";
				Query departmentQuery = session.createQuery(departmentStringQuery);
				departmentQuery.setParameter("codeName", codeRequest.getCodeName());
				departmentQuery.setParameter("companyId", codeRequest.getCompanyId());
				return departmentQuery;
			case 17: 
				String sectionStringQuery = "FROM Section WHERE SectionCode = :codeName AND CompanyId = :companyId";
				Query sectionQuery = session.createQuery(sectionStringQuery);
				sectionQuery.setParameter("codeName", codeRequest.getCodeName());
				sectionQuery.setParameter("companyId", codeRequest.getCompanyId());
				return sectionQuery;
			case 18: 
				String unitStringQuery = "FROM Unit WHERE UnitCode = :codeName AND CompanyId = :companyId";
				Query unitQuery = session.createQuery(unitStringQuery);
				unitQuery.setParameter("codeName", codeRequest.getCodeName());
				unitQuery.setParameter("companyId", codeRequest.getCompanyId());
				return unitQuery;
			case 19:
				String userStringQuery = "FROM Users where userName = :codeName";
				Query userQuery = session.createQuery(userStringQuery);
				userQuery.setParameter("codeName", codeRequest.getCodeName());
				return userQuery;
			case 20:
				String employmentTypeStringQuery = "FROM EmploymentType WHERE Code = :codeName AND CompanyRef = :companyId";
				Query employmentTypeQuery = session.createQuery(employmentTypeStringQuery);
				employmentTypeQuery.setParameter("codeName", codeRequest.getCodeName());
				employmentTypeQuery.setParameter("companyId", codeRequest.getCompanyId());
				return employmentTypeQuery;
			case 21:
				String gradeStringQuery = "FROM Grade WHERE Code = :codeName AND CompanyRef = :companyId";
				Query gradeQuery = session.createQuery(gradeStringQuery);
				gradeQuery.setParameter("codeName", codeRequest.getCodeName());
				gradeQuery.setParameter("companyId", codeRequest.getCompanyId());
				return gradeQuery;
			case 22:
				String holidayStringQuery = "FROM Holiday WHERE Name = :codeName AND CompanyRef = :companyId";
				Query holidayQuery = session.createQuery(holidayStringQuery);
				holidayQuery.setParameter("codeName", codeRequest.getCodeName());
				holidayQuery.setParameter("companyId", codeRequest.getCompanyId());
				return holidayQuery;
				
		}
		return null; 
	}
}
