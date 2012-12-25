package com.appCore.personnel.Core.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.Core.Entity.Section;
import com.appCore.personnel.Core.Entity.SectionInfo;
import com.appCore.personnel.Core.Entity.SectionSummary;

@Service("sectionService")
@Transactional
public class SectionService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;

	public SectionSummary getSummary(Integer companyId)
	{
	
		int summaryResultCount = 3;
		Session session = sessionFactory.getCurrentSession();

		Query queryCount = session.createQuery("select count(*) from Section where companyId = :companyId");
		queryCount.setParameter("companyId", companyId);
		Long summaryCount = ((Long) queryCount.uniqueResult()).longValue();

		Query query = session.createQuery("FROM Section where companyId = :companyId");
		query.setParameter("companyId", companyId);

		List<Section> list = query.setMaxResults(summaryResultCount).list();

		SectionSummary summary = new SectionSummary();
		summary.setCount(summaryCount);
		summary.setListSection(list);

		return summary;
	
	}

	public List<Section> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  Section");

		return  query.list();
	}

	
	public List<Section> getAllByCompany(Integer id) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  Section WHERE CompanyId = id");
		query.setParameter("id", id);
		return  query.list();

	}
	
	public Section get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Section section = (Section) session.get(Section.class, id);

		return section;
	}

	public void add(Section section) 
	{
		Session session = sessionFactory.getCurrentSession();
		
		Integer savedInstance = (Integer) session.save(section);
		
		for (SectionInfo info : section.getSectionInfo())
		{
			info.setRefEntity(savedInstance);
			session.save(info);
		}
		
	}


	public void saveOrUpdate(Section section) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(section);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Section section = (Section) session.get(Section.class, id);

		session.delete(section);
	}

	public void edit(Section section) 
	{
		Session session = sessionFactory.getCurrentSession();
		Section target = (Section) session.get(Section.class, section.getNid());

		target.setNid(section.getNid());
		target.setSectionCode(section.getSectionCode());
		target.setSectionName(section.getSectionName());
		target.setRemark(section.getRemark());
		target.setEnabled(section.getEnabled());
		target.setSectionInfo(section.getSectionInfo());
		target.setLastUpdate(section.getLastUpdate());

		session.save(target);
	}

	
}