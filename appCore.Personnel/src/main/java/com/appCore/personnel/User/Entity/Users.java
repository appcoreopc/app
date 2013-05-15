package com.appCore.personnel.User.Entity;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


	@Entity
	@Table(name = "Users")
	public class Users implements Serializable
	{

		@Id
		@GeneratedValue
		@Column(name = "Nid")
		private Integer nid;

		@Column(name = "CompanyId")
		private Integer companyId;
		
		
		@Column(name = "Username")
		private String username;

		
		@Column(name = "Password")
		private String password;

		
		@Column(name = "LastLogin")
		private Timestamp lastLogin;

		
		@Column(name = "Email")
		private String email;
		
		
		@Column(name = "FullName")
		private String fullName;

		
		public Integer getNid() { 
			return this.nid;
		}


		public void setNid(Integer nid) { 
			this.nid = nid;
		}

		public String getUsername() { 
			return this.username;
		}


		public void setUsername(String username) { 
			this.username = username;
		}

		public String getPassword() { 
			return this.password;
		}


		public void setPassword(String password) { 
			this.password = password;
		}

		public Timestamp getLastLogin() { 
			return this.lastLogin;
		}


		public void setLastLogin(Timestamp lastLogin) { 
			this.lastLogin = lastLogin;
		}
		
		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getFullName() {
			return fullName;
		}

		public void setFullName(String fullName) {
			this.fullName = fullName;
		}


		public Integer getCompanyId() {
			return companyId;
		}


		public void setCompanyId(Integer companyId) {
			this.companyId = companyId;
		}
			
	}