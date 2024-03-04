package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.User;
import com.example.repository.UserRepository;
import com.example.service.EmailService;
import com.example.service.UserService;
//Service implementation for managing user-related operations.

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
    private EmailService emailService;
	@Override
	public void registerUser(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);

        // Send registration confirmation email
        emailService.sendRegistrationConfirmationEmail(user.getEmail());
		
	}
	

}
