package com.appCore.personnel.User.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.User.Entity.Category;

@Service("categoryService")
@Transactional
public class CategoryService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<Category> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  Category");

		return  query.list();
	}

	public Category get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Category category = (Category) session.get(Category.class, id);

		return category;
	}

	public void add(Category category) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(category);
	}


	public void saveOrUpdate(Category category) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(category);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Category category = (Category) session.get(Category.class, id);

		session.delete(category);
	}

	public void edit(Category category) 
	{
		Session session = sessionFactory.getCurrentSession();
		Category target = (Category) session.get(Category.class, category.getNid());

		target.setNid(category.getNid());
		target.setCategoryName(category.getCategoryName());
		target.setDescription(category.getDescription());
		target.setLastUpdate(category.getLastUpdate());

		session.save(target);
	}
}