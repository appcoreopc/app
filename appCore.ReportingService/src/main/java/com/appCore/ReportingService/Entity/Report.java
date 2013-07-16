package com.appCore.reportingService.Entity;

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
@Table(name = "Report")
public class Report implements Serializable
{
										
		@Id
		@GeneratedValue 
		@Column(name = "Nid")
		private Integer nid;
					
				
		@Column(name = "ResourceId")
		private Integer resourceId;
		
		@Column(name = "CompanyRef")
		private Integer companyRef;
						
				
		@Column(name = "ReportLogicScript")
		private String reportLogicScript;
				
		
		@Column(name = "Name")
		private String name;
						
				
		@Column(name = "Title")
		private String title;
						
				
		@Column(name = "OutputFormat")
		private String outputFormat;
						
				
		@Column(name = "ReportScript")
		private String reportScript;
						
				
		@Column(name = "StartEffectiveDate")
		private Timestamp startEffectiveDate;
						
				
		@Column(name = "EndEffectiveDate")
		private Timestamp endEffectiveDate;
						
				
		@Column(name = "Disabled")
		private Boolean disabled;
						
				
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
						
		public Integer getResourceId() 
		{ 
			return this.resourceId;
		}
				
		public void setResourceId(Integer resourceId) 
		{ 
			this.resourceId = resourceId;
		}				
						
		public String getReportLogicScript() 
		{ 
			return this.reportLogicScript;
		}
				
		public void setReportLogicScript(String reportLogicScript) 
		{ 
			this.reportLogicScript = reportLogicScript;
		}				
						
		public String getName() 
		{ 
			return this.name;
		}
				
		public void setName(String name) 
		{ 
			this.name = name;
		}				
						
		public String getTitle() 
		{ 
			return this.title;
		}
				
		public void setTitle(String title) 
		{ 
			this.title = title;
		}				
						
		public String getOutputFormat() 
		{ 
			return this.outputFormat;
		}
				
		public void setOutputFormat(String outputFormat) 
		{ 
			this.outputFormat = outputFormat;
		}				
						
		public String getReportScript() 
		{ 
			return this.reportScript;
		}
				
		public void setReportScript(String reportScript) 
		{ 
			this.reportScript = reportScript;
		}				
						
		public Timestamp getStartEffectiveDate() 
		{ 
			return this.startEffectiveDate;
		}
				
		public void setStartEffectiveDate(Timestamp startEffectiveDate) 
		{ 
			this.startEffectiveDate = startEffectiveDate;
		}				
						
		public Timestamp getEndEffectiveDate() 
		{ 
			return this.endEffectiveDate;
		}
				
		public void setEndEffectiveDate(Timestamp endEffectiveDate) 
		{ 
			this.endEffectiveDate = endEffectiveDate;
		}				
						
		public Boolean getDisabled() 
		{ 
			return this.disabled;
		}
				
		public void setDisabled(Boolean disabled) 
		{ 
			this.disabled = disabled;
		}				
						
		public Timestamp getLastUpdate() 
		{ 
			return this.lastUpdate;
		}
				
		public void setLastUpdate(Timestamp lastUpdate) 
		{ 
			this.lastUpdate = lastUpdate;
		}

		public Integer getCompanyRef() {
			return companyRef;
		}

		public void setCompanyRef(Integer companyRef) {
			this.companyRef = companyRef;
		}				
			
}

