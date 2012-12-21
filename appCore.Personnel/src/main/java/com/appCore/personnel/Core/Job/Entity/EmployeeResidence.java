package com.appCore.personnel.Core.Job	.Entity;

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
	@Table(name = "EmployeeResidence")
	public class EmployeeResidence implements Serializable
	{

		@Id
		@GeneratedValue
		
		@Column(name = "Nid")
		private Integer nid;

		
		
		@Column(name = "Level")
		private String level;

		
		
		@Column(name = "PermanentAddress1")
		private String permanentAddress1;

		
		
		@Column(name = "PermanentAddress2")
		private String permanentAddress2;

		
		
		@Column(name = "PermanentAddress3")
		private String permanentAddress3;

		
		
		@Column(name = "City")
		private Integer city;

		
		
		@Column(name = "Country")
		private Integer country;

		
		
		@Column(name = "PostCode")
		private String postcode;

		
		
		@Column(name = "TelNo")
		private String telNo;

		
		
		@Column(name = "EmergencyContact1")
		private String emergencyContact1;

		
		
		@Column(name = "EmergencyContact2")
		private String emergencyContact2;

		
		
		@Column(name = "Contact1")
		private String contact1;

		
		
		@Column(name = "Contact3")
		private String contact2;

		
		
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

		public String getLevel() { 
			return this.level;
		}


		public void setLevel(String level) { 
			this.level = level;
		}

		public String getPermanentAddress1() { 
			return this.permanentAddress1;
		}


		public void setPermanentAddress1(String permanentAddress1) { 
			this.permanentAddress1 = permanentAddress1;
		}

		public String getPermanentAddress2() { 
			return this.permanentAddress2;
		}


		public void setPermanentAddress2(String permanentAddress2) { 
			this.permanentAddress2 = permanentAddress2;
		}

		public String getPermanentAddress3() { 
			return this.permanentAddress3;
		}


		public void setPermanentAddress3(String permanentAddress3) { 
			this.permanentAddress3 = permanentAddress3;
		}

		public Integer getCity() { 
			return this.city;
		}


		public void setCity(Integer city) { 
			this.city = city;
		}

		public Integer getCountry() { 
			return this.country;
		}


		public void setCountry(Integer country) { 
			this.country = country;
		}

		public String getPostCode() { 
			return this.postcode;
		}


		public void setPostCode(String postCode) { 
			this.postcode = postCode;
		}

		public String getTelNo() { 
			return this.telNo;
		}


		public void setTelNo(String telNo) { 
			this.telNo = telNo;
		}

		public String getEmergencyContact1() { 
			return this.emergencyContact1;
		}


		public void setEmergencyContact1(String emergencyContact1) { 
			this.emergencyContact1 = emergencyContact1;
		}

		public String getEmergencyContact2() { 
			return this.emergencyContact2;
		}


		public void setEmergencyContact2(String emergencyContact2) { 
			this.emergencyContact2 = emergencyContact2;
		}

		public String getContact1() { 
			return this.contact1;
		}


		public void setContact1(String contact1) { 
			this.contact1 = contact1;
		}

		public String getContact2() { 
			return this.contact2;
		}


		public void setContact2(String contact2) { 
			this.contact2 = contact2;
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