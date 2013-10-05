package com.appCore.personnel.User.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.User.Entity.Forms_Actions_Role;

@Service("actions_RoleService")
@Transactional
public class Actions_RoleService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;

	public Actions_RoleService()
	{
		
		
	}
	
	public Actions_RoleService(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	public List<Forms_Actions_Role> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  Actions_Role");

		return  query.list();
	}

	public Forms_Actions_Role get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Forms_Actions_Role actions_Role = (Forms_Actions_Role) session.get(Forms_Actions_Role.class, id);

		return actions_Role;
	}

	public void add(Forms_Actions_Role actions_Role) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(actions_Role);
	}


	public void saveOrUpdate(Forms_Actions_Role actions_Role) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(actions_Role);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Forms_Actions_Role actions_Role = (Forms_Actions_Role) session.get(Forms_Actions_Role.class, id);

		session.delete(actions_Role);
	}

	public void edit(Forms_Actions_Role actions_Role) 
	{
		Session session = sessionFactory.getCurrentSession();
		Forms_Actions_Role target = (Forms_Actions_Role) session.get(Forms_Actions_Role.class, actions_Role.getNid());

		target.setNid(actions_Role.getNid());
		target.setRole_nid(actions_Role.getRole_nid());
		target.setActions_nid(actions_Role.getActions_nid());
		target.setPermission(actions_Role.getPermission());
		target.setDisabled(actions_Role.getDisabled());
		target.setLastUpdate(actions_Role.getLastUpdate());

		session.save(target);
	}
}