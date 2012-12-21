package com.appCore.personnel.Core.Job.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.Core.Job.Entity.Gender;

@Service("genderService")
@Transactional
public class GenderService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<Gender> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  Gender");

		return  query.list();
	}

	public Gender get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Gender gender = (Gender) session.get(Gender.class, id);

		return gender;
	}

	public void add(Gender gender) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(gender);
	}


	public void saveOrUpdate(Gender gender) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(gender);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Gender gender = (Gender) session.get(Gender.class, id);

		session.delete(gender);
	}

	public void edit(Gender gender) 
	{
		Session session = sessionFactory.getCurrentSession();
		Gender target = (Gender) session.get(Gender.class, gender.getNid());

		target.setNid(gender.getNid());
		target.setName(gender.getName());
		target.setDescription(gender.getDescription());
		target.setStartEffectiveDate(gender.getStartEffectiveDate());
		target.setEndEffectiveDate(gender.getEndEffectiveDate());
		target.setDisabled(gender.getDisabled());
		target.setLastUpdate(gender.getLastUpdate());

		session.save(target);
	}
}