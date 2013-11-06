package com.appCore.personnel.Core.Calendar.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.Core.Calendar.Entity.HolidayLeaveEarningScheme;

@Service("holidayLeaveEarningSchemeService")
@Transactional
public class HolidayLeaveEarningSchemeService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;

	public List<HolidayLeaveEarningScheme> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  HolidayLeaveEarningScheme");

		return query.list();
	}

	public List<HolidayLeaveEarningScheme> getAllByCompany(Integer id) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  HolidayLeaveEarningScheme WHERE CompanyId = :id");
		query.setParameter("id", id);
		return query.list();
	}


	public HolidayLeaveEarningScheme get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		HolidayLeaveEarningScheme holidayLeaveEarningScheme = (HolidayLeaveEarningScheme) session.get(HolidayLeaveEarningScheme.class, id);

		return holidayLeaveEarningScheme;
	}

	public void add(HolidayLeaveEarningScheme holidayLeaveEarningScheme) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(holidayLeaveEarningScheme);
	}


	public void saveOrUpdate(HolidayLeaveEarningScheme holidayLeaveEarningScheme) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(holidayLeaveEarningScheme);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		HolidayLeaveEarningScheme holidayLeaveEarningScheme = (HolidayLeaveEarningScheme) session.get(HolidayLeaveEarningScheme.class, id);

		session.delete(holidayLeaveEarningScheme);
	}
	
}