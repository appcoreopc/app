package com.appCore.personnel.Core.Configuration.Service;


import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.Core.Configuration.Entity.CompanySettings;
import com.appCore.personnel.Core.Job.Entity.Country;
import com.appCore.personnel.Core.Job.Entity.Currency;

@Service("CompanySettingsService")
@Transactional
public class CompanySettingsService {
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;

	public List<CompanySettings> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  CompanySettings");

		return  query.list();
	}

	public CompanySettings get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		CompanySettings currency = (CompanySettings) session.get(CompanySettings.class, id);
		return currency;
	}

}
