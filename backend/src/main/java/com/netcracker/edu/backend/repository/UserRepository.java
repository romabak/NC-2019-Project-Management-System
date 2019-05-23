package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserEntity, Integer> {

    Optional<UserEntity> findByEmail(String email);

    @Query(value = "select * from user where user.role_id = (select id from role where role.role = :role)",
    nativeQuery = true)
    List<UserEntity> findAllByRole(@Param("role") String role);

    @Query(value = "select * from user where not user.role_id = (select id from role where role.role = :role)",
    nativeQuery = true)
    Page<UserEntity> findAllWithout(@Param("role") String role, Pageable page);

    @Query(value = "select * from user where not user.role_id = (select id from role where role.role = :role) " +
            "and" +
            ":str in (first_name, second_name, email) " +
            "or role_id = (select id from role where role = :str)", nativeQuery = true)
    Page<UserEntity> findAllByFilter(@Param("role") String role, @Param("str") String str, Pageable page);
}
