package com.appCore.personnel.Core.Job.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.Core.Job.Entity.EmployeeContact;
import com.appCore.personnel.Core.Job.Entity.EmployeeEmployment;

@Service("employeeEmploymentService")
@Transactional
public class EmployeeEmploymentService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<EmployeeEmployment> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  EmployeeEmployment");

		return  query.list();
	}

	public EmployeeEmployment get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		EmployeeEmployment employeeEmployment = (EmployeeEmployment) session.get(EmployeeEmployment.class, id);
		return employeeEmployment;
	}
	
	public List<EmployeeEmployment> getByEmployee(Integer id) 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  EmployeeEmployment where EmployeeRefId = :id");
		query.setParameter("id", id);
		return  query.list();
	}

	public void add(EmployeeEmployment employeeEmployment) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(employeeEmployment);
	}


	public void saveOrUpdate(EmployeeEmployment employeeEmployment) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(employeeEmployment);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		EmployeeEmployment employeeEmployment = (EmployeeEmployment) session.get(EmployeeEmployment.class, id);

		session.delete(employeeEmployment);
	}

	public void edit(EmployeeEmployment employeeEmployment) 
	{
		Session session = sessionFactory.getCurrentSession();
		EmployeeEmployment target = (EmployeeEmployment) session.get(EmployeeEmployment.class, employeeEmployment.getNid());

		target.setNid(employeeEmployment.getNid());
		target.setEmployerName(employeeEmployment.getEmployerName());
		target.setJob(employeeEmployment.getJob());
		target.setIndustry(employeeEmployment.getIndustry());
		target.setStartDate(employeeEmployment.getStartDate());
		target.setEndDate(employeeEmployment.getEndDate());
		target.setDuration(employeeEmployment.getDuration());
		target.setLastDrawnSalary(employeeEmployment.getLastDrawnSalary());
		target.setResignationReason(employeeEmployment.getResignationReason());
		target.setRemarks(employeeEmployment.getRemarks());
		target.setEmployeeRefId(employeeEmployment.getEmployeeRefId());
		target.setLastUpdate(employeeEmployment.getLastUpdate());

		session.save(target);
	}
}