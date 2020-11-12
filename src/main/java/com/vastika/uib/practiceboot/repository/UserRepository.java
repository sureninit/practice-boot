package com.vastika.uib.practiceboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vastika.uib.practiceboot.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByName(String name);

	public User findByNameAndPassword(String name, String password);

	//public UserModel findbyName(String name);

}
