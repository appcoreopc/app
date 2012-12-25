package com.appCore.personnel.Core.Job.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.Core.Job.Entity.Salutation;

@Service("salutationService")
@Transactional
public class SalutationService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<Salutation> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  Salutation");
		return  query.list();
	}

	
	public List<Salutation> getAllByCompany(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  Salutation WHERE CompanyRef = :id");
		query.setParameter("id", id);
		return  query.list();
	}
	
	
	public Salutation get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Salutation salutation = (Salutation) session.get(Salutation.class, id);

		return salutation;
	}

	public void add(Salutation salutation) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(salutation);
	}


	public void saveOrUpdate(Salutation salutation) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(salutation);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Salutation salutation = (Salutation) session.get(Salutation.class, id);

		session.delete(salutation);
	}

	public void edit(Salutation salutation) 
	{
		Session session = sessionFactory.getCurrentSession();
		Salutation target = (Salutation) session.get(Salutation.class, salutation.getNid());

		target.setNid(salutation.getNid());
		target.setName(salutation.getName());
		target.setDescription(salutation.getDescription());
		target.setStartEffectiveDate(salutation.getStartEffectiveDate());
		target.setEndEffectiveDate(salutation.getEndEffectiveDate());
		target.setDisabled(salutation.getDisabled());
		target.setLastUpdate(salutation.getLastUpdate());

		session.save(target);
	}

	
}