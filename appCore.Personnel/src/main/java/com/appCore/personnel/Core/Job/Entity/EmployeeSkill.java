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
	@Table(name = "EmployeeSkill")
	public class EmployeeSkill implements Serializable
	{

		@Id
		@GeneratedValue
		@Column(name = "Nid")
		private Integer nid;
		
		
		@Column(name = "Skill")
		private String skill;

		@Column(name = "EmployeeRefId")
		private Integer employeeRefId;
		

		@Column(name = "SkillLevel")
		private Integer skillLevel;
		
		
		@Column(name = "Category")
		private String category;

		
		@Column(name = "RefEntity")
		private Integer refEntity;

		
		
		@Column(name = "Description")
		private String description;

		
		
		@Column(name = "CategoryDescription")
		private String categoryDescription;

		
		
		@Column(name = "LastUpdate")
		private Timestamp lastUpdate;


		public Integer getNid() { 
			return this.nid;
		}

		public void setNid(Integer nid) { 
			this.nid = nid;
		}

		public String getSkill() { 
			return this.skill;
		}


		public void setSkill(String skill) { 
			this.skill = skill;
		}

		public Integer getSkillLevel() { 
			return this.skillLevel;
		}


		public void setSkillLevel(Integer skillLevel) { 
			this.skillLevel = skillLevel;
		}

		public String getCategory() { 
			return this.category;
		}


		public void setCategory(String category) { 
			this.category = category;
		}

		public Integer getRefEntity() { 
			return this.refEntity;
		}


		public void setRefEntity(Integer refEntity) { 
			this.refEntity = refEntity;
		}

		public String getDescription() { 
			return this.description;
		}


		public void setDescription(String description) { 
			this.description = description;
		}

		public String getCategoryDescription() { 
			return this.categoryDescription;
		}


		public void setCategoryDescription(String categoryDescription) { 
			this.categoryDescription = categoryDescription;
		}

		public Timestamp getLastUpdate() { 
			return this.lastUpdate;
		}

		public void setLastUpdate(Timestamp lastUpdate) { 
			this.lastUpdate = lastUpdate;
		}
		
		public Integer getEmployeeRefId() {
			return employeeRefId;
		}

		public void setEmployeeRefId(Integer employeeRefId) {
			this.employeeRefId = employeeRefId;
		}

	}