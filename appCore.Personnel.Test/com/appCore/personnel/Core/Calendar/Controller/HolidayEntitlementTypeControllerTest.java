package com.appCore.personnel.Core.Calendar.Controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import com.appCore.personnel.Core.Calendar.Entity.HolidayEntitlementType;
import com.appCore.personnel.Core.Calendar.Service.HolidayEntitlementTypeService;

public class HolidayEntitlementTypeControllerTest {

	@Test
	public void list() {

		List<HolidayEntitlementType> fakeHolidayEntitlementTypeList = new ArrayList<HolidayEntitlementType>();
		HolidayEntitlementType fakeHolidayEntitlementType = new HolidayEntitlementType();
		fakeHolidayEntitlementTypeList.add(fakeHolidayEntitlementType);

		HolidayEntitlementTypeService mockedService = Mockito.mock(HolidayEntitlementTypeService.class);
		HolidayEntitlementTypeController controller = new HolidayEntitlementTypeController();

		Mockito.when(mockedService.getAll()).thenReturn(fakeHolidayEntitlementTypeList);

		ReflectionTestUtils.setField(controller, "service", mockedService);

		// Act
		List<HolidayEntitlementType> result = controller.listHolidayEntitlementType();
		org.junit.Assert.assertEquals(result.size(), 1);

	}

	@Test
	public void get() {
		
		HolidayEntitlementType fakeHolidayEntitlementType = new HolidayEntitlementType();
		
		Integer fakeId = 1;

		HolidayEntitlementTypeService mockedService = Mockito.mock(HolidayEntitlementTypeService.class);
		HolidayEntitlementTypeController controller = new HolidayEntitlementTypeController();

		Mockito.when(mockedService.get(fakeId)).thenReturn(fakeHolidayEntitlementType);

		ReflectionTestUtils.setField(controller, "service", mockedService);

		// Act
		HolidayEntitlementType result = controller.getHolidayEntitlementType(fakeId);

		org.junit.Assert.assertNotNull(result);
		
	}

	@Test
	public void saveOrUpdate() 
	{

		HolidayEntitlementType fakeHolidayEntitlementType = new HolidayEntitlementType();
		Integer fakeId = 1;

		HolidayEntitlementTypeService mockedService = Mockito.mock(HolidayEntitlementTypeService.class);
		HolidayEntitlementTypeController controller = new HolidayEntitlementTypeController();

		ReflectionTestUtils.setField(controller, "service", mockedService);

		// Act
		controller.saveOrUpdateHolidayEntitlementType(fakeHolidayEntitlementType);

		verify(mockedService, times(1)).saveOrUpdate(fakeHolidayEntitlementType);
	}

	@Test
	public void delete() 
	{

		Integer fakeId = 1;

		HolidayEntitlementTypeService mockedService = Mockito.mock(HolidayEntitlementTypeService.class);
		HolidayEntitlementTypeController controller = new HolidayEntitlementTypeController();

		ReflectionTestUtils.setField(controller, "service", mockedService);

		// Act
		controller.deleteHolidayEntitlementType(fakeId);

		verify(mockedService, times(1)).delete(fakeId);

	}

}
