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
import com.appCore.personnel.Core.Calendar.Entity.OffDayInfo;



	@Entity
	@Table(name = "OffDay")
	public class OffDay implements Serializable
	{

		@Id
		@GeneratedValue
		@Column(name = "Nid")
		private Integer nid;

		
		@Column(name = "PatternName")
		private String patternName;

		@Column(name = "Description")
		private String description;
		
		
		@Column(name = "Disabled")
		private Boolean disabled;
		
		
		@Column(name = "DayPerCycle")
		private Integer dayPerCycle;

		@Column(name = "Remark")
		private String remark;

		
		@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
		@JoinColumn(name="RefEntity")
		private List<OffDayInfo> offDayInfo;
		
		
		@Column(name = "LastUpdate")
		private Date lastUpdate;


		public Integer getNid() { 
			return this.nid;
		}


		public void setNid(Integer nid) { 
			this.nid = nid;
		}

		public String getPatternName() { 
			return this.patternName;
		}


		public void setPatternName(String patternName) { 
			this.patternName = patternName;
		}

		public String getDescription() { 
			return this.description;
		}


		public void setDescription(String description) { 
			this.description = description;
		}

		public Boolean getDisabled() { 
			return this.disabled;
		}


		public void setDisabled(Boolean disabled) { 
			this.disabled = disabled;
		}

		public Integer getDayPerCycle() { 
			return this.dayPerCycle;
		}


		public void setDayPerCycle(Integer dayPerCycle) { 
			this.dayPerCycle = dayPerCycle;
		}

		public String getRemark() { 
			return this.remark;
		}


		public void setRemark(String remark) { 
			this.remark = remark;
		}

		public List<OffDayInfo> getOffDayInfo() { 
			return this.offDayInfo;
		}


		public void setOffDayInfo(List<OffDayInfo> offDayInfo) { 
			this.offDayInfo = offDayInfo;
		}

		public Date getLastUpdate() { 
			return this.lastUpdate;
		}


		public void setLastUpdate(Date lastUpdate) { 
			this.lastUpdate = lastUpdate;
		}
	}