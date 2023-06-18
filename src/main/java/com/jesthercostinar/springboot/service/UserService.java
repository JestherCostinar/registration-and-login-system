package com.jesthercostinar.springboot.service;

import com.jesthercostinar.springboot.dto.UserDto;
import com.jesthercostinar.springboot.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}
