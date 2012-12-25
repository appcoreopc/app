package com.appCore.personnel.Core.Job.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.Core.Job.Entity.MaritalStatus;

@Service("maritalStatusService")
@Transactional
public class MaritalStatusService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<MaritalStatus> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  MaritalStatus");

		return  query.list();
	}

	public List<MaritalStatus> getAllByCompany(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  MaritalStatus WHERE companyRef = :id");
		query.setParameter("id", id);
		return  query.list();
	}

	
	public MaritalStatus get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		MaritalStatus maritalStatus = (MaritalStatus) session.get(MaritalStatus.class, id);

		return maritalStatus;
	}

	public void add(MaritalStatus maritalStatus) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(maritalStatus);
	}


	public void saveOrUpdate(MaritalStatus maritalStatus) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(maritalStatus);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		MaritalStatus maritalStatus = (MaritalStatus) session.get(MaritalStatus.class, id);

		session.delete(maritalStatus);
	}

	public void edit(MaritalStatus maritalStatus) 
	{
		Session session = sessionFactory.getCurrentSession();
		MaritalStatus target = (MaritalStatus) session.get(MaritalStatus.class, maritalStatus.getNid());

		target.setNid(maritalStatus.getNid());
		target.setName(maritalStatus.getName());
		target.setDescription(maritalStatus.getDescription());
		target.setStartEffectiveDate(maritalStatus.getStartEffectiveDate());
		target.setEndEffectiveDate(maritalStatus.getEndEffectiveDate());
		target.setDisabled(maritalStatus.getDisabled());
		target.setLastUpdate(maritalStatus.getLastUpdate());

		session.save(target);
	}

	
}