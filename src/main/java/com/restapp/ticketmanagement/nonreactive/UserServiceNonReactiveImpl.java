package com.restapp.ticketmanagement.nonreactive;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import com.restapp.ticketmanagement.pojo.User;

@Service
public class UserServiceNonReactiveImpl implements UserServiceNonReactive {

	Map<Integer, User> users = new HashMap<>();
	
	public UserServiceNonReactiveImpl() {
		
		users.put(1, new User(1, "A"));
		users.put(2, new User(2, "B"));
		users.put(3, new User(3, "C"));
		
	}
	
	@Override
	public List<User> getAllUsers() {
		
		return new ArrayList<>(users.values());
	}

	@Override
	public User getUserById(int id) {
		
		return users.get(id);
	}
	
	@Override
	public User createUser(User user) {
		
		int newId = users.keySet().stream()
				.mapToInt(Integer::intValue)
				.max()
				.orElse(0) + 1;
		user.setUserid(newId);
		users.put(newId, user);
		
		return user;
	}

	@Override
	public void deleteUserById(int id) {
		users.remove(id);		
	}

	@Override
	public User updateUser(int id, User user) {
		users.put(id, user);
		return user;
	}

}
