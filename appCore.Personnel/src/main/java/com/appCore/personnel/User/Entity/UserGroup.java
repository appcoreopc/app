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
	@Table(name = "UserGroup")
	public class UserGroup implements Serializable
	{

		@Id
		@GeneratedValue
		
		@Column(name = "Nid")
		private Integer nid;

		
		
		@Column(name = "User_nid")
		private Integer user_nid;

		
		
		@Column(name = "Group_nid")
		private Integer group_nid;

		
		
		@Column(name = "LastUpdate")
		private Timestamp lastUpdate;


		public Integer getNid() { 
			return this.nid;
		}


		public void setNid(Integer nid) { 
			this.nid = nid;
		}

		public Integer getUser_nid() { 
			return this.user_nid;
		}


		public void setUser_nid(Integer user_nid) { 
			this.user_nid = user_nid;
		}

		public Integer getGroup_nid() { 
			return this.group_nid;
		}


		public void setGroup_nid(Integer group_nid) { 
			this.group_nid = group_nid;
		}

		public Timestamp getLastUpdate() { 
			return this.lastUpdate;
		}


		public void setLastUpdate(Timestamp lastUpdate) { 
			this.lastUpdate = lastUpdate;
		}
	}