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

import com.appCore.personnel.Core.Calendar.Entity.HolidayEntitlementType;
import com.appCore.personnel.Core.Calendar.Service.HolidayEntitlementTypeService;

public class HolidayEntitlementTypeServiceTest {
	
	@Test
	public void testGetAll() {
	
		List<HolidayEntitlementType> list = new ArrayList();
		list.add(new HolidayEntitlementType());
		list.add(new HolidayEntitlementType());
		
		HolidayEntitlementTypeService service = new HolidayEntitlementTypeService();
		
		SessionFactory mockedSessionFactory =  Mockito.mock(SessionFactory.class);
		Session mockedSession = Mockito.mock(Session.class);
	  Query mockedQuery = Mockito.mock(Query.class);
		
		Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
		Mockito.when(mockedSession.createQuery("FROM  HolidayEntitlementType")).thenReturn(mockedQuery);
		Mockito.when(mockedQuery.list()).thenReturn(list);
		
		ReflectionTestUtils.setField(service, "sessionFactory", mockedSessionFactory);
		
		List<HolidayEntitlementType> holidayEntitlementTypeData = service.getAll();
	
		org.junit.Assert.assertEquals(2, holidayEntitlementTypeData.size());
	
		verify(mockedSessionFactory).getCurrentSession();
		verify(mockedSession).createQuery("FROM  HolidayEntitlementType");
		verify(mockedQuery, times(1)).list();
		
	}

	@Test
	public void testDelete()
	{
	
		HolidayEntitlementTypeService service = new HolidayEntitlementTypeService();
		
		HolidayEntitlementType fakeHolidayEntitlementType = new HolidayEntitlementType();
		
		Integer fakeParamater = 1;
		
		SessionFactory mockedSessionFactory = Mockito.mock(SessionFactory.class);
		Session mockedSession = Mockito.mock(Session.class);
	  Query mockedQuery = Mockito.mock(Query.class);
	    
	  Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
	  Mockito.when(mockedSession.get(HolidayEntitlementType.class, fakeParamater)).thenReturn(fakeHolidayEntitlementType);
	    
	  ReflectionTestUtils.setField(service, "sessionFactory", mockedSessionFactory);
		
	  service.delete(fakeParamater);
		
	  verify(mockedSession).get(HolidayEntitlementType.class, fakeParamater);
		verify(mockedSession).delete(fakeHolidayEntitlementType);
		
	}
	
	@Test
	public void testGet()
	{
	
		HolidayEntitlementTypeService service = new HolidayEntitlementTypeService();
		HolidayEntitlementType fakeHolidayEntitlementType = new HolidayEntitlementType();
	
		
		Integer fakeParamater = 1;
		
		SessionFactory mockedSessionFactory =  Mockito.mock(SessionFactory.class);
		Session mockedSession = Mockito.mock(Session.class);
	  Query mockedQuery = Mockito.mock(Query.class);
	    
	  Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
	  Mockito.when(mockedSession.get(HolidayEntitlementType.class, fakeParamater)).thenReturn(fakeHolidayEntitlementType);
	    
	  ReflectionTestUtils.setField(service, "sessionFactory", mockedSessionFactory);
		
		// Act
	  service.get(fakeParamater);
		
	  verify(mockedSession).get(HolidayEntitlementType.class, fakeParamater);
		
	}

	@Test
	public void testSaveOrUpdate()
	{
		HolidayEntitlementTypeService service = new HolidayEntitlementTypeService();
				
		HolidayEntitlementType fakeHolidayEntitlementType = new HolidayEntitlementType();
		
		
		SessionFactory mockedSessionFactory =  Mockito.mock(SessionFactory.class);
		Session mockedSession = Mockito.mock(Session.class);
	  Query mockedQuery = Mockito.mock(Query.class);
	    
	  Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
	   
	  ReflectionTestUtils.setField(service, "sessionFactory", mockedSessionFactory);
		
	  service.saveOrUpdate(fakeHolidayEntitlementType);
	    
	  verify(mockedSession).saveOrUpdate(fakeHolidayEntitlementType);
	  verify(mockedSession, times(1));
	}

	
}
