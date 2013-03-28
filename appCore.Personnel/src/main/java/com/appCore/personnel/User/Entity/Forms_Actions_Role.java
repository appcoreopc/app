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
import javax.persistence.OneToOne;

import java.util.List;
import javax.persistence.Table;

	@Entity
	@Table(name = "Forms_Actions_Role")
	public class Forms_Actions_Role implements Serializable
	{

		@Id
		@GeneratedValue
		
		@Column(name = "Nid")
		private Integer nid;

		
		@Column(name = "Role_nid")
		private Integer role_nid;

		
		@Column(name = "Actions_nid")
		private Integer actions_nid;

		
		@Column(name = "Forms_nid")
		private Integer forms_nid;
		
		
		@Column(name = "Permission")
		private String permission;

		
		@Column(name = "Disabled")
		private Boolean disabled;

		
		@Column(name = "LastUpdate")
		private Timestamp lastUpdate;


		@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
		private Forms forms;
				
		
		public Integer getNid() { 
			return this.nid;
		}


		public void setNid(Integer nid) { 
			this.nid = nid;
		}

		public Integer getRole_nid() { 
			return this.role_nid;
		}


		public void setRole_nid(Integer role_nid) { 
			this.role_nid = role_nid;
		}

		public Integer getActions_nid() { 
			return this.actions_nid;
		}


		public void setActions_nid(Integer actions_nid) { 
			this.actions_nid = actions_nid;
		}

		
		public Integer getForms_nid() { 
			return this.forms_nid;
		}


		public void setForms_nid(Integer form_nid) { 
			this.forms_nid = form_nid;
		}
		
		
		public String getPermission() { 
			return this.permission;
		}


		public void setPermission(String permission) { 
			this.permission = permission;
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
		
		public Forms getForms() { 
			return this.forms;
		}

		public void setForms(Forms forms) { 
			this.forms= forms;
		}

	}