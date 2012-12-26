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
import com.appCore.personnel.Core.Entity.SectionInfo;


	@Entity
	@Table(name = "Section")
	public class Section implements Serializable
	{

		@Id
		@GeneratedValue
		@Column(name = "Nid")
		private Integer nid;

		@Column(name = "DepartmentId")
		private Integer departmentId;

		
		@Column(name = "CompanyId")
		private Integer companyId;

		
		@Column(name = "SectionCode")
		private String sectionCode;
		
		
		@Column(name = "SectionName")
		private String sectionName;
		
		
		@Column(name = "Remark")
		private String remark;
		
		
		@Column(name = "Disabled")
		private Boolean disabled;
		
		
		@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
		@JoinColumn(name="RefEntity")
		private List<SectionInfo> sectionInfo;
		
			
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

		
		public Integer getDepartmentId() { 
			return this.departmentId;
		}

		public void setDepartmentId(Integer departmentId) { 
			this.departmentId = departmentId;
		}
		

		public String getSectionCode() { 
			return this.sectionCode;
		}


		public void setSectionCode(String sectionCode) { 
			this.sectionCode = sectionCode;
		}

		public String getSectionName() { 
			return this.sectionName;
		}


		public void setSectionName(String sectionName) { 
			this.sectionName = sectionName;
		}

		public String getRemark() { 
			return this.remark;
		}


		public void setRemark(String remark) { 
			this.remark = remark;
		}

		public Boolean getDisabled() { 
			return this.disabled;
		}


		public void setDisabled(Boolean enabled) { 
			this.disabled = enabled;
		}
		

		public List<SectionInfo> getSectionInfo() { 
			return this.sectionInfo;
		}


		public void setSectionInfo(List<SectionInfo> sectionInfo) { 
			this.sectionInfo = sectionInfo;
		}

		public Timestamp getLastUpdate() { 
			return this.lastUpdate;
		}


		public void setLastUpdate(Timestamp lastUpdate) { 
			this.lastUpdate = lastUpdate;
		}
	}