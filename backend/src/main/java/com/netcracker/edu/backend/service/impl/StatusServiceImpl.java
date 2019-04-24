package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.StatusEntity;
import com.netcracker.edu.backend.repository.StatusRepository;
import com.netcracker.edu.backend.service.FindService;
import com.netcracker.edu.backend.service.IDefaultOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class StatusServiceImpl implements IDefaultOperationService<StatusEntity>, FindService<StatusEntity> {

    private StatusRepository repository;

    @Autowired
    public StatusServiceImpl(StatusRepository repository){
        this.repository = repository;
    }

    @Override
    public Iterable<StatusEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<StatusEntity> findById(Integer id) {
        return this.repository.findById(id);
    }

    @Override
    public StatusEntity save(StatusEntity status) {
        return this.repository.save(status);
    }

    @Override
    public void delete(Integer id) {}

    @Override
    public StatusEntity findByName(String name) {
        return this.repository.findByStatus(name);
    }
}
