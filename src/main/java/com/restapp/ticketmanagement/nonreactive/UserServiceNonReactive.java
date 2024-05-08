package com.restapp.ticketmanagement.nonreactive;

import java.util.List;

import com.restapp.ticketmanagement.pojo.User;

public interface UserServiceNonReactive {
	
	public List<User> getAllUsers();
	
	public User getUserById(int id);
	
	public User createUser(User user);
	
	public void deleteUserById(int id);
	
	public User updateUser(int id, User user);
	
}
