package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.UserEntity;
import com.netcracker.edu.backend.repository.UserRepository;
import com.netcracker.edu.backend.service.FindService;
import com.netcracker.edu.backend.service.IDefaultOperationService;
import com.netcracker.edu.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {

    private UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository){
        this.repository = repository;
    }

    @Override
    public Iterable<UserEntity> findAll() {
        return this.repository.findAll();
    }

    @Override
    public UserEntity save(UserEntity user) {
        return this.repository.save(user);
    }

    @Override
    public Optional<UserEntity> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        this.repository.deleteById(id);
    }

    @Override
    public Optional<UserEntity> findByEmail(String name) {
        return this.repository.findByEmail(name);
    }

    @Override
    public Page<UserEntity> findAllWithout(String role, Pageable page) {
        return this.repository.findAllWithout(role, page);
    }

    @Override
    public List<UserEntity> findAllByRole(String role) {
        return this.repository.findAllByRole(role);
    }
}
