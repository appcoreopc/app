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
	@Table(name = "ScriptWidget")
	public class ScriptWidget implements Serializable
	{

		@Id
		@GeneratedValue
		
		@Column(name = "Nid")
		private Integer nid;

		
		
		@Column(name = "CompanyId")
		private Integer companyId;

		
		
		@Column(name = "ScriptName")
		private String scriptName;

		
		
		@Column(name = "ScriptPath")
		private String scriptPath;

		
		
		@Column(name = "Description")
		private String description;

		
		
		@Column(name = "LastUpdate")
		private Timestamp lastUpdate;


		public Integer getNid() { 
			return this.nid;
		}


		public void setNid(Integer nid) { 
			this.nid = nid;
		}

		public Integer getCompanyId() { 
			return this.companyId;
		}


		public void setCompanyId(Integer companyId) { 
			this.companyId = companyId;
		}

		public String getScriptName() { 
			return this.scriptName;
		}


		public void setScriptName(String scriptName) { 
			this.scriptName = scriptName;
		}

		public String getScriptPath() { 
			return this.scriptPath;
		}


		public void setScriptPath(String scriptPath) { 
			this.scriptPath = scriptPath;
		}

		public String getDescription() { 
			return this.description;
		}


		public void setDescription(String description) { 
			this.description = description;
		}

		public Timestamp getLastUpdate() { 
			return this.lastUpdate;
		}


		public void setLastUpdate(Timestamp lastUpdate) { 
			this.lastUpdate = lastUpdate;
		}
	}