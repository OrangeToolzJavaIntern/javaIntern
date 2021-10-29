package com.khan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khan.model.User;


public interface UserRepository extends JpaRepository<User, Long>{

}
