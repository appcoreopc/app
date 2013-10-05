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
@Table(name = "PayrollTable")
public class PayrollTable implements Serializable
{
						
				
		@Id
		@GeneratedValue 
		@Column(name = "Nid")
		private Integer nid;
						
				
		@Column(name = "Name")
		private String name;
						
				
		@Column(name = "Description")
		private String description;
						
				
		@Column(name = "Application")
		private String application;
						
				
		@Column(name = "LastUpdate")
		private Timestamp lastUpdate;
						
				
		@Column(name = "CompanyId")
		private Integer companyId;
				
		
						
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
						
		public String getApplication() 
		{ 
			return this.application;
		}
		
		public void setApplication(String application) 
		{ 
			this.application = application;
		}				
						
		public Timestamp getLastUpdate() 
		{ 
			return this.lastUpdate;
		}
				
		public void setLastUpdate(Timestamp lastUpdate) 
		{ 
			this.lastUpdate = lastUpdate;
		}				
						
		public Integer getCompanyId() 
		{ 
			return this.companyId;
		}
				
		public void setCompanyId(Integer refId) 
		{ 
			this.companyId = refId;
		}				
			
}

