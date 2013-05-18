package com.appCore.personnel.User.Entity;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Transient;

import java.util.List;
import javax.persistence.Table;

import com.appCore.personnel.Core.Job.Entity.Employee;


	@Entity
	@Table(name = "Roles")
	public class Roles implements Serializable
	{

		@Id
		@GeneratedValue
		
		@Column(name = "Nid")
		private Integer nid;

		@Column(name = "CompanyId")
		private Integer companyId;
		
		
		@Column(name = "Rolename")
		private String rolename;
		
		
		@Column(name = "Description")
		private String description;

		
		@Column(name = "Disabled")
		private Boolean disabled;
		
		@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
		private List<UserRoleAssignment> assignedUsers;
		
		
		@Transient
		private List<Users> users;
		
		@Transient
		private List<Forms> forms;
		
		
		@Column(name = "LastUpdate")
		private Timestamp lastUpdate;


		public Integer getNid() { 
			return this.nid;
		}


		public void setNid(Integer nid) { 
			this.nid = nid;
		}

		public String getRolename() { 
			return this.rolename;
		}


		public void setRolename(String rolename) { 
			this.rolename = rolename;
		}

		public String getDescription() { 
			return this.description;
		}


		public void setDescription(String description) { 
			this.description = description;
		}

		public Boolean getDisabled() { 
			return this.disabled;
		}


		public void setDisabled(Boolean disabled) { 
			this.disabled = disabled;
		}

		public Timestamp getLastUpdate() { 
			return this.lastUpdate;
		}


		public void setLastUpdate(Timestamp lastUpdate) { 
			this.lastUpdate = lastUpdate;
		}
		
		public List<UserRoleAssignment> getAssignedUsers() {
			return assignedUsers;
		}


		public void setAssignedUsers(List<UserRoleAssignment> assignedUsers) {
			this.assignedUsers = assignedUsers;
		}


		public Integer getCompanyId() {
			return companyId;
		}


		public void setCompanyId(Integer companyId) {
			this.companyId = companyId;
		}


		public List<Users> getUsers() {
			return users;
		}


		public void setUsers(List<Users> users) {
			this.users = users;
		}


		public List<Forms> getForms() {
			return forms;
		}


		public void setForms(List<Forms> forms) {
			this.forms = forms;
		}
		
	}