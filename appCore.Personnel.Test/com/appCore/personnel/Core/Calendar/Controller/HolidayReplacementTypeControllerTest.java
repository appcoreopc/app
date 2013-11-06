package com.appCore.personnel.Core.Calendar.Controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import com.appCore.personnel.Core.Calendar.Entity.HolidayReplacementType;
import com.appCore.personnel.Core.Calendar.Service.HolidayReplacementTypeService;

public class HolidayReplacementTypeControllerTest {

	@Test
	public void list() {

		List<HolidayReplacementType> fakeHolidayReplacementTypeList = new ArrayList<HolidayReplacementType>();
		HolidayReplacementType fakeHolidayReplacementType = new HolidayReplacementType();
		fakeHolidayReplacementTypeList.add(fakeHolidayReplacementType);

		HolidayReplacementTypeService mockedService = Mockito.mock(HolidayReplacementTypeService.class);
		HolidayReplacementTypeController controller = new HolidayReplacementTypeController();

		Mockito.when(mockedService.getAll()).thenReturn(fakeHolidayReplacementTypeList);

		ReflectionTestUtils.setField(controller, "service", mockedService);

		// Act
		List<HolidayReplacementType> result = controller.listHolidayReplacementType();
		org.junit.Assert.assertEquals(result.size(), 1);

	}

	@Test
	public void get() {
		
		HolidayReplacementType fakeHolidayReplacementType = new HolidayReplacementType();
		
		Integer fakeId = 1;

		HolidayReplacementTypeService mockedService = Mockito.mock(HolidayReplacementTypeService.class);
		HolidayReplacementTypeController controller = new HolidayReplacementTypeController();

		Mockito.when(mockedService.get(fakeId)).thenReturn(fakeHolidayReplacementType);

		ReflectionTestUtils.setField(controller, "service", mockedService);

		// Act
		HolidayReplacementType result = controller.getHolidayReplacementType(fakeId);

		org.junit.Assert.assertNotNull(result);
		
	}

	@Test
	public void saveOrUpdate() 
	{

		HolidayReplacementType fakeHolidayReplacementType = new HolidayReplacementType();
		Integer fakeId = 1;

		HolidayReplacementTypeService mockedService = Mockito.mock(HolidayReplacementTypeService.class);
		HolidayReplacementTypeController controller = new HolidayReplacementTypeController();

		ReflectionTestUtils.setField(controller, "service", mockedService);

		// Act
		controller.saveOrUpdateHolidayReplacementType(fakeHolidayReplacementType);

		verify(mockedService, times(1)).saveOrUpdate(fakeHolidayReplacementType);
	}

	@Test
	public void delete() 
	{

		Integer fakeId = 1;

		HolidayReplacementTypeService mockedService = Mockito.mock(HolidayReplacementTypeService.class);
		HolidayReplacementTypeController controller = new HolidayReplacementTypeController();

		ReflectionTestUtils.setField(controller, "service", mockedService);

		// Act
		controller.deleteHolidayReplacementType(fakeId);

		verify(mockedService, times(1)).delete(fakeId);

	}

}
