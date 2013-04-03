package com.appCore.personnel.User.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.annotation.Resource;
import javax.crypto.NoSuchPaddingException;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.log4j.Logger;

import com.appCore.Requests.RequestStatus;
import com.appCore.Requests.UserAuthenticationRequestStatus;
import com.appCore.Security.Users.EncodedKey;
import com.appCore.Security.Users.SecureDataKeyProvider;
import com.appCore.Security.Users.SecureKeyProvider;
import com.appCore.personnel.Core.Helpers.RequestStatusHelper;
import com.appCore.personnel.User.Entity.Roles;
import com.appCore.personnel.User.Entity.UserLandingPage;
import com.appCore.personnel.User.Entity.Users;

import com.appCore.personnel.User.Service.UserLandingPageService;
import com.appCore.personnel.User.Service.UsersService;

@Controller
@RequestMapping("/Users")
public class UsersController {

	protected static Logger logger = Logger.getLogger("controller");
	
	@Resource(name = "usersService")
	private UsersService service;

	@Resource(name = "userLandingPageService")
	private UserLandingPageService userLandingservice;

	@RequestMapping(value = "/Users/list", method = RequestMethod.GET)
	public @ResponseBody
	List<Users> listUsers() {
		List<Users> list = service.getAll();
		return list;
	}

	@RequestMapping(value = "/Users/get", method = RequestMethod.GET)
	public @ResponseBody
	Users getUsers(@RequestParam(value = "id", required = true) Integer id) {
		Users users = service.get(id);
		return users;
	}

	@RequestMapping(value = "/Users/authenticate", method = RequestMethod.GET)
	public @ResponseBody
	UserAuthenticationRequestStatus authenticateSecureUser(@ModelAttribute Users user) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, IOException {
		
		EncodedKey encodedKeyPair = new EncodedKey();
		encodedKeyPair.setPublicKey("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCiPFWSQ8SyhSPmZUEipn14PbVX+EG+I93H9WW2Ay4zHqxST/TnPihcPJnJJy7ADlooITCD91Z6mkg/bwBIoWzQAOlHcFOHxTBei6mgxfiDMSWAW77jeCmzOh8gMsBAHP9lWBpBOeqhf5Kao2DMmumVLcz4O2X1fYN88p+ICthLcQIDAQAB");
		encodedKeyPair.setPrivateKey("MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAKI8VZJDxLKFI+ZlQSKmfXg9tVf4Qb4j3cf1ZbYDLjMerFJP9Oc+KFw8mcknLsAOWighMIP3VnqaSD9vAEihbNAA6UdwU4fFMF6LqaDF+IMxJYBbvuN4KbM6HyAywEAc/2VYGkE56qF/kpqjYMya6ZUtzPg7ZfV9g3zyn4gK2EtxAgMBAAECgYAnw3/5xJBubQGak9C+LG5uTTmoYRnD/8h5HSWb0fW949O6rQxKrUp5KQVMb0UfH6VrVo8smS/iBvSUT6GTK7WedKNIvC82HTcNs2asyl3TwNCZuBVy6t6zMXLz7EEtpGE7yJkOE3wopvP6kr1S6yhSWjhmeu2kEfJ/Ig2h7FfZwQJBAO663tfHn/SEnVxKlciOas+KyANuIk5hJlzye/Pd8k/FQJmqFP1HttreqrBNUde5olLg9BeClhk5ut2UdpXg2/kCQQCt+NZpd/7CCbCqtCD7jk2BfTpJUNmjQ2Cq5+4gnhgZpfDCYJNPdFyXyJ2O9b7/gYX2l8rngAEAgw0fNwYDrBk5AkBQXkrNG+BGoiqTumxIc2GT8yW4uegEuQIAQoXmKG792esQkEi2p+DwOAwAhFcsJ8t02VRzYbwETAITvHpbpLKJAkEApG/UcgIaiVtRYjg6CKubtK4h/pRt8fRIlaH9IVVtICkJ5SAVfP9WWZ0k17COJMFPVyJoheImkE5Og9elVqk/eQJALtLQbCBRTZN6eTm3oF+hU5W8YJkwWbfmNbAU4DIDiRYdnjf0YaSI56ooogwu0P7nXDup60EyjQQbtRvxXJB0Jw==");

		SecureDataKeyProvider secureKeyProvider = new SecureKeyProvider();
	
		String decryptedUsername = secureKeyProvider.decrypt(encodedKeyPair.getPrivateKey(), user.getUsername());
		String decryptedPassword = secureKeyProvider.decrypt(encodedKeyPair.getPrivateKey(), user.getPassword());
		
		return service.authenticateUser(decryptedUsername, decryptedPassword);
		
	}

	@RequestMapping(value = "/Users/validateLogin", method = RequestMethod.GET)
	public @ResponseBody UserAuthenticationRequestStatus getUsers(@ModelAttribute Users user) 
	{
		UserAuthenticationRequestStatus statusResponse = new UserAuthenticationRequestStatus();
		statusResponse.setMessageCode(-1);
		statusResponse.setMessageDescription("Login fails");

		List<Users> userVerificationResult = service.get(user.getUsername(),
				user.getPassword());
		service.getRole(1);

		if (userVerificationResult.size() > 0) {
			Users userFromStore = userVerificationResult.get(0);

			statusResponse.setUsername(user.getUsername());
			// status.setEmployeeRole();
			statusResponse.setMessageCode(0);
			statusResponse.setMessageDescription("User logins successfully.");

			List<UserLandingPage> userLandingData = userLandingservice
					.getByUserId(userFromStore.getNid());

			if (userLandingData.size() > 0) {
				UserLandingPage userLanding = userLandingData.get(0);
				statusResponse.setLandingPage(userLanding.getLandingPage());
			}
		}
		return statusResponse;
	}
	

	@RequestMapping(value = "/Users/add", method = RequestMethod.POST)
	public @ResponseBody
	RequestStatus addUsers(@RequestBody Users users) {
		boolean userAddState = service.add(users);
		if (userAddState)
			return RequestStatusHelper.GenerateRequestStatusSaveOperation();
		else
			return RequestStatusHelper.GenerateErrorMessage(
					"Unable to save duplicate user", -1);
	}

	@RequestMapping(value = "/Users/saveOrUpdate", method = RequestMethod.POST)
	public @ResponseBody
	RequestStatus saveOrUpdateUsers(@RequestBody Users users) {
		service.saveOrUpdate(users);
		return RequestStatusHelper.GenerateRequestStatusSaveOperation();
	}

}