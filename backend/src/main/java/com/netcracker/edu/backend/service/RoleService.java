package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.RoleEntity;

import java.util.Optional;

public interface RoleService {

    RoleEntity saveUserRole(RoleEntity role);
    Iterable<RoleEntity> getAllUserRole();
    Optional<RoleEntity> getRoleById(Integer id);
}
