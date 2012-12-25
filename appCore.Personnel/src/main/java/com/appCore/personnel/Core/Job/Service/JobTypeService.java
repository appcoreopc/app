package com.appCore.personnel.Core.Job.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.Core.Job.Entity.JobType;

@Service("jobTypeService")
@Transactional
public class JobTypeService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<JobType> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  JobType");

		return  query.list();
	}

	
	public List<JobType> getAllByCompany(Integer id) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  JobType WHERE companyRef = :id");
		query.setParameter("id", id);
		return  query.list();

	}
	
	public JobType get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		JobType jobType = (JobType) session.get(JobType.class, id);

		return jobType;
	}

	public void add(JobType jobType) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(jobType);
	}


	public void saveOrUpdate(JobType jobType) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(jobType);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		JobType jobType = (JobType) session.get(JobType.class, id);

		session.delete(jobType);
	}

	public void edit(JobType jobType) 
	{
		Session session = sessionFactory.getCurrentSession();
		JobType target = (JobType) session.get(JobType.class, jobType.getNid());

		target.setNid(jobType.getNid());
		target.setCode(jobType.getCode());
		target.setJobTitle(jobType.getJobTitle());
		target.setJobCategory(jobType.getJobCategory());
		target.setDescription(jobType.getDescription());
		//target.setQualification(jobType.getQualification());
		//target.setExperience(jobType.getExperience());
		//target.setSkill(jobType.getSkill());
		target.setDisabled(jobType.getDisabled());
		target.setLastUpdate(jobType.getLastUpdate());

		session.save(target);
	}

	
}