package com.appCore.payroll.config.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.payroll.config.Entity.WorkPackage;

@Service("workPackageService")
@Transactional
public class WorkPackageService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;

	public List<WorkPackage> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  WorkPackage");

		return query.list();
	}

	public List<WorkPackage> getAllByCompany(Integer id) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  WorkPackage WHERE CompanyId = :id");
		query.setParameter("id", id);
		return query.list();
	}


	public WorkPackage get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		WorkPackage workPackage = (WorkPackage) session.get(WorkPackage.class, id);

		return workPackage;
	}

	public void add(WorkPackage workPackage) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(workPackage);
	}


	public void saveOrUpdate(WorkPackage workPackage) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(workPackage);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		WorkPackage workPackage = (WorkPackage) session.get(WorkPackage.class, id);

		session.delete(workPackage);
	}
	
}