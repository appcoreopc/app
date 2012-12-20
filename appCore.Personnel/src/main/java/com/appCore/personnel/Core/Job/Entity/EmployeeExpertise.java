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
	@Table(name = "EmployeeExpertise")
	public class EmployeeExpertise implements Serializable
	{

		@Id
		@GeneratedValue
		
		@Column(name = "Nid")
		private Integer nid;

		
		
		@Column(name = "Industry")
		private Integer industry;

		
		
		@Column(name = "Specialty")
		private Integer specialty;

		
		
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

		
		
		@Column(name = "LastUpdate")
		private Timestamp lastUpdate;


		public Integer getNid() { 
			return this.nid;
		}


		public void setNid(Integer nid) { 
			this.nid = nid;
		}

		public Integer getIndustry() { 
			return this.industry;
		}


		public void setIndustry(Integer industry) { 
			this.industry = industry;
		}

		public Integer getSpecialty() { 
			return this.specialty;
		}


		public void setSpecialty(Integer specialty) { 
			this.specialty = specialty;
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

		public Integer getPeriod() { 
			return this.period;
		}


		public void setPeriod(Integer period) { 
			this.period = period;
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