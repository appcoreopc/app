package com.appCore.personnel.User.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.User.Entity.Roles;
import com.appCore.personnel.User.Entity.Users;

@Service("usersService")
@Transactional
public class UsersService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	public UsersService()
	{
	
	}

	public UsersService(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	public List<Users> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  Users");

		return  query.list();
	}

	public Users get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Users users = (Users) session.get(Users.class, id);

		return users;
	}
	
	public int getRole(Integer userId) 
	{
		//Session session = sessionFactory.getCurrentSession();
		//Query query = session.createQuery(("From userrole_assignment where assignedUsers_Nid :userId");
		//query.setParameter("userId", userId);
		//List result = query.list();
		//System.out.println(result.getClass().toString());
		//if (result.size() > 0)
		//{
			// int userRole = result.get(0).
		//}
		return -1;
	}
	
	
	public List<Users> get(String username, String password) 
	{
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("From Users where username = :username AND password = :password");
		query.setParameter("username", username);
		query.setParameter("password", password);
		return query.list();
	}

	public boolean add(Users users) 
	{
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Users where username = :username");
		query.setParameter("username", users.getUsername());
		
		if (query.list().size() == 0) 
		{	
			session.save(users);
			return true; 
		}
		else 
			return false;
	}


	public void saveOrUpdate(Users users) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(users);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Users users = (Users) session.get(Users.class, id);

		session.delete(users);
	}

	public void edit(Users users) 
	{
		Session session = sessionFactory.getCurrentSession();
		Users target = (Users) session.get(Users.class, users.getNid());

		target.setNid(users.getNid());
		target.setUsername(users.getUsername());
		target.setPassword(users.getPassword());
		target.setLastLogin(users.getLastLogin());

		session.save(target);
	}
}