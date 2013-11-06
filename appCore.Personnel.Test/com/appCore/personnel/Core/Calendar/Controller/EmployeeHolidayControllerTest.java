package com.appCore.personnel.Core.Calendar.Controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import com.appCore.personnel.Core.Calendar.Entity.EmployeeHoliday;
import com.appCore.personnel.Core.Calendar.Service.EmployeeHolidayService;

public class EmployeeHolidayControllerTest {

	@Test
	public void list() {

		List<EmployeeHoliday> fakeEmployeeHolidayList = new ArrayList<EmployeeHoliday>();
		EmployeeHoliday fakeEmployeeHoliday = new EmployeeHoliday();
		fakeEmployeeHolidayList.add(fakeEmployeeHoliday);

		EmployeeHolidayService mockedService = Mockito.mock(EmployeeHolidayService.class);
		EmployeeHolidayController controller = new EmployeeHolidayController();

		Mockito.when(mockedService.getAll()).thenReturn(fakeEmployeeHolidayList);

		ReflectionTestUtils.setField(controller, "service", mockedService);

		// Act
		List<EmployeeHoliday> result = controller.listEmployeeHoliday();
		org.junit.Assert.assertEquals(result.size(), 1);

	}

	@Test
	public void get() {
		
		EmployeeHoliday fakeEmployeeHoliday = new EmployeeHoliday();
		
		Integer fakeId = 1;

		EmployeeHolidayService mockedService = Mockito.mock(EmployeeHolidayService.class);
		EmployeeHolidayController controller = new EmployeeHolidayController();

		Mockito.when(mockedService.get(fakeId)).thenReturn(fakeEmployeeHoliday);

		ReflectionTestUtils.setField(controller, "service", mockedService);

		// Act
		EmployeeHoliday result = controller.getEmployeeHoliday(fakeId);

		org.junit.Assert.assertNotNull(result);
		
	}

	@Test
	public void saveOrUpdate() 
	{

		EmployeeHoliday fakeEmployeeHoliday = new EmployeeHoliday();
		Integer fakeId = 1;

		EmployeeHolidayService mockedService = Mockito.mock(EmployeeHolidayService.class);
		EmployeeHolidayController controller = new EmployeeHolidayController();

		ReflectionTestUtils.setField(controller, "service", mockedService);

		// Act
		controller.saveOrUpdateEmployeeHoliday(fakeEmployeeHoliday);

		verify(mockedService, times(1)).saveOrUpdate(fakeEmployeeHoliday);
	}

	@Test
	public void delete() 
	{

		Integer fakeId = 1;

		EmployeeHolidayService mockedService = Mockito.mock(EmployeeHolidayService.class);
		EmployeeHolidayController controller = new EmployeeHolidayController();

		ReflectionTestUtils.setField(controller, "service", mockedService);

		// Act
		controller.deleteEmployeeHoliday(fakeId);

		verify(mockedService, times(1)).delete(fakeId);

	}

}
