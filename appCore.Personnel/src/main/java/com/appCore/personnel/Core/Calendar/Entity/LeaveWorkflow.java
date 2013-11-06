package com.appCore.personnel.Core.Calendar.Entity;

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
@Table(name = "LeaveWorkflow")
public class LeaveWorkflow implements Serializable
{
				
		@Id
		@GeneratedValue 
		@Column(name = "Nid")
		private Integer nid;
						
				
		@Column(name = "Name")
		private String name;
						
		@Column(name = "CompanyId")
		private Integer companyId;
		
		
		@Column(name = "Description")
		private String description;
						
				
		@Column(name = "StartEffectiveDate")
		private Timestamp startEffectiveDate;
						
				
		@Column(name = "EndEffectiveDate")
		private Timestamp endEffectiveDate;
						
				
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
						
		public Timestamp getLastUpdate() 
		{ 
			return this.lastUpdate;
		}
				
		public void setLastUpdate(Timestamp lastUpdate) 
		{ 
			this.lastUpdate = lastUpdate;
		}

		public Integer getCompanyId() {
			return companyId;
		}

		public void setCompanyId(Integer companyId) {
			this.companyId = companyId;
		}
					
}

