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
	@Table(name = "EmployeeMembership")
	public class EmployeeMembership implements Serializable
	{

		@Id
		@GeneratedValue
		
		@Column(name = "Nid")
		private Integer nid;
		
		
		@Column(name = "Association")
		private String association;
		
		
		@Column(name = "MemberType")
		private Integer memberType;
		
		
		@Column(name = "ContactDetails")
		private String contactDetails;
		
		
		@Column(name = "StartDate")
		private Timestamp startDate;

		
		
		@Column(name = "EndDate")
		private Timestamp endDate;

		
		
		@Column(name = "MembershipPeriod")
		private Integer membershipPeriod;

		
		
		@Column(name = "EnrollmentFees")
		private Integer enrollmentFees;

		
		
		@Column(name = "MembershipFees")
		private Integer membershipFees;

		
		
		@Column(name = "Attachments")
		private String attachments;
		
		
		@Column(name = "Remarks")
		private String remarks;
		
		
		@Column(name = "EmployeeRefId")
		private Integer employeeRefId;

		
		@Column(name = "LastUpdate")
		private Timestamp lastUpdate;


		public Integer getNid() { 
			return this.nid;
		}


		public void setNid(Integer nid) { 
			this.nid = nid;
		}

		public String getAssociation() { 
			return this.association;
		}


		public void setAssociation(String association) { 
			this.association = association;
		}

		public Integer getMemberType() { 
			return this.memberType;
		}


		public void setMemberType(Integer memberType) { 
			this.memberType = memberType;
		}

		public String getContactDetails() { 
			return this.contactDetails;
		}


		public void setContactDetails(String contactDetails) { 
			this.contactDetails = contactDetails;
		}

		public Timestamp getStartDate() { 
			return this.startDate;
		}


		public void setStartDate(Timestamp startDate) { 
			this.startDate = startDate;
		}

		public Timestamp getEndDate() { 
			return this.endDate;
		}


		public void setEndDate(Timestamp endDate) { 
			this.endDate = endDate;
		}

		public Integer getMembershipPeriod() { 
			return this.membershipPeriod;
		}


		public void setMembershipPeriod(Integer membershipPeriod) { 
			this.membershipPeriod = membershipPeriod;
		}

		public Integer getEnrollmentFees() { 
			return this.enrollmentFees;
		}


		public void setEnrollmentFees(Integer enrollmentFees) { 
			this.enrollmentFees = enrollmentFees;
		}

		public Integer getMembershipFees() { 
			return this.membershipFees;
		}


		public void setMembershipFees(Integer membershipFees) { 
			this.membershipFees = membershipFees;
		}

		public String getAttachments() { 
			return this.attachments;
		}


		public void setAttachments(String attachments) { 
			this.attachments = attachments;
		}

		public String getRemarks() { 
			return this.remarks;
		}


		public void setRemarks(String remarks) { 
			this.remarks = remarks;
		}

		public Integer getEmployeeRefId() { 
			return this.employeeRefId;
		}


		public void setEmployeeRefId(Integer employeeRefId) { 
			this.employeeRefId = employeeRefId;
		}

		public Timestamp getLastUpdate() { 
			return this.lastUpdate;
		}


		public void setLastUpdate(Timestamp lastUpdate) { 
			this.lastUpdate = lastUpdate;
		}
	}