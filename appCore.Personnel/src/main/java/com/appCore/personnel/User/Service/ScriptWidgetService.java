package com.appCore.personnel.User.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.User.Entity.ScriptWidget;

@Service("scriptWidgetService")
@Transactional
public class ScriptWidgetService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<ScriptWidget> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  ScriptWidget");

		return  query.list();
	}

	public ScriptWidget get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		ScriptWidget scriptWidget = (ScriptWidget) session.get(ScriptWidget.class, id);

		return scriptWidget;
	}

	public void add(ScriptWidget scriptWidget) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(scriptWidget);
	}


	public void saveOrUpdate(ScriptWidget scriptWidget) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(scriptWidget);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		ScriptWidget scriptWidget = (ScriptWidget) session.get(ScriptWidget.class, id);

		session.delete(scriptWidget);
	}

	public void edit(ScriptWidget scriptWidget) 
	{
		Session session = sessionFactory.getCurrentSession();
		ScriptWidget target = (ScriptWidget) session.get(ScriptWidget.class, scriptWidget.getNid());

		target.setNid(scriptWidget.getNid());
		target.setCompanyId(scriptWidget.getCompanyId());
		target.setScriptName(scriptWidget.getScriptName());
		target.setScriptPath(scriptWidget.getScriptPath());
		target.setDescription(scriptWidget.getDescription());
		target.setLastUpdate(scriptWidget.getLastUpdate());

		session.save(target);
	}
}