package com.appCore.personnel.Core.Job.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.Core.Job.Entity.EmployeeQualification;

@Service("qualificationService")
@Transactional
public class QualificationService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<EmployeeQualification> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  Qualification");

		return  query.list();
	}

	public List<EmployeeQualification> getByEmployeeRefId(Integer id) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  Qualification WHERE EmployeeRefId = :id");
		query.setParameter("id", id);
		return  query.list();

	}
	
	public EmployeeQualification get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		EmployeeQualification qualification = (EmployeeQualification) session.get(EmployeeQualification.class, id);

		return qualification;
	}

	public void add(EmployeeQualification qualification) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(qualification);
	}


	public void saveOrUpdate(EmployeeQualification qualification) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(qualification);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		EmployeeQualification qualification = (EmployeeQualification) session.get(EmployeeQualification.class, id);

		session.delete(qualification);
	}

	public void edit(EmployeeQualification qualification) 
	{
		Session session = sessionFactory.getCurrentSession();
		EmployeeQualification target = (EmployeeQualification) session.get(EmployeeQualification.class, qualification.getNid());

		target.setNid(qualification.getNid());
		target.setLevel(qualification.getLevel());
		target.setFieldOfStudy(qualification.getFieldOfStudy());
		target.setLevelDescription(qualification.getLevelDescription());
		target.setFieldOfStudyDescription(qualification.getFieldOfStudyDescription());
		target.setEmployeeRefId(qualification.getEmployeeRefId());
		target.setLastUpdate(qualification.getLastUpdate());

		session.save(target);
	}

	
	
}