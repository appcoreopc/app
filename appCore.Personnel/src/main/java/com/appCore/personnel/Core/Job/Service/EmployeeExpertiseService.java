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
import com.appCore.personnel.Core.Job.Entity.EmployeeResidence;

@Service("employeeExpertiseService")
@Transactional
public class EmployeeExpertiseService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<EmployeeExpertise> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  EmployeeExpertise");

		return  query.list();
	}

	public EmployeeExpertise get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		EmployeeExpertise employeeExpertise = (EmployeeExpertise) session.get(EmployeeExpertise.class, id);

		return employeeExpertise;
	}
	
	public List<EmployeeExpertise> getByEmployee(Integer id) 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  EmployeeExpertise where EmployeeRefId = :id");
		query.setParameter("id", id);
		return  query.list();
	}
	

	public void add(EmployeeExpertise employeeExpertise) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(employeeExpertise);
	}


	public void saveOrUpdate(EmployeeExpertise employeeExpertise) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(employeeExpertise);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		EmployeeExpertise employeeExpertise = (EmployeeExpertise) session.get(EmployeeExpertise.class, id);

		session.delete(employeeExpertise);
	}

	public void edit(EmployeeExpertise employeeExpertise) 
	{
		Session session = sessionFactory.getCurrentSession();
		EmployeeExpertise target = (EmployeeExpertise) session.get(EmployeeExpertise.class, employeeExpertise.getNid());

		target.setNid(employeeExpertise.getNid());
		target.setIndustry(employeeExpertise.getIndustry());
		target.setSpecialty(employeeExpertise.getSpecialty());
		target.setStartDate(employeeExpertise.getStartDate());
		target.setEndDate(employeeExpertise.getEndDate());
		target.setPeriod(employeeExpertise.getPeriod());
		target.setRemarks(employeeExpertise.getRemarks());
		target.setEmployeeRefId(employeeExpertise.getEmployeeRefId());
		target.setLastUpdate(employeeExpertise.getLastUpdate());

		session.save(target);
	}
}