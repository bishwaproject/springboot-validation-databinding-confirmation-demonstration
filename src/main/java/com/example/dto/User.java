package com.example.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "First name is required")
	private String firstName;
	
	@NotBlank(message = "Last name is required")
	private String lastName;
	
	@Email(message = "Invalid email format")
	@NotBlank(message = "Email is required")
	private String email;

	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Long id, @NotBlank(message = "First name is required") String firstName,
			@NotBlank(message = "Last name is required") String lastName,
			@Email(message = "Invalid email format") @NotBlank(message = "Email is required") String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	
	

}
