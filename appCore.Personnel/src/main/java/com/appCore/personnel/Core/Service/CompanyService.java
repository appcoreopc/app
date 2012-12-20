package com.appCore.personnel.Core.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.Core.Entity.Company;

@Service("companyService")
@Transactional
public class CompanyService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;

	public Integer getSummary(Integer id) 
	{	
		Session session = sessionFactory.getCurrentSession();
		return ((Integer)session.createCriteria("select count(*) from Company").uniqueResult()).intValue();
	}


	public List<Company> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  Company");

		return  query.list();
	}

	public Company get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Company company = (Company) session.get(Company.class, id);

		return company;
	}

	public void add(Company company) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(company);
	}


	public void saveOrUpdate(Company company) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(company);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Company company = (Company) session.get(Company.class, id);

		session.delete(company);
	}

	public void edit(Company company) 
	{
		Session session = sessionFactory.getCurrentSession();
		Company target = (Company) session.get(Company.class, company.getNid());

		target.setNid(company.getNid());
		target.setCompanyCode(company.getCompanyCode());
		target.setRegistration(company.getRegistration());
		target.setCompanyName(company.getCompanyName());
		target.setAddress(company.getAddress());
		target.setCity(company.getCity());
		target.setCountry(company.getCountry());
		target.setPostcode(company.getPostcode());
		target.setTel(company.getTel());
		target.setDefaultCurrency(company.getDefaultCurrency());
		target.setParentCompany(company.getParentCompany());
		
		target.setLastUpdate(company.getLastUpdate());

		session.save(target);
	}
}