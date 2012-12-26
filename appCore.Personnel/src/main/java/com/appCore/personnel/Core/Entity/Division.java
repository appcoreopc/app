package com.appCore.personnel.Core.Entity;

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
import com.appCore.personnel.Core.Entity.DivisionInfo;

	@Entity
	@Table(name = "Division")
	public class Division implements Serializable
	{

		@Id
		@GeneratedValue
		@Column(name = "Nid")
		private Integer nid;
		
		@Column(name = "DivisionCode")
		private String divisionCode;
		
		@Column(name = "CompanyId")
		private Integer companyId;

		
		@Column(name = "DivisionName")
		private String divisionName;

		
		@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
		@JoinColumn(name="RefEntity")
		private List<DivisionInfo> divisionInfo;
		
		
		@Column(name = "Description")
		private String description;

		
		@Column(name = "Disabled")
		private Boolean disabled;

		
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
		
		public String getDivisionCode() { 
			return this.divisionCode;
		}
		public void setDivisionCode(String divisionCode) { 
			this.divisionCode = divisionCode;
		}

		public String getDivisionName() { 
			return this.divisionName;
		}


		public void setDivisionName(String divisionName) { 
			this.divisionName = divisionName;
		}

				
		public List<DivisionInfo> getDivisionInfo() { 
			return this.divisionInfo;
		}


		public void setDivisionInfo(List<DivisionInfo> divisionInfo) { 
			this.divisionInfo = divisionInfo;
		}
		
		
		public String getDescription() { 
			return this.description;
		}


		public void setDescription(String description) { 
			this.description = description;
		}

		public Boolean getDisabled() { 
			return this.disabled;
		}


		public void setDisabled(Boolean enabled) { 
			this.disabled = enabled;
		}

		public Timestamp getLastUpdate() { 
			return this.lastUpdate;
		}


		public void setLastUpdate(Timestamp lastUpdate) { 
			this.lastUpdate = lastUpdate;
		}
	}