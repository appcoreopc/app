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

@Service("employeeContactService")
@Transactional
public class EmployeeContactService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<EmployeeContact> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  EmployeeContact");

		return  query.list();
	}

	
	public List<EmployeeContact> getByEmployee(Integer id) 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  EmployeeContact where EmployeeRefId = :id");
		query.setParameter("id", id);
		return  query.list();
	}
	
	public EmployeeContact get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		EmployeeContact employeeContact = (EmployeeContact) session.get(EmployeeContact.class, id);

		return employeeContact;
	}

	public void add(EmployeeContact employeeContact) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(employeeContact);
	}


	public void saveOrUpdate(EmployeeContact employeeContact) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(employeeContact);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		EmployeeContact employeeContact = (EmployeeContact) session.get(EmployeeContact.class, id);

		session.delete(employeeContact);
	}

	public void edit(EmployeeContact employeeContact) 
	{
		Session session = sessionFactory.getCurrentSession();
		EmployeeContact target = (EmployeeContact) session.get(EmployeeContact.class, employeeContact.getNid());

		target.setNid(employeeContact.getNid());
		target.setLevel(employeeContact.getLevel());
		target.setEmail(employeeContact.getEmail());
		target.setMobileNo(employeeContact.getMobileNo());
		target.setAlternateEmail(employeeContact.getAlternateEmail());
		target.setExtNo(employeeContact.getExtNo());
		target.setCorrespondenceAddress1(employeeContact.getCorrespondenceAddress1());
		target.setCorrespondenceAddress2(employeeContact.getCorrespondenceAddress2());
		target.setCorrespondenceAddress3(employeeContact.getCorrespondenceAddress3());
		target.setCity(employeeContact.getCity());
		target.setCountry(employeeContact.getCountry());
		target.setPostCode(employeeContact.getPostCode());
		target.setTelNo(employeeContact.getTelNo());
		target.setEmployeeRefId(employeeContact.getEmployeeRefId());
		target.setLastUpdate(employeeContact.getLastUpdate());

		session.save(target);
	}
}