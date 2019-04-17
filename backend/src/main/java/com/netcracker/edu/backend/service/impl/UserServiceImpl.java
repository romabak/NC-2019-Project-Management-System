package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.UserEntity;
import com.netcracker.edu.backend.repository.UserRepository;
import com.netcracker.edu.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public Iterable<UserEntity> findAllUsers() {
        return this.repository.findAll();
    }

    @Override
    public UserEntity saveUser(UserEntity user) {
        return repository.save(user);
    }

    @Override
    public Optional<UserEntity> findUserById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
