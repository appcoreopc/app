package com.appCore.personnel.Core.Calendar.Controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import com.appCore.personnel.Core.Calendar.Entity.EmployeeHolidayHistory;
import com.appCore.personnel.Core.Calendar.Service.EmployeeHolidayHistoryService;

public class EmployeeHolidayHistoryControllerTest {

	@Test
	public void list() {

		List<EmployeeHolidayHistory> fakeEmployeeHolidayHistoryList = new ArrayList<EmployeeHolidayHistory>();
		EmployeeHolidayHistory fakeEmployeeHolidayHistory = new EmployeeHolidayHistory();
		fakeEmployeeHolidayHistoryList.add(fakeEmployeeHolidayHistory);

		EmployeeHolidayHistoryService mockedService = Mockito.mock(EmployeeHolidayHistoryService.class);
		EmployeeHolidayHistoryController controller = new EmployeeHolidayHistoryController();

		Mockito.when(mockedService.getAll()).thenReturn(fakeEmployeeHolidayHistoryList);

		ReflectionTestUtils.setField(controller, "service", mockedService);

		// Act
		List<EmployeeHolidayHistory> result = controller.listEmployeeHolidayHistory();
		org.junit.Assert.assertEquals(result.size(), 1);

	}

	@Test
	public void get() {
		
		EmployeeHolidayHistory fakeEmployeeHolidayHistory = new EmployeeHolidayHistory();
		
		Integer fakeId = 1;

		EmployeeHolidayHistoryService mockedService = Mockito.mock(EmployeeHolidayHistoryService.class);
		EmployeeHolidayHistoryController controller = new EmployeeHolidayHistoryController();

		Mockito.when(mockedService.get(fakeId)).thenReturn(fakeEmployeeHolidayHistory);

		ReflectionTestUtils.setField(controller, "service", mockedService);

		// Act
		EmployeeHolidayHistory result = controller.getEmployeeHolidayHistory(fakeId);

		org.junit.Assert.assertNotNull(result);
		
	}

	@Test
	public void saveOrUpdate() 
	{

		EmployeeHolidayHistory fakeEmployeeHolidayHistory = new EmployeeHolidayHistory();
		Integer fakeId = 1;

		EmployeeHolidayHistoryService mockedService = Mockito.mock(EmployeeHolidayHistoryService.class);
		EmployeeHolidayHistoryController controller = new EmployeeHolidayHistoryController();

		ReflectionTestUtils.setField(controller, "service", mockedService);

		// Act
		controller.saveOrUpdateEmployeeHolidayHistory(fakeEmployeeHolidayHistory);

		verify(mockedService, times(1)).saveOrUpdate(fakeEmployeeHolidayHistory);
	}

	@Test
	public void delete() 
	{

		Integer fakeId = 1;

		EmployeeHolidayHistoryService mockedService = Mockito.mock(EmployeeHolidayHistoryService.class);
		EmployeeHolidayHistoryController controller = new EmployeeHolidayHistoryController();

		ReflectionTestUtils.setField(controller, "service", mockedService);

		// Act
		controller.deleteEmployeeHolidayHistory(fakeId);

		verify(mockedService, times(1)).delete(fakeId);

	}

}
