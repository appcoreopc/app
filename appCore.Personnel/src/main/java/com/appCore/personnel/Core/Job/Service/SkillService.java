package com.appCore.personnel.Core.Job.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.Core.Job.Entity.EmployeeSkill;

@Service("skillService")
@Transactional
public class SkillService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<EmployeeSkill> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  Skill");

		return  query.list();
	}

	public EmployeeSkill get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		EmployeeSkill skill = (EmployeeSkill) session.get(EmployeeSkill.class, id);

		return skill;
	}

	public void add(EmployeeSkill skill) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(skill);
	}


	public void saveOrUpdate(EmployeeSkill skill) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(skill);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		EmployeeSkill skill = (EmployeeSkill) session.get(EmployeeSkill.class, id);

		session.delete(skill);
	}

	public void edit(EmployeeSkill skill) 
	{
		Session session = sessionFactory.getCurrentSession();
		EmployeeSkill target = (EmployeeSkill) session.get(EmployeeSkill.class, skill.getNid());

		target.setNid(skill.getNid());
		target.setSkill(skill.getSkill());
		target.setSkillLevel(skill.getSkillLevel());
		target.setCategory(skill.getCategory());
		target.setRefEntity(skill.getRefEntity());
		target.setDescription(skill.getDescription());
		target.setCategoryDescription(skill.getCategoryDescription());
		target.setLastUpdate(skill.getLastUpdate());

		session.save(target);
	}
}