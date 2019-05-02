package com.netcracker.edu.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import sun.security.util.Password;

import javax.annotation.Resource;


 @Configuration
 @EnableWebSecurity
 @EnableGlobalMethodSecurity(prePostEnabled = true)
 public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

     @Override
     protected void configure(HttpSecurity http) throws Exception{
         http.authorizeRequests().
                 antMatchers("/api/**").permitAll().
                 anyRequest().authenticated();
     }

     @Override
     protected void configure(final AuthenticationManagerBuilder auth) throws Exception{
         auth.inMemoryAuthentication().withUser("admin").password(encoder().encode("12345")).roles("ADMIN");
     }

     @Bean
     public PasswordEncoder encoder(){
         return new BCryptPasswordEncoder();
     }

 }
