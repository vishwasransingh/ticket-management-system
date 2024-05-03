package com.restapp.ticketmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapp.ticketmanagement.pojo.User;
import com.restapp.ticketmanagement.repository.UserRepository;

import reactor.core.publisher.Flux;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public Flux<User> getAllUsers() {
		return userRepository.getAllUsers();
	}
	
	
	
}
