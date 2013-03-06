package com.appCore.personnel.Core.Configuration.Entity;


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
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import java.util.Date;
import java.util.List;
import javax.persistence.Table;

import org.hibernate.annotations.GenerationTime;

import com.appCore.personnel.Core.Entity.BranchInfo;


@Entity
@Table(name = "CompanySettings")
public class CompanySettings {
		
	@Id
	@GeneratedValue
	@Column(name = "Nid")
	private Integer nid;
	
	@Column(name = "CompanyId")
	private Integer companyId;

	
	public Integer getNid() {
		return nid;
	}


	public void setNid(Integer nid) {
		this.nid = nid;
	}


	public Integer getCompanyId() {
		return companyId;
	}


	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}


	public String getEmployeePixFolder() {
		return employeePixFolder;
	}


	public void setEmployeePixFolder(String employeePixFolder) {
		this.employeePixFolder = employeePixFolder;
	}


	@Column(name = "EmployeePixFolder")
	private String employeePixFolder;

}
