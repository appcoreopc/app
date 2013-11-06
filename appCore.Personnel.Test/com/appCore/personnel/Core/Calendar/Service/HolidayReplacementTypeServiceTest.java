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

import com.appCore.personnel.Core.Calendar.Entity.HolidayReplacementType;
import com.appCore.personnel.Core.Calendar.Service.HolidayReplacementTypeService;

public class HolidayReplacementTypeServiceTest {
	
	@Test
	public void testGetAll() {
	
		List<HolidayReplacementType> list = new ArrayList();
		list.add(new HolidayReplacementType());
		list.add(new HolidayReplacementType());
		
		HolidayReplacementTypeService service = new HolidayReplacementTypeService();
		
		SessionFactory mockedSessionFactory =  Mockito.mock(SessionFactory.class);
		Session mockedSession = Mockito.mock(Session.class);
	  Query mockedQuery = Mockito.mock(Query.class);
		
		Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
		Mockito.when(mockedSession.createQuery("FROM  HolidayReplacementType")).thenReturn(mockedQuery);
		Mockito.when(mockedQuery.list()).thenReturn(list);
		
		ReflectionTestUtils.setField(service, "sessionFactory", mockedSessionFactory);
		
		List<HolidayReplacementType> holidayReplacementTypeData = service.getAll();
	
		org.junit.Assert.assertEquals(2, holidayReplacementTypeData.size());
	
		verify(mockedSessionFactory).getCurrentSession();
		verify(mockedSession).createQuery("FROM  HolidayReplacementType");
		verify(mockedQuery, times(1)).list();
		
	}

	@Test
	public void testDelete()
	{
	
		HolidayReplacementTypeService service = new HolidayReplacementTypeService();
		
		HolidayReplacementType fakeHolidayReplacementType = new HolidayReplacementType();
		
		Integer fakeParamater = 1;
		
		SessionFactory mockedSessionFactory = Mockito.mock(SessionFactory.class);
		Session mockedSession = Mockito.mock(Session.class);
	  Query mockedQuery = Mockito.mock(Query.class);
	    
	  Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
	  Mockito.when(mockedSession.get(HolidayReplacementType.class, fakeParamater)).thenReturn(fakeHolidayReplacementType);
	    
	  ReflectionTestUtils.setField(service, "sessionFactory", mockedSessionFactory);
		
	  service.delete(fakeParamater);
		
	  verify(mockedSession).get(HolidayReplacementType.class, fakeParamater);
		verify(mockedSession).delete(fakeHolidayReplacementType);
		
	}
	
	@Test
	public void testGet()
	{
	
		HolidayReplacementTypeService service = new HolidayReplacementTypeService();
		HolidayReplacementType fakeHolidayReplacementType = new HolidayReplacementType();
	
		
		Integer fakeParamater = 1;
		
		SessionFactory mockedSessionFactory =  Mockito.mock(SessionFactory.class);
		Session mockedSession = Mockito.mock(Session.class);
	  Query mockedQuery = Mockito.mock(Query.class);
	    
	  Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
	  Mockito.when(mockedSession.get(HolidayReplacementType.class, fakeParamater)).thenReturn(fakeHolidayReplacementType);
	    
	  ReflectionTestUtils.setField(service, "sessionFactory", mockedSessionFactory);
		
		// Act
	  service.get(fakeParamater);
		
	  verify(mockedSession).get(HolidayReplacementType.class, fakeParamater);
		
	}

	@Test
	public void testSaveOrUpdate()
	{
		HolidayReplacementTypeService service = new HolidayReplacementTypeService();
				
		HolidayReplacementType fakeHolidayReplacementType = new HolidayReplacementType();
		
		
		SessionFactory mockedSessionFactory =  Mockito.mock(SessionFactory.class);
		Session mockedSession = Mockito.mock(Session.class);
	  Query mockedQuery = Mockito.mock(Query.class);
	    
	  Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
	   
	  ReflectionTestUtils.setField(service, "sessionFactory", mockedSessionFactory);
		
	  service.saveOrUpdate(fakeHolidayReplacementType);
	    
	  verify(mockedSession).saveOrUpdate(fakeHolidayReplacementType);
	  verify(mockedSession, times(1));
	}

	
}
