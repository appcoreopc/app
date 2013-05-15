package com.appCore.personnel.User.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Resource;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.Requests.UserAuthenticationRequestStatus;
import com.appCore.personnel.Core.Entity.Branch;
import com.appCore.personnel.Core.Entity.Company;
import com.appCore.personnel.Core.Service.CompanyService;
import com.appCore.personnel.User.Entity.Roles;
import com.appCore.personnel.User.Entity.UserLandingPage;
import com.appCore.personnel.User.Entity.UserProfileConfiguration;
import com.appCore.personnel.User.Entity.Users;

@Service("usersService")
@Transactional
public class UsersService // implements UserRoleService 
{

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	@Resource(name="userProfileConfigurationService")
	private UserProfileConfigurationService userProfileService;
	
	@Resource(name = "userLandingPageService")
	private UserLandingPageService userLandingservice;
		
	@Resource(name = "companyService")
	private CompanyService companyService;
	
	public UsersService() {

	}

	public UsersService(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Users> getAll() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  Users");

		return query.list();
	}
	
	public List<Users> getAllByCompany(Integer id) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  Users WHERE CompanyId = :id");
		query.setParameter("id", id);
		return query.list();
		
	}

	public Users get(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Users users = (Users) session.get(Users.class, id);

		return users;
	}

	public List<Integer> getRole(Integer userId) {
		
		Session session = sessionFactory.getCurrentSession();
		Users employee = (Users) session.get(Users.class, userId);

		Query query = session.createSQLQuery("Select Role_Nid From UserRoleAssignment where user_nid = :userId").addScalar("Role_Nid", Hibernate.INTEGER);
		query.setParameter("userId", userId);

		List<Object> resultQuery = query.list();
		
		List<Integer> roleList = new ArrayList<Integer>(); 
			
		for (Iterator iterator = resultQuery.iterator(); iterator.hasNext();) {

			Object object = (Object) iterator.next();
			Integer roleId = (Integer) (object);
			roleList.add(roleId);
		}
		return roleList;
	}
	
	public List<Integer> getRoleByUsername(String username) {
		
		Session session = sessionFactory.getCurrentSession();
		Query userQuery = session.createQuery("FROM  Users where Username = :username");
		userQuery.setParameter("username", username);

		List<Users> userList = userQuery.list();
		
		if (userList.size() > 0)
		{
			Users usr = userList.get(0);
			int userId = usr.getNid();
		
			Query query = session.createSQLQuery(
							"Select Roles_Nid From userrole_assignment where assignedUsers_Nid = :userId")
					.addScalar("Roles_Nid", Hibernate.INTEGER);
			query.setParameter("userId", userId);

			List<Object> resultQuery = query.list();
		
			List<Integer> roleList = new ArrayList<Integer>();
			
			for (Object object : resultQuery) {
			 roleList.add((Integer) object);
			}
			
			return roleList;
			
		}
		return null;
	}
	
	
	public List<Users> get(String username, String password) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("From Users where username = :username AND password = :password");
		query.setParameter("username", username);
		query.setParameter("password", password);
		return query.list();
	}
	
	
	public UserAuthenticationRequestStatus authenticateUser(String username, String password)
	{
		UserAuthenticationRequestStatus statusResponse = new UserAuthenticationRequestStatus();
		statusResponse.setMessageCode(-1);
		statusResponse.setMessageDescription("Login fails");
		
		List<Users> userVerificationResult = this.get(username, password);
		
		if (userVerificationResult.size() > 0) {
			
			List<Integer> roleList = this.getRole(userVerificationResult.get(0).getNid());
			int[] roles = ArrayUtils.toPrimitive(roleList.toArray(new Integer[roleList.size()]));
			statusResponse.setRoles(roles);
			Users userFromStore = userVerificationResult.get(0);
			
			statusResponse.setUsername(username);
			statusResponse.setMessageCode(0);
			statusResponse.setMessageDescription("User logins successfully.");
			
			List<UserProfileConfiguration> userProfile = userProfileService.getByUserId(userFromStore.getNid());
			
			if (userProfile.size() > 0)	
			{
				int companyId = userProfile.get(0).getDefaultCompanyId();
				Company companyFromStore = companyService.get(companyId);
				
				if (companyFromStore != null)
				{
					statusResponse.setCompanyName(companyFromStore.getCompanyName());
				}
				statusResponse.setCompanyId(companyId);
			}
			
			List<UserLandingPage> userLandingData = userLandingservice.getByUserId(userFromStore.getNid());
			
			if (userLandingData.size() > 0) {
				UserLandingPage userLanding = userLandingData.get(0);
				statusResponse.setLandingPage(userLanding.getLandingPage());
			}
		}
		return statusResponse;
	}
	
	
	public boolean add(Users users) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("FROM Users where username = :username");
		query.setParameter("username", users.getUsername());

		if (query.list().size() == 0) {
			session.save(users);
			return true;
		} else
			return false;
	}

	public void saveOrUpdate(Users users) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(users);
	}

	public void delete(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Users users = (Users) session.get(Users.class, id);
		session.delete(users);
	}

	public void edit(Users users) {
		Session session = sessionFactory.getCurrentSession();
		Users target = (Users) session.get(Users.class, users.getNid());

		target.setNid(users.getNid());
		target.setUsername(users.getUsername());
		target.setPassword(users.getPassword());
		target.setLastLogin(users.getLastLogin());

		session.save(target);
	}
}