package com.appCore.personnel.Core.Calendar.Entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import javax.persistence.Column;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import java.util.List;
import javax.persistence.Table;

	@Entity
	@Table(name = "Holiday")
	public class Holiday implements Serializable
	{
		
		@Id
		@GeneratedValue
		@Column(name = "Nid")
		private Integer nid;
		
		
		@Column(name = "Name")
		private String name;
		
		// determine what action to take 
		// when holiday falls on sat / sun
		@Column(name = "ActionFallsOnHoliday")
		private int actionFallsOnHoliday;
		
		
		@Column(name = "HolidayDate")
		private Timestamp holidayDate;

		
		@Column(name = "StartholidayValidityCycle")
		private Timestamp startholidayValidityCycle;

		
		@Column(name = "EndholidayValidityCycle")
		private Timestamp endholidayValidityCycle;
			

		@Column(name = "NotificationType")
		private int notificationType;
		

		@Column(name = "CompanyRef")
		private Integer companyRef;
		
		
		@Column(name = "Recurring")
		private Boolean recurring;
		
		
		@Column(name = "Description")
		private String description;
		
		@Transient
		private List<HolidayGroup> holidayGroup;
		
		
		@Column(name = "Type")
		private Integer type;
		
		
		@Column(name = "LastUpdate")
		private Date lastUpdate;


		public Integer getNid() { 
			return this.nid;
		}


		public Integer getCompanyRef() {
			return companyRef;
		}


		public void setCompanyRef(Integer companyId) {
			this.companyRef = companyId;
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

		public Timestamp getHolidayDate() { 
			return this.holidayDate;
		}


		public void setHolidayDate(Timestamp holidayDate) { 
			this.holidayDate = holidayDate;
		}

		public Boolean getRecurring() { 
			return this.recurring;
		}


		public void setRecurring(Boolean recurring) { 
			this.recurring = recurring;
		}

		
		public String getDescription() { 
			return this.description;
		}


		public void setDescription(String description) { 
			this.description = description;
		}

		public Integer getType() { 
			return this.type;
		}


		public void setType(Integer type) { 
			this.type = type;
		}

		
		public List<HolidayGroup> getHolidayGroup() { 
			return this.holidayGroup;
		}
		

		public void setHolidayGroup(List<HolidayGroup> holidayGroup) { 
			this.holidayGroup = holidayGroup;
		}
		
		
		public Date getLastUpdate() { 
			return this.lastUpdate;
		}


		public void setLastUpdate(Date lastUpdate) { 
			this.lastUpdate = lastUpdate;
		}


		public int getActionFallsOnHoliday() {
			return actionFallsOnHoliday;
		}


		public void setActionFallsOnHoliday(int actionFallsOnHoliday) {
			this.actionFallsOnHoliday = actionFallsOnHoliday;
		}


		public Timestamp getStartholidayValidityCycle() {
			return startholidayValidityCycle;
		}


		public void setStartholidayValidityCycle(Timestamp startholidayValidityCycle) {
			this.startholidayValidityCycle = startholidayValidityCycle;
		}


		public Timestamp getEndholidayValidityCycle() {
			return endholidayValidityCycle;
		}


		public void setEndholidayValidityCycle(Timestamp endholidayValidityCycle) {
			this.endholidayValidityCycle = endholidayValidityCycle;
		}


		public int getNotificationType() {
			return notificationType;
		}


		public void setNotificationType(int notificationType) {
			this.notificationType = notificationType;
		}
	}