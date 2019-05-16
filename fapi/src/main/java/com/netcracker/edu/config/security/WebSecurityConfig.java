package com.netcracker.edu.config.security;

import com.netcracker.edu.security.JwtAuthenticationEntryPoint;
import com.netcracker.edu.security.JwtAuthenticationFilter;
import com.netcracker.edu.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import sun.security.util.Password;

import javax.annotation.Resource;


 @Configuration
 @EnableWebSecurity
 @EnableGlobalMethodSecurity(prePostEnabled = true)
 public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

     @Resource(name = "customUserDetailsService")
     private UserDetailsService userDetailsService;

     @Autowired
     private JwtAuthenticationEntryPoint unauthorizedHandler;

     @Autowired
     public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
         auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
     }

     @Override
     protected void configure(HttpSecurity http) throws Exception{
         http.cors().and().csrf().disable()
         .authorizeRequests()
//            .antMatchers("/api/task").hasAnyRole("PROJECT MANAGER","DEVELOPER", "TESTER")
//            .antMatchers("/api/user").hasAnyRole("ADMIN", "PROJECT MANAGER")
//            .antMatchers(HttpMethod.POST, "/api/task").hasRole("PROJECT MANAGER")
//            .antMatchers(HttpMethod.POST, "/api/project").hasRole("PROJECT MANAGER")
//            .antMatchers("/api/token/generate-token").permitAll()
                 .antMatchers("/**").permitAll()
                 .and()
                 .exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
                 .and()
                 .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

         http.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
     }

     @Bean
     public JwtAuthenticationFilter authenticationTokenFilterBean(){
         return new JwtAuthenticationFilter();
     }

     @Bean
     public BCryptPasswordEncoder encoder(){
         return new BCryptPasswordEncoder();
     }

     @Bean
     public AuthenticationManager authenticationManagerBean() throws Exception{
         return super.authenticationManagerBean();
     }


 }
