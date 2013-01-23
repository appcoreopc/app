package com.appCore.personnel.Core.Job.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.Core.Job.Entity.JobSetupQualification;

@Service("jobSetupQualificationService")
@Transactional
public class JobSetupQualificationService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<JobSetupQualification> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  JobSetupQualification");

		return  query.list();
	}

	public List<JobSetupQualification> listByJobSetup(Integer id) 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  JobSetupQualification WHERE JobSetupRef = :id");
		query.setParameter("id", id);
		return  query.list();
	}
	
	
	public JobSetupQualification get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		JobSetupQualification jobSetupQualification = (JobSetupQualification) session.get(JobSetupQualification.class, id);

		return jobSetupQualification;
	}

	public void add(JobSetupQualification jobSetupQualification) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(jobSetupQualification);
	}


	public void saveOrUpdate(JobSetupQualification jobSetupQualification) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(jobSetupQualification);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		JobSetupQualification jobSetupQualification = (JobSetupQualification) session.get(JobSetupQualification.class, id);

		session.delete(jobSetupQualification);
	}

	public void edit(JobSetupQualification jobSetupQualification) 
	{
		Session session = sessionFactory.getCurrentSession();
		JobSetupQualification target = (JobSetupQualification) session.get(JobSetupQualification.class, jobSetupQualification.getNid());

		target.setNid(jobSetupQualification.getNid());
		target.setJobSetupRef(jobSetupQualification.getJobSetupRef());
		target.setLevel(jobSetupQualification.getLevel());
		target.setDescription(jobSetupQualification.getDescription());
		target.setFieldOfStudy(jobSetupQualification.getFieldOfStudy());
		target.setStartEffectiveDate(jobSetupQualification.getStartEffectiveDate());
		target.setEndEffectiveDate(jobSetupQualification.getEndEffectiveDate());
		target.setDisabled(jobSetupQualification.getDisabled());
		target.setLastUpdate(jobSetupQualification.getLastUpdate());

		session.save(target);
	}
}