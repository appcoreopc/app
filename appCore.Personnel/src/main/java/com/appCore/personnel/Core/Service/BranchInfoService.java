package com.appCore.personnel.Core.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.Core.Entity.BranchInfo;

@Service("branchInfoService")
@Transactional
public class BranchInfoService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<BranchInfo> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  BranchInfo");

		return  query.list();
	}
	
	public List<BranchInfo> getAllByRefEntity(Integer id) 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  BranchInfo where RefEntity = :refEntity");
		query.setParameter("refEntity", id);

		return  query.list();
	}
	
	public BranchInfo get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		BranchInfo branchInfo = (BranchInfo) session.get(BranchInfo.class, id);

		return branchInfo;
	}

	public void add(BranchInfo branchInfo) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(branchInfo);
	}


	public int saveOrUpdate(BranchInfo branchInfo) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(branchInfo);
		return branchInfo.getNid();
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		BranchInfo branchInfo = (BranchInfo) session.get(BranchInfo.class, id);

		session.delete(branchInfo);
	}

	public void edit(BranchInfo branchInfo) 
	{
		Session session = sessionFactory.getCurrentSession();
		BranchInfo target = (BranchInfo) session.get(BranchInfo.class, branchInfo.getNid());

		target.setNid(branchInfo.getNid());
		target.setType(branchInfo.getType());
		target.setValue(branchInfo.getValue());
		target.setDescription(branchInfo.getDescription());
		target.setCategory(branchInfo.getCategory());
		target.setRefEntity(branchInfo.getRefEntity());
		target.setLastUpdate(branchInfo.getLastUpdate());

		session.save(target);
	}
}