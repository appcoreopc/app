package com.appCore.personnel.Core.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.Core.Entity.UnitInfo;

@Service("unitInfoService")
@Transactional
public class UnitInfoService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<UnitInfo> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  UnitInfo");
		return  query.list();
	}
	
	public List<UnitInfo> getAllByRefEntity(Integer id) 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  UnitInfo where RefEntity = :refEntity");
		query.setParameter("refEntity", id);
		return  query.list();
	}
	
	public UnitInfo get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		UnitInfo unitInfo = (UnitInfo) session.get(UnitInfo.class, id);

		return unitInfo;
	}

	public void add(UnitInfo unitInfo) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(unitInfo);
	}


	public int saveOrUpdate(UnitInfo unitInfo) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(unitInfo);
		
		return unitInfo.getNid();
	}
	

	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		UnitInfo unitInfo = (UnitInfo) session.get(UnitInfo.class, id);

		session.delete(unitInfo);
	}

	public void edit(UnitInfo unitInfo) 
	{
		Session session = sessionFactory.getCurrentSession();
		UnitInfo target = (UnitInfo) session.get(UnitInfo.class, unitInfo.getNid());

		target.setNid(unitInfo.getNid());
		target.setType(unitInfo.getType());
		target.setValue(unitInfo.getValue());
		target.setDescription(unitInfo.getDescription());
		target.setCategory(unitInfo.getCategory());
		target.setRefEntity(unitInfo.getRefEntity());
		target.setLastUpdate(unitInfo.getLastUpdate());

		session.save(target);
	}
}