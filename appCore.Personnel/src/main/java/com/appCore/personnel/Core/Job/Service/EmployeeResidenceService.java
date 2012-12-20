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
import com.appCore.personnel.Core.Job.Entity.EmployeeResidence;

@Service("employeeResidenceService")
@Transactional
public class EmployeeResidenceService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<EmployeeResidence> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  EmployeeResidence");

		return  query.list();
	}

	public EmployeeResidence get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		EmployeeResidence employeeResidence = (EmployeeResidence) session.get(EmployeeResidence.class, id);
		return employeeResidence;
	}

	public List<EmployeeResidence> getByEmployee(Integer id) 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  EmployeeResidence where EmployeeRefId = :id");
		query.setParameter("id", id);
		return  query.list();
	}
	
	public void add(EmployeeResidence employeeResidence) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(employeeResidence);
	}


	public void saveOrUpdate(EmployeeResidence employeeResidence) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(employeeResidence);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		EmployeeResidence employeeResidence = (EmployeeResidence) session.get(EmployeeResidence.class, id);

		session.delete(employeeResidence);
	}

	public void edit(EmployeeResidence employeeResidence) 
	{
		Session session = sessionFactory.getCurrentSession();
		EmployeeResidence target = (EmployeeResidence) session.get(EmployeeResidence.class, employeeResidence.getNid());

		target.setNid(employeeResidence.getNid());
		target.setLevel(employeeResidence.getLevel());
		target.setPermanentAddress1(employeeResidence.getPermanentAddress1());
		target.setPermanentAddress2(employeeResidence.getPermanentAddress2());
		target.setPermanentAddress3(employeeResidence.getPermanentAddress3());
		target.setCity(employeeResidence.getCity());
		target.setCountry(employeeResidence.getCountry());
		target.setPostCode(employeeResidence.getPostCode());
		target.setTelNo(employeeResidence.getTelNo());
		target.setEmergencyContact1(employeeResidence.getEmergencyContact1());
		target.setEmergencyContact2(employeeResidence.getEmergencyContact2());
		target.setContact1(employeeResidence.getContact1());
		target.setContact2(employeeResidence.getContact2());
		target.setEmployeeRefId(employeeResidence.getEmployeeRefId());
		target.setLastUpdate(employeeResidence.getLastUpdate());

		session.save(target);
	}
}