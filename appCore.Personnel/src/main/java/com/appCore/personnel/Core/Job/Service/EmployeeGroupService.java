package com.appCore.personnel.Core.Job.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.Core.Job.Entity.EmployeeGroup;

@Service("employeeGroupService")
@Transactional
public class EmployeeGroupService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<EmployeeGroup> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  EmployeeGroup");

		return  query.list();
	}

	public List<EmployeeGroup> getAllByCompany(Integer id) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  EmployeeGroup WHERE companyRef = :id");
		query.setParameter("id", id);
		return  query.list();

	}

	public EmployeeGroup get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		EmployeeGroup employeeGroup = (EmployeeGroup) session.get(EmployeeGroup.class, id);

		return employeeGroup;
	}

	public void add(EmployeeGroup employeeGroup) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(employeeGroup);
	}


	public void saveOrUpdate(EmployeeGroup employeeGroup) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(employeeGroup);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		EmployeeGroup employeeGroup = (EmployeeGroup) session.get(EmployeeGroup.class, id);

		session.delete(employeeGroup);
	}

	public void edit(EmployeeGroup employeeGroup) 
	{
		Session session = sessionFactory.getCurrentSession();
		EmployeeGroup target = (EmployeeGroup) session.get(EmployeeGroup.class, employeeGroup.getNid());

		target.setNid(employeeGroup.getNid());
		target.setName(employeeGroup.getName());
		target.setDescription(employeeGroup.getDescription());
		target.setStartEffectiveDate(employeeGroup.getStartEffectiveDate());
		target.setEndEffectiveDate(employeeGroup.getEndEffectiveDate());
		target.setDisabled(employeeGroup.getDisabled());
		target.setLastUpdate(employeeGroup.getLastUpdate());

		session.save(target);
	}
}