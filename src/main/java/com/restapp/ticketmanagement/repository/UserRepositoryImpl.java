package com.restapp.ticketmanagement.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.restapp.ticketmanagement.pojo.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class UserRepositoryImpl implements UserRepository {
	
	Map<Integer, User> users = new HashMap<>();

	public UserRepositoryImpl() {		
		users.put(1, (new User(1, "Vishwas")));
		users.put(2, (new User(2, "Satu")));
	}

	@Override
	public Flux<User> getAllUsers() {
		return Flux.fromIterable(this.users.values());
	}

	@Override
	public Mono<User> getUserById(Integer id) {
		
		return Mono.justOrEmpty(this.users.get(id));
	}

	@Override
	public Mono<User> createUser(User user) {
		
		int newId = users.keySet().stream().mapToInt(Integer::intValue).max().orElse(0) + 1;
		
		user.setUserid(newId);
		
		users.put(newId, user);
		
		return Mono.just(user);
	}
	
	@Override
	public Mono<Void> deleteUser(int id) {
		users.remove(id);
		return Mono.empty();
	}


}
