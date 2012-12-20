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
		
		//@MapKeyManyToMany(joinColumns=@JoinColumn(name="Holiday_Keys"))
		
		//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
		//@JoinTable(name="HolidayGroup_Holiday", joinColumns={ @JoinColumn(name="HolidayGroup_Key")}, 
		//inverseJoinColumns={@JoinColumn(name="Holiday_Key")})
		//@JoinColumn(name="HolidayGroup_Key")
		
		@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
		@JoinTable(name="HolidayGroup_Holiday")
		private List<Holiday> holidays;
	
		
		@Column(name = "LastUpdate")
		private Date lastUpdate;


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

		public Date getLastUpdate() { 
			return this.lastUpdate;
		}


		public void setLastUpdate(Date lastUpdate) { 
			this.lastUpdate = lastUpdate;
		}
	}