package com.netcracker.edu.service.impl;

import com.netcracker.edu.models.UserDBModel;
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

@Service("customUserDetailsService")
public class UserDataServiceImpl implements UserDetailsService, UserDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDBModel saveNewUser(UserDBModel user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        System.out.println("password = " + user.getPassword());
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
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDBModel user = getByEmail(email);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), getAuthority(user));
    }

    private Set<SimpleGrantedAuthority> getAuthority(UserDBModel user){
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
        return authorities;
    }
}
