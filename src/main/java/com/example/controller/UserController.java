package com.example.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.User;
import com.example.service.UserService;

import jakarta.validation.Valid;

//Controller class for handling user-related API requests.
@RestController
@RequestMapping("/api/users")
public class UserController {
 
 private static final Logger logger = LoggerFactory.getLogger(UserController.class);

 @Autowired
 private UserService userService;
 
 // Endpoint for registering a new user.
 @PostMapping("/register")
 public ResponseEntity<String> registerUser(@Valid @RequestBody User user, BindingResult bindingResult ){
     if(bindingResult.hasErrors()) {
         List<String> errors = bindingResult.getAllErrors().stream()
                 .map(ObjectError::getDefaultMessage)
                 .collect(Collectors.toList());
         return ResponseEntity.badRequest().body("Validation errors: " + errors);
     }
     try {
         userService.registerUser(user);
         return ResponseEntity.ok("User registered successfully!");
     } catch (Exception e) {
         logger.error("Error registering user", e);
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred. Please contact support.");
     }
 }
}
