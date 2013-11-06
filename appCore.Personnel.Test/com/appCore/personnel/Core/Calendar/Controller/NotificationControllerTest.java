package com.appCore.personnel.Core.Calendar.Controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import com.appCore.personnel.Core.Calendar.Entity.Notification;
import com.appCore.personnel.Core.Calendar.Service.NotificationService;

public class NotificationControllerTest {

	@Test
	public void list() {

		List<Notification> fakeNotificationList = new ArrayList<Notification>();
		Notification fakeNotification = new Notification();
		fakeNotificationList.add(fakeNotification);

		NotificationService mockedService = Mockito.mock(NotificationService.class);
		NotificationController controller = new NotificationController();

		Mockito.when(mockedService.getAll()).thenReturn(fakeNotificationList);

		ReflectionTestUtils.setField(controller, "service", mockedService);

		// Act
		List<Notification> result = controller.listNotification();
		org.junit.Assert.assertEquals(result.size(), 1);

	}

	@Test
	public void get() {
		
		Notification fakeNotification = new Notification();
		
		Integer fakeId = 1;

		NotificationService mockedService = Mockito.mock(NotificationService.class);
		NotificationController controller = new NotificationController();

		Mockito.when(mockedService.get(fakeId)).thenReturn(fakeNotification);

		ReflectionTestUtils.setField(controller, "service", mockedService);

		// Act
		Notification result = controller.getNotification(fakeId);

		org.junit.Assert.assertNotNull(result);
		
	}

	@Test
	public void saveOrUpdate() 
	{

		Notification fakeNotification = new Notification();
		Integer fakeId = 1;

		NotificationService mockedService = Mockito.mock(NotificationService.class);
		NotificationController controller = new NotificationController();

		ReflectionTestUtils.setField(controller, "service", mockedService);

		// Act
		controller.saveOrUpdateNotification(fakeNotification);

		verify(mockedService, times(1)).saveOrUpdate(fakeNotification);
	}

	@Test
	public void delete() 
	{

		Integer fakeId = 1;

		NotificationService mockedService = Mockito.mock(NotificationService.class);
		NotificationController controller = new NotificationController();

		ReflectionTestUtils.setField(controller, "service", mockedService);

		// Act
		controller.deleteNotification(fakeId);

		verify(mockedService, times(1)).delete(fakeId);

	}

}
