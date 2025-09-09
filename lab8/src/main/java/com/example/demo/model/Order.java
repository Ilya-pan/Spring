package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")  // Указываем новое имя таблицы
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;  // Идентификатор заказа
    private String name;  // Имя клиента
    private String email;  // Email клиента
    private String product;  // Название продукта
    private int quantity;  // Количество товара

    // Конструктор по умолчанию
    public Order() {}

    // Конструктор с параметрами
    public Order(String name, String email, String product, int quantity) {
        this.name = name;
        this.email = email;
        this.product = product;
        this.quantity = quantity;
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}