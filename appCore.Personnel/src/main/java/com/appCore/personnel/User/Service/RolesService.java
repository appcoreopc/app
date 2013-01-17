package com.appCore.personnel.User.Service;

import java.util.Iterator;
import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.Core.Job.Entity.Employee;
import com.appCore.personnel.Core.Job.Entity.EmployeeGroup;
import com.appCore.personnel.User.Entity.Forms_Actions_Role;
import com.appCore.personnel.User.Entity.Roles;
import com.appCore.personnel.User.Entity.Users;

@Service("rolesService")
@Transactional
public class RolesService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;

	public RolesService()
	{
	
	}
	
	public RolesService(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	
	public List<Roles> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  Roles");
		return  query.list();
	}

	public List<Roles> getRoleByRights() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  Roles");
		List<Roles> roles = query.list(); 
		
		for (int i = 0; i < roles.size(); i++) {
			
			Roles currentRole = roles.get(i);
			Query actionFormRoleQuery = session.createQuery("FROM  Forms_Actions_Role WHERE Role_nid = :roleId");
			actionFormRoleQuery.setParameter("roleId", currentRole.getNid());
			List<Forms_Actions_Role> rights = actionFormRoleQuery.list();
		
			if (rights.size() > 0)
			{
				currentRole.setAssignedRights(rights);
			}
		}
		return  query.list();
	}
	
	
	
	public Roles get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Roles roles = (Roles) session.get(Roles.class, id);
		return roles;
	}
	
	
	public boolean saveconfiguredRole(int employeeId, int groupId, boolean isGrantAccess)
	{
		Session session = sessionFactory.getCurrentSession();
		Roles employeeGroup = (Roles) session.get(Roles.class, groupId);
		Users employee = (Users) session.get(Users.class, employeeId);
		
		if (isGrantAccess)
		{
			employeeGroup.getAssignedUsers().add(employee);
		}
		else 
		{
			employeeGroup.getAssignedUsers().remove(employee);
		}
		return true; 
		
	}


	public void add(Roles roles) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(roles);
	}


	public void saveOrUpdate(Roles roles) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(roles);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Roles roles = (Roles) session.get(Roles.class, id);

		session.delete(roles);
	}

	public void edit(Roles roles) 
	{
		Session session = sessionFactory.getCurrentSession();
		Roles target = (Roles) session.get(Roles.class, roles.getNid());

		target.setNid(roles.getNid());
		target.setRolename(roles.getRolename());
		target.setDescription(roles.getDescription());
		target.setDisabled(roles.getDisabled());
		target.setLastUpdate(roles.getLastUpdate());

		session.save(target);
	}
}