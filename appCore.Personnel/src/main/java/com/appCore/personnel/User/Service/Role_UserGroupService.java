package com.appCore.personnel.User.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.User.Entity.Role_UserGroup;

@Service("role_UserGroupService")
@Transactional
public class Role_UserGroupService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<Role_UserGroup> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  Role_UserGroup");

		return  query.list();
	}

	public Role_UserGroup get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Role_UserGroup role_UserGroup = (Role_UserGroup) session.get(Role_UserGroup.class, id);

		return role_UserGroup;
	}

	public void add(Role_UserGroup role_UserGroup) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(role_UserGroup);
	}


	public void saveOrUpdate(Role_UserGroup role_UserGroup) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(role_UserGroup);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Role_UserGroup role_UserGroup = (Role_UserGroup) session.get(Role_UserGroup.class, id);

		session.delete(role_UserGroup);
	}

	public void edit(Role_UserGroup role_UserGroup) 
	{
		Session session = sessionFactory.getCurrentSession();
		Role_UserGroup target = (Role_UserGroup) session.get(Role_UserGroup.class, role_UserGroup.getNid());

		target.setNid(role_UserGroup.getNid());
		target.setRole_nid(role_UserGroup.getRole_nid());
		target.setUserGroup_nid(role_UserGroup.getUserGroup_nid());
		target.setType(role_UserGroup.getType());
		target.setLastUpdate(role_UserGroup.getLastUpdate());

		session.save(target);
	}
}