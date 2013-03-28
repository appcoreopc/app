package com.appCore.personnel.User.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.User.Entity.UserGroup;

@Service("userGroupService")
@Transactional
public class UserGroupService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<UserGroup> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  UserGroup");

		return  query.list();
	}

	public UserGroup get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		UserGroup userGroup = (UserGroup) session.get(UserGroup.class, id);

		return userGroup;
	}

	public void add(UserGroup userGroup) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(userGroup);
	}


	public void saveOrUpdate(UserGroup userGroup) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(userGroup);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		UserGroup userGroup = (UserGroup) session.get(UserGroup.class, id);

		session.delete(userGroup);
	}

	public void edit(UserGroup userGroup) 
	{
		Session session = sessionFactory.getCurrentSession();
		UserGroup target = (UserGroup) session.get(UserGroup.class, userGroup.getNid());

		target.setNid(userGroup.getNid());
		target.setUser_nid(userGroup.getUser_nid());
		target.setGroup_nid(userGroup.getGroup_nid());
		target.setLastUpdate(userGroup.getLastUpdate());

		session.save(target);
	}
}