package com.appCore.personnel.Core.Calendar.Controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import com.appCore.personnel.Core.Calendar.Entity.HolidayLeaveEarningScheme;
import com.appCore.personnel.Core.Calendar.Service.HolidayLeaveEarningSchemeService;

public class HolidayLeaveEarningSchemeControllerTest {

	@Test
	public void list() {

		List<HolidayLeaveEarningScheme> fakeHolidayLeaveEarningSchemeList = new ArrayList<HolidayLeaveEarningScheme>();
		HolidayLeaveEarningScheme fakeHolidayLeaveEarningScheme = new HolidayLeaveEarningScheme();
		fakeHolidayLeaveEarningSchemeList.add(fakeHolidayLeaveEarningScheme);

		HolidayLeaveEarningSchemeService mockedService = Mockito.mock(HolidayLeaveEarningSchemeService.class);
		HolidayLeaveEarningSchemeController controller = new HolidayLeaveEarningSchemeController();

		Mockito.when(mockedService.getAll()).thenReturn(fakeHolidayLeaveEarningSchemeList);

		ReflectionTestUtils.setField(controller, "service", mockedService);

		// Act
		List<HolidayLeaveEarningScheme> result = controller.listHolidayLeaveEarningScheme();
		org.junit.Assert.assertEquals(result.size(), 1);

	}

	@Test
	public void get() {
		
		HolidayLeaveEarningScheme fakeHolidayLeaveEarningScheme = new HolidayLeaveEarningScheme();
		
		Integer fakeId = 1;

		HolidayLeaveEarningSchemeService mockedService = Mockito.mock(HolidayLeaveEarningSchemeService.class);
		HolidayLeaveEarningSchemeController controller = new HolidayLeaveEarningSchemeController();

		Mockito.when(mockedService.get(fakeId)).thenReturn(fakeHolidayLeaveEarningScheme);

		ReflectionTestUtils.setField(controller, "service", mockedService);

		// Act
		HolidayLeaveEarningScheme result = controller.getHolidayLeaveEarningScheme(fakeId);

		org.junit.Assert.assertNotNull(result);
		
	}

	@Test
	public void saveOrUpdate() 
	{

		HolidayLeaveEarningScheme fakeHolidayLeaveEarningScheme = new HolidayLeaveEarningScheme();
		Integer fakeId = 1;

		HolidayLeaveEarningSchemeService mockedService = Mockito.mock(HolidayLeaveEarningSchemeService.class);
		HolidayLeaveEarningSchemeController controller = new HolidayLeaveEarningSchemeController();

		ReflectionTestUtils.setField(controller, "service", mockedService);

		// Act
		controller.saveOrUpdateHolidayLeaveEarningScheme(fakeHolidayLeaveEarningScheme);

		verify(mockedService, times(1)).saveOrUpdate(fakeHolidayLeaveEarningScheme);
	}

	@Test
	public void delete() 
	{

		Integer fakeId = 1;

		HolidayLeaveEarningSchemeService mockedService = Mockito.mock(HolidayLeaveEarningSchemeService.class);
		HolidayLeaveEarningSchemeController controller = new HolidayLeaveEarningSchemeController();

		ReflectionTestUtils.setField(controller, "service", mockedService);

		// Act
		controller.deleteHolidayLeaveEarningScheme(fakeId);

		verify(mockedService, times(1)).delete(fakeId);

	}

}
