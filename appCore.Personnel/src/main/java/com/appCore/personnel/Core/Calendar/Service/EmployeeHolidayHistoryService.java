package com.appCore.personnel.Core.Calendar.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.Core.Calendar.Entity.EmployeeHolidayHistory;

@Service("employeeHolidayHistoryService")
@Transactional
public class EmployeeHolidayHistoryService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;

	public List<EmployeeHolidayHistory> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  EmployeeHolidayHistory");

		return query.list();
	}

	public List<EmployeeHolidayHistory> getAllByCompany(Integer id) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  EmployeeHolidayHistory WHERE CompanyId = :id");
		query.setParameter("id", id);
		return query.list();
	}


	public EmployeeHolidayHistory get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		EmployeeHolidayHistory employeeHolidayHistory = (EmployeeHolidayHistory) session.get(EmployeeHolidayHistory.class, id);

		return employeeHolidayHistory;
	}

	public void add(EmployeeHolidayHistory employeeHolidayHistory) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(employeeHolidayHistory);
	}


	public void saveOrUpdate(EmployeeHolidayHistory employeeHolidayHistory) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(employeeHolidayHistory);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		EmployeeHolidayHistory employeeHolidayHistory = (EmployeeHolidayHistory) session.get(EmployeeHolidayHistory.class, id);

		session.delete(employeeHolidayHistory);
	}
	
}