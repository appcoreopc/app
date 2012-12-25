package com.appCore.personnel.Core.Job.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.Core.Job.Entity.Country;

@Service("countryService")
@Transactional
public class CountryService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<Country> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  Country");

		return  query.list();
	}

	public List<Country> getAllByCompany(Integer id) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  Country WHERE CompanyRef= :id");
		query.setParameter("id", id);
		return  query.list();
	}
	
	
	public Country get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Country country = (Country) session.get(Country.class, id);

		return country;
	}

	public void add(Country country) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(country);
	}


	public void saveOrUpdate(Country country) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(country);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Country country = (Country) session.get(Country.class, id);

		session.delete(country);
	}

	public void edit(Country country) 
	{
		Session session = sessionFactory.getCurrentSession();
		Country target = (Country) session.get(Country.class, country.getNid());

		target.setNid(country.getNid());
		target.setName(country.getName());
		target.setShortcutName(country.getShortcutName());
		target.setDescription(country.getDescription());
		target.setStartEffectiveDate(country.getStartEffectiveDate());
		target.setEndEffectiveDate(country.getEndEffectiveDate());
		target.setDisabled(country.getDisabled());
		target.setLastUpdate(country.getLastUpdate());

		session.save(target);
	}

	
}