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
	@Table(name = "EmployeeFamily")
	public class EmployeeFamily implements Serializable
	{

		@Id
		@GeneratedValue
		
		@Column(name = "Nid")
		private Integer nid;
		
		
		@Column(name = "MemberName")
		private String memberName;

				
		@Column(name = "MemberType")
		private Integer memberType;

				
		@Column(name = "BirthDate")
		private Timestamp birthDate;
		
		
		@Column(name = "Age")
		private Integer age;

				
		@Column(name = "Salutation")
		private Integer salutation;

				
		@Column(name = "Gender")
		private Integer gender;

				
		@Column(name = "MaritalStatus")
		private Integer maritalStatus;
		
		
		@Column(name = "IdentificationNo")
		private String identificationNo;
		
		
		@Column(name = "Working")
		private Boolean working;
		
		
		@Column(name = "Studying")
		private Boolean studying;
		
		
		@Column(name = "Handicap")
		private Boolean handicap;
		
		
		@Column(name = "NominatedSpouse")
		private Boolean nominatedSpouse;

				
		@Column(name = "Attachments")
		private String attachments;
		
		
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

		public String getMemberName() { 
			return this.memberName;
		}


		public void setMemberName(String memberName) { 
			this.memberName = memberName;
		}

		public Integer getMemberType() { 
			return this.memberType;
		}


		public void setMemberType(Integer memberType) { 
			this.memberType = memberType;
		}

		public Timestamp getBirthDate() { 
			return this.birthDate;
		}


		public void setBirthDate(Timestamp birthDate) { 
			this.birthDate = birthDate;
		}

		public Integer getAge() { 
			return this.age;
		}


		public void setAge(Integer age) { 
			this.age = age;
		}

		public Integer getSalutation() { 
			return this.salutation;
		}


		public void setSalutation(Integer salutation) { 
			this.salutation = salutation;
		}

		public Integer getGender() { 
			return this.gender;
		}


		public void setGender(Integer gender) { 
			this.gender = gender;
		}

		public Integer getMaritalStatus() { 
			return this.maritalStatus;
		}


		public void setMaritalStatus(Integer maritalStatus) { 
			this.maritalStatus = maritalStatus;
		}

		public String getIdentificationNo() { 
			return this.identificationNo;
		}


		public void setIdentificationNo(String identificationNo) { 
			this.identificationNo = identificationNo;
		}

		public Boolean getWorking() { 
			return this.working;
		}


		public void setWorking(Boolean working) { 
			this.working = working;
		}

		public Boolean getStudying() { 
			return this.studying;
		}


		public void setStudying(Boolean studying) { 
			this.studying = studying;
		}

		public Boolean getHandicap() { 
			return this.handicap;
		}


		public void setHandicap(Boolean handicap) { 
			this.handicap = handicap;
		}

		public Boolean getNominatedSpouse() { 
			return this.nominatedSpouse;
		}


		public void setNominatedSpouse(Boolean nominatedSpouse) { 
			this.nominatedSpouse = nominatedSpouse;
		}

		public String getAttachments() { 
			return this.attachments;
		}


		public void setAttachments(String attachments) { 
			this.attachments = attachments;
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