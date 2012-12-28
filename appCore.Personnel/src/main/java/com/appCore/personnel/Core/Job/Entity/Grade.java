package com.appCore.personnel.Core.Job.Entity;

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
import com.appCore.personnel.Core.Job.Entity.GradeInfo;



	@Entity
	@Table(name = "Grade")
	public class Grade implements Serializable
	{

		@Id
		@GeneratedValue
		@Column(name = "Nid")
		private Integer nid;
		
		
		@Column(name = "Code")
		private String code;

		@Column(name = "CompanyRef")
		private int companyRef;
		
		
		public int getCompanyRef() {
			return companyRef;
		}


		public void setCompanyRef(int companyRef) {
			this.companyRef = companyRef;
		}


		@Column(name = "Description")
		private String description;

		
		
		@Column(name = "Category")
		private String category;

		
		
		@Column(name = "ProbationMonth")
		private Integer probationMonth;

		
		//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
		//@JoinColumn(name="RefEntity")
		@Transient
		private List<GradeInfo> gradeInfo;
		
		
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

		public String getCode() { 
			return this.code;
		}


		public void setCode(String code) { 
			this.code = code;
		}

		public String getDescription() { 
			return this.description;
		}


		public void setDescription(String description) { 
			this.description = description;
		}

		public String getCategory() { 
			return this.category;
		}


		public void setCategory(String category) { 
			this.category = category;
		}

		public Integer getProbationMonth() { 
			return this.probationMonth;
		}


		public void setProbationMonth(Integer probationMonth) { 
			this.probationMonth = probationMonth;
		}

		public List<GradeInfo> getGradeInfo() { 
			return this.gradeInfo;
		}


		public void setGradeInfo(List<GradeInfo> gradeInfo) { 
			this.gradeInfo = gradeInfo;
		}

		public Boolean getDisabled() { 
			return this.disabled;
		}


		public void setDisabled(Boolean disabled) { 
			this.disabled = disabled;
		}

		public Timestamp getLastUpdate() { 
			return this.lastUpdate;
		}


		public void setLastUpdate(Timestamp lastUpdate) { 
			this.lastUpdate = lastUpdate;
		}
	}