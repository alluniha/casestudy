package com.example.demo;

import java.util.List;

public interface UserInterface {
	public List<User> login(String username, String password);
	public int createUser(User user);
	public List<User> getAllUsers();
}
