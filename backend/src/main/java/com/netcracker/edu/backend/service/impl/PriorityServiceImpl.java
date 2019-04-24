package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.PriorityEntity;
import com.netcracker.edu.backend.entity.ProjectEntity;
import com.netcracker.edu.backend.repository.PriorityRepository;
import com.netcracker.edu.backend.service.FindService;
import com.netcracker.edu.backend.service.IDefaultOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PriorityServiceImpl implements IDefaultOperationService<PriorityEntity>, FindService<PriorityEntity> {

    private PriorityRepository repository;

    @Autowired
    public PriorityServiceImpl(PriorityRepository repository){
        this.repository = repository;
    }

    @Override
    public Iterable<PriorityEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<PriorityEntity> findById(Integer id){
        return this.repository.findById(id);
    }

    @Override
    public PriorityEntity save(PriorityEntity project){
        return this.repository.save(project);
    }

    @Override
    public void delete(Integer id){};

    @Override
    public PriorityEntity findByName(String name) {
        return this.repository.findByPriority(name);
    }
}
