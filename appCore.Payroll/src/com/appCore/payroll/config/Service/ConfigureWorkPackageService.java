package com.appCore.payroll.config.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.payroll.config.Entity.ConfigureWorkPackage;

@Service("configureWorkPackageService")
@Transactional
public class ConfigureWorkPackageService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;

	public List<ConfigureWorkPackage> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  ConfigureWorkPackage");

		return query.list();
	}

	public List<ConfigureWorkPackage> getAllByCompany(Integer id) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  ConfigureWorkPackage WHERE CompanyId = :id");
		query.setParameter("id", id);
		return query.list();
	}


	public ConfigureWorkPackage get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		ConfigureWorkPackage configureWorkPackage = (ConfigureWorkPackage) session.get(ConfigureWorkPackage.class, id);

		return configureWorkPackage;
	}

	public void add(ConfigureWorkPackage configureWorkPackage) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(configureWorkPackage);
	}


	public void saveOrUpdate(ConfigureWorkPackage configureWorkPackage) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(configureWorkPackage);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		ConfigureWorkPackage configureWorkPackage = (ConfigureWorkPackage) session.get(ConfigureWorkPackage.class, id);

		session.delete(configureWorkPackage);
	}
	
}