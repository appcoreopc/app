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
	@Table(name = "UserRoleAssignment")
	public class UserRoleAssignment implements Serializable
	{

		@Id
		@GeneratedValue
		@Column(name = "Nid")
		private Integer nid;

		
		@Column(name = "Role_nid")
		private Integer role_nid;

		
		@Column(name = "User_nid")
		private Integer user_nid;
		
		
		@Column(name = "Type")
		private String type;

		
		
		@Column(name = "LastUpdate")
		private Timestamp lastUpdate;


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

		public Integer getUser_nid() { 
			return this.user_nid;
		}


		public void setUser_nid(Integer user_nid) { 
			this.user_nid = user_nid;
		}

		public String getType() { 
			return this.type;
		}


		public void setType(String type) { 
			this.type = type;
		}

		public Timestamp getLastUpdate() { 
			return this.lastUpdate;
		}


		public void setLastUpdate(Timestamp lastUpdate) { 
			this.lastUpdate = lastUpdate;
		}
	}