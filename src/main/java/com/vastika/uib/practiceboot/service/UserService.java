package com.vastika.uib.practiceboot.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.vastika.uib.practiceboot.model.User;


public interface UserService {

	public void saveUser(User user);
	
	public User getUserById(int id);
	
	public void deleteById(int id);
	
	public void update(User user);
	
	public List<User> getAllUser();
	
	public User getByName(String name);
	
	public User findbyNameAndPassword(String name, String password);
	
	
	
//	public void saveAllUser(AllUserModel all);
	
	
	
}
