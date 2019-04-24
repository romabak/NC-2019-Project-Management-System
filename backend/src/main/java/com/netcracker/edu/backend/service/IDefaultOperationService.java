package com.netcracker.edu.backend.service;

import java.util.Optional;

public interface IDefaultOperationService<T> {
    Iterable<T> findAll();
    Optional<T> findById(Integer id);
    T save(T obj);
    void delete(Integer id);

}
