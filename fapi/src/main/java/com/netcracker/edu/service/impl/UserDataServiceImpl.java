package com.netcracker.edu.service.impl;

import com.netcracker.edu.models.DTOModels.PageUserDTOModel;
import com.netcracker.edu.models.UserDBModel;
import com.netcracker.edu.models.pageModels.PageUserDBModel;
import com.netcracker.edu.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service("customUserDetailsService")
public class UserDataServiceImpl implements UserDetailsService, UserDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDBModel saveNewUser(UserDBModel user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        System.out.println(user.toString());
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/user", user, UserDBModel.class).getBody();
    }

    @Override
    public List<UserDBModel> getAllUsers() {
        RestTemplate restTemplate = new RestTemplate();
        UserDBModel[] userDBModelsResponse = restTemplate.getForObject(backendServerUrl + "/api/user", UserDBModel[].class);
        return userDBModelsResponse == null ? Collections.emptyList() : Arrays.asList(userDBModelsResponse);
    }

    @Override
    public UserDBModel getByEmail(String email) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/user/" + email, UserDBModel.class);
    }

    @Override
    public PageUserDBModel getPageUserByFilter(int page, int size, String filter) {
        RestTemplate restTemplate = new RestTemplate();
        if(filter == null){
            return restTemplate.getForObject(backendServerUrl + "/api/user?page="+page+"&size="+size+"&role=admin", PageUserDBModel.class);
        } else {
            return restTemplate.getForObject(backendServerUrl + "/api/user?page="+page+"&size="+size+"&role=admin&filter="+filter, PageUserDBModel.class);
        }
    }

    @Override
    public List<UserDBModel> getOnlyDeveloper() {
        RestTemplate restTemplate = new RestTemplate();
        UserDBModel[] userDBModelsResponse = restTemplate.getForObject(backendServerUrl + "/api/user?role=developer", UserDBModel[].class);
        System.out.println(userDBModelsResponse);
        return userDBModelsResponse == null ? Collections.emptyList() : Arrays.asList(userDBModelsResponse);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDBModel user = getByEmail(email);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), getAuthority(user));
    }

    @Override
    public void delete(int id){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/user/" + id, UserDBModel.class);
    }

    private Set<SimpleGrantedAuthority> getAuthority(UserDBModel user){
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole().getRole().toUpperCase()));
        System.out.println(authorities);
        return authorities;
    }
}
