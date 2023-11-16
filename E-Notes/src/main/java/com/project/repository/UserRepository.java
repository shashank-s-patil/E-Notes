package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.User;
import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer> {

	//Custom methods
	public boolean existsByEmail(String email);
	
	public User findByEmail(String email);
	
}
