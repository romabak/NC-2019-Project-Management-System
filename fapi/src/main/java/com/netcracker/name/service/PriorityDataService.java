package com.netcracker.name.service;

import com.netcracker.name.models.PriorityViewModel;

import java.util.List;

public interface PriorityDataService {
    List<PriorityViewModel> getAll();
    PriorityViewModel getByPriority(String name);
}
