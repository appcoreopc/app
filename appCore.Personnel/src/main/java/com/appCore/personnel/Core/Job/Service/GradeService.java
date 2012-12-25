package com.appCore.personnel.Core.Job.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.Core.Job.Entity.Grade;

@Service("gradeService")
@Transactional
public class GradeService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<Grade> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  Grade");

		return  query.list();
	}

	public List<Grade> getAllByCompany(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  Grade WHERE companyRef= :id");
		query.setParameter("id", id);
		return  query.list();
	}
	
	public Grade get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Grade grade = (Grade) session.get(Grade.class, id);

		return grade;
	}

	public void add(Grade grade) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(grade);
	}


	public void saveOrUpdate(Grade grade) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(grade);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Grade grade = (Grade) session.get(Grade.class, id);

		session.delete(grade);
	}

	public void edit(Grade grade) 
	{
		Session session = sessionFactory.getCurrentSession();
		Grade target = (Grade) session.get(Grade.class, grade.getNid());

		target.setNid(grade.getNid());
		target.setCode(grade.getCode());
		target.setDescription(grade.getDescription());
		target.setCategory(grade.getCategory());
		target.setProbationMonth(grade.getProbationMonth());
		target.setGradeInfo(grade.getGradeInfo());
		target.setDisabled(grade.getDisabled());
		target.setLastUpdate(grade.getLastUpdate());

		session.save(target);
	}

	
}