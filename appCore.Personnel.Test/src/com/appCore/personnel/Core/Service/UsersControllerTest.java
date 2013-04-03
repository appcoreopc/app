package src.com.appCore.personnel.Core.Service;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.junit.Test;
import org.junit.Assert;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.servlet.ModelAndView;

import com.appCore.personnel.User.Controller.UsersController;
import com.appCore.personnel.User.Entity.Users;
import com.appCore.personnel.User.Service.UsersService;

public class UsersControllerTest {
	
	@Test
	public void listUsers()
	{
		
		List<Users> fakeUserList = new ArrayList<Users>();
		String fakeEmailAddress = "test@gmail.com";
		Users fakeUser = new Users();
		fakeUser.setEmail(fakeEmailAddress);
		
		fakeUserList.add(fakeUser);
		
		UsersService mockedService = Mockito.mock(UsersService.class);
		UsersController controller = new UsersController();
		
		Mockito.when(mockedService.getAll()).thenReturn(fakeUserList);
		
		ReflectionTestUtils.setField(controller, "service", mockedService);
		
		// Act
		List<Users> userListFromService = controller.listUsers();
		org.junit.Assert.assertEquals(userListFromService.size(), 1);
		
	}	
		
	
	@Test
	public void getUser()
	{
		// Arrange
		// Fake user list 
		String fakeEmailAddress = "test@gmail.com";
		Users fakeUser = new Users();
		fakeUser.setEmail(fakeEmailAddress);
		
		int fakeUserId = 1;
		
		UsersService mockedService = Mockito.mock(UsersService.class);
		UsersController controller = new UsersController();
		
		Mockito.when(mockedService.get(fakeUserId)).thenReturn(fakeUser);
		
		ReflectionTestUtils.setField(controller, "service", mockedService);
	
		// Act
		Users userFromService = controller.getUsers(fakeUserId);
		
		// Assert 
		org.junit.Assert.assertEquals(fakeEmailAddress, userFromService.getEmail());
		
		verify(mockedService).get(fakeUserId);
	}
	
}
