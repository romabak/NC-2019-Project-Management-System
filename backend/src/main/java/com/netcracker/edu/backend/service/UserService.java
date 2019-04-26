package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.UserEntity;

import java.util.Optional;

public interface UserService extends IDefaultOperationService<UserEntity> {
    Optional<UserEntity> findByEmail(String email);
}
