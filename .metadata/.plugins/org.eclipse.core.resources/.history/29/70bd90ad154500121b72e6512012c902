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
	@Table(name = "EmployeeAssociation")
	public class EmployeeAssociation implements Serializable
	{

		@Id
		@GeneratedValue
		
		@Column(name = "Nid")
		private Integer nid;
		
		@Column(name = "Name")
		private String name;
		
		
		@Column(name = "Industry")
		private Integer industry;
				
		@Column(name = "Speciality")
		private Integer speciality;
		
		@Column(name = "StartDate")
		private Timestamp startDate;
		
		@Column(name = "EndDate")
		private Timestamp endDate;
		
		@Column(name = "Period")
		private Integer period;
		
		@Column(name = "Remarks")
		private String remarks;
		

		@Column(name = "EmployeeRefId")
		private Integer employeeRefId;
					
		@Column(name = "Description")
		private String description;
		
		
		@Column(name = "AssociationType")
		private String associationType;
		
		
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

		public String getName() { 
			return this.name;
		}


		public void setName(String name) { 
			this.name = name;
		}

		public String getDescription() { 
			return this.description;
		}


		public void setDescription(String description) { 
			this.description = description;
		}

		public String getAssociationType() { 
			return this.associationType;
		}


		public void setAssociationType(String associationType) { 
			this.associationType = associationType;
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
		
		
		public Integer getIndustry() {
			return industry;
		}


		public void setIndustry(Integer industry) {
			this.industry = industry;
		}


		public Integer getSpeciality() {
			return speciality;
		}


		public void setSpeciality(Integer speciality) {
			this.speciality = speciality;
		}


		public Timestamp getStartDate() {
			return startDate;
		}


		public void setStartDate(Timestamp startDate) {
			this.startDate = startDate;
		}


		public Timestamp getEndDate() {
			return this.endDate;
		}


		public void setEndDate(Timestamp endDate) {
			this.endDate = endDate;
		}


		public Integer getPeriod() {
			return period;
		}


		public void setPeriod(Integer period) {
			this.period = period;
		}


		public String getRemarks() {
			return remarks;
		}


		public void setRemarks(String remarks) {
			this.remarks = remarks;
		}
		
		public Integer getEmployeeRefId() {
			return employeeRefId;
		}

		public void setEmployeeRefId(Integer employeeRefId) {
			this.employeeRefId = employeeRefId;
		}



	}