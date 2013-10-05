package com.appCore.payroll.config.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.payroll.config.Entity.PayrollScript;

@Service("payrollScriptService")
@Transactional
public class PayrollScriptService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;

	public List<PayrollScript> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  PayrollScript");
		return query.list();
	}

	public List<PayrollScript> getAllByCompany(Integer id) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  PayrollScript WHERE CompanyId = :id");
		query.setParameter("id", id);
		return query.list();
	}


	public PayrollScript get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		PayrollScript payrollScript = (PayrollScript) session.get(PayrollScript.class, id);

		return payrollScript;
	}

	public void add(PayrollScript payrollScript) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(payrollScript);
	}


	public void saveOrUpdate(PayrollScript payrollScript) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(payrollScript);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		PayrollScript payrollScript = (PayrollScript) session.get(PayrollScript.class, id);

		session.delete(payrollScript);
	}
	
}