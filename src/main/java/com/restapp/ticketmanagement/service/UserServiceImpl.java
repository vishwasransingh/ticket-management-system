package com.restapp.ticketmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapp.ticketmanagement.pojo.User;
import com.restapp.ticketmanagement.repository.UserRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public Flux<User> getAllUsers() {
		
		return userRepository.getAllUsers();
	}

	@Override
	public Mono<User> getUser(Integer id) {
		
		return userRepository.getUserById(id);
	}

	@Override
	public Mono<User> createUser(User user) {
		
		return userRepository.createUser(user);
	}

	@Override
	public Mono<User> updateUser(int id, User user) {

		return userRepository.getUserById(id)
                .flatMap(existingUser -> {
                    existingUser.setUsername(user.getUsername());
                    return userRepository.createUser(existingUser);
                });
	}

	@Override
    public Mono<Void> deleteUserById(int id) {
		
        return userRepository.deleteUser(id);
    }
	
	
	
}
