package com.appCore.personnel.Core.Calendar.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.Core.Calendar.Entity.Holiday;
import com.appCore.personnel.Core.Entity.Branch;

@Service("holidayService")
@Transactional
public class HolidayService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<Holiday> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  Holiday");

		return  query.list();
	}
	
	public List<Holiday> getAllByCompany(Integer id) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  Holiday WHERE CompanyRef = :id");
		query.setParameter("id", id);
		return query.list();
	}
	
	public Holiday get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Holiday holiday = (Holiday) session.get(Holiday.class, id);

		return holiday;
	}

	public void add(Holiday holiday) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(holiday);
	}


	public void saveOrUpdate(Holiday holiday) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(holiday);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Holiday holiday = (Holiday) session.get(Holiday.class, id);

		session.delete(holiday);
	}

	public void edit(Holiday holiday) 
	{
		Session session = sessionFactory.getCurrentSession();
		Holiday target = (Holiday) session.get(Holiday.class, holiday.getNid());

		target.setNid(holiday.getNid());
		target.setName(holiday.getName());
		target.setHolidayDate(holiday.getHolidayDate());
		target.setRecurring(holiday.getRecurring());
		target.setCompanyRef(holiday.getCompanyRef());
		target.setDescription(holiday.getDescription());
		target.setType(holiday.getType());
		target.setLastUpdate(holiday.getLastUpdate());
		target.setCompanyRef(holiday.getCompanyRef());
		
		session.save(target);
	}
}