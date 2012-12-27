package com.appCore.personnel.Core.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.Core.Entity.DivisionInfo;

@Service("divisionInfoService")
@Transactional
public class DivisionInfoService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<DivisionInfo> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  DivisionInfo");

		return  query.list();
	}
	
	public List<DivisionInfo> getAllByRefEntity(Integer id) 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  DivisionInfo where RefEntity = :refEntity");
		query.setParameter("refEntity", id);
		return  query.list();
	}
	
	public DivisionInfo get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		DivisionInfo divisionInfo = (DivisionInfo) session.get(DivisionInfo.class, id);

		return divisionInfo;
	}

	public void add(DivisionInfo divisionInfo) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(divisionInfo);
	}


	public int saveOrUpdate(DivisionInfo divisionInfo) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(divisionInfo);
		return divisionInfo.getNid();
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		DivisionInfo divisionInfo = (DivisionInfo) session.get(DivisionInfo.class, id);

		session.delete(divisionInfo);
	}

	public void edit(DivisionInfo divisionInfo) 
	{
		Session session = sessionFactory.getCurrentSession();
		DivisionInfo target = (DivisionInfo) session.get(DivisionInfo.class, divisionInfo.getNid());

		target.setNid(divisionInfo.getNid());
		target.setType(divisionInfo.getType());
		target.setValue(divisionInfo.getValue());
		target.setDescription(divisionInfo.getDescription());
		target.setCategory(divisionInfo.getCategory());
		target.setRefEntity(divisionInfo.getRefEntity());
		target.setLastUpdate(divisionInfo.getLastUpdate());

		session.save(target);
	}
}