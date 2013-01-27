package com.appCore.personnel.Core.Entity;

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
import javax.persistence.Transient;

import java.util.List;
import javax.persistence.Table;

import org.hibernate.envers.Audited;


	@Audited
	@Entity
	@Table(name = "Company")
	public class Company implements Serializable
	{

		@Id
		@GeneratedValue
		@Column(name = "Nid")
		private Integer nid;
		
		@Column(name = "CompanyCode")
		private String companyCode;

		@Column(name = "Registration")
		private String registration;
		
		@Column(name = "CompanyName")
		private String companyName;
		
		@Column(name = "Address")
		private String address;
		
		@Column(name = "Address2")
		private String address2;
		
		@Column(name = "Address3")
		private String address3;
		
		
		@Column(name = "City")
		private String city;
		
		@Column(name = "Country")
		private String country;
		
		@Column(name = "Postcode")
		private String postcode;
		
		@Column(name = "Tel")
		private String tel;

		
		@Column(name = "Fax")
		private String fax;

		
		@Column(name = "DefaultCurrency")
		private String defaultCurrency;
		
		
		@Column(name = "ParentCompany")
		private Integer parentCompany;

		
		@Column(name = "Disabled")
		private Boolean disabled;
		
		
		@Column(name = "LastUpdate")
		private Timestamp lastUpdate;

		@Transient
		List<Branch> branchList; 
		
		
		public Integer getNid() { 
			return this.nid;
		}


		public void setNid(Integer nid) { 
			this.nid = nid;
		}

		public String getCompanyCode() { 
			return this.companyCode;
		}


		public void setCompanyCode(String companyCode) { 
			this.companyCode = companyCode;
		}

		public String getRegistration() { 
			return this.registration;
		}


		public void setRegistration(String registration) { 
			this.registration = registration;
		}

		public String getCompanyName() { 
			return this.companyName;
		}


		public void setCompanyName(String companyName) { 
			this.companyName = companyName;
		}

		public String getAddress() { 
			return this.address;
		}


		public void setAddress(String address) { 
			this.address = address;
		}

		public String getAddress2() {
			return address2;
		}


		public void setAddress2(String address2) {
			this.address2 = address2;
		}


		public String getAddress3() {
			return address3;
		}


		public void setAddress3(String address3) {
			this.address3 = address3;
		}

		
		public String getCity() { 
			return this.city;
		}


		public void setCity(String city) { 
			this.city = city;
		}

		public String getCountry() { 
			return this.country;
		}


		public void setCountry(String country) { 
			this.country = country;
		}

		public String getPostcode() { 
			return this.postcode;
		}


		public void setPostcode(String postcode) { 
			this.postcode = postcode;
		}

		public String getTel() { 
			return this.tel;
		}

		public void setTel(String tel) { 
			this.tel = tel;
		}
		
		public String getFax() { 
			return this.fax;
		}

		public void setFax(String fax) { 
			this.fax = fax;
		}
		

		public String getDefaultCurrency() { 
			return this.defaultCurrency;
		}


		public void setDefaultCurrency(String defaultCurrency) { 
			this.defaultCurrency = defaultCurrency;
		}

		public Integer getParentCompany() { 
			return this.parentCompany;
		}


		public void setParentCompany(Integer parentCompany) { 
			this.parentCompany = parentCompany;
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
		
		
		public List<Branch> getBranchList() {
			return branchList;
		}


		public void setBranchList(List<Branch> branchList) {
			this.branchList = branchList;
		}


		
}
	