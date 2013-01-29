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
import com.appCore.personnel.Core.Entity.Company;
import com.appCore.personnel.Core.Entity.Department;
import com.appCore.personnel.Core.Entity.Division;
import com.appCore.personnel.Core.Entity.Section;
import com.appCore.personnel.Core.Entity.Unit;

@Service("companyService")
@Transactional
public class CompanyService {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	public Integer getSummary(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		return ((Integer) session
				.createCriteria("select count(*) from Company").uniqueResult())
				.intValue();
	}

	public List<Company> getAll() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  Company");
		return query.list();
	}

	public List<Company> getAllCompanyInfo() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Company");

		List<Company> allCompanyInfoResult = query.list();

		for (int i = 0; i < allCompanyInfoResult.size(); i++) {
			Company currentCompany = allCompanyInfoResult.get(i);
			getDivision(currentCompany);
		}
		return allCompanyInfoResult;
	}
	
	
	private void getDivision(Company company) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("FROM Division where CompanyId = :companyId");
		query.setParameter("companyId", company.getNid());

		List<Division> resultQuery = query.list();
		if (resultQuery.size() > 0) {
			
			for (int i = 0; i < resultQuery.size(); i++) {
				Division currentCompany = resultQuery.get(i);
				getDepartment(currentCompany, company);
			}
			company.setDivisionList(resultQuery);
		}
	}

	private void getDepartment(Division division, Company company) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("FROM Department where DivisionId = :id");
		query.setParameter("id", division.getNid());

		List<Department> resultQuery = query.list();

		if (resultQuery.size() > 0) {
			for (Department department : resultQuery) {
				getSection(department, company);
			}
			division.setDepartmentList(resultQuery);
		}
	}

	private void getSection(Department department, Company company) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("FROM Section where DepartmentId = :id");
		query.setParameter("id", department.getNid());
		
		List<Section> resultQuery = query.list();

		if (resultQuery.size() > 0) {
			for (Section section : resultQuery) {
				getUnit(section, company);
			}
			department.setSection(resultQuery);
		}
	}

	private void getUnit(Section section, Company company) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("FROM Unit where SectionId = :id");
		query.setParameter("id", section.getNid());

		List<Unit> resultQuery = query.list();

		if (resultQuery.size() > 0) {
			section.setUnitList(resultQuery);
		}
	}


	
	public Company get(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Company company = (Company) session.get(Company.class, id);

		return company;
	}

	public void add(Company company) {
		Session session = sessionFactory.getCurrentSession();
		session.save(company);
	}

	public void saveOrUpdate(Company company) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(company);
	}

	public void delete(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Company company = (Company) session.get(Company.class, id);

		session.delete(company);
	}

	public void edit(Company company) {
		Session session = sessionFactory.getCurrentSession();
		Company target = (Company) session.get(Company.class, company.getNid());

		target.setNid(company.getNid());
		target.setCompanyCode(company.getCompanyCode());
		target.setRegistration(company.getRegistration());
		target.setCompanyName(company.getCompanyName());
		target.setAddress(company.getAddress());
		target.setCity(company.getCity());
		target.setCountry(company.getCountry());
		target.setPostcode(company.getPostcode());
		target.setTel(company.getTel());
		target.setDefaultCurrency(company.getDefaultCurrency());
		target.setParentCompany(company.getParentCompany());

		target.setLastUpdate(company.getLastUpdate());

		session.save(target);
	}
}