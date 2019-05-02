package com.netcracker.edu.service;

import com.netcracker.edu.models.RoleViewModel;

import java.util.List;

public interface RoleDataService {
    List<RoleViewModel> getAll();
    RoleViewModel getByRole(String role);
}