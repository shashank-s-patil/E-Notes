package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.project.entity.User;
import com.project.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public User saveUser(User user) {
		user.setRole("ROLE_USER");
		
		//To store the password in encrypted format in database
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		User newUser = userRepo.save(user);
		return newUser;
	}

	@Override
	public boolean existEmailCheck(String email) {
		
		return userRepo.existsByEmail(email);
	}
	
	public void removeSessionMessage() {
		HttpSession session = ((ServletRequestAttributes)(RequestContextHolder.getRequestAttributes())).getRequest().getSession();
		session.removeAttribute("msg");
	}

	
	
	
}
