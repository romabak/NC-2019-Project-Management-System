package com.netcracker.edu.service;

import com.netcracker.edu.models.StatusViewModel;

import java.util.List;

public interface StatusDataService {

    List<StatusViewModel> getAll();
    StatusViewModel getByStatus(String name);
}
