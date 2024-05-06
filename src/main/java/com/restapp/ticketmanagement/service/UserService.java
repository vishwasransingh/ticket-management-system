package com.restapp.ticketmanagement.service;

import com.restapp.ticketmanagement.pojo.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
	
	Flux<User> getAllUsers();
	
	Mono<User> getUser(Integer id);
	
	Mono<User> createUser(User user);

	Mono<User> updateUser(int id, User user);

	Mono<Void> deleteUserById(int id);
	
}
