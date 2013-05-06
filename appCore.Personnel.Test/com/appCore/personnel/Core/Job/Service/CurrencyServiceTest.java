package com.appCore.personnel.Core.Job.Service;

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

import com.appCore.personnel.Core.Job.Entity.Currency;
import com.appCore.personnel.Core.Job.Service.CurrencyService;

public class CurrencyServiceTest {
	
	@Test
	public void testGetAll() {
	
		List<Currency> list = new ArrayList();
		list.add(new Currency());
		list.add(new Currency());
		
		CurrencyService service = new CurrencyService();
		
		SessionFactory mockedSessionFactory =  Mockito.mock(SessionFactory.class);
		Session mockedSession = Mockito.mock(Session.class);
	  Query mockedQuery = Mockito.mock(Query.class);
		
		Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
		Mockito.when(mockedSession.createQuery("FROM  Currency")).thenReturn(mockedQuery);
		Mockito.when(mockedQuery.list()).thenReturn(list);
		
		ReflectionTestUtils.setField(service, "sessionFactory", mockedSessionFactory);
		
		List<Currency> currencyData = service.getAll();
	
		org.junit.Assert.assertEquals(2, currencyData.size());
	
		verify(mockedSessionFactory).getCurrentSession();
		verify(mockedSession).createQuery("FROM  Currency");
		verify(mockedQuery, times(1)).list();
		
	}

	@Test
	public void testDelete()
	{
	
		CurrencyService service = new CurrencyService();
		
		Currency fakeCurrency = new Currency();
		
		Integer fakeParamater = 1;
		
		SessionFactory mockedSessionFactory = Mockito.mock(SessionFactory.class);
		Session mockedSession = Mockito.mock(Session.class);
	  Query mockedQuery = Mockito.mock(Query.class);
	    
	  Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
	  Mockito.when(mockedSession.get(Currency.class, fakeParamater)).thenReturn(fakeCurrency);
	    
	  ReflectionTestUtils.setField(service, "sessionFactory", mockedSessionFactory);
		
	  service.delete(fakeParamater);
		
	  verify(mockedSession).get(Currency.class, fakeParamater);
		verify(mockedSession).delete(fakeCurrency);
		
	}
	
	@Test
	public void testGet()
	{
	
		CurrencyService service = new CurrencyService();
		Currency fakeCurrency = new Currency();
	
		
		Integer fakeParamater = 1;
		
		SessionFactory mockedSessionFactory =  Mockito.mock(SessionFactory.class);
		Session mockedSession = Mockito.mock(Session.class);
	  Query mockedQuery = Mockito.mock(Query.class);
	    
	  Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
	  Mockito.when(mockedSession.get(Currency.class, fakeParamater)).thenReturn(fakeCurrency);
	    
	  ReflectionTestUtils.setField(service, "sessionFactory", mockedSessionFactory);
		
		// Act
	  service.get(fakeParamater);
		
	  verify(mockedSession).get(Currency.class, fakeParamater);
		
	}

	@Test
	public void testSaveOrUpdate()
	{
		CurrencyService service = new CurrencyService();
				
		Currency fakeCurrency = new Currency();
		
		
		SessionFactory mockedSessionFactory =  Mockito.mock(SessionFactory.class);
		Session mockedSession = Mockito.mock(Session.class);
	  Query mockedQuery = Mockito.mock(Query.class);
	    
	  Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
	   
	  ReflectionTestUtils.setField(service, "sessionFactory", mockedSessionFactory);
		
	  service.saveOrUpdate(fakeCurrency);
	    
	  verify(mockedSession).saveOrUpdate(fakeCurrency);
	  verify(mockedSession, times(1));
	}

	
}
