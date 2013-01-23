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
import com.appCore.personnel.Core.Job.Entity.JobSetupSkill;

@Service("jobSetupSkillService")
@Transactional
public class JobSetupSkillService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<JobSetupSkill> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  JobSetupSkill");
		return  query.list();
	}
	
	public List<JobSetupSkill> listByJobSetup(Integer id) 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  JobSetupSkill WHERE JobSetupRef = :id");
		query.setParameter("id", id);
		return  query.list();
	}
	

	public JobSetupSkill get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		JobSetupSkill jobSetupSkill = (JobSetupSkill) session.get(JobSetupSkill.class, id);

		return jobSetupSkill;
	}

	public void add(JobSetupSkill jobSetupSkill) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(jobSetupSkill);
	}


	public void saveOrUpdate(JobSetupSkill jobSetupSkill) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(jobSetupSkill);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		JobSetupSkill jobSetupSkill = (JobSetupSkill) session.get(JobSetupSkill.class, id);

		session.delete(jobSetupSkill);
	}

	public void edit(JobSetupSkill jobSetupSkill) 
	{
		Session session = sessionFactory.getCurrentSession();
		JobSetupSkill target = (JobSetupSkill) session.get(JobSetupSkill.class, jobSetupSkill.getNid());

		target.setNid(jobSetupSkill.getNid());
		target.setJobSetupRef(jobSetupSkill.getJobSetupRef());
		target.setSkill(jobSetupSkill.getSkill());
		target.setLevel(jobSetupSkill.getLevel());
		target.setCategory(jobSetupSkill.getCategory());
		target.setCategoryDescription(jobSetupSkill.getCategoryDescription());
		target.setDescription(jobSetupSkill.getDescription());
		target.setStartEffectiveDate(jobSetupSkill.getStartEffectiveDate());
		target.setEndEffectiveDate(jobSetupSkill.getEndEffectiveDate());
		target.setDisabled(jobSetupSkill.getDisabled());
		target.setLastUpdate(jobSetupSkill.getLastUpdate());

		session.save(target);
	}
}