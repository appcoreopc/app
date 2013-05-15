package com.appCore.personnel.User.Controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import com.appCore.personnel.User.Entity.Roles;
import com.appCore.personnel.User.Service.RolesService;

public class RolesControllerTest {

	@Test
	public void list() {

		List<Roles> fakeRolesList = new ArrayList<Roles>();
		Roles fakeRoles = new Roles();
		fakeRolesList.add(fakeRoles);

		RolesService mockedService = Mockito.mock(RolesService.class);
		RolesController controller = new RolesController();

		Mockito.when(mockedService.getAll()).thenReturn(fakeRolesList);

		ReflectionTestUtils.setField(controller, "service", mockedService);

		// Act
		List<Roles> result = controller.listRoles();
		org.junit.Assert.assertEquals(result.size(), 1);

	}

	@Test
	public void get() {
		
		Roles fakeRoles = new Roles();
		
		Integer fakeId = 1;

		RolesService mockedService = Mockito.mock(RolesService.class);
		RolesController controller = new RolesController();

		Mockito.when(mockedService.get(fakeId)).thenReturn(fakeRoles);

		ReflectionTestUtils.setField(controller, "service", mockedService);

		// Act
		Roles result = controller.getRoles(fakeId);

		org.junit.Assert.assertNotNull(result);
		
	}

	@Test
	public void saveOrUpdate() 
	{

		Roles fakeRoles = new Roles();
		Integer fakeId = 1;

		RolesService mockedService = Mockito.mock(RolesService.class);
		RolesController controller = new RolesController();

		ReflectionTestUtils.setField(controller, "service", mockedService);

		// Act
		controller.saveOrUpdateRoles(fakeRoles);

		verify(mockedService, times(1)).saveOrUpdate(fakeRoles);
	}

	@Test
	public void delete() 
	{

		Integer fakeId = 1;

		RolesService mockedService = Mockito.mock(RolesService.class);
		RolesController controller = new RolesController();

		ReflectionTestUtils.setField(controller, "service", mockedService);

		// Act
		controller.deleteRoles(fakeId);

		verify(mockedService, times(1)).delete(fakeId);

	}

}
