package com.appCore.personnel.User.Entity;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import java.util.List;
import javax.persistence.Table;



	@Entity
	@Table(name = "UserLandingPage")
	public class UserLandingPage implements Serializable
	{

		@Id
		@GeneratedValue
		
		@Column(name = "Nid")
		private Integer nid;
		
		
		@Column(name = "UserId")
		private String userId;

		
		@Column(name = "LandingPage")
		private String landingPage;		
		
		@Column(name = "LastLogin")
		private Timestamp lastLogin;


		public Integer getNid() { 
			return this.nid;
		}


		public void setNid(Integer nid) { 
			this.nid = nid;
		}

		public String getUserId() { 
			return this.userId;
		}


		public void setUserId(String userId) { 
			this.userId = userId;
		}

		public String getLandingPage() { 
			return this.landingPage;
		}


		public void setLandingPage(String landingPage) { 
			this.landingPage = landingPage;
		}

		public Timestamp getLastLogin() { 
			return this.lastLogin;
		}


		public void setLastLogin(Timestamp lastLogin) { 
			this.lastLogin = lastLogin;
		}
	}