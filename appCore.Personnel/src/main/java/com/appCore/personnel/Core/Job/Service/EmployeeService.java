package com.appCore.personnel.Core.Job.Service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appCore.personnel.Core.Job.Entity.Employee;

@Service("employeeService")
@Transactional
public class EmployeeService
{ 

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<Employee> getAll() 
	{	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  Employee");

		return  query.list();
	}
	
	public List<Employee> getAllByCompany(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  Employee WHERE CompanyRef = :id");
		query.setParameter("id", id);
		return  query.list();
	}
	
	public Employee get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Employee employee = (Employee) session.get(Employee.class, id);

		return employee;
	}

	public void add(Employee employee) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(employee);
	}


	public void saveOrUpdate(Employee employee) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(employee);
	}


	public void delete(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Employee employee = (Employee) session.get(Employee.class, id);

		session.delete(employee);
	}

	public void edit(Employee employee) 
	{
		Session session = sessionFactory.getCurrentSession();
		Employee target = (Employee) session.get(Employee.class, employee.getNid());

		target.setNid(employee.getNid());
		target.setCode(employee.getCode());
		target.setDescription(employee.getDescription());
		target.setName(employee.getName());
		target.setFirstName(employee.getFirstName());
		target.setLastName(employee.getLastName());
		target.setMiddleName(employee.getMiddleName());
		target.setGender(employee.getGender());
		target.setSalutation(employee.getSalutation());
		target.setBirthDate(employee.getBirthDate());
		target.setAge(employee.getAge());
		target.setMaritalStatus(employee.getMaritalStatus());
		target.setMarriageDate(employee.getMarriageDate());
		target.setRace(employee.getRace());
		target.setReligion(employee.getReligion());
		target.setNationality(employee.getNationality());
		target.setCountryOrigin(employee.getCountryOrigin());
		target.setDisabled(employee.getDisabled());
		target.setLastUpdate(employee.getLastUpdate());

		session.save(target);
	}

	
}