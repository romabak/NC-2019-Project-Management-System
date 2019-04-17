package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.PriorityEntity;
import com.netcracker.edu.backend.repository.PriorityRepository;
import com.netcracker.edu.backend.service.PriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PriorityServiceImpl implements PriorityService {

    private PriorityRepository repository;

    @Autowired
    public PriorityServiceImpl(PriorityRepository repository){
        this.repository = repository;
    }
    @Override
    public Iterable<PriorityEntity> getAllTaskPriority() {
        return repository.findAll();
    }
}
