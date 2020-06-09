package com.gibson.springboot.crudapp.service;

import java.util.List;

import com.gibson.springboot.crudapp.entity.User;


public interface UserService {
	public List<User> findAll();
	
	public User findById(int id);
	
	public User findByUsername(String username);
	
	public void save(User user);
	
	public void deleteById(int id);
}
