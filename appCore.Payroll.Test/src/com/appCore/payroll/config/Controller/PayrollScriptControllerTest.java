package com.appCore.payroll.config.Controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import com.appCore.payroll.config.Entity.PayrollScript;
import com.appCore.payroll.config.Service.PayrollScriptService;

public class PayrollScriptControllerTest {

	@Test
	public void list() {

		List<PayrollScript> fakePayrollScriptList = new ArrayList<PayrollScript>();
		PayrollScript fakePayrollScript = new PayrollScript();
		fakePayrollScriptList.add(fakePayrollScript);

		PayrollScriptService mockedService = Mockito.mock(PayrollScriptService.class);
		PayrollScriptController controller = new PayrollScriptController();

		Mockito.when(mockedService.getAll()).thenReturn(fakePayrollScriptList);

		ReflectionTestUtils.setField(controller, "service", mockedService);

		// Act
		List<PayrollScript> result = controller.listPayrollScript();
		org.junit.Assert.assertEquals(result.size(), 1);

	}

	@Test
	public void get() {
		
		PayrollScript fakePayrollScript = new PayrollScript();
		
		Integer fakeId = 1;

		PayrollScriptService mockedService = Mockito.mock(PayrollScriptService.class);
		PayrollScriptController controller = new PayrollScriptController();

		Mockito.when(mockedService.get(fakeId)).thenReturn(fakePayrollScript);

		ReflectionTestUtils.setField(controller, "service", mockedService);

		// Act
		PayrollScript result = controller.getPayrollScript(fakeId);

		org.junit.Assert.assertNotNull(result);
		
	}

	@Test
	public void saveOrUpdate() 
	{

		PayrollScript fakePayrollScript = new PayrollScript();
		Integer fakeId = 1;

		PayrollScriptService mockedService = Mockito.mock(PayrollScriptService.class);
		PayrollScriptController controller = new PayrollScriptController();

		ReflectionTestUtils.setField(controller, "service", mockedService);

		// Act
		controller.saveOrUpdatePayrollScript(fakePayrollScript);

		verify(mockedService, times(1)).saveOrUpdate(fakePayrollScript);
	}

	@Test
	public void delete() 
	{

		Integer fakeId = 1;

		PayrollScriptService mockedService = Mockito.mock(PayrollScriptService.class);
		PayrollScriptController controller = new PayrollScriptController();

		ReflectionTestUtils.setField(controller, "service", mockedService);

		// Act
		controller.deletePayrollScript(fakeId);

		verify(mockedService, times(1)).delete(fakeId);

	}

}
