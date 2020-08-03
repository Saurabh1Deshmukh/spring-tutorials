package com.spring.boot.ms.learning.usermicroservice.services;

import com.spring.boot.ms.learning.usermicroservice.dto.RegisterDto;
import com.spring.boot.ms.learning.usermicroservice.dto.UserDetailDto;

public interface UserService {
	public UserDetailDto register(RegisterDto registerDto);
}