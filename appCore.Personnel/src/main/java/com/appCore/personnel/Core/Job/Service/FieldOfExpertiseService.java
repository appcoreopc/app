package com.appCore.personnel.Core.Job.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.Core.Job.Entity.FieldOfExpertise;

@Service("fieldOfExpertiseService")
@Transactional
public class FieldOfExpertiseService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<FieldOfExpertise> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  FieldOfExpertise");

		return  query.list();
	}

	public FieldOfExpertise get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		FieldOfExpertise fieldOfExpertise = (FieldOfExpertise) session.get(FieldOfExpertise.class, id);

		return fieldOfExpertise;
	}

	public void add(FieldOfExpertise fieldOfExpertise) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(fieldOfExpertise);
	}


	public void saveOrUpdate(FieldOfExpertise fieldOfExpertise) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(fieldOfExpertise);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		FieldOfExpertise fieldOfExpertise = (FieldOfExpertise) session.get(FieldOfExpertise.class, id);

		session.delete(fieldOfExpertise);
	}

	public void edit(FieldOfExpertise fieldOfExpertise) 
	{
		Session session = sessionFactory.getCurrentSession();
		FieldOfExpertise target = (FieldOfExpertise) session.get(FieldOfExpertise.class, fieldOfExpertise.getNid());

		target.setNid(fieldOfExpertise.getNid());
		target.setName(fieldOfExpertise.getName());
		target.setDescription(fieldOfExpertise.getDescription());
		target.setStartEffectiveDate(fieldOfExpertise.getStartEffectiveDate());
		target.setEndEffectiveDate(fieldOfExpertise.getEndEffectiveDate());
		target.setDisabled(fieldOfExpertise.getDisabled());
		target.setLastUpdate(fieldOfExpertise.getLastUpdate());

		session.save(target);
	}
}