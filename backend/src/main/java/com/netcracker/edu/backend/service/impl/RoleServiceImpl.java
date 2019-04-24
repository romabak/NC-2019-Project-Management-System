package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.RoleEntity;
import com.netcracker.edu.backend.repository.RoleRepository;
import com.netcracker.edu.backend.service.FindService;
import com.netcracker.edu.backend.service.IDefaultOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RoleServiceImpl implements IDefaultOperationService<RoleEntity>, FindService<RoleEntity> {

    private RoleRepository repository;

    @Autowired
    public RoleServiceImpl(RoleRepository repository){
        this.repository = repository;
    }

    @Override
    public RoleEntity save(RoleEntity role) {
        return repository.save(role);
    }

    @Override
    public Iterable<RoleEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<RoleEntity> findById(Integer id){
        return repository.findById(id);
    }

    @Override
    public void delete(Integer id){}

    @Override
    public RoleEntity findByName(String name) {
        return this.repository.findByRole(name);
    }
}
