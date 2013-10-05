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
@Table(name = "WorkPackage")
public class WorkPackage implements Serializable
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
		private Integer application;
						
				
		@Column(name = "Status")
		private Integer status;
						
				
		@Column(name = "setupType")
		private Integer setupType;
						
				
		@Column(name = "typeRefId")
		private Integer typeRefId;
						
				
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
						
		public Integer getApplication() 
		{ 
			return this.application;
		}
				
		public void setApplication(Integer application) 
		{ 
			this.application = application;
		}				
						
		public Integer getStatus() 
		{ 
			return this.status;
		}
				
		public void setStatus(Integer status) 
		{ 
			this.status = status;
		}				
						
		public Integer getsetupType() 
		{ 
			return this.setupType;
		}
				
		public void setsetupType(Integer setupType) 
		{ 
			this.setupType = setupType;
		}				
						
		public Integer gettypeRefId() 
		{ 
			return this.typeRefId;
		}
				
		public void settypeRefId(Integer typeRefId) 
		{ 
			this.typeRefId = typeRefId;
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
				
		public void setCompanyId(Integer companyId) 
		{ 
			this.companyId = companyId;
		}				
			
}

