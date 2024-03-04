package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dto.User;

//Repository interface for managing User entities.
public interface UserRepository extends JpaRepository<User, Long>{

}
