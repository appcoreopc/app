package com.appCore.personnel.User.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.User.Entity.Forms_Role;

@Service("forms_RoleService")
@Transactional
public class Forms_RoleService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;

	
	public Forms_RoleService()
	{
		
	}
	
	public Forms_RoleService(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	public List<Forms_Role> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  Forms_Role");

		return  query.list();
	}

	
	public List<Forms_Role> getByRoles(Integer roleId) 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  Forms_Role where Role_nid = :roleNid");
		query.setParameter("roleNid", roleId);
		return  query.list();
	}

	
	public Forms_Role get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Forms_Role forms_Role = (Forms_Role) session.get(Forms_Role.class, id);

		return forms_Role;
	}

	public void add(Forms_Role forms_Role) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(forms_Role);
	}


	public void saveOrUpdate(Forms_Role forms_Role) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(forms_Role);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Forms_Role forms_Role = (Forms_Role) session.get(Forms_Role.class, id);

		session.delete(forms_Role);
	}

	public void edit(Forms_Role forms_Role) 
	{
		Session session = sessionFactory.getCurrentSession();
		Forms_Role target = (Forms_Role) session.get(Forms_Role.class, forms_Role.getNid());

		target.setNid(forms_Role.getNid());
		target.setForms_nid(forms_Role.getForms_nid());
		target.setRole_nid(forms_Role.getRole_nid());
		target.setFilter(forms_Role.getFilter());
		target.setPermission(forms_Role.getPermission());
		target.setDisabled(forms_Role.getDisabled());
		target.setLastUpdate(forms_Role.getLastUpdate());
		target.setForms(forms_Role.getForms());

		session.save(target);
	}
}