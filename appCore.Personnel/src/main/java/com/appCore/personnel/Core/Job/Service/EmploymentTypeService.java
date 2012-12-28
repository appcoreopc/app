package com.appCore.personnel.Core.Job.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.Core.Job.Entity.EmployeeExpertise;
import com.appCore.personnel.Core.Job.Entity.EmploymentType;
import com.appCore.personnel.Core.Job.Entity.EmploymentTypeInfo;

@Service("employmentTypeService")
@Transactional
public class EmploymentTypeService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<EmploymentType> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  EmploymentType");
		return  query.list();
	}
		
	public List<EmploymentType> getAllByCompany(Integer id)  
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  EmploymentType WHERE CompanyRef = :id");
		query.setParameter("id", id);
		return  query.list();
	}

	public EmploymentType get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		EmploymentType employmentType = (EmploymentType) session.get(EmploymentType.class, id);

		Query query = session.createQuery("FROM  EmploymentTypeInfo WHERE RefEntity = :id");
		query.setParameter("id", id);
		List<EmploymentTypeInfo> info = query.list();
		employmentType.setEmploymentTypeInfo(info);
		
		return employmentType;
	}
	
	public void add(EmploymentType employmentType) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(employmentType);
	}


	public void saveOrUpdate(EmploymentType employmentType) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(employmentType);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		EmploymentType employmentType = (EmploymentType) session.get(EmploymentType.class, id);

		session.delete(employmentType);
	}

	public void edit(EmploymentType employmentType) 
	{
		Session session = sessionFactory.getCurrentSession();
		EmploymentType target = (EmploymentType) session.get(EmploymentType.class, employmentType.getNid());

		target.setNid(employmentType.getNid());
		target.setCode(employmentType.getCode());
		target.setDescription(employmentType.getDescription());
		target.setCategory(employmentType.getCategory());
		target.setEmploymentTypeInfo(employmentType.getEmploymentTypeInfo());
		target.setDisabled(employmentType.getDisabled());
		target.setLastUpdate(employmentType.getLastUpdate());

		session.save(target);
	}
}