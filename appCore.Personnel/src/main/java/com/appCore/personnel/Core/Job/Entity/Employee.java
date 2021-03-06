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
	@Table(name = "Employee")
	public class Employee implements Serializable
	{

		@Id
		@GeneratedValue
		
		@Column(name = "Nid")
		private Integer nid;
		
		
		@Column(name = "Code")
		private String code;

		@Column(name = "CompanyRef")
		private int companyRef;
		
		
		public int getCompanyRef() {
			return companyRef;
		}


		public void setCompanyRef(int companyRef) {
			this.companyRef = companyRef;
		}


		@Column(name = "Description")
		private String description;

		
		
		@Column(name = "Name")
		private String name;

		
		
		@Column(name = "FirstName")
		private String firstName;

		
		
		@Column(name = "LastName")
		private String lastName;

		
		
		@Column(name = "MiddleName")
		private String middleName;

		
		
		@Column(name = "Gender")
		private Integer gender;

			
		
		@Column(name = "Salutation")
		private Integer salutation;

		
		
		@Column(name = "BirthDate")
		private Timestamp birthDate;

		
		
		@Column(name = "Age")
		private Integer age;

		
		
		@Column(name = "MaritalStatus")
		private Integer maritalStatus;

		
		
		@Column(name = "MarriageDate")
		private Timestamp marriageDate;

		
		
		@Column(name = "Race")
		private Integer race;

		
		
		@Column(name = "Religion")
		private Integer religion;

		
		
		@Column(name = "Nationality")
		private Integer nationality;

		
		
		@Column(name = "CountryOrigin")
		private Integer countryOrigin;

		
		
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

		public String getCode() { 
			return this.code;
		}


		public void setCode(String code) { 
			this.code = code;
		}

		public String getDescription() { 
			return this.description;
		}


		public void setDescription(String description) { 
			this.description = description;
		}

		public String getName() { 
			return this.name;
		}


		public void setName(String name) { 
			this.name = name;
		}

		public String getFirstName() { 
			return this.firstName;
		}


		public void setFirstName(String firstName) { 
			this.firstName = firstName;
		}

		public String getLastName() { 
			return this.lastName;
		}


		public void setLastName(String lastName) { 
			this.lastName = lastName;
		}

		public String getMiddleName() { 
			return this.middleName;
		}


		public void setMiddleName(String middleName) { 
			this.middleName = middleName;
		}

		public Integer getGender() { 
			return this.gender;
		}


		public void setGender(Integer gender) { 
			this.gender = gender;
		}

		public Integer getSalutation() { 
			return this.salutation;
		}


		public void setSalutation(Integer salutation) { 
			this.salutation = salutation;
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

		public Integer getMaritalStatus() { 
			return this.maritalStatus;
		}


		public void setMaritalStatus(Integer maritalStatus) { 
			this.maritalStatus = maritalStatus;
		}

		public Timestamp getMarriageDate() { 
			return this.marriageDate;
		}


		public void setMarriageDate(Timestamp marriageDate) { 
			this.marriageDate = marriageDate;
		}

		public Integer getRace() { 
			return this.race;
		}


		public void setRace(Integer race) { 
			this.race = race;
		}

		public Integer getReligion() { 
			return this.religion;
		}


		public void setReligion(Integer religion) { 
			this.religion = religion;
		}

		public Integer getNationality() { 
			return this.nationality;
		}


		public void setNationality(Integer nationality) { 
			this.nationality = nationality;
		}

		public Integer getCountryOrigin() { 
			return this.countryOrigin;
		}


		public void setCountryOrigin(Integer countryOrigin) { 
			this.countryOrigin = countryOrigin;
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