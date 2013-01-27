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
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import java.util.Date;
import java.util.List;
import javax.persistence.Table;

import org.hibernate.annotations.GenerationTime;

import com.appCore.personnel.Core.Entity.BranchInfo;



	@Entity
	@Table(name = "Branch")
	public class Branch implements Serializable
	{

		@Id
		@GeneratedValue
		@Column(name = "Nid")
		private Integer nid;
		
		@Column(name = "CompanyId")
		private Integer companyId;

		
		@Column(name = "BranchCode")
		private String branchCode;
		
		
		@Column(name = "BranchName")
		private String branchName;
		
		
		@Column(name = "Description")
		private String description;

		
		@Transient
		private List<BranchInfo> branchInfo;
		
		@Column(name = "Disabled")
		private Boolean disabled;
				
		@Temporal(TemporalType.TIMESTAMP)
		@org.hibernate.annotations.Generated(value=GenerationTime.ALWAYS)
		@Column(name = "LastUpdate")
		private Date lastUpdate;

		
		@Transient
		List<Division> divisionList;
		
		
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

		
		public String getBranchCode() { 
			return this.branchCode;
		}


		public void setBranchCode(String branchCode) { 
			this.branchCode = branchCode;
		}

		public String getBranchName() { 
			return this.branchName;
		}


		public void setBranchName(String branchName) { 
			this.branchName = branchName;
		}

		public String getDescription() { 
			return this.description;
		}


		public void setDescription(String description) { 
			this.description = description;
		}

		public List<BranchInfo> getBranchInfo() { 
			return this.branchInfo;
		}


		public void setBranchInfo(List<BranchInfo> branchInfo) { 
			this.branchInfo = branchInfo;
		}

		public Boolean getDisabled() { 
			return this.disabled;
		}
		
		public void setDisabled(Boolean enabled) { 
			this.disabled = enabled;
		}

		 @PreUpdate
		 protected void onUpdate() 
		 {
			 this.lastUpdate = new Date();
		 }

		public Date getLastUpdate() { 
			return this.lastUpdate;
		}

		public void setLastUpdate(Date lastUpdate) { 
			this.lastUpdate = lastUpdate;
		}
		
		
		public List<Division> getDivisionList() {
			return divisionList;
		}

		
		public void setDivisionList(List<Division> divisionList) {
			this.divisionList = divisionList;
		}

		
	}