package com.appCore.personnel.Core.Calendar.Service;

import java.sql.Connection;
import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.Core.Calendar.Entity.Holiday;
import com.appCore.personnel.Core.Calendar.Entity.HolidayGroup;
// import com.appCore.personnel.User.Entity.HolidayGroup_Holiday;

@Service("holidayGroupService")
@Transactional
public class HolidayGroupService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<HolidayGroup> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  HolidayGroup");
		return  query.list();
	}
	
	public List<HolidayGroup> getAllByCompany(Integer id) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  HolidayGroup WHERE CompanyRef = :id");
		query.setParameter("id", id);
		return query.list();
	}
	
	
	public boolean saveconfiguredHolidayGroup(int holidayGroupId, int holidayId, boolean isGrantAccess)
	{
			Session session = sessionFactory.getCurrentSession();
			HolidayGroup holidayGroup = (HolidayGroup) session.get(HolidayGroup.class, holidayGroupId);
			Holiday holiday = (Holiday) session.get(Holiday.class, holidayId);
			
			if (isGrantAccess)
			{
				holidayGroup.getHolidays().add(holiday);
			}
			else 
			{
				holidayGroup.getHolidays().remove(holiday);
			}
			return true; 
	}
	
	
	public void getAllTest(Integer holidayGroupId, Integer holidayId) 
	{		
		Session session = sessionFactory.getCurrentSession();
		
		HolidayGroup holidayGroup = (HolidayGroup) session.get(HolidayGroup.class, holidayGroupId);
		Holiday holiday = (Holiday) session.get(Holiday.class, holidayId);
		holidayGroup.getHolidays().add(holiday);
		//return  query.list();
	}
	

	public HolidayGroup get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		HolidayGroup holidayGroup = (HolidayGroup) session.get(HolidayGroup.class, id);

		return holidayGroup;
	}

	public void add(HolidayGroup holidayGroup) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(holidayGroup);
	}


	public void saveOrUpdate(HolidayGroup holidayGroup) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(holidayGroup);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		HolidayGroup holidayGroup = (HolidayGroup) session.get(HolidayGroup.class, id);

		session.delete(holidayGroup);
	}

	public void edit(HolidayGroup holidayGroup) 
	{
		Session session = sessionFactory.getCurrentSession();
		HolidayGroup target = (HolidayGroup) session.get(HolidayGroup.class, holidayGroup.getNid());

		target.setNid(holidayGroup.getNid());
		target.setName(holidayGroup.getName());
		target.setDescription(holidayGroup.getDescription());
		target.setHolidays(holidayGroup.getHolidays());
		target.setLastUpdate(holidayGroup.getLastUpdate());
		target.setCompanyRef(holidayGroup.getCompanyRef());
		target.setStartEffectiveDate(holidayGroup.getEndEffectiveDate());
		target.setEndEffectiveDate(holidayGroup.getEndEffectiveDate());
		target.setDisabled(holidayGroup.getDisabled());
		
		session.save(target);
	}
}