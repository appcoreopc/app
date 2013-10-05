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
@Table(name = "PayrollTableValue")
public class PayrollTableValue implements Serializable
{
						
				
		@Id
		@GeneratedValue 
		@Column(name = "Nid")
		private Integer nid;
						
				
		@Column(name = "start")
		private Integer start;
						
				
		@Column(name = "end")
		private Integer end;
						
				
		@Column(name = "setupType")
		private Integer setupType;
						
				
		@Column(name = "typeRefId")
		private Integer typeRefId;
						
				
		@Column(name = "DirectValue")
		private Integer directValue;
						
				
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
						
		public Integer getstart() 
		{ 
			return this.start;
		}
				
		public void setstart(Integer start) 
		{ 
			this.start = start;
		}				
						
		public Integer getend() 
		{ 
			return this.end;
		}
				
		public void setend(Integer end) 
		{ 
			this.end = end;
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
						
		public Integer getDirectValue() 
		{ 
			return this.directValue;
		}
				
		public void setDirectValue(Integer directValue) 
		{ 
			this.directValue = directValue;
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
				
		public void setCompanyId(Integer companyId) 
		{ 
			this.companyId = companyId;
		}				
			
}

