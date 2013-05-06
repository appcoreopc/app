package src.com.appCore.personnel.Core.Service;

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

import com.appCore.personnel.Core.Entity.Branch;
import com.appCore.personnel.Core.Entity.BranchInfo;
import com.appCore.personnel.Core.Service.BranchService;

public class BranchServiceTest {
	
	@Test
	public void testGetAll() {
	
		List<Branch> list = new ArrayList();
		list.add(new Branch());
		list.add(new Branch());
		
		BranchService service = new BranchService();
		
		SessionFactory mockedSessionFactory =  Mockito.mock(SessionFactory.class);
		Session mockedSession = Mockito.mock(Session.class);
	    Query mockedQuery = Mockito.mock(Query.class);
		
		Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
		Mockito.when(mockedSession.createQuery("FROM  Branch")).thenReturn(mockedQuery);
		Mockito.when(mockedQuery.list()).thenReturn(list);
		
		ReflectionTestUtils.setField(service, "sessionFactory", mockedSessionFactory);
		
		List<Branch> branchData = service.getAll();
	
		org.junit.Assert.assertEquals(2, branchData.size());
		
		verify(mockedSessionFactory).getCurrentSession();
		verify(mockedSession).createQuery("FROM  Branch");
		verify(mockedQuery, times(1)).list();
		
	}
	
	@Test
	public void testGet()
	{
		BranchService service = new BranchService();
		
		List<BranchInfo> branchInfoList = new ArrayList<BranchInfo>();
		branchInfoList.add(new BranchInfo());
		branchInfoList.add(new BranchInfo());
		
		String fakeBranchCode = "Test";
		Branch fakeBranch = new Branch();
		fakeBranch.setBranchCode(fakeBranchCode);
		
		int fakeParamater = 1; 
		
		SessionFactory mockedSessionFactory =  Mockito.mock(SessionFactory.class);
		Session mockedSession = Mockito.mock(Session.class);
	    Query mockedQuery = Mockito.mock(Query.class);
	    
	    Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
	    Mockito.when(mockedSession.get(Branch.class, fakeParamater)).thenReturn(fakeBranch);
	    Mockito.when(mockedSession.createQuery("FROM BranchInfo WHERE RefEntity = :id")).thenReturn(mockedQuery);
	    Mockito.when(mockedQuery.list()).thenReturn(branchInfoList);
	    
	    ReflectionTestUtils.setField(service, "sessionFactory", mockedSessionFactory);
	    
	    Branch branchFromDatastore = service.get(fakeParamater);
	    org.junit.Assert.assertEquals(fakeBranchCode, branchFromDatastore.getBranchCode());
	    

	}
	
	@Test
	public void testSaveOrUpdate()
	{
		BranchService service = new BranchService();
		
		String fakeBranchCode = "Test";
		Branch fakeBranch = new Branch();
		fakeBranch.setBranchCode(fakeBranchCode);
		
		SessionFactory mockedSessionFactory =  Mockito.mock(SessionFactory.class);
		Session mockedSession = Mockito.mock(Session.class);
	    Query mockedQuery = Mockito.mock(Query.class);
	    
	    Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
	    
	    ReflectionTestUtils.setField(service, "sessionFactory", mockedSessionFactory);
		
	    service.saveOrUpdate(fakeBranch);
	    
	    verify(mockedSession).saveOrUpdate(fakeBranch);
	    verify(mockedSession, times(1));
	}
	
	@Test
	public void testDelete()
	{
	
		BranchService service = new BranchService();
		
		String fakeBranchCode = "Test";
		Branch fakeBranch = new Branch();
		fakeBranch.setBranchCode(fakeBranchCode);
		
		Integer fakeParamater = 1;
		
		SessionFactory mockedSessionFactory =  Mockito.mock(SessionFactory.class);
		Session mockedSession = Mockito.mock(Session.class);
	    Query mockedQuery = Mockito.mock(Query.class);
	    
	    Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
	    Mockito.when(mockedSession.get(Branch.class, fakeParamater)).thenReturn(fakeBranch);
	    
	    ReflectionTestUtils.setField(service, "sessionFactory", mockedSessionFactory);
		
	    service.delete(fakeParamater);
		verify(mockedSession).get(Branch.class, fakeParamater);
		verify(mockedSession).delete(fakeBranch);
		
	}
	
}
