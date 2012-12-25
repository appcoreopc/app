package com.appCore.personnel.Core.Job.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.Core.Job.Entity.Nationality;

@Service("nationalityService")
@Transactional
public class NationalityService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<Nationality> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  Nationality");

		return  query.list();
	}

	public List<Nationality> getAllByCompany(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  Nationality WHERE companyRef = :id");
		query.setParameter("id", id);
		return  query.list();	}
	
	public Nationality get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Nationality nationality = (Nationality) session.get(Nationality.class, id);

		return nationality;
	}

	public void add(Nationality nationality) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(nationality);
	}


	public void saveOrUpdate(Nationality nationality) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(nationality);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Nationality nationality = (Nationality) session.get(Nationality.class, id);

		session.delete(nationality);
	}

	public void edit(Nationality nationality) 
	{
		Session session = sessionFactory.getCurrentSession();
		Nationality target = (Nationality) session.get(Nationality.class, nationality.getNid());

		target.setNid(nationality.getNid());
		target.setName(nationality.getName());
		target.setDescription(nationality.getDescription());
		target.setStartEffectiveDate(nationality.getStartEffectiveDate());
		target.setEndEffectiveDate(nationality.getEndEffectiveDate());
		target.setDisabled(nationality.getDisabled());
		target.setLastUpdate(nationality.getLastUpdate());

		session.save(target);
	}

	
}