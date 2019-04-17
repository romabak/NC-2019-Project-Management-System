package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.StatusEntity;

public interface StatusService {

    Iterable<StatusEntity> getAllTaskStatus();

}
