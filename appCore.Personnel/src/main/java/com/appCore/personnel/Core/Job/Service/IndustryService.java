package com.appCore.personnel.Core.Job.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.Core.Job.Entity.Industry;

@Service("industryService")
@Transactional
public class IndustryService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<Industry> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  Industry");

		return  query.list();
	}
	
	public List<Industry> getAllByCompany(Integer id) 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  Industry WHERE companyRef= :id");
		query.setParameter("id", id);
		return  query.list();
	}

	public Industry get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Industry industry = (Industry) session.get(Industry.class, id);

		return industry;
	}
	
	
	public void add(Industry industry) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(industry);
	}


	public void saveOrUpdate(Industry industry) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(industry);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Industry industry = (Industry) session.get(Industry.class, id);

		session.delete(industry);
	}

	public void edit(Industry industry) 
	{
		Session session = sessionFactory.getCurrentSession();
		Industry target = (Industry) session.get(Industry.class, industry.getNid());

		target.setNid(industry.getNid());
		target.setName(industry.getName());
		target.setDescription(industry.getDescription());
		target.setStartEffectiveDate(industry.getStartEffectiveDate());
		target.setEndEffectiveDate(industry.getEndEffectiveDate());
		target.setDisabled(industry.getDisabled());
		target.setLastUpdate(industry.getLastUpdate());

		session.save(target);
	}
}