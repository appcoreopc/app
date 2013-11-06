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

import com.appCore.personnel.Core.Calendar.Entity.Notification;
import com.appCore.personnel.Core.Calendar.Service.NotificationService;

public class NotificationServiceTest {
	
	@Test
	public void testGetAll() {
	
		List<Notification> list = new ArrayList();
		list.add(new Notification());
		list.add(new Notification());
		
		NotificationService service = new NotificationService();
		
		SessionFactory mockedSessionFactory =  Mockito.mock(SessionFactory.class);
		Session mockedSession = Mockito.mock(Session.class);
	  Query mockedQuery = Mockito.mock(Query.class);
		
		Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
		Mockito.when(mockedSession.createQuery("FROM  Notification")).thenReturn(mockedQuery);
		Mockito.when(mockedQuery.list()).thenReturn(list);
		
		ReflectionTestUtils.setField(service, "sessionFactory", mockedSessionFactory);
		
		List<Notification> notificationData = service.getAll();
	
		org.junit.Assert.assertEquals(2, notificationData.size());
	
		verify(mockedSessionFactory).getCurrentSession();
		verify(mockedSession).createQuery("FROM  Notification");
		verify(mockedQuery, times(1)).list();
		
	}

	@Test
	public void testDelete()
	{
	
		NotificationService service = new NotificationService();
		
		Notification fakeNotification = new Notification();
		
		Integer fakeParamater = 1;
		
		SessionFactory mockedSessionFactory = Mockito.mock(SessionFactory.class);
		Session mockedSession = Mockito.mock(Session.class);
	  Query mockedQuery = Mockito.mock(Query.class);
	    
	  Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
	  Mockito.when(mockedSession.get(Notification.class, fakeParamater)).thenReturn(fakeNotification);
	    
	  ReflectionTestUtils.setField(service, "sessionFactory", mockedSessionFactory);
		
	  service.delete(fakeParamater);
		
	  verify(mockedSession).get(Notification.class, fakeParamater);
		verify(mockedSession).delete(fakeNotification);
		
	}
	
	@Test
	public void testGet()
	{
	
		NotificationService service = new NotificationService();
		Notification fakeNotification = new Notification();
	
		
		Integer fakeParamater = 1;
		
		SessionFactory mockedSessionFactory =  Mockito.mock(SessionFactory.class);
		Session mockedSession = Mockito.mock(Session.class);
	  Query mockedQuery = Mockito.mock(Query.class);
	    
	  Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
	  Mockito.when(mockedSession.get(Notification.class, fakeParamater)).thenReturn(fakeNotification);
	    
	  ReflectionTestUtils.setField(service, "sessionFactory", mockedSessionFactory);
		
		// Act
	  service.get(fakeParamater);
		
	  verify(mockedSession).get(Notification.class, fakeParamater);
		
	}

	@Test
	public void testSaveOrUpdate()
	{
		NotificationService service = new NotificationService();
				
		Notification fakeNotification = new Notification();
		
		
		SessionFactory mockedSessionFactory =  Mockito.mock(SessionFactory.class);
		Session mockedSession = Mockito.mock(Session.class);
	  Query mockedQuery = Mockito.mock(Query.class);
	    
	  Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
	   
	  ReflectionTestUtils.setField(service, "sessionFactory", mockedSessionFactory);
		
	  service.saveOrUpdate(fakeNotification);
	    
	  verify(mockedSession).saveOrUpdate(fakeNotification);
	  verify(mockedSession, times(1));
	}

	
}
