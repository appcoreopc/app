package com.appCore.personnel.Core.Calendar.Service;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import com.appCore.personnel.Core.Calendar.Entity.EmployeeHoliday;
import com.appCore.personnel.Core.Calendar.Service.EmployeeHolidayService;

public class EmployeeHolidayServiceTest {
	
	@Test
	public void testGetAll() {
	
		List<EmployeeHoliday> list = new ArrayList();
		list.add(new EmployeeHoliday());
		list.add(new EmployeeHoliday());
		
		EmployeeHolidayService service = new EmployeeHolidayService();
		
		SessionFactory mockedSessionFactory =  Mockito.mock(SessionFactory.class);
		Session mockedSession = Mockito.mock(Session.class);
	  Query mockedQuery = Mockito.mock(Query.class);
		
		Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
		Mockito.when(mockedSession.createQuery("FROM  EmployeeHoliday")).thenReturn(mockedQuery);
		Mockito.when(mockedQuery.list()).thenReturn(list);
		
		ReflectionTestUtils.setField(service, "sessionFactory", mockedSessionFactory);
		
		List<EmployeeHoliday> employeeHolidayData = service.getAll();
	
		org.junit.Assert.assertEquals(2, employeeHolidayData.size());
	
		verify(mockedSessionFactory).getCurrentSession();
		verify(mockedSession).createQuery("FROM  EmployeeHoliday");
		verify(mockedQuery, times(1)).list();
		
	}

	@Test
	public void testDelete()
	{
	
		EmployeeHolidayService service = new EmployeeHolidayService();
		
		EmployeeHoliday fakeEmployeeHoliday = new EmployeeHoliday();
		
		Integer fakeParamater = 1;
		
		SessionFactory mockedSessionFactory = Mockito.mock(SessionFactory.class);
		Session mockedSession = Mockito.mock(Session.class);
	  Query mockedQuery = Mockito.mock(Query.class);
	    
	  Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
	  Mockito.when(mockedSession.get(EmployeeHoliday.class, fakeParamater)).thenReturn(fakeEmployeeHoliday);
	    
	  ReflectionTestUtils.setField(service, "sessionFactory", mockedSessionFactory);
		
	  service.delete(fakeParamater);
		
	  verify(mockedSession).get(EmployeeHoliday.class, fakeParamater);
		verify(mockedSession).delete(fakeEmployeeHoliday);
		
	}
	
	@Test
	public void testGet()
	{
	
		EmployeeHolidayService service = new EmployeeHolidayService();
		EmployeeHoliday fakeEmployeeHoliday = new EmployeeHoliday();
	
		
		Integer fakeParamater = 1;
		
		SessionFactory mockedSessionFactory =  Mockito.mock(SessionFactory.class);
		Session mockedSession = Mockito.mock(Session.class);
	  Query mockedQuery = Mockito.mock(Query.class);
	    
	  Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
	  Mockito.when(mockedSession.get(EmployeeHoliday.class, fakeParamater)).thenReturn(fakeEmployeeHoliday);
	    
	  ReflectionTestUtils.setField(service, "sessionFactory", mockedSessionFactory);
		
		// Act
	  service.get(fakeParamater);
		
	  verify(mockedSession).get(EmployeeHoliday.class, fakeParamater);
		
	}

	@Test
	public void testSaveOrUpdate()
	{
		EmployeeHolidayService service = new EmployeeHolidayService();
				
		EmployeeHoliday fakeEmployeeHoliday = new EmployeeHoliday();
		
		
		SessionFactory mockedSessionFactory =  Mockito.mock(SessionFactory.class);
		Session mockedSession = Mockito.mock(Session.class);
	  Query mockedQuery = Mockito.mock(Query.class);
	    
	  Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
	   
	  ReflectionTestUtils.setField(service, "sessionFactory", mockedSessionFactory);
		
	  service.saveOrUpdate(fakeEmployeeHoliday);
	    
	  verify(mockedSession).saveOrUpdate(fakeEmployeeHoliday);
	  verify(mockedSession, times(1));
	}

	
}
