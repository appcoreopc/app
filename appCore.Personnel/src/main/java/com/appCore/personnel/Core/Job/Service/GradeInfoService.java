package com.appCore.personnel.Core.Job.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.Core.Job.Entity.GradeInfo;

@Service("gradeInfoService")
@Transactional
public class GradeInfoService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<GradeInfo> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  GradeInfo");

		return  query.list();
	}
	
	public List<GradeInfo> getAllByRefEntity(Integer id) 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  GradeInfo where RefEntity = :refEntity");
		query.setParameter("refEntity", id);
		return  query.list();
	}
	
	
	public GradeInfo get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		GradeInfo gradeInfo = (GradeInfo) session.get(GradeInfo.class, id);

		return gradeInfo;
	}

	public void add(GradeInfo gradeInfo) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(gradeInfo);
	}


	public int saveOrUpdate(GradeInfo gradeInfo) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(gradeInfo);
		return gradeInfo.getNid();
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		GradeInfo gradeInfo = (GradeInfo) session.get(GradeInfo.class, id);

		session.delete(gradeInfo);
	}

	public void edit(GradeInfo gradeInfo) 
	{
		Session session = sessionFactory.getCurrentSession();
		GradeInfo target = (GradeInfo) session.get(GradeInfo.class, gradeInfo.getNid());

		target.setNid(gradeInfo.getNid());
		target.setType(gradeInfo.getType());
		target.setValue(gradeInfo.getValue());
		target.setDescription(gradeInfo.getDescription());
		target.setCategory(gradeInfo.getCategory());
		target.setRefEntity(gradeInfo.getRefEntity());
		target.setLastUpdate(gradeInfo.getLastUpdate());

		session.save(target);
	}
}