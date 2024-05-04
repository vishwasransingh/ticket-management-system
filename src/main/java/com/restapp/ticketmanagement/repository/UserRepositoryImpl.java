package com.restapp.ticketmanagement.repository;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.restapp.ticketmanagement.pojo.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class UserRepositoryImpl implements UserRepository {
	
	Map<Integer, User> users;

	public UserRepositoryImpl() {
		users = Map.of(
				1, (new User(1, "Vishwas")),
				2, (new User(2, "Satu")));
	}

	@Override
	public Flux<User> getAllUsers() {
		return Flux.fromIterable(this.users.values());
	}

	@Override
	public Mono<User> getUser(Integer id) {
		
		return Mono.justOrEmpty(this.users.get(id));
	}


}
