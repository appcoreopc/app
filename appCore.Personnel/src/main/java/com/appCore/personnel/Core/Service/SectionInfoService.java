package com.appCore.personnel.Core.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.Core.Entity.SectionInfo;

@Service("sectionInfoService")
@Transactional
public class SectionInfoService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<SectionInfo> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  SectionInfo");
		return  query.list();
	}

	public List<SectionInfo> getAllByRefEntity(Integer id) 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  SectionInfo where RefEntity = :refEntity");
		query.setParameter("refEntity", id);
		return  query.list();
	}
	
	public SectionInfo get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		SectionInfo sectionInfo = (SectionInfo) session.get(SectionInfo.class, id);

		return sectionInfo;
	}

	public void add(SectionInfo sectionInfo) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(sectionInfo);
	}


	public void saveOrUpdate(SectionInfo sectionInfo) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(sectionInfo);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		SectionInfo sectionInfo = (SectionInfo) session.get(SectionInfo.class, id);

		session.delete(sectionInfo);
	}

	public void edit(SectionInfo sectionInfo) 
	{
		Session session = sessionFactory.getCurrentSession();
		SectionInfo target = (SectionInfo) session.get(SectionInfo.class, sectionInfo.getNid());

		target.setNid(sectionInfo.getNid());
		target.setType(sectionInfo.getType());
		target.setValue(sectionInfo.getValue());
		target.setDescription(sectionInfo.getDescription());
		target.setCategory(sectionInfo.getCategory());
		target.setRefEntity(sectionInfo.getRefEntity());
		target.setLastUpdate(sectionInfo.getLastUpdate());

		session.save(target);
	}
}