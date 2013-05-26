package com.appCore.reportingService.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.reportingService.Entity.ReportingServiceConfiguration;

@Service("reportingServiceConfigurationService")
@Transactional
public class ReportingServiceConfigurationService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;

	public List<ReportingServiceConfiguration> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  ReportingServiceConfiguration");

		return query.list();
	}

	public List<ReportingServiceConfiguration> getAllByCompany(Integer id) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  ReportingServiceConfiguration WHERE CompanyRef= :id");
		query.setParameter("id", id);
		return query.list();
	}


	public ReportingServiceConfiguration get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		ReportingServiceConfiguration reportingServiceConfiguration = (ReportingServiceConfiguration) session.get(ReportingServiceConfiguration.class, id);

		return reportingServiceConfiguration;
	}

	public void add(ReportingServiceConfiguration reportingServiceConfiguration) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(reportingServiceConfiguration);
	}


	public void saveOrUpdate(ReportingServiceConfiguration reportingServiceConfiguration) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(reportingServiceConfiguration);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		ReportingServiceConfiguration reportingServiceConfiguration = (ReportingServiceConfiguration) session.get(ReportingServiceConfiguration.class, id);

		session.delete(reportingServiceConfiguration);
	}
	
}