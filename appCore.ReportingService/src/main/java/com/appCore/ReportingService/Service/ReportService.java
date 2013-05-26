package com.appCore.reportingService.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.reportingService.Entity.Report;

@Service("reportService")
@Transactional
public class ReportService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;

	public List<Report> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  Report");

		return query.list();
	}

	public List<Report> getAllByCompany(Integer id) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  Report WHERE CompanyRef= :id");
		query.setParameter("id", id);
		return query.list();
	}


	public Report get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Report report = (Report) session.get(Report.class, id);

		return report;
	}

	public void add(Report report) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(report);
	}


	public void saveOrUpdate(Report report) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(report);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Report report = (Report) session.get(Report.class, id);

		session.delete(report);
	}	
}