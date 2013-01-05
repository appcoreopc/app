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
	@Table(name = "EmployeeQualification")
	public class EmployeeQualification implements Serializable
	{

		@Id
		@GeneratedValue
		@Column(name = "Nid")
		private Integer nid;

		
		@Column(name = "Level")
		private String level;

		
		@Column(name = "EmployeeRefId")
		private Integer employeeRefId;
						
		
		@Column(name = "Major")
		private String major;
		
		
		@Column(name = "Institution")
		private String institution;
		
		
		@Column(name = "LocalOrOversea")
		private boolean localOrOversea;
		
		
		@Column(name = "StartDate")
		private Timestamp startDate;
		
		@Column(name = "EndDate")
		private Timestamp endDate;
		
		@Column(name = "ResultCGPA")
		private String resultCGPA;
		
		
		@Column(name = "Attachment")
		private Timestamp attachment;
		
		
		@Column(name = "Remarks")
		private String remarks;
		
			
		@Column(name = "FieldOfStudy")
		private String fieldOfStudy;
		
		
		@Column(name = "LevelDescription")
		private String levelDescription;
		
		
		@Column(name = "FieldOfStudyDescription")
		private String fieldOfStudyDescription;
		
				
		@Column(name = "LastUpdate")
		private Timestamp lastUpdate;


		public Integer getNid() { 
			return this.nid;
		}


		public void setNid(Integer nid) { 
			this.nid = nid;
		}

		public String getLevel() { 
			return this.level;
		}


		public void setLevel(String level) { 
			this.level = level;
		}

		public String getFieldOfStudy() { 
			return this.fieldOfStudy;
		}


		public void setFieldOfStudy(String fieldOfStudy) { 
			this.fieldOfStudy = fieldOfStudy;
		}

		public String getLevelDescription() { 
			return this.levelDescription;
		}


		public void setLevelDescription(String levelDescription) { 
			this.levelDescription = levelDescription;
		}

		public String getFieldOfStudyDescription() { 
			return this.fieldOfStudyDescription;
		}


		public void setFieldOfStudyDescription(String fieldOfStudyDescription) { 
			this.fieldOfStudyDescription = fieldOfStudyDescription;
		}

		
		public Timestamp getLastUpdate() { 
			return this.lastUpdate;
		}


		public void setLastUpdate(Timestamp lastUpdate) { 
			this.lastUpdate = lastUpdate;
		}
		
		public Integer getEmployeeRefId() {
			return this.employeeRefId;
		}

		public void setEmployeeRefId(Integer employeeRefId) {
			this.employeeRefId = employeeRefId;
		}
		
		
		
		public String getMajor() {
			return major;
		}


		public void setMajor(String major) {
			this.major = major;
		}


		public String getInstitution() {
			return institution;
		}


		public void setInstitution(String institution) {
			this.institution = institution;
		}


		public boolean getLocalOrOversea() {
			return localOrOversea;
		}


		public void setLocalOrOversea(boolean localOrOversea) {
			this.localOrOversea = localOrOversea;
		}


		public Timestamp getStartDate() {
			return startDate;
		}


		public void setStartDate(Timestamp startDate) {
			this.startDate = startDate;
		}


		public Timestamp getEndDate() {
			return endDate;
		}


		public void setEndDate(Timestamp endDate) {
			this.endDate = endDate;
		}


		public String getResultCGPA() {
			return resultCGPA;
		}


		public void setResultCGPA(String resultCGPA) {
			this.resultCGPA = resultCGPA;
		}


		public Timestamp getAttachment() {
			return attachment;
		}


		public void setAttachment(Timestamp attachment) {
			this.attachment = attachment;
		}


		public String getRemarks() {
			return remarks;
		}

		public void setRemarks(String remarks) {
			this.remarks = remarks;
		}
		
		
		
	}