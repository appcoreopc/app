package com.appCore.personnel.Core.Job.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.Core.Job.Entity.AssociationMembershipType;

@Service("associationMembershipTypeService")
@Transactional
public class AssociationMembershipTypeService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<AssociationMembershipType> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  AssociationMembershipType");
		return  query.list();
	}

	
	public List<AssociationMembershipType> getAllByCompany(Integer id) {
	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  AssociationMembershipType WHERE CompanyRef = :id");
		query.setParameter("id", id);
		return  query.list();
	}
	
	public AssociationMembershipType get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		AssociationMembershipType associationMembershipType = (AssociationMembershipType) session.get(AssociationMembershipType.class, id);

		return associationMembershipType;
	}

	public void add(AssociationMembershipType associationMembershipType) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(associationMembershipType);
	}


	public void saveOrUpdate(AssociationMembershipType associationMembershipType) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(associationMembershipType);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		AssociationMembershipType associationMembershipType = (AssociationMembershipType) session.get(AssociationMembershipType.class, id);

		session.delete(associationMembershipType);
	}

	public void edit(AssociationMembershipType associationMembershipType) 
	{
		Session session = sessionFactory.getCurrentSession();
		AssociationMembershipType target = (AssociationMembershipType) session.get(AssociationMembershipType.class, associationMembershipType.getNid());

		target.setNid(associationMembershipType.getNid());
		target.setName(associationMembershipType.getName());
		target.setDescription(associationMembershipType.getDescription());
		target.setStartEffectiveDate(associationMembershipType.getStartEffectiveDate());
		target.setEndEffectiveDate(associationMembershipType.getEndEffectiveDate());
		target.setDisabled(associationMembershipType.getDisabled());
		target.setLastUpdate(associationMembershipType.getLastUpdate());

		session.save(target);
	}

	
}