package com.appCore.personnel.User.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.User.Entity.UserLandingPage;

@Service("userLandingPageService")
@Transactional
public class UserLandingPageService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<UserLandingPage> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  UserLandingPage");

		return  query.list();
	}

	public UserLandingPage get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		UserLandingPage userLandingPage = (UserLandingPage) session.get(UserLandingPage.class, id);

		return userLandingPage;
	}

	public List<UserLandingPage> getByUserId(Integer userId) 
	{
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  UserLandingPage WHERE UserId = :id");
		query.setParameter("id", userId);
		return query.list();
	}

	
	
	public void add(UserLandingPage userLandingPage) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(userLandingPage);
	}


	public void saveOrUpdate(UserLandingPage userLandingPage) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(userLandingPage);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		UserLandingPage userLandingPage = (UserLandingPage) session.get(UserLandingPage.class, id);

		session.delete(userLandingPage);
	}

	public void edit(UserLandingPage userLandingPage) 
	{
		Session session = sessionFactory.getCurrentSession();
		UserLandingPage target = (UserLandingPage) session.get(UserLandingPage.class, userLandingPage.getNid());

		target.setNid(userLandingPage.getNid());
		target.setUserId(userLandingPage.getUserId());
		target.setLandingPage(userLandingPage.getLandingPage());
		target.setLastLogin(userLandingPage.getLastLogin());

		session.save(target);
	}
}