package com.appCore.personnel.User.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.User.Entity.Actions;

@Service("actionsService")
@Transactional
public class ActionsService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;

	public ActionsService()
	{
		
	}
	
	public ActionsService(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	public List<Actions> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  Actions");

		return  query.list();
	}

	public Actions get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Actions actions = (Actions) session.get(Actions.class, id);

		return actions;
	}

	public void add(Actions actions) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(actions);
	}


	public void saveOrUpdate(Actions actions) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(actions);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Actions actions = (Actions) session.get(Actions.class, id);

		session.delete(actions);
	}

	public void edit(Actions actions) 
	{
		Session session = sessionFactory.getCurrentSession();
		Actions target = (Actions) session.get(Actions.class, actions.getNid());

		target.setNid(actions.getNid());
		target.setActionCode(actions.getActionCode());
		target.setDescription(actions.getDescription());
		target.setDisabled(actions.getDisabled());
		target.setLastUpdate(actions.getLastUpdate());

		session.save(target);
	}
}