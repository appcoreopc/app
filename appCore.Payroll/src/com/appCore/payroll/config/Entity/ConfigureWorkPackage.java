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
@Table(name = "ConfigureWorkPackage")
public class ConfigureWorkPackage implements Serializable
{
						
				
		@Id
		@GeneratedValue 
		@Column(name = "Nid")
		private Integer nid;
						
				
		@Column(name = "Name")
		private String name;
						
				
		@Column(name = "Description")
		private String description;
						
				
		@Column(name = "CompanyId")
		private Integer companyId;
						
				
		@Column(name = "Status")
		private Integer status;
						
				
		@Column(name = "WorkPackageId")
		private Integer workPackageId;
						
				
		@Column(name = "TargetType")
		private Integer targetType;
						
				
		@Column(name = "TargetId")
		private Integer targetId;
						
				
		@Column(name = "LastUpdate")
		private Timestamp lastUpdate;
				
		
						
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
						
		public Integer getCompanyId() 
		{ 
			return this.companyId;
		}
				
		public void setCompanyId(Integer companyId) 
		{ 
			this.companyId = companyId;
		}				
						
		public Integer getStatus() 
		{ 
			return this.status;
		}
				
		public void setStatus(Integer status) 
		{ 
			this.status = status;
		}				
						
		public Integer getWorkPackageId() 
		{ 
			return this.workPackageId;
		}
				
		public void setWorkPackageId(Integer workPackageId) 
		{ 
			this.workPackageId = workPackageId;
		}				
						
		public Integer getTargetType() 
		{ 
			return this.targetType;
		}
				
		public void setTargetType(Integer targetType) 
		{ 
			this.targetType = targetType;
		}				
						
		public Integer getTargetId() 
		{ 
			return this.targetId;
		}
				
		public void setTargetId(Integer targetId) 
		{ 
			this.targetId = targetId;
		}				
						
		public Timestamp getLastUpdate() 
		{ 
			return this.lastUpdate;
		}
				
		public void setLastUpdate(Timestamp lastUpdate) 
		{ 
			this.lastUpdate = lastUpdate;
		}				
			
}

