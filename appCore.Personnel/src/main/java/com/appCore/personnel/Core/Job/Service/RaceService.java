package com.appCore.personnel.Core.Job.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.Requests.CodeRequest;
import com.appCore.Requests.RequestStatus;
import com.appCore.personnel.Core.Job.Entity.Race;

@Service("raceService")
@Transactional
public class RaceService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<Race> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  Race");

		return  query.list();
	}

	public List<Race> getAllByCompany(Integer id) {

		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  Race WHERE CompanyRef= :id");
		query.setParameter("id", id);
		return  query.list();

	}
	
	public Race get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Race race = (Race) session.get(Race.class, id);

		return race;
	}
	

	public void add(Race race) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(race);
	}


	public void saveOrUpdate(Race race) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(race);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Race race = (Race) session.get(Race.class, id);

		session.delete(race);
	}

	public void edit(Race race) 
	{
		Session session = sessionFactory.getCurrentSession();
		Race target = (Race) session.get(Race.class, race.getNid());

		target.setNid(race.getNid());
		target.setName(race.getName());
		target.setDescription(race.getDescription());
		target.setStartEffectiveDate(race.getStartEffectiveDate());
		target.setEndEffectiveDate(race.getEndEffectiveDate());
		target.setDisabled(race.getDisabled());
		target.setLastUpdate(race.getLastUpdate());

		session.save(target);
	}

	
}