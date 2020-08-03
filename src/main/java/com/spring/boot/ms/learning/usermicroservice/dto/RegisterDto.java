package com.spring.boot.ms.learning.usermicroservice.dto;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {
	private String emailId;
	@Length(min = 6)
	private String password;
	private String confirmPassword;
	private String firstName;
	private String lastName;
}