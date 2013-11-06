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

import com.appCore.personnel.Core.Calendar.Entity.EmployeeHolidayHistory;
import com.appCore.personnel.Core.Calendar.Service.EmployeeHolidayHistoryService;

public class EmployeeHolidayHistoryServiceTest {
	
	@Test
	public void testGetAll() {
	
		List<EmployeeHolidayHistory> list = new ArrayList();
		list.add(new EmployeeHolidayHistory());
		list.add(new EmployeeHolidayHistory());
		
		EmployeeHolidayHistoryService service = new EmployeeHolidayHistoryService();
		
		SessionFactory mockedSessionFactory =  Mockito.mock(SessionFactory.class);
		Session mockedSession = Mockito.mock(Session.class);
	  Query mockedQuery = Mockito.mock(Query.class);
		
		Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
		Mockito.when(mockedSession.createQuery("FROM  EmployeeHolidayHistory")).thenReturn(mockedQuery);
		Mockito.when(mockedQuery.list()).thenReturn(list);
		
		ReflectionTestUtils.setField(service, "sessionFactory", mockedSessionFactory);
		
		List<EmployeeHolidayHistory> employeeHolidayHistoryData = service.getAll();
	
		org.junit.Assert.assertEquals(2, employeeHolidayHistoryData.size());
	
		verify(mockedSessionFactory).getCurrentSession();
		verify(mockedSession).createQuery("FROM  EmployeeHolidayHistory");
		verify(mockedQuery, times(1)).list();
		
	}

	@Test
	public void testDelete()
	{
	
		EmployeeHolidayHistoryService service = new EmployeeHolidayHistoryService();
		
		EmployeeHolidayHistory fakeEmployeeHolidayHistory = new EmployeeHolidayHistory();
		
		Integer fakeParamater = 1;
		
		SessionFactory mockedSessionFactory = Mockito.mock(SessionFactory.class);
		Session mockedSession = Mockito.mock(Session.class);
	  Query mockedQuery = Mockito.mock(Query.class);
	    
	  Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
	  Mockito.when(mockedSession.get(EmployeeHolidayHistory.class, fakeParamater)).thenReturn(fakeEmployeeHolidayHistory);
	    
	  ReflectionTestUtils.setField(service, "sessionFactory", mockedSessionFactory);
		
	  service.delete(fakeParamater);
		
	  verify(mockedSession).get(EmployeeHolidayHistory.class, fakeParamater);
		verify(mockedSession).delete(fakeEmployeeHolidayHistory);
		
	}
	
	@Test
	public void testGet()
	{
	
		EmployeeHolidayHistoryService service = new EmployeeHolidayHistoryService();
		EmployeeHolidayHistory fakeEmployeeHolidayHistory = new EmployeeHolidayHistory();
	
		
		Integer fakeParamater = 1;
		
		SessionFactory mockedSessionFactory =  Mockito.mock(SessionFactory.class);
		Session mockedSession = Mockito.mock(Session.class);
	  Query mockedQuery = Mockito.mock(Query.class);
	    
	  Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
	  Mockito.when(mockedSession.get(EmployeeHolidayHistory.class, fakeParamater)).thenReturn(fakeEmployeeHolidayHistory);
	    
	  ReflectionTestUtils.setField(service, "sessionFactory", mockedSessionFactory);
		
		// Act
	  service.get(fakeParamater);
		
	  verify(mockedSession).get(EmployeeHolidayHistory.class, fakeParamater);
		
	}

	@Test
	public void testSaveOrUpdate()
	{
		EmployeeHolidayHistoryService service = new EmployeeHolidayHistoryService();
				
		EmployeeHolidayHistory fakeEmployeeHolidayHistory = new EmployeeHolidayHistory();
		
		
		SessionFactory mockedSessionFactory =  Mockito.mock(SessionFactory.class);
		Session mockedSession = Mockito.mock(Session.class);
	  Query mockedQuery = Mockito.mock(Query.class);
	    
	  Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
	   
	  ReflectionTestUtils.setField(service, "sessionFactory", mockedSessionFactory);
		
	  service.saveOrUpdate(fakeEmployeeHolidayHistory);
	    
	  verify(mockedSession).saveOrUpdate(fakeEmployeeHolidayHistory);
	  verify(mockedSession, times(1));
	}

	
}
