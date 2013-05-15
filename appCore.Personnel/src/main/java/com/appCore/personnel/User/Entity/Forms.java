package com.appCore.personnel.User.Entity;

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
import javax.persistence.OneToOne;

import java.util.List;
import javax.persistence.Table;


	@Entity
	@Table(name = "Forms")
	public class Forms implements Serializable
	{

		@Id
		@GeneratedValue
		
		@Column(name = "Nid")
		private Integer nid;
		
		@Column(name = "FormId")
		private String formId;
		
		@Column(name = "Link")
		private String link;
		
		
		@Column(name = "Disabled")
		private Boolean disabled;
		
		@Column(name = "LastUpdate")
		private Timestamp lastUpdate;

		@Column(name = "CompanyId")
		private Integer companyId;
		
		@OneToOne
		private Category category;
		
		
		public Integer getNid() { 
			return this.nid;
		}


		public void setNid(Integer nid) { 
			this.nid = nid;
		}

		
		public Category getCategory() { 
			return this.category;
		}

		public void setCategory(Category category) { 
			this.category = category;
		}

		
		public String getFormId() { 
			return this.formId;
		}


		public void setFormId(String formId) { 
			this.formId = formId;
		}

		public String getLink() { 
			return this.link;
		}

		public void setLink(String link) { 
			this.link = link;
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


		public Integer getCompanyId() {
			return companyId;
		}


		public void setCompanyId(Integer companyId) {
			this.companyId = companyId;
		}
	}