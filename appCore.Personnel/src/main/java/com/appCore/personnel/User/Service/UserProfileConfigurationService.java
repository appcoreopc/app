package com.appCore.personnel.User.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.User.Entity.UserProfileConfiguration;

@Service("userProfileConfigurationService")
@Transactional
public class UserProfileConfigurationService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;

	public List<UserProfileConfiguration> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  UserProfileConfiguration");

		return  query.list();
	}
	
	public List<UserProfileConfiguration> getByUserId(int userId) 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  UserProfileConfiguration WHERE UserId = :id");
		query.setParameter("id", userId);
		return  query.list();
	}
	
	public UserProfileConfiguration get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		UserProfileConfiguration userProfileConfiguration = (UserProfileConfiguration) session.get(UserProfileConfiguration.class, id);

		return userProfileConfiguration;
	}

	public void add(UserProfileConfiguration userProfileConfiguration) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(userProfileConfiguration);
	}


	public void saveOrUpdate(UserProfileConfiguration userProfileConfiguration) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(userProfileConfiguration);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		UserProfileConfiguration userProfileConfiguration = (UserProfileConfiguration) session.get(UserProfileConfiguration.class, id);

		session.delete(userProfileConfiguration);
	}

	public void edit(UserProfileConfiguration userProfileConfiguration) 
	{
		Session session = sessionFactory.getCurrentSession();
		UserProfileConfiguration target = (UserProfileConfiguration) session.get(UserProfileConfiguration.class, userProfileConfiguration.getNid());

		target.setNid(userProfileConfiguration.getNid());
		target.setUserId(userProfileConfiguration.getUserId());
		target.setDefaultCompanyId(userProfileConfiguration.getDefaultCompanyId());
		target.setDefaultLanguage(userProfileConfiguration.getDefaultLanguage());
		target.setLastUpdate(userProfileConfiguration.getLastUpdate());

		session.save(target);
	}
}