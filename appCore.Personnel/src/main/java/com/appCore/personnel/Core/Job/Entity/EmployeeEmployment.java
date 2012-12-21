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
	@Table(name = "EmployeeEmployment")
	public class EmployeeEmployment implements Serializable
	{
		@Id
		@GeneratedValue
		
		@Column(name = "Nid")
		private Integer nid;
		
		
		@Column(name = "EmployerName")
		private String employerName;
		
		
		@Column(name = "Job")
		private String job;
		
		
		@Column(name = "Industry")
		private Integer industry;

		
		
		@Column(name = "StartDate")
		private Timestamp startDate;

		
		
		@Column(name = "EndDate")
		private Timestamp endDate;

		
		
		@Column(name = "Duration")
		private Integer duration;

		
		
		@Column(name = "LastDrawnSalary")
		private Integer lastDrawnSalary;

		
		
		@Column(name = "ResignationReason")
		private String resignationReason;

		
		
		@Column(name = "Remarks")
		private String remarks;

		
		
		@Column(name = "EmployeeRefId")
		private Integer employeeRefId;

		
		
		@Column(name = "LastUpdate")
		private Timestamp lastUpdate;


		public Integer getNid() { 
			return this.nid;
		}


		public void setNid(Integer nid) { 
			this.nid = nid;
		}

		public String getEmployerName() { 
			return this.employerName;
		}


		public void setEmployerName(String employerName) { 
			this.employerName = employerName;
		}

		public String getJob() { 
			return this.job;
		}


		public void setJob(String job) { 
			this.job = job;
		}

		public Integer getIndustry() { 
			return this.industry;
		}


		public void setIndustry(Integer industry) { 
			this.industry = industry;
		}

		public Timestamp getStartDate() { 
			return this.startDate;
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

		public Integer getDuration() { 
			return this.duration;
		}


		public void setDuration(Integer duration) { 
			this.duration = duration;
		}

		public Integer getLastDrawnSalary() { 
			return this.lastDrawnSalary;
		}


		public void setLastDrawnSalary(Integer lastDrawnSalary) { 
			this.lastDrawnSalary = lastDrawnSalary;
		}

		public String getResignationReason() { 
			return this.resignationReason;
		}


		public void setResignationReason(String resignationReason) { 
			this.resignationReason = resignationReason;
		}

		public String getRemarks() { 
			return this.remarks;
		}


		public void setRemarks(String remarks) { 
			this.remarks = remarks;
		}

		public Integer getEmployeeRefId() { 
			return this.employeeRefId;
		}


		public void setEmployeeRefId(Integer employeeRefId) { 
			this.employeeRefId = employeeRefId;
		}

		public Timestamp getLastUpdate() { 
			return this.lastUpdate;
		}


		public void setLastUpdate(Timestamp lastUpdate) { 
			this.lastUpdate = lastUpdate;
		}
	}