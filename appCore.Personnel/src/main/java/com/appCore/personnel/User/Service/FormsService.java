package com.appCore.personnel.User.Service;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.User.Entity.FormMenuView;
import com.appCore.personnel.User.Entity.Forms;
import com.appCore.personnel.User.Entity.Forms_Actions_Role;
import com.appCore.personnel.User.Entity.Category;


@Service("formsService")
@Transactional
public class FormsService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	public FormsService()
	{
		
	}
	
	public FormsService(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	public List<FormMenuView> getFormsMenu() 
	{	
		List<FormMenuView> result = new ArrayList<FormMenuView>();
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  Category");
		
		if (query.list().size() > 0)
		{
			List<Category> categories = (List<Category>) query.list();
			
			for	(Category category : categories)
			{
				FormMenuView element = new FormMenuView();
				element.setText(category.getCategoryName());
				
				List<FormMenuView> childMenus = getChildFormMenuItem(category.getNid(), session); 
				
				if (childMenus.size() > 0)
				{
					element.setItems(childMenus);
				}
				result.add(element);
			}
			
			return result;
		}
		return null;
	}
	
	private List<FormMenuView> getChildFormMenuItem(int id, Session session)
	{
		List<FormMenuView> result = new ArrayList<FormMenuView>();
		Query query = session.createQuery("FROM  Forms where category_nid = :nid");
		query.setParameter("nid", id);
		
		List<Forms> formsQuery = (List<Forms>) query.list(); 
		
		for (Forms form : formsQuery)
		{
			FormMenuView element = new FormMenuView();
			element.setText(form.getFormId());
			element.setLink(form.getLink());
			result.add(element);
		}
		return result;
	}	
	
	
	
	public List<Forms> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  Forms");

		return  query.list();
	}

	public Forms get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Forms forms = (Forms) session.get(Forms.class, id);

		return forms;
	}
	
	
	public Forms_Actions_Role get(String formId, Integer roleId) 
	{
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Forms where FormId = :formId");
		query.setParameter("formId", formId);

		List<Forms> forms = query.list();
		Integer formNid = -1;
		
		if (forms.size() > 0)
		{
			formNid = forms.get(0).getNid();
		
			Query forms_actions_role_query = session.createQuery("From Forms_Actions_Role where Forms_nid = :formsNid and Role_nid = :roleNid"); 
			forms_actions_role_query.setParameter("formsNid", formNid);
			forms_actions_role_query.setParameter("roleNid", roleId);
			List<Forms_Actions_Role> result = forms_actions_role_query.list();
			
			if (result.size() > 0)
				return result.get(0);
		}
		return null;
	}

	public void add(Forms forms) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(forms);
	}


	public void saveOrUpdate(Forms forms) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(forms);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Forms forms = (Forms) session.get(Forms.class, id);

		session.delete(forms);
	}

	public void edit(Forms forms) 
	{
		Session session = sessionFactory.getCurrentSession();
		Forms target = (Forms) session.get(Forms.class, forms.getNid());

		target.setNid(forms.getNid());
		target.setFormId(forms.getFormId());
		target.setDisabled(forms.getDisabled());
		target.setLastUpdate(forms.getLastUpdate());

		session.save(target);
	}
}