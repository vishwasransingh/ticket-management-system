package com.restapp.ticketmanagement.repository;

import com.restapp.ticketmanagement.pojo.User;

import reactor.core.publisher.Flux;

public interface UserRepository {
	Flux<User> getAllUsers();
}
