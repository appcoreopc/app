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
import com.appCore.personnel.Core.Job.Entity.EmployeeQualification;
import com.appCore.personnel.Core.Job.Entity.EmployeeExperience;
import com.appCore.personnel.Core.Job.Entity.EmployeeSkill;


	@Entity
	@Table(name = "JobType")
	public class JobType implements Serializable
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


		@Column(name = "JobTitle")
		private String jobTitle;

		
		@Column(name = "JobCategory")
		private String jobCategory;
		
		
		@Column(name = "Description")
		private String description;

		
		//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
		//@JoinColumn(name="RefEntity")
		//private List<EmployeeQualification> qualification;

		
		//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
		//@JoinColumn(name="RefEntity")
		//@Transient
		//private List<EmployeeExperience> experience;

		
		//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
		//@JoinColumn(name="RefEntity")
		//@Transient
		//private List<EmployeeSkill> skill;

		
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

		public String getJobTitle() { 
			return this.jobTitle;
		}


		public void setJobTitle(String jobTitle) { 
			this.jobTitle = jobTitle;
		}

		public String getJobCategory() { 
			return this.jobCategory;
		}


		public void setJobCategory(String jobCategory) { 
			this.jobCategory = jobCategory;
		}

		public String getDescription() { 
			return this.description;
		}


		public void setDescription(String description) { 
			this.description = description;
		}

/*		public List<EmployeeQualification> getQualification() { 
			return this.qualification;
		}


		public void setQualification(List<EmployeeQualification> qualification) { 
			this.qualification = qualification;
		}

		public List<EmployeeExperience> getExperience() { 
			return this.experience;
		}


		public void setExperience(List<EmployeeExperience> experience) { 
			this.experience = experience;
		}

		public List<EmployeeSkill> getSkill() { 
			return this.skill;
		}


		public void setSkill(List<EmployeeSkill> skill) { 
			this.skill = skill;
		}
*/
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