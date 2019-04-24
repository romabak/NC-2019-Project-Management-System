package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.UserEntity;
import com.netcracker.edu.backend.repository.UserRepository;
import com.netcracker.edu.backend.service.FindService;
import com.netcracker.edu.backend.service.IDefaultOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserServiceImpl implements IDefaultOperationService<UserEntity>, FindService<UserEntity> {

    @Autowired
    private UserRepository repository;

    @Override
    public Iterable<UserEntity> findAll() {
        return this.repository.findAll();
    }

    @Override
    public UserEntity save(UserEntity user) {
        return repository.save(user);
    }

    @Override
    public Optional<UserEntity> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public UserEntity findByName(String name) {
        return this.repository.findByEmail(name);
    }
}
