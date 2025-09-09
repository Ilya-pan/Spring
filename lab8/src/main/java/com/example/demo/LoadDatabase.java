package com.example.demo;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(ProductRepository repository) {
        return args -> {
            repository.save(new Product("Натуральный йогурт", "Свежий йогурт без добавок.", 150));
            repository.save(new Product("Сыр Гауда", "Выдержанный сыр из натурального молока.", 450));
            repository.save(new Product("Молоко", "Свежайшее молоко с фермы.", 90));
            repository.save(new Product("Сливочное масло", "Натуральное масло высшего сорта.", 200));
        };
    }
}