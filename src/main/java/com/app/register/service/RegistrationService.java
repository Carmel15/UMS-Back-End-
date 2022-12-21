package com.app.register.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.register.model.LoginHistory;
import com.app.register.model.UserRegister;
import com.app.register.repository.LoginHistoryRepository;
import com.app.register.repository.Repository;
import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {
	@Autowired
	private Repository repo;
	@Autowired
	private LoginHistoryRepository rep;


	public UserRegister saveUser(UserRegister user) {
		return repo.save(user);
	}

	public UserRegister fetchUserByEmailId(String email) {
		return repo.findByEmail(email);
	}

	public UserRegister fetchUserByEmailIdAndPassword(String email, String password) {
		return repo.findByEmailAndPassword(email, password);
	}

	public List<UserRegister> fetchUserList() {
		return repo.findAll();
	}
	public List<LoginHistory> fetchhistoryList() {
		return rep.findAll();
	}
	public Optional<UserRegister> fetchUserByFirstName(String firstName) {
		return repo.findByFirstName(firstName);
	}

	public String deleteUserById(int id) {
		String result;
		try {
			repo.deleteById(id);
			result = "User Successfully Deleted";
		} catch (Exception e) {
			result = "User with id is not deleted";
		}
		return result;
	}

	public Optional<UserRegister> fetchUserById(int id) {
		return repo.findById(id);

	}
}
