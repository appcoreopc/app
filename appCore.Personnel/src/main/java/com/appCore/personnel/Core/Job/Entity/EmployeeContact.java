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
	@Table(name = "EmployeeContact")
	public class EmployeeContact implements Serializable
	{

		@Id
		@GeneratedValue
		
		@Column(name = "Nid")
		private Integer nid;

		
		
		@Column(name = "Level")
		private String level;

		
		
		@Column(name = "Email")
		private String email;

		
		
		@Column(name = "MobileNo")
		private String mobileNo;

		
		
		@Column(name = "AlternateEmail")
		private String alternateEmail;

		
		
		@Column(name = "ExtNo")
		private String extNo;

		
		
		@Column(name = "CorrespondenceAddress1")
		private String correspondenceAddress1;

		
		
		@Column(name = "CorrespondenceAddress2")
		private String correspondenceAddress2;

		
		
		@Column(name = "CorrespondenceAddress3")
		private String correspondenceAddress3;

		
		
		@Column(name = "City")
		private Integer city;

		
		
		@Column(name = "Country")
		private Integer country;

		
		
		@Column(name = "PostCode")
		private String postCode;

		
		
		@Column(name = "TelNo")
		private String telNo;

		
		
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

		public String getEmail() { 
			return this.email;
		}


		public void setEmail(String email) { 
			this.email = email;
		}

		public String getMobileNo() { 
			return this.mobileNo;
		}


		public void setMobileNo(String mobileNo) { 
			this.mobileNo = mobileNo;
		}

		public String getAlternateEmail() { 
			return this.alternateEmail;
		}


		public void setAlternateEmail(String alternateEmail) { 
			this.alternateEmail = alternateEmail;
		}

		public String getExtNo() { 
			return this.extNo;
		}


		public void setExtNo(String extNo) { 
			this.extNo = extNo;
		}

		public String getCorrespondenceAddress1() { 
			return this.correspondenceAddress1;
		}


		public void setCorrespondenceAddress1(String correspondenceAddress1) { 
			this.correspondenceAddress1 = correspondenceAddress1;
		}

		public String getCorrespondenceAddress2() { 
			return this.correspondenceAddress2;
		}


		public void setCorrespondenceAddress2(String correspondenceAddress2) { 
			this.correspondenceAddress2 = correspondenceAddress2;
		}

		public String getCorrespondenceAddress3() { 
			return this.correspondenceAddress3;
		}


		public void setCorrespondenceAddress3(String correspondenceAddress3) { 
			this.correspondenceAddress3 = correspondenceAddress3;
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
			return this.postCode;
		}


		public void setPostCode(String postCode) { 
			this.postCode = postCode;
		}

		public String getTelNo() { 
			return this.telNo;
		}


		public void setTelNo(String telNo) { 
			this.telNo = telNo;
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