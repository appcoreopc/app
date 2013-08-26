package com.appCore.personnel.CoreSystem.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.CoreSystem.Entity.CoreModule;

@Service("coreModuleService")
@Transactional
public class CoreModuleService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;

	public List<CoreModule> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  CoreModule");

		return query.list();
	}

	public List<CoreModule> getAllByCompany(Integer id) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  CoreModule WHERE CompanyId= :id");
		query.setParameter("id", id);
		return query.list();
	}


	public CoreModule get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		CoreModule coreModule = (CoreModule) session.get(CoreModule.class, id);

		return coreModule;
	}

	public void add(CoreModule coreModule) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(coreModule);
	}


	public void saveOrUpdate(CoreModule coreModule) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(coreModule);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		CoreModule coreModule = (CoreModule) session.get(CoreModule.class, id);

		session.delete(coreModule);
	}
	
}