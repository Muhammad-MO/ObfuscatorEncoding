package com.simpleloginform.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.simpleloginform.repository.UsersRepository;
import com.simpleloginform.model.UsersModel;



@Service
public class UsersService {
	private final UsersRepository usersRepository;
	
	
	 @Autowired
	    public UsersService(UsersRepository usersRepository) {
	        this.usersRepository = usersRepository;
	    }
	  
	

	
	
	public UsersModel registerUser(String login, String password, String email) {
		
		if(login == null || password ==null) {
			return null;
		}
		else {
			
			UsersModel usersModel = new UsersModel();
			usersModel.setLogin(login);
			usersModel.setPassword(password);
			usersModel.setEmail(email);
			UsersModel savedUser =  usersRepository.save(usersModel);
			System.out.println("Regstered User:" + savedUser);
			return savedUser;
		}
			
			
		}
	
	
	public UsersModel authenticate(String login, String password) {
		return usersRepository.findByloginAndPassword(login, password).orElse(null);
		
	}
	}


