package com.example.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collections;

import com.example.dto.User;
import com.example.service.UserService;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @Mock
    private BindingResult bindingResult;

    @Test
    public void testRegisterUser_SuccessfulRegistration() {
        User user = new User(); // Create a valid User object
        Mockito.when(bindingResult.hasErrors()).thenReturn(false);
        
        ResponseEntity<String> response = userController.registerUser(user, bindingResult);

        Mockito.verify(userService, Mockito.times(1)).registerUser(user);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("User registered successfully!", response.getBody());
    } 

    @Test
    public void testRegisterUser_ValidationErrors() {
        User user = new User(); // Create a User object with validation errors
        Mockito.when(bindingResult.hasErrors()).thenReturn(true);
        Mockito.when(bindingResult.getAllErrors()).thenReturn(Collections.singletonList(new ObjectError("user", "Validation error")));

        ResponseEntity<String> response = userController.registerUser(user, bindingResult);

        Mockito.verify(userService, Mockito.never()).registerUser(user);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertTrue(response.getBody().contains("Validation errors"));}

    @Test
    public void testRegisterUser_UnexpectedError() {
        User user = new User(); // Create a valid User object
        Mockito.when(bindingResult.hasErrors()).thenReturn(false);
        Mockito.doThrow(new RuntimeException("Unexpected error")).when(userService).registerUser(user);

        ResponseEntity<String> response = userController.registerUser(user, bindingResult);

        Mockito.verify(userService, Mockito.times(1)).registerUser(user);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertTrue(response.getBody().contains("An unexpected error occurred"));
     }
}
