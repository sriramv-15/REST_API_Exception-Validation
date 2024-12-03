package com.validation.exception.springboot.Exception.Validation.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.validation.exception.springboot.Exception.Validation.BusinessExp.UserNotFoundException;
import com.validation.exception.springboot.Exception.Validation.Dto.UserRequest;
import com.validation.exception.springboot.Exception.Validation.Entity.User;
import com.validation.exception.springboot.Exception.Validation.Service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/signup")
	public ResponseEntity<User> addUser(@RequestBody @Valid UserRequest userRequest){
		//System.out.println("Received UserRequest: " + userRequest);
		return new ResponseEntity<>(userService.saveUser(userRequest), HttpStatus.CREATED);
	}
	
	@GetMapping("/fetchAll")
	public ResponseEntity<List<User>> fetchAllUsers(){
		return ResponseEntity.ok(userService.getAllUsers());
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> fetchUserById(@PathVariable int userId) throws UserNotFoundException{
		return ResponseEntity.ok(userService.getUserById(userId));
	}
	
	
}
