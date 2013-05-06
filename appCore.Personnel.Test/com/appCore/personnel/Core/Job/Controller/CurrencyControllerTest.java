package com.appCore.personnel.Core.Job.Controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import com.appCore.personnel.Core.Job.Entity.Currency;
import com.appCore.personnel.Core.Job.Service.CurrencyService;

public class CurrencyControllerTest {

	@Test
	public void list() {

		List<Currency> fakeCurrencyList = new ArrayList<Currency>();
		Currency fakeCurrency = new Currency();
		fakeCurrencyList.add(fakeCurrency);

		CurrencyService mockedService = Mockito.mock(CurrencyService.class);
		CurrencyController controller = new CurrencyController();

		Mockito.when(mockedService.getAll()).thenReturn(fakeCurrencyList);

		ReflectionTestUtils.setField(controller, "service", mockedService);

		// Act
		List<Currency> result = controller.listCurrency();
		org.junit.Assert.assertEquals(result.size(), 1);

	}

	@Test
	public void get() {
		
		Currency fakeCurrency = new Currency();
		
		Integer fakeId = 1;

		CurrencyService mockedService = Mockito.mock(CurrencyService.class);
		CurrencyController controller = new CurrencyController();

		Mockito.when(mockedService.get(fakeId)).thenReturn(fakeCurrency);

		ReflectionTestUtils.setField(controller, "service", mockedService);

		// Act
		Currency result = controller.getCurrency(fakeId);

		org.junit.Assert.assertNotNull(result);
		
	}

	@Test
	public void saveOrUpdate() 
	{

		Currency fakeCurrency = new Currency();
		Integer fakeId = 1;

		CurrencyService mockedService = Mockito.mock(CurrencyService.class);
		CurrencyController controller = new CurrencyController();

		ReflectionTestUtils.setField(controller, "service", mockedService);

		// Act
		controller.saveOrUpdateCurrency(fakeCurrency);

		verify(mockedService, times(1)).saveOrUpdate(fakeCurrency);
	}

	@Test
	public void delete() 
	{

		Integer fakeId = 1;

		CurrencyService mockedService = Mockito.mock(CurrencyService.class);
		CurrencyController controller = new CurrencyController();

		ReflectionTestUtils.setField(controller, "service", mockedService);

		// Act
		controller.deleteCurrency(fakeId);

		verify(mockedService, times(1)).delete(fakeId);

	}

}
