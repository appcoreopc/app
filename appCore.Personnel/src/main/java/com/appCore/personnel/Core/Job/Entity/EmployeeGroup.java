package com.appCore.personnel.Core.Job.Entity;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import java.util.List;
import javax.persistence.Table;

import com.appCore.personnel.Core.Calendar.Entity.Holiday;



	@Entity
	@Table(name = "EmployeeGroup")
	public class EmployeeGroup implements Serializable
	{

		@Id
		@GeneratedValue
		
		@Column(name = "Nid")
		private Integer nid;

		
		
		@Column(name = "Name")
		private String name;

		
		@Column(name = "CompanyRef")
		private int companyRef;
		
		
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


		@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
		@JoinTable(name="EmployeeGroup_Assignment")
		private List<Employee> assignedEmployees;
		

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

		
		public int getCompanyRef() {
			return companyRef;
		}


		public void setCompanyRef(int companyRef) {
			this.companyRef = companyRef;
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

		
		public List<Employee> getAssignedEmployees() {
			return assignedEmployees;
		}


		public void setAssignedEmployees(List<Employee> assignedEmployees) {
			this.assignedEmployees = assignedEmployees;
		}

	}