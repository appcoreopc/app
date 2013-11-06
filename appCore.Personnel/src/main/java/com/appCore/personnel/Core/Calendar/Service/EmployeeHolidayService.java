package com.appCore.personnel.Core.Calendar.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.Core.Calendar.Entity.EmployeeHoliday;

@Service("employeeHolidayService")
@Transactional
public class EmployeeHolidayService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;

	public List<EmployeeHoliday> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  EmployeeHoliday");

		return query.list();
	}

	public List<EmployeeHoliday> getAllByCompany(Integer id) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  EmployeeHoliday WHERE CompanyId = :id");
		query.setParameter("id", id);
		return query.list();
	}


	public EmployeeHoliday get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		EmployeeHoliday employeeHoliday = (EmployeeHoliday) session.get(EmployeeHoliday.class, id);

		return employeeHoliday;
	}

	public void add(EmployeeHoliday employeeHoliday) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(employeeHoliday);
	}


	public void saveOrUpdate(EmployeeHoliday employeeHoliday) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(employeeHoliday);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		EmployeeHoliday employeeHoliday = (EmployeeHoliday) session.get(EmployeeHoliday.class, id);

		session.delete(employeeHoliday);
	}
	
}