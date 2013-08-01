package com.appCore.personnel.User.Service;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.User.Entity.ScriptWidget;
import com.appCore.personnel.User.Entity.UserLanding;

@Service("userLandingService")
@Transactional
public class UserLandingService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<UserLanding> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  UserLanding");
		return query.list();
	}

	public List<ScriptWidget> get(Integer userId, int applicationType) 
	{
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM UserLanding WHERE UserId = :userId AND Enabled=true AND ApplicationType = :applicationType");
		query.setParameter("userId", userId);
		query.setParameter("applicationType", applicationType);
		
		List<UserLanding> userLandingListResult = query.list();
		List<ScriptWidget> widgetResult = new ArrayList<ScriptWidget>();
		
		for (UserLanding userLanding : userLandingListResult) {
			ScriptWidget scriptResult = (ScriptWidget) session.get(ScriptWidget.class, userLanding.getScriptId());
			if (scriptResult != null)
				widgetResult.add(scriptResult);
		}
   
		return widgetResult;
	}

	public void add(UserLanding userLanding) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(userLanding);
	}


	public void saveOrUpdate(UserLanding userLanding) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(userLanding);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		UserLanding userLanding = (UserLanding) session.get(UserLanding.class, id);

		session.delete(userLanding);
	}

	public void edit(UserLanding userLanding) 
	{
		Session session = sessionFactory.getCurrentSession();
		UserLanding target = (UserLanding) session.get(UserLanding.class, userLanding.getNid());

		target.setNid(userLanding.getNid());
		target.setUserId(userLanding.getUserId());
		target.setScriptId(userLanding.getScriptId());
		target.setLastUpdate(userLanding.getLastUpdate());

		session.save(target);
	}
}