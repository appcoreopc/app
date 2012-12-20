package com.appCore.personnel.Core.Job.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.Core.Job.Entity.EmployeeFamily;
import com.appCore.personnel.Core.Job.Entity.EmployeeResidence;

@Service("employeeFamilyService")
@Transactional
public class EmployeeFamilyService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<EmployeeFamily> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  EmployeeFamily");

		return  query.list();
	}

	public EmployeeFamily get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		EmployeeFamily employeeFamily = (EmployeeFamily) session.get(EmployeeFamily.class, id);

		return employeeFamily;
	}

	public List<EmployeeFamily> getByEmployee(Integer id) 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  EmployeeFamily where EmployeeRefId = :id");
		query.setParameter("id", id);
		return  query.list();
	}
	
	
	
	public void add(EmployeeFamily employeeFamily) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(employeeFamily);
	}


	public void saveOrUpdate(EmployeeFamily employeeFamily) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(employeeFamily);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		EmployeeFamily employeeFamily = (EmployeeFamily) session.get(EmployeeFamily.class, id);

		session.delete(employeeFamily);
	}

	public void edit(EmployeeFamily employeeFamily) 
	{
		Session session = sessionFactory.getCurrentSession();
		EmployeeFamily target = (EmployeeFamily) session.get(EmployeeFamily.class, employeeFamily.getNid());

		target.setNid(employeeFamily.getNid());
		target.setMemberName(employeeFamily.getMemberName());
		target.setMemberType(employeeFamily.getMemberType());
		target.setBirthDate(employeeFamily.getBirthDate());
		target.setAge(employeeFamily.getAge());
		target.setSalutation(employeeFamily.getSalutation());
		target.setGender(employeeFamily.getGender());
		target.setMaritalStatus(employeeFamily.getMaritalStatus());
		target.setIdentificationNo(employeeFamily.getIdentificationNo());
		target.setWorking(employeeFamily.getWorking());
		target.setStudying(employeeFamily.getStudying());
		target.setHandicap(employeeFamily.getHandicap());
		target.setNominatedSpouse(employeeFamily.getNominatedSpouse());
		target.setAttachments(employeeFamily.getAttachments());
		target.setRemarks(employeeFamily.getRemarks());
		target.setEmployeeRefId(employeeFamily.getEmployeeRefId());
		target.setLastUpdate(employeeFamily.getLastUpdate());

		session.save(target);
	}
}