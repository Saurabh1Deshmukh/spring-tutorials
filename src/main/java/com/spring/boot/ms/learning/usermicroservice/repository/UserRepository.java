package com.spring.boot.ms.learning.usermicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.boot.ms.learning.usermicroservice.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
