package com.appCore.personnel.Core.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.lang.Integer;
import java.lang.Object;
import com.appCore.personnel.Core.Entity.Unit;
import com.appCore.personnel.Core.Entity.UnitInfo;
import com.appCore.personnel.Core.Entity.UnitSummary;

@Service("unitService")
@Transactional
public class UnitService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	public UnitSummary getSummary(Integer companyId)
	{
		int summaryResultCount = 3;
		
		Session session = sessionFactory.getCurrentSession();
		
		Query queryCount = session.createQuery("select count(*) from Unit where companyId = :companyId");
		queryCount.setParameter("companyId", companyId);
		Long summaryCount = ((Long) queryCount.uniqueResult()).longValue();
		
		Query query = session.createQuery("FROM Unit where companyId = :companyId");
		query.setParameter("companyId", companyId);
		
		List<Unit> list = query.setMaxResults(summaryResultCount).list();
		
		UnitSummary summary = new UnitSummary();
		summary.setCount(summaryCount);
		summary.setListUnit(list);
		
		return summary;
	}

	public List<Unit> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  Unit");

		return query.list();
	}

	public List<Unit> getAllByCompany(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  Unit");
		query.setParameter("id", id);
		return query.list();
		
	}
	
	public Unit get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Unit unit = (Unit) session.get(Unit.class, id);

		return unit;
	}

	public void add(Unit unit) 
	{
		Session session = sessionFactory.getCurrentSession();
		
		Integer savedInstanced = (Integer) session.save(unit); 
		
		for (UnitInfo info : unit.getUnitInfo())
		{
			info.setRefEntity(savedInstanced);
			session.save(info);
		}
	}

	public void saveOrUpdate(Unit unit) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(unit);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Unit unit = (Unit) session.get(Unit.class, id);

		session.delete(unit);
	}

	public void edit(Unit unit) 
	{
		Session session = sessionFactory.getCurrentSession();
		Unit target = (Unit) session.get(Unit.class, unit.getNid());

		target.setNid(unit.getNid());
		target.setUnitCode(unit.getUnitCode());
		target.setUnitName(unit.getUnitName());
		target.setRemark(unit.getRemark());
		target.setEnabled(unit.getEnabled());
		target.setUnitInfo(unit.getUnitInfo());
		target.setLastUpdate(unit.getLastUpdate());

		session.save(target);
	}
	
}