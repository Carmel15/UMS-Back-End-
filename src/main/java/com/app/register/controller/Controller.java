package com.app.register.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.app.register.model.LoginHistory;
import com.app.register.model.UserRegister;
import com.app.register.repository.LoginHistoryRepository;
import com.app.register.repository.Repository;
import com.app.register.service.RegistrationService;

import java.util.List;

@RestController
public class Controller {

	@Autowired
	private RegistrationService service;
	
	@Autowired
	LoginHistoryRepository loginHistoryRepository;

	@PostMapping("/registeruser")
	@CrossOrigin(origins = "http://localhost:3000")
	public UserRegister registerUser(@RequestBody UserRegister user) throws Exception {
		String tempEmailId = user.getEmail();
		if (tempEmailId != null && !"".equals(tempEmailId)) {
			UserRegister userObj = service.fetchUserByEmailId(tempEmailId);

			if (userObj != null) {
				throw new Exception("user with " + tempEmailId + " is already exists");
			}
		}
		UserRegister userObj = service.saveUser(user);
		return userObj;
	}

	@PostMapping("/updateuser/{id}")
	@CrossOrigin(origins = "http://localhost:3000")
	public UserRegister updateUser(@RequestBody UserRegister user) throws Exception {
		String tempEmailId = user.getEmail();

		if (tempEmailId != null && !"".equals(tempEmailId)) {
		}

		UserRegister userObj = null;
		userObj = service.saveUser(user);
		return userObj;
	}

	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:3000")
	public UserRegister loginUser(@RequestBody UserRegister user) throws Exception {
		String tempEmailId = user.getEmail();
		String tempPass = user.getPassword();
		UserRegister userObj = null;

		if (tempEmailId != null && tempPass != null) {
			userObj = service.fetchUserByEmailIdAndPassword(tempEmailId, tempPass);
			System.out.println("login success");

			LoginHistory loginHistory = new LoginHistory();

			loginHistory.setUser(userObj);

			LocalDateTime instant = LocalDateTime.now();
			loginHistory.setLastLoginTimeStamp(instant);
			loginHistoryRepository.save(loginHistory);
		}
		if (userObj == null) {
			throw new Exception("bad Credentials" );
		}
		return userObj;
	}

	@GetMapping("/getuserlist")
	@CrossOrigin(origins = "http://localhost:3000")
	public List<UserRegister> fetchUserList() {
		List<UserRegister> users = new ArrayList<UserRegister>();
		users = service.fetchUserList();
		return users;
	}

	@GetMapping("/getuserbyname/{firstName}")
	@CrossOrigin(origins = "http://localhost:3000")
	public UserRegister fetchUserByFirstName(@PathVariable String firstName) {
		System.out.println(firstName);
		return service.fetchUserByFirstName(firstName).get();
	}

	@GetMapping("/getuserbyid/{id}")
	@CrossOrigin(origins = "http://localhost:3000")
	public UserRegister fetchUserById(@PathVariable int id) {
		return service.fetchUserById(id).get();
	}

	@DeleteMapping("/deleteuserbyid/{id}")
	@CrossOrigin(origins = "http://localhost:3000")
	public String DeleteUserById(@PathVariable int id) {
		service.deleteUserById(id);
		return "User deleted successfully ";
	}

}
