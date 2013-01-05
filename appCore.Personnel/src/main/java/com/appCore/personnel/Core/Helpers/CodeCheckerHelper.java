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
		
		System.out.println("creating instance getcurrentsession");
		Session session = sessionFactory.getCurrentSession();

		String generatedQuery = getQueryByCodeType(codeRequest.getCodeType());
		Query query = session.createQuery(generatedQuery);
		query.setParameter("codeName", codeRequest.getCodeName());
		query.setParameter("companyId", codeRequest.getCompanyId());
		
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
	 */
	 
	private static String getQueryByCodeType(int codeType)
	{
		switch (codeType)
		{
		
			case 1: 
				return "FROM Industry WHERE Name = :codeName AND CompanyRef = :companyId"; 
			case 2: 
				return "FROM Gender WHERE Name = :codeName AND CompanyRef = :companyId";
			case 3: 
				return "FROM Race WHERE Name = :codeName AND CompanyRef = :companyId"; 
			case 4: 
				return "FROM Salutation WHERE Name = :codeName AND CompanyRef = :companyId";
			case 5: 
				return "FROM Religion WHERE Name = :codeName AND CompanyRef = :companyId";
			case 6:
				return "FROM Nationality WHERE Name = :codeName AND CompanyRef = :companyId";
			case 7: 
				return "FROM MaritalStatus WHERE Name = :codeName AND CompanyRef = :companyId";
			case 8: 
				return "FROM Level WHERE Name = :codeName AND CompanyRef = :companyId";
			case 9: 
				return "FROM FieldOfExpertise WHERE Name = :codeName AND CompanyRef = :companyId";
			case 10: 
				return "FROM FamilyRelationType WHERE Name = :codeName AND CompanyRef = :companyId";
			case 11: 
				return "FROM EmployeeGroup WHERE Name = :codeName AND CompanyRef = :companyId";
			case 12: 
				return "FROM HolidayGroup WHERE Name = :codeName AND CompanyRef = :companyId";
			case 13: 
				return "FROM Company WHERE CompanyCode = :codeName";
			case 14: 
				return "FROM Branch WHERE BranchCode = :codeName AND CompanyId = :companyId";
			case 15: 
				return "FROM Division WHERE DivisionCode = :codeName AND CompanyId = :companyId";
			case 16: 
				return "FROM Department WHERE DepartmentCode = :codeName AND CompanyId = :companyId";
			case 17: 
				return "FROM Section WHERE SectionCode = :codeName AND CompanyId = :companyId";
			case 18: 
				return "FROM Unit WHERE UnitCode = :codeName AND CompanyId = :companyId";
		
		}
		return ""; 
	}
}
