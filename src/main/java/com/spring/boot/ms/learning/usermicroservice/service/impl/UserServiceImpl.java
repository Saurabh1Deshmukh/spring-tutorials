package com.spring.boot.ms.learning.usermicroservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.ms.learning.usermicroservice.dto.RegisterDto;
import com.spring.boot.ms.learning.usermicroservice.dto.UserDetailDto;
import com.spring.boot.ms.learning.usermicroservice.entity.User;
import com.spring.boot.ms.learning.usermicroservice.repository.UserRepository;
import com.spring.boot.ms.learning.usermicroservice.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository repository) {
		this.userRepository = repository;
	}

	@Override
	public UserDetailDto register(RegisterDto registerDto) {
		// convert the DTO into entity
		// separate util package ( custom converter methods )
		// ModelMapper
		User user = new User(null, registerDto.getEmailId(), registerDto.getPassword(), registerDto.getFirstName(), registerDto.getLastName());
		// to use repository layer to persist in database
		user = this.userRepository.save(user);
		// convert the entity into DTO
		UserDetailDto userDetailDto = new UserDetailDto(user.getId(), user.getEmailId(), user.getFirstName(), user.getLastName());
		return userDetailDto;
	}

}