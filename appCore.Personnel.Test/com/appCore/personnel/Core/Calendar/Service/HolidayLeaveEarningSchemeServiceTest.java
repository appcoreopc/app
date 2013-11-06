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

import com.appCore.personnel.Core.Calendar.Entity.HolidayLeaveEarningScheme;
import com.appCore.personnel.Core.Calendar.Service.HolidayLeaveEarningSchemeService;

public class HolidayLeaveEarningSchemeServiceTest {
	
	@Test
	public void testGetAll() {
	
		List<HolidayLeaveEarningScheme> list = new ArrayList();
		list.add(new HolidayLeaveEarningScheme());
		list.add(new HolidayLeaveEarningScheme());
		
		HolidayLeaveEarningSchemeService service = new HolidayLeaveEarningSchemeService();
		
		SessionFactory mockedSessionFactory =  Mockito.mock(SessionFactory.class);
		Session mockedSession = Mockito.mock(Session.class);
	  Query mockedQuery = Mockito.mock(Query.class);
		
		Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
		Mockito.when(mockedSession.createQuery("FROM  HolidayLeaveEarningScheme")).thenReturn(mockedQuery);
		Mockito.when(mockedQuery.list()).thenReturn(list);
		
		ReflectionTestUtils.setField(service, "sessionFactory", mockedSessionFactory);
		
		List<HolidayLeaveEarningScheme> holidayLeaveEarningSchemeData = service.getAll();
	
		org.junit.Assert.assertEquals(2, holidayLeaveEarningSchemeData.size());
	
		verify(mockedSessionFactory).getCurrentSession();
		verify(mockedSession).createQuery("FROM  HolidayLeaveEarningScheme");
		verify(mockedQuery, times(1)).list();
		
	}

	@Test
	public void testDelete()
	{
	
		HolidayLeaveEarningSchemeService service = new HolidayLeaveEarningSchemeService();
		
		HolidayLeaveEarningScheme fakeHolidayLeaveEarningScheme = new HolidayLeaveEarningScheme();
		
		Integer fakeParamater = 1;
		
		SessionFactory mockedSessionFactory = Mockito.mock(SessionFactory.class);
		Session mockedSession = Mockito.mock(Session.class);
	  Query mockedQuery = Mockito.mock(Query.class);
	    
	  Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
	  Mockito.when(mockedSession.get(HolidayLeaveEarningScheme.class, fakeParamater)).thenReturn(fakeHolidayLeaveEarningScheme);
	    
	  ReflectionTestUtils.setField(service, "sessionFactory", mockedSessionFactory);
		
	  service.delete(fakeParamater);
		
	  verify(mockedSession).get(HolidayLeaveEarningScheme.class, fakeParamater);
		verify(mockedSession).delete(fakeHolidayLeaveEarningScheme);
		
	}
	
	@Test
	public void testGet()
	{
	
		HolidayLeaveEarningSchemeService service = new HolidayLeaveEarningSchemeService();
		HolidayLeaveEarningScheme fakeHolidayLeaveEarningScheme = new HolidayLeaveEarningScheme();
	
		
		Integer fakeParamater = 1;
		
		SessionFactory mockedSessionFactory =  Mockito.mock(SessionFactory.class);
		Session mockedSession = Mockito.mock(Session.class);
	  Query mockedQuery = Mockito.mock(Query.class);
	    
	  Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
	  Mockito.when(mockedSession.get(HolidayLeaveEarningScheme.class, fakeParamater)).thenReturn(fakeHolidayLeaveEarningScheme);
	    
	  ReflectionTestUtils.setField(service, "sessionFactory", mockedSessionFactory);
		
		// Act
	  service.get(fakeParamater);
		
	  verify(mockedSession).get(HolidayLeaveEarningScheme.class, fakeParamater);
		
	}

	@Test
	public void testSaveOrUpdate()
	{
		HolidayLeaveEarningSchemeService service = new HolidayLeaveEarningSchemeService();
				
		HolidayLeaveEarningScheme fakeHolidayLeaveEarningScheme = new HolidayLeaveEarningScheme();
		
		
		SessionFactory mockedSessionFactory =  Mockito.mock(SessionFactory.class);
		Session mockedSession = Mockito.mock(Session.class);
	  Query mockedQuery = Mockito.mock(Query.class);
	    
	  Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
	   
	  ReflectionTestUtils.setField(service, "sessionFactory", mockedSessionFactory);
		
	  service.saveOrUpdate(fakeHolidayLeaveEarningScheme);
	    
	  verify(mockedSession).saveOrUpdate(fakeHolidayLeaveEarningScheme);
	  verify(mockedSession, times(1));
	}

	
}
