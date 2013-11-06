package com.appCore.personnel.Core.Calendar.Entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import javax.persistence.Column;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import java.util.List;
import javax.persistence.Table;

import org.hibernate.annotations.MapKeyManyToMany;

import com.appCore.personnel.Core.Calendar.Entity.Holiday;


	@Entity
	@Table(name = "HolidayGroup")
	public class HolidayGroup implements Serializable
	{

		@Id
		@GeneratedValue
		@Column(name = "Nid")
		private Integer nid;
		
		@Column(name = "Name")
		private String name;
				
		@Column(name = "Description")
		private String description;
		
		@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
		@JoinTable(name="HolidayGroup_Holiday")
		private List<Holiday> holidays;

		@Column(name = "HolidayReplacementType")
		private Integer holidayReplacementType;
		
		@Column(name = "LastUpdate")
		private Timestamp lastUpdate;
		
		@Column(name = "CompanyRef")
		private int companyRef;
		
		@Column(name = "startholidayValidityCycle")
		private Timestamp startholidayValidityCycle;
		
		@Column(name = "endholidayValidityCycle")
		private Timestamp endholidayValidityCycle;
		
		@Column(name = "EntitlementType")
		private int entitlementType;
		
		@Column(name = "ReplacementType")
		private int replacementType;
		
		@Column(name = "LeaveEarningType")
		private int leaveEarningType;
		
		@Column(name = "NotificationType")
		private int notificationType;
		
		@Column(name = "StartEffectiveDate")
		private Timestamp startEffectiveDate;
		
		
		@Column(name = "EndEffectiveDate")
		private Timestamp endEffectiveDate;
		
		
		@Column(name = "Disabled")
		private Boolean disabled;

		
		public int getCompanyRef() {
			return companyRef;
		}


		public void setCompanyRef(int companyRef) {
			this.companyRef = companyRef;
		}

		
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

		public String getDescription() { 
			return this.description;
		}


		public void setDescription(String description) { 
			this.description = description;
		}

		public List<Holiday> getHolidays() { 
			return this.holidays;
		}

		public void setHolidays(List<Holiday> holidays) { 
			this.holidays = holidays;
		}

		public Timestamp getLastUpdate() { 
			return this.lastUpdate;
		}


		public void setLastUpdate(Timestamp lastUpdate) { 
			this.lastUpdate = lastUpdate;
		}
		public Timestamp getStartEffectiveDate() {
			return startEffectiveDate;
		}


		public void setStartEffectiveDate(Timestamp startEffectiveDate) {
			this.startEffectiveDate = startEffectiveDate;
		}


		public Timestamp getEndEffectiveDate() {
			return endEffectiveDate;
		}


		public void setEndEffectiveDate(Timestamp endEffectiveDate) {
			this.endEffectiveDate = endEffectiveDate;
		}


		public Boolean getDisabled() {
			return disabled;
		}


		public void setDisabled(Boolean disabled) {
			this.disabled = disabled;
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


		public int getEntitlementType() {
			return entitlementType;
		}


		public void setEntitlementType(int entitlementType) {
			this.entitlementType = entitlementType;
		}


		public int getReplacementType() {
			return replacementType;
		}


		public void setReplacementType(int replacementType) {
			this.replacementType = replacementType;
		}


		public int getLeaveEarningType() {
			return leaveEarningType;
		}


		public void setLeaveEarningType(int leaveEarningType) {
			this.leaveEarningType = leaveEarningType;
		}


		public int getNotificationType() {
			return notificationType;
		}


		public void setNotificationType(int notificationType) {
			this.notificationType = notificationType;
		}


		public Integer getHolidayReplacementType() {
			return holidayReplacementType;
		}


		public void setHolidayReplacementType(Integer holidayReplacementType) {
			this.holidayReplacementType = holidayReplacementType;
		}


	}