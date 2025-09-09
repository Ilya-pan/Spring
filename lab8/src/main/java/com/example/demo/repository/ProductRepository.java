package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Здесь можно добавить дополнительные методы, если потребуется
}
