package com.appCore.personnel.Core.Job.Controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import com.appCore.personnel.Core.Job.Entity.Country;
import com.appCore.personnel.Core.Job.Service.CountryService;

public class CountryControllerTest {

	@Test
	public void list() {

		List<Country> fakeCountryList = new ArrayList<Country>();
		Country fakeCountry = new Country();
		fakeCountryList.add(fakeCountry);

		CountryService mockedService = Mockito.mock(CountryService.class);
		CountryController controller = new CountryController();

		Mockito.when(mockedService.getAll()).thenReturn(fakeCountryList);

		ReflectionTestUtils.setField(controller, "service", mockedService);

		// Act
		List<Country> userListFromService = controller.listCountry();
		org.junit.Assert.assertEquals(userListFromService.size(), 1);

	}

	@Test
	public void get() {
		String fakeProperty = "test@gmail.com";
		Country fakeCountry = new Country();
		fakeCountry.setName(fakeProperty);

		Integer fakeId = 1;

		CountryService mockedService = Mockito.mock(CountryService.class);
		CountryController controller = new CountryController();

		Mockito.when(mockedService.get(fakeId)).thenReturn(fakeCountry);

		ReflectionTestUtils.setField(controller, "service", mockedService);

		// Act
		Country result = controller.getCountry(fakeId);

		org.junit.Assert.assertNotNull(result);
		org.junit.Assert.assertEquals(fakeProperty, fakeCountry.getName());
	}

	@Test
	public void saveOrUpdate() {
		Country fakeCountry = new Country();
		Integer fakeId = 1;

		CountryService mockedService = Mockito.mock(CountryService.class);
		CountryController controller = new CountryController();

		ReflectionTestUtils.setField(controller, "service", mockedService);

		// Act
		controller.saveOrUpdateCountry(fakeCountry);

		verify(mockedService, times(1)).saveOrUpdate(fakeCountry);
	}

	@Test
	public void delete() {
		Integer fakeId = 1;

		CountryService mockedService = Mockito.mock(CountryService.class);
		CountryController controller = new CountryController();

		ReflectionTestUtils.setField(controller, "service", mockedService);

		// Act
		controller.deleteCountry(fakeId);

		verify(mockedService, times(1)).delete(fakeId);

	}

}
