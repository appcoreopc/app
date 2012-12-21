package com.appCore.personnel.Core.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.Core.Entity.Branch;
import com.appCore.personnel.Core.Entity.BranchInfo;
import com.appCore.personnel.Core.Entity.BranchSummary;

@Service("branchService")
@Transactional
public class BranchService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;

	protected static Logger logger = Logger.getLogger("service");

	public BranchSummary getSummary(Integer companyId)
	{
		
		int summaryResultCount = 3;
		Session session = sessionFactory.getCurrentSession();

		Query queryCount = session.createQuery("select count(*) from Branch where companyId = :companyId");
		queryCount.setParameter("companyId", companyId);
		
		Long summaryCount = ((Long) queryCount.uniqueResult()).longValue();

		Query query = session.createQuery("FROM Branch where companyId = :companyId");
		query.setParameter("companyId", companyId);

		List<Branch> list = query.setMaxResults(summaryResultCount).list();

		BranchSummary summary = new BranchSummary();
		summary.setCount(summaryCount);
		summary.setListBranch(list);

		return summary;
		
	}
	
	public List<Branch> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  Branch");
		return query.list();
	}

	public Branch get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Branch branch = (Branch) session.get(Branch.class, id);

		return branch;
	}

	public void add(Branch branch) 
	{
		Session session = sessionFactory.getCurrentSession();
		Integer savedInstance = (Integer) session.save(branch);
		for (BranchInfo info : branch.getBranchInfo())
		{
			info.setRefEntity(savedInstance);
			session.save(info);
		}
	}


	public void saveOrUpdate(Branch branch) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(branch);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Branch branch = (Branch) session.get(Branch.class, id);

		session.delete(branch);
	}

	public void edit(Branch branch) 
	{
		Session session = sessionFactory.getCurrentSession();
		Branch target = (Branch) session.get(Branch.class, branch.getNid());

		target.setNid(branch.getNid());
		target.setBranchCode(branch.getBranchCode());
		target.setBranchName(branch.getBranchName());
		target.setDescription(branch.getDescription());
		target.setBranchInfo(branch.getBranchInfo());
		target.setEnabled(branch.getEnabled());
		target.setLastUpdate(branch.getLastUpdate());

		session.save(target);
	}
}