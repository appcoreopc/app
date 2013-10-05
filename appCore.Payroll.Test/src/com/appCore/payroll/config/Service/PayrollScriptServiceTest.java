package com.appCore.payroll.config.Service;

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

import com.appCore.payroll.config.Entity.PayrollScript;
import com.appCore.payroll.config.Service.PayrollScriptService;

public class PayrollScriptServiceTest {
	
	@Test
	public void testGetAll() {
	
		List<PayrollScript> list = new ArrayList();
		list.add(new PayrollScript());
		list.add(new PayrollScript());
		
		PayrollScriptService service = new PayrollScriptService();
		
		SessionFactory mockedSessionFactory =  Mockito.mock(SessionFactory.class);
		Session mockedSession = Mockito.mock(Session.class);
		Query mockedQuery = Mockito.mock(Query.class);
		
		Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
		Mockito.when(mockedSession.createQuery("FROM  PayrollScript")).thenReturn(mockedQuery);
		Mockito.when(mockedQuery.list()).thenReturn(list);
		
		ReflectionTestUtils.setField(service, "sessionFactory", mockedSessionFactory);
		
		List<PayrollScript> payrollScriptData = service.getAll();
	
		org.junit.Assert.assertEquals(2, payrollScriptData.size());
	
		verify(mockedSessionFactory).getCurrentSession();
		verify(mockedSession).createQuery("FROM  PayrollScript");
		verify(mockedQuery, times(1)).list();
		
	}

	@Test
	public void testDelete()
	{
	
		PayrollScriptService service = new PayrollScriptService();
		
		PayrollScript fakePayrollScript = new PayrollScript();
		
		Integer fakeParamater = 1;
		
		SessionFactory mockedSessionFactory = Mockito.mock(SessionFactory.class);
		Session mockedSession = Mockito.mock(Session.class);
	  Query mockedQuery = Mockito.mock(Query.class);
	    
	  Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
	  Mockito.when(mockedSession.get(PayrollScript.class, fakeParamater)).thenReturn(fakePayrollScript);
	    
	  ReflectionTestUtils.setField(service, "sessionFactory", mockedSessionFactory);
		
	  service.delete(fakeParamater);
		
	  verify(mockedSession).get(PayrollScript.class, fakeParamater);
		verify(mockedSession).delete(fakePayrollScript);
		
	}
	
	@Test
	public void testGet()
	{
	
		PayrollScriptService service = new PayrollScriptService();
		PayrollScript fakePayrollScript = new PayrollScript();
	
		
		Integer fakeParamater = 1;
		
		SessionFactory mockedSessionFactory =  Mockito.mock(SessionFactory.class);
		Session mockedSession = Mockito.mock(Session.class);
	  Query mockedQuery = Mockito.mock(Query.class);
	    
	  Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
	  Mockito.when(mockedSession.get(PayrollScript.class, fakeParamater)).thenReturn(fakePayrollScript);
	    
	  ReflectionTestUtils.setField(service, "sessionFactory", mockedSessionFactory);
		
		// Act
	  service.get(fakeParamater);
		
	  verify(mockedSession).get(PayrollScript.class, fakeParamater);
		
	}

	@Test
	public void testSaveOrUpdate()
	{
		PayrollScriptService service = new PayrollScriptService();
				
		PayrollScript fakePayrollScript = new PayrollScript();
		
		
		SessionFactory mockedSessionFactory =  Mockito.mock(SessionFactory.class);
		Session mockedSession = Mockito.mock(Session.class);
	  Query mockedQuery = Mockito.mock(Query.class);
	    
	  Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
	   
	  ReflectionTestUtils.setField(service, "sessionFactory", mockedSessionFactory);
		
	  service.saveOrUpdate(fakePayrollScript);
	    
	  verify(mockedSession).saveOrUpdate(fakePayrollScript);
	  verify(mockedSession, times(1));
	}

	
}
