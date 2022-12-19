package com.app.register.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.app.register.model.LoginHistory;
import com.app.register.model.UserRegister;


public interface Repository extends JpaRepository<UserRegister, Integer> {

	public UserRegister findByEmail(String email);

	public UserRegister findByEmailAndPassword(String email, String password);

	public Optional<UserRegister> findByFirstName(String firstName);
	
	public Optional<UserRegister> findById(int id);

	public static void save(LoginHistory loginHistory) {
		
		
	}


}
