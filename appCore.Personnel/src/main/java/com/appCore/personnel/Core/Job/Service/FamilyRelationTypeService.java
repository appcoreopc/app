package com.appCore.personnel.Core.Job.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.Core.Job.Entity.FamilyRelationType;

@Service("familyRelationTypeService")
@Transactional
public class FamilyRelationTypeService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<FamilyRelationType> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  FamilyRelationType");

		return  query.list();
	}

	public FamilyRelationType get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		FamilyRelationType familyRelationType = (FamilyRelationType) session.get(FamilyRelationType.class, id);

		return familyRelationType;
	}

	public void add(FamilyRelationType familyRelationType) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(familyRelationType);
	}


	public void saveOrUpdate(FamilyRelationType familyRelationType) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(familyRelationType);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		FamilyRelationType familyRelationType = (FamilyRelationType) session.get(FamilyRelationType.class, id);

		session.delete(familyRelationType);
	}

	public void edit(FamilyRelationType familyRelationType) 
	{
		Session session = sessionFactory.getCurrentSession();
		FamilyRelationType target = (FamilyRelationType) session.get(FamilyRelationType.class, familyRelationType.getNid());

		target.setNid(familyRelationType.getNid());
		target.setName(familyRelationType.getName());
		target.setDescription(familyRelationType.getDescription());
		target.setStartEffectiveDate(familyRelationType.getStartEffectiveDate());
		target.setEndEffectiveDate(familyRelationType.getEndEffectiveDate());
		target.setDisabled(familyRelationType.getDisabled());
		target.setLastUpdate(familyRelationType.getLastUpdate());

		session.save(target);
	}
}