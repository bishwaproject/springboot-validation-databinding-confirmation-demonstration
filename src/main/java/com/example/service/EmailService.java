package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
//Service class for sending registration confirmation emails.
@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;
    
    // Sends a registration confirmation email to the specified user email address.
    
    public void sendRegistrationConfirmationEmail(String userEmail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(userEmail);
        message.setSubject("Registration Confirmation");
        message.setText("Dear User,\n\nYour registration was successful!\n\nBest regards,\nYour Application Team");

        emailSender.send(message);
    }
}
