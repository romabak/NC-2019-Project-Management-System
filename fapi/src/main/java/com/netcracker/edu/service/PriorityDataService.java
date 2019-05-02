package com.netcracker.edu.service;

import com.netcracker.edu.models.PriorityViewModel;

import java.util.List;

public interface PriorityDataService {
    List<PriorityViewModel> getAll();
    PriorityViewModel getByPriority(String name);
}
