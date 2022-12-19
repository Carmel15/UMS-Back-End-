package com.app.register.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.register.model.LoginHistory;


@Repository("loginHistoryRepository")
public interface LoginHistoryRepository extends JpaRepository<LoginHistory, Integer> {

}
