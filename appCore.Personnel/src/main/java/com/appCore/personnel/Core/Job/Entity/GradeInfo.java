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
	@Table(name = "GradeInfo")
	public class GradeInfo implements Serializable
	{

		@Id
		@GeneratedValue
		
		@Column(name = "Nid")
		private Integer nid;

		
		
		@Column(name = "Type")
		private String type;

		
		
		@Column(name = "Value")
		private String value;

		
		
		@Column(name = "Description")
		private String description;

		
		
		@Column(name = "Category")
		private String category;

		
		
		@Column(name = "RefEntity")
		private Integer refEntity;

		
		
		@Column(name = "LastUpdate")
		private Timestamp lastUpdate;


		public Integer getNid() { 
			return this.nid;
		}


		public void setNid(Integer nid) { 
			this.nid = nid;
		}

		public String getType() { 
			return this.type;
		}


		public void setType(String type) { 
			this.type = type;
		}

		public String getValue() { 
			return this.value;
		}


		public void setValue(String value) { 
			this.value = value;
		}

		public String getDescription() { 
			return this.description;
		}


		public void setDescription(String description) { 
			this.description = description;
		}

		public String getCategory() { 
			return this.category;
		}


		public void setCategory(String category) { 
			this.category = category;
		}

		public Integer getRefEntity() { 
			return this.refEntity;
		}


		public void setRefEntity(Integer refEntity) { 
			this.refEntity = refEntity;
		}

		public Timestamp getLastUpdate() { 
			return this.lastUpdate;
		}


		public void setLastUpdate(Timestamp lastUpdate) { 
			this.lastUpdate = lastUpdate;
		}
	}