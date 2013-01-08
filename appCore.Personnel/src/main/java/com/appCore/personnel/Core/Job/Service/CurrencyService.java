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
import com.appCore.personnel.Core.Job.Entity.Currency;

@Service("currencyService")
@Transactional
public class CurrencyService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<Currency> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  Currency");

		return  query.list();
	}

	public List<Currency> getAllByCompany(Integer id) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  Currency WHERE CompanyRef= :id");
		query.setParameter("id", id);
		return  query.list();
	}
	
	public Currency get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Currency currency = (Currency) session.get(Currency.class, id);

		return currency;
	}

	
	
	public void add(Currency currency) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(currency);
	}


	public void saveOrUpdate(Currency currency) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(currency);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Currency currency = (Currency) session.get(Currency.class, id);

		session.delete(currency);
	}

	public void edit(Currency currency) 
	{
		Session session = sessionFactory.getCurrentSession();
		Currency target = (Currency) session.get(Currency.class, currency.getNid());

		target.setNid(currency.getNid());
		target.setName(currency.getName());
		target.setDescription(currency.getDescription());
		target.setStartEffectiveDate(currency.getStartEffectiveDate());
		target.setEndEffectiveDate(currency.getEndEffectiveDate());
		target.setDisabled(currency.getDisabled());
		target.setLastUpdate(currency.getLastUpdate());

		session.save(target);
	}
}