package com.appCore.personnel.Core.Calendar.Entity;

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
@Table(name = "EmployeeHolidayHistory")
public class EmployeeHolidayHistory implements Serializable
{
						
				
		@Id
		@GeneratedValue 
		@Column(name = "Nid")
		private Integer nid;
						
		@Column(name = "CompanyId")
		private Integer companyId;
		
		@Column(name = "EmployeeId")
		private Integer employeeId;
		
		
		@Column(name = "Description")
		private String description;
						
				
		@Column(name = "Info")
		private String info;
						
				
		@Column(name = "HolidayEntitlementType")
		private Integer holidayEntitlementType;
						
				
		@Column(name = "LeaveEarningScheme")
		private Integer leaveEarningScheme;
						
				
		@Column(name = "LeaveWorkflow")
		private Integer leaveWorkflow;
						
				
		@Column(name = "LastUpdate")
		private Timestamp lastUpdate;
				
		
						
		public Integer getNid() 
		{ 
			return this.nid;
		}
				
		public void setNid(Integer nid) 
		{ 
			this.nid = nid;
		}				
						
		public String getDescription() 
		{ 
			return this.description;
		}
				
		public void setDescription(String description) 
		{ 
			this.description = description;
		}				
						
		public String getInfo() 
		{ 
			return this.info;
		}
				
		public void setInfo(String info) 
		{ 
			this.info = info;
		}				
						
		public Integer getHolidayEntitlementType() 
		{ 
			return this.holidayEntitlementType;
		}
				
		public void setHolidayEntitlementType(Integer holidayEntitlementType) 
		{ 
			this.holidayEntitlementType = holidayEntitlementType;
		}				
						
		public Integer getLeaveEarningScheme() 
		{ 
			return this.leaveEarningScheme;
		}
				
		public void setLeaveEarningScheme(Integer leaveEarningScheme) 
		{ 
			this.leaveEarningScheme = leaveEarningScheme;
		}				
						
		public Integer getLeaveWorkflow() 
		{ 
			return this.leaveWorkflow;
		}
				
		public void setLeaveWorkflow(Integer leaveWorkflow) 
		{ 
			this.leaveWorkflow = leaveWorkflow;
		}				
						
		public Timestamp getLastUpdate() 
		{ 
			return this.lastUpdate;
		}
				
		public void setLastUpdate(Timestamp lastUpdate) 
		{ 
			this.lastUpdate = lastUpdate;
		}

		public Integer getCompanyId() {
			return companyId;
		}

		public void setCompanyId(Integer companyId) {
			this.companyId = companyId;
		}

		public Integer getEmployeeId() {
			return employeeId;
		}

		public void setEmployeeId(Integer employeeId) {
			this.employeeId = employeeId;
		}				
			
}

