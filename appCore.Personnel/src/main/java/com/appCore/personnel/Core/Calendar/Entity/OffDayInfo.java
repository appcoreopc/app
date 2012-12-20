package com.appCore.personnel.Core.Calendar.Entity;

import java.io.Serializable;
import java.sql.Date;
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
	@Table(name = "OffDayInfo")
	public class OffDayInfo implements Serializable
	{

		@Id
		@GeneratedValue
		@Column(name = "Nid")
		private Integer nid;
		
		@Column(name = "RefEntity")
		private Integer refEntity;
		
		@Column(name = "DayNo")
		private Date dayNo;
		
		@Column(name = "DayType")
		private Integer dayType;

		@Column(name = "Description")
		private String description;

		@Column(name = "DayTypeDescription")
		private String dayTypeDescription;
		
		@Column(name = "ClashedAction")
		private Integer clashedAction;

		@Column(name = "NonClashedAction")
		private Integer nonClashedAction;
		
		@Column(name = "LastUpdate")
		private Timestamp lastUpdate;


		public Integer getNid() { 
			return this.nid;
		}


		public void setNid(Integer nid) { 
			this.nid = nid;
		}

		public Integer getRefEntity() { 
			return this.refEntity;
		}


		public void setRefEntity(Integer refEntity) { 
			this.refEntity = refEntity;
		}

		public Date getDayNo() { 
			return this.dayNo;
		}

		public void setDayNo(Date dayNo) { 
			this.dayNo = dayNo;
		}

		public Integer getDayType() { 
			return this.dayType;
		}


		public void setDayType(Integer dayType) { 
			this.dayType = dayType;
		}

		public String getDescription() { 
			return this.description;
		}


		public void setDescription(String description) { 
			this.description = description;
		}

		public String getDayTypeDescription() { 
			return this.dayTypeDescription;
		}


		public void setDayTypeDescription(String dayTypeDescription) { 
			this.dayTypeDescription = dayTypeDescription;
		}

		public Integer getClashedAction() { 
			return this.clashedAction;
		}


		public void setClashedAction(Integer clashedAction) { 
			this.clashedAction = clashedAction;
		}

		public Integer getNonClashedAction() { 
			return this.nonClashedAction;
		}


		public void setNonClashedAction(Integer nonClashedAction) { 
			this.nonClashedAction = nonClashedAction;
		}

		public Timestamp getLastUpdate() { 
			return this.lastUpdate;
		}


		public void setLastUpdate(Timestamp lastUpdate) { 
			this.lastUpdate = lastUpdate;
		}
	}