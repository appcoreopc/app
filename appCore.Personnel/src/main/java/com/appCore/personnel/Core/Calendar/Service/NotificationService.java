package com.appCore.personnel.Core.Calendar.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.Core.Calendar.Entity.Notification;

@Service("notificationService")
@Transactional
public class NotificationService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;

	public List<Notification> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  Notification");

		return query.list();
	}

	public List<Notification> getAllByCompany(Integer id) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  Notification WHERE CompanyId = :id");
		query.setParameter("id", id);
		return query.list();
	}


	public Notification get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Notification notification = (Notification) session.get(Notification.class, id);

		return notification;
	}

	public void add(Notification notification) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(notification);
	}


	public void saveOrUpdate(Notification notification) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(notification);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Notification notification = (Notification) session.get(Notification.class, id);

		session.delete(notification);
	}
	
}