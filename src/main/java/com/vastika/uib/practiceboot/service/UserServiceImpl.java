package com.vastika.uib.practiceboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vastika.uib.practiceboot.model.Role;
import com.vastika.uib.practiceboot.model.User;
import com.vastika.uib.practiceboot.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void saveUser(User user) {
		Role role = new Role();
		role.setId(2);
		role.setRoleName("ROLE_USER");
		user.setRole(role);
		userRepository.save(user);
		
	}

	@Override
	public User getUserById(int id) {
		return userRepository.findById(id).get();
		
		
	}

	@Override
	public void deleteById(int id) {
		userRepository.deleteById(id);
		
	}

	@Override
	public void update(User user) {
		userRepository.save(user);
		
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public User getByName(String name) {
		User user = userRepository.findByName(name);
		return user;
		
	}

	@Override
	public User findbyNameAndPassword(String name, String password) {
		User user = userRepository.findByNameAndPassword(name,password);
		return user;
	}

//	@Override
//	public UserModel findbyName(String name) {
//		return userRepository.findbyName(name);
//	}

	

	

	

	



}
