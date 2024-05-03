package com.restapp.ticketmanagement.service;

import com.restapp.ticketmanagement.pojo.User;

import reactor.core.publisher.Flux;

public interface UserService {
	
	Flux<User> getAllUsers();
	
}
