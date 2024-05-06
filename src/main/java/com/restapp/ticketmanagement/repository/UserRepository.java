package com.restapp.ticketmanagement.repository;

import com.restapp.ticketmanagement.pojo.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRepository {
	Flux<User> getAllUsers();
	Mono<User> getUserById(Integer id);
	Mono<User> createUser(User user);
	Mono<Void> deleteUser(int id);	
}
