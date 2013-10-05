package com.appCore.payroll.config.Entity;

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
@Table(name = "PayrollScript")
public class PayrollScript implements Serializable
{						
				
		@Id
		@GeneratedValue 
		@Column(name = "Nid")
		private Integer nid;
						
				
		@Column(name = "Name")
		private String name;
		
		@Column(name = "CompanyId")
		private String companyId;
						
				
		@Column(name = "Description")
		private String description;
						
				
		@Column(name = "ScriptPath")
		private String scriptPath;
						
				
		@Column(name = "LastUpdate")
		private Timestamp lastUpdate;
						
				
		@Column(name = "RefId")
		private Integer refId;
				
		
						
		public Integer getNid() 
		{ 
			return this.nid;
		}
				
		public void setNid(Integer nid) 
		{ 
			this.nid = nid;
		}				
						
		public String getName() 
		{ 
			return this.name;
		}
				
		public void setName(String name) 
		{ 
			this.name = name;
		}				
						
		public String getDescription() 
		{ 
			return this.description;
		}
				
		public void setDescription(String description) 
		{ 
			this.description = description;
		}				
						
		public String getScriptPath() 
		{ 
			return this.scriptPath;
		}
				
		public void setScriptPath(String scriptPath) 
		{ 
			this.scriptPath = scriptPath;
		}				
						
		public Timestamp getLastUpdate() 
		{ 
			return this.lastUpdate;
		}
				
		public void setLastUpdate(Timestamp lastUpdate) 
		{ 
			this.lastUpdate = lastUpdate;
		}				
						
		public Integer getRefId() 
		{ 
			return this.refId;
		}
				
		public void setRefId(Integer refId) 
		{ 
			this.refId = refId;
		}

		public String getCompanyId() {
			return companyId;
		}

		public void setCompanyId(String companyId) {
			this.companyId = companyId;
		}				
			
}

