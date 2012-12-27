package com.appCore.personnel.Core.Service;


import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.orm.hibernate3.SessionHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.appCore.personnel.Core.Entity.DepartmentInfo;
import com.appCore.personnel.Core.Entity.Division;
import com.appCore.personnel.Core.Entity.DivisionInfo;
import com.appCore.personnel.Core.Entity.DivisionSummary;

@Service("divisionService")
@Transactional
public class DivisionService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public DivisionSummary getSummary(Integer companyId)
	{
		int summaryResultCount = 3;
		Session session = sessionFactory.getCurrentSession();

		Query queryCount = session.createQuery("select count(*) from Division where companyId = :companyId");
		queryCount.setParameter("companyId", companyId);
		Long summaryCount = ((Long) queryCount.uniqueResult()).longValue();

		Query query = session.createQuery("FROM Division where companyId = :companyId");
		query.setParameter("companyId", companyId);

		List<Division> list = query.setMaxResults(summaryResultCount).list();
		DivisionSummary summary = new DivisionSummary();
		summary.setCount(summaryCount);
		summary.setListDivision(list);
		return summary;
		
	}
	
	public List<Division> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  Division");
		return  query.list();
	}

	public List<Division> getAllByCompany(Integer id) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  Division WHERE CompanyId = :id");
		query.setParameter("id", id);
		return  query.list();
		
	}
	
	public Division get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Division division = (Division) session.get(Division.class, id);
		
		Query query = session.createQuery("FROM DivisionInfo WHERE RefEntity = :id");
		query.setParameter("id", id);
		List<DivisionInfo> info = query.list();
		division.setDivisionInfo(info);
		
		return division;
	}

	public void add(Division division) 
	{
		Session session = sessionFactory.getCurrentSession();
		Integer savedInstance = (Integer) session.save(division);
		
		for (DivisionInfo info : division.getDivisionInfo())
		{
			info.setRefEntity(savedInstance);
			session.save(info);
		}
	}


	public void saveOrUpdate(Division division) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(division);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Division division = (Division) session.get(Division.class, id);

		session.delete(division);
	}

	public void edit(Division division) 
	{
		Session session = sessionFactory.getCurrentSession();
		Division target = (Division) session.get(Division.class, division.getNid());

		target.setNid(division.getNid());
		
		target.setDivisionCode(division.getDivisionCode());
		target.setDivisionName(division.getDivisionName());
		target.setDivisionInfo(division.getDivisionInfo());
		target.setDescription(division.getDescription());
		target.setDisabled(division.getDisabled());
		
		target.setLastUpdate(division.getLastUpdate());

		session.save(target);
	}

	
}