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

import com.appCore.personnel.Core.Entity.Branch;
import com.appCore.personnel.Core.Job.Entity.Employee;
import com.appCore.personnel.Core.Job.Entity.EmployeeGroup;
import com.appCore.personnel.User.Entity.Forms;
import com.appCore.personnel.User.Entity.Forms_Actions_Role;
import com.appCore.personnel.User.Entity.Roles;
import com.appCore.personnel.User.Entity.UserRoleAssignment;
import com.appCore.personnel.User.Entity.Users;

@Service("rolesService")
@Transactional
public class RolesService {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	public RolesService() {

	}

	public RolesService(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Roles> getAll() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  Roles");

		return query.list();
	}

	public List<Roles> getAllByCompany(Integer id) {

		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  Roles WHERE CompanyId = :id");
		query.setParameter("id", id);
		List<Roles> rolesResult = query.list();

		if (rolesResult.size() > 0) {
			
			for (Roles role : rolesResult) {
				List<Users> containingUserRole = getUserInRole(role);
				role.setUsers(containingUserRole);
				
				List<Forms> containingFormsRole = getFormsInRole(role); 
				role.setForms(containingFormsRole);
			}
		}
		return rolesResult;
	}
	
	private List<Forms> getFormsInRole(Roles role)
	{
		List<Forms> formList = new ArrayList<Forms>();
		Session session = sessionFactory.getCurrentSession();
		
		Query formsQuery = session.createQuery("FROM  Forms_Actions_Role WHERE Role_nid = :id");
		formsQuery.setParameter("id", role.getNid());
		
		List<Forms_Actions_Role> formResult = formsQuery.list();
		
		for (Forms_Actions_Role forms : formResult) {
			
			Forms formFound = (Forms) session.get(Forms.class, forms.getNid());
			if (formFound != null)
				formList.add(formFound);
		}
		
		return formList;
	}

	private List<Users> getUserInRole(Roles role) {
		
		List<Users> userList = new ArrayList<Users>();
		Session session = sessionFactory.getCurrentSession();

		Query userRoleAssignentQuery = session.createQuery("FROM  UserRoleAssignment WHERE Role_nid = :id");
		userRoleAssignentQuery.setParameter("id", role.getNid());
		
		List<UserRoleAssignment> assignmentResult = userRoleAssignentQuery.list();
			
		for (UserRoleAssignment userRoleAssignment : assignmentResult) 
		{	
				Users user = (Users) session.get(Users.class, userRoleAssignment.getUser_nid());
				if (user != null) 
					userList.add(user);
		}
		return userList;
	}

	public Roles get(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Roles roles = (Roles) session.get(Roles.class, id);
		return roles;
	}

	public boolean saveconfiguredRole(int employeeId, int groupId,
			boolean isGrantAccess) {
		Session session = sessionFactory.getCurrentSession();

		Roles userGroup = (Roles) session.get(Roles.class, groupId);
		Users employee = (Users) session.get(Users.class, employeeId);

		if (isGrantAccess) {
			UserRoleAssignment userRoleAssignment = new UserRoleAssignment();
			userRoleAssignment.setRole_nid(groupId);
			userRoleAssignment.setUser_nid(employeeId);
			userGroup.getAssignedUsers().add(userRoleAssignment);
		} else {
			userGroup.getAssignedUsers().remove(employee);
		}
		return true;

	}

	public void add(Roles roles) {
		Session session = sessionFactory.getCurrentSession();
		session.save(roles);
	}

	public void saveOrUpdate(Roles roles) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(roles);
	}

	public void delete(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Roles roles = (Roles) session.get(Roles.class, id);

		session.delete(roles);
	}

	public void edit(Roles roles) {
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