package com.appCore.personnel.Core.Calendar.Controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import com.appCore.personnel.Core.Calendar.Entity.LeaveWorkflow;
import com.appCore.personnel.Core.Calendar.Service.LeaveWorkflowService;

public class LeaveWorkflowControllerTest {

	@Test
	public void list() {

		List<LeaveWorkflow> fakeLeaveWorkflowList = new ArrayList<LeaveWorkflow>();
		LeaveWorkflow fakeLeaveWorkflow = new LeaveWorkflow();
		fakeLeaveWorkflowList.add(fakeLeaveWorkflow);

		LeaveWorkflowService mockedService = Mockito.mock(LeaveWorkflowService.class);
		LeaveWorkflowController controller = new LeaveWorkflowController();

		Mockito.when(mockedService.getAll()).thenReturn(fakeLeaveWorkflowList);

		ReflectionTestUtils.setField(controller, "service", mockedService);

		// Act
		List<LeaveWorkflow> result = controller.listLeaveWorkflow();
		org.junit.Assert.assertEquals(result.size(), 1);

	}

	@Test
	public void get() {
		
		LeaveWorkflow fakeLeaveWorkflow = new LeaveWorkflow();
		
		Integer fakeId = 1;

		LeaveWorkflowService mockedService = Mockito.mock(LeaveWorkflowService.class);
		LeaveWorkflowController controller = new LeaveWorkflowController();

		Mockito.when(mockedService.get(fakeId)).thenReturn(fakeLeaveWorkflow);

		ReflectionTestUtils.setField(controller, "service", mockedService);

		// Act
		LeaveWorkflow result = controller.getLeaveWorkflow(fakeId);

		org.junit.Assert.assertNotNull(result);
		
	}

	@Test
	public void saveOrUpdate() 
	{

		LeaveWorkflow fakeLeaveWorkflow = new LeaveWorkflow();
		Integer fakeId = 1;

		LeaveWorkflowService mockedService = Mockito.mock(LeaveWorkflowService.class);
		LeaveWorkflowController controller = new LeaveWorkflowController();

		ReflectionTestUtils.setField(controller, "service", mockedService);

		// Act
		controller.saveOrUpdateLeaveWorkflow(fakeLeaveWorkflow);

		verify(mockedService, times(1)).saveOrUpdate(fakeLeaveWorkflow);
	}

	@Test
	public void delete() 
	{

		Integer fakeId = 1;

		LeaveWorkflowService mockedService = Mockito.mock(LeaveWorkflowService.class);
		LeaveWorkflowController controller = new LeaveWorkflowController();

		ReflectionTestUtils.setField(controller, "service", mockedService);

		// Act
		controller.deleteLeaveWorkflow(fakeId);

		verify(mockedService, times(1)).delete(fakeId);

	}

}
