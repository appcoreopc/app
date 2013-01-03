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
	
		System.out.println("string builder");
		StringBuilder sb = new StringBuilder();
		sb.append("FROM Race WHERE Name = :codeName AND CompanyRef= :companyId");
		
		System.out.println(sb.toString());
		
		Query query = session.createQuery(sb.toString());
		
		query.setParameter("codeName", codeRequest.getCodeName());
		query.setParameter("companyId", codeRequest.getCompanyId());
		
		System.out.println("create query / set parameter ");
		
		if (query.list().size() == 0) 
		{
				return RequestStatusHelper.CodeCheckStatusOk("Code Ok", 0);
		}
		else 
		{
			return RequestStatusHelper.CodeCheckStatusDuplicate("Code already exist.", -1);
		}
		
	}

}
