package com.appCore.personnel.Core.Calendar.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.Core.Calendar.Entity.HolidayEntitlementType;

@Service("holidayEntitlementTypeService")
@Transactional
public class HolidayEntitlementTypeService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;

	public List<HolidayEntitlementType> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  HolidayEntitlementType");

		return query.list();
	}

	public List<HolidayEntitlementType> getAllByCompany(Integer id) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  HolidayEntitlementType WHERE CompanyId = :id");
		query.setParameter("id", id);
		return query.list();
	}


	public HolidayEntitlementType get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		HolidayEntitlementType holidayEntitlementType = (HolidayEntitlementType) session.get(HolidayEntitlementType.class, id);

		return holidayEntitlementType;
	}

	public void add(HolidayEntitlementType holidayEntitlementType) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(holidayEntitlementType);
	}


	public void saveOrUpdate(HolidayEntitlementType holidayEntitlementType) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(holidayEntitlementType);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		HolidayEntitlementType holidayEntitlementType = (HolidayEntitlementType) session.get(HolidayEntitlementType.class, id);

		session.delete(holidayEntitlementType);
	}
	
}