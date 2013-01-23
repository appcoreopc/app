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
	@Table(name = "JobSetupQualification")
	public class JobSetupQualification implements Serializable
	{

		@Id
		@GeneratedValue
		
		@Column(name = "Nid")
		private Integer nid;

		
		
		@Column(name = "JobSetupRef")
		private Integer jobSetupRef;

		
		
		@Column(name = "Level")
		private Integer level;

		
		
		@Column(name = "Description")
		private String description;

		
		
		@Column(name = "FieldOfStudy")
		private Integer fieldOfStudy;

		
		
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

		public Integer getLevel() { 
			return this.level;
		}


		public void setLevel(Integer level) { 
			this.level = level;
		}

		public String getDescription() { 
			return this.description;
		}


		public void setDescription(String description) { 
			this.description = description;
		}

		public Integer getFieldOfStudy() { 
			return this.fieldOfStudy;
		}


		public void setFieldOfStudy(Integer fieldOfStudy) { 
			this.fieldOfStudy = fieldOfStudy;
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