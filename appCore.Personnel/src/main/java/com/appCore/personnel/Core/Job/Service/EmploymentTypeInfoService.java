package com.appCore.personnel.Core.Job.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.Core.Job.Entity.EmploymentTypeInfo;

@Service("employmentTypeInfoService")
@Transactional
public class EmploymentTypeInfoService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<EmploymentTypeInfo> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  EmploymentTypeInfo");

		return  query.list();
	}

	public List<EmploymentTypeInfo> getAllByRefEntity(Integer id) 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  EmploymentTypeInfo where RefEntity = :refEntity");
		query.setParameter("refEntity", id);
		return  query.list();
	}
	
	public EmploymentTypeInfo get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		EmploymentTypeInfo employmentTypeInfo = (EmploymentTypeInfo) session.get(EmploymentTypeInfo.class, id);

		return employmentTypeInfo;
	}

	public void add(EmploymentTypeInfo employmentTypeInfo) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(employmentTypeInfo);
	}


	public int saveOrUpdate(EmploymentTypeInfo employmentTypeInfo) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(employmentTypeInfo);
		return employmentTypeInfo.getNid();
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		EmploymentTypeInfo employmentTypeInfo = (EmploymentTypeInfo) session.get(EmploymentTypeInfo.class, id);

		session.delete(employmentTypeInfo);
	}

	public void edit(EmploymentTypeInfo employmentTypeInfo) 
	{
		Session session = sessionFactory.getCurrentSession();
		EmploymentTypeInfo target = (EmploymentTypeInfo) session.get(EmploymentTypeInfo.class, employmentTypeInfo.getNid());

		target.setNid(employmentTypeInfo.getNid());
		target.setType(employmentTypeInfo.getType());
		target.setValue(employmentTypeInfo.getValue());
		target.setDescription(employmentTypeInfo.getDescription());
		target.setCategory(employmentTypeInfo.getCategory());
		target.setRefEntity(employmentTypeInfo.getRefEntity());
		target.setLastUpdate(employmentTypeInfo.getLastUpdate());

		session.save(target);
	}
}