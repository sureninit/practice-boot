package com.vastika.uib.practiceboot.controller;

import java.util.List;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vastika.uib.practiceboot.model.User;
import com.vastika.uib.practiceboot.repository.UserRepository;
import com.vastika.uib.practiceboot.service.UserService;

@RestController
@RequestMapping(value="/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserContro {
	
	private UserService userService;
	
	public UserContro(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value="/check")
	public String check() {
		return "check";
	}
	
	@PostMapping
	public void save(@RequestBody User user) {
		userService.saveUser(user);
	}
	
	@GetMapping("/{id}")
	public User getUser(@PathVariable int id) {
		return userService.getUserById(id);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		userService.deleteById(id);
		
	}
	
	@PutMapping
	public void update(@RequestBody User user) {
		userService.update(user);
	}
	
	@GetMapping
	public List<User> getAll(){
		return userService.getAllUser();
	}
	
//	@PostMapping("/login")
//	public UserModel findByName(@RequestBody UserModel user) throws Exception {
//		UserModel user1 = null;
//		String name = user.getName();
//		if(name !=null && !"".equals(name)){
//			user1 = userService.findbyName(name);
//		}
//		if(user1 == null) {
//			throw new Exception("Bad Credentials");
//		}
//		return user1;
//	}
	// only for username. It works good 
	@PostMapping("/login")
	public User getByName(@RequestBody User user) throws Exception {
		User userObj = null;
		String tempUsername = user.getName();
		if(tempUsername != null && !"".equals(tempUsername)) {
			userObj = userService.getByName(tempUsername);
		}
		if(userObj == null) {
			throw new Exception("Bad Credentials");
		}
		return userObj;
		
	}
	
	
	//login page for username and password
	@PostMapping("/login2")
	public User getByNameAndPassword(@RequestBody User user) throws Exception {
		User userObj = null;
		System.out.println(user.getName()+" "+user.getPassword());
		String tempUsername = user.getName();
		String tempPassword = user.getPassword();
		if(tempUsername != null && tempPassword != null) {
			userObj = userService.findbyNameAndPassword(tempUsername, tempPassword);
		}
		if(userObj == null) {
			throw new Exception("User name and Password arenot matches");
		}
		return userObj;
	
		
	}
	
	
	
}
