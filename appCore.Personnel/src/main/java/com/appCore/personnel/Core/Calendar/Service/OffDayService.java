package com.appCore.personnel.Core.Calendar.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.Core.Calendar.Entity.OffDay;

@Service("offDayService")
@Transactional
public class OffDayService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<OffDay> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  OffDay");

		return  query.list();
	}

	public OffDay get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		OffDay offDay = (OffDay) session.get(OffDay.class, id);

		return offDay;
	}

	public void add(OffDay offDay) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(offDay);
	}


	public void saveOrUpdate(OffDay offDay) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(offDay);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		OffDay offDay = (OffDay) session.get(OffDay.class, id);

		session.delete(offDay);
	}

	public void edit(OffDay offDay) 
	{
		Session session = sessionFactory.getCurrentSession();
		OffDay target = (OffDay) session.get(OffDay.class, offDay.getNid());

		target.setNid(offDay.getNid());
		target.setPatternName(offDay.getPatternName());
		target.setDescription(offDay.getDescription());
		target.setDisabled(offDay.getDisabled());
		target.setDayPerCycle(offDay.getDayPerCycle());
		target.setRemark(offDay.getRemark());
		target.setOffDayInfo(offDay.getOffDayInfo());
		target.setLastUpdate(offDay.getLastUpdate());

		session.save(target);
	}
}