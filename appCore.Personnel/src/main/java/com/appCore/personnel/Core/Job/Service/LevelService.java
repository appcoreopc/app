package com.appCore.personnel.Core.Job.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.Core.Job.Entity.Level;

@Service("levelService")
@Transactional
public class LevelService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<Level> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  Level");
		return  query.list();
	}

	public List<Level> getAllByCompany(Integer id) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  Level WHERE companyRef = :id");
		query.setParameter("id", id);
		return  query.list();
	}
	
	
	public Level get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Level level = (Level) session.get(Level.class, id);

		return level;
	}

	public void add(Level level) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(level);
	}


	public void saveOrUpdate(Level level) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(level);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Level level = (Level) session.get(Level.class, id);

		session.delete(level);
	}

	public void edit(Level level) 
	{
		Session session = sessionFactory.getCurrentSession();
		Level target = (Level) session.get(Level.class, level.getNid());

		target.setNid(level.getNid());
		target.setName(level.getName());
		target.setDescription(level.getDescription());
		target.setStartEffectiveDate(level.getStartEffectiveDate());
		target.setEndEffectiveDate(level.getEndEffectiveDate());
		target.setDisabled(level.getDisabled());
		target.setLastUpdate(level.getLastUpdate());

		session.save(target);
	}

	
}