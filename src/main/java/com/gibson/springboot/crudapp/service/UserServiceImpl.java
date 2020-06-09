package com.gibson.springboot.crudapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gibson.springboot.crudapp.dao.UserRepository;
import com.gibson.springboot.crudapp.entity.User;

@Service
public class UserServiceImpl implements UserService {
	private UserRepository repo;
	
	@Autowired
	public UserServiceImpl(UserRepository repo) {
		this.repo = repo;
	}
	@Override
	public List<User> findAll() {
		return repo.findAll();
	}

	@Override
	public User findById(int id) {
		Optional<User>result = repo.findById(id);
		User user = new User();
		if(result.isPresent()) {
			user = null;
		}else {
			throw new RuntimeException("Did not find user id of -- " + id);
		}
		return user;
	}

	@Override
	public User findByUsername(String username) {
		return repo.findByUsername(username);
	}
	
	public boolean checkIfUserExists(String username) {
		User user = this.findByUsername(username);
		Boolean result = user == null ? false : true;
		return result;
								
	}

	@Override
	public void save(User user) {
		repo.save(user);

	}

	@Override
	public void deleteById(int id) {
		repo.deleteById(id);

	}

}
