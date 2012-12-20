package com.appCore.personnel.Core.Job.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.Core.Job.Entity.EmployeeMembership;
import com.appCore.personnel.Core.Job.Entity.EmployeeResidence;

@Service("employeeMembershipService")
@Transactional
public class EmployeeMembershipService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<EmployeeMembership> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  EmployeeMembership");

		return  query.list();
	}

	public EmployeeMembership get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		EmployeeMembership employeeMembership = (EmployeeMembership) session.get(EmployeeMembership.class, id);

		return employeeMembership;
	}
	
	public List<EmployeeMembership> getByEmployee(Integer id) 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  EmployeeMembership where EmployeeRefId = :id");
		query.setParameter("id", id);
		return  query.list();
	}
	

	public void add(EmployeeMembership employeeMembership) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(employeeMembership);
	}


	public void saveOrUpdate(EmployeeMembership employeeMembership) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(employeeMembership);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		EmployeeMembership employeeMembership = (EmployeeMembership) session.get(EmployeeMembership.class, id);

		session.delete(employeeMembership);
	}

	public void edit(EmployeeMembership employeeMembership) 
	{
		Session session = sessionFactory.getCurrentSession();
		EmployeeMembership target = (EmployeeMembership) session.get(EmployeeMembership.class, employeeMembership.getNid());

		target.setNid(employeeMembership.getNid());
		target.setAssociation(employeeMembership.getAssociation());
		target.setMemberType(employeeMembership.getMemberType());
		target.setContactDetails(employeeMembership.getContactDetails());
		target.setStartDate(employeeMembership.getStartDate());
		target.setEndDate(employeeMembership.getEndDate());
		target.setMembershipPeriod(employeeMembership.getMembershipPeriod());
		target.setEnrollmentFees(employeeMembership.getEnrollmentFees());
		target.setMembershipFees(employeeMembership.getMembershipFees());
		target.setAttachments(employeeMembership.getAttachments());
		target.setRemarks(employeeMembership.getRemarks());
		target.setEmployeeRefId(employeeMembership.getEmployeeRefId());
		target.setLastUpdate(employeeMembership.getLastUpdate());

		session.save(target);
	}
}