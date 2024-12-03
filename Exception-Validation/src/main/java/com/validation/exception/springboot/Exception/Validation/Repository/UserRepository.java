package com.validation.exception.springboot.Exception.Validation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.validation.exception.springboot.Exception.Validation.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUserId(int userId);

}
