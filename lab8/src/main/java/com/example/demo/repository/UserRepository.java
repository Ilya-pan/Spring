package com.example.demo.repository;


import com.example.demo.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional findByUsername(String username);  // Поиск по имени пользователя
    boolean existsByUsername(String username);

}