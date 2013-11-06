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

import com.appCore.personnel.Core.Calendar.Entity.LeaveWorkflow;
import com.appCore.personnel.Core.Calendar.Service.LeaveWorkflowService;

public class LeaveWorkflowServiceTest {
	
	@Test
	public void testGetAll() {
	
		List<LeaveWorkflow> list = new ArrayList();
		list.add(new LeaveWorkflow());
		list.add(new LeaveWorkflow());
		
		LeaveWorkflowService service = new LeaveWorkflowService();
		
		SessionFactory mockedSessionFactory =  Mockito.mock(SessionFactory.class);
		Session mockedSession = Mockito.mock(Session.class);
	  Query mockedQuery = Mockito.mock(Query.class);
		
		Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
		Mockito.when(mockedSession.createQuery("FROM  LeaveWorkflow")).thenReturn(mockedQuery);
		Mockito.when(mockedQuery.list()).thenReturn(list);
		
		ReflectionTestUtils.setField(service, "sessionFactory", mockedSessionFactory);
		
		List<LeaveWorkflow> leaveWorkflowData = service.getAll();
	
		org.junit.Assert.assertEquals(2, leaveWorkflowData.size());
	
		verify(mockedSessionFactory).getCurrentSession();
		verify(mockedSession).createQuery("FROM  LeaveWorkflow");
		verify(mockedQuery, times(1)).list();
		
	}

	@Test
	public void testDelete()
	{
	
		LeaveWorkflowService service = new LeaveWorkflowService();
		
		LeaveWorkflow fakeLeaveWorkflow = new LeaveWorkflow();
		
		Integer fakeParamater = 1;
		
		SessionFactory mockedSessionFactory = Mockito.mock(SessionFactory.class);
		Session mockedSession = Mockito.mock(Session.class);
	  Query mockedQuery = Mockito.mock(Query.class);
	    
	  Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
	  Mockito.when(mockedSession.get(LeaveWorkflow.class, fakeParamater)).thenReturn(fakeLeaveWorkflow);
	    
	  ReflectionTestUtils.setField(service, "sessionFactory", mockedSessionFactory);
		
	  service.delete(fakeParamater);
		
	  verify(mockedSession).get(LeaveWorkflow.class, fakeParamater);
		verify(mockedSession).delete(fakeLeaveWorkflow);
		
	}
	
	@Test
	public void testGet()
	{
	
		LeaveWorkflowService service = new LeaveWorkflowService();
		LeaveWorkflow fakeLeaveWorkflow = new LeaveWorkflow();
	
		
		Integer fakeParamater = 1;
		
		SessionFactory mockedSessionFactory =  Mockito.mock(SessionFactory.class);
		Session mockedSession = Mockito.mock(Session.class);
	  Query mockedQuery = Mockito.mock(Query.class);
	    
	  Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
	  Mockito.when(mockedSession.get(LeaveWorkflow.class, fakeParamater)).thenReturn(fakeLeaveWorkflow);
	    
	  ReflectionTestUtils.setField(service, "sessionFactory", mockedSessionFactory);
		
		// Act
	  service.get(fakeParamater);
		
	  verify(mockedSession).get(LeaveWorkflow.class, fakeParamater);
		
	}

	@Test
	public void testSaveOrUpdate()
	{
		LeaveWorkflowService service = new LeaveWorkflowService();
				
		LeaveWorkflow fakeLeaveWorkflow = new LeaveWorkflow();
		
		
		SessionFactory mockedSessionFactory =  Mockito.mock(SessionFactory.class);
		Session mockedSession = Mockito.mock(Session.class);
	  Query mockedQuery = Mockito.mock(Query.class);
	    
	  Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
	   
	  ReflectionTestUtils.setField(service, "sessionFactory", mockedSessionFactory);
		
	  service.saveOrUpdate(fakeLeaveWorkflow);
	    
	  verify(mockedSession).saveOrUpdate(fakeLeaveWorkflow);
	  verify(mockedSession, times(1));
	}

	
}
