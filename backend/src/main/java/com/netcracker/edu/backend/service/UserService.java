package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.UserEntity;

import java.util.Optional;

public interface UserService {
    Iterable<UserEntity> findAllUsers();
    UserEntity saveUser(UserEntity user);
    Optional<UserEntity> findUserById(Integer id);
    void deleteById(Integer id);
}
