package com.appCore.personnel.Core.Job.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.Core.Job.Entity.Specialty;

@Service("specialtyService")
@Transactional
public class SpecialtyService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<Specialty> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  Specialty");

		return  query.list();
	}

	public Specialty get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Specialty specialty = (Specialty) session.get(Specialty.class, id);

		return specialty;
	}

	public void add(Specialty specialty) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(specialty);
	}


	public void saveOrUpdate(Specialty specialty) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(specialty);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Specialty specialty = (Specialty) session.get(Specialty.class, id);

		session.delete(specialty);
	}

	public void edit(Specialty specialty) 
	{
		Session session = sessionFactory.getCurrentSession();
		Specialty target = (Specialty) session.get(Specialty.class, specialty.getNid());

		target.setNid(specialty.getNid());
		target.setName(specialty.getName());
		target.setDescription(specialty.getDescription());
		target.setStartEffectiveDate(specialty.getStartEffectiveDate());
		target.setEndEffectiveDate(specialty.getEndEffectiveDate());
		target.setDisabled(specialty.getDisabled());
		target.setLastUpdate(specialty.getLastUpdate());

		session.save(target);
	}
}