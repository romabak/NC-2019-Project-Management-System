package com.netcracker.edu.service.impl;

import com.netcracker.edu.models.RoleViewModel;
import com.netcracker.edu.service.RoleDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class RoleDataServiceImpl implements RoleDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<RoleViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        RoleViewModel[] roleViewModelResponse = restTemplate.getForObject(backendServerUrl + "/api/role",
                RoleViewModel[].class);
        return roleViewModelResponse == null ? Collections.emptyList() : Arrays.asList(roleViewModelResponse);
    }

    @Override
    public RoleViewModel getByRole(String role) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/role/" + role, RoleViewModel.class);
    }
}
