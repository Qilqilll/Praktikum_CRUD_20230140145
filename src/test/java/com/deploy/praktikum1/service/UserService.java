package com.deploy.praktikum1.service;

import com.deploy.praktikum1.model.dto.UserAddRequest;

public interface UserService {
    UserDto AddUser(UserAddRequest request);
    List<UserDto> getAllUser();
    UserDto getUserById(String id);
    UserDto UpdateUser(String id, UserAddRequest request);
    void DeleteUser(String id);
}