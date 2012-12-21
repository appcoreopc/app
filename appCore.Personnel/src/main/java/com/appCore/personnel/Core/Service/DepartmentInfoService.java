package com.appCore.personnel.Core.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.Core.Entity.DepartmentInfo;

@Service("departmentInfoService")
@Transactional
public class DepartmentInfoService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<DepartmentInfo> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  DepartmentInfo");

		return  query.list();
	}
	
	public List<DepartmentInfo> getAllByRefEntity(Integer id) 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  DepartmentInfo where RefEntity = :refEntity");
		query.setParameter("refEntity", id);
		return  query.list();
	}

	public DepartmentInfo get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		DepartmentInfo departmentInfo = (DepartmentInfo) session.get(DepartmentInfo.class, id);

		return departmentInfo;
	}

	public void add(DepartmentInfo departmentInfo) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(departmentInfo);
	}


	public void saveOrUpdate(DepartmentInfo departmentInfo) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(departmentInfo);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		DepartmentInfo departmentInfo = (DepartmentInfo) session.get(DepartmentInfo.class, id);

		session.delete(departmentInfo);
	}

	public void edit(DepartmentInfo departmentInfo) 
	{
		Session session = sessionFactory.getCurrentSession();
		DepartmentInfo target = (DepartmentInfo) session.get(DepartmentInfo.class, departmentInfo.getNid());

		target.setNid(departmentInfo.getNid());
		target.setType(departmentInfo.getType());
		target.setValue(departmentInfo.getValue());
		target.setDescription(departmentInfo.getDescription());
		target.setCategory(departmentInfo.getCategory());
		target.setRefEntity(departmentInfo.getRefEntity());
		target.setLastUpdate(departmentInfo.getLastUpdate());

		session.save(target);
	}
}