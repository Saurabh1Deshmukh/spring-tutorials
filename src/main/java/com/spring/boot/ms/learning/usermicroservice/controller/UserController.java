package com.spring.boot.ms.learning.usermicroservice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.ms.learning.usermicroservice.dto.RegisterDto;
import com.spring.boot.ms.learning.usermicroservice.dto.UserDetailDto;
import com.spring.boot.ms.learning.usermicroservice.dto.UserExceptionDto;
import com.spring.boot.ms.learning.usermicroservice.exception.UserConstraintException;
import com.spring.boot.ms.learning.usermicroservice.services.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/register")
	public ResponseEntity<UserDetailDto> register(@Valid @RequestBody RegisterDto registerDto,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new UserConstraintException("Invalid Registration data!!!");
		}
		UserDetailDto userDetailDto = this.userService.register(registerDto);
		ResponseEntity<UserDetailDto> response = new ResponseEntity<UserDetailDto>(userDetailDto, HttpStatus.OK);
		return response;
	}

	@GetMapping("/login")
	public ResponseEntity<String> login() {
		String message = "Welcome!";
		ResponseEntity<String> response = new ResponseEntity<String>(message, HttpStatus.OK);
		return response;
	}

	@ExceptionHandler(UserConstraintException.class)
	public ResponseEntity<UserExceptionDto> boundaryExceptionHanler(UserConstraintException ex) {
		UserExceptionDto userExceptionDto = new UserExceptionDto(ex.getMessage(), System.currentTimeMillis(),
				HttpStatus.BAD_REQUEST.value());
		ResponseEntity<UserExceptionDto> response = new ResponseEntity<UserExceptionDto>(userExceptionDto,
				HttpStatus.BAD_REQUEST);
		return response;
	}
}
