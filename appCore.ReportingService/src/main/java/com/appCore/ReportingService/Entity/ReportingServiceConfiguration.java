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
@Table(name = "ReportingServiceConfiguration")
public class ReportingServiceConfiguration implements Serializable
{
						
				
		@Id
		@GeneratedValue 
		@Column(name = "Nid")
		private Integer nid;
						
				
		@Column(name = "CodePath")
		private String codePath;
						
				
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
						
		public String getCodePath() 
		{ 
			return this.codePath;
		}
				
		public void setCodePath(String codePath) 
		{ 
			this.codePath = codePath;
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
			
}

