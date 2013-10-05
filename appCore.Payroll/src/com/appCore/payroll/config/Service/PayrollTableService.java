package com.appCore.payroll.config.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.payroll.config.Entity.PayrollTable;

@Service("payrollTableService")
@Transactional
public class PayrollTableService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;

	public List<PayrollTable> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  PayrollTable");

		return query.list();
	}

	public List<PayrollTable> getAllByCompany(Integer id) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  PayrollTable WHERE CompanyId = :id");
		query.setParameter("id", id);
		return query.list();
	}


	public PayrollTable get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		PayrollTable payrollTable = (PayrollTable) session.get(PayrollTable.class, id);

		return payrollTable;
	}

	public void add(PayrollTable payrollTable) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(payrollTable);
	}


	public void saveOrUpdate(PayrollTable payrollTable) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(payrollTable);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		PayrollTable payrollTable = (PayrollTable) session.get(PayrollTable.class, id);

		session.delete(payrollTable);
	}
	
}