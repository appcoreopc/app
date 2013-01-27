package com.appCore.personnel.Core.Service;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.Core.Entity.Branch;
import com.appCore.personnel.Core.Entity.BranchInfo;
import com.appCore.personnel.Core.Entity.Company;
import com.appCore.personnel.Core.Entity.CompanyEntity;
import com.appCore.personnel.Core.Entity.Department;
import com.appCore.personnel.Core.Entity.Division;
import com.appCore.personnel.Core.Entity.Section;
import com.appCore.personnel.Core.Entity.Unit;

@Service("companyEntityService")
@Transactional
public class CompanyEntityService {
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;

	public List<CompanyEntity> getAllEntity()
	{
		return getCompanyAll();
	}
	
	private List<CompanyEntity> getCompanyAll()
	{
		List<CompanyEntity> list = new ArrayList<CompanyEntity>(); 
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Company");
		
		List<Company> queryResult = query.list();
		
		for (Company comp : queryResult)
		{
			CompanyEntity companyEntity = new CompanyEntity(); 
			companyEntity.setText(comp.getCompanyCode());
			companyEntity.setType("c");
			getDivision(companyEntity, comp);
			list.add(companyEntity);
		}
		return list; 
	}
	
	private void getBranch(CompanyEntity companyEntity, Company company)
	{
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Branch where CompanyId = :companyId");
		query.setParameter("companyId", company.getNid());
		
	    List<Branch> resultQuery = query.list(); 
	    
	    if (resultQuery.size() > 0) 
	    {
	    	companyEntity.items = new ArrayList<CompanyEntity>(); 

	    	for	(Branch division : resultQuery)
	    	{
	    		CompanyEntity branchCompanyEntity = new CompanyEntity(); 
	    		branchCompanyEntity.setText(division.getBranchCode());
	    		branchCompanyEntity.setType("branch");
	    		companyEntity.getItems().add(branchCompanyEntity);
	    		getDivision(branchCompanyEntity, company);
	    	}
	    }
	}
	
	
	private void getDivision(CompanyEntity companyEntity, Company company)
	{
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Division where CompanyId = :companyId");
		query.setParameter("companyId", company.getNid());
		
	    List<Division> resultQuery = query.list(); 
	    
	    if (resultQuery.size() > 0) 
	    {
	    	companyEntity.items = new ArrayList<CompanyEntity>(); 
	    	
	    	for	(Division division : resultQuery)
	    	{
	    		CompanyEntity divCompanyEntity = new CompanyEntity(); 
	    		divCompanyEntity.setText(division.getDivisionCode());
	    		divCompanyEntity.setType("di");
	    		companyEntity.getItems().add(divCompanyEntity);
	    		getDepartment(divCompanyEntity, division);
	    	}
	    }
	}
	
	private void getDepartment(CompanyEntity companyEntity, Division division)
	{
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Department where DivisionId = :divisionId");
		query.setParameter("divisionId", division.getNid());
		
	    List<Department> resultQuery = query.list(); 
	    
	    if (resultQuery.size() > 0) 
	    {
	    	companyEntity.items = new ArrayList<CompanyEntity>(); 
	    	
	    	for	(Department department : resultQuery)
	    	{
	    		CompanyEntity divCompanyEntity = new CompanyEntity(); 
	    		divCompanyEntity.setText(department.getDepartmentCode());
	    		divCompanyEntity.setType("de");
	    		companyEntity.getItems().add(divCompanyEntity);
	    		getSection(divCompanyEntity, department);
	    	}
	    }
	}
	
	
	private void getSection(CompanyEntity companyEntity, Department department)
	{
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Section where DepartmentId = :departmentId");
		query.setParameter("departmentId", department.getNid());
		
	    List<Section> resultQuery = query.list(); 
	    
	    if (resultQuery.size() > 0) 
	    {
	    	companyEntity.items = new ArrayList<CompanyEntity>(); 
	    	
	    	for	(Section section : resultQuery)
	    	{
	    		CompanyEntity divCompanyEntity = new CompanyEntity(); 
	    		divCompanyEntity.setText(section.getSectionCode());
	    		divCompanyEntity.setType("s");
	    		companyEntity.getItems().add(divCompanyEntity);
	    		getUnit(divCompanyEntity, section);
	    	}
	    }
	}
	
	
	private void getUnit(CompanyEntity companyEntity, Section section)
	{
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Unit where SectionId = :sectionId");
		query.setParameter("sectionId", section.getNid());
		
	    List<Unit> resultQuery = query.list(); 
	    
	    if (resultQuery.size() > 0) 
	    {
	    	companyEntity.items = new ArrayList<CompanyEntity>(); 
	    	
	    	for	(Unit unit : resultQuery)
	    	{
	    		CompanyEntity divCompanyEntity = new CompanyEntity(); 
	    		divCompanyEntity.setText(unit.getUnitCode());
	    		companyEntity.getItems().add(divCompanyEntity);
	    	}
	    }
	}	
}
