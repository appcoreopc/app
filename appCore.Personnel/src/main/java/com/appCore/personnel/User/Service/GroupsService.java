package com.appCore.personnel.User.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.User.Entity.Groups;

@Service("groupsService")
@Transactional
public class GroupsService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<Groups> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  Groups");

		return  query.list();
	}

	public Groups get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Groups groups = (Groups) session.get(Groups.class, id);

		return groups;
	}

	public void add(Groups groups) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(groups);
	}


	public void saveOrUpdate(Groups groups) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(groups);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Groups groups = (Groups) session.get(Groups.class, id);

		session.delete(groups);
	}

	public void edit(Groups groups) 
	{
		Session session = sessionFactory.getCurrentSession();
		Groups target = (Groups) session.get(Groups.class, groups.getNid());

		target.setNid(groups.getNid());
		target.setName(groups.getName());
		target.setDescription(groups.getDescription());
		target.setDisabled(groups.getDisabled());
		target.setLastUpdate(groups.getLastUpdate());

		session.save(target);
	}
}