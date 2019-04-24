package com.netcracker.edu.backend.service;

public interface FindService<T> {
    T findByName(String name);
}
