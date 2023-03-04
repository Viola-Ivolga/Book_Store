package com.bookStore.service;

import com.bookStore.dto.UserRegistrationDto;
import com.bookStore.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface UserService extends UserDetailsService{
    User save(UserRegistrationDto registrationDto);
    List<User> getAllUsers();
    User getById(Long id);
}
