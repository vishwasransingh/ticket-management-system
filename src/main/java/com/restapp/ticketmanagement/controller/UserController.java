package com.restapp.ticketmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.restapp.ticketmanagement.pojo.User;
import com.restapp.ticketmanagement.repository.UserRepository;
import com.restapp.ticketmanagement.service.UserService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/users")
	public Mono<ResponseEntity<Flux<User>>> getAllUsers() {
		Flux<User> users = userService.getAllUsers();
		return Mono.just(ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(users));
	}
	
	@GetMapping("/user/{id}")
	public Mono<ResponseEntity<User>> getUser(@PathVariable("id") Integer id) {
		
		Mono<User> userMono = userService.getUser(id);
		
		return userMono.map(user -> ResponseEntity.ok().body(user))
                .defaultIfEmpty(ResponseEntity.notFound().build());
	}
	
}
