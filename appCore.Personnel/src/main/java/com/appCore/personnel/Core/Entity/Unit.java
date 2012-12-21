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
import com.appCore.personnel.Core.Entity.UnitInfo;

	@Entity
	@Table(name = "Unit")
	public class Unit implements Serializable
	{

		@Id@GeneratedValue
		
		
		@Column(name = "Nid")
		private Integer nid;
		
		@Column(name = "CompanyId")
		private Integer companyId;

		@Column(name = "SectionId")
		private Integer sectionId;
	
		
		@Column(name = "UnitCode")
		private String unitCode;
		
				
		@Column(name = "UnitName")
		private String unitName;

		
		@Column(name = "Remark")
		private String remark;

		
		@Column(name = "Enabled")
		private Boolean enabled;

				
		@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
		@JoinColumn(name="RefEntity")
		private List<UnitInfo> unitInfo;
		
		
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
		
		public Integer getSectionId() { 
			return this.sectionId;
		}


		public void setSectionId(Integer sectionId) { 
			this.sectionId = sectionId;
		}

		
		public String getUnitCode() { 
			return this.unitCode;
		}


		public void setUnitCode(String unitCode) { 
			this.unitCode = unitCode;
		}

		public String getUnitName() { 
			return this.unitName;
		}


		public void setUnitName(String unitName) { 
			this.unitName = unitName;
		}

		public String getRemark() { 
			return this.remark;
		}


		public void setRemark(String remark) { 
			this.remark = remark;
		}

		public Boolean getEnabled() { 
			return this.enabled;
		}


		public void setEnabled(Boolean enabled) { 
			this.enabled = enabled;
		}


		public List<UnitInfo> getUnitInfo() { 
			return this.unitInfo;
		}


		public void setUnitInfo(List<UnitInfo> unitInfo) { 
			this.unitInfo = unitInfo;
		}

		public Timestamp getLastUpdate() { 
			return this.lastUpdate;
		}


		public void setLastUpdate(Timestamp lastUpdate) { 
			this.lastUpdate = lastUpdate;
		}
	}