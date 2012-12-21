package com.appCore.personnel.Core.Job.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.Core.Job.Entity.EmployeeAssociation;

@Service("associationService")
@Transactional
public class AssociationService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<EmployeeAssociation> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  Association");

		return  query.list();
	}

	public EmployeeAssociation get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		EmployeeAssociation association = (EmployeeAssociation) session.get(EmployeeAssociation.class, id);

		return association;
	}

	public void add(EmployeeAssociation association) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(association);
	}


	public void saveOrUpdate(EmployeeAssociation association) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(association);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		EmployeeAssociation association = (EmployeeAssociation) session.get(EmployeeAssociation.class, id);

		session.delete(association);
	}

	public void edit(EmployeeAssociation association) 
	{
		Session session = sessionFactory.getCurrentSession();
		EmployeeAssociation target = (EmployeeAssociation) session.get(EmployeeAssociation.class, association.getNid());

		target.setNid(association.getNid());
		target.setName(association.getName());
		target.setDescription(association.getDescription());
		target.setAssociationType(association.getAssociationType());
		target.setStartEffectiveDate(association.getStartEffectiveDate());
		target.setEndEffectiveDate(association.getEndEffectiveDate());
		target.setDisabled(association.getDisabled());
		target.setLastUpdate(association.getLastUpdate());

		session.save(target);
	}
}