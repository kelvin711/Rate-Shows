package com.kelvinarauz.exam.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kelvinarauz.exam.models.User;
import com.kelvinarauz.exam.repositories.UserRepository;



@Service
public class UserService {

	@Autowired
	private UserRepository uRepo;
	
	//FIND USER BY ID
	public User findUserById(Long id) {
		User user = this.uRepo.findById(id).orElse(null);
		return user;
	}
	//FIND ALL USERS
	public List<User> findAllUsers(){
		return (List<User>) this.uRepo.findAll();
	}
	//FIND USER BY EMAIL
	public User findByEmail(String email) {
		User user = this.uRepo.findByEmail(email);
		return user;
	}
	//UPDATE USER
	public void updateUser(User attendee) {
		uRepo.save(attendee);
	}
	//REGISTER USER
	public User registerUser(User user) {
		// Generate a Hash
		String hash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		
		// Set the hashed password on the users password field
		user.setPassword(hash);
		
		// Save the new user and the updated password to the database
		return this.uRepo.save(user);
	}
	//AUTHENTICATE USER
	public boolean authenticateUser(String email, String password) {
		// Make sure the user logging in is who they say they are
		// Try and query for user by email
		User user = this.uRepo.findByEmail(email);
		
		if (user == null) {
			return false;
		}
		
		// If we have reached this point, check the password against the password for this email in our database
		return BCrypt.checkpw(password, user.getPassword());
	}
	//FIND BY EMAIL
	public User getByEmail(String email) {
		return uRepo.findByEmail(email);
	}
}
