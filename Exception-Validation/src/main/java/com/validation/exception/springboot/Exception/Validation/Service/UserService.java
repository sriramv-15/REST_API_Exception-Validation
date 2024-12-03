package com.validation.exception.springboot.Exception.Validation.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.validation.exception.springboot.Exception.Validation.BusinessExp.UserNotFoundException;
import com.validation.exception.springboot.Exception.Validation.Dto.UserRequest;
import com.validation.exception.springboot.Exception.Validation.Entity.User;
import com.validation.exception.springboot.Exception.Validation.Repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User saveUser(UserRequest userRequest) {
		User user = new User(0, userRequest.getName(), userRequest.getEmail(), 
				userRequest.getMobile(), userRequest.getGender(), userRequest.getAge(),
				userRequest.getNationality());
		
		
		
		return userRepository.save(user);
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public User getUserById(int userId) throws UserNotFoundException{
		User user = userRepository.findByUserId(userId);
		if(user != null) {
			return user;
		}else {
			throw new UserNotFoundException("user not found with id " + userId);
		}
	}
	
	
}
