package com.appCore.personnel.Core.Job.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.Core.Job.Entity.EmployeeExperience;

@Service("experienceService")
@Transactional
public class ExperienceService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<EmployeeExperience> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  Experience");

		return  query.list();
	}

	public EmployeeExperience get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		EmployeeExperience experience = (EmployeeExperience) session.get(EmployeeExperience.class, id);

		return experience;
	}

	public void add(EmployeeExperience experience) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(experience);
	}


	public void saveOrUpdate(EmployeeExperience experience) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(experience);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		EmployeeExperience experience = (EmployeeExperience) session.get(EmployeeExperience.class, id);

		session.delete(experience);
	}

	public void edit(EmployeeExperience experience) 
	{
		Session session = sessionFactory.getCurrentSession();
		EmployeeExperience target = (EmployeeExperience) session.get(EmployeeExperience.class, experience.getNid());

		target.setNid(experience.getNid());
		target.setExpertise(experience.getExpertise());
		target.setYearOfExpertise(experience.getYearOfExpertise());
		target.setExpertiseDescription(experience.getExpertiseDescription());
		target.setEmployeeRefId(experience.getEmployeeRefId());
		target.setLastUpdate(experience.getLastUpdate());

		session.save(target);
	}
}