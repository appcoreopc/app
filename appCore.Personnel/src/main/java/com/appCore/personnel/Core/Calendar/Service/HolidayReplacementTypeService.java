package com.appCore.personnel.Core.Calendar.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.Core.Calendar.Entity.HolidayReplacementType;

@Service("holidayReplacementTypeService")
@Transactional
public class HolidayReplacementTypeService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;

	public List<HolidayReplacementType> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  HolidayReplacementType");

		return query.list();
	}

	public List<HolidayReplacementType> getAllByCompany(Integer id) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  HolidayReplacementType WHERE CompanyId = :id");
		query.setParameter("id", id);
		return query.list();
	}


	public HolidayReplacementType get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		HolidayReplacementType holidayReplacementType = (HolidayReplacementType) session.get(HolidayReplacementType.class, id);

		return holidayReplacementType;
	}

	public void add(HolidayReplacementType holidayReplacementType) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(holidayReplacementType);
	}


	public void saveOrUpdate(HolidayReplacementType holidayReplacementType) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(holidayReplacementType);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		HolidayReplacementType holidayReplacementType = (HolidayReplacementType) session.get(HolidayReplacementType.class, id);

		session.delete(holidayReplacementType);
	}
	
}