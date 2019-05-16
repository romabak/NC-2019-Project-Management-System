package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserService extends IDefaultOperationService<UserEntity> {
    Optional<UserEntity> findByEmail(String email);
    Page<UserEntity> findAllWithout(String role, Pageable page);
    List<UserEntity> findAllByRole(String role);
}
