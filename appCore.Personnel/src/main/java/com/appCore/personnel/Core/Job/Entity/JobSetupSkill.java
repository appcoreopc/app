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
import java.util.List;
import javax.persistence.Table;



	@Entity
	@Table(name = "JobSetupSkill")
	public class JobSetupSkill implements Serializable
	{

		@Id
		@GeneratedValue
		
		@Column(name = "Nid")
		private Integer nid;

		
		
		@Column(name = "JobSetupRef")
		private Integer jobSetupRef;

		
		
		@Column(name = "Skill")
		private Integer skill;

		
		
		@Column(name = "Level")
		private Integer level;

		
		
		@Column(name = "Category")
		private Integer category;

		
		
		@Column(name = "CategoryDescription")
		private String categoryDescription;

		
		
		@Column(name = "Description")
		private String description;

		
		
		@Column(name = "StartEffectiveDate")
		private Timestamp startEffectiveDate;

		
		
		@Column(name = "EndEffectiveDate")
		private Timestamp endEffectiveDate;

		
		
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

		public Integer getJobSetupRef() { 
			return this.jobSetupRef;
		}


		public void setJobSetupRef(Integer jobSetupRef) { 
			this.jobSetupRef = jobSetupRef;
		}

		public Integer getSkill() { 
			return this.skill;
		}


		public void setSkill(Integer skill) { 
			this.skill = skill;
		}

		public Integer getLevel() { 
			return this.level;
		}


		public void setLevel(Integer level) { 
			this.level = level;
		}

		public Integer getCategory() { 
			return this.category;
		}


		public void setCategory(Integer category) { 
			this.category = category;
		}

		public String getCategoryDescription() { 
			return this.categoryDescription;
		}


		public void setCategoryDescription(String categoryDescription) { 
			this.categoryDescription = categoryDescription;
		}

		public String getDescription() { 
			return this.description;
		}


		public void setDescription(String description) { 
			this.description = description;
		}

		public Timestamp getStartEffectiveDate() { 
			return this.startEffectiveDate;
		}


		public void setStartEffectiveDate(Timestamp startEffectiveDate) { 
			this.startEffectiveDate = startEffectiveDate;
		}

		public Timestamp getEndEffectiveDate() { 
			return this.endEffectiveDate;
		}


		public void setEndEffectiveDate(Timestamp endEffectiveDate) { 
			this.endEffectiveDate = endEffectiveDate;
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