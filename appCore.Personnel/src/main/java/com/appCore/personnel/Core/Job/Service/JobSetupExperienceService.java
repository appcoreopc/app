package com.appCore.personnel.Core.Job.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.Core.Job.Entity.JobSetupExperience;
import com.appCore.personnel.Core.Job.Entity.JobSetupQualification;

@Service("jobSetupExperienceService")
@Transactional
public class JobSetupExperienceService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<JobSetupExperience> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  JobSetupExperience");

		return  query.list();
	}

	public List<JobSetupExperience> listByJobSetup(Integer id) 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  JobSetupExperience WHERE JobSetupRef = :id");
		query.setParameter("id", id);
		return  query.list();
	}
	
	
	
	public JobSetupExperience get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		JobSetupExperience jobSetupExperience = (JobSetupExperience) session.get(JobSetupExperience.class, id);

		return jobSetupExperience;
	}

	public void add(JobSetupExperience jobSetupExperience) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(jobSetupExperience);
	}


	public void saveOrUpdate(JobSetupExperience jobSetupExperience) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(jobSetupExperience);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		JobSetupExperience jobSetupExperience = (JobSetupExperience) session.get(JobSetupExperience.class, id);

		session.delete(jobSetupExperience);
	}

	public void edit(JobSetupExperience jobSetupExperience) 
	{
		Session session = sessionFactory.getCurrentSession();
		JobSetupExperience target = (JobSetupExperience) session.get(JobSetupExperience.class, jobSetupExperience.getNid());

		target.setNid(jobSetupExperience.getNid());
		target.setJobSetupRef(jobSetupExperience.getJobSetupRef());
		target.setExpertise(jobSetupExperience.getExpertise());
		target.setExperienceYears(jobSetupExperience.getExperienceYears());
		target.setDescription(jobSetupExperience.getDescription());
		target.setStartEffectiveDate(jobSetupExperience.getStartEffectiveDate());
		target.setEndEffectiveDate(jobSetupExperience.getEndEffectiveDate());
		target.setDisabled(jobSetupExperience.getDisabled());
		target.setLastUpdate(jobSetupExperience.getLastUpdate());

		session.save(target);
	}
}