package com.appCore.personnel.Core.Calendar.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.Core.Calendar.Entity.OffDayInfo;

@Service("offDayInfoService")
@Transactional
public class OffDayInfoService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<OffDayInfo> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  OffDayInfo");

		return  query.list();
	}

	public List<OffDayInfo> getAllByRefEntity(Integer id) 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  OffDayInfo where RefEntity = :refEntity");
		query.setParameter("refEntity", id);
		
		return  query.list();
	}
	
	public OffDayInfo get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		OffDayInfo offDayInfo = (OffDayInfo) session.get(OffDayInfo.class, id);

		return offDayInfo;
	}

	public void add(OffDayInfo offDayInfo) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(offDayInfo);
	}


	public void saveOrUpdate(OffDayInfo offDayInfo) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(offDayInfo);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		OffDayInfo offDayInfo = (OffDayInfo) session.get(OffDayInfo.class, id);

		session.delete(offDayInfo);
	}

	public void edit(OffDayInfo offDayInfo) 
	{
		Session session = sessionFactory.getCurrentSession();
		OffDayInfo target = (OffDayInfo) session.get(OffDayInfo.class, offDayInfo.getNid());

		target.setNid(offDayInfo.getNid());
		target.setRefEntity(offDayInfo.getRefEntity());
		target.setDayNo(offDayInfo.getDayNo());
		target.setDayType(offDayInfo.getDayType());
		target.setDescription(offDayInfo.getDescription());
		target.setDayTypeDescription(offDayInfo.getDayTypeDescription());
		target.setClashedAction(offDayInfo.getClashedAction());
		target.setNonClashedAction(offDayInfo.getNonClashedAction());
		target.setLastUpdate(offDayInfo.getLastUpdate());

		session.save(target);
	}
}