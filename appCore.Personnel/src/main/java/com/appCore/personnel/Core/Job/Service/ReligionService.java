package com.appCore.personnel.Core.Job.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.Core.Job.Entity.Religion;

@Service("religionService")
@Transactional
public class ReligionService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<Religion> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  Religion");

		return  query.list();
	}

	public Religion get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Religion religion = (Religion) session.get(Religion.class, id);

		return religion;
	}

	public void add(Religion religion) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(religion);
	}


	public void saveOrUpdate(Religion religion) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(religion);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Religion religion = (Religion) session.get(Religion.class, id);

		session.delete(religion);
	}

	public void edit(Religion religion) 
	{
		Session session = sessionFactory.getCurrentSession();
		Religion target = (Religion) session.get(Religion.class, religion.getNid());

		target.setNid(religion.getNid());
		target.setName(religion.getName());
		target.setDescription(religion.getDescription());
		target.setStartEffectiveDate(religion.getStartEffectiveDate());
		target.setEndEffectiveDate(religion.getEndEffectiveDate());
		target.setDisabled(religion.getDisabled());
		target.setLastUpdate(religion.getLastUpdate());

		session.save(target);
	}
}