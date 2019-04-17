package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.RoleEntity;
import com.netcracker.edu.backend.repository.RoleRepository;
import com.netcracker.edu.backend.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RoleServiceImpl implements RoleService {

    private RoleRepository repository;

    @Autowired
    public RoleServiceImpl(RoleRepository repository){
        this.repository = repository;
    }

    @Override
    public RoleEntity saveUserRole(RoleEntity role) {
        return repository.save(role);
    }

    @Override
    public Iterable<RoleEntity> getAllUserRole() {
        return repository.findAll();
    }

    @Override
    public Optional<RoleEntity> getRoleById(Integer id){
        return repository.findById(id);
    }
}
