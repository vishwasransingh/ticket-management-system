package com.restapp.ticketmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("/users/{id}")
	public Mono<ResponseEntity<User>> getUser(@PathVariable("id") Integer id) {
		
		Mono<User> userMono = userService.getUser(id);
		
		return userMono.map(user -> ResponseEntity.ok().body(user))
                .defaultIfEmpty(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/users")
	public Mono<ResponseEntity<User>> createUser(@RequestBody User user) {
		
		System.out.println("UserController.createUser()" + user);
		
		Mono<User> createdUserMono = userService.createUser(user);
		return createdUserMono.map(createdUser -> ResponseEntity.ok().body(createdUser))
				  .defaultIfEmpty(ResponseEntity.internalServerError().build());
	}
	
	@PutMapping("/users/{id}")
	public Mono<ResponseEntity<User>> updateUser(@PathVariable int id, @RequestBody User user) {
		Mono<User> createdUserMono = userService.updateUser(id, user);
		return createdUserMono.map(createdUser -> ResponseEntity.ok().body(createdUser))
				.defaultIfEmpty(ResponseEntity.internalServerError().build());
	}
	
	@DeleteMapping("/users/{id}")
    public Mono<ResponseEntity<Void>> deleteUser(@PathVariable int id) {
        return userService.deleteUserById(id)
            .then(Mono.just(ResponseEntity.noContent().<Void>build()))
            .onErrorResume(e -> Mono.just(ResponseEntity.notFound().build()));
    }
}
