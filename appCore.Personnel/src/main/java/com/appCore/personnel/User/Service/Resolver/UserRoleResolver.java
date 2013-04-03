package com.appCore.personnel.User.Service.Resolver;

import java.util.List;

import com.appCore.personnel.User.Service.UserRoleService;


/*  
 *  UserRoleResolver helps to resolve user role. A role that is the higest always take precedence  
 *  over lower role. 
 *  
 *  A role can be considered a user group; that is given access to resources such as forms here. 
 */
public class UserRoleResolver implements RoleResolver {
	
	UserRoleService userRoleService; 
	
	public UserRoleResolver(UserRoleService service)
	{
		userRoleService = service; 
	}
	
	// 
	// formId is the id of resource 
	public int getRoleByUserName(String username, int formId)
	{
		List<Integer> rolesConfigured = userRoleService.getRoleByUsername(username);
		
		// look for a match between role and resource id;
		// typically means querying Forms_Actions_Role table 
		
		
		
		return -1;
	}
	
}
