package com.appCore.personnel.Core.Calendar.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.Core.Calendar.Entity.LeaveWorkflow;

@Service("leaveWorkflowService")
@Transactional
public class LeaveWorkflowService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;

	public List<LeaveWorkflow> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  LeaveWorkflow");

		return query.list();
	}

	public List<LeaveWorkflow> getAllByCompany(Integer id) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  LeaveWorkflow WHERE CompanyId = :id");
		query.setParameter("id", id);
		return query.list();
	}


	public LeaveWorkflow get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		LeaveWorkflow leaveWorkflow = (LeaveWorkflow) session.get(LeaveWorkflow.class, id);

		return leaveWorkflow;
	}

	public void add(LeaveWorkflow leaveWorkflow) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(leaveWorkflow);
	}


	public void saveOrUpdate(LeaveWorkflow leaveWorkflow) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(leaveWorkflow);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		LeaveWorkflow leaveWorkflow = (LeaveWorkflow) session.get(LeaveWorkflow.class, id);

		session.delete(leaveWorkflow);
	}
	
}