package com.appCore.payroll.config.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.payroll.config.Entity.PayrollTableValue;

@Service("payrollTableValueService")
@Transactional
public class PayrollTableValueService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;

	public List<PayrollTableValue> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  PayrollTableValue");

		return query.list();
	}

	public List<PayrollTableValue> getAllByCompany(Integer id) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  PayrollTableValue WHERE CompanyId = :id");
		query.setParameter("id", id);
		return query.list();
	}


	public PayrollTableValue get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		PayrollTableValue payrollTableValue = (PayrollTableValue) session.get(PayrollTableValue.class, id);

		return payrollTableValue;
	}

	public void add(PayrollTableValue payrollTableValue) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(payrollTableValue);
	}


	public void saveOrUpdate(PayrollTableValue payrollTableValue) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(payrollTableValue);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		PayrollTableValue payrollTableValue = (PayrollTableValue) session.get(PayrollTableValue.class, id);

		session.delete(payrollTableValue);
	}
	
}