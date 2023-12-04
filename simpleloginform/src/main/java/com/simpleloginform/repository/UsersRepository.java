package com.simpleloginform.repository;

import java.util.Optional;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;


import com.simpleloginform.model.UsersModel;



@Configuration
@ComponentScan(basePackages = "com.simplelogininform.repository")

public interface UsersRepository extends JpaRepository<UsersModel, Integer> {

	
	Optional<UsersModel> findByloginAndPassword(String login, String password);
}