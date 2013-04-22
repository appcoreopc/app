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
	@Table(name = "UserProfileConfiguration")
	public class UserProfileConfiguration implements Serializable
	{

		@Id
		@GeneratedValue
		
		@Column(name = "Nid")
		private Integer nid;

		
		
		@Column(name = "UserId")
		private Integer userId;

		
		
		@Column(name = "DefaultCompanyId")
		private Integer defaultCompanyId;

		
		
		@Column(name = "DefaultLanguage")
		private Integer defaultLanguage;

		
		
		@Column(name = "LastUpdate")
		private Timestamp lastUpdate;


		public Integer getNid() { 
			return this.nid;
		}


		public void setNid(Integer nid) { 
			this.nid = nid;
		}

		public Integer getUserId() { 
			return this.userId;
		}


		public void setUserId(Integer userId) { 
			this.userId = userId;
		}

		public Integer getDefaultCompanyId() { 
			return this.defaultCompanyId;
		}


		public void setDefaultCompanyId(Integer defaultCompanyId) { 
			this.defaultCompanyId = defaultCompanyId;
		}

		public Integer getDefaultLanguage() { 
			return this.defaultLanguage;
		}


		public void setDefaultLanguage(Integer defaultLanguage) { 
			this.defaultLanguage = defaultLanguage;
		}

		public Timestamp getLastUpdate() { 
			return this.lastUpdate;
		}


		public void setLastUpdate(Timestamp lastUpdate) { 
			this.lastUpdate = lastUpdate;
		}
	}