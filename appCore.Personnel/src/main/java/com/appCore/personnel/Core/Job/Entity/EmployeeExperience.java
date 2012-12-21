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
	@Table(name = "EmployeeExperience")
	public class EmployeeExperience implements Serializable
	{

		@Id
		@GeneratedValue
		@Column(name = "Nid")
		private Integer nid;

		
		@Column(name = "Expertise")
		private String expertise;

		@Column(name = "EmployeeRefId")
		private Integer employeeRefId;
		
		@Column(name = "YearOfExpertise")
		private Integer yearOfExpertise;

		
		@Column(name = "ExpertiseDescription")
		private String expertiseDescription;

		
		@Column(name = "LastUpdate")
		private Timestamp lastUpdate;


		public Integer getNid() { 
			return this.nid;
		}


		public void setNid(Integer nid) { 
			this.nid = nid;
		}

		public String getExpertise() { 
			return this.expertise;
		}


		public void setExpertise(String expertise) { 
			this.expertise = expertise;
		}

		public Integer getYearOfExpertise() { 
			return this.yearOfExpertise;
		}


		public void setYearOfExpertise(Integer yearOfExpertise) { 
			this.yearOfExpertise = yearOfExpertise;
		}

		public String getExpertiseDescription() { 
			return this.expertiseDescription;
		}


		public void setExpertiseDescription(String expertiseDescription) { 
			this.expertiseDescription = expertiseDescription;
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