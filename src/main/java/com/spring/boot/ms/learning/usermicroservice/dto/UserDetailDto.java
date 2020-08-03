package com.spring.boot.ms.learning.usermicroservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailDto {
	private String id;
	private String emailId;
	private String firstName;
	private String lastName;
}