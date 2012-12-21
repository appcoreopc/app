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
import javax.persistence.Transient;
import java.util.List;
import javax.persistence.Table;
import com.appCore.personnel.Core.Entity.DepartmentInfo;


	@Entity
	@Table(name = "Department")
	public class Department implements Serializable
	{

		@Id
		@GeneratedValue
		@Column(name = "Nid")
		private Integer nid;

		@Column(name = "CompanyId")
		private Integer companyId;
		
		
		@Column(name = "DivisionId")
		private Integer divisionId;
		
		@Column(name = "DepartmentCode")
		private String departmentCode;
		
		@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
		@JoinColumn(name="RefEntity")
		private List<DepartmentInfo> departmentInfo;
		
		@Transient
		private List<Section> section; 
		
		@Column(name = "DepartmentName")
		private String departmentName;
		
		
		@Column(name = "Remark")
		private String remark;

		
		@Column(name = "Enabled")
		private Boolean enabled;
		
		
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

		
		public List<Section> getSection() { 
			return this.section;
		}

		public void setSection(List<Section> section) { 
			this.section = section;
		}
		
		
		public Integer getDivisionId() { 
			return this.divisionId;
		}


		public void setDivisionId(Integer divisionId) { 
			this.divisionId = divisionId;
		}
		

		public String getDepartmentCode() { 
			return this.departmentCode;
		}


		public void setDepartmentCode(String departmentCode) { 
			this.departmentCode = departmentCode;
		}

		public List<DepartmentInfo> getDepartmentInfo() { 
			return this.departmentInfo;
		}


		public void setDepartmentInfo(List<DepartmentInfo> departmentInfo) { 
			this.departmentInfo = departmentInfo;
		}

		public String getDepartmentName() { 
			return this.departmentName;
		}


		public void setDepartmentName(String departmentName) { 
			this.departmentName = departmentName;
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
		
		public Timestamp getLastUpdate() { 
			return this.lastUpdate;
		}

		public void setLastUpdate(Timestamp lastUpdate) { 
			this.lastUpdate = lastUpdate;
		}
	}