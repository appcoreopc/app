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
	@Table(name = "UserLanding")
	public class UserLanding implements Serializable
	{

		@Id
		@GeneratedValue
		
		@Column(name = "Nid")
		private Integer nid;
		
		@Column(name = "Enabled")
		private boolean enabled;
		
		@Column(name = "ApplicationType")
		private Integer applicationType;
		
		
		@Column(name = "UserId")
		private Integer userId;
		
		
		@Column(name = "ScriptId")
		private Integer scriptId;
		
		
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
		
		public Timestamp getLastUpdate() { 
			return this.lastUpdate;
		}


		public void setLastUpdate(Timestamp lastUpdate) { 
			this.lastUpdate = lastUpdate;
		}


		public Integer getScriptId() {
			return scriptId;
		}


		public void setScriptId(Integer scriptId) {
			this.scriptId = scriptId;
		}

		public boolean isEnabled() {
			return enabled;
		}

		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}


		public Integer getApplicationType() {
			return applicationType;
		}


		public void setApplicationType(Integer applicationType) {
			this.applicationType = applicationType;
		}

			
	}